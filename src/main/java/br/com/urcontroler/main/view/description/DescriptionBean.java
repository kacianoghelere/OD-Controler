package br.com.urcontroler.main.view.description;

import br.com.urcontroler.data.db.dao.MenuItemDAO;
import br.com.urcontroler.data.entity.MenuItem;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.description.model.DescriptionObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean de controle para a tela de descrições
 *
 * @author kaciano
 * @version 1.0
 */
public class DescriptionBean extends ViewBean<DescriptionView> {

    private MenuItemDAO dao;

    /**
     * Cria nova instancia de DescriptionBean
     *
     * @param view {@code DescriptionView} Tela de descrições
     */
    public DescriptionBean(DescriptionView view) {
        super(view);
        this.dao = new MenuItemDAO();
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        List<MenuItem> items = new ArrayList<>();
        for (DescriptionObject desc : getView().getModel().getData()) {
            MenuItem item = desc.getItem();
            item.setDescription(desc.build());
            items.add(item);
        }
        dao.replaceAll(items);
    }

}
