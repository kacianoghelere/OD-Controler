package br.com.odcontroler.main;

import br.com.gmp.comps.baloontip.src.BalloonUtil;
import br.com.gmp.utils.annotations.Intercept;
import br.com.gmp.utils.interceptors.InterceptorModule;
import br.com.gmp.utils.system.SystemProperties;
import br.com.odcontroler.main.bean.MainScreenBean;
import br.com.odcontroler.main.interfaces.Main;
import br.com.odcontroler.main.interfaces.MainListener;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.MenuBuilder;
import br.com.odcontroler.main.view.dice.DiceView;
import br.com.odcontroler.main.view.menu.MenuView;
import br.com.odcontroler.main.view.menuitem.MenuItemView;
import br.com.odcontroler.main.view.object.ViewParameter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;

/**
 * Tela principal
 *
 * @author kaciano
 */
public class MainScreen extends javax.swing.JFrame implements Main {

    protected final Logger LOGGER = Logger.getLogger(MainScreen.class.getName());
    private final String ICON = "/dices/d12-icon.png";
    private final String PROP = "/br/com/odcontroler/properties/od-properties.properties";
    private final String VIEWPATH = "src/main/java/br/com/odcontroler/main/view";
    private MainListener listener;
    private Injector injector;
    protected Properties PROPS;

    /**
     * Cria novo MainScreen
     */
    public MainScreen() {
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        loadProperties();
        String name = getProperty("system.name");
        String version = getProperty("system.version");
        setTitle(name + " - Versão: " + version);
        setIconImage(new ImageIcon(getClass().getResource(ICON)).getImage());
        initComponents();
        setControls(new ViewParameter(false, false, false, false));
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        injector = Guice.createInjector(new InterceptorModule());
        listener = injector.getInstance(MainScreenBean.class);
        listener.setScreen(this);
        printTypedMsg("Aplicaçao iniciada", INFORMATIVE_MSG);
        loadMenus();
        printViews();
    }

    /**
     * Carrega o menu principal com as views no banco de dados
     */
    private void loadMenus() {
        try {
            MenuBuilder builder = injector.getInstance(MenuBuilder.class);
            builder.setMainScreen(this);
            builder.setRoot(jMRoot);
            builder.build();
            new BalloonUtil().showTimedBallon(jMRoot, "Menus carregados...");
        } catch (ClassNotFoundException | InstantiationException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Carrega o menu principal com as views no banco de dados
     */
    public void reloadMenus() {
        new Thread() {

            @Override
            public void run() {
                loadMenus();
            }

        }.start();
    }

    /**
     * Método que efetua a impressão de todas as views geradas
     */
    private void printViews() {
        File viewDir = new File(VIEWPATH);
        printChild(viewDir);
    }

    /**
     * Imprime as pastas e arquivos dentro do diretório indicado
     *
     * @param dir {@code File} Diretório
     */
    private void printChild(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                printChild(file);
            }
            if (file.getPath().endsWith("View.java")
                    && !file.getPath().endsWith("SubView.java")) {
                print(file.getPath().substring(14).replaceAll("/", "."));
            }
        }
    }

