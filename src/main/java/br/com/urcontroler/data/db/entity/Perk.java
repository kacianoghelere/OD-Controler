/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Perk.findAll", query = "SELECT p FROM Perk p"),
    @NamedQuery(name = "Perk.findByIdperk", query = "SELECT p FROM Perk p WHERE p.idperk = :idperk"),
    @NamedQuery(name = "Perk.findByName", query = "SELECT p FROM Perk p WHERE p.name = :name"),
    @NamedQuery(name = "Perk.findByDescription", query = "SELECT p FROM Perk p WHERE p.description = :description")})
public class Perk implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idperk;
    private String name;
    private String description;
    @ManyToMany(mappedBy = "perkList")
    private List<Breed> breedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperk")
    private List<Occupation> occupationList;
    @JoinColumn(name = "idperk_type", referencedColumnName = "idperk_type")
    @ManyToOne(optional = false)
    private PerkType idperkType;
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false)
    private User iduser;

    public Perk() {
    }

    public Perk(Long idperk) {
        this.idperk = idperk;
    }

    public Long getIdperk() {
        return idperk;
    }

    public void setIdperk(Long idperk) {
        this.idperk = idperk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Breed> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }

    public PerkType getIdperkType() {
        return idperkType;
    }

    public void setIdperkType(PerkType idperkType) {
        this.idperkType = idperkType;
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
        hash += (idperk != null ? idperk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perk)) {
            return false;
        }
        Perk other = (Perk) object;
        if ((this.idperk == null && other.idperk != null) || (this.idperk != null && !this.idperk.equals(other.idperk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Perk[ idperk=" + idperk + " ]";
    }
    
}
