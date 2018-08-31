/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.CoursDAO;
import geschool.persistence.model.Cours;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author INES
 */
@Stateless
public class CoursDAOImpl implements CoursDAO{
    @PersistenceContext
    private EntityManager em;
    
    

    @Override
    public void creerCours(Cours c) {
        try {
            em.persist(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierCours(Cours c) {
         if (c != null) {
            em.merge(c);
        }    }

    @Override
    public List<Cours> findAll() {
        return em.createNamedQuery("Cours.findAll").getResultList();
    }

    @Override
    public Cours findByIdCours(Integer id) {
    return em.find(Cours.class, id); 
    }

    @Override
    public Cours rechercherCoursParLibelleClasse(String l) {
    return (Cours) em.createNamedQuery("Evaluation.rechercherCoursParLibelleClasse")
                 .setParameter("designation", l)
                 .getSingleResult();     
    }

    @Override
    public int verifCoursExist(String l) {
        try {
            Cours c=  (Cours) em.createNamedQuery("Evaluation.rechercherCoursParLibelleClasse")
                 .setParameter("designation", l)
                 .getSingleResult();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

//    @Override
//    public Integer rechercherLeNombreClasseCours(Integer id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
