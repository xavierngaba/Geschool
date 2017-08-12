/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.MatiereDAO;
import geschool.persistence.model.Matiere;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;


public final class MatiereValidationForm {

    @EJB
    MatiereDAO mDAO;
    
    private static final String CHAMP_designation = "designation";
    //private static String CHAMP_NbrEleve = "nombreEleveMax";

    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(MatiereValidationForm.class.getName());

    public MatiereValidationForm(MatiereDAO mDAO) {
        this.mDAO = mDAO;
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

    public void ajoutMatiere(HttpServletRequest request) throws Exception {
        String designation = getValeurChamp(request, CHAMP_designation);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Matiere m = new Matiere();
        m.setDesignation(designation);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
        //c.setDateCreationMatiere(new Date());
        if (mDAO.verifMatiereExist(m.getDesignation()) == 0) {
            try {
                mDAO.creerMatiere(m);
                resultat = "création de la matière "+m.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec2", "Impossible de créer la matière "+m.getDesignation());
                resultat = "echec";
            }
        }else{
            setErreur("echec1", "La matière "+m.getDesignation()+" existe déjà!");
            resultat = "La matière "+m.getDesignation()+" existe déjà!";
        }
    }

    public void modifMatiere(HttpServletRequest request) throws Exception {
        String designation = getValeurChamp(request, CHAMP_designation);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Matiere m = new Matiere();
        m.setDesignation(designation);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
            try {
                mDAO.modifierMatiere(m);
                resultat = "modification de la matière "+m.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec", "La matière "+m.getDesignation()+" n'a pas été modifiée");
                resultat = "La matière "+m.getDesignation()+" n'a pas été modifiée";
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
