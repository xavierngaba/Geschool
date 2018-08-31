/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.EvaluationDAO;
import geschool.persistence.model.Evaluation;
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
public class EvaluationDAOImpl implements EvaluationDAO{
    @PersistenceContext
    private EntityManager em;
    
    

    @Override
    public void creerEvaluation(Evaluation c) {
        try {
            em.persist(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierEvaluation(Evaluation c) {
        if (c != null){
            em.merge(c);
        }
    }

    @Override
    public List<Evaluation> rechercherToutesLesEvaluation() {
        return em.createNamedQuery("Evaluation.findAll").getResultList();
    }

    @Override
    public Evaluation rechercherEvaluationParId(Integer id) {
return (Evaluation) em.createNamedQuery("Evaluation.findByIdEvaluation")
                 .setParameter("idEvaluation", id)
                 .getSingleResult();    
    }

    @Override
    public Evaluation rechercherEvaluationParLibelleCours(String l) {
    return (Evaluation) em.createNamedQuery("Evaluation.rechercherEvaluationParLibelleCours")
                 .setParameter("designation", l)
                 .getSingleResult();     
    }

    @Override
    public Long verifEvaluationExist(String l) {
return (Long) em.createQuery("SELECT count(e.IdEvaluation) FROM Evaluation e").getSingleResult();    
    }

   
}
