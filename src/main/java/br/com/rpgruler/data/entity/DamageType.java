package br.com.rpgruler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Entidade de controle dos tipos de dano
 *
 * @author kaciano
 */
public class DamageType extends Type {

    @NotCopiable
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;

    /**
     * Cria nova instancia de DamageType
     */
    public DamageType() {
    }

    /**
     * Cria nova instancia de DamageType
     *
     * @param id <code>Long</code> Código do tipo
     * @param title <code>String</code> Titulo do tipo
     */
    public DamageType(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Retorna o ID do EffectType
     *
     * @return <code>Long</code> ID do DamageType
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do EffectType
     *
     * @param id <code>Long</code> ID do DamageType
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do EffectType
     *
     * @return <code>String</code> Titulo do DamageType
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do EffectType
     *
     * @param title <code>String</code> Titulo do DamageType
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final DamageType other = (DamageType) obj;
        return Objects.equals(this.id, other.id);
    }

}
