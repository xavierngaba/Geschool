package geschool.persistence.interfaces;


import geschool.persistence.model.Eleve;
import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author msgomis
 */
@Local
public interface EleveDAO {
    Eleve findEleveByMat(String matricule);
    List<Eleve> listeDesEleves();
}
