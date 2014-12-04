package br.com.urcontroler.main.view.armor;

import br.com.gmp.comps.data.GenericDAO;
import br.com.urcontroler.data.db.dao.ArmorDAO;
import br.com.urcontroler.data.db.dao.ArmorTypeDAO;
import br.com.urcontroler.data.db.dao.DaoBuilder;
import br.com.urcontroler.data.db.dao.MaterialTypeDAO;
import br.com.urcontroler.data.db.dao.OriginDAO;
import br.com.urcontroler.data.entity.Armor;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.MaterialType;
import br.com.urcontroler.data.entity.Origin;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class ArmorListBean extends ViewBean<ArmorListView> {

    private ArmorDAO armorDAO;
    private ArmorTypeDAO armorTypeDAO;
    private MaterialTypeDAO materialsDAO;
    private OriginDAO originDAO;

    /**
     * Cria nova instancia de ArmorListBean
     *
     * @param view {@code ArmorListView} View de listagem de armaduras
     */
    public ArmorListBean(ArmorListView view) {
        super(view);
        initialize();
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        armorDAO.replaceAll(getView().getModel().getData());
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.armorTypeDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialTypeDAO();
        this.armorDAO = new ArmorDAO();
        this.originDAO = new OriginDAO();
    }

    /**
     * Retorna lista de todas as armaduras registradas
     *
     * @return {@code List(Armor)} Lista de armaduras registradas
     */
    public List<Armor> getArmorList() {
        GenericDAO<Armor> dao = DaoBuilder.get(Armor.class);
        return dao.getList();
    }

    /**
     * Retorna lista de todas os tipos de armaduras registradas
     *
     * @return {@code List(ArmorType)} Lista de tipos de armaduras registradas
     */
    public List<ArmorType> getArmorTypeList() {
        return this.armorTypeDAO.getList();
    }

    /**
     * Retorna lista de todas os materiais registradas
     *
     * @return {@code List(MaterialType)} Lista de materiais registradas
     */
    public List<MaterialType> getMaterialTypeList() {
        return this.materialsDAO.getList();
    }

    /**
     * Retorna lista de todas as origens registradas
     *
     * @return {@code List(Origin)} Lista de origens registradas
     */
    public List<Origin> getOriginList() {
        return this.originDAO.getList();
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        if (getView().getModel().getData().isEmpty()) {
            return (id + 1);
        }
        for (Armor armor : getView().getModel().getData()) {
            if (armor.getId() == null) {
                id = 1L;
            } else if (armor.getId() > id) {
                id = armor.getId();
            }
        }
        return (id + 1);
    }
}
