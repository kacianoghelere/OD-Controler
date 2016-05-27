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
    @NamedQuery(name = "Origin.findAll", query = "SELECT o FROM Origin o"),
    @NamedQuery(name = "Origin.findByIdorigin", query = "SELECT o FROM Origin o WHERE o.idorigin = :idorigin"),
    @NamedQuery(name = "Origin.findByName", query = "SELECT o FROM Origin o WHERE o.name = :name"),
    @NamedQuery(name = "Origin.findByVariation", query = "SELECT o FROM Origin o WHERE o.variation = :variation"),
    @NamedQuery(name = "Origin.findByBonus", query = "SELECT o FROM Origin o WHERE o.bonus = :bonus")})
public class Origin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idorigin;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private String variation;
    @Basic(optional = false)
    private int bonus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "originIdorigin")
    private List<Weapon> weaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorigin")
    private List<Armor> armorList;

    public Origin() {
    }

    public Origin(Long idorigin) {
        this.idorigin = idorigin;
    }

    public Origin(Long idorigin, String name, String variation, int bonus) {
        this.idorigin = idorigin;
        this.name = name;
        this.variation = variation;
        this.bonus = bonus;
    }

    public Long getIdorigin() {
        return idorigin;
    }

    public void setIdorigin(Long idorigin) {
        this.idorigin = idorigin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorigin != null ? idorigin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Origin)) {
            return false;
        }
        Origin other = (Origin) object;
        if ((this.idorigin == null && other.idorigin != null) || (this.idorigin != null && !this.idorigin.equals(other.idorigin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Origin[ idorigin=" + idorigin + " ]";
    }
    
}
