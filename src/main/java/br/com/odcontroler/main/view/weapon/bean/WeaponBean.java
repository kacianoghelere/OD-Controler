package br.com.odcontroler.main.view.weapon.bean;

import br.com.odcontroler.data.db.dao.WeaponDAO;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.weapon.WeaponView;

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
     * @param view {@code WeaponView} View do bean
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
