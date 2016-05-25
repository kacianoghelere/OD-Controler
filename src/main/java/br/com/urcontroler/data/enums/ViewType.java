package br.com.urcontroler.data.enums;

/**
 * Enum para resgistro dos tipos de views
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public enum ViewType {

    /**
     * View de Cadastro
     */
    REG("Cadastro"),
    /**
     * View de Gerenciamento
     */
    MAN("Gerenciamento"),
    /**
     * View do Sistema
     */
    SYS("Sistema");

    private final String type;

    /**
     * Cria nova instancia de WeaponSize
     *
     * @param type {@code String} Tipo
     */
    private ViewType(String type) {
        this.type = type;
    }

    /**
     * Retorna a descrição do tipo
     *
     * @return {@code String} Tipo
     */
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }

}
