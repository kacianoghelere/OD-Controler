package br.com.rpgruler.data.entity;

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
    private String title;

    /**
     * Cria nova instancia de Type
     */
    public Type() {
    }

    /**
     * Cria nova instancia de Type
     *
     * @param id <code>Long</code> Código do tipo
     * @param title <code>String</code> Titulo do tipo
     */
    public Type(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Retorna o ID do EffectType
     *
     * @return <code>Long</code> ID do Type
     */
    public abstract Long getId();

    /**
     * Modifica o ID do EffectType
     *
     * @param id <code>Long</code> ID do Type
     */
    public abstract void setId(Long id);

    /**
     * Retorna o titulo do EffectType
     *
     * @return <code>String</code> Titulo do Type
     */
    public abstract String getTitle();

    /**
     * Modifica o titulo do EffectType
     *
     * @param title <code>String</code> Titulo do Type
     */
    public abstract void setTitle(String title);

    @Override
    public String toString() {
        return getTitle();
    }

}
