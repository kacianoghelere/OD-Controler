package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Entidade de controle para itens gerais
 *
 * @author kaciano
 * @version 1.0
 */
public class Item {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Tipo")
    private ItemType type;
    @Editable
    @ColumnName(name = "Descrição")
    private String description;
    @Editable
    @ColumnName(name = "Peso")
    private Double weight;
    @Editable
    @ColumnName(name = "Preço")
    private Integer price;

    /**
     * Cria nova instância de Item
     */
    public Item() {
    }

    /**
     * Cria nova instância de Item
     *
     * @param id {@code Long} Código do item
     * @param name {@code String} Nome do item
     * @param type {@code ItemType} Tipo do item
     * @param description {@code String} Descrição do item
     * @param weight {@code Double} Peso do item
     * @param price {@code Integer} Preço do item
     */
    public Item(Long id, String name, ItemType type, String description, Double weight, Integer price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.type);
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    /**
     * Retorna o Código do item
     *
     * @return {@code Long} Código do item
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do item
     *
     * @param id {@code Long} Código do item
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do item
     *
     * @return {@code String} Nome do item
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do item
     *
     * @param name {@code String} Nome do item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Tipo do item
     *
     * @return {@code ItemType} Tipo do item
     */
    public ItemType getType() {
        return type;
    }

    /**
     * Modifica o Tipo do item
     *
     * @param type {@code ItemType} Tipo do item
     */
    public void setType(ItemType type) {
        this.type = type;
    }

    /**
     * Retorna a Descrição do item
     *
     * @return {@code String} Descrição do item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição do item
     *
     * @param description {@code String} Descrição do item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o Peso do item
     *
     * @return {@code Double} Peso do item
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Modifica o Peso do item
     *
     * @param weight {@code Double} Peso do item
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Retorna o Preço do item
     *
     * @return {@code Integer} Preço do item
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Modifica o Preço do item
     *
     * @param price {@code Integer} Preço do item
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

}
