package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Super classe dos tipos
 *
 * @author kaciano
 */
public abstract class Type implements Comparable<Type> {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de Type
     */
    public Type() {
    }

    /**
     * Cria nova instancia de Type
     *
     * @param id {@code Long} Código do tipo
     * @param name {@code String} Nome do tipo
     */
    public Type(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Type other = (Type) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna o Id do EffectType
     *
     * @return {@code Long} Id do Type
     */
    public abstract Long getId();

    /**
     * Modifica o Id do EffectType
     *
     * @param id {@code Long} Id do Type
     */
    public abstract void setId(Long id);

    /**
     * Retorna o nome do EffectType
     *
     * @return {@code String} Nome do Type
     */
    public abstract String getName();

    /**
     * Modifica o nome do EffectType
     *
     * @param name {@code String} Nome do Type
     */
    public abstract void setName(String name);

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Type o) {
        return getId().compareTo(o.getId());
    }

}
