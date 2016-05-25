package br.com.urcontroler.data.db.entity.controller.impl;

import br.com.urcontroler.data.db.entity.controller.exceptions.IllegalOrphanException;
import br.com.urcontroler.data.db.entity.controller.exceptions.NonexistentEntityException;
import br.com.urcontroler.data.db.entity.controller.interfaces.IGenericController;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kaciano Ghelere Ghelere
 * @param <T> Entidade abstrata
 */
public class GenericController<T> implements IGenericController<T> {

    private Class<T> objClass;
    private EntityManagerFactory emf = null;

    /**
     * Cria nova instancia de GerericJpaController
     *
     * @param emf {@code EntityManagerFactory} Fabrica de gerenciador de
     * entidades
     */
    public GenericController(EntityManagerFactory emf) {
        this.emf = emf;
        initialize();
    }

    /**
     * Cria nova instancia de GerericJpaController
     *
     * @param objClass {@code Class(T)} Classe da entidade
     * @param emf {@code EntityManagerFactory} Fabrica de gerenciador de
     * entidades
     */
    public GenericController(Class<T> objClass, EntityManagerFactory emf) {
        this.objClass = objClass;
        this.emf = emf;
        initialize();
    }

    /**
     * Inicializador de tipo genérico
     */
    private void initialize() {
        if (this.objClass == null) {
            ParameterizedType type = ((ParameterizedType) (getClass().getGenericSuperclass()));
            this.objClass = (Class<T>) type.getActualTypeArguments()[0];
        }
    }

    /**
     * Retorna gerenciador de entidades instanciado
     *
     * @return {@code EntityManager} Gerenciador de entidades
     */
    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(T alignment) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alignment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T edit(T entity) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            String msg = e.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = findId(entity);
                if (find(id) == null) {
                    throw new NonexistentEntityException("The entity with id " + id + " no longer exists.");
                }
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Encontra o campo demarcado com a anotação {@code @Id} dentro da entidade
     *
     * @param entity {@code Object} Entidade
     * @return {@code Long} ID da entidade
     * @throws java.lang.IllegalArgumentException Exceção de argumento invalido
     * @throws java.lang.IllegalAccessException Exceção de acesso negado
     */
    protected Long findId(Object entity) throws IllegalArgumentException, IllegalAccessException {
        try {
            Field field = null;
            for (Field f : entity.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(Id.class)) {
                    field = f;
                    break;
                }
            }
            if (field != null) {
                return (Long) field.get(entity);
            }
            return null;
        } catch (IllegalAccessException | IllegalArgumentException ex) {
            throw ex;
        }
    }

    /**
     * Método de verificação extra de remoção. Sobrescrever caso deseje utilizar
     *
     * @param id {@code Long} ID da entidade
     * @return {@code boolean} Retorno da validação
     */
    protected boolean preventDestruction(Long id) {
        return false;
    }

    @Override
    public void destroy(T entity) throws IllegalOrphanException, NonexistentEntityException, Exception {
        Long id = findId(entity);
        if (entity != null && id != null) {
            destroy(id);
        }
    }

    @Override
    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException, IllegalArgumentException, IllegalAccessException {
        if (preventDestruction(id)) {
            return;
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            T entity;
            try {
                entity = em.getReference(this.objClass, id);
                findId(entity);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("The entity with id " + id + " no longer exists.", e);
            }

            em.remove(entity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<T> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<T> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<T> findEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(this.objClass));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public T find(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(this.objClass, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<T> rt = cq.from(this.objClass);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
