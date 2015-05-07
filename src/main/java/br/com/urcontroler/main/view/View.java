package br.com.urcontroler.main.view;

import br.com.gmp.comps.cleaner.ComponentCleaner;
import br.com.gmp.comps.interfaces.ValidableComponent;
import br.com.gmp.utils.system.TimeCounter;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.actions.ClearAction;
import br.com.urcontroler.main.actions.FrameAction;
import br.com.urcontroler.main.actions.LoadAction;
import br.com.urcontroler.main.actions.ProccessAction;
import br.com.urcontroler.main.actions.CommitAction;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.dialog.DescriptionDialog;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.BeanListener;
import br.com.urcontroler.main.view.interfaces.ViewListener;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 * View padrão para embasamento
 *
 * @author kaciano
 * @version 1.0
 * @param <T> Tipo do Bean
 */
public abstract class View<T> extends JInternalFrame implements ViewListener<T> {

    private final MainScreen mainScreen;
    private Boolean canSave;
    private Boolean canProcess;
    private Boolean canClear;
    private Boolean canLoad;
    private String alias = "";
    private Description description;
    private Object parameter;
    private FrameAction saveAction;
    private FrameAction processAction;
    private FrameAction clearAction;
    private FrameAction loadAction;

    /**
     * Cria nova instancia de DefaultView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public View(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        initComponents();
        description = new Description.Builder("1", "2", "3", "4", "5", "6").apply();
        this.addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                mainScreen.getListener().setCurrentView(View.this);
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                mainScreen.getDesktop().remove(View.this);
                mainScreen.getListener().clear();
            }

        });
        DescribeAction describe = new DescribeAction();
        getRootPane().getActionMap().put("describe", describe);
        getRootPane().getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "describe");
        buildActions();
    }

    /**
     * Modifica os controles da view
     *
     * @param param {@code ViewParameter} Parametro para carregamento de views
     */
    public void setControls(ViewParameter param) {
        this.canSave = param.isSave();
        this.canProcess = param.isProcess();
        this.canClear = param.isClear();
        this.canLoad = param.isLoad();
    }

    /**
     * Monta as ações nas respectivas teclas
     */
    private void buildActions() {
        saveAction = new CommitAction(this);
        addKeyInput("commit", KeyEvent.VK_F2, saveAction);
        processAction = new ProccessAction(this);
        addKeyInput("proccess", KeyEvent.VK_F6, processAction);
        clearAction = new ClearAction(this);
        addKeyInput("clear", KeyEvent.VK_F4, clearAction);
        loadAction = new LoadAction(this);
        addKeyInput("load", KeyEvent.VK_F8, loadAction);
    }

    /**
     * Adiciona as ações especificas de cada tecla
     *
     * @param name {@code String} Nome da ação
     * @param keycode {@code KeyEvent} Código da tecla
     * @param action {@code Action} Ação da tecla
     */
    private void addKeyInput(String name, int keycode, Action action) {
        this.getRootPane().getActionMap().put(name, action);
        this.getRootPane().getInputMap().put(KeyStroke.getKeyStroke(keycode, 0), name);
    }

    /**
     * Descreve o uso da view e suas funções
     *
     * @throws java.lang.Exception Exceção padrão
     */
    public void describe() throws Exception {
        DescriptionDialog desc = new DescriptionDialog(this, getDescription().format());
    }

    @Override
    public void onCommit() {
        try {
            new Thread() {
                @Override
                public void run() {
                    TimeCounter timeCounter = new TimeCounter();
                    getMainScreen().toggleProcess();
                    try {
                        getBean().onCommit(new BeanEvent(View.this, null));
                        showMessage("Dados salvos.", MainScreen.SUCCESS_MSG);
                        new ComponentCleaner(true).clean(View.this);
                    } catch (Exception ex) {
                        throwException(new ViewException(View.this, "Commit error", ex));
                    }
                    getMainScreen().toggleProcess();
                    System.out.println("Commited in " + timeCounter.getTimeSpent() + "ms");
                }
            }.start();
        } catch (Exception ex) {
            throwException(new ViewException(this, "Commit error", ex));
        }
    }

    @Override
    public void onProcess() {
        try {
            new Thread() {
                @Override
                public void run() {
                    getMainScreen().toggleProcess();
                    try {
                        getBean().onProcess(new BeanEvent(View.this, null));
                        showMessage("Dados processados.", MainScreen.INFORMATIVE_MSG);
                    } catch (Exception ex) {
                        throwException(new ViewException(View.this, "Process error", ex));
                    }
                    getMainScreen().toggleProcess();
                }
            }.start();
        } catch (Exception ex) {
            throwException(new ViewException(this, "Process error", ex));
        }
    }

