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
@Table(name = "item_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "ItemType.findAll", query = "SELECT i FROM ItemType i"),
    @NamedQuery(name = "ItemType.findByIditemType", query = "SELECT i FROM ItemType i WHERE i.iditemType = :iditemType"),
    @NamedQuery(name = "ItemType.findByName", query = "SELECT i FROM ItemType i WHERE i.name = :name")})
public class ItemType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iditem_type")
    private Long iditemType;
    @Basic(optional = false)
    private String name;
    @JoinTable(name = "occupation_allowed_item_type", joinColumns = {
        @JoinColumn(name = "iditem_type", referencedColumnName = "iditem_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")})
    @ManyToMany
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditemType")
    private List<Item> itemList;

    public ItemType() {
    }

    public ItemType(Long iditemType) {
        this.iditemType = iditemType;
    }

    public ItemType(Long iditemType, String name) {
        this.iditemType = iditemType;
        this.name = name;
    }

    public Long getIditemType() {
        return iditemType;
    }

    public void setIditemType(Long iditemType) {
        this.iditemType = iditemType;
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iditemType != null ? iditemType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemType)) {
            return false;
        }
        ItemType other = (ItemType) object;
        if ((this.iditemType == null && other.iditemType != null) || (this.iditemType != null && !this.iditemType.equals(other.iditemType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.ItemType[ iditemType=" + iditemType + " ]";
    }
    
}
