package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    @ColumnName(name = "Tipo de armadura")
    private ArmorType type;
    @ColumnName(name = "CA")
    private String armorClass;
    @ColumnName(name = "Preço")
    private Double price;
    @ColumnName(name = "Material")
    private PrimeMaterial material;
    @Ignore
    @ColumnName(name = "Atributos")
    private Attributes attributes;
    @Ignore
    @ColumnName(name = "Restrições")
    private List<Restriction> restriction;
    @Ignore
    @ColumnName(name = "Efeitos")
    private List<Effect> effects;

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
     * @param description {@code String} Descrição da armadura
     * @param type {@code ArmorType} Tipo da armadura
     * @param price {@code Double} Preço da armadura
     * @param material {@code PrimeMaterial} Material
     * @param attributes {@code Attributes} Atributos da armadura
     */
    public Armor(Long id, String name, String description,
            ArmorType type, Double price, PrimeMaterial material,
            Attributes attributes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.material = material;
        this.attributes = attributes;
        this.effects = new ArrayList<>();
        this.restriction = new ArrayList<>();
    }

    /**
     * Cria nova instancia de Armor
     *
     * @param id {@code Long} ID da armadura
     * @param name {@code String} Nome da armadura
     * @param origin {@code Origin} Origem da armadura
     * @param description {@code String} Descrição da armadura
     * @param type {@code ArmorType} Tipo da armadura
     * @param price {@code Double} Preço da armadura
     * @param material {@code PrimeMaterial} Material 1
     * @param attributes {@code Attributes} Atributos da armadura
     */
    public Armor(Long id, String name, Origin origin, String description,
            ArmorType type, Double price, PrimeMaterial material,
            Attributes attributes) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.type = type;
        this.price = price;
        this.material = material;
        this.attributes = attributes;
        this.effects = new ArrayList<>();
        this.restriction = new ArrayList<>();
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
     * @return {@code String} Resistencia da armadura
     */
    public String getArmorClass() {
        return armorClass;
    }

    /**
     * Modifica a Resistencia da armadura
     *
     * @param armorClass {@code String} Resistencia da armadura
     */
    public void setArmorClass(String armorClass) {
        this.armorClass = armorClass;
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
     * Retorna os atributos
     *
     * @return {@code Attributes} Atributos
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Modifica os atributos
     *
     * @param attributes {@code Attributes} Atributos
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     * Modifica as restrições
     *
     * @return {@code List(Restriction)} Restrições
     */
    public List<Restriction> getRestriction() {
        return restriction;
    }

    /**
     * Retorna as restrições
     *
     * @param restriction {@code List(Restriction)} Restrições
     */
    public void setRestriction(List<Restriction> restriction) {
        this.restriction = restriction;
    }

    /**
     * Modifica os efeitos
     *
     * @return {@code List(Effect)} Efeitos
     */
    public List<Effect> getEffects() {
        return effects;
    }

    /**
     * Retorna os efeitos
     *
     * @param effects {@code List(Effect)} Efeitos
     */
    public void setEffects(List<Effect> effects) {
        this.effects = effects;
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
