/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.model.Session;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ines.G
 */
public final class SessionValidationForm {
    @EJB
    private final SessionDAO sDAO;
    private static final String CHAMP_DATE = "date";
    
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(SessionValidationForm.class.getName());

    public SessionValidationForm(SessionDAO sDAO) {
        this.sDAO = sDAO;
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
    
    public void ajoutSession(HttpServletRequest request) throws Exception{                                                                                                                                                                                                                              
        String date = getValeurChamp(request, CHAMP_DATE);
        Session s = new Session();
        if(date != null){
            List<Date> lesDates = ConvertDateYear.DateTransform(date);
            List<Integer> lesAnnees = ConvertDateYear.YearTransform(lesDates);
            try{
                if(verifDate(lesDates) == true){
                    s.setDateDebut(lesDates.get(0));
                    s.setDateFin(lesDates.get(1));

                    s.setAnneeDebut(lesAnnees.get(0));
                    s.setAnneFin(lesAnnees.get(1));
                    s.setActif(0);
                    try{
                        s.setIdSession(CreerId.creerSessionId(lesAnnees.get(0), lesAnnees.get(1)));
                    }catch (Exception e) {
                        setErreur("SessionId", e.getMessage());
                    }
                    try{
                        sDAO.creerSession(s);
                        resultat = "succes";
                    }catch (Exception e) {
                        setErreur("echec", e.getMessage());
                        resultat = "echec";
                    }
                }
            }catch (Exception e) {
                setErreur(CHAMP_DATE, e.getMessage());
            }
        }else{
            setErreur("SessionId", "Le champ date a renvoyé une valeur vide");
        } 
    }
    
    private boolean verifDate(List<Date> listDate)throws Exception{
        boolean flags = false;
        Date d1 = listDate.get(0);
        Date d2 = listDate.get(1);
        
        if(!(d1.compareTo(d2) == 0)){
            if(d1.compareTo(d2) < 0){
                flags = true;
            }else{
                throw new Exception("la date de début doit toujours être inférieure à la date de fin");
            }
        }else{
             throw new Exception("la date de début et la date de fin sont égaux");
        }    
       return flags;
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
