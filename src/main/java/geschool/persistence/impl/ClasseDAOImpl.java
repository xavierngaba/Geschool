/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.ClasseDAO;
import geschool.persistence.model.Classe;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
       if (verifClasseExist(c.getLibelleClasse()) != true){
           em.persist(c);
       }else{
           try {
               throw new Exception("Cette Salle de classe existe déjà en Base de données");
           } catch (Exception ex) {
               Logger.getLogger(ClasseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }  
   
    @Override
    public void modifierClasse(Classe u) {
        em.merge(u);
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
    public boolean verifClasseExist(String l) {
        Query query = em.createNamedQuery("Classe.rechercherLeNombreMaxEleveClasse");
        query.setParameter("libelleClasse", l);
        return query.getSingleResult() != null ?true:false; 
    }

    @Override
    public Integer rechercherLeNombreMaxEleveClasse(Integer id) {
        Query query = em.createNamedQuery("Classe.rechercherLeNombreMaxEleveClasse");
        query.setParameter("nombreEleveMax", id);
        return (Integer) query.getSingleResult(); 
    }
}

