/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.model.Eleve;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author msgomis
 */
@Stateless
public class EleveDAOImpl implements EleveDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Eleve findEleveByMat(String matricule) {                
        Query query = em.createNamedQuery("Eleve.findByMatricule");
        query.setParameter("matricule", matricule);
        return (Eleve) query.getSingleResult();
    }

    @Override
    public List<Eleve> listeDesEleves() {
        return em.createNamedQuery("Eleve.findAll").getResultList();
    }

   

}
