/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "alignment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alignment.findAll", query = "SELECT a FROM Alignment a"),
    @NamedQuery(name = "Alignment.findByIdalignment", query = "SELECT a FROM Alignment a WHERE a.idalignment = :idalignment"),
    @NamedQuery(name = "Alignment.findByName", query = "SELECT a FROM Alignment a WHERE a.name = :name")})
public class Alignment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalignment")
    private Long idalignment;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {}, mappedBy = "idalignment")
    private Collection<Breed> breedCollection;
    @OneToMany(cascade = {}, mappedBy = "idalignment")
    private Collection<Armor> armorCollection;
    @OneToMany(cascade = {}, mappedBy = "idalignment")
    private Collection<CharacterJournal> characterJournalCollection;
    @OneToMany(cascade = {}, mappedBy = "idalignment")
    private Collection<Occupation> occupationCollection;
    @OneToMany(cascade = {}, mappedBy = "idalignment")
    private Collection<Weapon> weaponCollection;

    public Alignment() {
    }

    public Alignment(Long idalignment) {
        this.idalignment = idalignment;
    }

    public Alignment(Long idalignment, String name) {
        this.idalignment = idalignment;
        this.name = name;
    }

    public Long getIdalignment() {
        return idalignment;
    }

    public void setIdalignment(Long idalignment) {
        this.idalignment = idalignment;
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
    public Collection<Armor> getArmorCollection() {
        return armorCollection;
    }

    public void setArmorCollection(Collection<Armor> armorCollection) {
        this.armorCollection = armorCollection;
    }

    @XmlTransient
    public Collection<CharacterJournal> getCharacterJournalCollection() {
        return characterJournalCollection;
    }

    public void setCharacterJournalCollection(Collection<CharacterJournal> characterJournalCollection) {
        this.characterJournalCollection = characterJournalCollection;
    }

    @XmlTransient
    public Collection<Occupation> getOccupationCollection() {
        return occupationCollection;
    }

    public void setOccupationCollection(Collection<Occupation> occupationCollection) {
        this.occupationCollection = occupationCollection;
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
        hash += (idalignment != null ? idalignment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alignment)) {
            return false;
        }
        Alignment other = (Alignment) object;
        if ((this.idalignment == null && other.idalignment != null) || (this.idalignment != null && !this.idalignment.equals(other.idalignment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Alignment[ idalignment=" + idalignment + " ]";
    }

}
