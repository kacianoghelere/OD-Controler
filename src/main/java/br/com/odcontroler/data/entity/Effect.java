package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade para registro de efeitos
 *
 * @author kaciano
 */
public class Effect implements Serializable {

    @NotCopiable
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;
    @Editable
    @ColumnName(name = "Proporção")
    private Double strength;
    @ColumnName(name = "Tipo")
    private EffectType type;

    /**
     * Cria nova instancia de efeito
     */
    public Effect() {
    }

    /**
     * Cria nova instancia de efeito
     *
     * @param id <code>Long</code> ID do efeito
     * @param title <code>String</code> Titulo do efeito
     * @param strength <code>Double</code> Força do efeito
     */
    public Effect(Long id, String title, Double strength) {
        this.id = id;
        this.title = title;
        this.strength = strength;
    }

    /**
     * Cria nova instancia de efeito
     *
     * @param id <code>Long</code> ID do efeito
     * @param title <code>String</code> Titulo do efeito
     * @param strength <code>Double</code> Força do efeito
     * @param type <code>EffectType</code> Tipo do efeito
     */
    public Effect(Long id, String title, Double strength, EffectType type) {
        this.id = id;
        this.title = title;
        this.strength = strength;
        this.type = type;
    }

    /**
     * Retorna o ID do efeito
     *
     * @return <code>Long</code> ID do efeito
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do efeito
     *
     * @param id <code>Long</code> ID do efeito
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do efeito
     *
     * @return <code>String</code> Titulo do efeito
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do efeito
     *
     * @param title <code>String</code> Titulo do efeito
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna a força do efeito
     *
     * @return <code>Double</code> Força do efeito
     */
    public Double getStrength() {
        return strength;
    }

    /**
     * Modifica a força do efeito
     *
     * @param strength <code>Double</code> Força do efeito
     */
    public void setStrength(Double strength) {
        this.strength = strength;
    }

    /**
     * Retorna o Tipo do efeito
     *
     * @return <code>EffectType</code> Tipo do efeito
     */
    public EffectType getType() {
        return type;
    }

    /**
     * Modifica o Tipo do efeito
     *
     * @param type <code>EffectType</code> Tipo do efeito
     */
    public void setType(EffectType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.strength);
        hash = 37 * hash + Objects.hashCode(this.type);
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
        final Effect other = (Effect) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.strength, other.strength)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return title;
    }

}
