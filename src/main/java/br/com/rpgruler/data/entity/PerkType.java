package br.com.rpgruler.data.entity;

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
    private String title;

    /**
     * Cria nova instancia de PerkType
     */
    public PerkType() {
    }

    /**
     * Cria nova instancia de PerkType
     *
     * @param id <code>Long</code> Código do tipo
     * @param title <code>String</code> Nome do tipo
     */
    public PerkType(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Retorna o ID do PerkType
     *
     * @return <code>Long</code> ID do PerkType
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do PerkType
     *
     * @param id <code>Long</code> ID do PerkType
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do PerkType
     *
     * @return <code>String</code> Titulo do PerkType
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do PerkType
     *
     * @param title <code>String</code> Titulo do PerkType
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.title);
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
        return Objects.equals(this.title, other.title);
    }

    @Override
    public String toString() {
        return title;
    }

}
