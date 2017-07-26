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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "suiviparametrageinscription", catalog = "gestschool", schema = "")
@SequenceGenerator(name="SuiviparametrageinscriptionSequence", initialValue=1, allocationSize=10)
@NamedQueries({
    @NamedQuery(name = "Suiviparametrageinscription.rechercherTousSuiviparametrageinscription", query = "SELECT s FROM Suiviparametrageinscription s"),
    @NamedQuery(name = "Suiviparametrageinscription.findByIdSuiviParametrageInscription", query = "SELECT s FROM Suiviparametrageinscription s WHERE s.idSuiviParametrageInscription = :idSuiviParametrageInscription"),
    @NamedQuery(name = "Suiviparametrageinscription.findByMontantTranche1", query = "SELECT s FROM Suiviparametrageinscription s WHERE s.montantTranche1 = :montantTranche1"),
    @NamedQuery(name = "Suiviparametrageinscription.findByMontantTranche2", query = "SELECT s FROM Suiviparametrageinscription s WHERE s.montantTranche2 = :montantTranche2"),
    @NamedQuery(name = "Suiviparametrageinscription.findByMontantTranche3", query = "SELECT s FROM Suiviparametrageinscription s WHERE s.montantTranche3 = :montantTranche3"),
    @NamedQuery(name = "Suiviparametrageinscription.findByMontantTotal", query = "SELECT s FROM Suiviparametrageinscription s WHERE s.montantTotal = :montantTotal")})
public class Suiviparametrageinscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SuiviparametrageinscriptionSequence")
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSuiviParametrageInscription", nullable = false)
    private Integer idSuiviParametrageInscription;
    @Column(name = "montantTranche1")
    private Integer montantTranche1;
    @Column(name = "montantTranche2")
    private Integer montantTranche2;
    @Column(name = "montantTranche3")
    private Integer montantTranche3;
    @Column(name = "montantTotal")
    private Integer montantTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "suiviParametrageInscriptionidSuiviParametrageInscription")
    private List<Inscription> inscriptionList;

    public Suiviparametrageinscription() {
    }

    public Integer getIdSuiviParametrageInscription() {
        return idSuiviParametrageInscription;
    }

    public void setIdSuiviParametrageInscription(Integer idSuiviParametrageInscription) {
        this.idSuiviParametrageInscription = idSuiviParametrageInscription;
    }

    public Integer getMontantTranche1() {
        return montantTranche1;
    }

    public void setMontantTranche1(Integer montantTranche1) {
        this.montantTranche1 = montantTranche1;
    }

    public Integer getMontantTranche2() {
        return montantTranche2;
    }

    public void setMontantTranche2(Integer montantTranche2) {
        this.montantTranche2 = montantTranche2;
    }

    public Integer getMontantTranche3() {
        return montantTranche3;
    }

    public void setMontantTranche3(Integer montantTranche3) {
        this.montantTranche3 = montantTranche3;
    }

    public Integer getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Integer montantTotal) {
        this.montantTotal = montantTotal;
    }

    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSuiviParametrageInscription != null ? idSuiviParametrageInscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suiviparametrageinscription)) {
            return false;
        }
        Suiviparametrageinscription other = (Suiviparametrageinscription) object;
        if ((this.idSuiviParametrageInscription == null && other.idSuiviParametrageInscription != null) || (this.idSuiviParametrageInscription != null && !this.idSuiviParametrageInscription.equals(other.idSuiviParametrageInscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Suiviparametrageinscription[ idSuiviParametrageInscription=" + idSuiviParametrageInscription + " ]";
    }
    
}
