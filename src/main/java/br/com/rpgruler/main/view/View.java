package br.com.rpgruler.main.view;

import br.com.gmp.comps.baloontip.src.BalloonUtil;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.actions.ClearAction;
import br.com.rpgruler.main.actions.FrameAction;
import br.com.rpgruler.main.actions.LoadAction;
import br.com.rpgruler.main.actions.ProccessAction;
import br.com.rpgruler.main.actions.CommitAction;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.util.Description;
import br.com.rpgruler.main.view.dialog.DescriptionDialog;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.ViewListener;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.KeyStroke;
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
    private FrameAction proccesAction;
    private FrameAction clearAction;
    private FrameAction loadAction;

    /**
     * Cria nova instancia de DefaultView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
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
                mainScreen.getListener().setActualView(View.this);
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
     * @param param <code>ViewParameter</code> Parametro para carregamento de
     * views
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
        proccesAction = new ProccessAction(this);
        addKeyInput("proccess", KeyEvent.VK_F6, proccesAction);
        clearAction = new ClearAction(this);
        addKeyInput("clear", KeyEvent.VK_F4, clearAction);
        loadAction = new LoadAction(this);
        addKeyInput("load", KeyEvent.VK_F8, loadAction);
    }

    /**
     * Adiciona as ações especificas de cada tecla
     *
     * @param name <b><code>String</code></b> Nome da ação
     * @param keycode <b><code>KeyEvent</code></b> Código da tecla
     * @param action <b><code>Action</code></b> Ação da tecla
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

    /**
     * Classe privada para uso da descrição
     */
    private class DescribeAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                describe();
            } catch (Exception ex) {
                throwException(ex);
            }
        }

    }

    /**
     * Instrução padrão para retorno de parametros da View
     *
     * @return <code>Object</code> Parametro
     */
    public Object getParameter() {
        return parameter;
    }

    /**
     * Instrução padrão para modificar parametros da View
     *
     * @param parameter <code>Object</code> Parametro
     */
    public void setParameter(Object parameter) {
        this.parameter = parameter;
    }

    /**
     * Retorna a descrição da tela
     *
     * @return <code>Description</code> Descrição da tela
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Modifica a descrição da tela
     *
     * @param description <code>Description</code> Descrição da tela
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * Retorna a sigla da View
     *
     * @return Sigla da View
     */
    public String getAlias() {
        return alias;
    }

    /**
     *
     * @param alias Sigla da View
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public void commit() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().commit(new BeanEvent(View.this, null));
                        showMessage("Dados salvos.", MainScreen.SUCCESS_MSG);
                    } catch (Exception ex) {
                        throwException(ex);
                    }
                }
            }.start();
        } catch (Exception ex) {
            throwException(ex);
        }
    }

    @Override
    public void process() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().process(new BeanEvent(View.this, null));
                        showMessage("Dados processados.", MainScreen.INFORMATIVE_MSG);
                    } catch (Exception ex) {
                        throwException(ex);
                    }
                }
            }.start();
        } catch (Exception ex) {
            throwException(ex);
        }
    }

    @Override
    public void clear() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().clear(new BeanEvent(View.this, null));
                        showMessage("Dados preenchidos removidos.", MainScreen.INFORMATIVE_MSG);
                    } catch (Exception ex) {
                        throwException(ex);
                    }
                }
            }.start();
        } catch (Exception ex) {
            throwException(ex);
        }
    }

    @Override
    public void load() {
        try {
            new Thread() {
                @Override
                public void run() {
                    try {
                        getBean().load(new BeanEvent(View.this, null));
                        showMessage("Dados carregados.", MainScreen.INFORMATIVE_MSG);
                    } catch (Exception ex) {
                        throwException(ex);
                    }
                }
            }.start();
        } catch (Exception ex) {
            throwException(ex);
        }
    }

    /**
     * Método padronizado para lançar exceções
     *
     * @param ex <code>Exception</code> Exceção a ser lançada
     */
    protected void throwException(Exception ex) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        this.showMessage(ex.getMessage(), MainScreen.ERROR_MSG);
    }

    @Override
    public void showMessage(String msg, int type) {
        getMainScreen().printTypedMsg(msg, type);
    }

    @Override
    public void showBalloon(JComponent component, String text) {
        new BalloonUtil().showTimedBallon(component, text);
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
    public Boolean canProcces() {
        return canProcess;
    }

    @Override
    public void setProcces(boolean process) {
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
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(498, 394));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(498, 394));
        setVisible(true);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
