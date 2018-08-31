/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.interfaces;

import geschool.persistence.model.Notification;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author xavier_ng
 */
@Local
public interface NotificationDAO {
    void ajouterNotification(Notification n);
    void modifierNotification(Notification n);
    Notification rechercherNotification(Integer id);
    List<Notification> rechercherTouteLesNotifications();
}
