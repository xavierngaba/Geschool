/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.metier.controller;

import geschool.persistence.interfaces.NotificationDAO;
import geschool.persistence.model.Notification;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xavier_ng
 */
public class AjaxServlet extends HttpServlet {
    @EJB
    private NotificationDAO nDAO;
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String notification = request.getParameter("notification");
        
        if(notification.equals("recherche")){
            Date d = new Date();
            String reponse = "";
            List<Notification> listNotif = nDAO.rechercherTouteLesNotifications();
            for (Notification notific : listNotif) {
                if(notific.getDateCr().equals(d)){
                    reponse = "oui";
                    break;
                }
            }
            response.setContentType("text/plain");
            response.getWriter().write(reponse);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
