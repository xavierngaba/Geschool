/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;

/**
 *
 * @author Ines.G
 */
public final class CreerId {

    public static final String SESSION_ID = "SESS";
    public static final String CLASS_ID = "CLASS";
    public static final String ELEVE_MATRICULE = "NP00";
    public static final String CODE_REGLEMENT = "F00";

    public static String creerSessionId(int anneeDebut, int anneeFin) throws Exception {
        String sessionId = "";

        if (anneeDebut != 0 && anneeFin != 0) {
            sessionId = "SESS" + anneeDebut + anneeFin + "";
        } else {
            throw new Exception("anneeDebut et anneeFin ont la valeur 0");
        }
        return sessionId;
    }

    public static String creerClasseId(String libelleClasse) throws Exception {
        String classeId = "";
        if (libelleClasse != null) {
            classeId = CLASS_ID + libelleClasse;
        } else {
            throw new Exception("le champ libelle est nul");
        }

        return classeId;
    }
    
    public static String creerMatriculeEleve(Long nbrEleve) throws Exception {
        String matriculeEleve = "";
        if (nbrEleve != 0) {
            nbrEleve++;
            matriculeEleve = ELEVE_MATRICULE.concat(String.valueOf(nbrEleve));
        } else {
            throw new Exception("le champ libelle est nul");
        }

        return matriculeEleve;
    }
    
    public static String creerCodeReglement(Integer nbrReglement) throws Exception {
        String codeReg = "";
        if (nbrReglement != 0) {
            nbrReglement++;
            codeReg = CODE_REGLEMENT.concat(String.valueOf(nbrReglement));
        } else {
            throw new Exception("Erreur lors de la génération du code reglement");
        }

        return codeReg;
    }
}
