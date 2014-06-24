package br.com.rpgruler.data.entity;

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
    @Editable
    @ColumnName(name = "Descrição")
    private String description;
    @ColumnName(name = "Tipo de armadura")
    private ArmorType type;
    @ColumnName(name = "Resistencia")
    private Double resistence;
    @ColumnName(name = "Preço")
    private Double price;
    @ColumnName(name = "Material 1")
    private PrimeMaterial material1;
    @ColumnName(name = "Material 2")
    private PrimeMaterial material2;
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
     * @param id <code>Long</code> ID da armadura
     * @param name <code>String</code> Nome da armadura
     * @param description <code>String</code> Descrição da armadura
     * @param type <code>ArmorType</code> Tipo da armadura
     * @param price <code>Double</code> Preço da armadura
     * @param material1 <code>PrimeMaterial</code> Material 1
     * @param material2 <code>PrimeMaterial</code> Material 2
     * @param attributes <code>Attributes</code> Atributos da armadura
     */
    public Armor(Long id, String name, String description, ArmorType type, Double price, PrimeMaterial material1, PrimeMaterial material2, Attributes attributes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.price = price;
        this.material1 = material1;
        this.material2 = material2;
        this.attributes = attributes;
        this.effects = new ArrayList<>();
        this.restriction = new ArrayList<>();
    }

    /**
     * Calcula a resistencia da armadura com base nos materiais e na resistencia
     * basica
     */
    public void calcResistence() {
        this.resistence = ((material1.getResistence() * type.getMaterialAmount1())
                + (material2.getResistence() * type.getMaterialAmount2())
                + type.getBase());
    }

    /**
     * Retorna o ID da armadura
     *
     * @return <code>Long</code> ID da armadura
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da armadura
     *
     * @param id <code>Long</code> ID da armadura
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da armadura
     *
     * @return <code>String</code> Nome da armadura
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da armadura
     *
     * @param name <code>String</code> Nome da armadura
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a Descrição da armadura
     *
     * @return <code>String</code> Descrição da armadura
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição da armadura
     *
     * @param description <code>String</code> Descrição da armadura
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o Tipo da armadura
     *
     * @return <code>ArmorType</code> Tipo da armadura
     */
    public ArmorType getType() {
        return type;
    }

    /**
     * Modifica o Tipo da armadura
     *
     * @param type <code>ArmorType</code> Tipo da armadura
     */
    public void setType(ArmorType type) {
        this.type = type;
    }

    /**
     * Retorna a Resistencia da armadura
     *
     * @return <code>Double</code> Resistencia da armadura
     */
    public Double getResistence() {
        return resistence;
    }

    /**
     * Modifica a Resistencia da armadura
     *
     * @param resistence <code>Double</code> Resistencia da armadura
     */
    public void setResistence(Double resistence) {
        this.resistence = resistence;
    }

    /**
     * Retorna o preço da armadura
     *
     * @return <code>Double</code> Preço da armadura
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Modifica o preço da armadura
     *
     * @param price <code>Double</code> Preço da armadura
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
     * Retorna os atributos
     *
     * @return <code>Attributes</code> Atributos
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     * Modifica os atributos
     *
     * @param attributes <code>Attributes</code> Atributos
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.material1);
        hash = 53 * hash + Objects.hashCode(this.material2);
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
        if (!Objects.equals(this.material1, other.material1)) {
            return false;
        }
        return Objects.equals(this.material2, other.material2);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
