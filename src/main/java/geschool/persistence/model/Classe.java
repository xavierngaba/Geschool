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
@Table(name = "classe", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Classe.rechercherToutesLesClasses", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.rechercherClasseParId", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse"),
    @NamedQuery(name = "Classe.rechercherClasseParLibelleClasse", query = "SELECT c FROM Classe c WHERE c.libelleClasse = :libelleClasse"),
    @NamedQuery(name = "Classe.rechercherLeNombreMaxEleveClasse", query = "SELECT c.nombreEleveMax FROM Classe c WHERE c.nombreEleveMax = :nombreEleveMax")})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idClasse", nullable = false, length = 10)
    private String idClasse;
    @Column(name = "libelleClasse", nullable = false, length = 25)
    private String libelleClasse;
    @Column(name = "dateCreationClasse")
    @Temporal(TemporalType.DATE)
    private Date dateCreationClasse;
    @Column(name = "nombreEleveMax")
    private Integer nombreEleveMax;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classeidClasse")
    private List<Sessionclasse> sessionclasseList;

    public Classe() {
    }

    public Classe(String idClasse) {
        this.idClasse = idClasse;
    }

    public Classe(String idClasse, String libelleClasse) {
        this.idClasse = idClasse;
        this.libelleClasse = libelleClasse;
    }

    public String getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(String idClasse) {
        this.idClasse = idClasse;
    }

    public Date getDateCreationClasse() {
        return dateCreationClasse;
    }

    public void setDateCreationClasse(Date dateCreationClasse) {
        this.dateCreationClasse = dateCreationClasse;
    }

    public Integer getNombreEleveMax() {
        return nombreEleveMax;
    }

    public void setNombreEleveMax(Integer nombreEleveMax) {
        this.nombreEleveMax = nombreEleveMax;
    }

    public List<Sessionclasse> getSessionclasseList() {
        return sessionclasseList;
    }

    public void setSessionclasseList(List<Sessionclasse> sessionclasseList) {
        this.sessionclasseList = sessionclasseList;
    }

    public String getLibelleClasse() {
        return libelleClasse;
    }

    public void setLibelleClasse(String libelleClasse) {
        this.libelleClasse = libelleClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasse != null ? idClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idClasse == null && other.idClasse != null) || (this.idClasse != null && !this.idClasse.equals(other.idClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Classe[ idClasse=" + idClasse + " ]";
    }
    
}