    @Override
    public void onClear() {
        try {
            new Thread() {
                @Override
                public void run() {
                    getMainScreen().toggleProcess();
                    try {
                        getBean().onClear(new BeanEvent(View.this, null));
                        //showMessage("Dados preenchidos removidos.", MainScreen.INFORMATIVE_MSG);
                    } catch (Exception ex) {
                        throwException(new ViewException(View.this, "Clear error", ex));
                    }
                    getMainScreen().toggleProcess();
                }
            }.start();
        } catch (Exception ex) {
            throwException(new ViewException(View.this, "Clear error", ex));
        }
    }

    @Override
    public void onLoad() {
        try {
            new Thread() {
                @Override
                public void run() {
                    getMainScreen().toggleProcess();
                    try {
                        getBean().onLoad(new BeanEvent(View.this, null));
                        //showMessage("Dados carregados.", MainScreen.INFORMATIVE_MSG);
                    } catch (Exception ex) {
                        throwException(new ViewException(View.this, "Load error", ex));
                    }
                    getMainScreen().toggleProcess();
                }
            }.start();
        } catch (Exception ex) {
            throwException(new ViewException(View.this, "Load error", ex));
        }
    }

    /**
     * Método padronizado para lançar exceções
     *
     * @param ex {@code ViewException} Exceção a ser lançada
     */
    public void throwException(ViewException ex) {
        try {
            LOGGER.log(Level.SEVERE, null, ex);
            this.showMessage(ex.getView() + ":" + ex.getMessage(), MainScreen.ERROR_MSG);
            mainScreen.getListener().appendLog(ex.getMessage());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Classe privada para uso da descrição
     */
    private class DescribeAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                describe();
            } catch (Exception ex) {
                throwException(new ViewException(View.this, "Action error", ex));
            }
        }

    }

    /**
     * Atualiza a estrutura dos componentes
     */
    public void updateComponents() {
        updateComponent(this);
    }

    /**
     * Atualiza a estrutura dos componentes
     *
     * @param component {@code Component} Componente à ser atualizada
     */
    public void updateComponent(Component component) {
        component.repaint();
        component.revalidate();
        SwingUtilities.updateComponentTreeUI(component);
    }

    /**
     * Modifica o titulo da View aplicando a sigla juntamente ao titulo
     *
     * @param alias {@code String} Sigla da View
     * @param title {@code String} Titulo da View
     */
    public void setTitle(String alias, String title) {
        super.setTitle(alias + " - " + title);
    }

    @Override
    public void showMessage(String msg, int type) {
        getMainScreen().printTypedMsg(msg, type);
        getMainScreen().showTypedBalloon(msg, type);
    }

    @Override
    public void showBallon(JComponent component, String text) {
        getMainScreen().showBalloon(component, text);
    }

    @Override
    public void showMessageBalloon(String text) {
        getMainScreen().showBalloon(text);
    }

    @Override
    public boolean validate(ValidableComponent component, String errorMsg) {
        return validate(component.validateComponent(), errorMsg);
    }

    @Override
    public boolean validate(boolean condition, String errorMsg) {
        if (!condition) {
            LOGGER.log(Level.WARNING, errorMsg);
            return false;
        }
        return true;
    }

    @Override
    public Boolean canCommit() {
        return canSave;
    }

    @Override
    public void setCommit(boolean save) {
        canSave = save;
    }

    @Override
    public Boolean canProcess() {
        return canProcess;
    }

    @Override
    public void setProcess(boolean process) {
        canProcess = process;
    }

    @Override
    public Boolean canClear() {
        return this.canClear;
    }

    @Override
    public void setClear(boolean clear) {
        this.canClear = clear;
    }

    @Override
    public Boolean canLoad() {
        return canLoad;
    }

    @Override
    public void setLoad(boolean load) {
        canLoad = load;
    }

    @Override
    public abstract <T> BeanListener getBean();

    @Override
    public MainScreen getMainScreen() {
        return this.mainScreen;
    }

    /**
     * Instrução padrão para retorno de parametros da View
     *
     * @return {@code Object} Parametro
     */
    public Object getParameter() {
        return parameter;
    }

    /**
     * Instrução padrão para modificar parametros da View
     *
     * @param parameter {@code Object} Parametro
     */
    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    /**
     * Retorna a descrição da tela
     *
     * @return {@code Description} Descrição da tela
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Modifica a descrição da tela
     *
     * @param description {@code Description} Descrição da tela
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * Retorna a sigla da View
     *
     * @return {@code String} Sigla da View
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Modifica a sigla da View
     *
     * @param alias {@code String} Sigla da View
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Informações geradas automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName(""); // NOI18N
        setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
