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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author INES
 */
@Entity
@Table(name = "classe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classe.rechercherToutesLesClasses", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.rechercherClasseParId", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse"),
    @NamedQuery(name = "Classe.rechercherClasseParLibelleClasse", query = "SELECT c FROM Classe c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Classe.verifierLibelleClasse", query = "SELECT COUNT(c) FROM Classe c WHERE c.libelle = :libelleClasse"),
    @NamedQuery(name = "Classe.findByClasseCode", query = "SELECT c FROM Classe c WHERE c.classeCode = :classeCode"),
    @NamedQuery(name = "Classe.findAll", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.findByIdClasse", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse"),
    @NamedQuery(name = "Classe.findByLibelle", query = "SELECT c FROM Classe c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Classe.findByMontant", query = "SELECT c FROM Classe c WHERE c.montant = :montant"),
    @NamedQuery(name = "Classe.findByClasseCode", query = "SELECT c FROM Classe c WHERE c.classeCode = :classeCode")})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdClasse")
    private Integer idClasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Montant")
    private int montant;
    @Size(max = 25)
    @Column(name = "Classe_Code")
    private String classeCode;
    @JoinColumn(name = "IdGroupe", referencedColumnName = "IdGroupe")
    @ManyToOne
    private Groupe idGroupe;

    public Classe() {
    }

    public Classe(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public Classe(Integer idClasse, String libelle, int montant) {
        this.idClasse = idClasse;
        this.libelle = libelle;
        this.montant = montant;
    }

    public Integer getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Integer idClasse) {
        this.idClasse = idClasse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getClasseCode() {
        return classeCode;
    }

    public void setClasseCode(String classeCode) {
        this.classeCode = classeCode;
    }

    public Groupe getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Groupe idGroupe) {
        this.idGroupe = idGroupe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClasse != null ? idClasse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classe)) {
            return false;
        }
        Classe other = (Classe) object;
        if ((this.idClasse == null && other.idClasse != null) || (this.idClasse != null && !this.idClasse.equals(other.idClasse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Classe[ idClasse=" + idClasse + " ]";
    }
    
}
