package br.com.urcontroler.main.view.interfaces;

import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;

/**
 * Interface padrão para views que contem dados em listas
 *
 * @author Kaciano Ghelere
 * @version 1.0
 * @param <T> Tipo de objetos carregados
 */
public interface ListView<T> {

    /**
     * Aplica as alterações do item na lista
     *
     * @throws java.lang.Exception Exceção lançada
     */
    void apply() throws Exception;

    /**
     * Adiciona um item na lista
     *
     * @throws java.lang.Exception Exceção lançada
     */
    void add() throws Exception;

    /**
     * Remove um item na lista
     *
     * @throws java.lang.Exception Exceção lançada
     */
    void remove() throws Exception;

    /**
     * Cria e adiciona um item temporario na lista
     *
     * @return {@code T} Objeto de retorno
     * @throws java.lang.Exception Exceção lançada
     */
    T buildTemp() throws Exception;

    /**
     * Retorna a lista
     *
     * @return {@code GList} Lista
     */
    GList getList();

    /**
     * Retorna o modelo da lista
     *
     * @return {@code GListModel} Modelo
     */
    GListModel<T> getModel();
}
