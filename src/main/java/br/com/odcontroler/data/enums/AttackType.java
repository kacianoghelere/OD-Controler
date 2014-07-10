package br.com.odcontroler.data.enums;

/**
 * Enumerador para tipos de ataque
 *
 * @author kaciano
 * @version 1.0
 */
public enum AttackType {

    /**
     * Ataque corpo-a-corpo
     */
    CLOSE("Corpo-a-corpo"),
    /**
     * Ataque à distancia
     */
    RANGED("Distancia");

    private String name;

    /**
     * Cria nova instancia de AttackType
     *
     * @param typeName {@code String} Titulo do tipo
     */
    private AttackType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna o Titulo do tipo
     *
     * @return {@code String} Titulo do tipo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Titulo do tipo
     *
     * @param name {@code String} Titulo do tipo
     */
    public void setName(String name) {
        this.name = name;
    }
}
