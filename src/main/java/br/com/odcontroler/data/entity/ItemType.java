package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade dos tipos de itens
 *
 * @author kaciano
 * @version 1.0
 */
public class ItemType extends Type {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de ItemType
     */
    public ItemType() {
    }

    /**
     * Cria nova instancia de ItemType
     *
     * @param id {@code Long} Código do tipo de item
     * @param name {@code String} Nome do tipo de item
     */
    public ItemType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ItemType other = (ItemType) obj;
        return Objects.equals(this.id, other.id);
    }

}
