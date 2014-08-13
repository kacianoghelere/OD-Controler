package br.com.odcontroler.main.view.spell;

import br.com.odcontroler.data.db.dao.SpellDAO;
import br.com.odcontroler.data.entity.Spell;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.exception.ViewException;
import br.com.odcontroler.main.view.spell.SpellView;
import br.com.odcontroler.main.view.spell.sub.SpellSubView;

/**
 * Bean de controle de SpellView
 *
 * @author kaciano
 */
public class SpellBean extends ViewBean<SpellView> {

    private final SpellDAO dao;
    private final TableUtil tableUtil;

    /**
     * Cria nova instancia de SpellBean
     *
     * @param view {@code SpellView} View do bean
     */
    public SpellBean(SpellView view) {
        super(view);
        this.dao = new SpellDAO();
        this.tableUtil = new TableUtil(view);
        try {
            load(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getModel().setData(dao.getList());
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        this.dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((Spell) evt.getValue());
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            SpellSubView subview;
            Spell spell = getView().getModel().getObject(row);
            subview = new SpellSubView(getView(), spell);
            getView().getMainScreen().getListener().insertView(subview);
            if (subview.getSpell() != null) {
                getView().getModel().update(row, subview.getSpell());
            }
        }
    }

    @Override
    public void update(Object object) throws Exception {
        Integer row = getView().getModel().getObjectRow(object);
        if (object != null) {
            getView().getModel().update(row, (Spell) object);
        }
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    /**
     * Retorna o DAO das magias
     *
     * @return {@code SpellDAO} DAO das magias
     */
    public SpellDAO getDao() {
        return this.dao;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Spell spell : getView().getModel().getData()) {
            if (spell.getId() > id) {
                id = spell.getId();
            }
        }
        return (id + 1);
    }
}
