/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.metier.utils.Inscriptionjob;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.quartz.CronScheduleBuilder;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author xavier_ng
 */
public class InscriptionListener implements ServletContextListener {

    Scheduler scheduler = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("initialisation du contexte");

        try {
            // Setup the Job class and the Job group
            JobDetail job = newJob(Inscriptionjob.class).withIdentity("Inscriptionjob", "Group").build();
            // Create a Trigger that fires every 5 minutes.
            Trigger trigger = newTrigger().withIdentity("InscriptionTrigger", "Group")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
                    .build();
            // Setup the Job and Trigger with Scheduler & schedule jobs
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed");
        try {
            scheduler.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
