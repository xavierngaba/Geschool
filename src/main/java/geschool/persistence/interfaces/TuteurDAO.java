/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Tuteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface TuteurDAO {
    void creerTuteur(Tuteur t);
    void modifierTuteur(Tuteur t);
    List<Tuteur> rechercherTousLesTuteurs();
    Tuteur rechercherTuteurAvecId(Integer idTuteur);
    Tuteur rechercherTuteurAvecTutCode(String tutCode);
    Long rechercherLeDernierTuteurAjoute();
    Long rechercherLeNombreTotalTuteur();
}
