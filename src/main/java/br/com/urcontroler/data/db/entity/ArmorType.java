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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "armor_type", catalog = "ultimaterpgtools", schema = "")
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
    private String name;
    @JoinTable(name = "breed_allowed_armor", joinColumns = {
        @JoinColumn(name = "idarmor_type", referencedColumnName = "idarmor_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idbreed", referencedColumnName = "idbreed")})
    @ManyToMany
    private List<Breed> breedList;
    @JoinTable(name = "occupation_allowed_armor_type", joinColumns = {
        @JoinColumn(name = "idarmor_type", referencedColumnName = "idarmor_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")})
    @ManyToMany
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idarmorType")
    private List<Armor> armorList;

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

    public List<Armor> getArmorList() {
        return armorList;
    }

    public void setArmorList(List<Armor> armorList) {
        this.armorList = armorList;
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
