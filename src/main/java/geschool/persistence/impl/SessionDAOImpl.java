/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.model.Anneescolaire;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Ines
 */
@Stateless
public class SessionDAOImpl implements SessionDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerSession(Anneescolaire s) {
        if(s != null){
            em.persist(s);
        }
    }

    @Override
    public void modifSession(Anneescolaire s) {
        if(s != null){
            em.merge(s);
        }
    }

    @Override
    public Anneescolaire rechercherUneAvecIdAnneeScolaire(Integer id) {
        return em.find(Anneescolaire.class, id);
    }

    @Override
    public Anneescolaire chercherSessionEnCours() {
        return (Anneescolaire) em.createQuery("SELECT a FROM Anneescolaire a WHERE a.actif = 1")
                                 .getSingleResult();
    }

    @Override
    public List<Anneescolaire> rechercherToutesLesAnneesScolaire() {
        Query query = em.createNamedQuery("Anneescolaire.rechercherToutesLesAnneesScolaire");
        return query.getResultList();
    }
}
