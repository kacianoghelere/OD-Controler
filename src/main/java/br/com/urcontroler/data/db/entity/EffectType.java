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
@Table(name = "effect_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "EffectType.findAll", query = "SELECT e FROM EffectType e"),
    @NamedQuery(name = "EffectType.findByIdeffectType", query = "SELECT e FROM EffectType e WHERE e.ideffectType = :ideffectType"),
    @NamedQuery(name = "EffectType.findByName", query = "SELECT e FROM EffectType e WHERE e.name = :name")})
public class EffectType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideffect_type")
    private Long ideffectType;
    @Basic(optional = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ideffectType")
    private List<Effect> effectList;

    public EffectType() {
    }

    public EffectType(Long ideffectType) {
        this.ideffectType = ideffectType;
    }

    public EffectType(Long ideffectType, String name) {
        this.ideffectType = ideffectType;
        this.name = name;
    }

    public Long getIdeffectType() {
        return ideffectType;
    }

    public void setIdeffectType(Long ideffectType) {
        this.ideffectType = ideffectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Effect> getEffectList() {
        return effectList;
    }

    public void setEffectList(List<Effect> effectList) {
        this.effectList = effectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideffectType != null ? ideffectType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EffectType)) {
            return false;
        }
        EffectType other = (EffectType) object;
        if ((this.ideffectType == null && other.ideffectType != null) || (this.ideffectType != null && !this.ideffectType.equals(other.ideffectType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.EffectType[ ideffectType=" + ideffectType + " ]";
    }
    
}
