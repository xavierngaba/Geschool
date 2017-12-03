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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author IGNES
 */
@Entity
@Table(name = "note", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n"),
    @NamedQuery(name = "Note.findByIdNote", query = "SELECT n FROM Note n WHERE n.idNote = :idNote"),
    @NamedQuery(name = "Note.findByNote", query = "SELECT n FROM Note n WHERE n.note = :note"),
    @NamedQuery(name = "Note.findByTypeNote", query = "SELECT n FROM Note n WHERE n.typeNote = :typeNote")})
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdNote")
    private Integer idNote;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Note")
    private int note;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Type_Note")
    private String typeNote;
    @JoinColumn(name = "IdEleve", referencedColumnName = "IdEleve")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Eleve idEleve;
    @JoinColumn(name = "IdMatiereClasse", referencedColumnName = "IdMClasse")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Matiereclasse idMatiereClasse;

    public Note() {
    }

    public Note(Integer idNote) {
        this.idNote = idNote;
    }

    public Note(Integer idNote, int note, String typeNote) {
        this.idNote = idNote;
        this.note = note;
        this.typeNote = typeNote;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getTypeNote() {
        return typeNote;
    }

    public void setTypeNote(String typeNote) {
        this.typeNote = typeNote;
    }

    public Eleve getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Eleve idEleve) {
        this.idEleve = idEleve;
    }

    public Matiereclasse getIdMatiereClasse() {
        return idMatiereClasse;
    }

    public void setIdMatiereClasse(Matiereclasse idMatiereClasse) {
        this.idMatiereClasse = idMatiereClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNote != null ? idNote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.idNote == null && other.idNote != null) || (this.idNote != null && !this.idNote.equals(other.idNote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Note[ idNote=" + idNote + " ]";
    }
    
}
