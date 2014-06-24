package br.com.odcontroler.data.entity;

import java.util.Objects;

/**
 * Entidade para controle dos atributos
 *
 * @author kaciano
 * @version 1.0
 */
public class Attribute {

    private Long id;
    private String name;
    private String alias;
    private Integer value;

    /**
     * Cria nova instancia de Attribute
     */
    public Attribute() {
    }

    /**
     * Cria nova instancia de Attribute
     *
     * @param id <code>Long</code> ID do atributo
     * @param name <code>String</code> Nome do atributo
     * @param alias <code>String</code> Sigla do atributo
     * @param value <code>Integer</code> Valor do atributo
     */
    public Attribute(Long id, String name, String alias, Integer value) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.value = value;
    }

    /**
     * Retorna o ID do atributo
     *
     * @return <code>Long</code> ID do atributo
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do atributo
     *
     * @param id <code>Long</code> ID do atributo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do atributo
     *
     * @return <code>String</code> Nome do atributo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do atributo
     *
     * @param name <code>String</code> Nome do atributo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a Sigla do atributo
     *
     * @return <code>String</code> Sigla do atributo
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Modifica a Sigla do atributo
     *
     * @param alias <code>String</code> Sigla do atributo
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retorna o Valor do atributo
     *
     * @return <code>Integer</code> Valor do atributo
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Modifica o Valor do atributo
     *
     * @param value <code>Integer</code> Valor do atributo
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.alias);
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
        final Attribute other = (Attribute) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.alias, other.alias);
    }
}
