package br.com.urcontroler.main.bean;

import br.com.gmp.utils.annotations.Intercept;
import br.com.gmp.utils.date.DateUtil;
import br.com.gmp.utils.reflection.ObjectInstance;
import br.com.gmp.utils.reflection.ReflectionUtil;
import br.com.urcontroler.data.entity.MenuItem;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.interfaces.Main;
import br.com.urcontroler.main.interfaces.MainListener;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.AudioListBuilder;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * Bean de controle da tela principal
 *
 * @author kaciano
 */
public class MainScreenBean implements MainListener {

    private View currentView;
    private MainScreen screen;
    private Map<String, MenuItem> viewMap;
    private File dir;
    private File log;
    private final ReflectionUtil reflect = new ReflectionUtil();    

    /**
     * Cria nova instancia de MainScreenBean
     */
    public MainScreenBean() {
        this.screen = null;
        this.initialize();
        try {
            startLog();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cria nova instancia de MainScreenBean
     *
     * @param mainScreen {@code MainScreen} Tela Principal
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
    public void onCommit(BeanEvent evt) {
        if (getCurrentView() != null && getCurrentView().canCommit()) {
            getCurrentView().onCommit();
        } else if (!getCurrentView().canCommit()) {
            screen.printTypedMsg("Esta View não pode salvar!", Main.WARNING_MSG);
        }
    }

    @Intercept
    @Override
    public void onProcess(BeanEvent evt) {
        if (getCurrentView() != null && getCurrentView().canProcces()) {
            getCurrentView().onProcess();
        } else if (!getCurrentView().canProcces()) {
            screen.printTypedMsg("Esta View não pode processar!", Main.WARNING_MSG);
        }
    }

    @Intercept
    @Override
    public void onClear(BeanEvent evt) {
        if (getCurrentView() != null && getCurrentView().canClear()) {
            getCurrentView().onClear();
        } else if (!getCurrentView().canClear()) {
            screen.printTypedMsg("Esta View não pode limpar!", Main.WARNING_MSG);
        }
    }

    @Intercept
    @Override
    public void onLoad(BeanEvent evt) {
        if (getCurrentView() != null && getCurrentView().canLoad()) {
            getCurrentView().onLoad();
        } else if (!getCurrentView().canLoad()) {
            screen.printTypedMsg("Esta View não pode carregar!", Main.WARNING_MSG);
        }
    }

    @Override
    public View getCurrentView() {
        return currentView;
    }

    @Override
    public void setCurrentView(View view) {
        this.currentView = view;
        this.screen.setControls(new ViewParameter(
                this.currentView.canCommit() != null ? currentView.canCommit() : false,
                this.currentView.canProcces() != null ? currentView.canProcces() : false,
                this.currentView.canClear() != null ? currentView.canClear() : false,
                this.currentView.canLoad() != null ? currentView.canLoad() : false
        ));
        System.out.println("View ativa: " + currentView.getClass().getSimpleName());
    }

    @Override
    public Boolean searchView(String prefix) {
        boolean found = false;
        for (Map.Entry<String, MenuItem> entry : viewMap.entrySet()) {
            System.out.println(prefix + " == " + entry.getKey() + "?");
            if (prefix.equalsIgnoreCase(entry.getKey())) {
                try {
                    Class<?> objClass = Class.forName(entry.getValue().getViewClass());
                    Class<?>[] argTypes = new Class[]{MainScreen.class};
                    Object[] arguments = new Object[]{screen};
                    ObjectInstance inst = new ObjectInstance(objClass, argTypes, arguments);
                    View newView = (View) reflect.newInstance(inst);
                    insertView(newView);
                    found = true;
                } catch (ClassNotFoundException | InstantiationException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
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
                        LOGGER.log(Level.SEVERE, null, ex);
                    }
                }
            }
            try {
                view.setSize(view.getPreferredSize());
                screen.getDesktop().add(view);
                screen.getDesktop().setLayer(view,
                        JDesktopPane.FRAME_CONTENT_LAYER);
                screen.getDesktop().setSelectedFrame(view);
                view.setSelected(true);
            } catch (PropertyVetoException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        } else {
            screen.printTypedMsg("View já carregada!", Main.INFORMATIVE_MSG);
        }
    }

    @Intercept
    @Override
    public void insertInstance(ObjectInstance instance) {
        insertInstance(instance, null);
    }

    @Intercept
    @Override
    public void insertInstance(ObjectInstance instance, Description description) {
        try {
            View newView = (View) reflect.newInstance(instance);
            newView.setDescription(description != null
                    ? description : new Description.Builder().apply());
            if (instance.getCl().getClass().isAnnotationPresent(ViewData.class)) {
                ViewData data = instance.getCl().getClass().getAnnotation(ViewData.class);
                newView.setTitle(data.name());
            }
            insertView(newView);
        } catch (InstantiationException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Verifica se a View já está na tela
     *
     * @param view {@code JInternalFrame} View
     * @return Boolean {@code Boolean} Está na tela?
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
     * Inicia as pastas e o arquivo de log
     *
     * @throws IOException Exceção de I/O
     */
    private void startLog() throws IOException {
        String dirName = new DateUtil().getFormattedDate(DateUtil.NOW, DateUtil.DATE);
        dir = new File("logs/" + dirName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String logName = new DateUtil().getFormattedDate(DateUtil.NOW, DateUtil.TXTDATE);
        log = new File(dir.getPath() + "/" + logName + ".log");
        if (!log.exists()) {
            log.createNewFile();
            appendLog(logName);
        }
    }

    @Override
    public void appendLog(String logData) throws IOException {
        try (FileWriter fw = new FileWriter(this.log, true)) {
            fw.write(logData + "\n");
        }
    }

    /**
     * Remove todos os frames da tela principal
     */
    @Intercept
    public void clearDesktop() {
        screen.getDesktop().removeAll();
    }

    @Intercept
    @Override
    public void buildAudioList() {
        new Thread(AudioListBuilder.build(this.screen)).start();
    }

    /**
     * Retorna a tela principal
     *
     * @return {@code MainScreen} Tela principal
     */
    @Override
    public MainScreen getScreen() {
        return screen;
    }

    /**
     * Modifica a tela principal
     *
     * @param screen {@code MainScreen} Tela principal
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
