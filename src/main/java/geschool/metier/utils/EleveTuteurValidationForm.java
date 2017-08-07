/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.interfaces.TuteurDAO;
import geschool.persistence.model.Anneescolaire;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Tuteur;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author xavier_ng
 */
public final class EleveTuteurValidationForm {
    @EJB
    private final EleveDAO eDAO;
    @EJB
    private final TuteurDAO tDAO;
    @EJB
    private SessionDAO sDAO;
    
    private static final String CHAMP_ELEVE_NOM = "Nom";
    private static final String CHAMP_ELEVE_PRENOM = "Prenom";
    private static final String CHAMP_ELEVE_DATE_NAISSANCE = "Date_Naiss";
    private static final String CHAMP_ELEVE_SEXE = "sexe";
    private static final String CHAMP_ELEVE_NATIONALITE = "nationalite";
    private static final String CHAMP_TUTEUR_NOM = "NomTuteur";
    private static final String CHAMP_TUTEUR_PRENOM = "PrenomTuteur";
    private static final String CHAMP_TUTEUR_TELEPHONE = "telephone";
    private static final String CHAMP_TUTEUR_ADRESSE = "Adresse";
    private static final String CHAMP_TUTEUR_RELATION = "Relation";
    
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(EleveTuteurValidationForm.class.getName());

    public EleveTuteurValidationForm(EleveDAO eDAO, TuteurDAO tDAO) {
        this.eDAO = eDAO;
        this.tDAO = tDAO;
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
    
    public void ajouterEleveTuteur(HttpServletRequest request) throws Exception{
        String Nom = getValeurChamp(request, CHAMP_ELEVE_NOM);
        String Prenom = getValeurChamp(request, CHAMP_ELEVE_PRENOM);
        String Date_Naiss = getValeurChamp(request, CHAMP_ELEVE_DATE_NAISSANCE);
        String sexe = getValeurChamp(request, CHAMP_ELEVE_SEXE);
        String nationalite = getValeurChamp(request, CHAMP_ELEVE_NATIONALITE);
        String NomTuteur = getValeurChamp(request, CHAMP_TUTEUR_NOM);
        String PrenomTuteur = getValeurChamp(request, CHAMP_TUTEUR_PRENOM);
        String telephone = getValeurChamp(request, CHAMP_TUTEUR_TELEPHONE);
        String Adresse = getValeurChamp(request, CHAMP_TUTEUR_ADRESSE);
        String Relation = getValeurChamp(request, CHAMP_TUTEUR_RELATION);
        Anneescolaire session = new Anneescolaire();
        Eleve el = new Eleve();
        el.setNom(Nom);
        el.setPrenom(Prenom);
        el.setDateNaiss(ConvertDateYear.StringTransformDate(Date_Naiss));
        el.setSexe(sexe);
        el.setNationalite(nationalite);
        Tuteur t = new Tuteur();
        t.setNomPrenom(NomTuteur.concat(" ").concat(PrenomTuteur));
        t.setTelephone(telephone);
        t.setAdresse(Adresse);
        t.setRelation(Relation);
        int nbrMaxEleve = 0;
        int nbrMaxTuteur = 0;
        try {
            session = sDAO.chercherSessionEnCours(new Date());
        } catch (Exception e) {
            setErreur("date", "Erreur lors de la récupération de l'année scolaire en cours");
        }
        try {
            nbrMaxEleve = eDAO.rechercherLeNombreTotalEleve();
        } catch (Exception e) {
            setErreur("nbrMaxEleve", "Erreur lors de la récupération du nombre total d'élève");
        }
        el.setMatricule(CreerId.creerMatriculeEleve(session.getLibelle(), nbrMaxEleve));
        try {
            nbrMaxTuteur = tDAO.rechercherLeNombreTotalTuteur();
        } catch (Exception e) {
            setErreur("nbrMaxTuteur", "Erreur lors de la récupération du nombre total de tuteur");
        }
        t.setTutCode(NomTuteur.concat(String.valueOf(nbrMaxTuteur+1)));
        try {
            tDAO.creerTuteur(t);
        } catch (Exception e) {
            setErreur("tuteur", "Erreur lors de l'ajout d'un nouveau tuteur");
        }
        el.setIdTuteur(tDAO.rechercherTuteurAvecId(tDAO.rechercherLeDernierTuteurAjoute()));
        el.setDateinscription(new Date());
        try {
            eDAO.creerEleve(el);
        } catch (Exception e) {
            setErreur("eleve", "Erreur lors de l'ajout d'un nouvel eleve");
        }
    }
    
    public void modiferEleveTuteur(HttpServletRequest request) throws Exception{
        String Nom = getValeurChamp(request, CHAMP_ELEVE_NOM);
        String Prenom = getValeurChamp(request, CHAMP_ELEVE_PRENOM);
        String Date_Naiss = getValeurChamp(request, CHAMP_ELEVE_DATE_NAISSANCE);
        String sexe = getValeurChamp(request, CHAMP_ELEVE_SEXE);
        String nationalite = getValeurChamp(request, CHAMP_ELEVE_NATIONALITE);
        String NomTuteur = getValeurChamp(request, CHAMP_TUTEUR_NOM);
        String PrenomTuteur = getValeurChamp(request, CHAMP_TUTEUR_PRENOM);
        String telephone = getValeurChamp(request, CHAMP_TUTEUR_TELEPHONE);
        String Adresse = getValeurChamp(request, CHAMP_TUTEUR_ADRESSE);
        String Relation = getValeurChamp(request, CHAMP_TUTEUR_RELATION);
        Eleve el = new Eleve();
        el.setNom(Nom);
        el.setPrenom(Prenom);
        el.setDateNaiss(ConvertDateYear.StringTransformDate(Date_Naiss));
        el.setSexe(sexe);
        el.setNationalite(nationalite);
        Tuteur t = new Tuteur();
        t.setNomPrenom(NomTuteur.concat(" ").concat(PrenomTuteur));
        t.setTelephone(telephone);
        t.setAdresse(Adresse);
        t.setRelation(Relation);
        int nbrMaxTuteur = 0;
        try {
            nbrMaxTuteur = tDAO.rechercherLeNombreTotalTuteur();
        } catch (Exception e) {
            setErreur("nbrMaxTuteur", "Erreur lors de la récupération du nombre total de tuteur");
        }
        t.setTutCode(NomTuteur.concat(String.valueOf(nbrMaxTuteur+1)));
        try {
            tDAO.modifierTuteur(t);
        } catch (Exception e) {
            setErreur("tuteur", "Erreur lors de la modification du tuteur");
        }
        el.setIdTuteur(tDAO.rechercherTuteurAvecId(tDAO.rechercherLeDernierTuteurAjoute()));
        try {
            eDAO.modifEleve(el);
        } catch (Exception e) {
            setErreur("eleve", "Erreur lors de la modification de l'eleve");
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
