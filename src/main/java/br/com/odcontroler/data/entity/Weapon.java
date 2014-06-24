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
    @Editable
    @ColumnName(name = "Descrição")
    private String description;
    @ColumnName(name = "Dano")    
    private Double damage;    
    @ColumnName(name = "Preço")
    private Double price;
    @ColumnName(name = "Tipo")
    private WeaponType type;
    @ColumnName(name = "Material 1")
    private PrimeMaterial material1;
    @ColumnName(name = "Material 2")
    private PrimeMaterial material2;
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
     * @param id <code>Long</code> ID da arma
     * @param name <code>String</code> Nome da arma
     * @param description <code>String</code> Descrição da arma
     * @param damage <code>Double</code> Dano da arma
     * @param price <code>Double</code> Preço da arma
     * @param type <code>WeaponType</code> Tipo de arma
     * @param material1 <code>PrimeMaterial</code> Quantidade do material 1
     * @param material2 <code>PrimeMaterial</code> Quantidade do material 2
     */
    public Weapon(Long id, String name, String description, Double damage, Double price, WeaponType type, PrimeMaterial material1, PrimeMaterial material2) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.damage = (double) 0;
        this.price = price;
        this.type = type;
        this.material1 = material1;
        this.material2 = material2;
        this.restriction = new ArrayList<>();
        this.effects = new ArrayList<>();
    }

    /**
     * Calcula o dano da arma
     */
    public void calcDamage() {
        this.damage = ((material1.getResistence() * type.getMaterialAmount1())
                + (material2.getResistence() * type.getMaterialAmount2())
                + type.getDamageBase());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.price);
        hash = 97 * hash + Objects.hashCode(this.type);
        hash = 97 * hash + Objects.hashCode(this.material1);
        hash = 97 * hash + Objects.hashCode(this.material2);
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
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.material1, other.material1)) {
            return false;
        }
        return Objects.equals(this.material2, other.material2);
    }

    /**
     * Retorna o ID da arma
     *
     * @return <code>Long</code> ID da arma
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da arma
     *
     * @param id <code>Long</code> ID da arma
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da arma
     *
     * @return <code>String</code> Nome da arma
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da arma
     *
     * @param name <code>String</code> Nome da arma
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a Descrição da arma
     *
     * @return <code>String</code> Descrição da arma
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição da arma
     *
     * @param description <code>String</code> Descrição da arma
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o Tipo da arma
     *
     * @return <code>WeaponType</code> Tipo da arma
     */
    public WeaponType getType() {
        return type;
    }

    /**
     * Modifica o Tipo da arma
     *
     * @param type <code>WeaponType</code> Tipo da arma
     */
    public void setType(WeaponType type) {
        this.type = type;
    }

    /**
     * Retorna a Resistencia da arma
     *
     * @return <code>Double</code> Resistencia da arma
     */
    public Double getDamage() {
        return damage;
    }

    /**
     * Modifica a Resistencia da arma
     *
     * @param damage <code>Double</code> Resistencia da arma
     */
    public void setDamage(Double damage) {
        this.damage = damage;
    }

    /**
     * Retorna o preço da arma
     *
     * @return <code>Double</code> Preço da arma
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Modifica o preço da arma
     *
     * @param price <code>Double</code> Preço da arma
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Retorna o Material 1
     *
     * @return <code>PrimeMaterial</code> Material 1
     */
    public PrimeMaterial getMaterial1() {
        return material1;
    }

    /**
     * Modifica o Material 1
     *
     * @param material1 <code>PrimeMaterial</code> Material 1
     */
    public void setMaterial1(PrimeMaterial material1) {
        this.material1 = material1;
    }

    /**
     * Retorna o Material 2
     *
     * @return <code>PrimeMaterial</code> Material 2
     */
    public PrimeMaterial getMaterial2() {
        return material2;
    }

    /**
     * Modifica o Material 2
     *
     * @param material2 <code>PrimeMaterial</code> Material 2
     */
    public void setMaterial2(PrimeMaterial material2) {
        this.material2 = material2;
    }

    /**
     * Modifica as restrições
     *
     * @return <code>List(Restriction)</code> Restrições
     */
    public List<Restriction> getRestriction() {
        return restriction;
    }

    /**
     * Retorna as restrições
     *
     * @param restriction <code>List(Restriction)</code> Restrições
     */
    public void setRestriction(List<Restriction> restriction) {
        this.restriction = restriction;
    }

    /**
     * Modifica os efeitos
     *
     * @return <code>List(Effect)</code> Efeitos
     */
    public List<Effect> getEffects() {
        return effects;
    }

    /**
     * Retorna os efeitos
     *
     * @param effects <code>List(Effect)</code> Efeitos
     */
    public void setEffects(List<Effect> effects) {
        this.effects = effects;
    }
}
