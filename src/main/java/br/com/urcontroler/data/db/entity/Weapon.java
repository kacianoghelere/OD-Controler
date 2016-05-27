/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "Weapon.findAll", query = "SELECT w FROM Weapon w"),
    @NamedQuery(name = "Weapon.findByIdweapon", query = "SELECT w FROM Weapon w WHERE w.idweapon = :idweapon"),
    @NamedQuery(name = "Weapon.findByName", query = "SELECT w FROM Weapon w WHERE w.name = :name"),
    @NamedQuery(name = "Weapon.findByDescription", query = "SELECT w FROM Weapon w WHERE w.description = :description"),
    @NamedQuery(name = "Weapon.findByInitiative", query = "SELECT w FROM Weapon w WHERE w.initiative = :initiative"),
    @NamedQuery(name = "Weapon.findByRange", query = "SELECT w FROM Weapon w WHERE w.range = :range"),
    @NamedQuery(name = "Weapon.findByDamage", query = "SELECT w FROM Weapon w WHERE w.damage = :damage"),
    @NamedQuery(name = "Weapon.findByWeight", query = "SELECT w FROM Weapon w WHERE w.weight = :weight"),
    @NamedQuery(name = "Weapon.findByPrice", query = "SELECT w FROM Weapon w WHERE w.price = :price")})
public class Weapon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idweapon;
    private String name;
    private String description;
    @Basic(optional = false)
    private int initiative;
    @Basic(optional = false)
    private int range;
    @Basic(optional = false)
    private String damage;
    @Basic(optional = false)
    private long weight;
    @Basic(optional = false)
    private long price;
    @JoinColumn(name = "idalignment", referencedColumnName = "idalignment")
    @ManyToOne(optional = false)
    private Alignment idalignment;
    @JoinColumn(name = "iddice", referencedColumnName = "iddice")
    @ManyToOne(optional = false)
    private Dice iddice;
    @JoinColumn(name = "idmaterial_type", referencedColumnName = "idmaterial_type")
    @ManyToOne(optional = false)
    private MaterialType idmaterialType;
    @JoinColumn(name = "origin_idorigin", referencedColumnName = "idorigin")
    @ManyToOne(optional = false)
    private Origin originIdorigin;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @JoinColumn(name = "idweapon_type", referencedColumnName = "idweapon_type")
    @ManyToOne(optional = false)
    private WeaponType idweaponType;

    public Weapon() {
    }

    public Weapon(Long idweapon) {
        this.idweapon = idweapon;
    }

    public Weapon(Long idweapon, int initiative, int range, String damage, long weight, long price) {
        this.idweapon = idweapon;
        this.initiative = initiative;
        this.range = range;
        this.damage = damage;
        this.weight = weight;
        this.price = price;
    }

    public Long getIdweapon() {
        return idweapon;
    }

    public void setIdweapon(Long idweapon) {
        this.idweapon = idweapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
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

    public MaterialType getIdmaterialType() {
        return idmaterialType;
    }

    public void setIdmaterialType(MaterialType idmaterialType) {
        this.idmaterialType = idmaterialType;
    }

    public Origin getOriginIdorigin() {
        return originIdorigin;
    }

    public void setOriginIdorigin(Origin originIdorigin) {
        this.originIdorigin = originIdorigin;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public WeaponType getIdweaponType() {
        return idweaponType;
    }

    public void setIdweaponType(WeaponType idweaponType) {
        this.idweaponType = idweaponType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idweapon != null ? idweapon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Weapon)) {
            return false;
        }
        Weapon other = (Weapon) object;
        if ((this.idweapon == null && other.idweapon != null) || (this.idweapon != null && !this.idweapon.equals(other.idweapon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Weapon[ idweapon=" + idweapon + " ]";
    }
    
}
