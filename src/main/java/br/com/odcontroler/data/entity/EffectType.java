package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Entidade dos tipos de Effects
 *
 * @author kaciano
 */
public class EffectType extends Type {

    @NotCopiable
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de EffectType
     */
    public EffectType() {
    }

    /**
     * Cria nova instancia de EffectType
     *
     * @param id {@code Long} Código do tipo
     * @param title {@code String} Titulo do tipo
     */
    public EffectType(Long id, String title) {
        this.id = id;
        this.name = title;
    }

    /**
     * Retorna o ID do EffectType
     *
     * @return {@code Long} ID do EffectType
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do EffectType
     *
     * @param id {@code Long} ID do EffectType
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do EffectType
     *
     * @return {@code String} Titulo do EffectType
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Modifica o titulo do EffectType
     *
     * @param title {@code String} Titulo do EffectType
     */
    @Override
    public void setName(String title) {
        this.name = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
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
        final EffectType other = (EffectType) obj;
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
