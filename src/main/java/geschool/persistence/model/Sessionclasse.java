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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier_ng
 */
@Entity
@Table(name = "sessionclasse", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Sessionclasse.rechercherLesClassesParSession", query = "SELECT s FROM Sessionclasse s where s.sessionidSession.idSession = :idSession"),
    @NamedQuery(name = "Sessionclasse.rechercherSessionClasseParId", query = "SELECT s FROM Sessionclasse s WHERE s.idSessionClasse = :idSessionClasse")})
public class Sessionclasse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSessionClasse", nullable = false)
    private Integer idSessionClasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionClasseidSessionClasse")
    private List<Suivisessionclasseeleve> suivisessionclasseeleveList;
    @JoinColumn(name = "Classe_idClasse", referencedColumnName = "idClasse", nullable = false)
    @ManyToOne(optional = false)
    private Classe classeidClasse;
    @JoinColumn(name = "Session_idSession", referencedColumnName = "idSession", nullable = false)
    @ManyToOne(optional = false)
    private Session sessionidSession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionClasseidSessionClasse")
    private List<Suivisessionclassematiere> suivisessionclassematiereList;

    public Sessionclasse() {
    }

    public Integer getIdSessionClasse() {
        return idSessionClasse;
    }

    public void setIdSessionClasse(Integer idSessionClasse) {
        this.idSessionClasse = idSessionClasse;
    }

    public List<Suivisessionclasseeleve> getSuivisessionclasseeleveList() {
        return suivisessionclasseeleveList;
    }

    public void setSuivisessionclasseeleveList(List<Suivisessionclasseeleve> suivisessionclasseeleveList) {
        this.suivisessionclasseeleveList = suivisessionclasseeleveList;
    }

    public Classe getClasseidClasse() {
        return classeidClasse;
    }

    public void setClasseidClasse(Classe classeidClasse) {
        this.classeidClasse = classeidClasse;
    }

    public Session getSessionidSession() {
        return sessionidSession;
    }

    public void setSessionidSession(Session sessionidSession) {
        this.sessionidSession = sessionidSession;
    }

    public List<Suivisessionclassematiere> getSuivisessionclassematiereList() {
        return suivisessionclassematiereList;
    }

    public void setSuivisessionclassematiereList(List<Suivisessionclassematiere> suivisessionclassematiereList) {
        this.suivisessionclassematiereList = suivisessionclassematiereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSessionClasse != null ? idSessionClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sessionclasse)) {
            return false;
        }
        Sessionclasse other = (Sessionclasse) object;
        if ((this.idSessionClasse == null && other.idSessionClasse != null) || (this.idSessionClasse != null && !this.idSessionClasse.equals(other.idSessionClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Sessionclasse[ idSessionClasse=" + idSessionClasse + " ]";
    }
    
}
