package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Entidade dos elementos
 *
 * @author kaciano
 * @version 1.0
 */
public class Element extends Type {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de Element
     */
    public Element() {
    }

    /**
     * Cria nova instancia de Element
     *
     * @param id {@code Long} ID do elemento
     * @param title {@code String} Titulo do elemento
     */
    public Element(Long id, String title) {
        this.id = id;
        this.name = title;
    }

    /**
     * Retorna o ID do elemento
     *
     * @return {@code Long} ID do elemento
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do elemento
     *
     * @param id {@code Long} ID do elemento
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo do elemento
     *
     * @return {@code String} Titulo do elemento
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Modifica o Titulo do elemento
     *
     * @param name {@code String} Titulo do elemento
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
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
        final Element other = (Element) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return name;
    }

}
