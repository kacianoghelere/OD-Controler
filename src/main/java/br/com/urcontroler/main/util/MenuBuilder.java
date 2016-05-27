package br.com.urcontroler.main.util;

import br.com.gmp.utils.annotations.Intercept;
import br.com.gmp.utils.object.StringUtil;
import br.com.gmp.utils.reflection.ReflectionUtil;
import br.com.urcontroler.data.db.entity.Menu;
import br.com.urcontroler.data.db.entity.MenuItem;
import br.com.urcontroler.data.db.entity.comparators.MenuComparator;
import br.com.urcontroler.data.db.entity.comparators.MenuItemComparator;
import br.com.urcontroler.data.db.entity.controller.MenuController;
import br.com.urcontroler.data.db.entity.controller.MenuItemController;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.system.SystemManager;
import java.awt.Component;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

/**
 * Classe utilitária para construção de menus e dos respectivos itens
 *
 * @author Kaciano Ghelere
 * @version 1.0
 * @see br.com.urcontroler.data.db.entity.controller.MenuController
 * @see br.com.urcontroler.data.db.entity.controller.MenuItemController
 * @see br.com.urcontroler.data.db.entity.Menu
 * @see br.com.urcontroler.data.db.entity.MenuItem
 */
public class MenuBuilder {

    private MainScreen mainScreen;
    private JMenu root;
    private MenuController menuController;
    private MenuItemController viewController;
    private final ReflectionUtil reflect = new ReflectionUtil();
    private final Logger LOGGER = Logger.getLogger(MenuBuilder.class.getName());

    /**
     * Cria nova instancia de MenuBuilder
     */
    public MenuBuilder() {
    }

    /**
     * Cria nova instancia de MenuBuilder
     *
     * @param main {@code MainScreen} Tela principal
     * @param root {@code JMenu} Menu raiz
     */
    public MenuBuilder(MainScreen main, JMenu root) {
        initialize(main, root);
    }

