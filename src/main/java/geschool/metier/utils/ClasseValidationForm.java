/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.model.Classe;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author xavier_ng
 */
    public final class ClasseValidationForm {
    @EJB
    private ClasseDAO cDAO;
    private static String CHAMP_libelle ="libelleClasse";
    private static final String CHAMP_DATE = "dateCreationClasse";
    private static String CHAMP_NbrEleve ="nombreEleveMax";       
    
    
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
    
    public void ajoutClasse(HttpServletRequest request) throws Exception{                                                                                                                                                                                                                              
        String date = getValeurChamp(request, CHAMP_DATE);
        Classe c = new Classe();
        
        List<Date> lesDates = ConvertDateYear.DateTransform(date);
        List<Integer> lesAnnees = ConvertDateYear.YearTransform(lesDates);
        try{
            if(verifDate(lesDates) == true){
                c.setDateCreation(lesDates.get(0));
                
                c.setDateCreation(lesAnnees.get(0));
                try{
                    c.setIdClasse(CreerId.creerSessionId(lesAnnees.get(0), lesAnnees.get(1)));
                }catch (Exception e) {
                    setErreur("SessionId", e.getMessage());
                }
                try{
                    cDAO.creerClasse(c);
                    resultat = "succes";
                }catch (Exception e) {
                    setErreur("echec", e.getMessage());
                    resultat = "echec";
                }
            }
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

