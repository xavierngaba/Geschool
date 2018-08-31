/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INES
 */
@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c"),
    @NamedQuery(name = "Cours.findByIdCours", query = "SELECT c FROM Cours c WHERE c.idCours = :idCours"),
    @NamedQuery(name = "Cours.rechercherCoursParLibelleClasse", query = "SELECT e FROM Cours e WHERE e.designation = :designation"),
    @NamedQuery(name = "Cours.findByDesignation", query = "SELECT c FROM Cours c WHERE c.designation = :designation")})
public class Cours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdCours")
    private Integer idCours;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Designation")
    private String designation;
    @JoinColumn(name = "IdClasse", referencedColumnName = "IdClasse")
    @ManyToOne(optional = false)
    private Classe idClasse;
    @JoinColumn(name = "IdMatiere", referencedColumnName = "IdMatiere")
    @ManyToOne(optional = false)
    private Matiere idMatiere;
    @JoinColumn(name = "IdProfesseur", referencedColumnName = "IdProfesseur")
    @ManyToOne(optional = false)
    private Professeur idProfesseur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCours")
    private Collection<Evaluation> evaluationCollection;

    public Cours() {
    }

    public Cours(Integer idCours) {
        this.idCours = idCours;
    }

    public Cours(Integer idCours, String designation) {
        this.idCours = idCours;
        this.designation = designation;
    }

    public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public Matiere getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Matiere idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Professeur getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Professeur idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    @XmlTransient
    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCours != null ? idCours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.idCours == null && other.idCours != null) || (this.idCours != null && !this.idCours.equals(other.idCours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Cours[ idCours=" + idCours + " ]";
    }
    
}
