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

/**
 *
 * @author Ines.G
 */
@Entity
@Table(name = "professeur", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Professeur.findAll", query = "SELECT p FROM Professeur p"),
    @NamedQuery(name = "Professeur.findByIdProfesseur", query = "SELECT p FROM Professeur p WHERE p.idProfesseur = :idProfesseur"),
    @NamedQuery(name = "Professeur.findByNomPrenom", query = "SELECT p FROM Professeur p WHERE p.nomPrenom = :nomPrenom"),
    @NamedQuery(name = "Professeur.findByCodeprof", query = "SELECT p FROM Professeur p WHERE p.codeprof = :codeprof")})
public class Professeur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdProfesseur")
    private Integer idProfesseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_prenom")
    private String nomPrenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code_prof")
    private int codeprof;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfesseur")
    private List<Matiere> matiereList;

    public Professeur() {
    }

    public Professeur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public Professeur(Integer idProfesseur, String nomPrenom, int codeprof) {
        this.idProfesseur = idProfesseur;
        this.nomPrenom = nomPrenom;
        this.codeprof = codeprof;
    }

    public Integer getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Integer idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public int getCodeprof() {
        return codeprof;
    }

    public void setCodeprof(int codeprof) {
        this.codeprof = codeprof;
    }

    public List<Matiere> getMatiereList() {
        return matiereList;
    }

    public void setMatiereList(List<Matiere> matiereList) {
        this.matiereList = matiereList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfesseur != null ? idProfesseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.idProfesseur == null && other.idProfesseur != null) || (this.idProfesseur != null && !this.idProfesseur.equals(other.idProfesseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Professeur[ idProfesseur=" + idProfesseur + " ]";
    }
    
}
