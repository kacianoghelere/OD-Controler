package br.com.urcontroler.main.view.description;

import br.com.urcontroler.data.db.dao.MenuItemDAO;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.exception.ViewException;

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
        try {
            load(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getListModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getListModel().setData(dao.getList());
    }

}
