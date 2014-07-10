package br.com.odcontroler.data.enums;

import br.com.gmp.utils.annotations.ColumnName;

/**
 * Enumerador de tamanhos
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public enum Size {

    /**
     * Tamanho pequeno
     */
    P("Pequeno"),
    /**
     * Tamanho Médio
     */
    M("Médio"),
    /**
     * Tamanho Grande
     */
    G("Grande");

    @ColumnName(name = "Titulo")
    private String name;

    /**
     * Cria nova instancia de Size
     *
     * @param name {@code String} Nome do tamanho
     */
    private Size(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna o Nome do tamanho
     *
     * @return {@code String} Nome do tamanho
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do tamanho
     *
     * @param name {@code String} Nome do tamanho
     */
    public void setName(String name) {
        this.name = name;
    }

}
