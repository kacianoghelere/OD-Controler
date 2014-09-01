package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.object.StringUtil;
import br.com.urcontroler.main.util.Description;
import java.util.Objects;

/**
 * Objeto para criação de atalhos das telas
 *
 * @author kaciano
 */
public class MenuItem implements Comparable<MenuItem> {

    @ColumnName(name = "ID")
    private Long id;
    @Editable
    @ColumnName(name = "Menu")
    private Long menu;
    @Editable
    @ColumnName(name = "Titulo")
    private String title;
    @Editable
    @ColumnName(name = "Classe")
    private String viewClass;
    @ColumnName(name = "Ícone")
    private String icon;
    @Ignore
    @ColumnName(name = "Descrição")
    private Description description;

    /**
     * Cria nova instancia de Menu
     */
    public MenuItem() {
    }

    /**
     * Cria nova instancia de Menu
     *
     * @param id {@code Long} ID do MenuItem
     * @param parent {@code Long} ID do MenuItem
     * @param viewClass {@code String} Classe do MenuItem
     * @param title {@code String} Titulo do MenuItem
     * @param icon {@code String} Icone do MenuItem
     * @param description {@code Description} Descrição do MenuItem
     */
    public MenuItem(Long id, Long parent, String viewClass, String title, String icon, Description description) {
        this.id = id;
        this.menu = parent;
        this.viewClass = viewClass;
        this.title = title;
        this.icon = icon;
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final MenuItem other = (MenuItem) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return title;
    }

    /**
     * Retorna o nome construido da view
     *
     * @return {@code String} Nome da view
     */
    public String getName() {
        String number = new StringUtil().completeWithZeros(3, id);
        return "VIEW" + number + " - " + title;
    }

    /**
     * Retorna o ID do MenuItem
     *
     * @return {@code Long} ID do MenuItem
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do MenuItem
     *
     * @param id {@code Long} ID do MenuItem
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o ID do menu pai
     *
     * @return {@code Long} ID do menu pai
     */
    public Long getMenu() {
        return menu;
    }

    /**
     * Modifica o ID do menu pai
     *
     * @param menu {@code Long} ID do menu pai
     */
    public void setMenu(Long menu) {
        this.menu = menu;
    }

    /**
     * Retorna a classe do MenuItem
     *
     * @return {@code String} Classe do MenuItem
     */
    public String getViewClass() {
        return viewClass;
    }

    /**
     * Retorna a classe do MenuItem
     *
     * @param viewClass {@code String} Classe do MenuItem
     */
    public void setViewClass(String viewClass) {
        this.viewClass = viewClass.replaceAll(".java", "");
    }

    /**
     * Retorna o titulo do MenuItem
     *
     * @return {@code String} Titulo do MenuItem
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do MenuItem
     *
     * @param title {@code String} Titulo do MenuItem
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o icone do MenuItem
     *
     * @return {@code String} Icone do MenuItem
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Modifica o icone do MenuItem
     *
     * @param icon {@code String} Icone do MenuItem
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Retorna a Descrição do MenuItem
     *
     * @return {@code Description} Descrição do MenuItem
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição do MenuItem
     *
     * @param description {@code Description} Descrição do MenuItem
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    @Override
    public int compareTo(MenuItem o) {
        return this.id.compareTo(o.getId());
    }

}
