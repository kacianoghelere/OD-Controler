package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import br.com.odcontroler.data.enums.Alignment;
import br.com.odcontroler.data.enums.Attribute;
import br.com.odcontroler.data.enums.ClassType;
import br.com.odcontroler.data.enums.Dice;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Entidade das classes de personagem
 *
 * @author kaciano
 * @version 1.0
 */
public class ClassBase implements Serializable {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Dado de Vida")
    private Dice lifeDice;
    @Editable
    @ColumnName(name = "CA Bônus")
    private Integer armorBonus;
    @ColumnName(name = "Atributo Chave")
    private Attribute keyAttribute;
    @ColumnName(name = "Tipo da classe")
    private ClassType type;
    @ColumnName(name = "Alinhamento")
    private Alignment alignment;
    @Ignore
    @ColumnName(name = "Descrição")
    private String description;
    @Ignore
    @ColumnName(name = "Requerimentos")
    private Requirement requirement;
    @Ignore
    @ColumnName(name = "Níveis de classes")
    private List<ClassLevel> classLevels;
    @Ignore
    @ColumnName(name = "Armaduras Permitidas")
    private List<ArmorType> allowedArmors;
    @Ignore
    @ColumnName(name = "Armas Permitidas")
    private List<WeaponType> allowedWeapons;
    @Ignore
    @ColumnName(name = "Itens Permitidas")
    private List<ItemType> allowedItems;
    @Ignore
    @ColumnName(name = "Perícias Exclusivas")
    private List<Expertise> allowedExpertises;
    @Ignore
    @ColumnName(name = "Magias por Circulos")
    private List<Integer[]> magicPerCircle;
    @Ignore
    @ColumnName(name = "Vantagens")
    private List<Perk> perks;
    
    /**
     * Cria nova instancia de CharClass
     */
    public ClassBase() {
    }

