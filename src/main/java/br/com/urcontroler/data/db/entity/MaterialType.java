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
@Table(name = "material_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "MaterialType.findAll", query = "SELECT m FROM MaterialType m"),
    @NamedQuery(name = "MaterialType.findByIdmaterialType", query = "SELECT m FROM MaterialType m WHERE m.idmaterialType = :idmaterialType"),
    @NamedQuery(name = "MaterialType.findByName", query = "SELECT m FROM MaterialType m WHERE m.name = :name")})
public class MaterialType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmaterial_type")
    private Long idmaterialType;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmaterialType")
    private List<Weapon> weaponList;

    public MaterialType() {
    }

    public MaterialType(Long idmaterialType) {
        this.idmaterialType = idmaterialType;
    }

    public Long getIdmaterialType() {
        return idmaterialType;
    }

    public void setIdmaterialType(Long idmaterialType) {
        this.idmaterialType = idmaterialType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void setWeaponList(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmaterialType != null ? idmaterialType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialType)) {
            return false;
        }
        MaterialType other = (MaterialType) object;
        if ((this.idmaterialType == null && other.idmaterialType != null) || (this.idmaterialType != null && !this.idmaterialType.equals(other.idmaterialType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.MaterialType[ idmaterialType=" + idmaterialType + " ]";
    }
    
}
