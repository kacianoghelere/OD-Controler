package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import br.com.urcontroler.data.enums.SpellCategory;
import br.com.urcontroler.data.enums.SpellClass;
import java.util.Objects;

/**
 * Entidade de registro das magias
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class Spell {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name; //1
    @Editable
    @ColumnName(name = "Tipo")
    private SpellType type;//2
    @Editable
    @ColumnName(name = "Categoria")
    private SpellCategory category; //3
    @Editable
    @ColumnName(name = "Classificação")
    private SpellClass classification;//4
    @Editable
    @ColumnName(name = "Elemento")
    private ElementType elementType;//5
    @Editable
    @ColumnName(name = "Custo de Magia")
    private Integer magicCost;//6
    @Editable
    @ColumnName(name = "Alcance")
    private String range;//7
    @Editable
    @ColumnName(name = "Duração")
    private String duration;//8
    @Ignore
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
     * @param type {@code SpellType} Tipo do Spell
     * @param category {@code SpellCategory} Categoria do Spell
     * @param classification {@code SpellClass} Classificação do Spell
     * @param elementType {@code ElementType} Elemento
     * @param magicCost {@code Integer} Custo de magica
     * @param range {@code String} O alcance do Spell
     * @param duration {@code String} Duração do Spell
     * @param description {@code String} Descrição do Spell
     */
    public Spell(Long id, String name, SpellType type, SpellCategory category,
            SpellClass classification, ElementType elementType, Integer magicCost,
            String range, String duration, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.classification = classification;
        this.range = range;
        this.duration = duration;
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " - " + name;
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
     * Retorna o tipo do Spell
     *
     * @return {@code SpellType} Tipo do Spell
     */
    public SpellType getType() {
        return type;
    }

    /**
     * Modifica o tipo do Spell
     *
     * @param type {@code SpellType} Tipo do Spell
     */
    public void setType(SpellType type) {
        this.type = type;
    }

    /**
     * Retorna o SpellCategory do Spell
     *
     * @return {@code SpellCategory} SpellClass do Spell
     */
    public SpellCategory getCategory() {
        return category;
    }

    /**
     * Modifica o SpellCategory do Spell
     *
     * @param category {@code SpellCategory} Tipo do Spell
     */
    public void setCategory(SpellCategory category) {
        this.category = category;
    }

    /**
     * Retorna o SpellClass do Spell
     *
     * @return {@code SpellClass} SpellClass do Spell
     */
    public SpellClass getClassification() {
        return classification;
    }

    /**
     * Modifica o SpellClass do Spell
     *
     * @param classification {@code SpellClass} SpellClass do Spell
     */
    public void setClassification(SpellClass classification) {
        this.classification = classification;
    }

    /**
     * Retorna o elemento da magia
     *
     * @return {@code ElementType} Elemento
     */
    public ElementType getElementType() {
        return elementType;
    }

    /**
     * Modifica o elemento da magia
     *
     * @param elementType {@code ElementType} Elemento
     */
    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    /**
     * Retorna o Custo de magica
     *
     * @return {@code Integer} Custo de magica
     */
    public Integer getMagicCost() {
        return magicCost;
    }

    /**
     * Modifica o Custo de magica
     *
     * @param magicCost {@code Integer} Custo de magica
     */
    public void setMagicCost(Integer magicCost) {
        this.magicCost = magicCost;
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
