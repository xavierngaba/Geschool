/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.InscritDAO;
import geschool.persistence.model.Inscrit;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xavier_ng
 */
@Stateless
public class InscritDAOImpl implements InscritDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerUneInscription(Inscrit i) {
        if(i != null){
            em.persist(i);
            em.flush();
        }
    }

    @Override
    public void modifierUneInscription(Inscrit i) {
        em.merge(i);
    }

    @Override
    public List<Inscrit> rechercherToutesLesInscriptions() {
        return em.createNamedQuery("Inscrit.rechercherToutesLesInscriptions").getResultList();
    }

    @Override
    public List<Inscrit> rechercherToutesLesElevesInscritsDansUneClasseUneAnnee(Integer idClasse, Integer idAnnee) {
        return em.createNamedQuery("Inscrit.rechercherToutesLesElevesInscritsDansUneClasseUneAnnee")
                 .setParameter("idClasse", idClasse)
                 .setParameter("idAnnee", idAnnee)
                 .getResultList();
    }

    @Override
    public List<Inscrit> rechercherToutesLesElevesInscritsPourUneAnnee(Integer idAnnee) {
        return em.createNamedQuery("Inscrit.rechercherToutesLesElevesInscritsPourUneAnnee")
                 .setParameter("idAnnee", idAnnee)
                 .getResultList();
    }

    @Override
    public List<Inscrit> rechercherToutesLesInscriptionsEleve(Integer idEleve) {
        return em.createNamedQuery("Inscrit.rechercherToutesLesInscriptionsEleve")
                 .setParameter("idEleve", idEleve)
                 .getResultList();
    }

    @Override
    public Inscrit rechercherInscritAvecId(Integer idInscrit) {
        return em.find(Inscrit.class, idInscrit);
    }

    @Override
    public Long verifierInscriptionEleve(Integer idEleve) {
        return (Long) em.createNamedQuery("Inscrit.verifierInscriptionEleve").setParameter("idEleve", idEleve).getSingleResult();
    }
}
