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
 * @author Ines.G
 */
@Entity
@Table(name = "anneescolaire", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Anneescolaire.rechercherToutesLesAnneesScolaire", query = "SELECT a FROM Anneescolaire a"),
    @NamedQuery(name = "Anneescolaire.rechercherUneAvecIdAnneeScolaire", query = "SELECT a FROM Anneescolaire a WHERE a.id = :id"),
    @NamedQuery(name = "Anneescolaire.rechercherParLibelle", query = "SELECT a FROM Anneescolaire a WHERE a.libelle = :libelle")})
public class Anneescolaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_debut")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_fin")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnnee")
    private List<Inscrit> inscritList;

    public Anneescolaire() {
    }

    public Anneescolaire(Integer id, String libelle, Date datedebut, Date datefin) {
        this.id = id;
        this.libelle = libelle;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public List<Inscrit> getInscritList() {
        return inscritList;
    }

    public void setInscritList(List<Inscrit> inscritList) {
        this.inscritList = inscritList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anneescolaire)) {
            return false;
        }
        Anneescolaire other = (Anneescolaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Anneescolaire[ id=" + id + " ]";
    }
    
}
