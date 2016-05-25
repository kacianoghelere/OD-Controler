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
@Table(name = "occupation_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OccupationType.findAll", query = "SELECT o FROM OccupationType o"),
    @NamedQuery(name = "OccupationType.findByIdoccupationType", query = "SELECT o FROM OccupationType o WHERE o.idoccupationType = :idoccupationType"),
    @NamedQuery(name = "OccupationType.findByName", query = "SELECT o FROM OccupationType o WHERE o.name = :name"),
    @NamedQuery(name = "OccupationType.findByMagic", query = "SELECT o FROM OccupationType o WHERE o.magic = :magic"),
    @NamedQuery(name = "OccupationType.findByProtection", query = "SELECT o FROM OccupationType o WHERE o.protection = :protection")})
public class OccupationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoccupation_type")
    private Long idoccupationType;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "magic")
    private boolean magic;
    @Basic(optional = false)
    @Column(name = "protection")
    private int protection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoccupationType")
    private Collection<Occupation> occupationCollection;

    public OccupationType() {
    }

    public OccupationType(Long idoccupationType) {
        this.idoccupationType = idoccupationType;
    }

    public OccupationType(Long idoccupationType, String name, boolean magic, int protection) {
        this.idoccupationType = idoccupationType;
        this.name = name;
        this.magic = magic;
        this.protection = protection;
    }

    public Long getIdoccupationType() {
        return idoccupationType;
    }

    public void setIdoccupationType(Long idoccupationType) {
        this.idoccupationType = idoccupationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getMagic() {
        return magic;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    @XmlTransient
    public Collection<Occupation> getOccupationCollection() {
        return occupationCollection;
    }

    public void setOccupationCollection(Collection<Occupation> occupationCollection) {
        this.occupationCollection = occupationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoccupationType != null ? idoccupationType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationType)) {
            return false;
        }
        OccupationType other = (OccupationType) object;
        if ((this.idoccupationType == null && other.idoccupationType != null) || (this.idoccupationType != null && !this.idoccupationType.equals(other.idoccupationType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.OccupationType[ idoccupationType=" + idoccupationType + " ]";
    }

}
