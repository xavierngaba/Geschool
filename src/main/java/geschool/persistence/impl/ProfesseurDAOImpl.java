/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.ProfesseurDAO;
import geschool.persistence.model.Professeur;
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
public class ProfesseurDAOImpl implements ProfesseurDAO{
    @PersistenceContext
    private EntityManager em;
    
    @Override
   public void creerProfesseur(Professeur p){
         if(p != null){
           em.persist(p);
        }  
   }
   
    @Override
    public void modifierProfesseur(Professeur p){
        String updateQuery = "UPDATE Professeur SET nom_prenom = :nom_prenom WHERE p.IdProfesseur = :IdProfesseur";
        Query query = em.createNamedQuery(updateQuery);
        query.setParameter("IdProfesseur", p.getIdProfesseur());
        query.setParameter("nom_prenom", p.getNomPrenom());
        query.executeUpdate();
    }

   
     @Override
    public List<Professeur> rechercherTousLesProfesseur() {
        return em.createNamedQuery("Professeur.rechercherToutsLesProfesseur").getResultList();
    }

    @Override
    public Professeur rechercherProfesseurParId(String id) {
        Query query = em.createNamedQuery("Professeur.rechercherProfesseurParId");
        query.setParameter("IdProfesseur", id);
        return (Professeur) query.getSingleResult();
    }

    @Override
    public Professeur rechercherProfesseurParNom(String p) {
        Query query = em.createNamedQuery("Professeur.rechercherProfesseurParId");
        query.setParameter("nom_prenom", p);
        return (Professeur) query.getSingleResult();
    }

    @Override
    public Long verifProfesseurExist(String p) {
        Query query = em.createNamedQuery("Professeur.verifiernom_prenom");
        query.setParameter("nom_prenom", p);
        return (Long)query.getSingleResult(); 
    }

   

   
}

