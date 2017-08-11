/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Classe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author IGNES
 */
@Local
public interface ClasseDAO {
    void creerClasse(Classe c);
    void modifierClasse(Classe c);
    List<Classe> rechercherToutesLesClasses();
    Classe rechercherClasseParId (Integer id);
    Classe rechercherClasseParLibelleClasse(String l);
    Long verifClasseExist(String l);
    Integer rechercherLeNombreMaxEleveClasse(Integer id);
}   