    /**
     * Cria nova instancia de MenuBuilder
     *
     * @param main {@code MainScreen} Tela principal
     * @param root {@code JMenu} Menu raiz
     */
    public void initialize(MainScreen main, JMenu root) {
        this.mainScreen = main;
        this.root = root;
        try {
            SystemManager mng = this.mainScreen.getManager();
            this.menuController = (MenuController) mng.getController(MenuController.class);
            this.viewController = (MenuItemController) mng.getController(MenuItemController.class);
        } catch (ClassNotFoundException | InstantiationException ex) {
            Logger.getLogger(MenuBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Inicia a construção do menu
     *
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    @Intercept
    public void build() throws ClassNotFoundException, InstantiationException {
        List<Menu> menus = this.menuController.findEntities();
        List<MenuItem> views = this.viewController.findEntities();
        build(menus, views, true);
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus {@code List(Menu)} Listas de Menus
     * @param items {@code List(MenuItem)} Listas de MenuItems
     * @param execute {@code boolean} O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    @Intercept
    public void build(List<Menu> menus, List<MenuItem> items, boolean execute)
            throws ClassNotFoundException, InstantiationException {
        menus.removeAll(Collections.singleton(null));
        items.removeAll(Collections.singleton(null));
        Collections.sort(menus, new MenuComparator());
        Collections.sort(items, new MenuItemComparator());
        buildMenu(menus);
        buildItems(items, execute);
        SwingUtilities.updateComponentTreeUI(mainScreen);
    }

    /**
     * Inicia a construção do menu
     *
     * @param menus {@code List(Menu)} Listas de menus
     */
    public void buildMenu(List<Menu> menus) {
        root.removeAll();
        Collections.sort(menus, new MenuComparator());
        for (Menu menu : menus) {
            if (menu.getParent() == null) {
                insertMenu(root, menu);
            } else {
                recursiveMenus(root, menu);
            }
        }
    }

    /**
     * Insere um novo menu no menu pai
     *
     * @param parent {@code JMenu} Menu pai
     * @param menu {@code Menu} Menu à ser inserido
     */
    private void insertMenu(JMenu parent, Menu menu) {
        JMenu jmenu = generateMenu(menu);
        parent.add(jmenu);
    }

    /**
     * Insere os menus recursivamente
     *
     * @param parent {@code JMenu} Menu pai
     * @param menu {@code Menu} Menu à ser inserido
     */
    private void recursiveMenus(JMenu parent, Menu menu) {
        JMenu jmenu = null;
        String sub = null;
        Long menuid = null;
        for (Component comp : parent.getMenuComponents()) {
            jmenu = (JMenu) comp;
            sub = jmenu.getText().split("-")[0].trim();
            menuid = Long.parseLong(StringUtil.onlyNumbers(sub));
            if (menu.getParent().equals(menuid)) {
                LOGGER.log(Level.INFO, "Inserindo em: {0}", jmenu.getText());
                insertMenu(jmenu, menu);
                break;
            } else {
                recursiveMenus(jmenu, menu);
            }
        }
    }

    /**
     * Constroi os itens nos menus
     *
     * @param items {@code List(MenuItem)} Listas de MenuItems
     * @param execute {@code boolean} O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    public void buildItems(List<MenuItem> items, boolean execute)
            throws ClassNotFoundException, InstantiationException {
        Collections.sort(items, new MenuItemComparator());
        for (MenuItem item : items) {
            if (item.getMenu() == null || 0l == item.getMenu().getId()) {
                insertItem(root, item, execute);
            } else {
                recursiveItems(root, item, execute);
            }
        }
    }

    /**
     * Constroi os itens recursivamente nos menus
     *
     * @param jmenu {@code JMenu} Menu de base
     * @param item {@code MenuItem} Item a ser inserido
     * @param execute {@code boolean} O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe desconhecida
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    public void recursiveItems(JMenu jmenu, MenuItem item, boolean execute)
            throws ClassNotFoundException, InstantiationException {
        JMenu menu = null;
        String prefix = null;
        Long menuid = null;
        for (Component comp : jmenu.getMenuComponents()) {
            if (comp instanceof JMenu) {
                menu = (JMenu) comp;
                prefix = menu.getText().split("-")[0].trim();
                menuid = Long.parseLong(StringUtil.onlyNumbers(prefix));
                if (item.getMenu().equals(menuid)) {
                    insertItem(menu, item, execute);
                    break;
                } else {
                    recursiveItems(menu, item, execute);
                }
            }
        }
    }

    /**
     * Insere o item no Menu
     *
     * @param menu {@code JMenu} Menu de base
     * @param item {@code List(MenuView)} Lista de Views
     * @param execute {@code boolean} O item deve executar a função?
     * @throws java.lang.ClassNotFoundException Exceção de classe não encontrada
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    private void insertItem(JMenu menu, MenuItem item, boolean execute)
            throws ClassNotFoundException, InstantiationException {
        JMenuItem jitem = generateItem(item, execute);
        menu.add(jitem);
    }

    /**
     * Retorna um JMenu construido a partir de um Menu
     *
     * @param menu {@code Menu} Objeto de Menu
     * @return {@code JMenu} JMenu gerado
     */
    public JMenu generateMenu(Menu menu) {
        JMenu jmenu = new JMenu();
        jmenu.setName(menu.toString());
        jmenu.setText(menu.toString());
        jmenu.setIcon(new ImageIcon(getClass().getResource(menu.getIcon())));
        return jmenu;
    }

    /**
     * Retorna um JMenuItem construido a partir de um MenuItem
     *
     * @param view {@code MenuItem} Objeto da View
     * @param execute {@code boolean} O item deve executar a função?
     * @return {@code JMenuItem} Item criado
     * @throws ClassNotFoundException Exceção de classe não encontrada
     * @throws java.lang.InstantiationException Exceção de instanciamento
     */
    public JMenuItem generateItem(final MenuItem view, boolean execute)
            throws ClassNotFoundException, InstantiationException {
        JMenuItem item = new JMenuItem();
        item.setText(view.getTitle());
        item.setIcon(new ImageIcon(getClass().getResource(view.getIcon())));
        if (execute) {
            mainScreen.getListener().getViewMap()
                    .put(view.getTitle().split("-")[0].trim(), view);
            view.setViewClass(view.getViewClass().replaceAll(".java", ""));
//            item.addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    try {
//                        DescriptionObject desc;
//                        desc = new DescriptionObject.Builder().fromBase(view.getDescription());
//                        mainScreen.getListener().insertInstance(
//                                new ObjectInstance(
//                                        Class.forName(view.getViewClass()),
//                                        new Class[]{MainScreen.class},
//                                        new Object[]{mainScreen}), desc);
//                    } catch (ClassNotFoundException ex) {
//                        LOGGER.log(Level.SEVERE, null, ex);
//                    }
//                }
//            });
            item.addActionListener(new MenuBuilderAction(mainScreen, view));
        }
        return item;
    }

    /**
     * Retorna a tela principal
     *
     * @return {@code MainScreen} Tela principal
     */
    public MainScreen getMainScreen() {
        return mainScreen;
    }

    /**
     * Modifica a tela principal
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    /**
     * Retorna o menu raiz
     *
     * @return {@code JMenu} Menu raiz
     */
    public JMenu getRoot() {
        return root;
    }

    /**
     * Modifica o menu raiz
     *
     * @param root {@code JMenu} Menu raiz
     */
    public void setRoot(JMenu root) {
        this.root = root;
    }

}
