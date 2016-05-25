package br.com.urcontroler.data.entity;

import br.com.urcontroler.data.entity.interfaces.Type;
import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade dos tipos de Perk
 *
 * @author Kaciano Ghelere
 */
public class ExpertiseType extends Type {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;

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
        this.name = title;
    }

    /**
     * Retorna o Id do ExpertiseType
     *
     * @return {@code Long} Id do ExpertiseType
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id do ExpertiseType
     *
     * @param id {@code Long} Id do ExpertiseType
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do ExpertiseType
     *
     * @return {@code String} Titulo do ExpertiseType
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Modifica o titulo do ExpertiseType
     *
     * @param title {@code String} Titulo do ExpertiseType
     */
    @Override
    public void setName(String title) {
        this.name = title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
