package br.com.odcontroler.main.view.terms.bean;

import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.ArmorTypeDAO;
import br.com.odcontroler.data.db.dao.EffectTypeDAO;
import br.com.odcontroler.data.db.dao.ElementDAO;
import br.com.odcontroler.data.db.dao.ExpertiseTypeDAO;
import br.com.odcontroler.data.db.dao.MaterialsDAO;
import br.com.odcontroler.data.db.dao.PerkTypeDAO;
import br.com.odcontroler.data.entity.ArmorType;
import br.com.odcontroler.data.entity.EffectType;
import br.com.odcontroler.data.entity.Element;
import br.com.odcontroler.data.entity.ExpertiseType;
import br.com.odcontroler.data.entity.ItemType;
import br.com.odcontroler.data.entity.Material;
import br.com.odcontroler.data.entity.PerkType;
import br.com.odcontroler.data.entity.Type;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.terms.TermsView;
import java.util.List;

/**
 * Bean para TermsView
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public class TermsBean extends ViewBean<TermsView> {

    private final EffectTypeDAO effectTypeDAO;
    private final PerkTypeDAO perkTypeDao;
    private final ExpertiseTypeDAO expDAO;
    private final ArmorTypeDAO armorDAO;
    private final MaterialsDAO materialsDAO;
    private final ElementDAO elementDAO;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view {@code TermsView} View
     */
    public TermsBean(TermsView view) {
        super(view);
        this.effectTypeDAO = new EffectTypeDAO();
        this.perkTypeDao = new PerkTypeDAO();
        this.expDAO = new ExpertiseTypeDAO();
        this.armorDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialsDAO();
        this.elementDAO = new ElementDAO();
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        effectTypeDAO.replaceAll(getView().getEffectModel().getData());
        perkTypeDao.replaceAll(getView().getPerkModel().getData());
        expDAO.replaceAll(getView().getExpertiseModel().getData());
        armorDAO.replaceAll(getView().getArmorModel().getData());
        materialsDAO.replaceAll(getView().getMaterialModel().getData());
        elementDAO.replaceAll(getView().getElementModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getEffectModel().setData(effectTypeDAO.getList());
        getView().getPerkModel().setData(perkTypeDao.getList());
        getView().getExpertiseModel().setData(expDAO.getList());
        getView().getArmorModel().setData(armorDAO.getList());
        getView().getMaterialModel().setData(materialsDAO.getList());
        getView().getElementModel().setData(elementDAO.getList());
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt {@code BeanEvent} Evento do Bean
     */
    public void addEffectTp(BeanEvent evt) {
        Long nextId = getNextID(getView().getEffectModel().getData());
        EffectType type = new EffectType(nextId, (String) evt.getValue());
        getView().getEffectModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     */
    public void addPerkTp(BeanEvent evt) {
        Long nextId = getNextID(getView().getPerkModel().getData());
        PerkType type = new PerkType(nextId, (String) evt.getValue());
        getView().getPerkModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de ExpertiseTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     */
    public void addExpTp(BeanEvent evt) {
        Long nextId = getNextID(getView().getExpertiseModel().getData());
        ExpertiseType type = new ExpertiseType(nextId, (String) evt.getValue());
        getView().getExpertiseModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de ArmorTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @since 1.1
     */
    public void addArmorType(BeanEvent evt) {
        Long nextId = getNextID(getView().getArmorModel().getData());
        ArmorType type = new ArmorType(nextId, (String) evt.getValue());
        getView().getArmorModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de Materials
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @since 1.1
     */
    public void addMaterial(BeanEvent evt) {
        Long nextId = getNextID(getView().getMaterialModel().getData());
        Material material = new Material(nextId, (String) evt.getValue());
        getView().getMaterialModel().add(material);
    }

    /**
     * Adiciona novo elemento na lista de Elements
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @since 1.1
     */
    public void addElement(BeanEvent evt) {
        Long nextId = getNextID(getView().getElementModel().getData());
        Element element = new Element(nextId, (String) evt.getValue());
        getView().getElementModel().add(element);
    }

    /**
     * Adiciona novo elemento na lista de ItemTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @since 1.1
     */
    public void addItem(BeanEvent evt) {
        Long nextId = getNextID(getView().getItemModel().getData());
        ItemType type = new ItemType(nextId, (String) evt.getValue());
        getView().getItemModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Propagação da Exceção
     * @since 1.1
     */
    @Override
    public void add(BeanEvent evt) throws Exception {
        ObjectWrapper wrapper = evt.getWrapper();
        GListModel model = (GListModel) wrapper.getValue("model");
        Long nextId = getNextID(model.getData());
        ItemType type = new ItemType(nextId, (String) wrapper.getValue("name"));
        model.add(type);
    }

    /**
     * Retorna o próximo ID do tipo da lista de tipos informada
     *
     * @param list {@code List} Lista de tipos
     * @return {@code Long} Próximo ID
     * @since 1.1
     */
    public Long getNextID(List list) {
        Long id = 0L;
        for (Object obj : list) {
            Type type = (Type) obj;
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
