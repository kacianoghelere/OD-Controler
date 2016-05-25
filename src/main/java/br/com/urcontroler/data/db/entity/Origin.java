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
@Table(name = "origin")
@XmlRootElement
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
    @Column(name = "idorigin")
    private Long idorigin;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "variation")
    private String variation;
    @Basic(optional = false)
    @Column(name = "bonus")
    private int bonus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorigin")
    private Collection<Armor> armorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "originIdorigin")
    private Collection<Weapon> weaponCollection;

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

    @XmlTransient
    public Collection<Armor> getArmorCollection() {
        return armorCollection;
    }

    public void setArmorCollection(Collection<Armor> armorCollection) {
        this.armorCollection = armorCollection;
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
