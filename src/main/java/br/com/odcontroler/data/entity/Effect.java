package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade para registro de efeitos
 *
 * @author kaciano
 */
public class Effect implements Serializable {

    @Id
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
     * @param id {@code Long} Id do efeito
     * @param title {@code String} Titulo do efeito
     * @param strength {@code Double} Força do efeito
     */
    public Effect(Long id, String title, Double strength) {
        this.id = id;
        this.title = title;
        this.strength = strength;
    }

    /**
     * Cria nova instancia de efeito
     *
     * @param id {@code Long} Id do efeito
     * @param title {@code String} Titulo do efeito
     * @param strength {@code Double} Força do efeito
     * @param type {@code EffectType} Tipo do efeito
     */
    public Effect(Long id, String title, Double strength, EffectType type) {
        this.id = id;
        this.title = title;
        this.strength = strength;
        this.type = type;
    }

    /**
     * Retorna o Id do efeito
     *
     * @return {@code Long} Id do efeito
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id do efeito
     *
     * @param id {@code Long} Id do efeito
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do efeito
     *
     * @return {@code String} Titulo do efeito
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do efeito
     *
     * @param title {@code String} Titulo do efeito
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna a força do efeito
     *
     * @return {@code Double} Força do efeito
     */
    public Double getStrength() {
        return strength;
    }

    /**
     * Modifica a força do efeito
     *
     * @param strength {@code Double} Força do efeito
     */
    public void setStrength(Double strength) {
        this.strength = strength;
    }

    /**
     * Retorna o Tipo do efeito
     *
     * @return {@code EffectType} Tipo do efeito
     */
    public EffectType getType() {
        return type;
    }

    /**
     * Modifica o Tipo do efeito
     *
     * @param type {@code EffectType} Tipo do efeito
     */
    public void setType(EffectType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return title;
    }

}
