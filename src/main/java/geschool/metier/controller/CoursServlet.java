/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.metier.utils.AllUrl;

import geschool.metier.utils.CoursValidationForm;
import geschool.persistence.interfaces.CoursDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Cours;
import geschool.persistence.model.Utilisateur;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ines.G
 */
public class CoursServlet extends HttpServlet {
    @EJB
    private CoursDAO cDAO;
    @EJB
    private UtilisateurDAO uDAO;
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_FORM = "form";
    public static final String MESSAGE = "message";
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int sessionId = Integer.parseInt(request.getParameter("session"));
        Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if(action.equals("listecours")){
            session.setAttribute( ATT_SESSION_USER, u );
            List<Cours> listCours = cDAO.findAll();
            request.setAttribute("listecours", listCours); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_COURS ).forward( request, response );
        }
        
        if(action.equals("modifcours")){
            session.setAttribute( ATT_SESSION_USER, u );
            String idcours = request.getParameter("idcours");
            Cours c = cDAO.findByIdCours(Integer.parseInt(idcours));
            request.setAttribute("cours", c); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_MODIF_COURS ).forward( request, response );
        }
    }     


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String action = request.getParameter("action");
        int sessionId = Integer.parseInt(request.getParameter("session"));
        HttpSession session = request.getSession();
        if(action.equals("ajoutcours")){
            try {
                CoursValidationForm form = new CoursValidationForm(cDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.ajoutCours(request);
                request.setAttribute( ATT_FORM, form );
                 if ( form.getErreurs().isEmpty() ) {
                     session.setAttribute( ATT_SESSION_USER, u );
                     request.setAttribute(MESSAGE, "success");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_COURS ).forward( request, response );
                 }else{
                     request.setAttribute(MESSAGE, "error");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_COURS ).forward( request, response );
                 }
            } catch (Exception ex) {
                Logger.getLogger(CoursServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(action.equals("modifcours")){
            try {
                CoursValidationForm form = new CoursValidationForm(cDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.modifCours(request);
                request.setAttribute( ATT_FORM, form );
                 if ( form.getErreurs().isEmpty() ) {
                     session.setAttribute( ATT_SESSION_USER, u );
                     request.setAttribute(MESSAGE, "success");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_COURS ).forward( request, response );
                 }else{
                     request.setAttribute(MESSAGE, "error");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_COURS ).forward( request, response );
                 }
            } catch (Exception ex) {
                Logger.getLogger(CoursServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("******************Pas de recup à l'action...");
        }

            
       }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
    return "Short description";
    }// </editor-fold>
}
