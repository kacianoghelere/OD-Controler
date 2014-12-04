package br.com.urcontroler.main.view.item;

import br.com.urcontroler.data.db.dao.ItemDAO;
import br.com.urcontroler.data.db.dao.ItemTypeDAO;
import br.com.urcontroler.data.entity.Item;
import br.com.urcontroler.data.entity.ItemType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.List;

/**
 * Bean de controle para a lista de itens
 *
 * @author kaciano
 */
public class ItemListBean extends ViewBean<ItemListView> {

    private ItemDAO itemDAO;
    private ItemTypeDAO itemTypeDAO;

    /**
     *
     * @param view {@code ItemListView} View da lista de itens
     */
    public ItemListBean(ItemListView view) {
        super(view);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.itemDAO = new ItemDAO();
        this.itemTypeDAO = new ItemTypeDAO();
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        itemDAO.replaceAll(getView().getModel().getData());
    }

    /**
     * Retorna a lista de itens
     *
     * @return {@code List(Item)}
     */
    public List<Item> getItemList() {
        return itemDAO.getList();
    }

    /**
     * Retorna a lista de tipos de itens
     *
     * @return {@code List(ItemType)}
     */
    public List<ItemType> getItemTypeList() {
        return itemTypeDAO.getList();
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        if (getView().getModel().getData().isEmpty()) {
            return (id + 1);
        }
        for (Item item : getView().getModel().getData()) {
            if (item.getId() == null) {
                id = 1L;
            } else if (item.getId() > id) {
                id = item.getId();
            }
        }
        return (id + 1);
    }
}
