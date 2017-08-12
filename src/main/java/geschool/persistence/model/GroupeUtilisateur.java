/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ines.G
 */
@Entity
@Table(name = "groupe_utilisateur", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "GroupeUtilisateur.findAll", query = "SELECT g FROM GroupeUtilisateur g"),
    @NamedQuery(name = "GroupeUtilisateur.findByIdGroupeUtilisateur", query = "SELECT g FROM GroupeUtilisateur g WHERE g.idGroupeUtilisateur = :idGroupeUtilisateur"),
    @NamedQuery(name = "GroupeUtilisateur.findByLibelleGroupeUtilisateur", query = "SELECT g FROM GroupeUtilisateur g WHERE g.libelleGroupeUtilisateur = :libelleGroupeUtilisateur")})
public class GroupeUtilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdGroupeUtilisateur")
    private Integer idGroupeUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LibelleGroupeUtilisateur")
    private String libelleGroupeUtilisateur;

    public GroupeUtilisateur() {
    }

    public GroupeUtilisateur(Integer idGroupeUtilisateur) {
        this.idGroupeUtilisateur = idGroupeUtilisateur;
    }

    public GroupeUtilisateur(Integer idGroupeUtilisateur, String libelleGroupeUtilisateur) {
        this.idGroupeUtilisateur = idGroupeUtilisateur;
        this.libelleGroupeUtilisateur = libelleGroupeUtilisateur;
    }

    public Integer getIdGroupeUtilisateur() {
        return idGroupeUtilisateur;
    }

    public void setIdGroupeUtilisateur(Integer idGroupeUtilisateur) {
        this.idGroupeUtilisateur = idGroupeUtilisateur;
    }

    public String getLibelleGroupeUtilisateur() {
        return libelleGroupeUtilisateur;
    }

    public void setLibelleGroupeUtilisateur(String libelleGroupeUtilisateur) {
        this.libelleGroupeUtilisateur = libelleGroupeUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupeUtilisateur != null ? idGroupeUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GroupeUtilisateur)) {
            return false;
        }
        GroupeUtilisateur other = (GroupeUtilisateur) object;
        if ((this.idGroupeUtilisateur == null && other.idGroupeUtilisateur != null) || (this.idGroupeUtilisateur != null && !this.idGroupeUtilisateur.equals(other.idGroupeUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.GroupeUtilisateur[ idGroupeUtilisateur=" + idGroupeUtilisateur + " ]";
    }
    
}
