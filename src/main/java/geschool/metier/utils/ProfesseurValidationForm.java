/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.ProfesseurDAO;
import geschool.persistence.model.Professeur;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;


public final class ProfesseurValidationForm {

    @EJB
    ProfesseurDAO pDAO;
    
    private static final String CHAMP_nom_prenom = "nomPrenom";
    //private static String CHAMP_NbrEleve = "nombreEleveMax";

    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(ProfesseurValidationForm.class.getName());

    public ProfesseurValidationForm(ProfesseurDAO pDAO) {
        this.pDAO = pDAO;
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

    public void ajoutProfesseur(HttpServletRequest request) throws Exception {
        String nomPrenom = getValeurChamp(request, CHAMP_nom_prenom);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Professeur p = new Professeur();
        p.setNomPrenom(nomPrenom);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
        //c.setDateCreationClasse(new Date());
        if (pDAO.verifProfesseurExist(p.getNomPrenom()) == 0L) {
            try {
                pDAO.creerProfesseur(p);
                resultat = "création du prof "+p.getNomPrenom()+" avec succès";
            } catch (Exception e) {
                setErreur("echec2", "Impossible de créer le prof "+p.getNomPrenom());
                resultat = "echec";
            }
        }else{
            setErreur("echec1", "Le professeur "+p.getNomPrenom()+" existe déjà!");
            resultat = "Le prof "+p.getNomPrenom()+" existe déjà!";
        }
    }

    public void modifProfesseur(HttpServletRequest request) throws Exception {
        String nom_prenom = getValeurChamp(request, CHAMP_nom_prenom);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Professeur p = new Professeur();
        p.setNomPrenom(nom_prenom);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
            try {
                pDAO.modifierProfesseur(p);
                resultat = "modification du professeur "+p.getNomPrenom()+" avec succès";
            } catch (Exception e) {
                setErreur("echec", "Le professeur "+p.getNomPrenom()+" n'a pas été modifié");
                resultat = "Le professeur "+p.getNomPrenom()+" n'a pas été modifié";
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
