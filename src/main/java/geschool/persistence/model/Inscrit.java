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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INES
 */
@Entity
@Table(name = "inscrit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscrit.rechercherToutesLesInscriptions", query = "SELECT i FROM Inscrit i"),
    @NamedQuery(name = "Inscrit.rechercherInscritAvecId", query = "SELECT i FROM Inscrit i WHERE i.idInscrit = :idInscrit "),
    @NamedQuery(name = "Inscrit.rechercherToutesLesElevesInscritsDansUneClasseUneAnnee", query = "SELECT i FROM Inscrit i WHERE i.idClasse.idClasse = :idClasse AND i.idAnnee.id = :idAnnee"),
    @NamedQuery(name = "Inscrit.rechercherToutesLesElevesInscritsPourUneAnnee", query = "SELECT i FROM Inscrit i WHERE i.idAnnee.id = :idAnnee"),
    @NamedQuery(name = "Inscrit.verifierInscriptionEleve", query = "SELECT COUNT(i) FROM Inscrit i WHERE i.idEleve.idEleve = :idEleve"),
    @NamedQuery(name = "Inscrit.rechercherToutesLesInscriptionsEleve", query = "SELECT i FROM Inscrit i WHERE i.idEleve.idEleve = :idEleve"),
    @NamedQuery(name = "Inscrit.findAll", query = "SELECT i FROM Inscrit i"),
    @NamedQuery(name = "Inscrit.findByIdInscrit", query = "SELECT i FROM Inscrit i WHERE i.idInscrit = :idInscrit")})
public class Inscrit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdInscrit")
    private Integer idInscrit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEleve")
    private List<Note> noteList;
    @JoinColumn(name = "IdEleve", referencedColumnName = "IdEleve")
    @ManyToOne(optional = false)
    private Eleve idEleve;
    @JoinColumn(name = "IdClasse", referencedColumnName = "IdClasse")
    @ManyToOne(optional = false)
    private Classe idClasse;
    @JoinColumn(name = "IdAnnee", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Anneescolaire idAnnee;

    public Inscrit() {
    }

    public Inscrit(Integer idInscrit) {
        this.idInscrit = idInscrit;
    }

    public Integer getIdInscrit() {
        return idInscrit;
    }

    public void setIdInscrit(Integer idInscrit) {
        this.idInscrit = idInscrit;
    }

    @XmlTransient
    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public Anneescolaire getIdAnnee() {
        return idAnnee;
    }

    public void setIdAnnee(Anneescolaire idAnnee) {
        this.idAnnee = idAnnee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscrit != null ? idInscrit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscrit)) {
            return false;
        }
        Inscrit other = (Inscrit) object;
        if ((this.idInscrit == null && other.idInscrit != null) || (this.idInscrit != null && !this.idInscrit.equals(other.idInscrit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Inscrit[ idInscrit=" + idInscrit + " ]";
    }
    
}
