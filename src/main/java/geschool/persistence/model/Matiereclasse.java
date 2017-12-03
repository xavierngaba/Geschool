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
@Table(name = "matiereclasse", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matiereclasse.findAll", query = "SELECT m FROM Matiereclasse m"),
    @NamedQuery(name = "Matiereclasse.findByIdMClasse", query = "SELECT m FROM Matiereclasse m WHERE m.idMClasse = :idMClasse"),
    @NamedQuery(name = "Matiereclasse.findByLibelle", query = "SELECT m FROM Matiereclasse m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "Matiereclasse.findByCoef", query = "SELECT m FROM Matiereclasse m WHERE m.coef = :coef"),
    @NamedQuery(name = "Matiereclasse.findByMatCode", query = "SELECT m FROM Matiereclasse m WHERE m.matCode = :matCode")})
public class Matiereclasse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMClasse")
    private Integer idMClasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Coef")
    private int coef;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mat_Code")
    private int matCode;
    @JoinColumn(name = "IdMatiere", referencedColumnName = "IdMatiere")
    @ManyToOne(optional = false)
    private Matiere idMatiere;
    @JoinColumn(name = "IdClasse", referencedColumnName = "IdClasse")
    @ManyToOne(optional = false)
    private Classe idClasse;

    public Matiereclasse() {
    }

    public Matiereclasse(Integer idMClasse) {
        this.idMClasse = idMClasse;
    }

    public Matiereclasse(Integer idMClasse, String libelle, int coef, int matCode) {
        this.idMClasse = idMClasse;
        this.libelle = libelle;
        this.coef = coef;
        this.matCode = matCode;
    }

    public Integer getIdMClasse() {
        return idMClasse;
    }

    public void setIdMClasse(Integer idMClasse) {
        this.idMClasse = idMClasse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getMatCode() {
        return matCode;
    }

    public void setMatCode(int matCode) {
        this.matCode = matCode;
    }

    public Matiere getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Matiere idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMClasse != null ? idMClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiereclasse)) {
            return false;
        }
        Matiereclasse other = (Matiereclasse) object;
        if ((this.idMClasse == null && other.idMClasse != null) || (this.idMClasse != null && !this.idMClasse.equals(other.idMClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Matiereclasse[ idMClasse=" + idMClasse + " ]";
    }
    
}
