package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Id;
import br.com.gmp.utils.object.StringUtil;
import java.util.Objects;

/**
 * Entidade para registro de menus
 *
 * @author kaciano
 * @version 1.0
 */
public class Menu implements Comparable<Menu> {

    @Id
    @ColumnName(name = "ID")
    private Long id;
    @Editable
    @ColumnName(name = "Menu Pai")
    private Long parent;
    @Editable
    @ColumnName(name = "Titulo")
    private String title;
    @Editable
    @ColumnName(name = "Icone")
    private String icon;

    /**
     * Cria nova instancia de Menu
     */
    public Menu() {
    }

    /**
     * Cria nova instancia de Menu
     *
     * @param id {@code Long} ID do menu
     * @param title {@code String} Titulo do menu
     * @param icon {@code String} Icone do menu
     */
    public Menu(Long id, String title, String icon) {
        this.id = id;
        this.parent = (long) 0;
        this.title = title;
        this.icon = icon;
    }

    /**
     * Cria nova instancia de Menu
     *
     * @param id {@code Long} ID do menu
     * @param parent {@code Long} ID do menu pai
     * @param title {@code String} Titulo do menu
     * @param icon {@code String} Icone do menu
     */
    public Menu(Long id, Long parent, String title, String icon) {
        this.id = id;
        this.parent = parent;
        this.title = title;
        this.icon = icon;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Menu other = (Menu) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        String number = new StringUtil().completeWithZeros(3, id);
        return "MENU" + number + " - " + title;
    }

    /**
     * Retorna o ID do menu
     *
     * @return {@code Long} ID do menu
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do menu
     *
     * @param id {@code Long} ID do menu
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o ID do menu pai
     *
     * @return {@code Long} ID do menu pai
     */
    public Long getParent() {
        return parent;
    }

    /**
     * Modifica o ID do menu pai
     *
     * @param parent {@code Long} ID do menu pai
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * Retorna o titulo do menu
     *
     * @return {@code String} Titulo do menu
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do menu
     *
     * @param title {@code String} Titulo do menu
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o icone do menu
     *
     * @return {@code String} Icone do menu
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Modifica o icone do menu
     *
     * @param icon {@code String} Icone do menu
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public int compareTo(Menu o) {
        return this.id.compareTo(o.getId());
    }

}
