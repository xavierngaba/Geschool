/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ines
 */
@Entity
@Table(name = "utilisateur", catalog = "gestschool", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"login"})})
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.rechercheUtilisateurAvecId", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Utilisateur.rechercheUtilisateurParMotDePasse", query = "SELECT u FROM Utilisateur u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateur.rechercheLoginEtPassword", query = "SELECT u FROM Utilisateur u WHERE u.login = :login AND u.password = :password")})
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUtilisateur", nullable = false)
    private Integer idUtilisateur;
    @Size(max = 520)
    @Column(name = "nomUtilisateur", length = 520)
    private String nomUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "login", nullable = false, length = 45)
    private String login;
    @Size(max = 256)
    @Column(name = "password", length = 256)
    private String password;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(name = "etatConnexion")
    private Integer etatConnexion;
    @JoinColumn(name = "GroupeUtilisateur_idGroupeUtilisateur", referencedColumnName = "idGroupeUtilisateur", nullable = false)
    @ManyToOne(optional = false)
    private Groupeutilisateur groupeUtilisateuridGroupeUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateuridUtilisateur")
    private List<Suivistatuteleve> suivistatuteleveList;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(Integer idUtilisateur, String login) {
        this.idUtilisateur = idUtilisateur;
        this.login = login;
    }

    public Utilisateur(Integer idUtilisateur, String nomUtilisateur, String login, String password) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.login = login;
        this.password = password;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Integer getEtatConnexion() {
        return etatConnexion;
    }

    public void setEtatConnexion(Integer etatConnexion) {
        this.etatConnexion = etatConnexion;
    }

    public Groupeutilisateur getGroupeUtilisateuridGroupeUtilisateur() {
        return groupeUtilisateuridGroupeUtilisateur;
    }

    public void setGroupeUtilisateuridGroupeUtilisateur(Groupeutilisateur groupeUtilisateuridGroupeUtilisateur) {
        this.groupeUtilisateuridGroupeUtilisateur = groupeUtilisateuridGroupeUtilisateur;
    }

    public List<Suivistatuteleve> getSuivistatuteleveList() {
        return suivistatuteleveList;
    }

    public void setSuivistatuteleveList(List<Suivistatuteleve> suivistatuteleveList) {
        this.suivistatuteleveList = suivistatuteleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
