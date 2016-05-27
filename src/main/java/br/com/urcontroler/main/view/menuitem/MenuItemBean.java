package br.com.urcontroler.main.view.menuitem;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.entity.Menu;
import br.com.urcontroler.data.db.entity.MenuItem;
import br.com.urcontroler.data.db.entity.controller.MenuController;
import br.com.urcontroler.data.db.entity.controller.MenuItemController;
import br.com.urcontroler.data.enums.ViewType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Bean de controle para tela de cadastro de itens de menu
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class MenuItemBean extends ViewBean<MenuItemView> {

    private MenuController menuController;
    private MenuItemController controller;

    /**
     * Cria nova instancia de MenuItemBean
     *
     * @param view {@code MenuItemView} View dos itens de menu
     */
    public MenuItemBean(MenuItemView view) {
        super(view);
        try {
            this.controller = (MenuItemController) view.getController(MenuItemController.class);
            this.menuController = (MenuController) view.getController(MenuController.class);
        } catch (ClassNotFoundException | InstantiationException ex) {
            Logger.getLogger(MenuItemBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        getView().getParentModel().setData(getParentMenus());
        getView().getIconModel().setData(getItemIcons());
        getView().getTypeModel().setData(ViewType.values());
    }

    /**
     * Retorna lista de entidades
     *
     * @return {@code List(MenuItem)} Lista de entidades
     */
    public List<MenuItem> getList() {
        return this.controller.findEntities();
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        controller.replaceAll(getView().getModel().getData());
        getView().getMainScreen().reloadMenus();
    }

    /**
     * Adiciona novo item na tabela
     *
     * @param evt {@code BeanEvent} Evento do bean
     * @throws java.lang.Exception Exceção lançada
     */
    @Override
    public void add(BeanEvent evt) throws Exception {
        ObjectWrapper ow = (ObjectWrapper) evt.getValue();
        String title = (String) ow.getValue("title");
        Integer icon = (Integer) ow.getValue("icon");
        String itemClass = (String) ow.getValue("class");
        Menu menu = (Menu) ow.getValue("menu");
        MenuItem item = new MenuItem(menu, itemClass, title, getIcons()[icon]);
        getView().getModel().add(item);
    }

    /**
     * Retorna um array com os icones possiveis para menus
     *
     * @return {@code ImageIcon[]} Array de iconess
     */
    public ImageIcon[] getItemIcons() {
        List<ImageIcon> icons = new ArrayList<>();
        for (String icon : getIcons()) {
            icons.add(new ImageIcon(getClass().getResource(icon)));
        }
        return icons.toArray(new ImageIcon[]{});
    }

    /**
     * Retorna os nomes dos icones
     *
     * @return {@code String[]} Nomes dos icones
     */
    private String[] getIcons() {
        String path = "/Mixed/";
        List<String> list = new ArrayList<>();
        File dir = new File(getClass().getResource(path).getFile());
        for (File file : dir.listFiles()) {
            list.add(path + file.getName());
        }
        list.removeAll(Collections.singleton(null));
        Collections.sort(list);
        return list.toArray(new String[]{});
    }

    /**
     * Retorna lista de menus superiores
     *
     * @return {@code List(Menu)}
     */
    private List<Menu> getParentMenus() {
        List<Menu> parents = new ArrayList<>();
        parents.add(new Menu((long) 0, "Raiz", null));
        for (Menu menu : menuController.findEntities()) {
            parents.add(menu);
        }
        return parents;
    }
}
