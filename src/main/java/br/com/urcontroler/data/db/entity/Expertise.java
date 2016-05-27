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
    @NamedQuery(name = "Expertise.findAll", query = "SELECT e FROM Expertise e"),
    @NamedQuery(name = "Expertise.findByIdexpertise", query = "SELECT e FROM Expertise e WHERE e.idexpertise = :idexpertise"),
    @NamedQuery(name = "Expertise.findByName", query = "SELECT e FROM Expertise e WHERE e.name = :name"),
    @NamedQuery(name = "Expertise.findByModifier", query = "SELECT e FROM Expertise e WHERE e.modifier = :modifier")})
public class Expertise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idexpertise;
    private String name;
    private Integer modifier;
    @ManyToMany(mappedBy = "expertiseList")
    private List<CharacterSheet> characterSheetList;
    @JoinColumn(name = "idattribute", referencedColumnName = "idstats_attribute")
    @ManyToOne(optional = false)
    private StatsAttribute idattribute;
    @JoinColumn(name = "idexpertise_type", referencedColumnName = "idexpertise_type")
    @ManyToOne(optional = false)
    private ExpertiseType idexpertiseType;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;

    public Expertise() {
    }

    public Expertise(Long idexpertise) {
        this.idexpertise = idexpertise;
    }

    public Long getIdexpertise() {
        return idexpertise;
    }

    public void setIdexpertise(Long idexpertise) {
        this.idexpertise = idexpertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public List<CharacterSheet> getCharacterSheetList() {
        return characterSheetList;
    }

    public void setCharacterSheetList(List<CharacterSheet> characterSheetList) {
        this.characterSheetList = characterSheetList;
    }

    public StatsAttribute getIdattribute() {
        return idattribute;
    }

    public void setIdattribute(StatsAttribute idattribute) {
        this.idattribute = idattribute;
    }

    public ExpertiseType getIdexpertiseType() {
        return idexpertiseType;
    }

    public void setIdexpertiseType(ExpertiseType idexpertiseType) {
        this.idexpertiseType = idexpertiseType;
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
        hash += (idexpertise != null ? idexpertise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expertise)) {
            return false;
        }
        Expertise other = (Expertise) object;
        if ((this.idexpertise == null && other.idexpertise != null) || (this.idexpertise != null && !this.idexpertise.equals(other.idexpertise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Expertise[ idexpertise=" + idexpertise + " ]";
    }
    
}
