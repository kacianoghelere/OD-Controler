package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import br.com.odcontroler.data.enums.Alignment;
import java.util.Objects;

/**
 * Entidade das armas
 *
 * @author kaciano
 * @version 1.0
 */
public class Weapon {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Origem")
    private Origin origin;
    @Ignore
    @Editable
    @ColumnName(name = "Descrição")
    private String description;
    @Editable
    @ColumnName(name = "Iniciativa")
    private Integer initiative;
    @Editable
    @ColumnName(name = "Alcance")
    private Integer range;
    @Editable
    @ColumnName(name = "Dano")
    private String damage;
    @Ignore
    @Editable
    @ColumnName(name = "Peso")
    private Double weight;
    @Ignore
    @Editable
    @ColumnName(name = "Preço")
    private Integer price;
    @Editable
    @ColumnName(name = "Tipo")
    private WeaponType type;
    @Editable
    @ColumnName(name = "Material")
    private MaterialType material;
    @Editable
    @ColumnName(name = "Alinhamento")
    private Alignment alignment;

    /**
     * Cria nova instancia de Weapon
     */
    public Weapon() {
    }

    /**
     * Cria nova instancia de Weapon
     *
     * @param id {@code Long} ID da arma
     * @param name {@code String} Nome da arma
     * @param origin {@code Origin} Origem da arma
     * @param description {@code String} Descrição da arma
     * @param initiative {@code Integer} Classificação do tipo
     * @param range {@code Double} Alcance da arma
     * @param damage {@code String} Dano da arma
     * @param weight {@code Double} Peso da arma
     * @param price {@code Integer} Preço da arma
     * @param type {@code WeaponType} Tipo de arma
     * @param material {@code PrimeMaterial} Quantidade do material
     * @param alignment {@code Align} Alinhamento
     */
    public Weapon(Long id, String name, Origin origin, String description,
            Integer initiative, Integer range, String damage, Double weight,
            Integer price, WeaponType type, MaterialType material, Alignment alignment) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.initiative = initiative;
        this.range = range;
        this.damage = damage;
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.material = material;
        this.alignment = alignment;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.origin);
        hash = 43 * hash + Objects.hashCode(this.type);
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
        final Weapon other = (Weapon) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.origin, other.origin)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    /**
     * Retorna o ID da arma
     *
     * @return {@code Long} ID da arma
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da arma
     *
     * @param id {@code Long} ID da arma
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da arma
     *
     * @return {@code String} Nome da arma
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da arma
     *
     * @param name {@code String} Nome da arma
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Origem da arma
     *
     * @return {@code Origin} Origem da arma
     */
    public Origin getOrigin() {
        return origin;
    }

    /**
     * Modifica o Origem da arma
     *
     * @param origin {@code Origin} Origem da arma
     */
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    /**
     * Retorna a Descrição da arma
     *
     * @return {@code String} Descrição da arma
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição da arma
     *
     * @param description {@code String} Descrição da arma
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o Tipo da arma
     *
     * @return {@code WeaponType} Tipo da arma
     */
    public WeaponType getType() {
        return type;
    }

    /**
     * Modifica o Tipo da arma
     *
     * @param type {@code WeaponType} Tipo da arma
     */
    public void setType(WeaponType type) {
        this.type = type;
    }

    /**
     * Retorna o dano da arma
     *
     * @return {@code String} Dano da arma
     */
    public String getDamage() {
        return damage;
    }

    /**
     * Modifica o dano da arma
     *
     * @param damage {@code String} Dano da arma
     */
    public void setDamage(String damage) {
        this.damage = damage;
    }

    /**
     * Retorna o preço da arma
     *
     * @return {@code Integer} Preço da arma
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Modifica o preço da arma
     *
     * @param price {@code Integer} Preço da arma
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Retorna o MaterialType
     *
     * @return {@code PrimeMaterial} MaterialType
     */
    public MaterialType getMaterial() {
        return material;
    }

    /**
     * Modifica o MaterialType
     *
     * @param material {@code PrimeMaterial} MaterialType
     */
    public void setMaterial(MaterialType material) {
        this.material = material;
    }

    /**
     * Retorna a iniciativa da arma
     *
     * @return {@code Integer} Iniciativa da arma
     */
    public Integer getInitiative() {
        return initiative;
    }

    /**
     * Modifica a iniciativa da arma
     *
     * @param initiative {@code Integer} Iniciativa da arma
     */
    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

    /**
     * Retorna o peso da arma
     *
     * @return {@code Double} Peso da arma
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Modifica o peso da arma
     *
     * @param weight {@code Double} Peso da arma
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Retorna o alcance da arma
     *
     * @return {@code Integer} Alcance da arma
     */
    public Integer getRange() {
        return range;
    }

    /**
     * Modifica o alcance da arma
     *
     * @param range {@code Integer} Alcance da arma
     */
    public void setRange(Integer range) {
        this.range = range;
    }

    /**
     * Retorna o Alinhamento
     *
     * @return {@code Align} Alinhamento
     */
    public Alignment getAlignment() {
        return alignment;
    }

    /**
     * Modifica o Alinhamento
     *
     * @param alignment {@code Align} Alinhamento
     */
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }
}
