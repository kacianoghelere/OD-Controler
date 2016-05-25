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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "effect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Effect.findAll", query = "SELECT e FROM Effect e"),
    @NamedQuery(name = "Effect.findByIdeffect", query = "SELECT e FROM Effect e WHERE e.ideffect = :ideffect"),
    @NamedQuery(name = "Effect.findByName", query = "SELECT e FROM Effect e WHERE e.name = :name"),
    @NamedQuery(name = "Effect.findByDescription", query = "SELECT e FROM Effect e WHERE e.description = :description")})
public class Effect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideffect")
    private Long ideffect;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @JoinColumn(name = "ideffect_type", referencedColumnName = "ideffect_type")
    @ManyToOne(optional = false)
    private EffectType ideffectType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ideffect")
    private Collection<Skill> skillCollection;

    public Effect() {
    }

    public Effect(Long ideffect) {
        this.ideffect = ideffect;
    }

    public Long getIdeffect() {
        return ideffect;
    }

    public void setIdeffect(Long ideffect) {
        this.ideffect = ideffect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public EffectType getIdeffectType() {
        return ideffectType;
    }

    public void setIdeffectType(EffectType ideffectType) {
        this.ideffectType = ideffectType;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ideffect != null ? ideffect.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Effect)) {
            return false;
        }
        Effect other = (Effect) object;
        if ((this.ideffect == null && other.ideffect != null) || (this.ideffect != null && !this.ideffect.equals(other.ideffect))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Effect[ ideffect=" + ideffect + " ]";
    }

}
