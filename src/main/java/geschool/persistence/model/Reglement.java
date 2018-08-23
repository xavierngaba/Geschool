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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INES
 */
@Entity
@Table(name = "reglement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reglement.findByEleveInscrit", query = "SELECT r FROM Reglement r WHERE r.regMontant != 0"),
    @NamedQuery(name = "Reglement.findByIdEleve", query = "SELECT r FROM Reglement r WHERE r.idEleves.idEleve = :idEleve"),


    @NamedQuery(name = "Reglement.findAll", query = "SELECT r FROM Reglement r"),
    @NamedQuery(name = "Reglement.findByIdReglement", query = "SELECT r FROM Reglement r WHERE r.idReglement = :idReglement"),
    @NamedQuery(name = "Reglement.findByRegCode", query = "SELECT r FROM Reglement r WHERE r.regCode = :regCode"),
    @NamedQuery(name = "Reglement.findByRegDate", query = "SELECT r FROM Reglement r WHERE r.regDate = :regDate"),
    @NamedQuery(name = "Reglement.findByRegMontant", query = "SELECT r FROM Reglement r WHERE r.regMontant = :regMontant"),
    @NamedQuery(name = "Reglement.findByRegref", query = "SELECT r FROM Reglement r WHERE r.regref = :regref"),
    @NamedQuery(name = "Reglement.findByRegCategories", query = "SELECT r FROM Reglement r WHERE r.regCategories = :regCategories")})
public class Reglement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdReglement")
    private Integer idReglement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "Reg_Code")
    private String regCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reg_Date")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Reg_Montant")
    private int regMontant;
    @Size(max = 100)
    @Column(name = "Reg_ref")
    private String regref;
    @Size(max = 100)
    @Column(name = "Reg_Categories")
    private String regCategories;
    @JoinColumn(name = "IdEleves", referencedColumnName = "IdEleve")
    @ManyToOne(optional = false)
    private Eleve idEleves;
    @JoinColumn(name = "Reg_Type", referencedColumnName = "idTypeReglement")
    @ManyToOne(optional = false)
    private Typereglement regType;

    public Reglement() {
    }

    public Reglement(Integer idReglement) {
        this.idReglement = idReglement;
    }

    public Reglement(Integer idReglement, String regCode, Date regDate, int regMontant) {
        this.idReglement = idReglement;
        this.regCode = regCode;
        this.regDate = regDate;
        this.regMontant = regMontant;
    }

    public Integer getIdReglement() {
        return idReglement;
    }

    public void setIdReglement(Integer idReglement) {
        this.idReglement = idReglement;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getRegMontant() {
        return regMontant;
    }

    public void setRegMontant(int regMontant) {
        this.regMontant = regMontant;
    }

    public String getRegref() {
        return regref;
    }

    public void setRegref(String regref) {
        this.regref = regref;
    }

    public String getRegCategories() {
        return regCategories;
    }

    public void setRegCategories(String regCategories) {
        this.regCategories = regCategories;
    }

    public Eleve getIdEleves() {
        return idEleves;
    }

    public void setIdEleves(Eleve idEleves) {
        this.idEleves = idEleves;
    }

    public Typereglement getRegType() {
        return regType;
    }

    public void setRegType(Typereglement regType) {
        this.regType = regType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReglement != null ? idReglement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reglement)) {
            return false;
        }
        Reglement other = (Reglement) object;
        if ((this.idReglement == null && other.idReglement != null) || (this.idReglement != null && !this.idReglement.equals(other.idReglement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Reglement[ idReglement=" + idReglement + " ]";
    }
    
}
