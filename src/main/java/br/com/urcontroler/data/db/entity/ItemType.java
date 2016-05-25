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
@Table(name = "item_type")
@XmlRootElement
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
    @Column(name = "name")
    private String name;
    @JoinTable(name = "occupation_allowed_item_type", joinColumns = {
        @JoinColumn(name = "iditem_type", referencedColumnName = "iditem_type")}, inverseJoinColumns = {
        @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")})
    @ManyToMany
    private Collection<Occupation> occupationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iditemType")
    private Collection<Item> itemCollection;

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

    @XmlTransient
    public Collection<Occupation> getOccupationCollection() {
        return occupationCollection;
    }

    public void setOccupationCollection(Collection<Occupation> occupationCollection) {
        this.occupationCollection = occupationCollection;
    }

    @XmlTransient
    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
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
