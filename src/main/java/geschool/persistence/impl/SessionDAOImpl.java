/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.SessionDAO;
import geschool.persistence.model.Session;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ines
 */
@Stateless
public class SessionDAOImpl implements SessionDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void creerSession(Session s) {
        if(s != null){
            em.persist(s);
        }
    }

    @Override
    public void modifSession(Session s) {
        if(s != null){
            em.merge(s);
        }
    }

    @Override
    public Session chercherSession(String idSession) {
        Query query = em.createNamedQuery("Session.rechercherUneSessionAvecId");
        query.setParameter("idSession", idSession);
        return (Session) query.getSingleResult();
    }

    @Override
    public Session chercherSessionEnCours() {
        Query query = em.createNamedQuery("Session.rechercherUneSessionEnCours");
        return (Session) query.getSingleResult();
    }

    @Override
    public List<Session> chercherToutesLesSessions() {
        Query query = em.createNamedQuery("Session.rechercherToutesLesSessions");
        return query.getResultList();
    }
}
