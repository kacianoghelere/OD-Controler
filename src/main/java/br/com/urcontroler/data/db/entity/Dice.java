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
    @NamedQuery(name = "Dice.findAll", query = "SELECT d FROM Dice d"),
    @NamedQuery(name = "Dice.findByIddice", query = "SELECT d FROM Dice d WHERE d.iddice = :iddice"),
    @NamedQuery(name = "Dice.findByName", query = "SELECT d FROM Dice d WHERE d.name = :name")})
public class Dice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long iddice;
    @Basic(optional = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlifeDice")
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddice")
    private List<Weapon> weaponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddice")
    private List<Breed> breedList;

    public Dice() {
    }

    public Dice(Long iddice) {
        this.iddice = iddice;
    }

    public Dice(Long iddice, String name) {
        this.iddice = iddice;
        this.name = name;
    }

    public Long getIddice() {
        return iddice;
    }

    public void setIddice(Long iddice) {
        this.iddice = iddice;
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

    public List<Breed> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddice != null ? iddice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dice)) {
            return false;
        }
        Dice other = (Dice) object;
        if ((this.iddice == null && other.iddice != null) || (this.iddice != null && !this.iddice.equals(other.iddice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Dice[ iddice=" + iddice + " ]";
    }
    
}
