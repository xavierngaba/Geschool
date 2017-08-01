/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "inscription", catalog = "gestschool", schema = "")
@SequenceGenerator(name="InscriptionSequnce", initialValue=1, allocationSize=5)
@NamedQueries({
    @NamedQuery(name = "Inscription.rechercherToutesLesInscriptions", query = "SELECT i FROM Inscription i"),
    @NamedQuery(name = "Inscription.rechercherInscriptionAvecId", query = "SELECT i FROM Inscription i WHERE i.idInscription = :idInscription"),
    @NamedQuery(name = "Inscription.recherccherInscriptionAvecTranche1OK", query = "SELECT i FROM Inscription i WHERE i.tranche1Ok = :tranche1Ok"),
    @NamedQuery(name = "Inscription.recherccherInscriptionAvecTranche2OK", query = "SELECT i FROM Inscription i WHERE i.tranche2Ok = :tranche2Ok"),
    @NamedQuery(name = "Inscription.recherccherInscriptionAvecTranche3OK", query = "SELECT i FROM Inscription i WHERE i.tranche3Ok = :tranche3Ok"),
    @NamedQuery(name = "Inscription.recherccherInscriptionParSuiviParametrage", query = "SELECT i FROM Inscription i WHERE i.suiviParametrageInscriptionidSuiviParametrageInscription = :SuiviParametrage"),
    @NamedQuery(name = "Inscription.recherccherInscriptionSessionEnCours", query = "SELECT i FROM Inscription i WHERE i.suiviSessionClasseEleveEleveidEleve.sessionClasseidSessionClasse.sessionidSession.idSession = :idSession"),
    @NamedQuery(name = "Inscription.recherccherToutesLesInscriptionUneSalleClasse", query = "SELECT i FROM Inscription i WHERE i.suiviSessionClasseEleveEleveidEleve.sessionClasseidSessionClasse.classeidClasse.idClasse = :idClasse")
})
public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="InscriptionSequence")
    @Id
    @NotNull
    @Column(name = "idInscription", nullable = false)
    private Integer idInscription;
    @Size(max = 255)
    @Column(name = "commentaire", length = 255)
    private String commentaire;
    @Column(name = "Tranche1Ok")
    private Integer tranche1Ok;
    @Column(name = "Tranche2Ok")
    private Integer tranche2Ok;
    @Column(name = "Tranche3Ok")
    private Integer tranche3Ok;
    @JoinColumn(name = "SuiviSessionClasseEleve_Eleve_idEleve", referencedColumnName = "Eleve_idEleve", nullable = false)
    @ManyToOne(optional = false)
    private Suivisessionclasseeleve suiviSessionClasseEleveEleveidEleve;
    @JoinColumn(name = "SuiviParametrageInscription_idSuiviParametrageInscription", referencedColumnName = "idSuiviParametrageInscription", nullable = false)
    @ManyToOne(optional = false)
    private Suiviparametrageinscription suiviParametrageInscriptionidSuiviParametrageInscription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscriptionidInscription")
    private List<Tranche2> tranche2List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscriptionidInscription")
    private List<Tranche1> tranche1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscriptionidInscription")
    private List<Tranche3> tranche3List;

    public Inscription() {
    }

    public Integer getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Integer idInscription) {
        this.idInscription = idInscription;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getTranche1Ok() {
        return tranche1Ok;
    }

    public void setTranche1Ok(Integer tranche1Ok) {
        this.tranche1Ok = tranche1Ok;
    }

    public Integer getTranche2Ok() {
        return tranche2Ok;
    }

    public void setTranche2Ok(Integer tranche2Ok) {
        this.tranche2Ok = tranche2Ok;
    }

    public Integer getTranche3Ok() {
        return tranche3Ok;
    }

    public void setTranche3Ok(Integer tranche3Ok) {
        this.tranche3Ok = tranche3Ok;
    }

    public Suivisessionclasseeleve getSuiviSessionClasseEleveEleveidEleve() {
        return suiviSessionClasseEleveEleveidEleve;
    }

    public void setSuiviSessionClasseEleveEleveidEleve(Suivisessionclasseeleve suiviSessionClasseEleveEleveidEleve) {
        this.suiviSessionClasseEleveEleveidEleve = suiviSessionClasseEleveEleveidEleve;
    }

    public Suiviparametrageinscription getSuiviParametrageInscriptionidSuiviParametrageInscription() {
        return suiviParametrageInscriptionidSuiviParametrageInscription;
    }

    public void setSuiviParametrageInscriptionidSuiviParametrageInscription(Suiviparametrageinscription suiviParametrageInscriptionidSuiviParametrageInscription) {
        this.suiviParametrageInscriptionidSuiviParametrageInscription = suiviParametrageInscriptionidSuiviParametrageInscription;
    }

    public List<Tranche2> getTranche2List() {
        return tranche2List;
    }

    public void setTranche2List(List<Tranche2> tranche2List) {
        this.tranche2List = tranche2List;
    }

    public List<Tranche1> getTranche1List() {
        return tranche1List;
    }

    public void setTranche1List(List<Tranche1> tranche1List) {
        this.tranche1List = tranche1List;
    }

    public List<Tranche3> getTranche3List() {
        return tranche3List;
    }

    public void setTranche3List(List<Tranche3> tranche3List) {
        this.tranche3List = tranche3List;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInscription != null ? idInscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.idInscription == null && other.idInscription != null) || (this.idInscription != null && !this.idInscription.equals(other.idInscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Inscription[ idInscription=" + idInscription + " ]";
    }
    
}
