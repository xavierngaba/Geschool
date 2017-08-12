package geschool.metier.controller;

import geschool.metier.utils.AllUrl;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.InscritDAO;
import geschool.persistence.interfaces.TuteurDAO;
import geschool.persistence.interfaces.MatiereDAO;
import geschool.persistence.interfaces.ProfesseurDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Matiere;
import geschool.persistence.model.Professeur;
import geschool.persistence.interfaces.FactureDAO;
import geschool.persistence.model.Classe;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Inscrit;
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
    private EleveDAO eDAO;
    @EJB
    private TuteurDAO tDAO;
    @EJB
    private InscritDAO iDAO;
    @EJB
    private ClasseDAO cDAO;
    private MatiereDAO mDAO;
    private ProfesseurDAO pDAO;
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        List<Classe> listClasse = cDAO.rechercherToutesLesClasses();
        List<Eleve> listeleve = eDAO.rechercherTousLesEleves();
        List<Inscrit> listInscrit = iDAO.rechercherToutesLesInscriptions();
        if (listClasse != null) {
            request.setAttribute("nblistclasse", listClasse.size());
        } else {
            request.setAttribute("nblistclasse", 0);
        }
        if (listeleve != null) {
            request.setAttribute("nblisteleve", listeleve.size());
        } else {
            request.setAttribute("nblisteleve", 0);
        }
        if (listInscrit != null) {
            request.setAttribute("nblistinscrit", listInscrit.size());
        } else {
            request.setAttribute("nblistinscrit", 0);
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
            if (action.equals("listeleve")) {
                request.setAttribute("action", "listeleve");
                this.getServletContext().getRequestDispatcher("/InscriptionServlet").forward(request, response);
            }
            if (action.equals("listinscription")) {
                request.setAttribute("action", "listinscription");
                this.getServletContext().getRequestDispatcher("/InscriptionServlet").forward(request, response);
            }
            if (action.equals("detaileleve")) {
                String idEleve = request.getParameter("idEleve");
                Eleve e = eDAO.rechercherUnEleveAvecId(Integer.parseInt(idEleve));
                //Envoie de l'id de l'élève comme paramètre de requête
                request.setAttribute("eleve", e);
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_DETAIL_ELEVE).forward(request, response);
            }
            if (action.equals("listinscription")) {
                request.setAttribute("action", "listinscription");
                this.getServletContext().getRequestDispatcher("/InscriptionServlet").forward(request, response);
            }
            if (action.equals("listeprofesseur")) {
                request.setAttribute("action", "listeprofesseur");
                this.getServletContext().getRequestDispatcher("/ProfServlet").forward(request, response);
            }
            if (action.equals("listematiere")) {
                request.setAttribute("action", "listematiere");
                this.getServletContext().getRequestDispatcher("/MatiereServlet").forward(request, response);
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
            if (action.equals("ajouteleve")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_ELEVE).forward(request, response);
            }
            if (action.equals("ajoutinscription")) {
                //Envoie de la liste de toutes les classes disponibles en BDD
                request.setAttribute("listeleve", eDAO.rechercherTousLesEleves());
                //Envoie de la liste de tous les élèves enregistrés en BDD
                request.setAttribute("listclasse", cDAO.rechercherToutesLesClasses());
                request.setAttribute("Annee", sDAO.chercherSessionEnCours(new Date()));
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_INSCRIPTION).forward(request, response);
            }
            if (action.equals("ajoutprofesseur")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_PROFESSEUR).forward(request, response);
            }
            if (action.equals("ajoutmatiere")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_MATIERE).forward(request, response);
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
                if (action.equals("modifeleve")) {
                    String ideleve = request.getParameter("ideleve");
                    request.setAttribute("action", "modifeleve");
                    request.setAttribute("ideleve", ideleve);
                    this.getServletContext().getRequestDispatcher("/InscriptionServlet").forward(request, response);
                }
                if (action.equals("modifinscription")) {
                    String idInscrit = request.getParameter("idInscrit");
                    request.setAttribute("action", "modifinscription");
                    request.setAttribute("idInscrit", idInscrit);
                    this.getServletContext().getRequestDispatcher("/InscriptionServlet").forward(request, response);
                }
                if (action.equals("modifmatiere")) {
                    String idmatiere = request.getParameter("idmatiere");
                    request.setAttribute("action", "modifmatiere");
                    request.setAttribute("idmatiere", idmatiere);
                    this.getServletContext().getRequestDispatcher("/MatiereServlet").forward(request, response);
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
