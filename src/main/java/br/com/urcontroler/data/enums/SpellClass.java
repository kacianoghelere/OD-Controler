package br.com.urcontroler.data.enums;

import java.awt.Color;

/**
 * Enumerador para classificações de magias
 *
 * @author kaciano
 * @version 1.0
 */
public enum SpellClass {

    /**
     * Classe Principiante
     */
    NOVICE(1, "Principiante", Color.GRAY),
    /**
     * Classe Aprendiz
     */
    APPRENTICE(2, "Aprendiz", Color.BLUE),
    /**
     * Classe Adepto
     */
    ADEPT(3, "Adepto", Color.GREEN.darker()),
    /**
     * Classe Perito
     */
    EXPERT(4, "Perito", Color.ORANGE.darker()),
    /**
     * Classe Mestre
     */
    MASTER(5, "Mestre", Color.RED.darker());

    private int code;
    private String name;
    private Color highlight;

    /**
     * Cria nova instancia de SpellClass
     *
     * @param code {@code int} Código
     * @param name {@code String} Nome
     * @param highlight {@code Color} Destaque
     */
    private SpellClass(int code, String name, Color highlight) {
        this.code = code;
        this.name = name;
        this.highlight = highlight;
    }

    /**
     * Retorna a classificação conforme o código recebido
     *
     * @param code {@code int} Código
     * @return {@code SpellClass} Categoria
     */
    public static SpellClass fromCode(int code) {
        for (SpellClass category : values()) {
            if (category.getCode() == code) {
                return category;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna o código
     *
     * @return {@code int} Código
     */
    public int getCode() {
        return code;
    }

    /**
     * Modifica o código
     *
     * @param code {@code int} Código
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Retorna o nome
     *
     * @return {@code String} Nome
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome
     *
     * @param name {@code String} Nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a cor de destaque
     *
     * @return {@code Color} Destaque
     */
    public Color getHighlight() {
        return highlight;
    }

    /**
     * Modifica a cor de destaque
     *
     * @param highlight {@code Color} Destaque
     */
    public void setHighlight(Color highlight) {
        this.highlight = highlight;
    }

}
