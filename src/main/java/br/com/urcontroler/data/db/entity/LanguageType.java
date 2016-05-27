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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "language_type", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "LanguageType.findAll", query = "SELECT l FROM LanguageType l"),
    @NamedQuery(name = "LanguageType.findByIdlanguageType", query = "SELECT l FROM LanguageType l WHERE l.idlanguageType = :idlanguageType"),
    @NamedQuery(name = "LanguageType.findByName", query = "SELECT l FROM LanguageType l WHERE l.name = :name")})
public class LanguageType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlanguage_type")
    private Long idlanguageType;
    @Basic(optional = false)
    private String name;
    @Lob
    private String description;
    @ManyToMany(mappedBy = "languageTypeList")
    private List<Breed> breedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idnativeLanguage")
    private List<Breed> breedList1;

    public LanguageType() {
    }

    public LanguageType(Long idlanguageType) {
        this.idlanguageType = idlanguageType;
    }

    public LanguageType(Long idlanguageType, String name) {
        this.idlanguageType = idlanguageType;
        this.name = name;
    }

    public Long getIdlanguageType() {
        return idlanguageType;
    }

    public void setIdlanguageType(Long idlanguageType) {
        this.idlanguageType = idlanguageType;
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

    public List<Breed> getBreedList1() {
        return breedList1;
    }

    public void setBreedList1(List<Breed> breedList1) {
        this.breedList1 = breedList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlanguageType != null ? idlanguageType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LanguageType)) {
            return false;
        }
        LanguageType other = (LanguageType) object;
        if ((this.idlanguageType == null && other.idlanguageType != null) || (this.idlanguageType != null && !this.idlanguageType.equals(other.idlanguageType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.LanguageType[ idlanguageType=" + idlanguageType + " ]";
    }
    
}
