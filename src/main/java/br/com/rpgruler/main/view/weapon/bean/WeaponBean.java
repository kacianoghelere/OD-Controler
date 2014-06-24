package br.com.rpgruler.main.view.weapon.bean;

import br.com.rpgruler.data.db.dao.WeaponDAO;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.weapon.WeaponView;

/**
 * Bean de controle de WeaponView
 *
 * @author kaciano
 */
public class WeaponBean extends ViewBean<WeaponView> {

    private WeaponDAO dao;

    /**
     * Cria nova instancia de WeaponBean
     *
     * @param view <code>WeaponView</code> View do bean
     */
    public WeaponBean(WeaponView view) {
        super(view);
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        super.add(evt); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        super.edit(evt); //To change body of generated methods, choose Tools | Templates.
    }

}
