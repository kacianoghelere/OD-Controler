/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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

/**
 *
 * @author kaciano
 */
@Entity
@Table(catalog = "ultimaterpgtools", schema = "")
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
    private Long idskill;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "skillList")
    private List<Breed> breedList;
    @JoinColumn(name = "ideffect", referencedColumnName = "ideffect")
    @ManyToOne(optional = false)
    private Effect ideffect;
    @JoinColumn(name = "idskill_type", referencedColumnName = "idskill_type")
    @ManyToOne(optional = false)
    private SkillType idskillType;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;

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

    public List<Breed> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }

    public Effect getIdeffect() {
        return ideffect;
    }

    public void setIdeffect(Effect ideffect) {
        this.ideffect = ideffect;
    }

    public SkillType getIdskillType() {
        return idskillType;
    }

    public void setIdskillType(SkillType idskillType) {
        this.idskillType = idskillType;
    }

    public User getIduser() {
        return iduser;
    }

    public void setIduser(User iduser) {
        this.iduser = iduser;
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
