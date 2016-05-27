/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author kaciano
 */
@Entity
@Table(catalog = "ultimaterpgtools", schema = "")
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
    private Long idcampain;
    @Basic(optional = false)
    private String title;
    @Lob
    private String description;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "conclusion_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conclusionDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campain")
    private List<CampainMembers> campainMembersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcampain")
    private List<CampainJournal> campainJournalList;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;

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

    public List<CampainMembers> getCampainMembersList() {
        return campainMembersList;
    }

    public void setCampainMembersList(List<CampainMembers> campainMembersList) {
        this.campainMembersList = campainMembersList;
    }

    public List<CampainJournal> getCampainJournalList() {
        return campainJournalList;
    }

    public void setCampainJournalList(List<CampainJournal> campainJournalList) {
        this.campainJournalList = campainJournalList;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
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
        if ((this.idcampain == null && other.idcampain != null) || (this.idcampain != null && !this.idcampain.equals(other.idcampain))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Campain[ idcampain=" + idcampain + " ]";
    }
    
}
