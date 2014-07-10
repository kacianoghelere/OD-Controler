package br.com.odcontroler.data.entity;

import br.com.odcontroler.data.enums.Align;
import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class Armor implements Serializable {

    @NotCopiable
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @ColumnName(name = "Origem")
    private Origin origin;
    @Editable
    @ColumnName(name = "Descrição")
    private String description;
    @ColumnName(name = "Tipo")
    private ArmorType type;
    @Editable
    @ColumnName(name = "CA")
    private Integer armorClass;
    @Editable
    @ColumnName(name = "Red. Movimento")
    private Integer movReduction;
    @Editable
    @ColumnName(name = "Preço")
    private Double price;
    @ColumnName(name = "Material")
    private PrimeMaterial material;
    @ColumnName(name = "Alinhamento")
    private Align align;

    /**
     * Cria nova instancia de Armor
     */
    public Armor() {
    }

    /**
     * Cria nova instancia de Armor
     *
     * @param id {@code Long} ID da armadura
     * @param name {@code String} Nome da armadura
     * @param origin {@code Origin} Origem da armadura
     * @param description {@code String} Descrição da armadura
     * @param type {@code ArmorType} Tipo da armadura
     * @param armorClass {@code Integer} Classe de armadura
     * @param movReduction {@code Integer} Redução de Movimento
     * @param price {@code Double} Preço da armadura
     * @param material {@code PrimeMaterial} Material
     * @param align {@code Align} Alinhamento
     */
    public Armor(Long id, String name, Origin origin, String description,
            ArmorType type, Integer armorClass, Integer movReduction,
            Double price, PrimeMaterial material, Align align) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.type = type;
        this.armorClass = armorClass;
        this.movReduction = movReduction;
        this.price = price;
        this.material = material;
        this.align = align;
    }

    /**
     * Retorna o ID da armadura
     *
     * @return {@code Long} ID da armadura
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da armadura
     *
     * @param id {@code Long} ID da armadura
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da armadura
     *
     * @return {@code String} Nome da armadura
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da armadura
     *
     * @param name {@code String} Nome da armadura
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Origem da armadura
     *
     * @return {@code Origin} Origem da armadura
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * Modifica o Origem da armadura
     *
     * @param origin {@code Origin} Origem da armadura
     */
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    /**
     * Retorna a Descrição da armadura
     *
     * @return {@code String} Descrição da armadura
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição da armadura
     *
     * @param description {@code String} Descrição da armadura
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o Tipo da armadura
     *
     * @return {@code ArmorType} Tipo da armadura
     */
    public ArmorType getType() {
        return type;
    }

    /**
     * Modifica o Tipo da armadura
     *
     * @param type {@code ArmorType} Tipo da armadura
     */
    public void setType(ArmorType type) {
        this.type = type;
    }

    /**
     * Retorna a Resistencia da armadura
     *
     * @return {@code Integer} Resistencia da armadura
     */
    public Integer getArmorClass() {
        return armorClass;
    }

    /**
     * Modifica a Resistencia da armadura
     *
     * @param armorClass {@code Integer} Resistencia da armadura
     */
    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }

    /**
     * Retorna a a redução de movimento
     *
     * @return {@code Integer} Redução de movimento
     */
    public Integer getMovReduction() {
        return movReduction;
    }

    /**
     * Modifica a redução de movimento
     *
     * @param movReduction {@code Integer} Redução de movimento
     */
    public void setMovReduction(Integer movReduction) {
        this.movReduction = movReduction;
    }

    /**
     * Retorna o preço da armadura
     *
     * @return {@code Double} Preço da armadura
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Modifica o preço da armadura
     *
     * @param price {@code Double} Preço da armadura
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Retorna o Material
     *
     * @return {@code PrimeMaterial} Material
     */
    public PrimeMaterial getMaterial() {
        return material;
    }

    /**
     * Modifica o Material
     *
     * @param material {@code PrimeMaterial} Material
     */
    public void setMaterial(PrimeMaterial material) {
        this.material = material;
    }

    /**
     * Retorna o Alinhamento
     *
     * @return {@code Align} Alinhamento
     */
    public Align getAlign() {
        return align;
    }

    /**
     * Modifica o Alinhamento
     *
     * @param align {@code Align} Alinhamento
     */
    public void setAlign(Align align) {
        this.align = align;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.material);
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
        final Armor other = (Armor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return Objects.equals(this.material, other.material);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
