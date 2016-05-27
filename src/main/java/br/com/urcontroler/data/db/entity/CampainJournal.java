/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "campain_journal", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "CampainJournal.findAll", query = "SELECT c FROM CampainJournal c"),
    @NamedQuery(name = "CampainJournal.findByIdcampainJournal", query = "SELECT c FROM CampainJournal c WHERE c.idcampainJournal = :idcampainJournal"),
    @NamedQuery(name = "CampainJournal.findByDescription", query = "SELECT c FROM CampainJournal c WHERE c.description = :description"),
    @NamedQuery(name = "CampainJournal.findByIdactive", query = "SELECT c FROM CampainJournal c WHERE c.idactive = :idactive"),
    @NamedQuery(name = "CampainJournal.findByLogDate", query = "SELECT c FROM CampainJournal c WHERE c.logDate = :logDate")})
public class CampainJournal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcampain_journal")
    private Long idcampainJournal;
    private String description;
    @Basic(optional = false)
    private boolean idactive;
    @Basic(optional = false)
    @Column(name = "log_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    @JoinColumn(name = "idcampain", referencedColumnName = "idcampain")
    @ManyToOne(optional = false)
    private Campain idcampain;

    public CampainJournal() {
    }

    public CampainJournal(Long idcampainJournal) {
        this.idcampainJournal = idcampainJournal;
    }

    public CampainJournal(Long idcampainJournal, boolean idactive, Date logDate) {
        this.idcampainJournal = idcampainJournal;
        this.idactive = idactive;
        this.logDate = logDate;
    }

    public Long getIdcampainJournal() {
        return idcampainJournal;
    }

    public void setIdcampainJournal(Long idcampainJournal) {
        this.idcampainJournal = idcampainJournal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIdactive() {
        return idactive;
    }

    public void setIdactive(boolean idactive) {
        this.idactive = idactive;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Campain getIdcampain() {
        return idcampain;
    }

    public void setIdcampain(Campain idcampain) {
        this.idcampain = idcampain;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampainJournal != null ? idcampainJournal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampainJournal)) {
            return false;
        }
        CampainJournal other = (CampainJournal) object;
        if ((this.idcampainJournal == null && other.idcampainJournal != null) || (this.idcampainJournal != null && !this.idcampainJournal.equals(other.idcampainJournal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.CampainJournal[ idcampainJournal=" + idcampainJournal + " ]";
    }
    
}
