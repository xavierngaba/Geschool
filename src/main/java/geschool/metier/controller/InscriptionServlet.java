/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.metier.utils.AllUrl;
import geschool.metier.utils.EleveTuteurValidationForm;
import geschool.metier.utils.InscriptionValidationForm;
import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.InscritDAO;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.interfaces.TuteurDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Inscrit;
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
public class InscriptionServlet extends HttpServlet {

    @EJB
    private EleveDAO eDAO;
    @EJB
    private TuteurDAO tDAO;
    @EJB
    private InscritDAO iDAO;
    @EJB
    private UtilisateurDAO uDAO;
    @EJB
    private ClasseDAO cDAO;
    @EJB
    private SessionDAO sDAO;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sessionId = Integer.parseInt(request.getParameter("session"));
        Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if (action.equals("listeleve")) {
            session.setAttribute(ATT_SESSION_USER, u);
            List<Eleve> listeleve = eDAO.rechercherTousLesEleves();
            request.setAttribute("listeleve", listeleve);
            this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_TABLEAU_ELEVE).forward(request, response);
        }
        if (action.equals("modifeleve")) {
            String ideleve = request.getParameter("ideleve");
            request.setAttribute("eleve", eDAO.rechercherUnEleveAvecId(Integer.parseInt(ideleve)));
            this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_ELEVE).forward(request, response);
        }
        if (action.equals("modifinscription")) {
            String idInscrit = request.getParameter("idInscrit");
            request.setAttribute("inscrit", iDAO.rechercherInscritAvecId(Integer.parseInt(idInscrit)));
            //Envoie de la liste de toutes les classes disponibles en BDD
            request.setAttribute("listeleve", eDAO.rechercherTousLesEleves());
            //Envoie de la liste de tous les élèves enregistrés en BDD
            request.setAttribute("listclasse", cDAO.rechercherToutesLesClasses());
            request.setAttribute("Annee", sDAO.chercherSessionEnCours());
            this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_INSCRIPTION).forward(request, response);
        }
        if (action.equals("listinscription")) {
            session.setAttribute(ATT_SESSION_USER, u);
            List<Inscrit> listinscrit = iDAO.rechercherToutesLesInscriptions();
            request.setAttribute("listinscrit", listinscrit);
            this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_TABLEAU_INSCRIPTION).forward(request, response);
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
        String action = request.getParameter("action");
        int sessionId = Integer.parseInt(request.getParameter("session"));
        HttpSession session = request.getSession();
        if (action.equals("ajouteleve")) {
            try {
                EleveTuteurValidationForm form = new EleveTuteurValidationForm(eDAO, tDAO,sDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.ajouterEleveTuteur(request);
                request.setAttribute(ATT_FORM, form);
                if (form.getErreurs().isEmpty()) {
                    session.setAttribute(ATT_SESSION_USER, u);
                    request.setAttribute(MESSAGE, "success");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_ELEVE).forward(request, response);
                } else {
                    request.setAttribute(MESSAGE, "error");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_ELEVE).forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(SessionServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute(MESSAGE, "error");
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_ELEVE).forward(request, response);
            }
        }
        if (action.equals("ajoutinscription")) {
            try {
                InscriptionValidationForm form = new InscriptionValidationForm(eDAO, cDAO, sDAO, iDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.ajouterInscription(request);
                request.setAttribute(ATT_FORM, form);
                if (form.getErreurs().isEmpty()) {
                    session.setAttribute(ATT_SESSION_USER, u);
                    request.setAttribute(MESSAGE, "success");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_INSCRIPTION).forward(request, response);
                } else {
                    request.setAttribute(MESSAGE, "error");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_INSCRIPTION).forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(SessionServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute(MESSAGE, "error");
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_INSCRIPTION).forward(request, response);
            }
        }
        if (action.equals("modifeleve")) {
            try {
                EleveTuteurValidationForm form = new EleveTuteurValidationForm(eDAO,tDAO,sDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.modiferEleveTuteur(request);
                request.setAttribute(ATT_FORM, form);
                if (form.getErreurs().isEmpty()) {
                    session.setAttribute(ATT_SESSION_USER, u);
                    request.setAttribute(MESSAGE, "success");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_ELEVE).forward(request, response);
                } else {
                    request.setAttribute(MESSAGE, "error");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_ELEVE).forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(SessionServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute(MESSAGE, "error");
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_ELEVE).forward(request, response);
            }
        }
        if (action.equals("modifinscription")) {
            try {
                InscriptionValidationForm form = new InscriptionValidationForm(eDAO, cDAO, sDAO, iDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.modifierInscription(request);
                request.setAttribute(ATT_FORM, form);
                if (form.getErreurs().isEmpty()) {
                    session.setAttribute(ATT_SESSION_USER, u);
                    request.setAttribute(MESSAGE, "success");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_INSCRIPTION).forward(request, response);
                } else {
                    request.setAttribute(MESSAGE, "error");
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_INSCRIPTION).forward(request, response);
                }
            } catch (Exception ex) {
                Logger.getLogger(SessionServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute(MESSAGE, "error");
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_MODIFIER_INSCRIPTION).forward(request, response);
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
