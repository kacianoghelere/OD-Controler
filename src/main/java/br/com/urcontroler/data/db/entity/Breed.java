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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(catalog = "ultimaterpgtools", schema = "")
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
    private Long idbreed;
    @Basic(optional = false)
    private String name;
    @Column(name = "min_height")
    private Long minHeight;
    @Column(name = "max_height")
    private Long maxHeight;
    @Column(name = "min_weight")
    private Long minWeight;
    @Column(name = "max_weight")
    private Long maxWeight;
    private Integer maturity;
    @Column(name = "max_age")
    private Integer maxAge;
    @JoinTable(name = "breed_perk", joinColumns = {
        @JoinColumn(name = "idrace", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idperk", referencedColumnName = "idperk")})
    @ManyToMany
    private List<Perk> perkList;
    @ManyToMany(mappedBy = "breedList")
    private List<ArmorType> armorTypeList;
    @JoinTable(name = "breed_allowed_weapon", joinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idweapon_type", referencedColumnName = "idweapon_type")})
    @ManyToMany
    private List<WeaponType> weaponTypeList;
    @JoinTable(name = "breed_language", joinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idlanguage_type", referencedColumnName = "idlanguage_type")})
    @ManyToMany
    private List<LanguageType> languageTypeList;
    @JoinTable(name = "breed_skill", joinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")}, inverseJoinColumns = {
        @JoinColumn(name = "idskill", referencedColumnName = "idskill")})
    @ManyToMany
    private List<Skill> skillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbreed")
    private List<CharacterSheet> characterSheetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "breed")
    private List<BreedAttrModifier> breedAttrModifierList;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @JoinColumn(name = "iddice", referencedColumnName = "iddice")
    @ManyToOne(optional = false)
    private Dice iddice;
    @JoinColumn(name = "idnative_language", referencedColumnName = "idlanguage_type")
    @ManyToOne(optional = false)
    private LanguageType idnativeLanguage;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;

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

    public List<Perk> getPerkList() {
        return perkList;
    }

    public void setPerkList(List<Perk> perkList) {
        this.perkList = perkList;
    }

    public List<ArmorType> getArmorTypeList() {
        return armorTypeList;
    }

    public void setArmorTypeList(List<ArmorType> armorTypeList) {
        this.armorTypeList = armorTypeList;
    }

    public List<WeaponType> getWeaponTypeList() {
        return weaponTypeList;
    }

    public void setWeaponTypeList(List<WeaponType> weaponTypeList) {
        this.weaponTypeList = weaponTypeList;
    }

    public List<LanguageType> getLanguageTypeList() {
        return languageTypeList;
    }

    public void setLanguageTypeList(List<LanguageType> languageTypeList) {
        this.languageTypeList = languageTypeList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<CharacterSheet> getCharacterSheetList() {
        return characterSheetList;
    }

    public void setCharacterSheetList(List<CharacterSheet> characterSheetList) {
        this.characterSheetList = characterSheetList;
    }

    public List<BreedAttrModifier> getBreedAttrModifierList() {
        return breedAttrModifierList;
    }

    public void setBreedAttrModifierList(List<BreedAttrModifier> breedAttrModifierList) {
        this.breedAttrModifierList = breedAttrModifierList;
    }

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
    }

    public Dice getIddice() {
        return iddice;
    }

    public void setIddice(Dice iddice) {
        this.iddice = iddice;
    }

    public LanguageType getIdnativeLanguage() {
        return idnativeLanguage;
    }

    public void setIdnativeLanguage(LanguageType idnativeLanguage) {
        this.idnativeLanguage = idnativeLanguage;
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
