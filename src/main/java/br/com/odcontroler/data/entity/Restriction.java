package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import java.util.Objects;

/**
 * Restrição de uso para equipamentos
 *
 * @author kaciano
 */
public class Restriction {

    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Tipo")
    private RestrictionType type;
    @Editable
    @ColumnName(name = "Valor")
    private Integer value;

    /**
     * Cria nova instancia de Restriction
     */
    public Restriction() {
    }

    /**
     * Cria nova instancia de Restriction
     *
     * @param id <code>Long</code> ID da restrições
     * @param type <code>RestrictionType</code> Tipo da Restrição
     * @param value <code>Integer</code> Valor da Restrição
     */
    public Restriction(Long id, RestrictionType type, Integer value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    /**
     * Cria nova instancia de Restriction
     *
     * @param type <code>RestrictionType</code> Tipo da Restrição
     * @param value <code>Integer</code> Valor da Restrição
     */
    public Restriction(RestrictionType type, Integer value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Retorna o ID da restrições
     *
     * @return <code>Long</code> ID da restrições
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da restrições
     *
     * @param id <code>Long</code> ID da restrições
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Tipo da Restrição
     *
     * @return <code>RestrictionType</code> Tipo da Restrição
     */
    public RestrictionType getType() {
        return type;
    }

    /**
     * Modifica o Tipo da Restrição
     *
     * @param type <code>RestrictionType</code> Tipo da Restrição
     */
    public void setType(RestrictionType type) {
        this.type = type;
    }

    /**
     * Retorna o Valor da Restrição
     *
     * @return <code>Integer</code> Valor da Restrição
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Modifica o Valor da Restrição
     *
     * @param value <code>Integer</code> Valor da Restrição
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return type.getTitle() + ": " + value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.type);
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
        final Restriction other = (Restriction) obj;
        return Objects.equals(this.id, other.id);
    }

}
