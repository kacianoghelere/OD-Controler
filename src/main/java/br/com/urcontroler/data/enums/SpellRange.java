package br.com.urcontroler.data.enums;

/**
 * Enumerador de alcance para magias
 *
 * @author kaciano
 * @version 1.0
 */
public enum SpellRange {

    /**
     * Alcance de toque
     */
    TOUCH(1L, "Toque"),
    /**
     * Alcance pessoal
     */
    PERSONAL(2L, "Pessoal"),
    /**
     * Alcance à ser definido
     */
    SPECIAL(3L, "Especial"),
    /**
     * Alcance de 3 metros
     */
    METERS3(4L, "%2d metros");

    private Long id;
    private String name;

    /**
     * Cria nova instancia de SpellRange
     *
     * @param id {@code Long} ID do SpellRange
     * @param name {@code String} Nome do SpellRange
     */
    private SpellRange(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retorna o ID do SpellRange
     *
     * @return {@code Long} ID do SpellRange
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do SpellRange
     *
     * @param id {@code Long} ID do SpellRange
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome do SpellRange
     *
     * @return {@code String} Nome do SpellRange
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do SpellRange
     *
     * @param name {@code String} Nome do SpellRange
     */
    public void setName(String name) {
        this.name = name;
    }
}
