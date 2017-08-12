package geschool.persistence.interfaces;

import geschool.persistence.model.Facture;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author msgomis
 */
@Local
public interface FactureDAO {    
    void creerFacture(Facture facture);
    List<Facture> rechercherToutesLesFactures();
}
