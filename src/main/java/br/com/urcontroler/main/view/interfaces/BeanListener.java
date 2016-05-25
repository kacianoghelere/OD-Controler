package br.com.urcontroler.main.view.interfaces;

import br.com.gmp.comps.data.GenericDAO;
import br.com.urcontroler.main.object.BeanEvent;

/**
 *
 * @author Kaciano Ghelere
 * @param <T> Tipo da View
 */
public interface BeanListener<T> {

    /**
     * Metodo padrão para salvar
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.urcontroler.main.view.View#onCommit()
     */
    void onCommit(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.urcontroler.main.view.View#onProcess()
     */
    void onProcess(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.urcontroler.main.view.View#onClear()
     */
    void onClear(BeanEvent evt) throws Exception;

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt {@code BeanEvent} Evento
     * @throws java.lang.Exception Exceção
     * @see br.com.urcontroler.main.view.View#onLoad()
     */
    void onLoad(BeanEvent evt) throws Exception;

    /**
     * Retorna a view do bean
     *
     * @return {@code T} View do bean
     */
    T getView();

}
