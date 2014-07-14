package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Tipo de armadura
 *
 * @author kaciano
 */
public class ArmorType implements Entity {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;

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
        this.title = typeName;
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
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do tipo
     *
     * @return {@code String} Nome do tipo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Nome do tipo
     *
     * @param title {@code String} Nome do tipo
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.title);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.title, other.title);
    }

    @Override
    public String toString() {
        return id + " - " + title;
    }

}
