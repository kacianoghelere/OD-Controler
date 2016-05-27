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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "character_journal", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "CharacterJournal.findAll", query = "SELECT c FROM CharacterJournal c"),
    @NamedQuery(name = "CharacterJournal.findByIdcharacterJournal", query = "SELECT c FROM CharacterJournal c WHERE c.idcharacterJournal = :idcharacterJournal"),
    @NamedQuery(name = "CharacterJournal.findByCurrentLevel", query = "SELECT c FROM CharacterJournal c WHERE c.currentLevel = :currentLevel"),
    @NamedQuery(name = "CharacterJournal.findByCurrentExp", query = "SELECT c FROM CharacterJournal c WHERE c.currentExp = :currentExp"),
    @NamedQuery(name = "CharacterJournal.findByIdactive", query = "SELECT c FROM CharacterJournal c WHERE c.idactive = :idactive"),
    @NamedQuery(name = "CharacterJournal.findByIncDate", query = "SELECT c FROM CharacterJournal c WHERE c.incDate = :incDate")})
public class CharacterJournal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcharacter_journal")
    private Long idcharacterJournal;
    @Column(name = "current_level")
    private Integer currentLevel;
    @Column(name = "current_exp")
    private Integer currentExp;
    @Basic(optional = false)
    private boolean idactive;
    @Basic(optional = false)
    @Column(name = "inc_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incDate;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @JoinColumn(name = "idcharacter", referencedColumnName = "idcharacter")
    @ManyToOne(optional = false)
    private CharacterSheet idcharacter;

    public CharacterJournal() {
    }

    public CharacterJournal(Long idcharacterJournal) {
        this.idcharacterJournal = idcharacterJournal;
    }

    public CharacterJournal(Long idcharacterJournal, boolean idactive, Date incDate) {
        this.idcharacterJournal = idcharacterJournal;
        this.idactive = idactive;
        this.incDate = incDate;
    }

    public Long getIdcharacterJournal() {
        return idcharacterJournal;
    }

    public void setIdcharacterJournal(Long idcharacterJournal) {
        this.idcharacterJournal = idcharacterJournal;
    }

    public Integer getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Integer currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Integer getCurrentExp() {
        return currentExp;
    }

    public void setCurrentExp(Integer currentExp) {
        this.currentExp = currentExp;
    }

    public boolean getIdactive() {
        return idactive;
    }

    public void setIdactive(boolean idactive) {
        this.idactive = idactive;
    }

    public Date getIncDate() {
        return incDate;
    }

    public void setIncDate(Date incDate) {
        this.incDate = incDate;
    }

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
    }

    public CharacterSheet getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(CharacterSheet idcharacter) {
        this.idcharacter = idcharacter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcharacterJournal != null ? idcharacterJournal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CharacterJournal)) {
            return false;
        }
        CharacterJournal other = (CharacterJournal) object;
        if ((this.idcharacterJournal == null && other.idcharacterJournal != null) || (this.idcharacterJournal != null && !this.idcharacterJournal.equals(other.idcharacterJournal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.CharacterJournal[ idcharacterJournal=" + idcharacterJournal + " ]";
    }
    
}
