/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

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

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "stats_attribute", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "StatsAttribute.findAll", query = "SELECT s FROM StatsAttribute s"),
    @NamedQuery(name = "StatsAttribute.findByIdstatsAttribute", query = "SELECT s FROM StatsAttribute s WHERE s.idstatsAttribute = :idstatsAttribute"),
    @NamedQuery(name = "StatsAttribute.findByName", query = "SELECT s FROM StatsAttribute s WHERE s.name = :name"),
    @NamedQuery(name = "StatsAttribute.findByShortname", query = "SELECT s FROM StatsAttribute s WHERE s.shortname = :shortname")})
public class StatsAttribute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstats_attribute")
    private Long idstatsAttribute;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String shortname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkeyAttribute")
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idattribute")
    private List<Expertise> expertiseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statsAttribute")
    private List<OccupationRequirement> occupationRequirementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statsAttribute")
    private List<BreedAttrModifier> breedAttrModifierList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstatsAttribute")
    private List<CharacterStatsAttr> characterStatsAttrList;

    public StatsAttribute() {
    }

    public StatsAttribute(Long idstatsAttribute) {
        this.idstatsAttribute = idstatsAttribute;
    }

    public StatsAttribute(Long idstatsAttribute, String name, String shortname) {
        this.idstatsAttribute = idstatsAttribute;
        this.name = name;
        this.shortname = shortname;
    }

    public Long getIdstatsAttribute() {
        return idstatsAttribute;
    }

    public void setIdstatsAttribute(Long idstatsAttribute) {
        this.idstatsAttribute = idstatsAttribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }

    public List<Expertise> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(List<Expertise> expertiseList) {
        this.expertiseList = expertiseList;
    }

    public List<OccupationRequirement> getOccupationRequirementList() {
        return occupationRequirementList;
    }

    public void setOccupationRequirementList(List<OccupationRequirement> occupationRequirementList) {
        this.occupationRequirementList = occupationRequirementList;
    }

    public List<BreedAttrModifier> getBreedAttrModifierList() {
        return breedAttrModifierList;
    }

    public void setBreedAttrModifierList(List<BreedAttrModifier> breedAttrModifierList) {
        this.breedAttrModifierList = breedAttrModifierList;
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
        hash += (idstatsAttribute != null ? idstatsAttribute.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatsAttribute)) {
            return false;
        }
        StatsAttribute other = (StatsAttribute) object;
        if ((this.idstatsAttribute == null && other.idstatsAttribute != null) || (this.idstatsAttribute != null && !this.idstatsAttribute.equals(other.idstatsAttribute))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.StatsAttribute[ idstatsAttribute=" + idstatsAttribute + " ]";
    }
    
}
