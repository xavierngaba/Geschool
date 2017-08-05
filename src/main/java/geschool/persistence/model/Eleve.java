/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geschool.persistence.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ines.G
 */
@Entity
@Table(name = "eleve", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e"),
    @NamedQuery(name = "Eleve.findByIdEleve", query = "SELECT e FROM Eleve e WHERE e.idEleve = :idEleve"),
    @NamedQuery(name = "Eleve.findByMatricule", query = "SELECT e FROM Eleve e WHERE e.matricule = :matricule"),
    @NamedQuery(name = "Eleve.findByNom", query = "SELECT e FROM Eleve e WHERE e.nom = :nom"),
    @NamedQuery(name = "Eleve.findByPrenom", query = "SELECT e FROM Eleve e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Eleve.findByDateNaiss", query = "SELECT e FROM Eleve e WHERE e.dateNaiss = :dateNaiss"),
    @NamedQuery(name = "Eleve.findByAdresses", query = "SELECT e FROM Eleve e WHERE e.adresses = :adresses"),
    @NamedQuery(name = "Eleve.findByTelephone", query = "SELECT e FROM Eleve e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Eleve.findByDette", query = "SELECT e FROM Eleve e WHERE e.dette = :dette"),
    @NamedQuery(name = "Eleve.findByStatus", query = "SELECT e FROM Eleve e WHERE e.status = :status"),
    @NamedQuery(name = "Eleve.findByQuantine", query = "SELECT e FROM Eleve e WHERE e.quantine = :quantine"),
    @NamedQuery(name = "Eleve.findByNationalite", query = "SELECT e FROM Eleve e WHERE e.nationalite = :nationalite"),
    @NamedQuery(name = "Eleve.findBySexe", query = "SELECT e FROM Eleve e WHERE e.sexe = :sexe"),
    @NamedQuery(name = "Eleve.findByEmail", query = "SELECT e FROM Eleve e WHERE e.email = :email"),
    @NamedQuery(name = "Eleve.findByDateinscription", query = "SELECT e FROM Eleve e WHERE e.dateinscription = :dateinscription")})
public class Eleve implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEleve")
    private Integer idEleve;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Naiss")
    @Temporal(TemporalType.DATE)
    private Date dateNaiss;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "adresses")
    private String adresses;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dette")
    private int dette;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantine")
    private int quantine;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nationalite")
    private String nationalite;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sexe")
    private String sexe;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_inscription")
    @Temporal(TemporalType.DATE)
    private Date dateinscription;
    @JoinColumn(name = "IdTuteur", referencedColumnName = "IdTuteur")
    @ManyToOne(optional = false)
    private Tuteur idTuteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEleve")
    private List<Inscrit> inscritList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEleves")
    private List<Reglement> reglementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEleve")
    private List<Facture> factureList;

    public Eleve() {
    }

    public Eleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public Eleve(Integer idEleve, String matricule, String nom, String prenom, Date dateNaiss, String adresses, String telephone, int dette, String status, int quantine, String nationalite, String sexe, String email, Date dateinscription) {
        this.idEleve = idEleve;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaiss = dateNaiss;
        this.adresses = adresses;
        this.telephone = telephone;
        this.dette = dette;
        this.status = status;
        this.quantine = quantine;
        this.nationalite = nationalite;
        this.sexe = sexe;
        this.email = email;
        this.dateinscription = dateinscription;
    }

    public Integer getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Integer idEleve) {
        this.idEleve = idEleve;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getAdresses() {
        return adresses;
    }

    public void setAdresses(String adresses) {
        this.adresses = adresses;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getDette() {
        return dette;
    }

    public void setDette(int dette) {
        this.dette = dette;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantine() {
        return quantine;
    }

    public void setQuantine(int quantine) {
        this.quantine = quantine;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    public Tuteur getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(Tuteur idTuteur) {
        this.idTuteur = idTuteur;
    }

    public List<Inscrit> getInscritList() {
        return inscritList;
    }

    public void setInscritList(List<Inscrit> inscritList) {
        this.inscritList = inscritList;
    }

    public List<Reglement> getReglementList() {
        return reglementList;
    }

    public void setReglementList(List<Reglement> reglementList) {
        this.reglementList = reglementList;
    }

    public List<Facture> getFactureList() {
        return factureList;
    }

    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEleve != null ? idEleve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.idEleve == null && other.idEleve != null) || (this.idEleve != null && !this.idEleve.equals(other.idEleve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Eleve[ idEleve=" + idEleve + " ]";
    }
    
}
