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
    @NamedQuery(name = "Alignment.findAll", query = "SELECT a FROM Alignment a"),
    @NamedQuery(name = "Alignment.findByIdalignment", query = "SELECT a FROM Alignment a WHERE a.idalignment = :idalignment"),
    @NamedQuery(name = "Alignment.findByName", query = "SELECT a FROM Alignment a WHERE a.name = :name")})
public class Alignment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idalignment;
    @Basic(optional = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<Weapon> weaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<CharacterJournal> characterJournalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<Breed> breedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idalignment")
    private List<Armor> armorList;

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

    public List<CharacterJournal> getCharacterJournalList() {
        return characterJournalList;
    }

    public void setCharacterJournalList(List<CharacterJournal> characterJournalList) {
        this.characterJournalList = characterJournalList;
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
