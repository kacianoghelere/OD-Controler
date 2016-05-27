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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(name = "menu_item", catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "MenuItem.findAll", query = "SELECT m FROM MenuItem m"),
    @NamedQuery(name = "MenuItem.findById", query = "SELECT m FROM MenuItem m WHERE m.id = :id"),
    @NamedQuery(name = "MenuItem.findByTitle", query = "SELECT m FROM MenuItem m WHERE m.title = :title"),
    @NamedQuery(name = "MenuItem.findByViewClass", query = "SELECT m FROM MenuItem m WHERE m.viewClass = :viewClass"),
    @NamedQuery(name = "MenuItem.findByIcon", query = "SELECT m FROM MenuItem m WHERE m.icon = :icon")})
public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    private String title;
    @Basic(optional = false)
    private String viewClass;
    private String icon;
    @JoinColumn(name = "menu", referencedColumnName = "id")
    @ManyToOne
    private Menu menu;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "menuItem")
    private Description description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenuItem")
    private List<RoleAccess> roleAccessList;

    public MenuItem() {
    }

    public MenuItem(Long id) {
        this.id = id;
    }

    public MenuItem(Menu menu, String viewClass, String title, String icon) {
        this.menu = menu;
        this.viewClass = viewClass;
        this.title = title;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewClass() {
        return viewClass;
    }

    public void setViewClass(String viewClass) {
        this.viewClass = viewClass;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public List<RoleAccess> getRoleAccessList() {
        return roleAccessList;
    }

    public void setRoleAccessList(List<RoleAccess> roleAccessList) {
        this.roleAccessList = roleAccessList;
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
        if (!(object instanceof MenuItem)) {
            return false;
        }
        MenuItem other = (MenuItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.MenuItem[ id=" + id + " ]";
    }

}
