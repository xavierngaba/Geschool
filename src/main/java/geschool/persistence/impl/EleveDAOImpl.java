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
 * @author inesG
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
            em.merge(e);
        }
    }

    @Override
    public List<Eleve> rechercherTousLesEleves() {
        return em.createNamedQuery("Eleve.rechercherTousLesEleves").getResultList();
    }

    @Override
    public Eleve rechercherUnEleveAvecId(Integer idEleve) {
        return em.find(Eleve.class, idEleve);
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
    public Long rechercherLeNombreTotalEleve() {
        return (Long) em.createQuery("SELECT COUNT(e.idEleve) FROM Eleve e").getSingleResult();
    }
}
