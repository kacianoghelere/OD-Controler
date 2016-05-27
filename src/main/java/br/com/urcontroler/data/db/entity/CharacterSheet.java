/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "character_sheet", catalog = "ultimaterpgtools", schema = "")
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
    private Long idcharacter;
    private String name;
    private Long weight;
    private Long height;
    private Integer age;
    @Lob
    private String description;
    @JoinTable(name = "character_expertise", joinColumns = {
        @JoinColumn(name = "idcharacter", referencedColumnName = "idcharacter")}, inverseJoinColumns = {
        @JoinColumn(name = "expertise_idexpertise", referencedColumnName = "idexpertise")})
    @ManyToMany
    private List<Expertise> expertiseList;
    @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")
    @ManyToOne(optional = false)
    private Breed idbreed;
    @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")
    @ManyToOne(optional = false)
    private Occupation idoccupation;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "characterSheet")
    private List<CampainMembers> campainMembersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcharacter")
    private List<CharacterJournal> characterJournalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcharacter")
    private List<CharacterStatsAttr> characterStatsAttrList;

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

    public List<Expertise> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(List<Expertise> expertiseList) {
        this.expertiseList = expertiseList;
    }

    public Breed getIdbreed() {
        return idbreed;
    }

    public void setIdbreed(Breed idbreed) {
        this.idbreed = idbreed;
    }

    public Occupation getIdoccupation() {
        return idoccupation;
    }

    public void setIdoccupation(Occupation idoccupation) {
        this.idoccupation = idoccupation;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public List<CampainMembers> getCampainMembersList() {
        return campainMembersList;
    }

    public void setCampainMembersList(List<CampainMembers> campainMembersList) {
        this.campainMembersList = campainMembersList;
    }

    public List<CharacterJournal> getCharacterJournalList() {
        return characterJournalList;
    }

    public void setCharacterJournalList(List<CharacterJournal> characterJournalList) {
        this.characterJournalList = characterJournalList;
    }

    public List<CharacterStatsAttr> getCharacterStatsAttrList() {
        return characterStatsAttrList;
    }

    public void setCharacterStatsAttrList(List<CharacterStatsAttr> characterStatsAttrList) {
        this.characterStatsAttrList = characterStatsAttrList;
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
