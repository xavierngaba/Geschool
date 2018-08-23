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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author INES
 */
@Entity
@Table(name = "typereglement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typereglement.findAll", query = "SELECT t FROM Typereglement t"),
    @NamedQuery(name = "Typereglement.findByIdTypeReglement", query = "SELECT t FROM Typereglement t WHERE t.idTypeReglement = :idTypeReglement"),
    @NamedQuery(name = "Typereglement.findByLibelle", query = "SELECT t FROM Typereglement t WHERE t.libelle = :libelle")})
public class Typereglement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTypeReglement")
    private Integer idTypeReglement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regType")
    private List<Reglement> reglementList;

    public Typereglement() {
    }

    public Typereglement(Integer idTypeReglement) {
        this.idTypeReglement = idTypeReglement;
    }

    public Typereglement(Integer idTypeReglement, String libelle) {
        this.idTypeReglement = idTypeReglement;
        this.libelle = libelle;
    }

    public Integer getIdTypeReglement() {
        return idTypeReglement;
    }

    public void setIdTypeReglement(Integer idTypeReglement) {
        this.idTypeReglement = idTypeReglement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<Reglement> getReglementList() {
        return reglementList;
    }

    public void setReglementList(List<Reglement> reglementList) {
        this.reglementList = reglementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeReglement != null ? idTypeReglement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typereglement)) {
            return false;
        }
        Typereglement other = (Typereglement) object;
        if ((this.idTypeReglement == null && other.idTypeReglement != null) || (this.idTypeReglement != null && !this.idTypeReglement.equals(other.idTypeReglement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Typereglement[ idTypeReglement=" + idTypeReglement + " ]";
    }
    
}
