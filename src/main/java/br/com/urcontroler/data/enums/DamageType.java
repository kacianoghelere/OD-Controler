package br.com.urcontroler.data.enums;

/**
 * Enumerador dos tipos de dano
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public enum DamageType {

    /**
     * Dano por Esmagamento
     */
    CRUSH("Esmagamento"),
    /**
     * Dano por Corte
     */
    CUT("Corte"),
    /**
     * Dano por Perfuração
     */
    PIERCE("Perfuração");

    private String name;

    /**
     * Cria nova isntancia de DamageType
     *
     * @param name {@code String} Nome do tipo de dano
     */
    private DamageType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna o nome do tipo de dano
     *
     * @return {@code String} Nome do tipo de dano
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do tipo de dano
     *
     * @param name {@code String} Nome do tipo de dano
     */
    public void setName(String name) {
        this.name = name;
    }

}
