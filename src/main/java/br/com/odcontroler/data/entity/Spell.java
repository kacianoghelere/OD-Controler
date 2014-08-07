package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;

/**
 * Entidade de registro das magias
 *
 * @author kaciano
 * @version 1.0
 */
public class Spell {

    @NotCopiable
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
    @ColumnName(name = "Alcance")
    private String range;
    @Editable
    @ColumnName(name = "Duração")
    private String duration;
    @Editable
    @ColumnName(name = "Descrição")
    private String description;

    /**
     * Retorna o ID do Spell
     *
     * @return {@code Long} ID do Spell
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do Spell
     *
     * @param id {@code Long} ID do Spell
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