    /**
     * Retorna o arquivo de propriedades do sistema
     */
    private void loadProperties() {
        try {
            PROPS = new Properties();
            PROPS.load(getClass().getResourceAsStream(PROP));
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Retorna a propriedade da chave indicada
     *
     * @param key {@code String} Chave da propriedade
     * @return {@code String} Valor da propriedade
     */
    public String getProperty(String key) {
        return PROPS.getProperty(key);
    }

    @Override
    public void commit(ActionEvent evt) {
        listener.commit(new BeanEvent(this, evt));
    }

    @Override
    public void process(ActionEvent evt) {
        listener.process(new BeanEvent(this, evt));
    }

    @Override
    public void clear(ActionEvent evt) {
        listener.clear(new BeanEvent(this, evt));
    }

    @Override
    public void load(ActionEvent evt) {
        listener.load(new BeanEvent(this, evt));
    }

    //<editor-fold desc="Get's & Set's" defaultstate="collapsed">
    /**
     * Retorna o listener
     *
     * @return {@code MainListener} Listener do frame principal
     */
    public MainListener getListener() {
        return listener;
    }

    /**
     * Modifica o listener
     *
     * @param listener {@code MainListener} Listener do frame principal
     */
    public void setListener(MainListener listener) {
        this.listener = listener;
    }

    /**
     * Retorno o desktop
     *
     * @return {@code JDesktopPane}
     */
    public JDesktopPane getDesktop() {
        return desktop;
    }

    /**
     * Modifica o desktop
     *
     * @param desktop {@code JDesktopPane}
     */
    public void setDesktop(JDesktopPane desktop) {
        this.desktop = desktop;
    }

    /**
     * Modifica os controles de acordo com a View ativa
     *
     * @param controls {@code boolean[]} Array com as opções de controle
     */
    public void setControls(Boolean... controls) {
        this.jBSave.setEnabled(controls[0]);
        this.jBProcess.setEnabled(controls[1]);
        this.jBClear.setEnabled(controls[2]);
        this.jBRefresh.setEnabled(controls[3]);
    }

    /**
     * Modifica os controles de acordo com a View ativa
     *
     * @param param {@code ViewParameter} Parametros das opções de controle
     */
    public void setControls(ViewParameter param) {
        this.jBSave.setEnabled(param.isSave());
        this.jBProcess.setEnabled(param.isProcess());
        this.jBClear.setEnabled(param.isClear());
        this.jBRefresh.setEnabled(param.isLoad());
    }

    /**
     * Imprime o objeto no console
     *
     * @param object {@code Object} Objeto a ser impresso no console
     */
    private void print(Object object) {
        System.out.println(object);
    }

    /**
     * <html>
     * Imprime uma mensagem na barra de mensagens <br><br>
     * <table border="1">
     * <thead>
     * <tr>
     * <th>Tipo de mensagem</th>
     * <th>Variavel</th>
     * </tr>
     * </thead>
     * <tbody>
     * <tr>
     * <td>Mensagem informativa</td>
     * <td>MainScreen.QUESTION_ICON</td>
     * </tr>
     * <tr>
     * <td>Mensagem de questionamento</td>
     * <td>MainScreen.INFORMATIVE_ICON</td>
     * </tr>
     * <tr>
     * <td>Mensagem de aviso</td>
     * <td>MainScreen.WARNING_ICON</td>
     * </tr>
     * <tr>
     * <td>Mensagem de erro</td>
     * <td>MainScreen.ERROR_ICON</td>
     * </tr>
     * <tr>
     * <td>Mensagem de sucesso</td>
     * <td>MainScreen.SUCCESS_ICON</td>
     * </tr>
     * </tbody>
     * </table>
     *
     * @param text {@code String} Texto à ser impresso
     * @param icon {@code String} Icone de tipo para a mensagem
     * </html>
     */
    private void printMsg(String text, String icon) {
        ImageIcon ic = new javax.swing.ImageIcon(getClass().getResource(icon));
        this.jLMsgs.setText(text);
        this.jLMsgs.setIcon(ic);
        try {
            getListener().appendLog(text);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <html>
     * Imprime uma mensagem na barra de mensagens<br><br>
     * <table border="1">
     * <thead>
     * <tr>
     * <th>Tipo de mensagem</th>
     * <th>Mensagem</th>
     * </tr>
     * </thead>
     * <tbody>
     * <tr>
     * <td>Mensagem informativa</td>
     * <td>1</td>
     * </tr>
     * <tr>
     * <td>Mensagem de questionamento</td>
     * <td>2</td>
     * </tr>
     * <tr>
     * <td>Mensagem de aviso</td>
     * <td>3</td>
     * </tr>
     * <tr>
     * <td>Mensagem de erro</td>
     * <td>4</td>
     * </tr>
     * <tr>
     * <td>Mensagem de sucesso</td>
     * <td>5</td>
     * </tr>
     * </tbody>
     * </table>
     *
     * @param text {@code String} Texto à ser impresso
     * @param type {@code int} Tipo da mensagem
     * </html>
     */
    @Intercept
    public void printTypedMsg(String text, int type) {
        switch (type) {
            case 1:
                printMsg(text, INFORMATIVE_ICON);
                print(SystemProperties.ANSI_BLUE + "(INFO) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            case 2:
                printMsg(text, QUESTION_ICON);
                print(SystemProperties.ANSI_BLUE + "(QUESTION) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            case 3:
                printMsg(text, WARNING_ICON);
                print(SystemProperties.ANSI_YELLOW + "(WARNING) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            case 4:
                printMsg(text, ERROR_ICON);
                print(SystemProperties.ANSI_RED + "(ERROR) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            case 5:
                printMsg(text, SUCCESS_ICON);
                print(SystemProperties.ANSI_GREEN + "(SUCCESS) " + text
                        + SystemProperties.ANSI_BLACK);
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Limpa as informações da barra de mensagem
     */
    public void clearMsg() {
        this.jLMsgs.setText("");
        this.jLMsgs.setIcon(null);
    }

    /**
     * Retorna o menu raiz
     *
     * @return {@code JMenu} Menu raiz
     */
    public JMenu getRoot() {
        return jMRoot;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jBSave = new javax.swing.JButton();
        jBProcess = new javax.swing.JButton();
        jBClear = new javax.swing.JButton();
        jBRefresh = new javax.swing.JButton();
        jBDice = new javax.swing.JButton();
        desktop = new javax.swing.JDesktopPane();
        jTBMsgs = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLMsgs = new javax.swing.JLabel();
        jTBSearch = new javax.swing.JToolBar();
        gTView = new br.com.gmp.comps.textfield.GTextField();
        jMenuBar = new javax.swing.JMenuBar();
        jMOptions = new javax.swing.JMenu();
        jMISave = new javax.swing.JMenuItem();
        jMIProcess = new javax.swing.JMenuItem();
        jMIRefresh = new javax.swing.JMenuItem();
        jMIDice = new javax.swing.JMenuItem();
        jMControls = new javax.swing.JMenu();
        jMIMenus = new javax.swing.JMenuItem();
        jMIViews = new javax.swing.JMenuItem();
        jMRoot = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);
        jToolBar.setName("jToolBar"); // NOI18N

        jBSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/save.png"))); // NOI18N
        jBSave.setToolTipText("Salvar");
        jBSave.setFocusable(false);
        jBSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBSave.setName("jBSave"); // NOI18N
        jBSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });
        jToolBar.add(jBSave);

        jBProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jBProcess.setToolTipText("Processar");
        jBProcess.setFocusable(false);
        jBProcess.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBProcess.setName("jBProcess"); // NOI18N
        jBProcess.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBProcessActionPerformed(evt);
            }
        });
        jToolBar.add(jBProcess);

        jBClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/brush.png"))); // NOI18N
        jBClear.setToolTipText("Limpar");
        jBClear.setFocusable(false);
        jBClear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBClear.setName("jBClear"); // NOI18N
        jBClear.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClearActionPerformed(evt);
            }
        });
        jToolBar.add(jBClear);

        jBRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jBRefresh.setToolTipText("Recarregar");
        jBRefresh.setFocusable(false);
        jBRefresh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBRefresh.setName("jBRefresh"); // NOI18N
        jBRefresh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRefreshActionPerformed(evt);
            }
        });
        jToolBar.add(jBRefresh);

        jBDice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/dice.gif"))); // NOI18N
        jBDice.setToolTipText("Jogar dados");
        jBDice.setFocusable(false);
        jBDice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBDice.setName("jBDice"); // NOI18N
        jBDice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDiceActionPerformed(evt);
            }
        });
        jToolBar.add(jBDice);

        desktop.setBackground(new java.awt.Color(204, 204, 204));
        desktop.setName("desktop"); // NOI18N

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jTBMsgs.setFloatable(false);
        jTBMsgs.setRollover(true);
        jTBMsgs.setName("jTBMsgs"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N
        jTBMsgs.add(jSeparator1);

        jLMsgs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/toolbar/1.png"))); // NOI18N
        jLMsgs.setText("Mensagens");
        jLMsgs.setName("jLMsgs"); // NOI18N
        jLMsgs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLMsgsMouseClicked(evt);
            }
        });
        jTBMsgs.add(jLMsgs);

        jTBSearch.setFloatable(false);
        jTBSearch.setRollover(true);
        jTBSearch.setName("jTBSearch"); // NOI18N

        gTView.setName("gTView"); // NOI18N
        gTView.setPreferredSize(new java.awt.Dimension(170, 28));
        gTView.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTViewKeyReleased(evt);
            }
        });
        jTBSearch.add(gTView);

        jMenuBar.setName("jMenuBar"); // NOI18N

        jMOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1246_.png"))); // NOI18N
        jMOptions.setText("Opções");
        jMOptions.setName("jMOptions"); // NOI18N

        jMISave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/save.png"))); // NOI18N
        jMISave.setText("Salvar");
        jMISave.setName("jMISave"); // NOI18N
        jMISave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISaveActionPerformed(evt);
            }
        });
        jMOptions.add(jMISave);

        jMIProcess.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jMIProcess.setText("Processar");
        jMIProcess.setName("jMIProcess"); // NOI18N
        jMIProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProcessActionPerformed(evt);
            }
        });
        jMOptions.add(jMIProcess);

        jMIRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jMIRefresh.setText("Recarregar");
        jMIRefresh.setName("jMIRefresh"); // NOI18N
        jMIRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRefreshActionPerformed(evt);
            }
        });
        jMOptions.add(jMIRefresh);

        jMIDice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/dice.gif"))); // NOI18N
        jMIDice.setText("Jogar dados");
        jMIDice.setName("jMIDice"); // NOI18N
        jMIDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDiceActionPerformed(evt);
            }
        });
        jMOptions.add(jMIDice);

        jMControls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/window/frame.png"))); // NOI18N
        jMControls.setText("Cadastros");
        jMControls.setName("jMControls"); // NOI18N

        jMIMenus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar.png"))); // NOI18N
        jMIMenus.setText("Menus");
        jMIMenus.setName("jMIMenus"); // NOI18N
        jMIMenus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIMenusActionPerformed(evt);
            }
        });
        jMControls.add(jMIMenus);

        jMIViews.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/window/dialog.png"))); // NOI18N
        jMIViews.setText("Telas");
        jMIViews.setName("jMIViews"); // NOI18N
        jMIViews.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIViewsActionPerformed(evt);
            }
        });
        jMControls.add(jMIViews);

        jMOptions.add(jMControls);

        jMenuBar.add(jMOptions);

        jMRoot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1214_.png"))); // NOI18N
        jMRoot.setText("Informações");
        jMRoot.setName("jMRoot"); // NOI18N
        jMenuBar.add(jMRoot);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
            .addComponent(jTBMsgs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jTBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTBSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(desktop)
                .addGap(0, 0, 0)
                .addComponent(jTBMsgs, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        commit(evt);
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jBProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBProcessActionPerformed
        process(evt);
    }//GEN-LAST:event_jBProcessActionPerformed

    private void jBRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRefreshActionPerformed
        load(evt);
    }//GEN-LAST:event_jBRefreshActionPerformed

    private void jMISaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISaveActionPerformed
        commit(evt);
    }//GEN-LAST:event_jMISaveActionPerformed

    private void jMIProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProcessActionPerformed
        process(evt);
    }//GEN-LAST:event_jMIProcessActionPerformed

    private void jMIRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRefreshActionPerformed
        load(evt);
    }//GEN-LAST:event_jMIRefreshActionPerformed

    private void jMIDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDiceActionPerformed
        listener.insertView(new DiceView(this));
    }//GEN-LAST:event_jMIDiceActionPerformed

    private void jBDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDiceActionPerformed
        listener.insertView(new DiceView(this));
    }//GEN-LAST:event_jBDiceActionPerformed

    private void jBClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClearActionPerformed
        clear(evt);
    }//GEN-LAST:event_jBClearActionPerformed

    private void jLMsgsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMsgsMouseClicked
        clearMsg();
    }//GEN-LAST:event_jLMsgsMouseClicked

    private void jMIMenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIMenusActionPerformed
        listener.insertView(new MenuView(this));
    }//GEN-LAST:event_jMIMenusActionPerformed

    private void jMIViewsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIViewsActionPerformed
        listener.insertView(new MenuItemView(this));
    }//GEN-LAST:event_jMIViewsActionPerformed

    private void gTViewKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTViewKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean searchView = listener.searchView(gTView.getText());
            if (searchView) {
                printTypedMsg("View sendo carregada!", MainScreen.INFORMATIVE_MSG);
                gTView.clear();
            } else {
                printTypedMsg("View não encontrada!", MainScreen.ERROR_MSG);
            }
        }
    }//GEN-LAST:event_gTViewKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private br.com.gmp.comps.textfield.GTextField gTView;
    private javax.swing.JButton jBClear;
    private javax.swing.JButton jBDice;
    private javax.swing.JButton jBProcess;
    private javax.swing.JButton jBRefresh;
    private javax.swing.JButton jBSave;
    private javax.swing.JLabel jLMsgs;
    private javax.swing.JMenu jMControls;
    private javax.swing.JMenuItem jMIDice;
    private javax.swing.JMenuItem jMIMenus;
    private javax.swing.JMenuItem jMIProcess;
    private javax.swing.JMenuItem jMIRefresh;
    private javax.swing.JMenuItem jMISave;
    private javax.swing.JMenuItem jMIViews;
    private javax.swing.JMenu jMOptions;
    private javax.swing.JMenu jMRoot;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jTBMsgs;
    private javax.swing.JToolBar jTBSearch;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
