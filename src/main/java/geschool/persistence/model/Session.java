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
import javax.persistence.Id;
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
 * @author xavier_ng
 */
@Entity
@Table(name = "session", catalog = "gestschool", schema = "")
@NamedQueries({
    @NamedQuery(name = "Session.rechercherToutesLesSessions", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.rechercherUneSessionAvecId", query = "SELECT s FROM Session s WHERE s.idSession = :idSession"),
    @NamedQuery(name = "Session.rechercherSessionAvecAnneeDebut", query = "SELECT s FROM Session s WHERE s.anneeDebut = :anneeDebut"),
    @NamedQuery(name = "Session.rechercherSessionAvecAnneeFin", query = "SELECT s FROM Session s WHERE s.anneFin = :anneFin"),
    @NamedQuery(name = "Session.rechercherSessionAvecDateDebut", query = "SELECT s FROM Session s WHERE s.dateDebut = :dateDebut"),
    @NamedQuery(name = "Session.rechercherSessionAvecDateFin", query = "SELECT s FROM Session s WHERE s.dateFin = :dateFin"),
    @NamedQuery(name = "Session.rechercherUneSessionEnCours", query = "SELECT s FROM Session s WHERE s.actif = 1")})
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idSession", nullable = false, length = 45)
    private String idSession;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anneeDebut", nullable = false)
    private int anneeDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anneFin", nullable = false)
    private int anneFin;
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "DateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "actif")
    private Integer actif;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionidSession")
    private List<Sessionclasse> sessionclasseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionidSession")
    private List<Sessiontrimestre> sessiontrimestreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionidSession")
    private List<Sessionenseignant> sessionenseignantList;

    public Session() {
    }

    public Session(String idSession, int anneeDebut, int anneFin) {
        this.idSession = idSession;
        this.anneeDebut = anneeDebut;
        this.anneFin = anneFin;
    }

    public Session(String idSession, int anneeDebut, int anneFin, Date dateDebut, Date dateFin, Integer actif) {
        this.idSession = idSession;
        this.anneeDebut = anneeDebut;
        this.anneFin = anneFin;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.actif = actif;
    }

    public String getIdSession() {
        return idSession;
    }

    public void setIdSession(String idSession) {
        this.idSession = idSession;
    }

    public int getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(int anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public int getAnneFin() {
        return anneFin;
    }

    public void setAnneFin(int anneFin) {
        this.anneFin = anneFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getActif() {
        return actif;
    }

    public void setActif(Integer actif) {
        this.actif = actif;
    }

    public List<Sessionclasse> getSessionclasseList() {
        return sessionclasseList;
    }

    public void setSessionclasseList(List<Sessionclasse> sessionclasseList) {
        this.sessionclasseList = sessionclasseList;
    }

    public List<Sessiontrimestre> getSessiontrimestreList() {
        return sessiontrimestreList;
    }

    public void setSessiontrimestreList(List<Sessiontrimestre> sessiontrimestreList) {
        this.sessiontrimestreList = sessiontrimestreList;
    }

    public List<Sessionenseignant> getSessionenseignantList() {
        return sessionenseignantList;
    }

    public void setSessionenseignantList(List<Sessionenseignant> sessionenseignantList) {
        this.sessionenseignantList = sessionenseignantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSession != null ? idSession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session)) {
            return false;
        }
        Session other = (Session) object;
        if ((this.idSession == null && other.idSession != null) || (this.idSession != null && !this.idSession.equals(other.idSession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "geschool.persistence.model.Session[ idSession=" + idSession + " ]";
    }
    
}
