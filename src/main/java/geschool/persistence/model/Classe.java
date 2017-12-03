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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ines.G
 */
@Entity
@Table(name = "classe", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Classe.rechercherToutesLesClasses", query = "SELECT c FROM Classe c"),
    @NamedQuery(name = "Classe.rechercherClasseParId", query = "SELECT c FROM Classe c WHERE c.idClasse = :idClasse"),
    @NamedQuery(name = "Classe.rechercherClasseParLibelleClasse", query = "SELECT c FROM Classe c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Classe.verifierLibelleClasse", query = "SELECT COUNT(c) FROM Classe c WHERE c.libelle = :libelleClasse"),
    @NamedQuery(name = "Classe.findByClasseCode", query = "SELECT c FROM Classe c WHERE c.classeCode = :classeCode")})
public class Classe implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse", fetch = FetchType.LAZY)
    private List<Matiereclasse> matiereclasseList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "IdClasse")
    private Integer idClasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Libelle")
    private String libelle;
    @Size(min = 1, max = 25)
    @Column(name = "Classe_Code")
    private String classeCode;
    @JoinColumn(name = "IdGroupe", referencedColumnName = "IdGroupe")
    @ManyToOne(optional = false)
    private Groupe idGroupe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClasse")
    private List<Inscrit> inscritList;

    public Classe() {
    }

    public Classe(Integer idClasse, String libelle) {
        this.idClasse = idClasse;
        this.libelle = libelle;
    }

    public Classe(Integer idClasse, String libelle, String classeCode) {
        this.idClasse = idClasse;
        this.libelle = libelle;
        this.classeCode = classeCode;
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

    public List<Inscrit> getInscritList() {
        return inscritList;
    }

    public void setInscritList(List<Inscrit> inscritList) {
        this.inscritList = inscritList;
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

    public List<Matiereclasse> getMatiereclasseList() {
        return matiereclasseList;
    }

    public void setMatiereclasseList(List<Matiereclasse> matiereclasseList) {
        this.matiereclasseList = matiereclasseList;
    }
    
}
