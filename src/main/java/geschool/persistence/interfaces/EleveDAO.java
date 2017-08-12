package geschool.persistence.interfaces;

import geschool.persistence.model.Eleve;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author inesG
 */
@Local
public interface EleveDAO {
    void creerEleve(Eleve e);
    void modifEleve(Eleve e);
    List<Eleve> rechercherTousLesEleves();
    Eleve rechercherUnEleveAvecId(Integer idEleve);
    Eleve rechercherUnEleveAvecMatricule(String matricule);
    Eleve rechercherUnEleveAvecNomEtPrenom(String nom,String prenom);
    Long rechercherLeNombreTotalEleve();
}
