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
@Table(name = "stats_attribute")
@XmlRootElement
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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "shortname")
    private String shortname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statsAttribute")
    private Collection<BreedAttrModifier> breedAttrModifierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statsAttribute")
    private Collection<OccupationRequirement> occupationRequirementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idkeyAttribute")
    private Collection<Occupation> occupationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idattribute")
    private Collection<Expertise> expertiseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idstatsAttribute")
    private Collection<CharacterStatsAttr> characterStatsAttrCollection;

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

    @XmlTransient
    public Collection<BreedAttrModifier> getBreedAttrModifierCollection() {
        return breedAttrModifierCollection;
    }

    public void setBreedAttrModifierCollection(Collection<BreedAttrModifier> breedAttrModifierCollection) {
        this.breedAttrModifierCollection = breedAttrModifierCollection;
    }

    @XmlTransient
    public Collection<OccupationRequirement> getOccupationRequirementCollection() {
        return occupationRequirementCollection;
    }

    public void setOccupationRequirementCollection(Collection<OccupationRequirement> occupationRequirementCollection) {
        this.occupationRequirementCollection = occupationRequirementCollection;
    }

    @XmlTransient
    public Collection<Occupation> getOccupationCollection() {
        return occupationCollection;
    }

    public void setOccupationCollection(Collection<Occupation> occupationCollection) {
        this.occupationCollection = occupationCollection;
    }

    @XmlTransient
    public Collection<Expertise> getExpertiseCollection() {
        return expertiseCollection;
    }

    public void setExpertiseCollection(Collection<Expertise> expertiseCollection) {
        this.expertiseCollection = expertiseCollection;
    }

    @XmlTransient
    public Collection<CharacterStatsAttr> getCharacterStatsAttrCollection() {
        return characterStatsAttrCollection;
    }

    public void setCharacterStatsAttrCollection(Collection<CharacterStatsAttr> characterStatsAttrCollection) {
        this.characterStatsAttrCollection = characterStatsAttrCollection;
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
