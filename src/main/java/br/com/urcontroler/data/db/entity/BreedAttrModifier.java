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
@Table(name = "breed_attr_modifier", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "BreedAttrModifier.findAll", query = "SELECT b FROM BreedAttrModifier b"),
    @NamedQuery(name = "BreedAttrModifier.findByIdbreed", query = "SELECT b FROM BreedAttrModifier b WHERE b.breedAttrModifierPK.idbreed = :idbreed"),
    @NamedQuery(name = "BreedAttrModifier.findByIdattribute", query = "SELECT b FROM BreedAttrModifier b WHERE b.breedAttrModifierPK.idattribute = :idattribute"),
    @NamedQuery(name = "BreedAttrModifier.findByModifier", query = "SELECT b FROM BreedAttrModifier b WHERE b.modifier = :modifier")})
public class BreedAttrModifier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BreedAttrModifierPK breedAttrModifierPK;
    @Basic(optional = false)
    private int modifier;
    @JoinColumn(name = "idattribute", referencedColumnName = "idstats_attribute", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StatsAttribute statsAttribute;
    @JoinColumn(name = "idbreed", referencedColumnName = "idbreed", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Breed breed;

    public BreedAttrModifier() {
    }

    public BreedAttrModifier(BreedAttrModifierPK breedAttrModifierPK) {
        this.breedAttrModifierPK = breedAttrModifierPK;
    }

    public BreedAttrModifier(BreedAttrModifierPK breedAttrModifierPK, int modifier) {
        this.breedAttrModifierPK = breedAttrModifierPK;
        this.modifier = modifier;
    }

    public BreedAttrModifier(long idbreed, long idattribute) {
        this.breedAttrModifierPK = new BreedAttrModifierPK(idbreed, idattribute);
    }

    public BreedAttrModifierPK getBreedAttrModifierPK() {
        return breedAttrModifierPK;
    }

    public void setBreedAttrModifierPK(BreedAttrModifierPK breedAttrModifierPK) {
        this.breedAttrModifierPK = breedAttrModifierPK;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public StatsAttribute getStatsAttribute() {
        return statsAttribute;
    }

    public void setStatsAttribute(StatsAttribute statsAttribute) {
        this.statsAttribute = statsAttribute;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (breedAttrModifierPK != null ? breedAttrModifierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BreedAttrModifier)) {
            return false;
        }
        BreedAttrModifier other = (BreedAttrModifier) object;
        if ((this.breedAttrModifierPK == null && other.breedAttrModifierPK != null) || (this.breedAttrModifierPK != null && !this.breedAttrModifierPK.equals(other.breedAttrModifierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.BreedAttrModifier[ breedAttrModifierPK=" + breedAttrModifierPK + " ]";
    }
    
}
