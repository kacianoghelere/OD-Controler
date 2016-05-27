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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "weapon_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "WeaponType.findAll", query = "SELECT w FROM WeaponType w"),
    @NamedQuery(name = "WeaponType.findByIdweaponType", query = "SELECT w FROM WeaponType w WHERE w.idweaponType = :idweaponType"),
    @NamedQuery(name = "WeaponType.findByName", query = "SELECT w FROM WeaponType w WHERE w.name = :name"),
    @NamedQuery(name = "WeaponType.findByRanged", query = "SELECT w FROM WeaponType w WHERE w.ranged = :ranged")})
public class WeaponType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idweapon_type")
    private Long idweaponType;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    private boolean ranged;
    @ManyToMany(mappedBy = "weaponTypeList")
    private List<Breed> breedList;
    @ManyToMany(mappedBy = "weaponTypeList")
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idweaponType")
    private List<Weapon> weaponList;

    public WeaponType() {
    }

    public WeaponType(Long idweaponType) {
        this.idweaponType = idweaponType;
    }

    public WeaponType(Long idweaponType, String name, boolean ranged) {
        this.idweaponType = idweaponType;
        this.name = name;
        this.ranged = ranged;
    }

    public Long getIdweaponType() {
        return idweaponType;
    }

    public void setIdweaponType(Long idweaponType) {
        this.idweaponType = idweaponType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRanged() {
        return ranged;
    }

    public void setRanged(boolean ranged) {
        this.ranged = ranged;
    }

    public List<Breed> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idweaponType != null ? idweaponType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeaponType)) {
            return false;
        }
        WeaponType other = (WeaponType) object;
        if ((this.idweaponType == null && other.idweaponType != null) || (this.idweaponType != null && !this.idweaponType.equals(other.idweaponType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.WeaponType[ idweaponType=" + idweaponType + " ]";
    }
    
}
