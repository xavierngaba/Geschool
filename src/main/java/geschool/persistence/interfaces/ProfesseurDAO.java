/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Professeur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author IGNES
 */
@Local
public interface ProfesseurDAO {
    void creerProfesseur(Professeur p);
    void modifierProfesseur(Professeur p);
    List<Professeur> rechercherTousLesProfesseur();
    Professeur rechercherProfesseurParId (String id);
    Professeur rechercherProfesseurParNom(String p);
    Long verifProfesseurExist(String p);
}   