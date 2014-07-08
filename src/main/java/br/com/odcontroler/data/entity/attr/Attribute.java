package br.com.odcontroler.data.entity.attr;

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
    STR(1L, "Força", "FOR"),
    /**
     * Atributo Destreza
     */
    DEX(2L, "Destreza", "DES"),
    /**
     * Atributo Constituição
     */
    CONS(3L, "Constituição", "CON"),
    /**
     * Atributo Inteligência
     */
    INT(4L, "Inteligência", "INT"),
    /**
     * Atributo Sabedoria
     */
    WIS(5L, "Sabedoria", "SAB"),
    /**
     * Atributo Carisma
     */
    CHAR(6L, "Carisma", "CAR");

    private final Long id;
    private final String title;
    private final String shortTitle;

    /**
     * Cria nova instancia de AttrEnumeration
     *
     * @param id {@code Long} ID do atributo
     * @param title {@code String} Titulo do atributo
     * @param shortTitle {@code String} Abreviatura do atributo
     */
    private Attribute(Long id, String title, String shortTitle) {
        this.id = id;
        this.title = title;
        this.shortTitle = shortTitle;
    }

    @Override
    public Long getId() {
        return id;
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
