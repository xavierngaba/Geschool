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
        Query query = em.createNamedQuery("Anneescolaire.rechercherUneAvecIdAnneeScolaire");
        query.setParameter("id", id);
        return (Anneescolaire) query.getSingleResult();
    }

    @Override
    public Anneescolaire chercherSessionEnCours(Date d) {
        Query query = em.createQuery("SELECT a FROM Anneescolaire a WHERE a.datedebut < :today")
                         .setParameter("today", d, TemporalType.DATE);
        return (Anneescolaire) query.getSingleResult();
    }

    @Override
    public List<Anneescolaire> rechercherToutesLesAnneesScolaire() {
        Query query = em.createNamedQuery("Anneescolaire.rechercherToutesLesAnneesScolaire");
        return query.getResultList();
    }
}
