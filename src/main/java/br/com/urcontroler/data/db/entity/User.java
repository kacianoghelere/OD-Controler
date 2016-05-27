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

/**
 *
 * @author kaciano
 */
@Entity
@Table(catalog = "ultimaterpgtools", schema = "")
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
    private Long iduser;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String login;
    @Basic(optional = false)
    private String pass;
    @Basic(optional = false)
    @Column(name = "inc_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date incDate;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Expertise> expertiseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<CharacterSheet> characterSheetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Weapon> weaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Skill> skillList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Perk> perkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Spell> spellList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Item> itemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Campain> campainList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Breed> breedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Armor> armorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Effect> effectList;
    @JoinColumn(name = "idrole", referencedColumnName = "idrole")
    @ManyToOne(optional = false)
    private Role idrole;

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

    public List<CharacterSheet> getCharacterSheetList() {
        return characterSheetList;
    }

    public void setCharacterSheetList(List<CharacterSheet> characterSheetList) {
        this.characterSheetList = characterSheetList;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<Perk> getPerkList() {
        return perkList;
    }

    public void setPerkList(List<Perk> perkList) {
        this.perkList = perkList;
    }

    public List<Spell> getSpellList() {
        return spellList;
    }

    public void setSpellList(List<Spell> spellList) {
        this.spellList = spellList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Campain> getCampainList() {
        return campainList;
    }

    public void setCampainList(List<Campain> campainList) {
        this.campainList = campainList;
    }

    public List<Breed> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }

    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
    }

    public List<Effect> getEffectList() {
        return effectList;
    }

    public void setEffectList(List<Effect> effectList) {
        this.effectList = effectList;
    }

    public Role getIdrole() {
        return idrole;
    }

    public void setIdrole(Role idrole) {
        this.idrole = idrole;
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
