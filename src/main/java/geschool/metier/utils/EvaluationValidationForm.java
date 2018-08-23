/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.EvaluationDAO;
import geschool.persistence.model.Evaluation;
import geschool.persistence.model.Evaluation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;


public final class EvaluationValidationForm {

    @EJB
    private final EvaluationDAO cDAO;
    
    
    private static final String ID_EVALUATION = "idEvaluation";
    private static final String CHAMP_DESIGNATION = "designation";



    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(EvaluationValidationForm.class.getName());

    public EvaluationValidationForm(EvaluationDAO cDAO) {
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

    public void ajoutEvaluation(HttpServletRequest request) throws Exception {
        String designation = getValeurChamp(request, CHAMP_DESIGNATION);
      

        Evaluation c = new Evaluation();
        c.setDesignation(designation);
        
        
        
        if (cDAO.verifEvaluationExist(c.getDesignation()) == 0) {
            try {
                cDAO.creerEvaluation(c);
                resultat = "création de l'evaluation "+c.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec2", "Impossible de créer l'evaluation  "+c.getDesignation());
                resultat = "echec";
            }
        }else{
            setErreur("echec1", "L'evaluation "+c.getDesignation()+" existe déjà!");
            resultat = "L'evaluation "+c.getDesignation()+" existe déjà!";
        }
    }

    public void modifEvaluation(HttpServletRequest request) throws Exception {
        Integer idEvaluation = Integer.parseInt(getValeurChamp(request, ID_EVALUATION));
        String designation = getValeurChamp(request, CHAMP_DESIGNATION);
        Evaluation c = cDAO.rechercherEvaluationParId(idEvaluation);
        c.setDesignation(designation);
            try {
                cDAO.modifierEvaluation(c);
                resultat = "modification de l'evaluation "+c.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec", "L'evaluation "+c.getDesignation()+" n'a pas été modifiée");
                resultat = "L'evaluation "+c.getDesignation()+" n'a pas été modifiée";
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
