package br.com.urcontroler.data.enums;

/**
 * Interface para padronização na criação de atributos
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public interface Attr {

    /**
     * Retorna o titulo do atributo
     *
     * @return {@code String} Titulo do atributo
     */
    String getTitle();

    /**
     * Retorna a abreviatura do atributo
     *
     * @return {@code String} Abreviatura do atributo
     */
    String getShortTitle();
}
