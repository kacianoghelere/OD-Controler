package br.com.urcontroler.data.db.entity.controller;

import br.com.urcontroler.data.db.entity.controller.impl.GenericController;
import javax.persistence.EntityManagerFactory;

/**
 * Builder de controllers padrão para entidades que não necessitam de tratamento
 * especial em seus métodos
 *
 * @author Kaciano Ghelere
 */
public class ControllerBuilder {

    /**
     * Constroi uma nova instancia de GenericController agregando os indicadores
     * de tipo
     *
     * @param <T> Tipo de entidade
     * @param ctrlClass {@code Class(T)} Classe do tipo de entidade
     * @param emf {@code EntityManagerFactory} Fabrica de gerenciador de
     * entidades
     * @return {@code GenericController(T)} Nova instancia de GenericDAO
     */
    public static <T extends Object> GenericController<T> get(Class<T> ctrlClass, EntityManagerFactory emf) {
        return new GenericController<T>(ctrlClass, emf) {
        };
    }
}
