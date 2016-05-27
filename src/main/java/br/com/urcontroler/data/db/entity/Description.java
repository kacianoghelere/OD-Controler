/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author kaciano
 */
@Entity
@Table(catalog = "ultimaterpgtools", schema = "")
@NamedQueries({
    @NamedQuery(name = "Description.findAll", query = "SELECT d FROM Description d"),
    @NamedQuery(name = "Description.findByIdmenuItem", query = "SELECT d FROM Description d WHERE d.idmenuItem = :idmenuItem"),
    @NamedQuery(name = "Description.findByTitle", query = "SELECT d FROM Description d WHERE d.title = :title"),
    @NamedQuery(name = "Description.findByCommitAction", query = "SELECT d FROM Description d WHERE d.commitAction = :commitAction"),
    @NamedQuery(name = "Description.findByProcessAction", query = "SELECT d FROM Description d WHERE d.processAction = :processAction"),
    @NamedQuery(name = "Description.findByClearAction", query = "SELECT d FROM Description d WHERE d.clearAction = :clearAction"),
    @NamedQuery(name = "Description.findByLoadAction", query = "SELECT d FROM Description d WHERE d.loadAction = :loadAction")})
public class Description implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idmenu_item")
    private Long idmenuItem;
    private String title;
    @Lob
    private String description;
    private String commitAction;
    private String processAction;
    private String clearAction;
    private String loadAction;
    @JoinColumn(name = "idmenu_item", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MenuItem menuItem;

    public Description() {
    }

    public Description(Long idmenuItem) {
        this.idmenuItem = idmenuItem;
    }

    public Long getIdmenuItem() {
        return idmenuItem;
    }

    public void setIdmenuItem(Long idmenuItem) {
        this.idmenuItem = idmenuItem;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommitAction() {
        return commitAction;
    }

    public void setCommitAction(String commitAction) {
        this.commitAction = commitAction;
    }

    public String getProcessAction() {
        return processAction;
    }

    public void setProcessAction(String processAction) {
        this.processAction = processAction;
    }

    public String getClearAction() {
        return clearAction;
    }

    public void setClearAction(String clearAction) {
        this.clearAction = clearAction;
    }

    public String getLoadAction() {
        return loadAction;
    }

    public void setLoadAction(String loadAction) {
        this.loadAction = loadAction;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenuItem != null ? idmenuItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Description)) {
            return false;
        }
        Description other = (Description) object;
        if ((this.idmenuItem == null && other.idmenuItem != null) || (this.idmenuItem != null && !this.idmenuItem.equals(other.idmenuItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.urcontroler.data.db.entity.Description[ idmenuItem=" + idmenuItem + " ]";
    }
    
}
