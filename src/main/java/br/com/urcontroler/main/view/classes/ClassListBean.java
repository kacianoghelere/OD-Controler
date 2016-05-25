package br.com.urcontroler.main.view.classes;

import br.com.gmp.comps.data.GenericDAO;
import br.com.urcontroler.data.db.dao.DaoBuilder;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.ClassBase;
import br.com.urcontroler.data.entity.ClassType;
import br.com.urcontroler.data.entity.Expertise;
import br.com.urcontroler.data.entity.ItemType;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.List;

/**
 * Bean de controle para lista de classes
 *
 * @author Kaciano Ghelere
 */
public class ClassListBean extends ViewBean<ClassListView> {

    private GenericDAO<ClassBase> classBaseDAO;
    private GenericDAO<ClassType> classTypeDAO;
    private GenericDAO<Expertise> expertiseDAO;
    private GenericDAO<ArmorType> armorTypeDAO;
    private GenericDAO<ItemType> itemTypeDAO;
    private GenericDAO<WeaponType> weaponTypeDAO;
    private GenericDAO<Perk> perkDAO;

    /**
     * Cria nova instancia de ClassListBean
     *
     * @param view {@code ClassListView} Lista de classes
     */
    public ClassListBean(ClassListView view) {
        super(view);
        initialize();
    }

    /**
     * Método de inicializacao
     */
    private void initialize() {
        this.classBaseDAO = DaoBuilder.get(ClassBase.class);
        this.classTypeDAO = DaoBuilder.get(ClassType.class);
        this.armorTypeDAO = DaoBuilder.get(ArmorType.class);
        this.itemTypeDAO = DaoBuilder.get(ItemType.class);
        this.weaponTypeDAO = DaoBuilder.get(WeaponType.class);
        this.perkDAO = DaoBuilder.get(Perk.class);
        this.expertiseDAO = DaoBuilder.get(Expertise.class);
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {

    }

    /**
     * Retorna a lista de registros de classes
     *
     * @return {@code List(ClassBase)} Lista de registros de classes
     */
    public List<ClassBase> getClassBaseList() {
        return classBaseDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de classes
     *
     * @return {@code List(ClassType)} Lista de registros de tipos de classes
     */
    public List<ClassType> getClassTypeList() {
        return classTypeDAO.getList();
    }

    /**
     * Retorna a lista de registros de pericias
     *
     * @return {@code List(Expertise)} Lista de registros de pericias
     */
    public List<Expertise> getExpertiseList() {
        return expertiseDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de armaduras
     *
     * @return {@code List(ArmorType)} Lista de registros de tipos de armaduras
     */
    public List<ArmorType> getArmorTypeList() {
        return armorTypeDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de itens
     *
     * @return {@code List(ItemType)} Lista de registros de tipos de itens
     */
    public List<ItemType> getItemTypeList() {
        return itemTypeDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de armas
     *
     * @return {@code List(WeaponType)} Lista de registros de tipos de armas
     */
    public List<WeaponType> getWeaponTypeList() {
        return weaponTypeDAO.getList();
    }

    /**
     * Retorna a lista de registros de vantagens
     *
     * @return {@code List(Perk)} Lista de registros de vantagens
     */
    public List<Perk> getPerkList() {
        return perkDAO.getList();
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
        for (ClassBase cb : getView().getModel().getData()) {
            if (cb.getId() == null) {
                id = 1L;
            } else if (cb.getId() > id) {
                id = cb.getId();
            }
        }
        return (id + 1);
    }
}
