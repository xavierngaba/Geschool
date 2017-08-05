package geschool.metier.controller;

import geschool.metier.utils.AllUrl;
import geschool.persistence.interfaces.SessionDAO;

import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.FactureDAO;

import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Classe;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Utilisateur;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AutoServlet extends HttpServlet {

    @EJB
    private UtilisateurDAO uDAO;
    @EJB
    private SessionDAO sDAO;
    @EJB
    private ClasseDAO cDAO;
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        List<Classe> listClasse = cDAO.rechercherToutesLesClasses();
        if(listClasse != null){
           request.setAttribute("nblistclasse", listClasse.size()); 
        }else{
           request.setAttribute("nblistclasse", 0); 
        }
        
        int sessionId = Integer.parseInt(request.getParameter("session"));
        if (session.getMaxInactiveInterval() != 2 && session != null) {
            Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
            session.setAttribute(ATT_SESSION_USER, u);

            if (action.equals("home")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_ACCUEIL).forward(request, response);
            }
            if (action.equals("listesession")) {
                request.setAttribute("action", "listesession");
                this.getServletContext().getRequestDispatcher("/SessionServlet").forward(request, response);
            }
            if (action.equals("listeclasse")) {
                request.setAttribute("action", "listeclasse");
                this.getServletContext().getRequestDispatcher("/ClasseServlet").forward(request, response);
            }
            if (action.equals("classeSession")) {
                request.setAttribute("action", "classeSession");
                Date dateActuel = new Date();
                request.setAttribute("sessionClasse", sDAO.chercherSessionEnCours(dateActuel));
                this.getServletContext().getRequestDispatcher("/ClasseServlet").forward(request, response);
            }
            if (action.equals("ajoutsession")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_SESSION_ACADEMIQUE).forward(request, response);
            }
            if (action.equals("ajoutclasse")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_CLASSE).forward(request, response);
            }
            if (action.equals("ajoutfacture")) {
                request.setAttribute("action", "ajoutfacture");
                this.getServletContext().getRequestDispatcher("/FactureServlet").forward(request, response);
            }
            if (action.equals("listefacture")) {
                request.setAttribute("action", "listefacture");
                this.getServletContext().getRequestDispatcher("/FactureServlet").forward(request, response);
            }
            if (action.equals("modifclasse")) {
                String idclasse = request.getParameter("idclasse");
                request.setAttribute("action", "modifclasse");
                request.setAttribute("idclasse", idclasse);
                this.getServletContext().getRequestDispatcher("/ClasseServlet").forward(request, response);
            }
            if (action.equals("ajoutsessionclasse")) {
                Date dateActuel = new Date();
                request.setAttribute("sessionClasse", sDAO.chercherSessionEnCours(dateActuel));
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_SESSION_CLASSE).forward(request, response);
            }
        } else {
            request.setAttribute("action", "unlock");
            request.setAttribute(ATT_SESSION_USER, session);
            this.getServletContext().getRequestDispatcher("/UtilisateurServlet").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        int sessionId = Integer.parseInt(request.getParameter("session"));
        if (session.getMaxInactiveInterval() != 2 && session != null) {
            Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
            session.setAttribute(ATT_SESSION_USER, u);
            if (action.equals("ajoutclasse")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_CLASSE).forward(request, response);
            }
        } else {
            request.setAttribute("action", "unlock");
            request.setAttribute(ATT_SESSION_USER, session);
            this.getServletContext().getRequestDispatcher("/UtilisateurServlet").forward(request, response);
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
