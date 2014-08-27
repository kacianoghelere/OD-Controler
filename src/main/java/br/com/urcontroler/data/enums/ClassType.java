package br.com.urcontroler.data.enums;

/**
 * Enumerador de tipos de classes
 *
 * @author kaciano
 * @version 1.0
 */
public enum ClassType {

    /**
     * Tipo de classe voltada para combate fisico
     */
    COMBAT("Combate", false),
    /**
     * Tipo de classe voltada para a diplomacia
     */
    DIPLOMACY("Diplomacia", false),
    /**
     * Tipo de classe que faz uso de magias
     */
    MAGIC("Magica", true),
    /**
     * Tipo de classe para taticas furtivas
     */
    STEALTH("Furtividade", false),
    /**
     * Tipo de classe estudiosos das ciencias
     */
    SCIENCE("Ciência", false);

    private String name;
    private boolean magic;

    /**
     * Cria nova instancia de ClassType
     *
     * @param name {@code String} Nome do tipo
     * @param magic {@code boolean} Classe magica?
     */
    private ClassType(String name, boolean magic) {
        this.name = name;
    }

    /**
     * Retorna o nome do tipo
     *
     * @return {@code String} Nome do tipo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do tipo
     *
     * @param name {@code String} Nome do tipo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna se é um tipo de Classe magica
     *
     * @return {@code boolean} Classe magica?
     */
    public boolean isMagic() {
        return magic;
    }

    /**
     * Modifica se é um tipo de Classe magica
     *
     * @param magic {@code boolean} Classe magica?
     */
    public void setMagic(boolean magic) {
        this.magic = magic;
    }

}
