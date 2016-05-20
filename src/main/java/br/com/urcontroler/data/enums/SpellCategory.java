package br.com.urcontroler.data.enums;

/**
 * Enumerador das categorias de magias
 *
 * @author kaciano
 * @version 1.0
 */
public enum SpellCategory {

    /**
     * Classe de magias de Abjuração
     */
    ABJURATION("Abjuração"),
    /**
     * Classe de magias de Alteração
     */
    ALTERATION("Alteração"),
    /**
     * Classe de magias de Conjuração
     */
    CONJURATION("Conjuração"),
    /**
     * Classe de magias de Encantamento
     */
    ENCANTATION("Encantamento"),
    /**
     * Classe de magias de Ilusão
     */
    ILLUSION("Ilusão"),
    /**
     * Classe de magias de Invocação ou Evocação
     */
    INVOCATION("Invocação|Evocação"),
    /**
     * Classe de magias de Necromancia
     */
    NECROMANCY("Necromancia"),
    /**
     * Classe de magias de Profecia
     */
    OMEN("Profecia");

    private String name;

    /**
     * Cria nova instancia de SpellCategory
     *
     * @param name {@code String} Nome da classe
     */
    private SpellCategory(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
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

}
