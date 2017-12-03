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
   public void creerMatiere(Matiere c){
         if(c != null){
           em.persist(c);
        }  
   }
   
    @Override
    public void modifierMatiere(Matiere c){
        String updateQuery = "UPDATE Matiere SET libelleMatiere = :libelleMatiere WHERE c.idMatiere = :idMatiere";
        Query query = em.createNamedQuery(updateQuery);
        query.setParameter("idMatiere", c.getIdMatiere());
        query.setParameter("libelleMatiere", c.getDesignation());
        query.executeUpdate();
    }

    @Override
    public List<Matiere> rechercherToutesLesMatieres() {
        return em.createNamedQuery("Matiere.rechercherToutesLesMatieres").getResultList();
    }

    @Override
    public Matiere rechercherMatiereParId(Integer id) {
        Query query = em.createNamedQuery("Matiere.rechercherMatiereParId");
        query.setParameter("idMatiere", id);
        return (Matiere) query.getSingleResult();
    }

    @Override
    public Matiere rechercherMatiereParLibelleMatiere(String l) {
        Query query = em.createNamedQuery("Matiere.rechercherMatiereParId");
        query.setParameter("libelleMatiere", l);
        return (Matiere) query.getSingleResult();
    }

    @Override
    public Long verifMatiereExist(String l) {
        Query query = em.createNamedQuery("Matiere.verifierDesignation");
        query.setParameter("designation", l);
        return (Long)query.getSingleResult(); 
    }

//    @Override
//    public Integer rechercherLeNombreMaxEleveMatiere(Integer id) {
//        Query query = em.createNamedQuery("Classe.rechercherLeNombreMaxEleveClasse");
//        query.setParameter("nombreEleveMax", id);
//        return (Integer) query.getSingleResult(); 
//    }
}

