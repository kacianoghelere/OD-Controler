package br.com.urcontroler.main.util;

import br.com.gmp.utils.reflection.ObjectInstance;
import br.com.urcontroler.data.db.entity.MenuItem;
import br.com.urcontroler.main.MainScreen;
import static br.com.urcontroler.main.interfaces.MainListener.LOGGER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;

/**
 * Classe interna para controle de ações do item de menu
 *
 * @author Kaciano Ghelere
 */
public class MenuBuilderAction implements ActionListener {

    private MenuItem view;
    private MainScreen mainScreen;

    /**
     * Cria nova instancia de MenuItemAction
     *
     * @param mainScreen {@code MainScreen} Tela principal
     * @param view {@code MenuItem} Item de menu
     */
    public MenuBuilderAction(MainScreen mainScreen, MenuItem view) {
        this.mainScreen = mainScreen;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            DescriptionObject desc;
            desc = new DescriptionObject.Builder().fromBase(view.getDescription());
            Class<?> forName = Class.forName(view.getViewClass());
            Class[] pClasses = new Class[]{MainScreen.class};
            Object[] params = new Object[]{mainScreen};
            this.mainScreen.getListener().insertInstance(
                    new ObjectInstance(forName, pClasses, params), desc);
        } catch (ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

}
