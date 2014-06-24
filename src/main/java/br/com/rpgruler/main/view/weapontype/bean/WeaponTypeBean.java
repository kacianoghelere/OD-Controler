package br.com.rpgruler.main.view.weapontype.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.rpgruler.data.db.dao.WeaponTypeDAO;
import br.com.rpgruler.data.db.dao.UseTypeDAO;
import br.com.rpgruler.data.db.dao.WeaponSizeDAO;
import br.com.rpgruler.data.entity.WeaponType;
import br.com.rpgruler.data.entity.UseType;
import br.com.rpgruler.data.entity.WeaponSize;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.weapontype.WeaponTypeView;

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
     * @param view <code>WeaponTypeView</code> View do Bean
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
        getView().getUseModel().setData(new UseTypeDAO().getList());
        getView().getSizeModel().setData(new WeaponSizeDAO().getList());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        Long nextID = getNextID();
        ObjectWrapper ow = evt.getWrapper();
        WeaponType type = new WeaponType();
        type.setId(nextID);
        type.setTitle((String) ow.getValue("title"));
        type.setCategory((Integer) ow.getValue("category"));
        type.setDamageBase((Double) ow.getValue("basedmg"));
        type.setUseType((UseType) ow.getValue("use"));
        type.setMaterialAmount1((Double) ow.getValue("qtd1"));
        type.setMaterialAmount2((Double) ow.getValue("qtd2"));
        type.setSize((WeaponSize) ow.getValue("size"));
        type.setRange((Integer) ow.getValue("range"));
        getView().getModel().add(type);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
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
