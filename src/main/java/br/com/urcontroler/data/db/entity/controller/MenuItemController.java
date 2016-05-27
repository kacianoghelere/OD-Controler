package br.com.urcontroler.data.db.entity.controller;

import br.com.urcontroler.data.db.entity.MenuItem;
import br.com.urcontroler.data.db.entity.controller.impl.AbstractEntityController;
import javax.persistence.EntityManagerFactory;

/**
 * Controlador da entidade {@code MenuItem}
 *
 * @author Kaciano Ghelere
 */
public class MenuItemController extends AbstractEntityController<MenuItem> {

    /**
     * Cria nova instancia de MenuItemController
     *
     * @param emf {@code EntityManagerFactory} Fabrica de gerenciador de
     * entidades
     */
    public MenuItemController(EntityManagerFactory emf) {
        super(MenuItem.class, emf);
    }

}
