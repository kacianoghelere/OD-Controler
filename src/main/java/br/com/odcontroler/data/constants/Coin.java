package br.com.odcontroler.data.constants;

/**
 * Enum de registro de dados de moedas
 *
 * @author kaciano
 * @version 1.0
 */
public enum Coin {

    PC("Peças de cobre", 1),
    PP("Peças de prata", 10),
    PO("Peças de ouro", 100),
    PL("Platina", 1000),
    EL("Electrun", 10000);

    private final String description;
    private final Integer value;

    /**
     * Cria nova instancia de Coin
     *
     * @param description {@code String} descrição da moeda
     * @param value {@code Valor da moeda}
     */
    private Coin(String description, Integer value) {
        this.description = description;
        this.value = value;
    }

    /**
     * Retorna a descrição da moeda
     *
     * @return {@code String} Descrição da moeda
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retorna o valor da moeda
     *
     * @return {@code Integer} Valor da moeda
     */
    public Integer getValue() {
        return value;
    }

}
