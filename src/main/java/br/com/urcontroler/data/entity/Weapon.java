package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.enums.Dice;
import java.util.Objects;

/**
 * Entidade das armas
 *
 * @author kaciano
 * @version 1.0
 */
public class Weapon {

    @Ignore
    @Id
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
    private int initiative;
    @Editable
    @ColumnName(name = "Alcance")
    private int range;
    @Editable
    @ColumnName(name = "Qt. Dano")
    private int dmgAmount;
    @Editable
    @ColumnName(name = "Dado")
    private Dice dice;
    @Ignore
    @Editable
    @ColumnName(name = "Peso")
    private double weight;
    @Ignore
    @Editable
    @ColumnName(name = "Preço")
    private int price;
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
     * @param id {@code Long} Id da arma
     * @param name {@code String} Nome da arma
     * @param origin {@code Origin} Origem da arma
     * @param description {@code String} Descrição da arma
     * @param initiative {@code int} Classificação do tipo
     * @param range {@code double} Alcance da arma
     * @param dmgAmount {@code int} Quantidade de dano da arma
     * @param dice {@code Dice} Dado de dano da arma
     * @param weight {@code double} Peso da arma
     * @param price {@code int} Preço da arma
     * @param type {@code WeaponType} Tipo de arma
     * @param material {@code PrimeMaterial} Quantidade do material
     * @param alignment {@code Align} Alinhamento
     */
    public Weapon(Long id, String name, Origin origin, String description,
            int initiative, int range, int dmgAmount, Dice dice, double weight,
            int price, WeaponType type, MaterialType material, Alignment alignment) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.description = description;
        this.initiative = initiative;
        this.range = range;
        this.dmgAmount = dmgAmount;
        this.weight = weight;
        this.price = price;
        this.type = type;
        this.material = material;
        this.alignment = alignment;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna o Id da arma
     *
     * @return {@code Long} Id da arma
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id da arma
     *
     * @param id {@code Long} Id da arma
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
     * @return {@code int} Dano da arma
     */
    public int getDmgAmount() {
        return dmgAmount;
    }

    /**
     * Modifica o dano da arma
     *
     * @param dmgAmount {@code int} Dano da arma
     */
    public void setDmgAmount(int dmgAmount) {
        this.dmgAmount = dmgAmount;
    }

    /**
     * Retorna o dado de dano da arma
     *
     * @return {@code Dice} Dado de dano da arma
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Modifica o dado de dano da arma
     *
     * @param dice {@code Dice} Dado de dano da arma
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    /**
     * Retorna o preço da arma
     *
     * @return {@code int} Preço da arma
     */
    public int getPrice() {
        return price;
    }

    /**
     * Modifica o preço da arma
     *
     * @param price {@code int} Preço da arma
     */
    public void setPrice(int price) {
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
     * @return {@code int} Iniciativa da arma
     */
    public int getInitiative() {
        return initiative;
    }

    /**
     * Modifica a iniciativa da arma
     *
     * @param initiative {@code int} Iniciativa da arma
     */
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    /**
     * Retorna o peso da arma
     *
     * @return {@code double} Peso da arma
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Modifica o peso da arma
     *
     * @param weight {@code double} Peso da arma
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Retorna o alcance da arma
     *
     * @return {@code int} Alcance da arma
     */
    public int getRange() {
        return range;
    }

    /**
     * Modifica o alcance da arma
     *
     * @param range {@code int} Alcance da arma
     */
    public void setRange(int range) {
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
