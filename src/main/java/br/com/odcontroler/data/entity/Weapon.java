package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.ArrayList;
import java.util.List;
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
    @ColumnName(name = "Origem")
    private Origin origin;
    @Editable
    @ColumnName(name = "Descrição")
    private String description;
    @ColumnName(name = "Iniciativa")
    private Integer initiative;
    @ColumnName(name = "Dano")
    private Integer damage;
    @ColumnName(name = "Preço")
    private Integer price;
    @ColumnName(name = "Tipo")
    private WeaponType type;
    @ColumnName(name = "Material")
    private PrimeMaterial material;
    @Ignore
    @ColumnName(name = "Restrições")
    private List<Restriction> restriction;
    @Ignore
    @ColumnName(name = "Efeitos")
    private List<Effect> effects;

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
     * @param damage {@code String} Dano da arma
     * @param price {@code Integer} Preço da arma
     * @param type {@code WeaponType} Tipo de arma
     * @param material {@code PrimeMaterial} Quantidade do material 1
     */
    public Weapon(Long id, String name, Origin origin, String description,
            Integer initiative, String damage, Integer price, WeaponType type,
            PrimeMaterial material) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.initiative = initiative;
        this.damage = 0;
        this.price = price;
        this.type = type;
        this.material = material;
        this.restriction = new ArrayList<>();
        this.effects = new ArrayList<>();
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
     * Retorna a Resistencia da arma
     *
     * @return {@code Integer} Resistencia da arma
     */
    public Integer getDamage() {
        return damage;
    }

    /**
     * Modifica a Resistencia da arma
     *
     * @param damage {@code Integer} Resistencia da arma
     */
    public void setDamage(Integer damage) {
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

    /**
     * Retorna a Classificação do tipo
     *
     * @return {@code Integer} Classificação do tipo
     */
    public Integer getInitiative() {
        return initiative;
    }

    /**
     * Modifica a Classificação do tipo
     *
     * @param initiative {@code Integer} Classificação do tipo
     */
    public void setInitiative(Integer initiative) {
        this.initiative = initiative;
    }

}
