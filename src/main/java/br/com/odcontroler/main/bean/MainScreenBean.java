package br.com.odcontroler.main.bean;

import br.com.gmp.utils.annotations.Intercept;
import br.com.gmp.utils.reflection.ObjectInstance;
import br.com.gmp.utils.reflection.ReflectionUtil;
import br.com.odcontroler.data.entity.MenuItem;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.interfaces.Main;
import br.com.odcontroler.main.interfaces.MainListener;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.object.ViewParameter;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * Bean de controle da tela principal
 *
 * @author kaciano
 */
public class MainScreenBean implements MainListener {

    protected static final Logger LOG = Logger.getLogger(MainScreenBean.class.getName());
    private View actualView;
    private MainScreen screen;
    private Map<String, MenuItem> viewMap;

    /**
     * Cria nova instancia de MainScreenBean
     */
    public MainScreenBean() {
        this.screen = null;
        this.initialize();
    }

    /**
     * Cria nova instancia de MainScreenBean
     *
     * @param mainScreen <code>MainScreen</code>
     */
    public MainScreenBean(MainScreen mainScreen) {
        this.screen = mainScreen;
        this.initialize();
    }

    /**
     * Método inicializador
     */
    private void initialize() {
        this.viewMap = new HashMap<>();
    }

    @Intercept
    @Override
    public void commit(BeanEvent evt) {
        if (getActualView() != null && getActualView().canCommit()) {
            getActualView().commit();
        } else if (!getActualView().canCommit()) {
            screen.printTypedMsg("Esta View nao pode salvar!", MainScreen.WARNING_MSG);
        }
    }

    @Intercept
    @Override
    public void process(BeanEvent evt) {
        if (getActualView() != null && getActualView().canProcces()) {
            getActualView().process();
        } else if (!getActualView().canProcces()) {
            screen.printTypedMsg("Esta View nao pode processar!", MainScreen.WARNING_MSG);
        }
    }

    @Intercept
    @Override
    public void clear(BeanEvent evt) {
        if (getActualView() != null && getActualView().canClear()) {
            getActualView().clear();
        } else if (!getActualView().canClear()) {
            screen.printTypedMsg("Esta View nao pode limpar!", MainScreen.WARNING_MSG);
        }
    }

    @Intercept
    @Override
    public void load(BeanEvent evt) {
        if (getActualView() != null && getActualView().canLoad()) {
            getActualView().load();
        } else if (!getActualView().canLoad()) {
            screen.printTypedMsg("Esta View nao pode carregar!", MainScreen.WARNING_MSG);
        }
    }

    @Override
    public View getActualView() {
        return actualView;
    }

    @Override
    public void setActualView(View view) {
        this.actualView = view;
        this.screen.setControls(new ViewParameter(
                this.actualView.canCommit() != null ? actualView.canCommit() : false,
                this.actualView.canProcces() != null ? actualView.canProcces() : false,
                this.actualView.canClear() != null ? actualView.canClear() : false,
                this.actualView.canLoad() != null ? actualView.canLoad() : false
        ));
        System.out.println("View ativa: " + actualView.getClass().getSimpleName());
    }

    @Override
    public Boolean searchView(String prefix) {
        boolean found = false;
        for (Map.Entry<String, MenuItem> entry : viewMap.entrySet()) {
            System.out.println(prefix + " == " + entry.getKey() + "?");
            if (prefix.equalsIgnoreCase(entry.getKey())) {
                try {
                    ReflectionUtil reflect = new ReflectionUtil();
                    Class<?> objClass = Class.forName(entry.getValue().getViewClass());
                    Class<?>[] argTypes = new Class[]{MainScreen.class};
                    Object[] arguments = new Object[]{screen};
                    ObjectInstance inst = new ObjectInstance(objClass, argTypes, arguments);
                    View newView = (View) reflect.newInstance(inst);
                    insertView(newView);
                    found = true;
                } catch (ClassNotFoundException | InstantiationException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                }
                break;
            }
        }
        return found;
    }

    @Override
    public void clear() {
        if (screen.getDesktop().getAllFrames().length == 0) {
            this.screen.setControls(new ViewParameter(false, false, false, false));
        }
    }

    @Intercept
    @Override
    public void insertView(View view) {
        if (!isOnDesktop(view)) {
            for (Component c : screen.getDesktop().getComponents()) {
                if (c instanceof JInternalFrame) {
                    try {
                        JInternalFrame jif = (JInternalFrame) c;
                        jif.setSelected(false);
                    } catch (PropertyVetoException ex) {
                        LOG.log(Level.SEVERE, null, ex);
                    }
                }
            }
            try {
                screen.getDesktop().add(view);
                screen.getDesktop().setLayer(view,
                        JDesktopPane.FRAME_CONTENT_LAYER);
                screen.getDesktop().setSelectedFrame(view);
                view.setSelected(true);
            } catch (PropertyVetoException ex) {
                LOG.log(Level.SEVERE, null, ex);
            }
        } else {
            screen.printTypedMsg("View já carregada!", Main.INFORMATIVE_MSG);
        }
    }

    /**
     * Verifica se a View já está na tela
     *
     * @param view View
     * @return Boolean Está na tela?
     */
    private Boolean isOnDesktop(JInternalFrame view) {
        boolean indesktop = false;
        for (Component c : screen.getDesktop().getComponents()) {
            if (c instanceof JInternalFrame) {
                JInternalFrame jif = (JInternalFrame) c;
                if (jif.getTitle().equals(view.getTitle())) {
                    indesktop = true;
                    break;
                }
            }
        }
        return indesktop;
    }

    /**
     * Remove todos os frames da tela principal
     */
    @Intercept
    public void clearDesktop() {
        screen.getDesktop().removeAll();
    }

    /**
     * Retorna a tela principal
     *
     * @return <code>MainScreen</code> Tela principal
     */
    @Override
    public MainScreen getScreen() {
        return screen;
    }

    /**
     * Modifica a tela principal
     *
     * @param screen <code>MainScreen</code> Tela principal
     */
    @Override
    public void setScreen(MainScreen screen) {
        this.screen = screen;
    }

    @Override
    public Map<String, MenuItem> getViewMap() {
        return viewMap;
    }

}
