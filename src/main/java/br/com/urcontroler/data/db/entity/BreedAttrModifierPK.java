/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Kaciano Ghelere
 */
@Embeddable
public class BreedAttrModifierPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idbreed")
    private long idbreed;
    @Basic(optional = false)
    @Column(name = "idattribute")
    private long idattribute;

    public BreedAttrModifierPK() {
    }

    public BreedAttrModifierPK(long idbreed, long idattribute) {
        this.idbreed = idbreed;
        this.idattribute = idattribute;
    }

    public long getIdbreed() {
        return idbreed;
    }

    public void setIdbreed(long idbreed) {
        this.idbreed = idbreed;
    }

    public long getIdattribute() {
        return idattribute;
    }

    public void setIdattribute(long idattribute) {
        this.idattribute = idattribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idbreed;
        hash += (int) idattribute;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BreedAttrModifierPK)) {
            return false;
        }
        BreedAttrModifierPK other = (BreedAttrModifierPK) object;
        if (this.idbreed != other.idbreed) {
            return false;
        }
        if (this.idattribute != other.idattribute) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BreedAttrModifierPK[ idbreed=" + idbreed + ", idattribute=" + idattribute + " ]";
    }

}
