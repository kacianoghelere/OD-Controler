package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;

/**
 * Parametros da classe
 *
 * @author kaciano
 * @version 1.0
 */
public class ClassLevel {

    @ColumnName(name = "Nível")
    private Integer level;
    @Editable
    @ColumnName(name = "Exp")
    private Long xp;
    @Editable
    @ColumnName(name = "Dado de vida")
    private Integer lifeAmount;
    @Ignore
    @ColumnName(name = "Vida extra")
    private Boolean plusLife;
    @Editable
    @ColumnName(name = "Ataque Base")
    private Integer atkBase;
    @Editable
    @ColumnName(name = "JP")
    private Integer protection;

    /**
     * Cria nova instância de ClassLevel
     */
    public ClassLevel() {
    }

    /**
     * Cria nova instância de ClassLevel
     *
     * @param level {@code Integer} Nivel
     * @param xp {@code Long} Experiência
     * @param lifeAmount {@code Integer} Quantidade de dados de vida
     * @param plusLife {@code Integer} Representa vida extra
     * @param atkBase {@code Integer} Base de ataque
     * @param protection {@code Integer} JP
     */
    public ClassLevel(Integer level, Long xp, Integer lifeAmount, Boolean plusLife,
            Integer atkBase, Integer protection) {
        this.level = level;
        this.xp = xp;
        this.lifeAmount = lifeAmount;
        this.plusLife = plusLife;
        this.atkBase = atkBase;
        this.protection = protection;
    }

    @Override
    public String toString() {
        return "ClassLevel{"
                + "Level = " + level + ", "
                + "Xp = " + xp + ", "
                + "LifeAmount = " + lifeAmount + ", "
                + "AtkBase = " + atkBase + ", "
                + "Protection = " + protection + '}';
    }

    /**
     * Retorna o Nivel
     *
     * @return {@code Integer} Nivel
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Modifica o Nivel
     *
     * @param level {@code Integer} Nivel
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * Retorna a Experiência
     *
     * @return {@code Long} Experiência
     */
    public Long getXp() {
        return xp;
    }

    /**
     * Modifica a Experiência
     *
     * @param xp {@code Long} Experiência
     */
    public void setXp(Long xp) {
        this.xp = xp;
    }

    /**
     * Retorna a Quantidade de dados de vida
     *
     * @return {@code Integer} Quantidade de dados de vida
     */
    public Integer getLifeAmount() {
        return lifeAmount;
    }

    /**
     * Modifica a Quantidade de dados de vida
     *
     * @param lifeAmount {@code Integer} Quantidade de dados de vida
     */
    public void setLifeAmount(Integer lifeAmount) {
        this.lifeAmount = lifeAmount;
    }

    /**
     * Retorna se Representa vida extra
     *
     * @return {@code Integer} Representa vida extra
     */
    public Boolean isPlusLife() {
        return plusLife;
    }

    /**
     * Modifica se Representa vida extra
     *
     * @param plusLife {@code Integer} Representa vida extra
     */
    public void setPlusLife(Boolean plusLife) {
        this.plusLife = plusLife;
    }

    /**
     * Retorna a Base de ataque
     *
     * @return {@code Integer} Base de ataque
     */
    public Integer getAtkBase() {
        return atkBase;
    }

    /**
     * Modifica a Base de ataque
     *
     * @param atkBase {@code Integer} Base de ataque
     */
    public void setAtkBase(Integer atkBase) {
        this.atkBase = atkBase;
    }

    /**
     * Retorna o JP
     *
     * @return {@code Integer} JP
     */
    public Integer getProtection() {
        return protection;
    }

    /**
     * Modifica o JP
     *
     * @param protection {@code Integer} JP
     */
    public void setProtection(Integer protection) {
        this.protection = protection;
    }

}
