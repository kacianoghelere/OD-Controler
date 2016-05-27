/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "occupation_requirement", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "OccupationRequirement.findAll", query = "SELECT o FROM OccupationRequirement o"),
    @NamedQuery(name = "OccupationRequirement.findByIdoccupation", query = "SELECT o FROM OccupationRequirement o WHERE o.occupationRequirementPK.idoccupation = :idoccupation"),
    @NamedQuery(name = "OccupationRequirement.findByIdstatsAttribute", query = "SELECT o FROM OccupationRequirement o WHERE o.occupationRequirementPK.idstatsAttribute = :idstatsAttribute"),
    @NamedQuery(name = "OccupationRequirement.findByValue", query = "SELECT o FROM OccupationRequirement o WHERE o.value = :value")})
public class OccupationRequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OccupationRequirementPK occupationRequirementPK;
    @Basic(optional = false)
    private int value;
    @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Occupation occupation;
    @JoinColumn(name = "idstats_attribute", referencedColumnName = "idstats_attribute", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StatsAttribute statsAttribute;

    public OccupationRequirement() {
    }

    public OccupationRequirement(OccupationRequirementPK occupationRequirementPK) {
        this.occupationRequirementPK = occupationRequirementPK;
    }

    public OccupationRequirement(OccupationRequirementPK occupationRequirementPK, int value) {
        this.occupationRequirementPK = occupationRequirementPK;
        this.value = value;
    }

    public OccupationRequirement(long idoccupation, long idstatsAttribute) {
        this.occupationRequirementPK = new OccupationRequirementPK(idoccupation, idstatsAttribute);
    }

    public OccupationRequirementPK getOccupationRequirementPK() {
        return occupationRequirementPK;
    }

    public void setOccupationRequirementPK(OccupationRequirementPK occupationRequirementPK) {
        this.occupationRequirementPK = occupationRequirementPK;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public StatsAttribute getStatsAttribute() {
        return statsAttribute;
    }

    public void setStatsAttribute(StatsAttribute statsAttribute) {
        this.statsAttribute = statsAttribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (occupationRequirementPK != null ? occupationRequirementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationRequirement)) {
            return false;
        }
        OccupationRequirement other = (OccupationRequirement) object;
        if ((this.occupationRequirementPK == null && other.occupationRequirementPK != null) || (this.occupationRequirementPK != null && !this.occupationRequirementPK.equals(other.occupationRequirementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.OccupationRequirement[ occupationRequirementPK=" + occupationRequirementPK + " ]";
    }
    
}