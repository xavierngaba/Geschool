package geschool.metier.controller;

import geschool.metier.utils.AllUrl;
import geschool.metier.utils.TypeReglementEnum;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.interfaces.CoursDAO;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.InscritDAO;
import geschool.persistence.interfaces.TuteurDAO;
import geschool.persistence.interfaces.MatiereDAO;
import geschool.persistence.interfaces.ProfesseurDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Matiere;
import geschool.persistence.model.Professeur;
import geschool.persistence.interfaces.ReglementDAO;
import geschool.persistence.model.Anneescolaire;
import geschool.persistence.model.Classe;
import geschool.persistence.model.Cours;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Inscrit;
import geschool.persistence.model.Reglement;
import geschool.persistence.model.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
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
    @EJB
    private CoursDAO dDAO;
    @EJB
    private MatiereDAO mDAO;
    @EJB
    private ProfesseurDAO pDAO;
    @EJB
    private ReglementDAO rDAO;
    public static final String ATT_SESSION_USER = "sessionUtilisateur";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        List<Classe> listClasse = cDAO.rechercherToutesLesClasses();
        List<Eleve> listeleve = eDAO.rechercherTousLesEleves();
        List<Inscrit> listInscrit = iDAO.rechercherToutesLesInscriptions();
        List<Inscrit> listeleveinscrit = new ArrayList<Inscrit>();
        List<Cours> listCours = dDAO.findAll();
        List<Reglement> listreglement = rDAO.rechercherTousLesElevesInscrits();
        for (Inscrit inscrit : listInscrit) {
            if(inscrit.getIdEleve().getDette() > 0 || inscrit.getIdEleve().getStatus().equals("Inscrit")){
                    listeleveinscrit.add(inscrit);
            }
        }
        List<Professeur> listprofesseur= pDAO.rechercherTousLesProfesseur();
        List<Matiere> listmatiere=mDAO.rechercherToutesLesMatieres();
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
        if (listprofesseur != null) {
            request.setAttribute("nblistprofesseur", listprofesseur.size());
        } else {
            request.setAttribute("nblistprofesseur", 0);
        } 
        if (listmatiere != null) {
            request.setAttribute("nblistmatiere", listmatiere.size());
        } else {
            request.setAttribute("nblistmatiere", 0);
        }
        if (listeleveinscrit != null) {
            request.setAttribute("nblistinscrit", listeleveinscrit.size());
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
            if (action.equals("listcours")) {
                request.setAttribute("action", "listcours");
                this.getServletContext().getRequestDispatcher("/CoursServlet").forward(request, response);
            }
            if (action.equals("listevaluation")) {
                request.setAttribute("action", "listevaluation");
                this.getServletContext().getRequestDispatcher("/EvaluationServlet").forward(request, response);
            }
            if (action.equals("detaileleve")) {
                String idEleve = request.getParameter("ideleve");
                Eleve e = eDAO.rechercherUnEleveAvecId(Integer.parseInt(idEleve));
                // recheche de la salle de classe de l'année en cours de l'élève
                e.setInscritList(iDAO.rechercherToutesLesInscriptionsEleve(e.getIdEleve()));
                Anneescolaire a = sDAO.chercherSessionEnCours();
                Classe c = new Classe();
                for (Inscrit list : e.getInscritList()) {
                    if(list.getIdAnnee().getId().equals(a.getId())){
                        c = list.getIdClasse();
                    }
                }
                e.setReglementList(rDAO.rechercherTousLesReglementAvecIdEleve(e.getIdEleve()));
                Integer scolarite = 0;
                for (Reglement list : e.getReglementList()) {
                    scolarite = scolarite + list.getRegMontant();
                }
                //Recherche de toutes les notes de l'élève pour l'année en cours et pour les années précédentes
                // à compléter ...
                //Envoie de l'id de l'élève comme paramètre de requête
                request.setAttribute("eleve", e);
                request.setAttribute("classe", c);
                request.setAttribute("scolarite", scolarite);
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_DETAIL_ELEVE).forward(request, response);
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
                request.setAttribute("sessionClasse", sDAO.chercherSessionEnCours());
                this.getServletContext().getRequestDispatcher("/ClasseServlet").forward(request, response);
            }
            if (action.equals("ajoutsession")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_SESSION_ACADEMIQUE).forward(request, response);
            }
           
            if (action.equals("ajoutevaluation")) {
                request.setAttribute("listecours", listCours);
                for(Classe c : listClasse){
                    System.out.println(c.getLibelle());
                }
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_EVALUATION).forward(request, response);
            }
            if (action.equals("ajoutclasse")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_CLASSE).forward(request, response);
            }
            if (action.equals("ajoutcours")) {
                request.setAttribute("listeclasse", listClasse);
                request.setAttribute("listprofesseur", listprofesseur);
                request.setAttribute("listmatiere", listmatiere);
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_COURS).forward(request, response);
            }
            if (action.equals("ajouteleve")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_ELEVE).forward(request, response);
            }
            if (action.equals("ajoutinscription")) {
                //Envoie de la liste de toutes les classes disponibles en BDD
                request.setAttribute("listeleve", eDAO.rechercherTousLesEleves());
                //Envoie de la liste de tous les élèves enregistrés en BDD
                request.setAttribute("listclasse", cDAO.rechercherToutesLesClasses());
                request.setAttribute("Annee", sDAO.chercherSessionEnCours());
                request.setAttribute("listetypereglement", TypeReglementEnum.ToutesLesTypeDeReglement());
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_INSCRIPTION).forward(request, response);
            }
            if (action.equals("ajoutpaiement")) {
                if(!request.getParameter("ideleve").equals("null")){
                   Eleve eleve = eDAO.rechercherUnEleveAvecId(Integer.parseInt(request.getParameter("ideleve")));
                   List<Inscrit> listEleveInscrit = iDAO.rechercherToutesLesInscriptionsEleve(eleve.getIdEleve());
                   if(listEleveInscrit != null && iDAO.verifierInscriptionEleve(eleve.getIdEleve()) != 0L){
                        Inscrit inscrit = listEleveInscrit.get(0);
                        List<Reglement> listeReglement = rDAO.rechercherTousLesReglementAvecIdEleve(eleve.getIdEleve());
                        Integer scolarite = 0;
                        for (Reglement list : listeReglement) {
                           scolarite = scolarite + list.getRegMontant();
                        }
                        request.setAttribute("Annee", sDAO.chercherSessionEnCours());
                        request.setAttribute("eleve", eleve);
                        request.setAttribute("Inscrit", inscrit);
                        request.setAttribute("scolarite", scolarite);
                        request.setAttribute("listetypereglement", TypeReglementEnum.ToutesLesTypeDeReglement());
                        this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_PAIEMENT).forward(request, response);
                   }else{
                        //Envoie de la liste de toutes les classes disponibles en BDD
                        request.setAttribute("listeleve", eDAO.rechercherTousLesEleves());
                        //Envoie de la liste de tous les élèves enregistrés en BDD
                        request.setAttribute("listclasse", cDAO.rechercherToutesLesClasses());
                        request.setAttribute("Annee", sDAO.chercherSessionEnCours());
                        request.setAttribute("listetypereglement", TypeReglementEnum.ToutesLesTypeDeReglement());
                        this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_PAIEMENT).forward(request, response);  
                   }   
                }else{
                    //Envoie de la liste de toutes les classes disponibles en BDD
                    request.setAttribute("listeleve", eDAO.rechercherTousLesEleves());
                    //Envoie de la liste de tous les élèves enregistrés en BDD
                    request.setAttribute("listclasse", cDAO.rechercherToutesLesClasses());
                    request.setAttribute("Annee", sDAO.chercherSessionEnCours());
                    request.setAttribute("listetypereglement", TypeReglementEnum.ToutesLesTypeDeReglement());
                    this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_PAIEMENT).forward(request, response); 
                }  
            }
            if (action.equals("ajoutprofesseur")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_PROFESSEUR).forward(request, response);
            }
            if (action.equals("ajoutmatiere")) {
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_MATIERE).forward(request, response);
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
            if (action.equals("modifcours")) {
                String idcours = request.getParameter("idcours");
                request.setAttribute("action", "modifcours");
                request.setAttribute("idcours", idcours);
                this.getServletContext().getRequestDispatcher("/CoursServlet").forward(request, response);
            }
            if (action.equals("modifevaluation")) {
                String idevaluation = request.getParameter("idevaluation");
                request.setAttribute("action", "modifevaluation");
                request.setAttribute("idevaluation", idevaluation);
                this.getServletContext().getRequestDispatcher("/EvaluationServlet").forward(request, response);
            }
            if (action.equals("modifeleve")) {
                String ideleve = request.getParameter("ideleve");
                String idtuteur = request.getParameter("idtuteur");
                request.setAttribute("action", "modifeleve");
                request.setAttribute("ideleve", ideleve);
                request.setAttribute("idtuteur", idtuteur);
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
                request.setAttribute("sessionClasse", sDAO.chercherSessionEnCours());
                this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_SESSION_CLASSE).forward(request, response);
            }

            } else {
                request.setAttribute("action", "unlock");
                request.setAttribute(ATT_SESSION_USER, session);
                this.getServletContext().getRequestDispatcher("/UtilisateurServlet").forward(request, response);
            }
    }

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
