package br.com.odcontroler.main.view.item.bean;

import br.com.odcontroler.data.db.dao.ItemDAO;
import br.com.odcontroler.main.view.item.ItemView;
import br.com.odcontroler.data.db.dao.ItemTypeDAO;
import br.com.odcontroler.data.entity.Item;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.item.sub.ItemSubView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bean de controle para tela de itens
 *
 * @author kaciano
 * @version 1.0
 */
public class ItemBean extends ViewBean<ItemView> {

    private TableUtil tableUtil;
    private final ItemTypeDAO typeDAO;
    private ItemDAO dao;

    /**
     * Cria nova instância de ItemBean
     *
     * @param view {@code ItemView}
     */
    public ItemBean(ItemView view) {
        super(view);
        this.typeDAO = new ItemTypeDAO();
        this.dao = new ItemDAO();
        this.tableUtil = new TableUtil(view);
        try {
            load(null);
        } catch (Exception ex) {
            Logger.getLogger(ItemBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getModel().setData(dao.getList());
        getView().getTypeModel().setData(typeDAO.getList());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((Item) evt.getValue());
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            ItemSubView subview;
            Item weapon = getView().getModel().getObject(row);
            subview = new ItemSubView(getView(), weapon);
            getView().getMainScreen().getListener().insertView(subview);
            if (subview.getItem() != null) {
                getView().getModel().update(row, subview.getItem());
            }
        }
    }

    @Override
    public void update(Object object) throws Exception {
        Integer row = getView().getModel().getObjectRow(object);
        if (object != null) {
            getView().getModel().update(row, (Item) object);
        }
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Item item : getView().getModel().getData()) {
            if (item.getId() > id) {
                id = item.getId();
            }
        }
        return (id + 1);
    }
}
