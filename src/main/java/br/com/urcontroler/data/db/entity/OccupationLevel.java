/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "occupation_level", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "OccupationLevel.findAll", query = "SELECT o FROM OccupationLevel o"),
    @NamedQuery(name = "OccupationLevel.findByIdoccupationLevel", query = "SELECT o FROM OccupationLevel o WHERE o.idoccupationLevel = :idoccupationLevel"),
    @NamedQuery(name = "OccupationLevel.findByExp", query = "SELECT o FROM OccupationLevel o WHERE o.exp = :exp"),
    @NamedQuery(name = "OccupationLevel.findByLifeAmount", query = "SELECT o FROM OccupationLevel o WHERE o.lifeAmount = :lifeAmount"),
    @NamedQuery(name = "OccupationLevel.findByHasPlusLife", query = "SELECT o FROM OccupationLevel o WHERE o.hasPlusLife = :hasPlusLife"),
    @NamedQuery(name = "OccupationLevel.findByAttackBase", query = "SELECT o FROM OccupationLevel o WHERE o.attackBase = :attackBase"),
    @NamedQuery(name = "OccupationLevel.findByProtection", query = "SELECT o FROM OccupationLevel o WHERE o.protection = :protection")})
public class OccupationLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idoccupation_level")
    private Long idoccupationLevel;
    private BigInteger exp;
    @Column(name = "life_amount")
    private Integer lifeAmount;
    @Basic(optional = false)
    @Column(name = "has_plus_life")
    private boolean hasPlusLife;
    @Basic(optional = false)
    @Column(name = "attack_base")
    private int attackBase;
    @Basic(optional = false)
    private int protection;
    @JoinColumn(name = "idoccupation", referencedColumnName = "idoccupation")
    @ManyToOne(optional = false)
    private Occupation idoccupation;

    public OccupationLevel() {
    }

    public OccupationLevel(Long idoccupationLevel) {
        this.idoccupationLevel = idoccupationLevel;
    }

    public OccupationLevel(Long idoccupationLevel, boolean hasPlusLife, int attackBase, int protection) {
        this.idoccupationLevel = idoccupationLevel;
        this.hasPlusLife = hasPlusLife;
        this.attackBase = attackBase;
        this.protection = protection;
    }

    public Long getIdoccupationLevel() {
        return idoccupationLevel;
    }

    public void setIdoccupationLevel(Long idoccupationLevel) {
        this.idoccupationLevel = idoccupationLevel;
    }

    public BigInteger getExp() {
        return exp;
    }

    public void setExp(BigInteger exp) {
        this.exp = exp;
    }

    public Integer getLifeAmount() {
        return lifeAmount;
    }

    public void setLifeAmount(Integer lifeAmount) {
        this.lifeAmount = lifeAmount;
    }

    public boolean getHasPlusLife() {
        return hasPlusLife;
    }

    public void setHasPlusLife(boolean hasPlusLife) {
        this.hasPlusLife = hasPlusLife;
    }

    public int getAttackBase() {
        return attackBase;
    }

    public void setAttackBase(int attackBase) {
        this.attackBase = attackBase;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public Occupation getIdoccupation() {
        return idoccupation;
    }

    public void setIdoccupation(Occupation idoccupation) {
        this.idoccupation = idoccupation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idoccupationLevel != null ? idoccupationLevel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationLevel)) {
            return false;
        }
        OccupationLevel other = (OccupationLevel) object;
        if ((this.idoccupationLevel == null && other.idoccupationLevel != null) || (this.idoccupationLevel != null && !this.idoccupationLevel.equals(other.idoccupationLevel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.OccupationLevel[ idoccupationLevel=" + idoccupationLevel + " ]";
    }
    
}
