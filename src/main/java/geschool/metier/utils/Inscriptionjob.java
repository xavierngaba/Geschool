/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.utils;


import geschool.persistence.interfaces.NotificationDAO;
import geschool.persistence.model.Notification;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import javax.ejb.EJB;

/**
 *
 * @author xavier_ng
 */
public class Inscriptionjob implements Job{
//    @EJB
//    private NotificationDAO nDAO;
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        Date d = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//        Notification notif = new Notification();
//        notif.setCommentaire("Impression de la liste des élèves n'ayant pas terminés leur scolarité!!");
//        notif.setDateCr(d);
//        notif.setStatus("Non Lus");
//        nDAO.ajouterNotification(notif);
        System.out.println("Impression de la liste des élèves n'ayant pas terminés leur scolarité!!"+formater.format(d));
    }
    
}
