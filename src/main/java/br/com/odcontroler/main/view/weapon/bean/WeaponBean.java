package br.com.odcontroler.main.view.weapon.bean;

import br.com.odcontroler.data.db.dao.WeaponDAO;
import br.com.odcontroler.data.entity.Weapon;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.weapon.WeaponView;
import br.com.odcontroler.main.view.weapon.sub.WeaponSubView;

/**
 * Bean de controle de WeaponView
 *
 * @author kaciano
 */
public class WeaponBean extends ViewBean<WeaponView> {

    private final WeaponDAO dao;
    private final TableUtil tableUtil;

    /**
     * Cria nova instancia de WeaponBean
     *
     * @param view {@code WeaponView} View do bean
     */
    public WeaponBean(WeaponView view) {
        super(view);
        this.dao = new WeaponDAO();
        this.tableUtil = new TableUtil(view);
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        this.dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((Weapon) evt.getValue());
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            WeaponSubView dialog;
            dialog = new WeaponSubView(getView(), getView().getModel().getObject(row));
            getView().getMainScreen().getListener().insertView(dialog);
            if (dialog.getWeapon() != null) {
                getView().getModel().update(row, dialog.getWeapon());
            }
        }
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    /**
     * Retorna o DAO das armas
     *
     * @return {@code Weapon} DAO das armas
     */
    public WeaponDAO getDao() {
        return this.dao;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Weapon type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }
}
