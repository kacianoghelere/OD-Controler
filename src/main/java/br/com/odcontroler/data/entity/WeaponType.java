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
    @ColumnName(name = "Alcance")
    private Integer range;
    @ColumnName(name = "Tipo de dano")
    private DamageType damageType;
    @ColumnName(name = "Tamanho")
    private WeaponSize size;
    @ColumnName(name = "Porte")
    private UseType wearType;

    /**
     * Cria nova instancia de WeaponType
     */
    public WeaponType() {
    }

    /**
     * Cria nova instancia de WeaponType
     *
     * @param id {@code Long} Código do tipo de arma
     * @param typeName {@code String} Titulo do tipo de arma
     * @param wearType {@code WearType} Tipo de porte
     */
    public WeaponType(Long id, String typeName, UseType wearType) {
        this.id = id;
        this.title = typeName;
        this.wearType = wearType;
    }

    /**
     * Cria nova instancia de WeaponType
     *
     * @param id {@code Long} Código do tipo de arma
     * @param typeName {@code String} Titulo do tipo de arma
     * @param range {@code Integer} Alcance da arma
     * @param size {@code WeaponSize} Tamanho da arma
     * @param wearType {@code WearType} Tipo de porte
     */
    public WeaponType(Long id, String typeName, Integer range, WeaponSize size,
            UseType wearType) {
        this.id = id;
        this.title = typeName;
        this.range = range;
        this.size = size;
        this.wearType = wearType;
    }

    /**
     * Cria nova instancia de WeaponType
     *
     * @param id {@code Long} Código do tipo de arma
     * @param title {@code String} Titulo do tipo de arma
     * @param range {@code Integer} Alcance da arma
     * @param damageType {@code DamageType} Tipo de dano
     * @param size {@code WeaponSize} Tamanho da arma
     * @param wearType {@code WearType} Tipo de porte
     */
    public WeaponType(Long id, String title, Integer range,
            DamageType damageType, WeaponSize size, UseType wearType) {
        this.id = id;
        this.title = title;
        this.range = range;
        this.damageType = damageType;
        this.size = size;
        this.wearType = wearType;
    }

    /**
     * Retorna o Código do tipo de arma
     *
     * @return {@code Long} Código do tipo de arma
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do tipo de arma
     *
     * @param id {@code Long} Código do tipo de arma
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo do tipo de arma
     *
     * @return {@code String} Titulo do tipo de arma
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Titulo do tipo de arma
     *
     * @param title {@code String} Titulo do tipo de arma
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o Dano base do tipo
     *
     * @return {@code Double} Dano base do tipo
     */
    public DamageType getDamageType() {
        return damageType;
    }

    /**
     * Modifica o tipo de Dano
     *
     * @param damageType {@code DamageType} Tipo de dano
     */
    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
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
     * Retorna o tamanho da arma
     *
     * @return {@code WeaponSize} Tamanho da arma
     */
    public WeaponSize getSize() {
        return size;
    }

    /**
     * Modifica o tamanho da arma
     *
     * @param size {@code WeaponSize} Tamanho da arma
     */
    public void setSize(WeaponSize size) {
        this.size = size;
    }

    /**
     * Retorna o Tipo de porte
     *
     * @return {@code WearType} Tipo de porte
     */
    public UseType getWearType() {
        return wearType;
    }

    /**
     * Modifica o Tipo de porte
     *
     * @param wearType {@code WearType} Tipo de porte
     */
    public void setUseType(UseType wearType) {
        this.wearType = wearType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.title);
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
        return Objects.equals(this.wearType, other.wearType);
    }

    @Override
    public String toString() {
        return title;
    }

}
