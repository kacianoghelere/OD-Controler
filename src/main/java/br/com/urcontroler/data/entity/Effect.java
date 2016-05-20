package br.com.urcontroler.data.entity;

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
 * @version 1.0
 * @author kaciano
 * @version 1.1
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
    @ColumnName(name = "Descrição")
    private String description;
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
     * @param description {@code String} Descrição do efeito
     * @param type {@code EffectType} Tipo do efeito
     */
    public Effect(Long id, String title, String description, EffectType type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        return title;
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
     * @return {@code String} Descrição do efeito
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a força do efeito
     *
     * @param description {@code String} Descrição do efeito
     */
    public void setDescription(String description) {
        this.description = description;
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

}
