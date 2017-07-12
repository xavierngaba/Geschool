/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.metier.utils.AllUrl;
import geschool.metier.utils.SessionValidationForm;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Session;
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
public class SessionServlet extends HttpServlet {
    @EJB
    private SessionDAO sDAO;
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
        if(action.equals("listesession")){
            session.setAttribute( ATT_SESSION_USER, u );
            List<Session> listSession = sDAO.chercherToutesLesSessions();
            request.setAttribute("listesession", listSession); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response );
        }
        if(action.equals("active")){
            Date now = new Date();
            String idSession = request.getParameter("date");
            Session s = sDAO.chercherSession(idSession);
            List<Session> listSession = sDAO.chercherToutesLesSessions();
            request.setAttribute("listesession", listSession);
            session.setAttribute( ATT_SESSION_USER, u );
            if(s.getDateDebut().compareTo(now) < 0 && now.compareTo(s.getDateFin()) < 0){
                for (Session ses : listSession) {
                    if(ses.getActif() == 1){
                        request.setAttribute(MESSAGE, "warning");
                        request.setAttribute("text", "Une session est déjà en cours attendez la fin de la session en cours.");
                        this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response );
                    }else{
                        s.setActif(1);
                        sDAO.modifSession(s);
                        request.setAttribute(MESSAGE, "success");
                        request.setAttribute("text", "La session a été bien activée.");
                        this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response );
                    }
                }
                //cette condition faut la modifier c'est à cause d'elle qu'il y a le bug
            }else if(s.getDateFin().compareTo(now) < 0 && now.getMonth() == 6){
                s.setActif(1);
                sDAO.modifSession(s);
                request.setAttribute(MESSAGE, "success");
                request.setAttribute("text", "La session a été bien activée.");
                this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response );
            }else{
                request.setAttribute(MESSAGE, "warning");
                request.setAttribute("text", "Impossible d'avtiver cette section");
                this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response );
            }  
        }
        if(action.equals("desactive")){
            Date now = new Date();
            String idSession = request.getParameter("date");
            Session s = sDAO.chercherSession(idSession);
            List<Session> listSession = sDAO.chercherToutesLesSessions();
            request.setAttribute("listesession", listSession);
            session.setAttribute( ATT_SESSION_USER, u );
            if(s.getDateDebut().compareTo(now) < 0 && now.compareTo(s.getDateFin()) < 0){
                request.setAttribute(MESSAGE, "warning");
                request.setAttribute("text", "Une session est déjà en cours attendez la fin de la session en cours pour desactiver cette section.");
                this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response );
            }else if(s.getDateFin().compareTo(now) < 0 && now.getMonth() == 6){
                s.setActif(0);
                sDAO.modifSession(s);
                request.setAttribute(MESSAGE, "success");
                request.setAttribute("text", "Cette session a été désactivée avec succès");
                this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response );
            }else{
               request.setAttribute(MESSAGE, "warning");
               request.setAttribute("text", "impossible de désactiver cette session");
               this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_SESSION ).forward( request, response ); 
            } 
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
        if(action.equals("ajoutsession")){
            try {
                SessionValidationForm form = new SessionValidationForm(sDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.ajoutSession(request);
                request.setAttribute( ATT_FORM, form );
                 if ( form.getErreurs().isEmpty() ) {
                     session.setAttribute( ATT_SESSION_USER, u );
                     request.setAttribute(MESSAGE, "success");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_SESSION_ACADEMIQUE ).forward( request, response );
                 }else{
                     request.setAttribute(MESSAGE, "error");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_SESSION_ACADEMIQUE ).forward( request, response );
                 }
            } catch (Exception ex) {
                Logger.getLogger(SessionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(action.equals("activesession")){
            Date dateNow = new Date();
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
