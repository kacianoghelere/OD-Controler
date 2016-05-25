/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kaciano Ghelere
 */
@Entity
@Table(name = "spell_circle")
@XmlRootElement
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
    @Column(name = "circle")
    private int circle;
    @JoinColumn(name = "idspell_class", referencedColumnName = "idspell_class")
    @ManyToOne(optional = false)
    private SpellClass idspellClass;
    @JoinColumn(name = "idspell", referencedColumnName = "idspell")
    @ManyToOne(optional = false)
    private Spell idspell;

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

    public SpellClass getIdspellClass() {
        return idspellClass;
    }

    public void setIdspellClass(SpellClass idspellClass) {
        this.idspellClass = idspellClass;
    }

    public Spell getIdspell() {
        return idspell;
    }

    public void setIdspell(Spell idspell) {
        this.idspell = idspell;
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
