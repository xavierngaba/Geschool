/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.CoursDAO;
import geschool.persistence.model.Cours;
import geschool.persistence.model.Matiere;
import geschool.persistence.model.Professeur;
import geschool.persistence.model.Classe;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;


public final class CoursValidationForm {

    @EJB
    private final CoursDAO cDAO;
    
    private static final String CHAMP_DESIGNATION = "designationCours";
    private static final String CHAMP_MATIERE = "matiere";
    private static final String CHAMP_PROFESSEUR = "professeur";
    private static final String CHAMP_CLASSE = "classe";
    private static final String ID_COURS = "idCours";



    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(CoursValidationForm.class.getName());

    public CoursValidationForm(CoursDAO cDAO) {
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

    public void ajoutCours(HttpServletRequest request) throws Exception {
        String designationCours = getValeurChamp(request, CHAMP_DESIGNATION);
        String matiere = getValeurChamp(request, CHAMP_MATIERE);
        System.out.println("matiere***************"+matiere);
        int id_matier = Integer.parseInt(matiere);
        String professeur = getValeurChamp(request, CHAMP_PROFESSEUR);
        System.out.println("matiere***************"+professeur);
        int id_professeur = Integer.parseInt(professeur);
        String classe = getValeurChamp(request, CHAMP_CLASSE);
        System.out.println("matiere***************"+classe);
        int id_classe = Integer.parseInt(classe);
      

        Cours c = new Cours();
        c.setDesignation(designationCours);
        c.setIdClasse(new Classe(id_classe));
        c.setIdMatiere(new Matiere(id_matier));
        c.setIdProfesseur(new Professeur(id_professeur));
        
        
        
        if (cDAO.verifCoursExist(c.getDesignation()) == 0) {
            try {
                cDAO.creerCours(c);
                resultat = "création du cours "+c.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec2", "Impossible de créer le cours "+c.getDesignation());
                resultat = "echec";
            }
        }else{
            setErreur("echec1", "Le cours "+c.getDesignation()+" existe déjà!");
            resultat = "Le cours "+c.getDesignation()+" existe déjà!";
        }
    }

    public void modifCours(HttpServletRequest request) throws Exception {
        Integer idCours = Integer.parseInt(getValeurChamp(request, ID_COURS));
        String designationCours = getValeurChamp(request, CHAMP_DESIGNATION);
        Cours c = cDAO.findByIdCours(idCours);
        c.setDesignation(designationCours);
            try {
                cDAO.modifierCours(c);
                resultat = "modification du cours "+c.getDesignation()+" avec succès";
            } catch (Exception e) {
                setErreur("echec", "Le cours "+c.getDesignation()+" n'a pas été modifiée");
                resultat = "Le cours "+c.getDesignation()+" n'a pas été modifiée";
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
