package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Id;
import br.com.gmp.utils.annotations.Ignore;
import java.util.Objects;

/**
 * Entidade de tipos de idiomas
 *
 * @author kaciano
 * @version 1.0
 */
public class LanguageType extends Type {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String name;

    /**
     * Cria nova instancia de LanguageType
     */
    public LanguageType() {
    }

    /**
     * Cria nova instancia de LanguageType
     *
     * @param id {@code Long} Código do tipo de idioma
     * @param name {@code String} Nome do tipo de idioma
     */
    public LanguageType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retorna o Código do tipo de idioma
     *
     * @return {@code Long} Código do tipo de idioma
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo de idioma
     *
     * @param id {@code Long} Código do tipo de idioma
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do tipo de idioma
     *
     * @return {@code String} Nome do tipo de idioma
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do tipo de idioma
     *
     * @param name {@code String} Nome do tipo de idioma
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final LanguageType other = (LanguageType) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }
}
