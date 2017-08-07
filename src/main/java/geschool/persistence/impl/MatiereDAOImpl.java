/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.MatiereDAO;
import geschool.persistence.model.Matiere;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author IGNES
 */
@Stateless
public class MatiereDAOImpl implements MatiereDAO{
    @PersistenceContext
    private EntityManager em;
    
    @Override
   public void creerMatiere(Matiere m){
         if(m != null){
           em.persist(m);
        }  
   }
   
    @Override
    public void modifierMatiere(Matiere m){
        String updateQuery = "UPDATE Matiere SET designation = :designation WHERE c.idMatiere = :idMatiere";
        Query query = em.createNamedQuery(updateQuery);
        query.setParameter("idMatiere", m.getIdMatiere());
        query.setParameter("designation", m.getDesignation());
        query.executeUpdate();
    }

    @Override
    public List<Matiere> rechercherToutesLesMatieres() {
        return em.createNamedQuery("Matiere.rechercherToutesLesMatieres").getResultList();
    }

    @Override
    public Matiere rechercherMatiereParId(String id) {
        Query query = em.createNamedQuery("Classe.rechercherMatiereParId");
        query.setParameter("idMatiere", id);
        return (Matiere) query.getSingleResult();
    }

    @Override
    public Matiere rechercherMatiereParDesignation(String d) {
        Query query = em.createNamedQuery("Matiere.rechercherMatiereParId");
        query.setParameter("designation", d);
        return (Matiere) query.getSingleResult();
    }

    @Override
    public Long verifMatiereExist(String d) {
        Query query = em.createNamedQuery("Matiere.verifierdesignation");
        query.setParameter("designation", d);
        return (Long)query.getSingleResult(); 
    }

}

