package geschool.metier.utils;

import geschool.persistence.interfaces.FactureDAO;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Facture;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author msgomis
 */
public class FactureValidationForm {

    @EJB
    FactureDAO fDAO;

    public static final String CHAMP_MONTANT = "montant";
    public static final String CHAMP_CODE = "codefacture";
    public static final String CHAMP_ID_ELEVE = "ideleve";

    public FactureValidationForm(FactureDAO fDAO) {
        this.fDAO = fDAO;
    }

    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    public void ajoutFacture(HttpServletRequest request) throws Exception {
        String codefacture = getValeurChamp(request, CHAMP_CODE);
        int montant = Integer.parseInt(getValeurChamp(request, CHAMP_MONTANT));
        int idEleve = Integer.parseInt(getValeurChamp(request, CHAMP_ID_ELEVE));
        Facture f = new Facture();

        try {
            f.setCodeFacture(codefacture);
            f.setMontantFacture(montant);
            f.setDateFacture(new Date());
            f.setIdEleve(new Eleve(idEleve));
            fDAO.creerFacture(f);
            resultat = "succes";
        } catch (Exception e) {
            setErreur("echec", e.getMessage());
            resultat = "echec";
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
