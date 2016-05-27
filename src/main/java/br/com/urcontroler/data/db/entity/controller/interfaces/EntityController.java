package br.com.urcontroler.data.db.entity.controller.interfaces;

import br.com.urcontroler.data.db.entity.controller.exceptions.IllegalOrphanException;
import br.com.urcontroler.data.db.entity.controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;

/**
 * Interface de padronização de Controllers
 *
 * @author Kaciano Ghelere Ghelere
 * @param <T> Entidade generica
 */
public interface EntityController<T> extends Serializable {

    /**
     * Persiste dados da entidade
     *
     * @param entity {@code T} Entidade
     */
    public void create(T entity);

    /**
     * Edita informações da entidade
     *
     * @param entity {@code T} Entidade
     * @return {@code T} Entidade modificada
     * @throws IllegalOrphanException Exceção de entidade relacionada
     * @throws NonexistentEntityException Exceção de entidade inexistente
     * @throws Exception Exceção genérica
     */
    public T edit(T entity) throws IllegalOrphanException, NonexistentEntityException, Exception;

    /**
     * Destrói todas as entidades e adiciona novas
     *
     * @param list {@code List(T)} Lista de Entidades
     * @throws IllegalOrphanException Exceção de entidade relacionada
     * @throws NonexistentEntityException Exceção de entidade inexistente
     * @throws Exception Exceção genérica
     */
    public void replaceAll(List<T> list) throws IllegalOrphanException, NonexistentEntityException, Exception;

    /**
     * Destrói entidade a partir do ID
     *
     * @param id {@code Long} ID da Entidade
     * @throws IllegalOrphanException Exceção de entidade relacionada
     * @throws NonexistentEntityException Exceção de entidade inexistente
     * @throws Exception Exceção genérica
     */
    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException, Exception;

    /**
     * Destrói entidade
     *
     * @param entity {@code T} Entidade
     * @throws IllegalOrphanException Exceção de entidade relacionada
     * @throws NonexistentEntityException Exceção de entidade inexistente
     * @throws Exception Exceção genérica
     */
    public void destroy(T entity) throws IllegalOrphanException, NonexistentEntityException, Exception;

    /**
     * Destrói todas as entidades
     *
     * @throws IllegalOrphanException Exceção de entidade relacionada
     * @throws NonexistentEntityException Exceção de entidade inexistente
     * @throws Exception Exceção genérica
     */
    public void destroyAll() throws IllegalOrphanException, NonexistentEntityException, Exception;

    /**
     * Busca entidade a partir do ID
     *
     * @param id {@code Long} ID da Entidade
     * @return {@code T} Entidade
     */
    public T find(Long id);

    /**
     * Encontra todos os registros do entidade
     *
     * @return {@code List(T)} Lista de Entidades
     */
    public List<T> findEntities();

    /**
     * Encontra todos os registros do entidade, aplicando filtro de limite e
     * inicio de contagem
     *
     * @param maxResults {@code int} Limite de resultados
     * @param firstResult {@code int} Indice do inicio da contagem(a partir de
     * [x])
     * @return {@code List(T)} Lista de Entidades
     */
    public List<T> findEntities(int maxResults, int firstResult);

    /**
     * Efetua contagem de registros
     *
     * @return {@code int} Contagem de entidades
     */
    public int count();

}
