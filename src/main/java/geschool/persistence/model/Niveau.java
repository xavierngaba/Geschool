/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "niveau", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n"),
    @NamedQuery(name = "Niveau.findByIdNiveau", query = "SELECT n FROM Niveau n WHERE n.idNiveau = :idNiveau"),
    @NamedQuery(name = "Niveau.findByLibelle", query = "SELECT n FROM Niveau n WHERE n.libelle = :libelle")})
public class Niveau implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdNiveau")
    private Integer idNiveau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNiveau")
    private List<Discipline> disciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNiveau")
    private List<Groupe> groupeList;

    public Niveau() {
    }

    public Niveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Niveau(Integer idNiveau, String libelle) {
        this.idNiveau = idNiveau;
        this.libelle = libelle;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    public List<Groupe> getGroupeList() {
        return groupeList;
    }

    public void setGroupeList(List<Groupe> groupeList) {
        this.groupeList = groupeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNiveau != null ? idNiveau.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.idNiveau == null && other.idNiveau != null) || (this.idNiveau != null && !this.idNiveau.equals(other.idNiveau))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Niveau[ idNiveau=" + idNiveau + " ]";
    }
    
}
