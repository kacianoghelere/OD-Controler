package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Tipo de arma
 *
 * @author kaciano
 */
public class WeaponType extends Type {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;
    @Editable
    @ColumnName(name = "Dano base")
    private Double damageBase;
    @Editable
    @ColumnName(name = "Alcance")
    private Integer range;
    @ColumnName(name = "Tipo de dano")
    private DamageType damageType;
    @ColumnName(name = "Tamanho")
    private WeaponSize size;
    @Editable
    @ColumnName(name = "Categoria")
    private Integer category;
    @ColumnName(name = "Porte")
    private UseType wearType;
    @Editable
    @ColumnName(name = "Qtd. 1")
    private Double materialAmount1;
    @Editable
    @ColumnName(name = "Qtd. 2")
    private Double materialAmount2;

    /**
     * Cria nova instancia de WeaponType
     */
    public WeaponType() {
    }

    /**
     * Cria nova instancia de WeaponType
     *
     * @param id <code>Long</code> Código do tipo de arma
     * @param typeName <code>String</code> Titulo do tipo de arma
     * @param damageBase <code>Double</code> Dano base do tipo
     * @param category <code>Integer</code> Classificação do tipo
     * @param wearType <code>WearType</code> Tipo de porte
     * @param materialAmount1 <code>Double</code> Qtd. do material 1
     * @param materialAmount2 <code>Double</code> Qtd. do material 2
     */
    public WeaponType(Long id, String typeName, Double damageBase, Integer category, UseType wearType, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.title = typeName;
        this.damageBase = damageBase;
        this.category = category;
        this.wearType = wearType;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    /**
     *
     * @param id <code>Long</code> Código do tipo de arma
     * @param typeName <code>String</code> Titulo do tipo de arma
     * @param damageBase <code>Double</code> Dano base do tipo
     * @param range <code>Integer</code> Alcance da arma
     * @param size <code>WeaponSize</code> Tamanho da arma
     * @param category <code>Integer</code> Classificação do tipo
     * @param wearType <code>WearType</code> Tipo de porte
     * @param materialAmount1 <code>Double</code> Qtd. do material 1
     * @param materialAmount2 <code>Double</code> Qtd. do material 2
     */
    public WeaponType(Long id, String typeName, Double damageBase, Integer range, WeaponSize size, Integer category, UseType wearType, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.title = typeName;
        this.damageBase = damageBase;
        this.range = range;
        this.size = size;
        this.category = category;
        this.wearType = wearType;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    /**
     *
     * @param id <code>Long</code> Código do tipo de arma
     * @param title <code>String</code> Titulo do tipo de arma
     * @param damageBase <code>Double</code> Dano base do tipo
     * @param range <code>Integer</code> Alcance da arma
     * @param damageType <code>DamageType</code> Tipo de dano
     * @param size <code>WeaponSize</code> Tamanho da arma
     * @param category <code>Integer</code> Classificação do tipo
     * @param wearType <code>WearType</code> Tipo de porte
     * @param materialAmount1 <code>Double</code> Qtd. do material 1
     * @param materialAmount2 <code>Double</code> Qtd. do material 2
     */
    public WeaponType(Long id, String title, Double damageBase, Integer range, DamageType damageType, WeaponSize size, Integer category, UseType wearType, Double materialAmount1, Double materialAmount2) {
        this.id = id;
        this.title = title;
        this.damageBase = damageBase;
        this.range = range;
        this.damageType = damageType;
        this.size = size;
        this.category = category;
        this.wearType = wearType;
        this.materialAmount1 = materialAmount1;
        this.materialAmount2 = materialAmount2;
    }

    /**
     * Retorna o Código do tipo de arma
     *
     * @return <code>Long</code> Código do tipo de arma
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo de arma
     *
     * @param id <code>Long</code> Código do tipo de arma
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo do tipo de arma
     *
     * @return <code>String</code> Titulo do tipo de arma
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Titulo do tipo de arma
     *
     * @param title <code>String</code> Titulo do tipo de arma
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna a Qtd. do material 1
     *
     * @return <code>Double</code> Qtd. do material 1
     */
    public Double getMaterialAmount1() {
        return materialAmount1;
    }

    /**
     * Modifica a Qtd. do material 1
     *
     * @param amount1 <code>Double</code> Qtd. do material 1
     */
    public void setMaterialAmount1(Double amount1) {
        this.materialAmount1 = amount1;
    }

    /**
     * Retorna a Qtd. do material 2
     *
     * @return <code>Double</code> Qtd. do material 2
     */
    public Double getMaterialAmount2() {
        return materialAmount2;
    }

    /**
     * Modifica a Qtd. do material 2
     *
     * @param amount2 <code>Double</code> Qtd. do material 2
     */
    public void setMaterialAmount2(Double amount2) {
        this.materialAmount2 = amount2;
    }

    /**
     * Retorna o Dano base do tipo
     *
     * @return <code>Double</code> Dano base do tipo
     */
    public Double getDamageBase() {
        return damageBase;
    }

    /**
     * Modificao tipo de Dano
     *
     * @param damageBase <code>DamageType</code> Tipo de dano
     */
    public void setDamageBase(Double damageBase) {
        this.damageBase = damageBase;
    }

    /**
     * Retorna o Dano base do tipo
     *
     * @return <code>Double</code> Dano base do tipo
     */
    public DamageType getDamageType() {
        return damageType;
    }

    /**
     * Modifica o tipo de Dano
     *
     * @param damageType <code>DamageType</code> Tipo de dano
     */
    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    /**
     * Retorna o alcance da arma
     *
     * @return <code>Integer</code> Alcance da arma
     */
    public Integer getRange() {
        return range;
    }

    /**
     * Modifica o alcance da arma
     *
     * @param range <code>Integer</code> Alcance da arma
     */
    public void setRange(Integer range) {
        this.range = range;
    }

    /**
     * Retorna o tamanho da arma
     *
     * @return <code>WeaponSize</code> Tamanho da arma
     */
    public WeaponSize getSize() {
        return size;
    }

    /**
     * Modifica o tamanho da arma
     *
     * @param size <code>WeaponSize</code> Tamanho da arma
     */
    public void setSize(WeaponSize size) {
        this.size = size;
    }

    /**
     * Retorna a Classificação do tipo
     *
     * @return <code>Integer</code> Classificação do tipo
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * Modifica a Classificação do tipo
     *
     * @param category <code>Integer</code> Classificação do tipo
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * Retorna o Tipo de porte
     *
     * @return <code>WearType</code> Tipo de porte
     */
    public UseType getWearType() {
        return wearType;
    }

    /**
     * Modifica o Tipo de porte
     *
     * @param wearType <code>WearType</code> Tipo de porte
     */
    public void setUseType(UseType wearType) {
        this.wearType = wearType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.damageBase);
        hash = 29 * hash + Objects.hashCode(this.category);
        hash = 29 * hash + Objects.hashCode(this.wearType);
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
        final WeaponType other = (WeaponType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.damageBase, other.damageBase)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        return Objects.equals(this.wearType, other.wearType);
    }

    @Override
    public String toString() {
        return title;
    }

}
