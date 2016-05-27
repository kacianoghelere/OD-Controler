package br.com.urcontroler.data.db.entity.controller;

import br.com.urcontroler.data.db.entity.Menu;
import br.com.urcontroler.data.db.entity.controller.impl.AbstractEntityController;
import javax.persistence.EntityManagerFactory;

/**
 * Controlador da entidade {@code Menu}
 *
 * @author Kaciano Ghelere
 */
public class MenuController extends AbstractEntityController<Menu> {

    /**
     * Cria nova instancia de MenuController
     *
     * @param emf {@code EntityManagerFactory} Fabrica de gerenciador de
     * entidades
     */
    public MenuController(EntityManagerFactory emf) {
        super(Menu.class, emf);
    }

}
