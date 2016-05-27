package br.com.urcontroler.main.view.menu;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.entity.Menu;
import br.com.urcontroler.data.db.entity.controller.MenuController;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.MenuBuilder;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.exception.ViewException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Bean de controle para a View de menus
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class MenuBean extends ViewBean<MenuView> {

    private MenuController controller;

    /**
     * Cria nova instancia de MenuBean
     *
     * @param view {@code MenuView} Tela
     */
    public MenuBean(MenuView view) {
        super(view);
        try {
            this.controller = (MenuController) getView().getController(MenuController.class);
            onLoad(null);
            buildPreview();
        } catch (Exception ex) {
            getView().throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        this.controller.replaceAll(getView().getModel().getData());
        getView().getMainScreen().reloadMenus();
    }

    @Override
    public void onLoad(BeanEvent evt) throws Exception {
        getView().getIconModel().setData(getMenuIcons());
        getView().getParentModel().setData(getParentMenus());
    }

    @Override
    public void onProcess(BeanEvent evt) throws Exception {
        buildPreview();
    }

    /**
     * Constroi os dados no menu de pré-visualização
     */
    private void buildPreview() {
        new MenuBuilder(getView().getMainScreen(), getView().getRoot())
                .buildMenu(getView().getModel().getData());
    }

    /**
     * Constroi um objeto do tipo Menu
     *
     * @return {@code Menu} Menu gerado
     */
    private Menu buildNew(String title, String icon, Menu parent) {
        Menu menu = new Menu();
        menu.setId(getNextID());
        menu.setTitle(title);
        menu.setParent(parent);
        menu.setIcon(icon);
        return menu;
    }

    /**
     * Retorna lista de entidades
     *
     * @return {@code List(Menu)} Lista de entidades
     */
    public List<Menu> getList() {
        return this.controller.findEntities();
    }

    /**
     * Adiciona novo item na tabela
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    @Override
    public void add(BeanEvent evt) throws Exception {
        ObjectWrapper wrapper = evt.getWrapper();
        if (wrapper != null) {
            String title = (String) wrapper.getValue("title");
            String icon = getIcons()[(Integer) wrapper.getValue("index")];
            Menu parent = (Menu) wrapper.getValue("parent");
            getView().getModel().add(buildNew(title, icon, parent));
            getView().getParentModel().setData(getParentMenus());
            buildPreview();
            getView().refresh();
        }
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return {@code Long} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Menu menu : getView().getModel().getData()) {
            if (id < menu.getId()) {
                id = menu.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna um array com os icones possiveis para menus
     *
     * @return {@code ImageIcon[]} Array de iconess
     */
    private ImageIcon[] getMenuIcons() {
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
     * @return {@code List(Menu)} Lista de menus superiores
     */
    private List<Menu> getParentMenus() {
        List<Menu> parents = new ArrayList<>();
        parents.add(new Menu(0l, "Raiz", null));
        for (Menu menu : getView().getModel().getData()) {
            parents.add(menu);
        }
        return parents;
    }

}
