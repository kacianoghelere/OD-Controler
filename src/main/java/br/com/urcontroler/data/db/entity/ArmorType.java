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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "armor_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArmorType.findAll", query = "SELECT a FROM ArmorType a"),
    @NamedQuery(name = "ArmorType.findByIdarmorType", query = "SELECT a FROM ArmorType a WHERE a.idarmorType = :idarmorType"),
    @NamedQuery(name = "ArmorType.findByName", query = "SELECT a FROM ArmorType a WHERE a.name = :name")})
public class ArmorType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idarmor_type")
    private Long idarmorType;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "breed_allowed_armor", joinColumns = {
        @JoinColumn(name = "idarmor_type", referencedColumnName = "idarmor_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")})
    @ManyToMany
    private Collection<Breed> breedCollection;
    @JoinTable(name = "occupation_allowed_armor_type", joinColumns = {
        @JoinColumn(name = "idarmor_type", referencedColumnName = "idarmor_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")})
    @ManyToMany
    private Collection<Occupation> occupationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarmorType")
    private Collection<Armor> armorCollection;

    public ArmorType() {
    }

    public ArmorType(Long idarmorType) {
        this.idarmorType = idarmorType;
    }

    public ArmorType(Long idarmorType, String name) {
        this.idarmorType = idarmorType;
        this.name = name;
    }

    public Long getIdarmorType() {
        return idarmorType;
    }

    public void setIdarmorType(Long idarmorType) {
        this.idarmorType = idarmorType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Breed> getBreedCollection() {
        return breedCollection;
    }

    public void setBreedCollection(Collection<Breed> breedCollection) {
        this.breedCollection = breedCollection;
    }

    @XmlTransient
    public Collection<Occupation> getOccupationCollection() {
        return occupationCollection;
    }

    public void setOccupationCollection(Collection<Occupation> occupationCollection) {
        this.occupationCollection = occupationCollection;
    }

    @XmlTransient
    public Collection<Armor> getArmorCollection() {
        return armorCollection;
    }

    public void setArmorCollection(Collection<Armor> armorCollection) {
        this.armorCollection = armorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idarmorType != null ? idarmorType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArmorType)) {
            return false;
        }
        ArmorType other = (ArmorType) object;
        if ((this.idarmorType == null && other.idarmorType != null) || (this.idarmorType != null && !this.idarmorType.equals(other.idarmorType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.ArmorType[ idarmorType=" + idarmorType + " ]";
    }

}
