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
@Table(name = "spell_class", catalog = "ultimaterpgtools", schema = "")
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
    private String name;
    @ManyToMany(mappedBy = "spellClassList")
    private List<Occupation> occupationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspellClass")
    private List<SpellCircle> spellCircleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspellClass")
    private List<Spell> spellList;

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

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }

    public List<SpellCircle> getSpellCircleList() {
        return spellCircleList;
    }

    public void setSpellCircleList(List<SpellCircle> spellCircleList) {
        this.spellCircleList = spellCircleList;
    }

    public List<Spell> getSpellList() {
        return spellList;
    }

    public void setSpellList(List<Spell> spellList) {
        this.spellList = spellList;
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
