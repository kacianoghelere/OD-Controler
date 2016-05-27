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
@Table(name = "spell_circle", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "SpellCircle.findAll", query = "SELECT s FROM SpellCircle s"),
    @NamedQuery(name = "SpellCircle.findByIdspellCircle", query = "SELECT s FROM SpellCircle s WHERE s.idspellCircle = :idspellCircle"),
    @NamedQuery(name = "SpellCircle.findByCircle", query = "SELECT s FROM SpellCircle s WHERE s.circle = :circle")})
public class SpellCircle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspell_circle")
    private Long idspellCircle;
    @Basic(optional = false)
    private int circle;
    @JoinColumn(name = "idspell", referencedColumnName = "idspell")
    @ManyToOne(optional = false)
    private Spell idspell;
    @JoinColumn(name = "idspell_class", referencedColumnName = "idspell_class")
    @ManyToOne(optional = false)
    private SpellClass idspellClass;

    public SpellCircle() {
    }

    public SpellCircle(Long idspellCircle) {
        this.idspellCircle = idspellCircle;
    }

    public SpellCircle(Long idspellCircle, int circle) {
        this.idspellCircle = idspellCircle;
        this.circle = circle;
    }

    public Long getIdspellCircle() {
        return idspellCircle;
    }

    public void setIdspellCircle(Long idspellCircle) {
        this.idspellCircle = idspellCircle;
    }

    public int getCircle() {
        return circle;
    }

    public void setCircle(int circle) {
        this.circle = circle;
    }

    public Spell getIdspell() {
        return idspell;
    }

    public void setIdspell(Spell idspell) {
        this.idspell = idspell;
    }

    public SpellClass getIdspellClass() {
        return idspellClass;
    }

    public void setIdspellClass(SpellClass idspellClass) {
        this.idspellClass = idspellClass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idspellCircle != null ? idspellCircle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpellCircle)) {
            return false;
        }
        SpellCircle other = (SpellCircle) object;
        if ((this.idspellCircle == null && other.idspellCircle != null) || (this.idspellCircle != null && !this.idspellCircle.equals(other.idspellCircle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.SpellCircle[ idspellCircle=" + idspellCircle + " ]";
    }
    
}
