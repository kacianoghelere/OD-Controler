package br.com.rpgruler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import java.util.Objects;

/**
 * Entidade dos tipos de restrição
 *
 * @author kaciano
 */
public class RestrictionType extends Type {

    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Titulo")
    private String title;
    @ColumnName(name = "Atributo")
    private Attribute attribute;

    /**
     * Cria nova instancia de RestrictionType
     */
    public RestrictionType() {
    }

    /**
     * Cria nova instancia de RestrictionType
     *
     * @param id <code>Long</code> Código do tipo
     * @param title <code>String</code> Titulo do tipo
     */
    public RestrictionType(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Cria nova instancia de RestrictionType
     *
     * @param id <code>Long</code> Código do tipo
     * @param title <code>String</code> Titulo do tipo
     * @param attribute <code>Attribute</code> Atributo da Restrição
     */
    public RestrictionType(Long id, String title, Attribute attribute) {
        this.id = id;
        this.title = title;
        this.attribute = attribute;
    }

    /**
     * Retorna o código
     *
     * @return <code>Long</code> Código do tipo
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o código
     *
     * @param id <code>Long</code> Código do tipo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo
     *
     * @return <code>String</code> Titulo do tipo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retorna o atributo da Restrição
     *
     * @return <code>Attribute</code> Atributo da Restrição
     */
    public Attribute getAttribute() {
        return attribute;
    }

    /**
     * Modifica o atributo da Restrição
     *
     * @param attribute <code>Attribute</code> Atributo da Restrição
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    /**
     * Modifica o titulo
     *
     * @param title <code>String</code> Titulo do tipo
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.title);
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
        final RestrictionType other = (RestrictionType) obj;
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
