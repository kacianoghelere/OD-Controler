package br.com.rpgruler.main.view.perk.bean;

import br.com.rpgruler.data.db.dao.PerkDAO;
import br.com.rpgruler.data.entity.Perk;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.perk.PerkView;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.perk.sub.PerkSubView;

/**
 * Bean de controle para a PerkView
 *
 * @author kaciano
 */
public class PerkBean extends ViewBean<PerkView> {

    private PerkDAO dao;

    /**
     * Cria nova instancia de PerkBean
     *
     * @param view <code>PerkView</code> View do Bean
     */
    public PerkBean(PerkView view) {
        super(view);
        this.dao = new PerkDAO();
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        this.dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) {
        Perk perk = (Perk) evt.getValue();
        getView().getModel().add(perk);
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            PerkSubView subview = new PerkSubView(getView(), getView().getModel().getObject(row));
            getView().getMainScreen().getListener().insertView(subview);
            if (subview.getPerk() != null) {
                getView().getModel().update(row, subview.getPerk());
            }
        }
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return <code>Long</code> Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Perk perk : getView().getModel().getData()) {
            if (id < perk.getId()) {
                id = perk.getId();
            }
        }
        return (id + 1);
    }
}
