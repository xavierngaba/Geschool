/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.SessionClasseDAO;
import geschool.persistence.model.Sessionclasse;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author IGNES
 */
@Stateless
public class SessionClasseDAOImpl implements SessionClasseDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Sessionclasse> rechercherLesClassesParSession(String idSession) {
        return em.createNamedQuery("Sessionclasse.rechercherLesClassesParSession")
                .setParameter("idSession", idSession)
                .getResultList();
    }

    @Override
    public Sessionclasse rechercherSessionClasseParId(Integer idSessionClasse) {
        return (Sessionclasse) em.createNamedQuery("Sessionclasse.rechercherSessionClasseParId")
                 .setParameter("idSessionClasse", idSessionClasse)
                 .getSingleResult();
    }

    @Override
    public void creerSessionClasse(Sessionclasse s) throws Exception{
        if( s.getSessionidSession().getIdSession() != null && s.getClasseidClasse().getIdClasse() != null){
            em.persist(s);
        }else{
            throw new NullPointerException("Des valeurs nulles ont été envoyées");
        }
    }

    @Override
    public void modifierSessionClasse(Sessionclasse s)throws Exception {
       if( s.getSessionidSession().getIdSession() != null && s.getClasseidClasse().getIdClasse() != null){
            em.merge(s);
        }else{
            throw new NullPointerException("Des valeurs nulles ont été envoyées");
        } 
    }  
}
