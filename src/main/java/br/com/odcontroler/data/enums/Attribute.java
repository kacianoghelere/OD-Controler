package br.com.odcontroler.data.enums;

/**
 * Enumerador de constantes para os atributos
 *
 * @author kaciano
 * @version 1.0
 */
public enum Attribute implements Attr {

    /**
     * Atributo Força
     */
    STR("Força", "FOR"),
    /**
     * Atributo Destreza
     */
    DEX("Destreza", "DES"),
    /**
     * Atributo Constituição
     */
    CONS("Constituição", "CON"),
    /**
     * Atributo Inteligência
     */
    INT("Inteligência", "INT"),
    /**
     * Atributo Sabedoria
     */
    WIS("Sabedoria", "SAB"),
    /**
     * Atributo Carisma
     */
    CHAR("Carisma", "CAR");

    private final String title;
    private final String shortTitle;

    /**
     * Cria nova instancia de AttrEnumeration
     *
     * @param title {@code String} Titulo do atributo
     * @param shortTitle {@code String} Abreviatura do atributo
     */
    private Attribute(String title, String shortTitle) {
        this.title = title;
        this.shortTitle = shortTitle;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getShortTitle() {
        return shortTitle;
    }

}
