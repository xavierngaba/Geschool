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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INES
 */
@Entity
@Table(name = "typenote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Typenote.findAll", query = "SELECT t FROM Typenote t"),
    @NamedQuery(name = "Typenote.findByIdTypeNote", query = "SELECT t FROM Typenote t WHERE t.idTypeNote = :idTypeNote"),
    @NamedQuery(name = "Typenote.findByTypeNote", query = "SELECT t FROM Typenote t WHERE t.typeNote = :typeNote")})
public class Typenote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTypeNote")
    private Integer idTypeNote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "TypeNote")
    private String typeNote;

    public Typenote() {
    }

    public Typenote(Integer idTypeNote) {
        this.idTypeNote = idTypeNote;
    }

    public Typenote(Integer idTypeNote, String typeNote) {
        this.idTypeNote = idTypeNote;
        this.typeNote = typeNote;
    }

    public Integer getIdTypeNote() {
        return idTypeNote;
    }

    public void setIdTypeNote(Integer idTypeNote) {
        this.idTypeNote = idTypeNote;
    }

    public String getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(String typeNote) {
        this.typeNote = typeNote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeNote != null ? idTypeNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Typenote)) {
            return false;
        }
        Typenote other = (Typenote) object;
        if ((this.idTypeNote == null && other.idTypeNote != null) || (this.idTypeNote != null && !this.idTypeNote.equals(other.idTypeNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Typenote[ idTypeNote=" + idTypeNote + " ]";
    }
    
}
