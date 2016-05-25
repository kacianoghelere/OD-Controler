/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaciano Ghelere
 */
@Entity
@Table(name = "character_sheet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CharacterSheet.findAll", query = "SELECT c FROM CharacterSheet c"),
    @NamedQuery(name = "CharacterSheet.findByIdcharacter", query = "SELECT c FROM CharacterSheet c WHERE c.idcharacter = :idcharacter"),
    @NamedQuery(name = "CharacterSheet.findByName", query = "SELECT c FROM CharacterSheet c WHERE c.name = :name"),
    @NamedQuery(name = "CharacterSheet.findByWeight", query = "SELECT c FROM CharacterSheet c WHERE c.weight = :weight"),
    @NamedQuery(name = "CharacterSheet.findByHeight", query = "SELECT c FROM CharacterSheet c WHERE c.height = :height"),
    @NamedQuery(name = "CharacterSheet.findByAge", query = "SELECT c FROM CharacterSheet c WHERE c.age = :age")})
public class CharacterSheet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcharacter")
    private Long idcharacter;
    @Column(name = "name")
    private String name;
    @Column(name = "weight")
    private Long weight;
    @Column(name = "height")
    private Long height;
    @Column(name = "age")
    private Integer age;
    @Lob
    @Column(name = "description")
    private String description;
    @JoinTable(name = "character_expertise", joinColumns = {
        @JoinColumn(name = "idcharacter", referencedColumnName = "idcharacter")}, inverseJoinColumns = {
        @JoinColumn(name = "expertise_idexpertise", referencedColumnName = "idexpertise")})
    @ManyToMany
    private Collection<Expertise> expertiseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterSheet")
    private Collection<CampainMembers> campainMembersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcharacter")
    private Collection<CharacterJournal> characterJournalCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcharacter")
    private Collection<CharacterStatsAttr> characterStatsAttrCollection;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")
    @ManyToOne(optional = false)
    private Occupation idoccupation;
    @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")
    @ManyToOne(optional = false)
    private Breed idbreed;

    public CharacterSheet() {
    }

    public CharacterSheet(Long idcharacter) {
        this.idcharacter = idcharacter;
    }

    public Long getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(Long idcharacter) {
        this.idcharacter = idcharacter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Expertise> getExpertiseCollection() {
        return expertiseCollection;
    }

    public void setExpertiseCollection(Collection<Expertise> expertiseCollection) {
        this.expertiseCollection = expertiseCollection;
    }

    @XmlTransient
    public Collection<CampainMembers> getCampainMembersCollection() {
        return campainMembersCollection;
    }

    public void setCampainMembersCollection(Collection<CampainMembers> campainMembersCollection) {
        this.campainMembersCollection = campainMembersCollection;
    }

    @XmlTransient
    public Collection<CharacterJournal> getCharacterJournalCollection() {
        return characterJournalCollection;
    }

    public void setCharacterJournalCollection(Collection<CharacterJournal> characterJournalCollection) {
        this.characterJournalCollection = characterJournalCollection;
    }

    @XmlTransient
    public Collection<CharacterStatsAttr> getCharacterStatsAttrCollection() {
        return characterStatsAttrCollection;
    }

    public void setCharacterStatsAttrCollection(Collection<CharacterStatsAttr> characterStatsAttrCollection) {
        this.characterStatsAttrCollection = characterStatsAttrCollection;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Occupation getIdoccupation() {
        return idoccupation;
    }

    public void setIdoccupation(Occupation idoccupation) {
        this.idoccupation = idoccupation;
    }

    public Breed getIdbreed() {
        return idbreed;
    }

    public void setIdbreed(Breed idbreed) {
        this.idbreed = idbreed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcharacter != null ? idcharacter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CharacterSheet)) {
            return false;
        }
        CharacterSheet other = (CharacterSheet) object;
        if ((this.idcharacter == null && other.idcharacter != null) || (this.idcharacter != null && !this.idcharacter.equals(other.idcharacter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.CharacterSheet[ idcharacter=" + idcharacter + " ]";
    }

}
