/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kaciano Ghelere
 */
@Entity
@Table(name = "skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s"),
    @NamedQuery(name = "Skill.findByIdskill", query = "SELECT s FROM Skill s WHERE s.idskill = :idskill"),
    @NamedQuery(name = "Skill.findByName", query = "SELECT s FROM Skill s WHERE s.name = :name"),
    @NamedQuery(name = "Skill.findByDescription", query = "SELECT s FROM Skill s WHERE s.description = :description")})
public class Skill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idskill")
    private Long idskill;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToMany(mappedBy = "skillCollection")
    private Collection<Breed> breedCollection;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;
    @JoinColumn(name = "idskill_type", referencedColumnName = "idskill_type")
    @ManyToOne(optional = false)
    private SkillType idskillType;
    @JoinColumn(name = "ideffect", referencedColumnName = "ideffect")
    @ManyToOne(optional = false)
    private Effect ideffect;

    public Skill() {
    }

    public Skill(Long idskill) {
        this.idskill = idskill;
    }

    public Long getIdskill() {
        return idskill;
    }

    public void setIdskill(Long idskill) {
        this.idskill = idskill;
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

    @XmlTransient
    public Collection<Breed> getBreedCollection() {
        return breedCollection;
    }

    public void setBreedCollection(Collection<Breed> breedCollection) {
        this.breedCollection = breedCollection;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
    }

    public SkillType getIdskillType() {
        return idskillType;
    }

    public void setIdskillType(SkillType idskillType) {
        this.idskillType = idskillType;
    }

    public Effect getIdeffect() {
        return ideffect;
    }

    public void setIdeffect(Effect ideffect) {
        this.ideffect = ideffect;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idskill != null ? idskill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.idskill == null && other.idskill != null) || (this.idskill != null && !this.idskill.equals(other.idskill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Skill[ idskill=" + idskill + " ]";
    }

}
