package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

/**
 * Entidade das classes de personagem
 * @author kaciano
 */
public class CharClass implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Titulo")
    private String title;

    @ColumnName(name = "Vantagens")
    @Ignore
    private Collection<Perk> perkCollection;

    /**
     *
     */
    public CharClass() {
    }

    /**
     * Cria nova instancia de CharClass
     *
     * @param id <code>Long</code> ID da classe
     */
    public CharClass(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final CharClass other = (CharClass) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return title;
    }

}
