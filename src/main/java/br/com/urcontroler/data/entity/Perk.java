package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade de vantagens
 *
 * @author kaciano
 * @version 1.0
 */
public class Perk {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;
    @ColumnName(name = "Descrição")
    private String description;
    @ColumnName(name = "Tipo")
    private PerkType type;

    /**
     * Cria nova instancia de Perk
     */
    public Perk() {
    }

    /**
     * Cria nova instancia de Perk
     *
     * @param id {@code Long} Código
     * @param title {@code String} Titulo
     * @param description {@code String} Descrição
     * @param type {@code PerkType} Tipo do perk
     */
    public Perk(Long id, String title, String description, PerkType type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    /**
     * Retorna o Id do Perk
     *
     * @return {@code Long}
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id do Perk
     *
     * @param id {@code Long}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do Perk
     *
     * @return {@code String}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do Perk
     *
     * @param title {@code String}
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna a descrição do Perk
     *
     * @return {@code String}
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a descrição do Perk
     *
     * @param description {@code String}
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o tipo do Perk
     *
     * @return {@code PerkType}
     */
    public PerkType getType() {
        return type;
    }

    /**
     * Modifica o tipo do Perk
     *
     * @param type {@code PerkType}
     */
    public void setType(PerkType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Perk other = (Perk) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return this.title;
    }

}
