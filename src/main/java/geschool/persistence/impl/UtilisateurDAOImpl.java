/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.impl;

import geschool.persistence.interfaces.UtilisateurDAO;
import geschool.persistence.model.Utilisateur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ines
 */
@Stateless
public class UtilisateurDAOImpl implements UtilisateurDAO{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Utilisateur rechercheUtilisateur(String login, String password) {
        Query query = em.createNamedQuery("Utilisateur.rechercheLoginEtPassword");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (Utilisateur) query.getSingleResult();
    }

    @Override
    public boolean rechercheUtilisateur(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void majEtatConnexion(Utilisateur u) {
        em.merge(u);
    }

    @Override
    public Utilisateur rechercheUtilisateurParMotDePasse(String password) {
         Query query = em.createNamedQuery("Utilisateur.rechercheUtilisateurParMotDePasse");
        query.setParameter("password", password);
        return (Utilisateur) query.getSingleResult();
    }

    @Override
    public Utilisateur rechercheUtilisateurAvecId(Integer id) {
        Query query = em.createNamedQuery("Utilisateur.rechercheUtilisateurAvecId");
        query.setParameter("idUtilisateur", id);
        return (Utilisateur) query.getSingleResult();
    }
}
