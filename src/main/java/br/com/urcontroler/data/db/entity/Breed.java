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
@Table(name = "breed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Breed.findAll", query = "SELECT b FROM Breed b"),
    @NamedQuery(name = "Breed.findByIdbreed", query = "SELECT b FROM Breed b WHERE b.idbreed = :idbreed"),
    @NamedQuery(name = "Breed.findByName", query = "SELECT b FROM Breed b WHERE b.name = :name"),
    @NamedQuery(name = "Breed.findByMinHeight", query = "SELECT b FROM Breed b WHERE b.minHeight = :minHeight"),
    @NamedQuery(name = "Breed.findByMaxHeight", query = "SELECT b FROM Breed b WHERE b.maxHeight = :maxHeight"),
    @NamedQuery(name = "Breed.findByMinWeight", query = "SELECT b FROM Breed b WHERE b.minWeight = :minWeight"),
    @NamedQuery(name = "Breed.findByMaxWeight", query = "SELECT b FROM Breed b WHERE b.maxWeight = :maxWeight"),
    @NamedQuery(name = "Breed.findByMaturity", query = "SELECT b FROM Breed b WHERE b.maturity = :maturity"),
    @NamedQuery(name = "Breed.findByMaxAge", query = "SELECT b FROM Breed b WHERE b.maxAge = :maxAge")})
public class Breed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbreed")
    private Long idbreed;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "min_height")
    private Long minHeight;
    @Column(name = "max_height")
    private Long maxHeight;
    @Column(name = "min_weight")
    private Long minWeight;
    @Column(name = "max_weight")
    private Long maxWeight;
    @Column(name = "maturity")
    private Integer maturity;
    @Column(name = "max_age")
    private Integer maxAge;
    @ManyToMany(mappedBy = "breedCollection")
    private Collection<ArmorType> armorTypeCollection;
    @JoinTable(name = "breed_language", joinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idlanguage_type", referencedColumnName = "idlanguage_type")})
    @ManyToMany
    private Collection<LanguageType> languageTypeCollection;
    @JoinTable(name = "breed_perk", joinColumns = {
        @JoinColumn(name = "idrace", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idperk", referencedColumnName = "idperk")})
    @ManyToMany
    private Collection<Perk> perkCollection;
    @JoinTable(name = "breed_skill", joinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idskill", referencedColumnName = "idskill")})
    @ManyToMany
    private Collection<Skill> skillCollection;
    @JoinTable(name = "breed_allowed_weapon", joinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idweapon_type", referencedColumnName = "idweapon_type")})
    @ManyToMany
    private Collection<WeaponType> weaponTypeCollection;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @JoinColumn(name = "idnative_language", referencedColumnName = "idlanguage_type")
    @ManyToOne(optional = false)
    private LanguageType idnativeLanguage;
    @JoinColumn(name = "iddice", referencedColumnName = "iddice")
    @ManyToOne(optional = false)
    private Dice iddice;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "breed")
    private Collection<BreedAttrModifier> breedAttrModifierCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbreed")
    private Collection<CharacterSheet> characterSheetCollection;

    public Breed() {
    }

    public Breed(Long idbreed) {
        this.idbreed = idbreed;
    }

    public Breed(Long idbreed, String name) {
        this.idbreed = idbreed;
        this.name = name;
    }

    public Long getIdbreed() {
        return idbreed;
    }

    public void setIdbreed(Long idbreed) {
        this.idbreed = idbreed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(Long minHeight) {
        this.minHeight = minHeight;
    }

    public Long getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(Long maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Long getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(Long minWeight) {
        this.minWeight = minWeight;
    }

    public Long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Integer getMaturity() {
        return maturity;
    }

    public void setMaturity(Integer maturity) {
        this.maturity = maturity;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    @XmlTransient
    public Collection<ArmorType> getArmorTypeCollection() {
        return armorTypeCollection;
    }

    public void setArmorTypeCollection(Collection<ArmorType> armorTypeCollection) {
        this.armorTypeCollection = armorTypeCollection;
    }

    @XmlTransient
    public Collection<LanguageType> getLanguageTypeCollection() {
        return languageTypeCollection;
    }

    public void setLanguageTypeCollection(Collection<LanguageType> languageTypeCollection) {
        this.languageTypeCollection = languageTypeCollection;
    }

    @XmlTransient
    public Collection<Perk> getPerkCollection() {
        return perkCollection;
    }

    public void setPerkCollection(Collection<Perk> perkCollection) {
        this.perkCollection = perkCollection;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    @XmlTransient
    public Collection<WeaponType> getWeaponTypeCollection() {
        return weaponTypeCollection;
    }

    public void setWeaponTypeCollection(Collection<WeaponType> weaponTypeCollection) {
        this.weaponTypeCollection = weaponTypeCollection;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public LanguageType getIdnativeLanguage() {
        return idnativeLanguage;
    }

    public void setIdnativeLanguage(LanguageType idnativeLanguage) {
        this.idnativeLanguage = idnativeLanguage;
    }

    public Dice getIddice() {
        return iddice;
    }

    public void setIddice(Dice iddice) {
        this.iddice = iddice;
    }

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
    }

    @XmlTransient
    public Collection<BreedAttrModifier> getBreedAttrModifierCollection() {
        return breedAttrModifierCollection;
    }

    public void setBreedAttrModifierCollection(Collection<BreedAttrModifier> breedAttrModifierCollection) {
        this.breedAttrModifierCollection = breedAttrModifierCollection;
    }

    @XmlTransient
    public Collection<CharacterSheet> getCharacterSheetCollection() {
        return characterSheetCollection;
    }

    public void setCharacterSheetCollection(Collection<CharacterSheet> characterSheetCollection) {
        this.characterSheetCollection = characterSheetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbreed != null ? idbreed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Breed)) {
            return false;
        }
        Breed other = (Breed) object;
        if ((this.idbreed == null && other.idbreed != null) || (this.idbreed != null && !this.idbreed.equals(other.idbreed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Breed[ idbreed=" + idbreed + " ]";
    }

}
