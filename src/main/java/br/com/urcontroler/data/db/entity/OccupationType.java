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
@Table(name = "occupation_type", catalog = "ultimaterpgtools", schema = "")
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
    private String name;
    @Basic(optional = false)
    private boolean magic;
    @Basic(optional = false)
    private int protection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idoccupationType")
    private List<Occupation> occupationList;

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

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
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
