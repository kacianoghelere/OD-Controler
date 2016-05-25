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
@Table(name = "occupation")
@XmlRootElement
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
    @Column(name = "idoccupation")
    private Long idoccupation;
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "armor_bonus")
    private int armorBonus;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "idrequirement")
    private long idrequirement;
    @JoinTable(name = "occupation_allowed_weapon_type", joinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")}, inverseJoinColumns = {
        @JoinColumn(name = "idweapon_type", referencedColumnName = "idweapon_type")})
    @ManyToMany
    private Collection<WeaponType> weaponTypeCollection;
    @JoinTable(name = "occupation_allowed_spell_category", joinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")}, inverseJoinColumns = {
        @JoinColumn(name = "idspell_category", referencedColumnName = "idspell_class")})
    @ManyToMany
    private Collection<SpellClass> spellClassCollection;
    @ManyToMany(mappedBy = "occupationCollection")
    private Collection<ItemType> itemTypeCollection;
    @ManyToMany(mappedBy = "occupationCollection")
    private Collection<ArmorType> armorTypeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "occupation")
    private Collection<OccupationRequirement> occupationRequirementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoccupation")
    private Collection<OccupationLevel> occupationLevelCollection;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @JoinColumn(name = "idperk", referencedColumnName = "idperk")
    @ManyToOne(optional = false)
    private Perk idperk;
    @JoinColumn(name = "idlife_dice", referencedColumnName = "iddice")
    @ManyToOne(optional = false)
    private Dice idlifeDice;
    @JoinColumn(name = "idoccupation_type", referencedColumnName = "idoccupation_type")
    @ManyToOne(optional = false)
    private OccupationType idoccupationType;
    @JoinColumn(name = "idkey_attribute", referencedColumnName = "idstats_attribute")
    @ManyToOne(optional = false)
    private StatsAttribute idkeyAttribute;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoccupation")
    private Collection<CharacterSheet> characterSheetCollection;

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

    @XmlTransient
    public Collection<WeaponType> getWeaponTypeCollection() {
        return weaponTypeCollection;
    }

    public void setWeaponTypeCollection(Collection<WeaponType> weaponTypeCollection) {
        this.weaponTypeCollection = weaponTypeCollection;
    }

    @XmlTransient
    public Collection<SpellClass> getSpellClassCollection() {
        return spellClassCollection;
    }

    public void setSpellClassCollection(Collection<SpellClass> spellClassCollection) {
        this.spellClassCollection = spellClassCollection;
    }

    @XmlTransient
    public Collection<ItemType> getItemTypeCollection() {
        return itemTypeCollection;
    }

    public void setItemTypeCollection(Collection<ItemType> itemTypeCollection) {
        this.itemTypeCollection = itemTypeCollection;
    }

    @XmlTransient
    public Collection<ArmorType> getArmorTypeCollection() {
        return armorTypeCollection;
    }

    public void setArmorTypeCollection(Collection<ArmorType> armorTypeCollection) {
        this.armorTypeCollection = armorTypeCollection;
    }

    @XmlTransient
    public Collection<OccupationRequirement> getOccupationRequirementCollection() {
        return occupationRequirementCollection;
    }

    public void setOccupationRequirementCollection(Collection<OccupationRequirement> occupationRequirementCollection) {
        this.occupationRequirementCollection = occupationRequirementCollection;
    }

    @XmlTransient
    public Collection<OccupationLevel> getOccupationLevelCollection() {
        return occupationLevelCollection;
    }

    public void setOccupationLevelCollection(Collection<OccupationLevel> occupationLevelCollection) {
        this.occupationLevelCollection = occupationLevelCollection;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public Perk getIdperk() {
        return idperk;
    }

    public void setIdperk(Perk idperk) {
        this.idperk = idperk;
    }

    public Dice getIdlifeDice() {
        return idlifeDice;
    }

    public void setIdlifeDice(Dice idlifeDice) {
        this.idlifeDice = idlifeDice;
    }

    public OccupationType getIdoccupationType() {
        return idoccupationType;
    }

    public void setIdoccupationType(OccupationType idoccupationType) {
        this.idoccupationType = idoccupationType;
    }

    public StatsAttribute getIdkeyAttribute() {
        return idkeyAttribute;
    }

    public void setIdkeyAttribute(StatsAttribute idkeyAttribute) {
        this.idkeyAttribute = idkeyAttribute;
    }

    public Alignment getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Alignment idalignment) {
        this.idalignment = idalignment;
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
