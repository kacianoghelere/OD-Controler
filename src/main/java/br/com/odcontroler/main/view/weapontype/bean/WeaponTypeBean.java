package br.com.odcontroler.main.view.weapontype.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.WeaponTypeDAO;
import br.com.odcontroler.data.db.dao.WeaponSizeDAO;
import br.com.odcontroler.data.enums.AttackType;
import br.com.odcontroler.data.enums.DamageType;
import br.com.odcontroler.data.entity.WeaponType;
import br.com.odcontroler.data.enums.UseType;
import br.com.odcontroler.data.enums.Size;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.weapontype.WeaponTypeView;

/**
 * Bean de controle para WeaponTypeView
 *
 * @author kaciano
 */
public class WeaponTypeBean extends ViewBean<WeaponTypeView> {

    private final WeaponTypeDAO dao;

    /**
     * Cria nova instancia de WeaponTypeBean
     *
     * @param view {@code WeaponTypeView} View do Bean
     */
    public WeaponTypeBean(WeaponTypeView view) {
        super(view);
        this.dao = new WeaponTypeDAO();
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getSizeModel().setData(new WeaponSizeDAO().getList());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        Long nextID = getNextID();
        ObjectWrapper ow = evt.getWrapper();
        WeaponType type = new WeaponType();
        type.setId(nextID);
        type.setTitle((String) ow.getValue("name"));
        type.setUseType((UseType) ow.getValue("use"));
        type.setSize((Size) ow.getValue("size"));
        type.setRange((Integer) ow.getValue("range"));
        type.setDamageType((DamageType) ow.getValue("damage"));
        type.setAttackType((AttackType) ow.getValue("attack"));
        getView().getModel().add(type);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Long} Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (WeaponType type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }
}
