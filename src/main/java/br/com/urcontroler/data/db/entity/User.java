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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIduser", query = "SELECT u FROM User u WHERE u.iduser = :iduser"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @NamedQuery(name = "User.findByPass", query = "SELECT u FROM User u WHERE u.pass = :pass"),
    @NamedQuery(name = "User.findByIncDate", query = "SELECT u FROM User u WHERE u.incDate = :incDate"),
    @NamedQuery(name = "User.findByLastLogin", query = "SELECT u FROM User u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser")
    private Long iduser;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "pass")
    private String pass;
    @Basic(optional = false)
    @Column(name = "inc_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incDate;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Breed> breedCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Armor> armorCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Perk> perkCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Campain> campainCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Spell> spellCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Occupation> occupationCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Expertise> expertiseCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Effect> effectCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Skill> skillCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Item> itemCollection;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<Weapon> weaponCollection;
    @JoinColumn(name = "idrole", referencedColumnName = "idrole")
    @ManyToOne(optional = false)
    private Role idrole;
    @OneToMany(cascade = {}, mappedBy = "iduser")
    private Collection<CharacterSheet> characterSheetCollection;

    public User() {
    }

    public User(Long iduser) {
        this.iduser = iduser;
    }

    public User(Long iduser, String name, String login, String pass, Date incDate) {
        this.iduser = iduser;
        this.name = name;
        this.login = login;
        this.pass = pass;
        this.incDate = incDate;
    }

    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getIncDate() {
        return incDate;
    }

    public void setIncDate(Date incDate) {
        this.incDate = incDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Breed> getBreedCollection() {
        return breedCollection;
    }

    public void setBreedCollection(Collection<Breed> breedCollection) {
        this.breedCollection = breedCollection;
    }

    @XmlTransient
    public Collection<Armor> getArmorCollection() {
        return armorCollection;
    }

    public void setArmorCollection(Collection<Armor> armorCollection) {
        this.armorCollection = armorCollection;
    }

    @XmlTransient
    public Collection<Perk> getPerkCollection() {
        return perkCollection;
    }

    public void setPerkCollection(Collection<Perk> perkCollection) {
        this.perkCollection = perkCollection;
    }

    @XmlTransient
    public Collection<Campain> getCampainCollection() {
        return campainCollection;
    }

    public void setCampainCollection(Collection<Campain> campainCollection) {
        this.campainCollection = campainCollection;
    }

    @XmlTransient
    public Collection<Spell> getSpellCollection() {
        return spellCollection;
    }

    public void setSpellCollection(Collection<Spell> spellCollection) {
        this.spellCollection = spellCollection;
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
    public Collection<Effect> getEffectCollection() {
        return effectCollection;
    }

    public void setEffectCollection(Collection<Effect> effectCollection) {
        this.effectCollection = effectCollection;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    @XmlTransient
    public Collection<Weapon> getWeaponCollection() {
        return weaponCollection;
    }

    public void setWeaponCollection(Collection<Weapon> weaponCollection) {
        this.weaponCollection = weaponCollection;
    }

    public Role getIdrole() {
        return idrole;
    }

    public void setIdrole(Role idrole) {
        this.idrole = idrole;
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
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.User[ iduser=" + iduser + " ]";
    }

}
