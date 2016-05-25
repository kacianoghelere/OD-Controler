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
import javax.persistence.ManyToMany;
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
@Table(name = "weapon_type")
@XmlRootElement
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
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "ranged")
    private boolean ranged;
    @ManyToMany(mappedBy = "weaponTypeCollection")
    private Collection<Occupation> occupationCollection;
    @ManyToMany(mappedBy = "weaponTypeCollection")
    private Collection<Breed> breedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idweaponType")
    private Collection<Weapon> weaponCollection;

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

    @XmlTransient
    public Collection<Occupation> getOccupationCollection() {
        return occupationCollection;
    }

    public void setOccupationCollection(Collection<Occupation> occupationCollection) {
        this.occupationCollection = occupationCollection;
    }

    @XmlTransient
    public Collection<Breed> getBreedCollection() {
        return breedCollection;
    }

    public void setBreedCollection(Collection<Breed> breedCollection) {
        this.breedCollection = breedCollection;
    }

    @XmlTransient
    public Collection<Weapon> getWeaponCollection() {
        return weaponCollection;
    }

    public void setWeaponCollection(Collection<Weapon> weaponCollection) {
        this.weaponCollection = weaponCollection;
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
