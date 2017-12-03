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
@Table(name = "matiere", catalog = "geschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m"),
    @NamedQuery(name = "Matiere.findByIdMatiere", query = "SELECT m FROM Matiere m WHERE m.idMatiere = :idMatiere"),
    @NamedQuery(name = "Matiere.findByDesignation", query = "SELECT m FROM Matiere m WHERE m.designation = :designation"),
    @NamedQuery(name = "Matiere.findByCodmatiere", query = "SELECT m FROM Matiere m WHERE m.codmatiere = :codmatiere")})
public class Matiere implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMatiere")
    private Integer idMatiere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "designation")
    private String designation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod_matiere")
    private int codmatiere;
    @JoinColumn(name = "IdProfesseur", referencedColumnName = "IdProfesseur")
    @ManyToOne(optional = false)
    private Professeur idProfesseur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMatiere", fetch = FetchType.LAZY)
    private List<Matiereclasse> matiereclasseList;

    public Matiere() {
    }

    public Matiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Matiere(Integer idMatiere, String designation, int codmatiere) {
        this.idMatiere = idMatiere;
        this.designation = designation;
        this.codmatiere = codmatiere;
    }

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getCodmatiere() {
        return codmatiere;
    }

    public void setCodmatiere(int codmatiere) {
        this.codmatiere = codmatiere;
    }

    public Professeur getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(Professeur idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatiere != null ? idMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.idMatiere == null && other.idMatiere != null) || (this.idMatiere != null && !this.idMatiere.equals(other.idMatiere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Matiere[ idMatiere=" + idMatiere + " ]";
    }

    public List<Matiereclasse> getMatiereclasseList() {
        return matiereclasseList;
    }

    public void setMatiereclasseList(List<Matiereclasse> matiereclasseList) {
        this.matiereclasseList = matiereclasseList;
    }
    
}
