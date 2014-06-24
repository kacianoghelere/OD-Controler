package br.com.rpgruler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Modo de uso das armas
 *
 * @author kaciano
 */
public class UseType extends Type {

    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Uso")
    private String title;

    /**
     * Cria nova instancia de WearType
     */
    public UseType() {
    }

    /**
     * Cria nova instancia de WearType
     *
     * @param id <code>Long</code> Código do tipo
     * @param typeName <code>String</code> Titulo do tipo
     */
    public UseType(Long id, String typeName) {
        this.id = id;
        this.title = typeName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.title);
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
        final UseType other = (UseType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.title, other.title);
    }

    @Override
    public String toString() {
        return title;
    }

    /**
     * Retorna o Código do tipo
     *
     * @return <code>Long</code> Código do tipo
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo
     *
     * @param id <code>Long</code> Código do tipo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo do tipo
     *
     * @return <code>String</code> Titulo do tipo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Titulo do tipo
     *
     * @param title <code>String</code> Titulo do tipo
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