    /**
     * Cria nova instancia de CharClass
     *
     * @param id {@code Long} ID da classe
     * @param name {@code String} Nome da classe
     * @param lifeDice {@code Dice} Dado de vida
     * @param armorBonus {@code Integer} Bônus de armadura
     * @param keyAttribute {@code Attribute} Atributo chave
     * @param type {@code ClassType} Tipo da classe
     * @param alignment {@code Alignment} Alinhamento da classe
     * @param description {@code String} Descrição da classe
     * @param requirement {@code Requirement} Requerimentos da classe
     * @param classLevels {@code List(ClassLevel)} Niveis da classe
     * @param allowedArmors {@code List(ArmorType)} Armaduras permitidas
     * @param allowedWeapons {@code List(WeaponType)} Armas permitidas
     * @param allowedItems {@code List(ItemType)} Itens permitidos
     * @param allowedExpertises {@code List(Expertise)} Perícias exclusivas
     * @param magicPerCircle {@code List(Integer[])} Circulos de magia por nivel
     * @param perks {@code List(Perk)} Vantagens
     */
    public ClassBase(Long id, String name, Dice lifeDice, Integer armorBonus,
            Attribute keyAttribute, ClassType type, Alignment alignment, String description,
            Requirement requirement, List<ClassLevel> classLevels,
            List<ArmorType> allowedArmors, List<WeaponType> allowedWeapons,
            List<ItemType> allowedItems, List<Expertise> allowedExpertises,
            List<Integer[]> magicPerCircle,
            List<Perk> perks) {
        this.id = id;
        this.name = name;
        this.lifeDice = lifeDice;
        this.armorBonus = armorBonus;
        this.keyAttribute = keyAttribute;
        this.type = type;
        this.alignment = alignment;
        this.description = description;
        this.requirement = requirement;
        this.classLevels = classLevels;
        this.allowedArmors = allowedArmors;
        this.allowedWeapons = allowedWeapons;
        this.allowedItems = allowedItems;
        this.allowedExpertises = allowedExpertises;
        this.magicPerCircle = magicPerCircle;
        this.perks = perks;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ClassBase other = (ClassBase) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna o ID da classe
     *
     * @return {@code Long} ID da classe
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID da classe
     *
     * @param id {@code Long} ID da classe
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da classe
     *
     * @return {@code String} Nome da classe
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da classe
     *
     * @param name {@code String} Nome da classe
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Dado de vida
     *
     * @return {@code Dice} Dado de vida
     */
    public Dice getLifeDice() {
        return lifeDice;
    }

    /**
     * Modifica o Dado de vida
     *
     * @param lifeDice {@code Dice} Dado de vida
     */
    public void setLifeDice(Dice lifeDice) {
        this.lifeDice = lifeDice;
    }

    /**
     * Retorna o Bônus de armadura
     *
     * @return {@code Integer} Bônus de armadura
     */
    public Integer getArmorBonus() {
        return armorBonus;
    }

    /**
     * Modifica o Bônus de armadura
     *
     * @param armorBonus {@code Integer} Bônus de armadura
     */
    public void setArmorBonus(Integer armorBonus) {
        this.armorBonus = armorBonus;
    }

    /**
     * Retorna o Atributo chave
     *
     * @return {@code Attribute} Atributo chave
     */
    public Attribute getKeyAttribute() {
        return keyAttribute;
    }

    /**
     * Modifica o Atributo chave
     *
     * @param keyAttribute {@code Attribute} Atributo chave
     */
    public void setKeyAttribute(Attribute keyAttribute) {
        this.keyAttribute = keyAttribute;
    }

    /**
     * Retorna os Tipo da classe
     *
     * @return {@code ClassType} Tipo da classe
     */
    public ClassType getType() {
        return type;
    }

    /**
     * Modifica os Tipo da classe
     *
     * @param type {@code ClassType} Tipo da classe
     */
    public void setType(ClassType type) {
        this.type = type;
    }

    /**
     * Retorna o Alinhamento da classe
     *
     * @return {@code Alignment} Alinhamento da classe
     */
    public Alignment getAlignment() {
        return alignment;
    }

    /**
     * Modifica o Alinhamento da classe
     *
     * @param alignment {@code Alignment} Alinhamento da classe
     */
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    /**
     * Retorna a Descrição da classe
     *
     * @return {@code String} Descrição da classe
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a Descrição da classe
     *
     * @param description {@code String} Descrição da classe
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna os Requerimentos da classe
     *
     * @return {@code Requirement} Requerimentos da classe
     */
    public Requirement getRequirement() {
        return requirement;
    }

    /**
     * Modifica os Requerimentos da classe
     *
     * @param requirement {@code Requirement} Requerimentos da classe
     */
    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    /**
     * Retorna os Niveis da classe
     *
     * @return {@code List(ClassLevel)} Niveis da classe
     */
    public List<ClassLevel> getClassLevels() {
        return classLevels;
    }

    /**
     * Modifica os Niveis da classe
     *
     * @param classLevels {@code List(ClassLevel)} Niveis da classe
     */
    public void setClassLevels(List<ClassLevel> classLevels) {
        this.classLevels = classLevels;
    }

    /**
     * Retorna as Armaduras permitidas
     *
     * @return {@code List(ArmorType)} Armaduras permitidas
     */
    public List<ArmorType> getAllowedArmors() {
        return allowedArmors;
    }

    /**
     * Modifica as Armaduras permitidas
     *
     * @param allowedArmors {@code List(ArmorType)} Armaduras permitidas
     */
    public void setAllowedArmors(List<ArmorType> allowedArmors) {
        this.allowedArmors = allowedArmors;
    }

    /**
     * Retorna as Armas permitidas
     *
     * @return {@code List(WeaponType)} Armas permitidas
     */
    public List<WeaponType> getAllowedWeapons() {
        return allowedWeapons;
    }

    /**
     * Modifica as Armas permitidas
     *
     * @param allowedWeapons {@code List(WeaponType)} Armas permitidas
     */
    public void setAllowedWeapons(List<WeaponType> allowedWeapons) {
        this.allowedWeapons = allowedWeapons;
    }

    /**
     * Retorna os Itens permitidos
     *
     * @return {@code List(ItemType)} Itens permitidos
     */
    public List<ItemType> getAllowedItems() {
        return allowedItems;
    }

    /**
     * Modifica os Itens permitidos
     *
     * @param allowedItems {@code List(ItemType)} Itens permitidos
     */
    public void setAllowedItems(List<ItemType> allowedItems) {
        this.allowedItems = allowedItems;
    }

    /**
     * Retorna as Perícias exclusivas
     *
     * @return {@code List(Expertise)} Perícias exclusivas
     */
    public List<Expertise> getAllowedExpertises() {
        return allowedExpertises;
    }

    /**
     * Modifica as Perícias exclusivas
     *
     * @param allowedExpertises {@code List(Expertise)} Perícias exclusivas
     */
    public void setAllowedExpertises(List<Expertise> allowedExpertises) {
        this.allowedExpertises = allowedExpertises;
    }

    /**
     * Retorna os Circulos de magia por nivel
     *
     * @return {@code List(Integer[])} Circulos de magia por nivel
     */
    public List<Integer[]> getMagicPerCircle() {
        return magicPerCircle;
    }

    /**
     * Modifica os Circulos de magia por nivel
     *
     * @param magicPerCircle {@code List(Integer[])} Circulos de magia por nivel
     */
    public void setMagicPerCircle(List<Integer[]> magicPerCircle) {
        this.magicPerCircle = magicPerCircle;
    }

    /**
     * Retorna as Vantagens
     *
     * @return {@code List(Perk)} Vantagens
     */
    public List<Perk> getPerks() {
        return perks;
    }

    /**
     * Modifica as Vantagens
     *
     * @param perks {@code List(Perk)} Vantagens
     */
    public void setPerks(List<Perk> perks) {
        this.perks = perks;
    }

}
