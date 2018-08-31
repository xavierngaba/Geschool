/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Cours;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author IGNES
 */
@Local
public interface CoursDAO {
    void creerCours(Cours c);
    void modifierCours(Cours c);
    List<Cours> findAll();
    Cours findByIdCours (Integer id);
    Cours rechercherCoursParLibelleClasse(String l);
    int verifCoursExist(String l);
//    Integer rechercherLeNombreClasseCours(Integer id);
}   