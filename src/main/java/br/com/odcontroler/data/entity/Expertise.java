package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade das perícias
 *
 * @author kaciano
 * @version 1.0
 */
public class Expertise implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Titulo")
    private String title;
    @ColumnName(name = "Tipo")
    private ExpertiseType type;
    @ColumnName(name = "Atributo chave")
    private br.com.odcontroler.data.entity.attr.Attribute attribute;
    @Editable
    @ColumnName(name = "Modificador")
    private Integer mod;

    /**
     * Cria nova instancia de Expertise
     */
    public Expertise() {
    }

    /**
     * Cria nova instancia de Expertise
     *
     * @param id {@code Long} ID da perícia
     * @param title {@code String} Titulo da perícia
     * @param type {@code ExpertiseType} Tipo de perícia
     * @param attribute {@code Attribute} Atributo chave
     * @param value {@code Integer} Valor da perícia
     */
    public Expertise(Long id, String title, ExpertiseType type, br.com.odcontroler.data.entity.attr.Attribute attribute, Integer value) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.attribute = attribute;
        this.mod = value;
    }

    /**
     * Retorna o ID da perícia
     *
     * @return {@code Long} ID da perícia
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da perícia
     *
     * @param id {@code Long} ID da perícia
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo da perícia
     *
     * @return {@code String} Titulo da perícia
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo da perícia
     *
     * @param title {@code String} Titulo da perícia
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o tipo de perícia
     *
     * @return {@code ExpertiseType} Tipo de perícia
     */
    public ExpertiseType getType() {
        return type;
    }

    /**
     * Modifica o tipo de perícia
     *
     * @param type {@code ExpertiseType} Tipo de perícia
     */
    public void setType(ExpertiseType type) {
        this.type = type;
    }

    /**
     * Retorna o atributo chave
     *
     * @return {@code br.com.odcontroler.data.entity.attr.Attribute} Atributo chave
     */
    public br.com.odcontroler.data.entity.attr.Attribute getAttribute() {
        return attribute;
    }

    /**
     * Modifica o atributo chave
     *
     * @param attribute {@code br.com.odcontroler.data.entity.attr.Attribute} Atributo chave
     */
    public void setAttribute(br.com.odcontroler.data.entity.attr.Attribute attribute) {
        this.attribute = attribute;
    }

    /**
     * Retorna o modificador da perícia
     *
     * @return {@code Integer} Valor da perícia
     */
    public Integer getMod() {
        return mod;
    }

    /**
     * Modifica o modificador da perícia
     *
     * @param value {@code Integer} Valor da perícia
     */
    public void setMod(Integer value) {
        this.mod = value;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.type);
        hash = 89 * hash + Objects.hashCode(this.attribute);
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
        final Expertise other = (Expertise) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.attribute, other.attribute);
    }

    @Override
    public String toString() {
        return title + "(" + mod + ")";
    }

}
