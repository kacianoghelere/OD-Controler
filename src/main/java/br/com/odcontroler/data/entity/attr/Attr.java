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
     * @return <code>Long</code> ID do atributo
     */
    Long getId();

    /**
     * Retorna o titulo do atributo
     *
     * @return <code>String</code> Titulo do atributo
     */
    String getTitle();

    /**
     * Retorna a abreviatura do atributo
     *
     * @return <code>String</code> Abreviatura do atributo
     */
    String getShortTitle();
}
