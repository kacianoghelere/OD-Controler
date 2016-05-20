package br.com.urcontroler.data.enums;

/**
 * Enumerador de caminho de classes
 *
 * @author kaciano
 */
public enum ClassPaths {

    /**
     * Caminho das classes arcanas
     */
    ARCANE("Arcanismo"),
    /**
     * Caminho das classes combatentes
     */
    COMBAT("Combate"),
    /**
     * Caminho das classes espirituosas
     */
    SPIRIT("Espiritualismo"),
    /**
     * Caminho das classes furtivas
     */
    STEALTH("Furtividade");

    private String name;

    /**
     * Cria nova instancia de caminho de classes
     *
     * @param name {@code String} Nome do caminho
     */
    private ClassPaths(String name) {
        this.name = name;
    }

    /**
     * Retorna o nome do caminho
     *
     * @return {@code String} Nome do caminho
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do caminho
     *
     * @param name {@code String} Nome do caminho
     */
    public void setName(String name) {
        this.name = name;
    }

}
