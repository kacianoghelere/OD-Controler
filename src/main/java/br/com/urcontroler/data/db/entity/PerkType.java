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
@Table(name = "perk_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "PerkType.findAll", query = "SELECT p FROM PerkType p"),
    @NamedQuery(name = "PerkType.findByIdperkType", query = "SELECT p FROM PerkType p WHERE p.idperkType = :idperkType"),
    @NamedQuery(name = "PerkType.findByName", query = "SELECT p FROM PerkType p WHERE p.name = :name")})
public class PerkType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperk_type")
    private Long idperkType;
    @Basic(optional = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperkType")
    private List<Perk> perkList;

    public PerkType() {
    }

    public PerkType(Long idperkType) {
        this.idperkType = idperkType;
    }

    public PerkType(Long idperkType, String name) {
        this.idperkType = idperkType;
        this.name = name;
    }

    public Long getIdperkType() {
        return idperkType;
    }

    public void setIdperkType(Long idperkType) {
        this.idperkType = idperkType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Perk> getPerkList() {
        return perkList;
    }

    public void setPerkList(List<Perk> perkList) {
        this.perkList = perkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperkType != null ? idperkType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerkType)) {
            return false;
        }
        PerkType other = (PerkType) object;
        if ((this.idperkType == null && other.idperkType != null) || (this.idperkType != null && !this.idperkType.equals(other.idperkType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.PerkType[ idperkType=" + idperkType + " ]";
    }
    
}
