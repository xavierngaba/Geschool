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
@Table(name = "tuteur", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tuteur.rechercherTousLesTuteurs", query = "SELECT t FROM Tuteur t"),
    @NamedQuery(name = "Tuteur.rechercherTuteurAvecId", query = "SELECT t FROM Tuteur t WHERE t.idTuteur = :idTuteur"),
    @NamedQuery(name = "Tuteur.rechercherLeDernierTuteurAjoute", query = "SELECT MAX(t.idTuteur) FROM Tuteur t"),
    @NamedQuery(name = "Tuteur.rechercherTuteurAvecTutCode", query = "SELECT t FROM Tuteur t WHERE t.tutCode = :tutCode")})
public class Tuteur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdTuteur")
    private Integer idTuteur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tut_code")
    private String tutCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_prenom")
    private String nomPrenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Adresse")
    private String adresse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Relation")
    private String relation;
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "profession")
    private String profession;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTuteur")
    private List<Eleve> eleveList;

    public Tuteur() {
    }

    public Integer getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Integer idTuteur) {
        this.idTuteur = idTuteur;
    }

    public String getTutCode() {
        return tutCode;
    }

    public void setTutCode(String tutCode) {
        this.tutCode = tutCode;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<Eleve> getEleveList() {
        return eleveList;
    }

    public void setEleveList(List<Eleve> eleveList) {
        this.eleveList = eleveList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTuteur != null ? idTuteur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tuteur)) {
            return false;
        }
        Tuteur other = (Tuteur) object;
        if ((this.idTuteur == null && other.idTuteur != null) || (this.idTuteur != null && !this.idTuteur.equals(other.idTuteur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tuteur[ idTuteur=" + idTuteur + " ]";
    }
}
