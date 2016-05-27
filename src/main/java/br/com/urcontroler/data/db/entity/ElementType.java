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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "element_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "ElementType.findAll", query = "SELECT e FROM ElementType e"),
    @NamedQuery(name = "ElementType.findByIdelementType", query = "SELECT e FROM ElementType e WHERE e.idelementType = :idelementType"),
    @NamedQuery(name = "ElementType.findByName", query = "SELECT e FROM ElementType e WHERE e.name = :name")})
public class ElementType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idelement_type")
    private Long idelementType;
    @Basic(optional = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idelementType")
    private List<Spell> spellList;

    public ElementType() {
    }

    public ElementType(Long idelementType) {
        this.idelementType = idelementType;
    }

    public ElementType(Long idelementType, String name) {
        this.idelementType = idelementType;
        this.name = name;
    }

    public Long getIdelementType() {
        return idelementType;
    }

    public void setIdelementType(Long idelementType) {
        this.idelementType = idelementType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (idelementType != null ? idelementType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ElementType)) {
            return false;
        }
        ElementType other = (ElementType) object;
        if ((this.idelementType == null && other.idelementType != null) || (this.idelementType != null && !this.idelementType.equals(other.idelementType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.ElementType[ idelementType=" + idelementType + " ]";
    }
    
}
