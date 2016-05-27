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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "Spell.findAll", query = "SELECT s FROM Spell s"),
    @NamedQuery(name = "Spell.findByIdspell", query = "SELECT s FROM Spell s WHERE s.idspell = :idspell"),
    @NamedQuery(name = "Spell.findByName", query = "SELECT s FROM Spell s WHERE s.name = :name"),
    @NamedQuery(name = "Spell.findByMagicCost", query = "SELECT s FROM Spell s WHERE s.magicCost = :magicCost"),
    @NamedQuery(name = "Spell.findByRange", query = "SELECT s FROM Spell s WHERE s.range = :range"),
    @NamedQuery(name = "Spell.findByDuration", query = "SELECT s FROM Spell s WHERE s.duration = :duration"),
    @NamedQuery(name = "Spell.findByDescription", query = "SELECT s FROM Spell s WHERE s.description = :description")})
public class Spell implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idspell;
    @Basic(optional = false)
    private String name;
    @Basic(optional = false)
    @Column(name = "magic_cost")
    private int magicCost;
    @Basic(optional = false)
    private String range;
    @Basic(optional = false)
    private String duration;
    @Basic(optional = false)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idspell")
    private List<SpellCircle> spellCircleList;
    @JoinColumn(name = "idelement_type", referencedColumnName = "idelement_type")
    @ManyToOne(optional = false)
    private ElementType idelementType;
    @JoinColumn(name = "idspell_class", referencedColumnName = "idspell_class")
    @ManyToOne(optional = false)
    private SpellClass idspellClass;
    @JoinColumn(name = "idspell_type", referencedColumnName = "idspell_type")
    @ManyToOne(optional = false)
    private SpellType idspellType;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;

    public Spell() {
    }

    public Spell(Long idspell) {
        this.idspell = idspell;
    }

    public Spell(Long idspell, String name, int magicCost, String range, String duration, String description) {
        this.idspell = idspell;
        this.name = name;
        this.magicCost = magicCost;
        this.range = range;
        this.duration = duration;
        this.description = description;
    }

    public Long getIdspell() {
        return idspell;
    }

    public void setIdspell(Long idspell) {
        this.idspell = idspell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagicCost() {
        return magicCost;
    }

    public void setMagicCost(int magicCost) {
        this.magicCost = magicCost;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SpellCircle> getSpellCircleList() {
        return spellCircleList;
    }

    public void setSpellCircleList(List<SpellCircle> spellCircleList) {
        this.spellCircleList = spellCircleList;
    }

    public ElementType getIdelementType() {
        return idelementType;
    }

    public void setIdelementType(ElementType idelementType) {
        this.idelementType = idelementType;
    }

    public SpellClass getIdspellClass() {
        return idspellClass;
    }

    public void setIdspellClass(SpellClass idspellClass) {
        this.idspellClass = idspellClass;
    }

    public SpellType getIdspellType() {
        return idspellType;
    }

    public void setIdspellType(SpellType idspellType) {
        this.idspellType = idspellType;
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
        hash += (idspell != null ? idspell.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spell)) {
            return false;
        }
        Spell other = (Spell) object;
        if ((this.idspell == null && other.idspell != null) || (this.idspell != null && !this.idspell.equals(other.idspell))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Spell[ idspell=" + idspell + " ]";
    }
    
}
