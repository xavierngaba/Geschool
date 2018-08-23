/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.metier.utils.AllUrl;

import geschool.metier.utils.EvaluationValidationForm;
import geschool.persistence.interfaces.EvaluationDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Evaluation;
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
public class EvaluationServlet extends HttpServlet {
    @EJB
    private EvaluationDAO cDAO;
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
        if(action.equals("listeevaluation")){
            session.setAttribute( ATT_SESSION_USER, u );
            List<Evaluation> listEvaluation = cDAO.rechercherToutesLesEvaluation();
            request.setAttribute("listeevaluation", listEvaluation); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_EVALUATION ).forward( request, response );
        }
        
        if(action.equals("modifevaluation")){
            session.setAttribute( ATT_SESSION_USER, u );
            String idevaluation = request.getParameter("idevaluation");
            Evaluation c = cDAO.rechercherEvaluationParId(Integer.parseInt(idevaluation));
            request.setAttribute("evaluation", c); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_MODIF_EVALUATION ).forward( request, response );
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
        if(action.equals("ajoutevaluation")){
            try {
                EvaluationValidationForm form = new EvaluationValidationForm(cDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.ajoutEvaluation(request);
                request.setAttribute( ATT_FORM, form );
                 if ( form.getErreurs().isEmpty() ) {
                     session.setAttribute( ATT_SESSION_USER, u );
                     request.setAttribute(MESSAGE, "success");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_EVALUATION ).forward( request, response );
                 }else{
                     request.setAttribute(MESSAGE, "error");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_EVALUATION ).forward( request, response );
                 }
            } catch (Exception ex) {
                Logger.getLogger(EvaluationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(action.equals("modifevaluation")){
            try {
                EvaluationValidationForm form = new EvaluationValidationForm(cDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.modifEvaluation(request);
                request.setAttribute( ATT_FORM, form );
                 if ( form.getErreurs().isEmpty() ) {
                     session.setAttribute( ATT_SESSION_USER, u );
                     request.setAttribute(MESSAGE, "success");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_EVALUATION ).forward( request, response );
                 }else{
                     request.setAttribute(MESSAGE, "error");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_EVALUATION ).forward( request, response );
                 }
            } catch (Exception ex) {
                Logger.getLogger(EvaluationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
