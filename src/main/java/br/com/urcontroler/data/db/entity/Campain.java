/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaciano Ghelere
 */
@Entity
@Table(name = "campain")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campain.findAll", query = "SELECT c FROM Campain c"),
    @NamedQuery(name = "Campain.findByIdcampain", query = "SELECT c FROM Campain c WHERE c.idcampain = :idcampain"),
    @NamedQuery(name = "Campain.findByTitle", query = "SELECT c FROM Campain c WHERE c.title = :title"),
    @NamedQuery(name = "Campain.findByStartDate", query = "SELECT c FROM Campain c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "Campain.findByConclusionDate", query = "SELECT c FROM Campain c WHERE c.conclusionDate = :conclusionDate")})
public class Campain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcampain")
    private Long idcampain;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "conclusion_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conclusionDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campain")
    private Collection<CampainMembers> campainMembersCollection;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampain")
    private Collection<CampainJournal> campainJournalCollection;

    public Campain() {
    }

    public Campain(Long idcampain) {
        this.idcampain = idcampain;
    }

    public Campain(Long idcampain, String title, Date startDate) {
        this.idcampain = idcampain;
        this.title = title;
        this.startDate = startDate;
    }

    public Long getIdcampain() {
        return idcampain;
    }

    public void setIdcampain(Long idcampain) {
        this.idcampain = idcampain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getConclusionDate() {
        return conclusionDate;
    }

    public void setConclusionDate(Date conclusionDate) {
        this.conclusionDate = conclusionDate;
    }

    @XmlTransient
    public Collection<CampainMembers> getCampainMembersCollection() {
        return campainMembersCollection;
    }

    public void setCampainMembersCollection(Collection<CampainMembers> campainMembersCollection) {
        this.campainMembersCollection = campainMembersCollection;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public Collection<CampainJournal> getCampainJournalCollection() {
        return campainJournalCollection;
    }

    public void setCampainJournalCollection(Collection<CampainJournal> campainJournalCollection) {
        this.campainJournalCollection = campainJournalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampain != null ? idcampain.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campain)) {
            return false;
        }
        Campain other = (Campain) object;
        return !((this.idcampain == null && other.idcampain != null) || (this.idcampain != null && !this.idcampain.equals(other.idcampain)));
    }

    @Override
    public String toString() {
        return "Campain[ idcampain=" + idcampain + " ]";
    }

}
