package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Entidade dos tipos de Perk
 *
 * @author kaciano
 */
public class PerkType extends Type {

    @NotCopiable
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de PerkType
     */
    public PerkType() {
    }

    /**
     * Cria nova instancia de PerkType
     *
     * @param id {@code Long} Código do tipo
     * @param name {@code String} Nome do tipo
     */
    public PerkType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retorna o ID do PerkType
     *
     * @return {@code Long} ID do PerkType
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do PerkType
     *
     * @param id {@code Long} ID do PerkType
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do PerkType
     *
     * @return {@code String} Titulo do PerkType
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Modifica o titulo do PerkType
     *
     * @param title {@code String} Titulo do PerkType
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
        final PerkType other = (PerkType) obj;
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
