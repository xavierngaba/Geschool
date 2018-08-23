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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INES
 */
@Entity
@Table(name = "maitre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maitre.findAll", query = "SELECT m FROM Maitre m"),
    @NamedQuery(name = "Maitre.findByMatriculeMaitre", query = "SELECT m FROM Maitre m WHERE m.matriculeMaitre = :matriculeMaitre")})
public class Maitre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MatriculeMaitre")
    private Integer matriculeMaitre;

    public Maitre() {
    }

    public Maitre(Integer matriculeMaitre) {
        this.matriculeMaitre = matriculeMaitre;
    }

    public Integer getMatriculeMaitre() {
        return matriculeMaitre;
    }

    public void setMatriculeMaitre(Integer matriculeMaitre) {
        this.matriculeMaitre = matriculeMaitre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculeMaitre != null ? matriculeMaitre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maitre)) {
            return false;
        }
        Maitre other = (Maitre) object;
        if ((this.matriculeMaitre == null && other.matriculeMaitre != null) || (this.matriculeMaitre != null && !this.matriculeMaitre.equals(other.matriculeMaitre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Maitre[ matriculeMaitre=" + matriculeMaitre + " ]";
    }
    
}
