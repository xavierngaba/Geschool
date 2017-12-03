/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.InscritDAO;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.model.Anneescolaire;
import geschool.persistence.model.Classe;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Inscrit;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ines gnaly
 */
public final class InscriptionValidationForm {
    @EJB
    private final EleveDAO eDAO;
    @EJB
    private final ClasseDAO cDAO;
    @EJB
    private final SessionDAO sDAO;
    @EJB
    private final InscritDAO iDAO;
    
    private static final String CHAMP_ID_INSCRIT = "idInscrit";
    private static final String CHAMP_ID_ANNEE = "idAnnee";
    private static final String CHAMP_ID_ELEVE = "idEleve";
    private static final String CHAMP_ID_CLASSE = "idClasse";
    
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(EleveTuteurValidationForm.class.getName());

    public InscriptionValidationForm(EleveDAO eDAO, ClasseDAO cDAO, SessionDAO sDAO, InscritDAO iDAO) {
        this.eDAO = eDAO;
        this.cDAO = cDAO;
        this.sDAO = sDAO;
        this.iDAO = iDAO;
    }
    
    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }
    
    public void ajouterInscription(HttpServletRequest request) throws Exception{
        String idAnnee = getValeurChamp(request, CHAMP_ID_ANNEE);
        String idEleve = getValeurChamp(request, CHAMP_ID_ELEVE);
        String idClasse = getValeurChamp(request, CHAMP_ID_CLASSE);
        Anneescolaire session = new Anneescolaire();
        Eleve eleve = new Eleve();
        Classe classe = new Classe();
        Inscrit i = new Inscrit();
        try {
            session = sDAO.rechercherUneAvecIdAnneeScolaire(Integer.parseInt(idAnnee));
        } catch (Exception e) {
            setErreur("date", "Erreur lors de la récupération de l'année scolaire en cours");
        }
        try {
            eleve = eDAO.rechercherUnEleveAvecId(Integer.parseInt(idEleve));
        } catch (Exception e) {
            setErreur("eleve", "Erreur lors de la récupération de l'eleve");
        }
        try {
            classe = cDAO.rechercherClasseParId(Integer.parseInt(idClasse));
        } catch (Exception e) {
            setErreur("classe", "Erreur lors de la récupération de la classe");
        }
        i.setIdAnnee(session);
        i.setIdClasse(classe);
        i.setIdEleve(eleve);
        try {
            iDAO.creerUneInscription(i);
            resultat = "L'élève "+eleve.getPrenom()+" "+eleve.getNom()+" "
                    + "a été bien ajouté dans la salle de classe "+classe.getLibelle()+" pour l'année "+session.getLibelle();
        } catch (Exception e) {
            setErreur("Inscription", "Erreur lors de l'ajout d'une nouvelle inscription");
        }
    }
    
    public void modifierInscription(HttpServletRequest request) throws Exception{
        String idInscrit = getValeurChamp(request, CHAMP_ID_INSCRIT);
        String idAnnee = getValeurChamp(request, CHAMP_ID_ANNEE);
        String idEleve = getValeurChamp(request, CHAMP_ID_ELEVE);
        String idClasse = getValeurChamp(request, CHAMP_ID_CLASSE);
        Anneescolaire session = new Anneescolaire();
        Eleve eleve = eDAO.rechercherUnEleveAvecId(Integer.parseInt(idEleve));
        Classe classe = cDAO.rechercherClasseParId(Integer.parseInt(idClasse));
        Inscrit i = iDAO.rechercherInscritAvecId(Integer.parseInt(idInscrit));
        try {
            session = sDAO.rechercherUneAvecIdAnneeScolaire(Integer.parseInt(idAnnee));
        } catch (Exception e) {
            setErreur("date", "Erreur lors de la récupération de l'année scolaire en cours");
        }
        try {
            eleve = eDAO.rechercherUnEleveAvecId(Integer.parseInt(idEleve));
        } catch (Exception e) {
            setErreur("eleve", "Erreur lors de la récupération de l'eleve");
        }
        try {
            classe = cDAO.rechercherClasseParId(Integer.parseInt(idClasse));
        } catch (Exception e) {
            setErreur("classe", "Erreur lors de la récupération de la classe");
        }
        i.setIdAnnee(session);
        i.setIdClasse(classe);
        i.setIdEleve(eleve);
        try {
            iDAO.modifierUneInscription(i);
        } catch (Exception e) {
            setErreur("Inscription", "Erreur lors de la modification de l'inscription");
        }
    }
    
    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
