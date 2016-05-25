package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade de controle para itens gerais
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class Item {

    @Ignore
    @Id
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
    private double weight;
    @Editable
    @ColumnName(name = "Preço")
    private int price;

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
     * @param weight {@code double} Peso do item
     * @param price {@code int} Preço do item
     */
    public Item(Long id, String name, ItemType type, String description, double weight, int price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
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
     * @return {@code double} Peso do item
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Modifica o Peso do item
     *
     * @param weight {@code double} Peso do item
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Retorna o Preço do item
     *
     * @return {@code int} Preço do item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Modifica o Preço do item
     *
     * @param price {@code int} Preço do item
     */
    public void setPrice(int price) {
        this.price = price;
    }

}
