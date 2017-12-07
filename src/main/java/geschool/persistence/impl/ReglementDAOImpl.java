/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.ReglementDAO;
import geschool.persistence.model.Reglement;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xavier_ng
 */
@Stateless
public class ReglementDAOImpl implements ReglementDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerReglement(Reglement r) {
        if(r != null){
            em.persist(r);
        }
    }

    @Override
    public void modifierReglement(Reglement r) {
        em.merge(r);
    }

    @Override
    public List<Reglement> rechercherTousLesRgelement() {
        return em.createNamedQuery("Reglement.findAll").getResultList();
    }

    @Override
    public Reglement rechercherUnReglementAvecUnId(Integer idReglement) {
        return (Reglement) em.createNamedQuery("Reglement.findByIdReglement").setParameter("idReglement", idReglement).getSingleResult();
    }

    @Override
    public List<Reglement> rechercherTousLesReglementAvecIdEleve(Integer idEleve) {
        return em.createNamedQuery("Reglement.findByIdEleve").setParameter("idEleve", idEleve).getResultList();
    }

    @Override
    public List<Reglement> rechercherTousLesElevesInscrits() {
        return em.createNamedQuery("Reglement.findByEleveInscrit").getResultList();
    }
}
