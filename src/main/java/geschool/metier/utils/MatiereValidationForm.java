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
    private final MatiereDAO cDAO;
    
    private static final String CHAMP_libelle = "libelleMatiere";
    //private static String CHAMP_NbrEleve = "nombreEleveMax";

    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(MatiereValidationForm.class.getName());

    public MatiereValidationForm(MatiereDAO cDAO) {
        this.cDAO = cDAO;
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
        String libelleMatiere = getValeurChamp(request, CHAMP_libelle);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Matiere c = new Matiere();
        c.setDesignation(libelleMatiere);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
        //c.setDateCreationClasse(new Date());
        if (cDAO.verifMatiereExist(c.getDesignation()) == 0L) {
            try {
                cDAO.creerMatiere(c);
                resultat = "création de la matiere "+c.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec2", "Impossible de créer la matiere "+c.getDesignation());
                resultat = "echec";
            }
        }else{
            setErreur("echec1", "La matiere "+c.getDesignation()+" existe déjà!");
            resultat = "La matiere "+c.getDesignation()+" existe déjà!";
        }
    }

    public void modifMatiere(HttpServletRequest request) throws Exception {
        String libelleMatiere = getValeurChamp(request, CHAMP_libelle);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Matiere c = new Matiere();
        c.setDesignation(libelleMatiere);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
            try {
                cDAO.modifierMatiere(c);
                resultat = "modification de la matiere "+c.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec", "La matiere "+c.getDesignation()+" n'a pas été modifiée");
                resultat = "La matiere "+c.getDesignation()+" n'a pas été modifiée";
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
