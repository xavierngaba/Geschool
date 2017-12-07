/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Reglement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface ReglementDAO {
    void creerReglement(Reglement r);
    void modifierReglement(Reglement r);
    List<Reglement> rechercherTousLesRgelement();
    List<Reglement> rechercherTousLesElevesInscrits();
    Reglement rechercherUnReglementAvecUnId(Integer idReglement);
    List<Reglement> rechercherTousLesReglementAvecIdEleve(Integer idEleve);
}
