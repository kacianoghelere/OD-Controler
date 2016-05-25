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
@Table(name = "spell_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpellClass.findAll", query = "SELECT s FROM SpellClass s"),
    @NamedQuery(name = "SpellClass.findByIdspellClass", query = "SELECT s FROM SpellClass s WHERE s.idspellClass = :idspellClass"),
    @NamedQuery(name = "SpellClass.findByName", query = "SELECT s FROM SpellClass s WHERE s.name = :name")})
public class SpellClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspell_class")
    private Long idspellClass;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "spellClassCollection")
    private Collection<Occupation> occupationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspellClass")
    private Collection<Spell> spellCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspellClass")
    private Collection<SpellCircle> spellCircleCollection;

    public SpellClass() {
    }

    public SpellClass(Long idspellClass) {
        this.idspellClass = idspellClass;
    }

    public SpellClass(Long idspellClass, String name) {
        this.idspellClass = idspellClass;
        this.name = name;
    }

    public Long getIdspellClass() {
        return idspellClass;
    }

    public void setIdspellClass(Long idspellClass) {
        this.idspellClass = idspellClass;
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
    public Collection<Spell> getSpellCollection() {
        return spellCollection;
    }

    public void setSpellCollection(Collection<Spell> spellCollection) {
        this.spellCollection = spellCollection;
    }

    @XmlTransient
    public Collection<SpellCircle> getSpellCircleCollection() {
        return spellCircleCollection;
    }

    public void setSpellCircleCollection(Collection<SpellCircle> spellCircleCollection) {
        this.spellCircleCollection = spellCircleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspellClass != null ? idspellClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpellClass)) {
            return false;
        }
        SpellClass other = (SpellClass) object;
        if ((this.idspellClass == null && other.idspellClass != null) || (this.idspellClass != null && !this.idspellClass.equals(other.idspellClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.SpellClass[ idspellClass=" + idspellClass + " ]";
    }

}
