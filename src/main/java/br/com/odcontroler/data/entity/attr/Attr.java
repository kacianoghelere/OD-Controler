package br.com.odcontroler.data.entity.attr;

/**
 * Interface para padronização na criação de atributos
 *
 * @author kaciano
 * @version 1.0
 */
public interface Attr {

    /**
     * Retorna o ID do atributo
     *
     * @return {@code Long} ID do atributo
     */
    Long getId();

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
