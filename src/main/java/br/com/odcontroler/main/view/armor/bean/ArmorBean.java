package br.com.odcontroler.main.view.armor.bean;

import br.com.odcontroler.data.db.dao.ArmorDAO;
import br.com.odcontroler.data.db.dao.ArmorTypeDAO;
import br.com.odcontroler.data.db.dao.MaterialsDAO;
import br.com.odcontroler.data.db.dao.RestrictionTypeDAO;
import br.com.odcontroler.data.entity.Armor;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.armor.ArmorView;
import br.com.odcontroler.main.view.armor.sub.ArmorSubView;
import br.com.odcontroler.main.view.bean.ViewBean;

/**
 * Bean de controle para tela de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class ArmorBean extends ViewBean<ArmorView> {

    private ArmorTypeDAO armorTypeDAO;
    private MaterialsDAO materialsDAO;
    private ArmorDAO armorDAO;
    private RestrictionTypeDAO restDAO;

    /**
     * Cria nova instancia de ArmorBean
     *
     * @param view {@code ArmorView} Tela de armaduras
     */
    public ArmorBean(ArmorView view) {
        super(view);
        this.armorTypeDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialsDAO();
        this.armorDAO = new ArmorDAO();
        this.restDAO = new RestrictionTypeDAO();
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
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            ArmorSubView dialog = new ArmorSubView(getView(), getView().getModel().getObject(row));
            getView().getMainScreen().getListener().insertView(dialog);
            if (dialog.getArmor() != null) {
                getView().getModel().update(row, dialog.getArmor());
            }
        }
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
     * @return {@code MaterialsDAO} DAO de PrimeMaterial
     */
    public MaterialsDAO getMaterialsDAO() {
        return materialsDAO;
    }

    /**
     * Retorna o DAO de controle dos tipos de restrições
     *
     * @return {@code RestrictionTypeDAO} DAO de RestrictionType
     */
    public RestrictionTypeDAO getRestDAO() {
        return restDAO;
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
