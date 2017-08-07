/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ines.G
 */
@Entity
@Table(name = "facture", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Facture.findAll", query = "SELECT f FROM Facture f"),
    @NamedQuery(name = "Facture.findByIdFacture", query = "SELECT f FROM Facture f WHERE f.idFacture = :idFacture"),
    @NamedQuery(name = "Facture.findByDateFacture", query = "SELECT f FROM Facture f WHERE f.dateFacture = :dateFacture"),
    @NamedQuery(name = "Facture.findByMontantFacture", query = "SELECT f FROM Facture f WHERE f.montantFacture = :montantFacture"),
    @NamedQuery(name = "Facture.findByCodeFacture", query = "SELECT f FROM Facture f WHERE f.codeFacture = :codeFacture")})
public class Facture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdFacture")
    private Integer idFacture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Facture")
    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Montant_Facture")
    private int montantFacture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Code_Facture")
    private String codeFacture;
    @JoinColumn(name = "IdEleve", referencedColumnName = "IdEleve")
    @ManyToOne(optional = false)
    private Eleve idEleve;

    public Facture() {
    }

    public Facture(Integer idFacture) {
        this.idFacture = idFacture;
    }

    public Facture(Integer idFacture, Date dateFacture, int montantFacture, String codeFacture) {
        this.idFacture = idFacture;
        this.dateFacture = dateFacture;
        this.montantFacture = montantFacture;
        this.codeFacture = codeFacture;
    }

    public Integer getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Integer idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public int getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(int montantFacture) {
        this.montantFacture = montantFacture;
    }

    public String getCodeFacture() {
        return codeFacture;
    }

    public void setCodeFacture(String codeFacture) {
        this.codeFacture = codeFacture;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacture != null ? idFacture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.idFacture == null && other.idFacture != null) || (this.idFacture != null && !this.idFacture.equals(other.idFacture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Facture[ idFacture=" + idFacture + " ]";
    }
    
}
