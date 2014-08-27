package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Tipo de armadura
 *
 * @author kaciano
 */
public class ArmorType extends Type {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de ArmorType
     */
    public ArmorType() {
    }

    /**
     * Cria nova instancia de ArmorType
     *
     * @param id {@code Long} Código do tipo
     * @param typeName {@code String} Nome do tipo
     */
    public ArmorType(Long id, String typeName) {
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
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final ArmorType other = (ArmorType) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }

}
