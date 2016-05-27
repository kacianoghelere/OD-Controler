/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "character_stats_attr", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "CharacterStatsAttr.findAll", query = "SELECT c FROM CharacterStatsAttr c"),
    @NamedQuery(name = "CharacterStatsAttr.findByIdcharacterAttributes", query = "SELECT c FROM CharacterStatsAttr c WHERE c.idcharacterAttributes = :idcharacterAttributes"),
    @NamedQuery(name = "CharacterStatsAttr.findByAmount", query = "SELECT c FROM CharacterStatsAttr c WHERE c.amount = :amount"),
    @NamedQuery(name = "CharacterStatsAttr.findByModifier", query = "SELECT c FROM CharacterStatsAttr c WHERE c.modifier = :modifier")})
public class CharacterStatsAttr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcharacter_attributes")
    private Long idcharacterAttributes;
    @Basic(optional = false)
    private int amount;
    @Basic(optional = false)
    private int modifier;
    @JoinColumn(name = "idstats_attribute", referencedColumnName = "idstats_attribute")
    @ManyToOne(optional = false)
    private StatsAttribute idstatsAttribute;
    @JoinColumn(name = "idcharacter", referencedColumnName = "idcharacter")
    @ManyToOne(optional = false)
    private CharacterSheet idcharacter;

    public CharacterStatsAttr() {
    }

    public CharacterStatsAttr(Long idcharacterAttributes) {
        this.idcharacterAttributes = idcharacterAttributes;
    }

    public CharacterStatsAttr(Long idcharacterAttributes, int amount, int modifier) {
        this.idcharacterAttributes = idcharacterAttributes;
        this.amount = amount;
        this.modifier = modifier;
    }

    public Long getIdcharacterAttributes() {
        return idcharacterAttributes;
    }

    public void setIdcharacterAttributes(Long idcharacterAttributes) {
        this.idcharacterAttributes = idcharacterAttributes;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public StatsAttribute getIdstatsAttribute() {
        return idstatsAttribute;
    }

    public void setIdstatsAttribute(StatsAttribute idstatsAttribute) {
        this.idstatsAttribute = idstatsAttribute;
    }

    public CharacterSheet getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(CharacterSheet idcharacter) {
        this.idcharacter = idcharacter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcharacterAttributes != null ? idcharacterAttributes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CharacterStatsAttr)) {
            return false;
        }
        CharacterStatsAttr other = (CharacterStatsAttr) object;
        if ((this.idcharacterAttributes == null && other.idcharacterAttributes != null) || (this.idcharacterAttributes != null && !this.idcharacterAttributes.equals(other.idcharacterAttributes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.CharacterStatsAttr[ idcharacterAttributes=" + idcharacterAttributes + " ]";
    }
    
}
