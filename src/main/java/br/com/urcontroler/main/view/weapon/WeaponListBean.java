package br.com.urcontroler.main.view.weapon;

import br.com.gmp.comps.data.GenericDAO;
import br.com.urcontroler.data.db.dao.DaoBuilder;
import br.com.urcontroler.data.entity.MaterialType;
import br.com.urcontroler.data.entity.Origin;
import br.com.urcontroler.data.entity.Weapon;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.List;

/**
 * Bean de controle para WeaponList
 *
 * @author Kaciano Ghelere
 */
public class WeaponListBean extends ViewBean<WeaponListView> {

    private GenericDAO<Weapon> weaponDAO;
    private GenericDAO<WeaponType> weaponTypeDAO;
    private GenericDAO<Origin> originDAO;
    private GenericDAO<MaterialType> materialTypeDAO;

    /**
     * Cria nova instancia de WeaponListBean
     *
     * @param view {@code WeaponListView} View da lista de armas
     */
    public WeaponListBean(WeaponListView view) {
        super(view);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.weaponDAO = DaoBuilder.get(Weapon.class);
        this.weaponTypeDAO = DaoBuilder.get(WeaponType.class);
        this.originDAO = DaoBuilder.get(Origin.class);
        this.materialTypeDAO = DaoBuilder.get(MaterialType.class);
        this.weaponDAO = DaoBuilder.get(Weapon.class);
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        weaponDAO.replaceAll(getView().getModel().getData());
    }

    /**
     * Retorna a lista de registros para armas
     *
     * @return {@code List(Weapon)} Lista de registro para armas
     */
    public List<Weapon> getWeaponList() {
        return weaponDAO.getList();
    }

    /**
     * Retorna a lista de registros para tipos de armas
     *
     * @return {@code List(Weapon)} Lista de registro para tipos de armas
     */
    public List<WeaponType> getWeaponTypeList() {
        return weaponTypeDAO.getList();
    }

    /**
     * Retorna a lista de registros para origens
     *
     * @return {@code List(Origin)} Lista de registro para origens
     */
    public List<Origin> getOriginList() {
        return originDAO.getList();
    }

    /**
     * Retorna a lista de registros para materiais
     *
     * @return {@code List(MaterialType)} Lista de registro para materiais
     */
    public List<MaterialType> getMaterialTypeList() {
        return materialTypeDAO.getList();
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        if (getView().getModel().getData() != null || getView().getModel().getData().isEmpty()) {
            return (id + 1);
        }
        for (Weapon weapon : getView().getModel().getData()) {
            if (weapon.getId() == null) {
                id = 1L;
            } else if (weapon.getId() > id) {
                id = weapon.getId();
            }
        }
        return (id + 1);
    }
}
