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
public class ExpertiseType implements Entity {

    @NotCopiable
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;

    /**
     * Cria nova instancia de ExpertiseType
     */
    public ExpertiseType() {
    }

    /**
     * Cria nova instancia de ExpertiseType
     *
     * @param id {@code Long} Código do tipo
     * @param title {@code String} Nome do tipo
     */
    public ExpertiseType(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Retorna o ID do ExpertiseType
     *
     * @return {@code Long} ID do ExpertiseType
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do ExpertiseType
     *
     * @param id {@code Long} ID do ExpertiseType
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do ExpertiseType
     *
     * @return {@code String} Titulo do ExpertiseType
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do ExpertiseType
     *
     * @param title {@code String} Titulo do ExpertiseType
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
        final ExpertiseType other = (ExpertiseType) obj;
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
