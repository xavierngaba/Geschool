/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Anneescolaire;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface SessionDAO {
    void creerSession(Anneescolaire s);
    void modifSession(Anneescolaire s);
    Anneescolaire rechercherUneAvecIdAnneeScolaire(Integer id);
    Anneescolaire chercherSessionEnCours(Date d);
    List<Anneescolaire> rechercherToutesLesAnneesScolaire();
}
