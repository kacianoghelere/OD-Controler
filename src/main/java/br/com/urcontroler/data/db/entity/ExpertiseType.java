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
@Table(name = "expertise_type")
@XmlRootElement
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
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexpertiseType")
    private Collection<Expertise> expertiseCollection;

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

    @XmlTransient
    public Collection<Expertise> getExpertiseCollection() {
        return expertiseCollection;
    }

    public void setExpertiseCollection(Collection<Expertise> expertiseCollection) {
        this.expertiseCollection = expertiseCollection;
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
