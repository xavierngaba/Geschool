/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.NotificationDAO;
import geschool.persistence.model.Notification;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author xavier_ng
 */
@Stateless
public class NotificationDAOImpl implements NotificationDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void ajouterNotification(Notification n) {
        if(n != null){
            em.persist(n);
            em.flush();
        }
    }

    @Override
    public void modifierNotification(Notification n) {
        em.merge(n);
    }

    @Override
    public Notification rechercherNotification(Integer id) {
        return (Notification) em.createNamedQuery("Notification.rechercherNotificationAvecId")
                 .setParameter("id", id)
                 .getSingleResult();
    }

    @Override
    public List<Notification> rechercherTouteLesNotifications() {
        return em.createNamedQuery("Notification.rechercherToutesLesNotifications")
                 .getResultList();
    }
}
