/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.model.Classe;
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
public class ClasseDAOImpl implements ClasseDAO{
    @PersistenceContext
    private EntityManager em;
    
    @Override
   public void creerClasse(Classe c){
         if(c != null){
           em.persist(c);
        }  
   }
   
    @Override
    public void modifierClasse(Classe c){
        String updateQuery = "UPDATE Classe SET libelleClasse = :libelleClasse WHERE c.idClasse = :idClasse";
        Query query = em.createNamedQuery(updateQuery);
        query.setParameter("idClasse", c.getIdClasse());
        query.setParameter("libelleClasse", c.getLibelle());
        query.executeUpdate();
    }

    @Override
    public List<Classe> rechercherToutesLesClasses() {
        return em.createNamedQuery("Classe.rechercherToutesLesClasses").getResultList();
    }

    @Override
    public Classe rechercherClasseParId(Integer id) {
        Query query = em.createNamedQuery("Classe.rechercherClasseParId");
        query.setParameter("idClasse", id);
        return (Classe) query.getSingleResult();
    }

    @Override
    public Classe rechercherClasseParLibelleClasse(String l) {
        Query query = em.createNamedQuery("Classe.rechercherClasseParId");
        query.setParameter("libelleClasse", l);
        return (Classe) query.getSingleResult();
    }

    @Override
    public Long verifClasseExist(String l) {
        Query query = em.createNamedQuery("Classe.verifierLibelleClasse");
        query.setParameter("libelleClasse", l);
        return (Long)query.getSingleResult(); 
    }

    @Override
    public Integer rechercherLeNombreMaxEleveClasse(Integer id) {
        Query query = em.createNamedQuery("Classe.rechercherLeNombreMaxEleveClasse");
        query.setParameter("nombreEleveMax", id);
        return (Integer) query.getSingleResult(); 
    }
}

