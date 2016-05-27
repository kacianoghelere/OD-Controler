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
@Table(name = "campain_members", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "CampainMembers.findAll", query = "SELECT c FROM CampainMembers c"),
    @NamedQuery(name = "CampainMembers.findByIdcampain", query = "SELECT c FROM CampainMembers c WHERE c.campainMembersPK.idcampain = :idcampain"),
    @NamedQuery(name = "CampainMembers.findByIdcharacter", query = "SELECT c FROM CampainMembers c WHERE c.campainMembersPK.idcharacter = :idcharacter"),
    @NamedQuery(name = "CampainMembers.findByIdactive", query = "SELECT c FROM CampainMembers c WHERE c.idactive = :idactive")})
public class CampainMembers implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampainMembersPK campainMembersPK;
    @Basic(optional = false)
    private boolean idactive;
    @JoinColumn(name = "idcampain", referencedColumnName = "idcampain", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campain campain;
    @JoinColumn(name = "idcharacter", referencedColumnName = "idcharacter", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CharacterSheet characterSheet;

    public CampainMembers() {
    }

    public CampainMembers(CampainMembersPK campainMembersPK) {
        this.campainMembersPK = campainMembersPK;
    }

    public CampainMembers(CampainMembersPK campainMembersPK, boolean idactive) {
        this.campainMembersPK = campainMembersPK;
        this.idactive = idactive;
    }

    public CampainMembers(long idcampain, long idcharacter) {
        this.campainMembersPK = new CampainMembersPK(idcampain, idcharacter);
    }

    public CampainMembersPK getCampainMembersPK() {
        return campainMembersPK;
    }

    public void setCampainMembersPK(CampainMembersPK campainMembersPK) {
        this.campainMembersPK = campainMembersPK;
    }

    public boolean getIdactive() {
        return idactive;
    }

    public void setIdactive(boolean idactive) {
        this.idactive = idactive;
    }

    public Campain getCampain() {
        return campain;
    }

    public void setCampain(Campain campain) {
        this.campain = campain;
    }

    public CharacterSheet getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(CharacterSheet characterSheet) {
        this.characterSheet = characterSheet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campainMembersPK != null ? campainMembersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampainMembers)) {
            return false;
        }
        CampainMembers other = (CampainMembers) object;
        if ((this.campainMembersPK == null && other.campainMembersPK != null) || (this.campainMembersPK != null && !this.campainMembersPK.equals(other.campainMembersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.CampainMembers[ campainMembersPK=" + campainMembersPK + " ]";
    }
    
}
