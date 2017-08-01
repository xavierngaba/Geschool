/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Utilisateur;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ines.G
 */
public final class ConnexionValidationForm {

    private static final String CHAMP_LOGIN = "login";
    private static final String CHAMP_PASS = "password";
    private static final String REGEX = "[a-zA-Z_0-9]*";
    private String resultat;
    private final Map<String, String> erreurs = new HashMap<>();
    @EJB
    private UtilisateurDAO uDAO;
    private static final Logger LOG = Logger.getLogger(ConnexionValidationForm.class.getName());

    public ConnexionValidationForm(UtilisateurDAO uDAO) {
        this.uDAO = uDAO;
    }

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur(HttpServletRequest request) throws Exception {
        /* Récupération des champs du formulaire */
        String login = getValeurChamp(request, CHAMP_LOGIN);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);
        Utilisateur utilisateur = new Utilisateur();
        try {
            validationLogin(login);
        } catch (Exception e) {
            setErreur(CHAMP_LOGIN, e.getMessage());
        }
        utilisateur.setLogin(login);
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse(motDePasse);
        } catch (Exception e) {
            setErreur(CHAMP_PASS, e.getMessage());
        }
        utilisateur.setPassword(motDePasse);
        try {
            boolean flags = verifUser(utilisateur.getLogin(), utilisateur.getPassword());
            if (flags == true) {
                utilisateur = uDAO.rechercheUtilisateur(utilisateur.getLogin(), utilisateur.getPassword());
                resultat = "succes";
            } else {
                resultat = "echec";
            }
        } catch (Exception e) {
            setErreur("user", e.getMessage());
        }
        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }
        return utilisateur;
    }

    public Utilisateur unlockUtilisateur(HttpServletRequest request) throws Exception {
        String motDePasse = getValeurChamp(request, CHAMP_PASS);
        Utilisateur utilisateur = new Utilisateur();
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse(motDePasse);
        } catch (Exception e) {
            setErreur(CHAMP_PASS, e.getMessage());
        }
        utilisateur.setPassword(motDePasse);
        try {
            utilisateur = uDAO.rechercheUtilisateurParMotDePasse(utilisateur.getPassword());
            if (utilisateur != null) {
                resultat = "succes";
            } else {
                resultat = "echec";
            }
        } catch (Exception e) {
            setErreur("user", e.getMessage());
        }
        /* Initialisation du résultat global de la validation. */
        if (erreurs.isEmpty()) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }
        return utilisateur;
    }

    /**
     * Valide le login.
     */
    private void validationLogin(String login) throws Exception {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(login);
        if (login != null) {
            if (!m.matches()) {
                throw new Exception("Les caractères saisies ne sont pas correctes");
            }
        } else {
            throw new Exception("Le Champ est vide");
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse(String motDePasse) throws Exception {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(motDePasse);
        if (motDePasse != null) {
            if (!m.matches()) {
                throw new Exception("Les caractères saisies ne sont pas correctes");
            }
        } else {
            throw new Exception("Le Champ est vide");
        }
    }

    private boolean verifUser(String login, String password) throws Exception {
        Utilisateur u = uDAO.rechercheUtilisateur(login, password);
        boolean flags = false;
        if (u.getIdUtilisateur() != null) {
            flags = true;
        } else {
            throw new Exception("Utilisateur non enregistré dans le système contactez votre administrateur");
        }
        return flags;
    }
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
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
