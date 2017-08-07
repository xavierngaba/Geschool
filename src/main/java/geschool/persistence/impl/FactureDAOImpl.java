package geschool.persistence.impl;

import geschool.persistence.interfaces.FactureDAO;
import geschool.persistence.model.Facture;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author msgomis
 */
@Stateless
public class FactureDAOImpl implements FactureDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerFacture(Facture f) {
        if (f != null) {
            em.persist(f);
        }
    }

    @Override
    public List<Facture> rechercherToutesLesFactures() {
        return em.createNamedQuery("Facture.findAll").getResultList();
    }


}
