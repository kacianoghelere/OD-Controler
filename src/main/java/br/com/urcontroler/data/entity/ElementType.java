package br.com.urcontroler.data.entity;

import br.com.urcontroler.data.entity.interfaces.Type;
import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade dos elementos
 *
 * @author kaciano
 * @version 1.0
 */
public class ElementType extends Type {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de Element
     */
    public ElementType() {
    }

    /**
     * Cria nova instancia de Element
     *
     * @param id {@code Long} Id do elemento
     * @param title {@code String} Titulo do elemento
     */
    public ElementType(Long id, String title) {
        this.id = id;
        this.name = title;
    }

    /**
     * Retorna o Id do elemento
     *
     * @return {@code Long} Id do elemento
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id do elemento
     *
     * @param id {@code Long} Id do elemento
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
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final ElementType other = (ElementType) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }

}
