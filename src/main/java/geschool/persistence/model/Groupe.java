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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "groupe", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g"),
    @NamedQuery(name = "Groupe.findByIdGroupe", query = "SELECT g FROM Groupe g WHERE g.idGroupe = :idGroupe"),
    @NamedQuery(name = "Groupe.findByDesignation", query = "SELECT g FROM Groupe g WHERE g.designation = :designation"),
    @NamedQuery(name = "Groupe.findByGroupMensualite", query = "SELECT g FROM Groupe g WHERE g.groupMensualite = :groupMensualite"),
    @NamedQuery(name = "Groupe.findByGroupFraisInscription", query = "SELECT g FROM Groupe g WHERE g.groupFraisInscription = :groupFraisInscription"),
    @NamedQuery(name = "Groupe.findByGroupNbMois", query = "SELECT g FROM Groupe g WHERE g.groupNbMois = :groupNbMois"),
    @NamedQuery(name = "Groupe.findByGroupDateOuverture", query = "SELECT g FROM Groupe g WHERE g.groupDateOuverture = :groupDateOuverture"),
    @NamedQuery(name = "Groupe.findByGroupDateFermeture", query = "SELECT g FROM Groupe g WHERE g.groupDateFermeture = :groupDateFermeture")})
public class Groupe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdGroupe")
    private Integer idGroupe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_mensualite")
    private int groupMensualite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_frais_inscription")
    private int groupFraisInscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_nb_mois")
    private int groupNbMois;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_date_ouverture")
    @Temporal(TemporalType.DATE)
    private Date groupDateOuverture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_date_fermeture")
    @Temporal(TemporalType.DATE)
    private Date groupDateFermeture;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupe")
    private List<Classe> classeList;
    @JoinColumn(name = "IdNiveau", referencedColumnName = "IdNiveau")
    @ManyToOne(optional = false)
    private Niveau idNiveau;

    public Groupe() {
    }

    public Groupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Groupe(Integer idGroupe, String designation, int groupMensualite, int groupFraisInscription, int groupNbMois, Date groupDateOuverture, Date groupDateFermeture) {
        this.idGroupe = idGroupe;
        this.designation = designation;
        this.groupMensualite = groupMensualite;
        this.groupFraisInscription = groupFraisInscription;
        this.groupNbMois = groupNbMois;
        this.groupDateOuverture = groupDateOuverture;
        this.groupDateFermeture = groupDateFermeture;
    }

    public Integer getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getGroupMensualite() {
        return groupMensualite;
    }

    public void setGroupMensualite(int groupMensualite) {
        this.groupMensualite = groupMensualite;
    }

    public int getGroupFraisInscription() {
        return groupFraisInscription;
    }

    public void setGroupFraisInscription(int groupFraisInscription) {
        this.groupFraisInscription = groupFraisInscription;
    }

    public int getGroupNbMois() {
        return groupNbMois;
    }

    public void setGroupNbMois(int groupNbMois) {
        this.groupNbMois = groupNbMois;
    }

    public Date getGroupDateOuverture() {
        return groupDateOuverture;
    }

    public void setGroupDateOuverture(Date groupDateOuverture) {
        this.groupDateOuverture = groupDateOuverture;
    }

    public Date getGroupDateFermeture() {
        return groupDateFermeture;
    }

    public void setGroupDateFermeture(Date groupDateFermeture) {
        this.groupDateFermeture = groupDateFermeture;
    }

    public List<Classe> getClasseList() {
        return classeList;
    }

    public void setClasseList(List<Classe> classeList) {
        this.classeList = classeList;
    }

    public Niveau getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Niveau idNiveau) {
        this.idNiveau = idNiveau;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupe != null ? idGroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.idGroupe == null && other.idGroupe != null) || (this.idGroupe != null && !this.idGroupe.equals(other.idGroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Groupe[ idGroupe=" + idGroupe + " ]";
    }
    
}
