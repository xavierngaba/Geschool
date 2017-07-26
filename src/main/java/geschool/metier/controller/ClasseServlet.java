/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.metier.utils.AllUrl;
import geschool.metier.utils.ClasseValidationForm;
import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.interfaces.SessionClasseDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Classe;
import static geschool.persistence.model.Classe_.idClasse;
import geschool.persistence.model.Sessionclasse;
import geschool.persistence.model.Utilisateur;
import java.io.IOException;
import java.util.Date;
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
 * @author xavier_ng
 */
public class ClasseServlet extends HttpServlet {
    @EJB
    private ClasseDAO cDAO;
    @EJB
    private SessionClasseDAO sessClasseDAO;
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
        if(action.equals("listeclasse")){
            session.setAttribute( ATT_SESSION_USER, u );
            List<Classe> listClasse = cDAO.rechercherToutesLesClasses();
            request.setAttribute("listeclasse", listClasse); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_CLASSE ).forward( request, response );
        }
        if(action.equals("classeSession")){
            session.setAttribute( ATT_SESSION_USER, u );
            String sessionClasseId = request.getParameter("sessionClasse");
            List<Sessionclasse> listSessionClasse = sessClasseDAO.rechercherLesClassesParSession(sessionClasseId);
            request.setAttribute("Sessionclasse", listSessionClasse); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_CLASSE_SESSION ).forward( request, response );
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
        if(action.equals("ajoutclasse")){
       try {
                ClasseValidationForm form = new ClasseValidationForm(cDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.ajoutClasse(request);
                request.setAttribute( ATT_FORM, form );
                 if ( form.getErreurs().isEmpty() ) {
                     session.setAttribute( ATT_SESSION_USER, u );
                     request.setAttribute(MESSAGE, "success");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_CLASSE ).forward( request, response );
                 }else{
                     request.setAttribute(MESSAGE, "error");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_CLASSE ).forward( request, response );
                 }
            } catch (Exception ex) {
                Logger.getLogger(ClasseServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//////       
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
