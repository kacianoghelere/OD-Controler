package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade dos elementos
 *
 * @author kaciano
 * @version 1.0
 */
public class Element {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;
    @ColumnName(name = "Simbolo")
    private String symbol;
    @ColumnName(name = "Bonûs")
    private Element bonus;
    @ColumnName(name = "Fraqueza")
    private Element weakness;

    /**
     * Cria nova instancia de Element
     */
    public Element() {
    }

    /**
     * Cria nova instancia de Element
     *
     * @param id <code>Long</code> ID do elemento
     * @param title <code>String</code> Titulo do elemento
     * @param symbol <code>String</code> Simbolo do elemento
     */
    public Element(Long id, String title, String symbol) {
        this.id = id;
        this.title = title;
        this.symbol = symbol;
    }

    /**
     * Cria nova instancia de Element
     *
     * @param id <code>Long</code> ID do elemento
     * @param title <code>String</code> Titulo do elemento
     * @param symbol <code>String</code> Simbolo do elemento
     * @param bonus <code>Element</code> Elemento de ganho
     * @param weakness <code>Element</code> Elemento de perda
     */
    public Element(Long id, String title, String symbol, Element bonus, Element weakness) {
        this.id = id;
        this.title = title;
        this.symbol = symbol;
        this.bonus = bonus;
        this.weakness = weakness;
    }

    /**
     * Retorna o ID do elemento
     *
     * @return <code>Long</code> ID do elemento
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do elemento
     *
     * @param id <code>Long</code> ID do elemento
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo do elemento
     *
     * @return <code>String</code> Titulo do elemento
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Titulo do elemento
     *
     * @param title <code>String</code> Titulo do elemento
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o Simbolo do elemento
     *
     * @return <code>String</code> Simbolo do elemento
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Modifica o Simbolo do elemento
     *
     * @param symbol <code>String</code> Simbolo do elemento
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Retorna o Elemento de ganho
     *
     * @return <code>Element</code> Elemento de ganho
     */
    public Element getBonus() {
        return bonus;
    }

    /**
     * Modifica o Elemento de ganho
     *
     * @param bonus <code>Element</code> Elemento de ganho
     */
    public void setBonus(Element bonus) {
        this.bonus = bonus;
    }

    /**
     * Retorna o Elemento de perda
     *
     * @return <code>Element</code> Elemento de perda
     */
    public Element getWeakness() {
        return weakness;
    }

    /**
     * Modifica o Elemento de perda
     *
     * @param weakness <code>Element</code> Elemento de perda
     */
    public void setWeakness(Element weakness) {
        this.weakness = weakness;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.symbol);
        hash = 53 * hash + Objects.hashCode(this.bonus);
        hash = 53 * hash + Objects.hashCode(this.weakness);
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
        final Element other = (Element) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        if (!Objects.equals(this.bonus, other.bonus)) {
            return false;
        }
        return Objects.equals(this.weakness, other.weakness);
    }

    @Override
    public String toString() {
        return title;
    }

}
