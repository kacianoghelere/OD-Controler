package br.com.urcontroler.main.view.weapontype;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.WeaponTypeDAO;
import br.com.urcontroler.data.enums.AttackType;
import br.com.urcontroler.data.enums.DamageType;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.data.enums.UseType;
import br.com.urcontroler.data.enums.Size;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.weapontype.WeaponTypeView;

/**
 * Bean de controle para WeaponTypeView
 *
 * @author kaciano
 */
public class WeaponTypeBean extends ViewBean<WeaponTypeView> {

    private final WeaponTypeDAO dao;
    private TableUtil tableUtil;

    /**
     * Cria nova instancia de WeaponTypeBean
     *
     * @param view {@code WeaponTypeView} View do Bean
     */
    public WeaponTypeBean(WeaponTypeView view) {
        super(view);
        this.dao = new WeaponTypeDAO();
        this.tableUtil = new TableUtil(view);
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        Long nextID = getNextID();
        ObjectWrapper ow = evt.getWrapper();
        WeaponType type = new WeaponType();
        type.setId(nextID);
        type.setName((String) ow.getValue("name"));
        type.setUseType((UseType) ow.getValue("use"));
        type.setSize((Size) ow.getValue("size"));
        type.setRange((Integer) ow.getValue("range"));
        type.setDamageType((DamageType) ow.getValue("damage"));
        type.setAttackType((AttackType) ow.getValue("attack"));
        getView().getModel().add(type);
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);        
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
