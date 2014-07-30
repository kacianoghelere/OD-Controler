package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;

/**
 * Super classe dos tipos
 *
 * @author kaciano
 */
public abstract class Type {

    @NotCopiable
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

    /**
     * Retorna o ID do EffectType
     *
     * @return {@code Long} ID do Type
     */
    public abstract Long getId();

    /**
     * Modifica o ID do EffectType
     *
     * @param id {@code Long} ID do Type
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

}
