/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "role_access", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "RoleAccess.findAll", query = "SELECT r FROM RoleAccess r"),
    @NamedQuery(name = "RoleAccess.findById", query = "SELECT r FROM RoleAccess r WHERE r.id = :id")})
public class RoleAccess implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @JoinColumn(name = "id_menu_item", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MenuItem idMenuItem;
    @JoinColumn(name = "id_role", referencedColumnName = "idrole")
    @ManyToOne(optional = false)
    private Role idRole;

    public RoleAccess() {
    }

    public RoleAccess(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuItem getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(MenuItem idMenuItem) {
        this.idMenuItem = idMenuItem;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleAccess)) {
            return false;
        }
        RoleAccess other = (RoleAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.RoleAccess[ id=" + id + " ]";
    }
    
}
