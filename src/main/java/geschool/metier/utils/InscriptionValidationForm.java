/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.InscritDAO;
import geschool.persistence.interfaces.ReglementDAO;
import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.model.Anneescolaire;
import geschool.persistence.model.Classe;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Inscrit;
import geschool.persistence.model.Reglement;
import geschool.persistence.model.Typereglement;
import java.util.Date;
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
    @EJB
    private final ReglementDAO rDAO;
    
    private static final String CHAMP_ID_INSCRIT = "idInscrit";
    private static final String CHAMP_ID_ANNEE = "idAnnee";
    private static final String CHAMP_ID_ELEVE = "idEleve";
    private static final String CHAMP_ID_CLASSE = "idClasse";
    private static final String CHAMP_MONTANT = "montant";
    private static final String CHAMP_RESTE = "reste";
    private static final String CHAMP_COMMENTAIRE = "commentaire";
    private static final String CHAMP_TYPE_REGLEMENT = "typeReglement";
    
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(EleveTuteurValidationForm.class.getName());

    public InscriptionValidationForm(EleveDAO eDAO, ClasseDAO cDAO, SessionDAO sDAO, InscritDAO iDAO, ReglementDAO rDAO) {
        this.eDAO = eDAO;
        this.cDAO = cDAO;
        this.sDAO = sDAO;
        this.iDAO = iDAO;
        this.rDAO = rDAO;
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
        String montant = getValeurChamp(request, CHAMP_MONTANT);
        String reste = getValeurChamp(request, CHAMP_RESTE);
        String commentaire = getValeurChamp(request, CHAMP_COMMENTAIRE);
        String typeReglement = getValeurChamp(request, CHAMP_TYPE_REGLEMENT);
        
        Anneescolaire session = new Anneescolaire();
        Eleve eleve = new Eleve();
        Classe classe = new Classe();
        Inscrit i = new Inscrit();
        Reglement r = new Reglement();
        Date dateCr = new Date();
        // a revoir
        //rechercheTypeReglementTypereglement tr = new Typereglement(TypeReglementEnum.rechercheTypeReglement(typeReglement));
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
        r.setIdEleves(eleve);
        r.setRegMontant(Integer.parseInt(montant));
        // a revoir
        //
        r.setRegType(null);
        r.setRegDate(dateCr);
        r.setRegref(commentaire);
        r.setRegCode(CreerId.creerCodeReglement(rDAO.rechercherTousLesRgelement().size()));
        try {
            rDAO.creerReglement(r);
            resultat = resultat + "\n Le paiement de la somme de "+r.getRegMontant()+" a été bien enregistré pour cette élève";
        }catch (Exception e) {
            setErreur("Reglement", "Erreur l'enregistrement du paiement de l'inscription");
        }
        eleve.setDette(Integer.parseInt(reste));
        eleve.setStatus("Inscrit");
        try{
           eDAO.modifEleve(eleve);
           resultat = resultat + "\n Mise à jour des informations de l'élève";
        }catch (Exception e) {
            setErreur("Eleve", "Erreur lors de la mise à jour des informations de l'élève");
        }
    }
    
    public void ajouterReglement(HttpServletRequest request) throws Exception{
        String idEleve = getValeurChamp(request, CHAMP_ID_ELEVE);
        String montant = getValeurChamp(request, CHAMP_MONTANT);
        String reste = getValeurChamp(request, CHAMP_RESTE);
        String commentaire = getValeurChamp(request, CHAMP_COMMENTAIRE);
        String typeReglement = getValeurChamp(request, CHAMP_TYPE_REGLEMENT);
        
        Eleve eleve = new Eleve();
        Reglement r = new Reglement();
        Date dateCr = new Date();
        // a revoir
        //Typereglement tr = new Typereglement(TypeReglementEnum.rechercheTypeReglement(typeReglement));
        try {
            eleve = eDAO.rechercherUnEleveAvecId(Integer.parseInt(idEleve));
        } catch (Exception e) {
            setErreur("eleve", "Erreur lors de la récupération de l'eleve");
        }
        r.setIdEleves(eleve);
        r.setRegMontant(Integer.parseInt(montant));
        //a revoir
        r.setRegType(null);
        r.setRegDate(dateCr);
        commentaire = commentaire+" Prochain paiement le "+ConvertDateYear.AjoutDateReglement(null, dateCr)+"";
        r.setRegref(commentaire);
        r.setRegCode(CreerId.creerCodeReglement(rDAO.rechercherTousLesRgelement().size()));
        try {
            rDAO.creerReglement(r);
            resultat = resultat + "\n Le paiement de la somme de "+r.getRegMontant()+" a été bien enregistré pour cette élève";
        }catch (Exception e) {
            setErreur("Reglement", "Erreur l'enregistrement du paiement de l'inscription");
        }
        eleve.setDette(Integer.parseInt(reste));
        eleve.setStatus("Inscrit");
        try{
           eDAO.modifEleve(eleve);
           resultat = resultat + "\n Mise à jour des informations de l'élève";
        }catch (Exception e) {
            setErreur("Eleve", "Erreur lors de la mise à jour des informations de l'élève");
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
