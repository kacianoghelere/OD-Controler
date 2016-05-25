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
public class CampainMembersPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idcampain")
    private long idcampain;
    @Basic(optional = false)
    @Column(name = "idcharacter")
    private long idcharacter;

    public CampainMembersPK() {
    }

    public CampainMembersPK(long idcampain, long idcharacter) {
        this.idcampain = idcampain;
        this.idcharacter = idcharacter;
    }

    public long getIdcampain() {
        return idcampain;
    }

    public void setIdcampain(long idcampain) {
        this.idcampain = idcampain;
    }

    public long getIdcharacter() {
        return idcharacter;
    }

    public void setIdcharacter(long idcharacter) {
        this.idcharacter = idcharacter;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcampain;
        hash += (int) idcharacter;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampainMembersPK)) {
            return false;
        }
        CampainMembersPK other = (CampainMembersPK) object;
        if (this.idcampain != other.idcampain) {
            return false;
        }
        if (this.idcharacter != other.idcharacter) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.CampainMembersPK[ idcampain=" + idcampain + ", idcharacter=" + idcharacter + " ]";
    }

}
