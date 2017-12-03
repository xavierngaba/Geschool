/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.TuteurDAO;
import geschool.persistence.model.Tuteur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xavier_ng
 */
@Stateless
public class TuteurDAOImpl implements TuteurDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerTuteur(Tuteur t) {
        if(t != null){
            em.persist(t);
            em.flush();
        }
    }

    @Override
    public void modifierTuteur(Tuteur t) {
        if(t != null){
            em.merge(t);
        }
    }

    @Override
    public List<Tuteur> rechercherTousLesTuteurs() {
        return em.createNamedQuery("Tuteur.rechercherTousLesTuteurs").getResultList();
    }

    @Override
    public Tuteur rechercherTuteurAvecId(Integer idTuteur) {
        return em.find(Tuteur.class, idTuteur);
    }

    @Override
    public Tuteur rechercherTuteurAvecTutCode(String tutCode) {
        return (Tuteur) em.createNamedQuery("Tuteur.rechercherTuteurAvecTutCode")
                 .setParameter("tutCode", tutCode)
                 .getSingleResult();
    }

    @Override
    public Long rechercherLeDernierTuteurAjoute() {
        return (Long) em.createQuery("SELECT MAX(t.idTuteur) FROM Tuteur t").getSingleResult();
    }

    @Override
    public Long rechercherLeNombreTotalTuteur() {
        return (Long) em.createQuery("SELECT COUNT(t.idTuteur) FROM Tuteur t").getSingleResult();
    }
}
