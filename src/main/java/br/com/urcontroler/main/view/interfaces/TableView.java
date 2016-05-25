package br.com.urcontroler.main.view.interfaces;

import br.com.gmp.comps.model.GTableModel;
import br.com.gmp.comps.table.GTable;

/**
 * Interface padrão para views que contem dados em tabelas
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public interface TableView {

    /**
     * Adiciona um item na tabela
     *
     * @throws java.lang.Exception Exceção lançada
     */
    void add() throws Exception;

    /**
     * Remove um item na tabela
     *
     * @throws java.lang.Exception Exceção lançada
     */
    void remove() throws Exception;

    /**
     * Inicia edição de um item na tabela
     *
     * @throws java.lang.Exception Exceção lançada
     */
    void edit() throws Exception;

    /**
     * Retorna a tabela
     *
     * @return {@code GTable}
     */
    GTable getTable();

    /**
     * Retorna o modelo da tabela
     *
     * @return {@code GTableModel}
     */
    GTableModel getModel();
}
