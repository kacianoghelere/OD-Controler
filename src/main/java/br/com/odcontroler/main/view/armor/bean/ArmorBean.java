package br.com.odcontroler.main.view.armor.bean;

import br.com.odcontroler.data.db.dao.ArmorDAO;
import br.com.odcontroler.data.db.dao.ArmorTypeDAO;
import br.com.odcontroler.data.db.dao.MaterialTypeDAO;
import br.com.odcontroler.data.db.dao.OriginDAO;
import br.com.odcontroler.data.entity.Armor;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.armor.ArmorView;
import br.com.odcontroler.main.view.armor.sub.ArmorSubView;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.exception.ViewException;

/**
 * Bean de controle para tela de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class ArmorBean extends ViewBean<ArmorView> {

    private final ArmorTypeDAO armorTypeDAO;
    private final MaterialTypeDAO materialsDAO;
    private final OriginDAO originDAO;
    private final ArmorDAO armorDAO;
    private TableUtil tableUtil;

    /**
     * Cria nova instancia de ArmorBean
     *
     * @param view {@code ArmorView} Tela de armaduras
     */
    public ArmorBean(ArmorView view) {
        super(view);
        this.armorTypeDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialTypeDAO();
        this.armorDAO = new ArmorDAO();
        this.originDAO = new OriginDAO();
        this.tableUtil = new TableUtil(view);
        try {
            load(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        armorDAO.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {

    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((Armor) evt.getValue());
    }

    @Override
    public void update(Object object) throws Exception {
        Integer row = getView().getModel().getObjectRow(object);
        if (object != null) {
            getView().getModel().update(row, (Armor) object);
        }
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            Armor armor = getView().getModel().getObject(row);
            ArmorSubView subview = new ArmorSubView(getView(), armor);
            getView().getMainScreen().getListener().insertView(subview);
            if (subview.getArmor() != null) {
                getView().getModel().update(row, subview.getArmor());
            }
        }
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        this.tableUtil.remove(evt);
    }

    /**
     * Retorna o DAO de controle dos tipos de armadura
     *
     * @return {@code ArmorTypeDAO} DAO de ArmorType
     */
    public ArmorTypeDAO getArmorTypeDAO() {
        return armorTypeDAO;
    }

    /**
     * Retorna o DAO de controle das matérias primas
     *
     * @return {@code MaterialTypeDAO} DAO de PrimeMaterial
     */
    public MaterialTypeDAO getMaterialsDAO() {
        return materialsDAO;
    }

    /**
     * Retorna o DAO de controle dos tipos de origem
     *
     * @return {@code OriginDAO} DAO de Origin
     */
    public OriginDAO getOriginDAO() {
        return originDAO;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Armor type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }
}
