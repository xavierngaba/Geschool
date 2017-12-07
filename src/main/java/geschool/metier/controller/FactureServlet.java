package geschool.metier.controller;

import static geschool.metier.controller.ClasseServlet.ATT_FORM;
import static geschool.metier.controller.ClasseServlet.ATT_SESSION_USER;
import static geschool.metier.controller.ClasseServlet.MESSAGE;
import geschool.metier.utils.AllUrl;
import geschool.metier.utils.ClasseValidationForm;
import geschool.metier.utils.FactureValidationForm;
import geschool.persistence.interfaces.EleveDAO;
import geschool.persistence.interfaces.FactureDAO;
import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Eleve;
import geschool.persistence.model.Facture;
import geschool.persistence.model.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author msgomis
 */
public class FactureServlet extends HttpServlet {

    @EJB
    private UtilisateurDAO uDAO;
    @EJB
    private EleveDAO eDAO;
    @EJB
    private FactureDAO fDAO;
    
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String ATT_FORM = "form";
    public static final String MESSAGE = "message";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int sessionId = Integer.parseInt(request.getParameter("session"));
        Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equals("ajoutfacture")) {
            List<Eleve> listEleve = eDAO.rechercherTousLesEleves();
            request.setAttribute("listeleve", listEleve);
            this.getServletContext().getRequestDispatcher(AllUrl.URL_PAGE_AJOUT_FACTURE).forward(request, response);
        }
            
        if(action.equals("listefacture")){
            session.setAttribute( ATT_SESSION_USER, u );
            List<Facture> listeFacture = fDAO.rechercherToutesLesFactures();
            request.setAttribute("listeFacture", listeFacture); 
            this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_TABLEAU_FACTURE ).forward( request, response );
        }
        if (action.equals("geteleve")) {
                String matricule = request.getParameter("matricule");
                Eleve eleve = eDAO.rechercherUnEleveAvecMatricule(matricule);
                Map data = new HashMap();
                if (eleve != null) {
                    data.put("ideleve", eleve.getIdEleve());
                    data.put("nomcomplet", eleve.getPrenom()+" "+eleve.getNom());
                } else {
                    data.put("ko", "Pas de resultat");
                }
                System.out.println(data.toString());                
                //JSONObject json = (JSONObject) JSONSerializer.toJSON(data);
                //response.getWriter().print(json);
            }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int sessionId = Integer.parseInt(request.getParameter("session"));
        HttpSession session = request.getSession();
        
        if (action.equals("ajoutfacture")) {
            try {
                FactureValidationForm form = new FactureValidationForm(fDAO);
                Utilisateur u = uDAO.rechercheUtilisateurAvecId(sessionId);
                /* Traitement de la requête et récupération du bean en résultant */
                form.ajoutFacture(request);
                request.setAttribute( ATT_FORM, form );
                 if ( form.getErreurs().isEmpty() ) {
                     session.setAttribute( ATT_SESSION_USER, u );
                     request.setAttribute(MESSAGE, "success");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_FACTURE ).forward( request, response );
                 }else{
                     request.setAttribute(MESSAGE, "error");
                     this.getServletContext().getRequestDispatcher( AllUrl.URL_PAGE_AJOUT_FACTURE ).forward( request, response );
                 }
            } catch (Exception ex) {
                Logger.getLogger(ClasseServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
