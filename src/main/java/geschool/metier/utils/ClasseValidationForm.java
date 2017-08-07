/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.model.Classe;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;


public final class ClasseValidationForm {

    @EJB
    private final ClasseDAO cDAO;
    
    private static final String CHAMP_libelle = "libelleClasse";
    //private static String CHAMP_NbrEleve = "nombreEleveMax";

    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(ClasseValidationForm.class.getName());

    public ClasseValidationForm(ClasseDAO cDAO) {
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

    public void ajoutClasse(HttpServletRequest request) throws Exception {
        String libelleClasse = getValeurChamp(request, CHAMP_libelle);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Classe c = new Classe();
        c.setLibelle(libelleClasse);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
        //c.setDateCreationClasse(new Date());
        if (cDAO.verifClasseExist(c.getLibelle()) == 0) {
            try {
                cDAO.creerClasse(c);
                resultat = "création de la classe "+c.getLibelle()+" avec succès";
            } catch (Exception e) {
                setErreur("echec2", "Impossible de créer la classe "+c.getLibelle());
                resultat = "echec";
            }
        }else{
            setErreur("echec1", "La classe "+c.getLibelle()+" existe déjà!");
            resultat = "La classe "+c.getLibelle()+" existe déjà!";
        }
    }

    public void modifClasse(HttpServletRequest request) throws Exception {
        String libelleClasse = getValeurChamp(request, CHAMP_libelle);
        //String nombreEleveMax = getValeurChamp(request, CHAMP_NbrEleve);
        Classe c = new Classe();
        c.setLibelle(libelleClasse);
        //c.setNombreEleveMax(Integer.parseInt(nombreEleveMax));
            try {
                cDAO.modifierClasse(c);
                resultat = "modification de la classe "+c.getLibelle()+" avec succès";
            } catch (Exception e) {
                setErreur("echec", "La classe "+c.getLibelle()+" n'a pas été modifiée");
                resultat = "La classe "+c.getLibelle()+" n'a pas été modifiée";
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
