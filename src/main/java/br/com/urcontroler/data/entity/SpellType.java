package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade dos tipos de mágica
 *
 * @author kaciano
 * @version 1.0
 */
public class SpellType extends Type {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de MagicType
     */
    public SpellType() {
    }

    /**
     * Cria nova instancia de MagicType
     *
     * @param id {@code Long} Código do tipo
     * @param typeName {@code String} Nome do tipo
     */
    public SpellType(Long id, String typeName) {
        this.id = id;
        this.name = typeName;
    }

    /**
     * Retorna o Código do tipo
     *
     * @return {@code Long} Código do tipo
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo
     *
     * @param id {@code Long} Código do tipo
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do tipo
     *
     * @return {@code String} Nome do tipo
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do tipo
     *
     * @param title {@code String} Nome do tipo
     */
    @Override
    public void setName(String title) {
        this.name = title;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final SpellType other = (SpellType) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }

}
