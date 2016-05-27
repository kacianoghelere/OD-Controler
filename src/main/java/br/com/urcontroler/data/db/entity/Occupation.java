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
    @NamedQuery(name = "Occupation.findAll", query = "SELECT o FROM Occupation o"),
    @NamedQuery(name = "Occupation.findByIdoccupation", query = "SELECT o FROM Occupation o WHERE o.idoccupation = :idoccupation"),
    @NamedQuery(name = "Occupation.findByName", query = "SELECT o FROM Occupation o WHERE o.name = :name"),
    @NamedQuery(name = "Occupation.findByArmorBonus", query = "SELECT o FROM Occupation o WHERE o.armorBonus = :armorBonus"),
    @NamedQuery(name = "Occupation.findByDescription", query = "SELECT o FROM Occupation o WHERE o.description = :description"),
    @NamedQuery(name = "Occupation.findByIdrequirement", query = "SELECT o FROM Occupation o WHERE o.idrequirement = :idrequirement")})
public class Occupation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long idoccupation;
    private String name;
    @Basic(optional = false)
    @Column(name = "armor_bonus")
    private int armorBonus;
    private String description;
    @Basic(optional = false)
    private long idrequirement;
    @JoinTable(name = "occupation_allowed_spell_category", joinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")}, inverseJoinColumns = {
        @JoinColumn(name = "idspell_category", referencedColumnName = "idspell_class")})
    @ManyToMany
    private List<SpellClass> spellClassList;
    @ManyToMany(mappedBy = "occupationList")
    private List<ItemType> itemTypeList;
    @ManyToMany(mappedBy = "occupationList")
    private List<ArmorType> armorTypeList;
    @JoinTable(name = "occupation_allowed_weapon_type", joinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")}, inverseJoinColumns = {
        @JoinColumn(name = "idweapon_type", referencedColumnName = "idweapon_type")})
    @ManyToMany
    private List<WeaponType> weaponTypeList;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @JoinColumn(name = "idkey_attribute", referencedColumnName = "idstats_attribute")
    @ManyToOne(optional = false)
    private StatsAttribute idkeyAttribute;
    @JoinColumn(name = "idoccupation_type", referencedColumnName = "idoccupation_type")
    @ManyToOne(optional = false)
    private OccupationType idoccupationType;
    @JoinColumn(name = "idlife_dice", referencedColumnName = "iddice")
    @ManyToOne(optional = false)
    private Dice idlifeDice;
    @JoinColumn(name = "idperk", referencedColumnName = "idperk")
    @ManyToOne(optional = false)
    private Perk idperk;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoccupation")
    private List<CharacterSheet> characterSheetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoccupation")
    private List<OccupationLevel> occupationLevelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private List<OccupationRequirement> occupationRequirementList;

    public Occupation() {
    }

    public Occupation(Long idoccupation) {
        this.idoccupation = idoccupation;
    }

    public Occupation(Long idoccupation, int armorBonus, long idrequirement) {
        this.idoccupation = idoccupation;
        this.armorBonus = armorBonus;
        this.idrequirement = idrequirement;
    }

    public Long getIdoccupation() {
        return idoccupation;
    }

    public void setIdoccupation(Long idoccupation) {
        this.idoccupation = idoccupation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArmorBonus() {
        return armorBonus;
    }

    public void setArmorBonus(int armorBonus) {
        this.armorBonus = armorBonus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdrequirement() {
        return idrequirement;
    }

    public void setIdrequirement(long idrequirement) {
        this.idrequirement = idrequirement;
    }

    public List<SpellClass> getSpellClassList() {
        return spellClassList;
    }

    public void setSpellClassList(List<SpellClass> spellClassList) {
        this.spellClassList = spellClassList;
    }

    public List<ItemType> getItemTypeList() {
        return itemTypeList;
    }

    public void setItemTypeList(List<ItemType> itemTypeList) {
        this.itemTypeList = itemTypeList;
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

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
    }

    public StatsAttribute getIdkeyAttribute() {
        return idkeyAttribute;
    }

    public void setIdkeyAttribute(StatsAttribute idkeyAttribute) {
        this.idkeyAttribute = idkeyAttribute;
    }

    public OccupationType getIdoccupationType() {
        return idoccupationType;
    }

    public void setIdoccupationType(OccupationType idoccupationType) {
        this.idoccupationType = idoccupationType;
    }

    public Dice getIdlifeDice() {
        return idlifeDice;
    }

    public void setIdlifeDice(Dice idlifeDice) {
        this.idlifeDice = idlifeDice;
    }

    public Perk getIdperk() {
        return idperk;
    }

    public void setIdperk(Perk idperk) {
        this.idperk = idperk;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public List<CharacterSheet> getCharacterSheetList() {
        return characterSheetList;
    }

    public void setCharacterSheetList(List<CharacterSheet> characterSheetList) {
        this.characterSheetList = characterSheetList;
    }

    public List<OccupationLevel> getOccupationLevelList() {
        return occupationLevelList;
    }

    public void setOccupationLevelList(List<OccupationLevel> occupationLevelList) {
        this.occupationLevelList = occupationLevelList;
    }

    public List<OccupationRequirement> getOccupationRequirementList() {
        return occupationRequirementList;
    }

    public void setOccupationRequirementList(List<OccupationRequirement> occupationRequirementList) {
        this.occupationRequirementList = occupationRequirementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoccupation != null ? idoccupation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Occupation)) {
            return false;
        }
        Occupation other = (Occupation) object;
        if ((this.idoccupation == null && other.idoccupation != null) || (this.idoccupation != null && !this.idoccupation.equals(other.idoccupation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Occupation[ idoccupation=" + idoccupation + " ]";
    }
    
}
