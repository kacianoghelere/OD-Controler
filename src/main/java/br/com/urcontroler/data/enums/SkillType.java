package br.com.urcontroler.data.enums;

/**
 * Enumerador de tipos de habilidades singulares
 *
 * @author kaciano
 * @version 1.0
 */
public enum SkillType {

    /**
     * Tipo de habilidade Inata
     */
    INNATE("Inata"),
    /**
     * Tipo de habilidade adquirida
     */
    ACQUIRED("Adquirida");

    private String name;

    @Override
    public String toString() {
        return name;
    }

    /**
     * Cria nova instancia de SkillType
     *
     * @param name {@code String} Nome do tipo
     */
    private SkillType(String name) {
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

}
