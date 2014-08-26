package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import br.com.odcontroler.data.enums.Category;
import java.util.Objects;

/**
 * Entidade de registro das magias
 *
 * @author kaciano
 * @version 1.0
 */
public class Spell {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Círculo")
    private Integer circle;
    @Editable
    @ColumnName(name = "Tipo")
    private SpellType type;
    @Editable
    @ColumnName(name = "Categoria")
    private Category category;
    @Editable
    @ColumnName(name = "Alcance")
    private String range;
    @Editable
    @ColumnName(name = "Duração")
    private String duration;
    @Editable
    @ColumnName(name = "Descrição")
    private String description;

    /**
     * Cria nova instancia de Spell
     */
    public Spell() {
    }

    /**
     * Cria nova instancia de Spell
     *
     * @param id {@code Long} Id do Spell
     * @param name {@code String} Nome do Spell
     * @param circle {@code Integer} O circulo do Spell
     * @param type {@code SpellType} Tipo do Spell
     * @param category {@code Category} Categoria do Spell
     * @param range {@code String} O alcance do Spell
     * @param duration {@code String} Duração do Spell
     * @param description {@code String} Descrição do Spell
     */
    public Spell(Long id, String name, Integer circle, SpellType type,
            Category category, String range, String duration, String description) {
        this.id = id;
        this.name = name;
        this.circle = circle;
        this.type = type;
        this.category = category;
        this.range = range;
        this.duration = duration;
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Spell other = (Spell) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna o Id do Spell
     *
     * @return {@code Long} Id do Spell
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id do Spell
     *
     * @param id {@code Long} Id do Spell
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome do Spell
     *
     * @return {@code String} Nome do Spell
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do Spell
     *
     * @param name {@code String} Nome do Spell
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o titulo do Perk
     *
     * @return {@code Integer} O circulo do Spell
     */
    public Integer getCircle() {
        return circle;
    }

    /**
     * Modifica o circulo do Spell
     *
     * @param circle name {@code Integer} O circulo do Spell
     */
    public void setCircle(Integer circle) {
        this.circle = circle;
    }

    /**
     * Retorna o tipo do SpellType
     *
     * @return {@code SpellType} Tipo do SpellType
     */
    public SpellType getType() {
        return type;
    }

    /**
     * Modifica o tipo do SpellType
     *
     * @param type {@code SpellType} Tipo do SpellType
     */
    public void setType(SpellType type) {
        this.type = type;
    }

    /**
     * Retorna o Category do SpellType
     *
     * @return {@code Category} Category do SpellType
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Modifica o Category do SpellType
     *
     * @param category {@code Category} Category do SpellType
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Retorna O alcance do Spell
     *
     * @return {@code String} O alcance do Spell
     */
    public String getRange() {
        return range;
    }

    /**
     * Modifica O alcance do Spell
     *
     * @param range {@code String} O alcance do Spell
     */
    public void setRange(String range) {
        this.range = range;
    }

    /**
     * Retorna a Duração do Spell
     *
     * @return {@code String} Duração do Spell
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Modifica a Duração do Spell
     *
     * @param duration {@code String} Duração do Spell
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Retorna a descrição do Spell
     *
     * @return {@code String} Descrição do Spell
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a descrição do Spell
     *
     * @param description {@code String} Descrição do Spell
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
