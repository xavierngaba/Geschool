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
@Table(name = "statuteleve", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Statuteleve.findAll", query = "SELECT s FROM Statuteleve s"),
    @NamedQuery(name = "Statuteleve.findByIdStatutEleve", query = "SELECT s FROM Statuteleve s WHERE s.idStatutEleve = :idStatutEleve"),
    @NamedQuery(name = "Statuteleve.findByLibelleStatutEleve", query = "SELECT s FROM Statuteleve s WHERE s.libelleStatutEleve = :libelleStatutEleve")})
public class Statuteleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idStatutEleve", nullable = false)
    private Integer idStatutEleve;
    @Size(max = 45)
    @Column(name = "libelleStatutEleve", length = 45)
    private String libelleStatutEleve;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statutEleveidStatutEleve")
    private List<Suivistatuteleve> suivistatuteleveList;

    public Statuteleve() {
    }

    public Integer getIdStatutEleve() {
        return idStatutEleve;
    }

    public void setIdStatutEleve(Integer idStatutEleve) {
        this.idStatutEleve = idStatutEleve;
    }

    public String getLibelleStatutEleve() {
        return libelleStatutEleve;
    }

    public void setLibelleStatutEleve(String libelleStatutEleve) {
        this.libelleStatutEleve = libelleStatutEleve;
    }

    public List<Suivistatuteleve> getSuivistatuteleveList() {
        return suivistatuteleveList;
    }

    public void setSuivistatuteleveList(List<Suivistatuteleve> suivistatuteleveList) {
        this.suivistatuteleveList = suivistatuteleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStatutEleve != null ? idStatutEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statuteleve)) {
            return false;
        }
        Statuteleve other = (Statuteleve) object;
        if ((this.idStatutEleve == null && other.idStatutEleve != null) || (this.idStatutEleve != null && !this.idStatutEleve.equals(other.idStatutEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Statuteleve[ idStatutEleve=" + idStatutEleve + " ]";
    }
    
}
