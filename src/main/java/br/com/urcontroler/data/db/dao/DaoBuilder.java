package br.com.urcontroler.data.db.dao;

import br.com.gmp.comps.data.GenericDAO;

/**
 * Construtor de DAO's genericos
 *
 * @author kaciano
 * @version 1.0
 */
public class DaoBuilder {

    /**
     * Constroi uma nova instancia de GenericDAO agregando os indicados de tipo
     *
     * @param <T> Tipo de entidade
     * @param daoClass {@code Class(T)} Classe do tipo de entidade
     * @return {@code GenericDAO(T)} Nova instancia de GenericDAO
     */
    public static <T extends Object> GenericDAO<T> get(Class<T> daoClass) {
        return new GenericDAO<T>(daoClass) {
        };
    }

    /**
     * Constroi uma nova instancia de GenericDAO agregando os indicados de tipo
     *
     * @param <T> Tipo de entidade
     * @param daoClass {@code Class(T)} Classe do tipo de entidade
     * @param path {@code String} Caminho do banco
     * @return {@code GenericDAO(T)} Nova instancia de GenericDAO
     */
    public static <T extends Object> GenericDAO<T> get(Class<T> daoClass, String path) {
        return new GenericDAO<T>(daoClass, path) {
        };
    }

    /**
     * Constroi uma nova instancia de GenericDAO agregando os indicados de tipo
     *
     * @param <T> Tipo de entidade
     * @param daoClass {@code Class(T)} Classe do tipo de entidade
     * @param name {@code String} Nome do banco
     * @param sufix {@code String} Extensão do banco
     * @return {@code GenericDAO(T)} Nova instancia de GenericDAO
     */
    public static <T extends Object> GenericDAO<T> get(Class<T> daoClass, String name, String sufix) {
        return new GenericDAO<T>(daoClass, name, sufix) {
        };
    }
}
