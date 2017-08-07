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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "discipline", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Discipline.findAll", query = "SELECT d FROM Discipline d"),
    @NamedQuery(name = "Discipline.findByIdDiscipline", query = "SELECT d FROM Discipline d WHERE d.idDiscipline = :idDiscipline"),
    @NamedQuery(name = "Discipline.findByDesignation", query = "SELECT d FROM Discipline d WHERE d.designation = :designation")})
public class Discipline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdDiscipline")
    private Integer idDiscipline;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "designation")
    private String designation;
    @JoinColumn(name = "IdNiveau", referencedColumnName = "IdNiveau")
    @ManyToOne(optional = false)
    private Niveau idNiveau;

    public Discipline() {
    }

    public Discipline(Integer idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public Discipline(Integer idDiscipline, String designation) {
        this.idDiscipline = idDiscipline;
        this.designation = designation;
    }

    public Integer getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(Integer idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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
        hash += (idDiscipline != null ? idDiscipline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discipline)) {
            return false;
        }
        Discipline other = (Discipline) object;
        if ((this.idDiscipline == null && other.idDiscipline != null) || (this.idDiscipline != null && !this.idDiscipline.equals(other.idDiscipline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Discipline[ idDiscipline=" + idDiscipline + " ]";
    }
    
}
