package br.com.odcontroler.main.view.interfaces;

import br.com.odcontroler.main.object.BeanEvent;

/**
 *
 * @author kaciano
 * @param <T> Tipo da View
 */
public interface BeanListener<T> {

    /**
     * Metodo padrão para salvar
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.odcontroler.main.view.View#commit()
     */
    void commit(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.odcontroler.main.view.View#process()
     */
    void process(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.odcontroler.main.view.View#clear()
     */
    void clear(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.odcontroler.main.view.View#load()
     */
    void load(BeanEvent evt) throws Exception;

    /**
     * Retorna a view do bean
     *
     * @return {@code T} View do bean
     */
    T getView();
}
