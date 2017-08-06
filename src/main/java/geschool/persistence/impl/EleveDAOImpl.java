/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.model.Eleve;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xavier_ng
 */
@Stateless
public class EleveDAOImpl implements EleveDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerEleve(Eleve e) {
        if (e != null) {
            em.persist(e);
            em.flush();
        }
    }

    @Override
    public void modifEleve(Eleve e) {
        if (e != null) {
            Eleve el = em.find(Eleve.class, e.getIdEleve());
            el.setDateNaiss(e.getDateNaiss());
            el.setNom(e.getNom());
            el.setPrenom(e.getPrenom());
            el.setIdTuteur(e.getIdTuteur());
            el.setAdresses(e.getAdresses());
            el.setQuantine(e.getQuantine());
            el.setStatus(e.getStatus());
        }
    }

    @Override
    public List<Eleve> rechercherTousLesEleves() {
        return em.createNamedQuery("Eleve.rechercherTousLesEleves").getResultList();
    }

    @Override
    public Eleve rechercherUnEleveAvecId(Integer idEleve) {
        return (Eleve) em.createNamedQuery("Eleve.rechercherUnEleveAvecId")
                         .setParameter("idEleve", idEleve)
                         .getSingleResult();
    }

    @Override
    public Eleve rechercherUnEleveAvecMatricule(String matricule) {
        return (Eleve) em.createNamedQuery("Eleve.rechercherUnEleveAvecMatricule")
                 .setParameter("matricule", matricule)
                 .getSingleResult();
    }

    @Override
    public Eleve rechercherUnEleveAvecNomEtPrenom(String nom, String prenom) {
        return (Eleve) em.createNamedQuery("Eleve.rechercherUnEleveAvecNomEtPrenom")
                 .setParameter("nom", nom)
                 .setParameter("prenom", prenom)
                 .getSingleResult();
    }

    @Override
    public Integer rechercherLeNombreTotalEleve() {
        return (Integer) em.createQuery("SELECT count(e.idEleve) FROM Eleve e").getSingleResult();
    }
}
