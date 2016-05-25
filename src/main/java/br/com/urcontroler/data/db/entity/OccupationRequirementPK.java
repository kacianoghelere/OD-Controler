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
public class OccupationRequirementPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idoccupation")
    private long idoccupation;
    @Basic(optional = false)
    @Column(name = "idstats_attribute")
    private long idstatsAttribute;

    public OccupationRequirementPK() {
    }

    public OccupationRequirementPK(long idoccupation, long idstatsAttribute) {
        this.idoccupation = idoccupation;
        this.idstatsAttribute = idstatsAttribute;
    }

    public long getIdoccupation() {
        return idoccupation;
    }

    public void setIdoccupation(long idoccupation) {
        this.idoccupation = idoccupation;
    }

    public long getIdstatsAttribute() {
        return idstatsAttribute;
    }

    public void setIdstatsAttribute(long idstatsAttribute) {
        this.idstatsAttribute = idstatsAttribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idoccupation;
        hash += (int) idstatsAttribute;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OccupationRequirementPK)) {
            return false;
        }
        OccupationRequirementPK other = (OccupationRequirementPK) object;
        if (this.idoccupation != other.idoccupation) {
            return false;
        }
        if (this.idstatsAttribute != other.idstatsAttribute) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.OccupationRequirementPK[ idoccupation=" + idoccupation + ", idstatsAttribute=" + idstatsAttribute + " ]";
    }

}
