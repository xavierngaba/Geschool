/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Sessionclasse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author IGNES
 */
@Local
public interface SessionClasseDAO {
    void creerSessionClasse(Sessionclasse s)throws Exception;
    void modifierSessionClasse(Sessionclasse s)throws Exception;
    List<Sessionclasse> rechercherLesClassesParSession(String idSession);
    Sessionclasse rechercherSessionClasseParId(Integer idSessionClasse);
}
