package br.com.urcontroler.data.entity;

import br.com.urcontroler.data.enums.DamageType;
import br.com.urcontroler.data.enums.UseType;
import br.com.urcontroler.data.enums.AttackType;
import br.com.urcontroler.data.enums.Size;
import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Tipo de arma
 *
 * @author kaciano
 */
public class WeaponType extends Type {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;
    @Editable
    @ColumnName(name = "Alcance")
    private Integer range;
    @Editable
    @ColumnName(name = "Tipo de Dano")
    private DamageType damageType;
    @Editable
    @ColumnName(name = "Tamanho")
    private Size size;
    @Editable
    @ColumnName(name = "Porte")
    private UseType useType;
    @Editable
    @ColumnName(name = "Tipo de Ataque")
    private AttackType attackType;

    /**
     * Cria nova instancia de WeaponType
     */
    public WeaponType() {
    }

    /**
     * Cria nova instancia de WeaponType
     *
     * @param id {@code Long} Código do tipo de arma
     * @param title {@code String} Titulo do tipo de arma
     * @param range {@code Integer} Alcance da arma
     * @param dmgType {@code DamageType} Tipo de dano
     * @param size {@code WeaponSize} Tamanho da arma
     * @param useType {@code WearType} Tipo de porte
     * @param attackType {@code AttackType} Tipo de ataque
     */
    public WeaponType(Long id, String title, Integer range, DamageType dmgType,
            Size size, UseType useType, AttackType attackType) {
        super(id, title);
        this.id = id;
        this.title = title;
        this.range = range;
        this.damageType = dmgType;
        this.size = size;
        this.useType = useType;
        this.attackType = attackType;
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
    public String getName() {
        return title;
    }

    /**
     * Modifica o Titulo do tipo de arma
     *
     * @param title {@code String} Titulo do tipo de arma
     */
    @Override
    public void setName(String title) {
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
    public Size getSize() {
        return size;
    }

    /**
     * Modifica o tamanho da arma
     *
     * @param size {@code WeaponSize} Tamanho da arma
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Retorna o Tipo de porte
     *
     * @return {@code WearType} Tipo de porte
     */
    public UseType getUseType() {
        return useType;
    }

    /**
     * Modifica o Tipo de porte
     *
     * @param wearType {@code WearType} Tipo de porte
     */
    public void setUseType(UseType wearType) {
        this.useType = wearType;
    }

    /**
     * Retorna o tipo de ataque
     *
     * @return {@code AttackType} Tipo de ataque
     */
    public AttackType getAttackType() {
        return attackType;
    }

    /**
     * Modifica o tipo de ataque
     *
     * @param attackType {@code AttackType} Tipo de ataque
     */
    public void setAttackType(AttackType attackType) {
        this.attackType = attackType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return title;
    }

}
