package br.com.odcontroler.data.entity.attr;

/**
 * Enumerador de constantes para os atributos
 *
 * @author kaciano
 * @version 1.0
 */
public enum AttrEnum implements Attr {

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
    CON(3L, "Constituição", "CON"),
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
    CAR(6L, "Carisma", "CAR");

    private Long id;
    private String title;
    private String shortTitle;

    /**
     * Cria nova instancia de AttrEnumeration
     *
     * @param id <code>Long</code> ID do atributo
     * @param title <code>String</code> Titulo do atributo
     * @param shortTitle <code>String</code> Abreviatura do atributo
     */
    private AttrEnum(Long id, String title, String shortTitle) {
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
