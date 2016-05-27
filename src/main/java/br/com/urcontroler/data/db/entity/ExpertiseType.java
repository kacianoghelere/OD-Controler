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
@Table(name = "expertise_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "ExpertiseType.findAll", query = "SELECT e FROM ExpertiseType e"),
    @NamedQuery(name = "ExpertiseType.findByIdexpertiseType", query = "SELECT e FROM ExpertiseType e WHERE e.idexpertiseType = :idexpertiseType"),
    @NamedQuery(name = "ExpertiseType.findByName", query = "SELECT e FROM ExpertiseType e WHERE e.name = :name")})
public class ExpertiseType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexpertise_type")
    private Long idexpertiseType;
    @Basic(optional = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexpertiseType")
    private List<Expertise> expertiseList;

    public ExpertiseType() {
    }

    public ExpertiseType(Long idexpertiseType) {
        this.idexpertiseType = idexpertiseType;
    }

    public ExpertiseType(Long idexpertiseType, String name) {
        this.idexpertiseType = idexpertiseType;
        this.name = name;
    }

    public Long getIdexpertiseType() {
        return idexpertiseType;
    }

    public void setIdexpertiseType(Long idexpertiseType) {
        this.idexpertiseType = idexpertiseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expertise> getExpertiseList() {
        return expertiseList;
    }

    public void setExpertiseList(List<Expertise> expertiseList) {
        this.expertiseList = expertiseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexpertiseType != null ? idexpertiseType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExpertiseType)) {
            return false;
        }
        ExpertiseType other = (ExpertiseType) object;
        if ((this.idexpertiseType == null && other.idexpertiseType != null) || (this.idexpertiseType != null && !this.idexpertiseType.equals(other.idexpertiseType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.ExpertiseType[ idexpertiseType=" + idexpertiseType + " ]";
    }
    
}
