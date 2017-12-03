/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Matiere;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author IGNES
 */
@Local
public interface MatiereDAO {
    void creerMatiere(Matiere c);
    void modifierMatiere(Matiere c);
    List<Matiere> rechercherToutesLesMatieres();
    Matiere rechercherMatiereParId (Integer id);
    Matiere rechercherMatiereParLibelleMatiere(String l);
    Long verifMatiereExist(String l);
//    Integer rechercherLeNombreMaxEleveClasse(Integer id);
}   