package br.com.urcontroler.main.view.perk;

import br.com.urcontroler.data.db.dao.PerkDAO;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.perk.PerkView;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.perk.sub.PerkSubView;

/**
 * Bean de controle para a PerkView
 *
 * @author Kaciano Ghelere
 */
public class PerkBean extends ViewBean<PerkView> {

    private PerkDAO dao;

    /**
     * Cria nova instancia de PerkBean
     *
     * @param view {@code PerkView} View do Bean
     */
    public PerkBean(PerkView view) {
        super(view);
        this.dao = new PerkDAO();
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
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
     * @return {@code Long} Próximo ID
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
