package br.com.urcontroler.main.view.menuitem;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.MenuDAO;
import br.com.urcontroler.data.db.dao.MenuItemDAO;
import br.com.urcontroler.data.entity.Menu;
import br.com.urcontroler.data.entity.MenuItem;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.data.enums.ViewType;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Bean de controle para tela de cadastro de itens de menu
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class MenuItemBean extends ViewBean<MenuItemView> {

    private final MenuItemDAO dao;

    /**
     * Cria nova instancia de MenuItemBean
     *
     * @param view {@code MenuItemView} View dos itens de menu
     */
    public MenuItemBean(MenuItemView view) {
        super(view);
        dao = new MenuItemDAO();
        getView().getParentModel().setData(getParentMenus());
        getView().getIconModel().setData(getItemIcons());
        getView().getTypeModel().setData(ViewType.values());
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
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
        Long menu = ((Menu) ow.getValue("menu")).getId();
        ViewType type = (ViewType) ow.getValue("type");
        MenuItem item = new MenuItem(getNextID(), menu, itemClass, title,
                getIcons()[icon], new Description.Builder().apply(), type);
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
        for (Menu menu : new MenuDAO().getList()) {
            parents.add(menu);
        }
        return parents;
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return {@code Long} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (MenuItem menu : getView().getModel().getData()) {
            if (id < menu.getId()) {
                id = menu.getId();
            }
        }
        return (id + 1);
    }
}
