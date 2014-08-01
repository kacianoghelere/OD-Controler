package br.com.odcontroler.main.view.type.bean;

import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.ArmorTypeDAO;
import br.com.odcontroler.data.db.dao.EffectTypeDAO;
import br.com.odcontroler.data.db.dao.ElementDAO;
import br.com.odcontroler.data.db.dao.ExpertiseTypeDAO;
import br.com.odcontroler.data.db.dao.ItemTypeDAO;
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
import br.com.odcontroler.main.view.type.TypeView;
import java.util.List;

/**
 * Bean para TypeView
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public class TypeBean extends ViewBean<TypeView> {

    private final EffectTypeDAO effectTypeDAO;
    private final PerkTypeDAO perkTypeDao;
    private final ExpertiseTypeDAO expertiseDAO;
    private final ArmorTypeDAO armorDAO;
    private final MaterialsDAO materialsDAO;
    private final ElementDAO elementDAO;
    private final ItemTypeDAO itemDAO;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view {@code TypeView} View
     */
    public TypeBean(TypeView view) {
        super(view);
        this.effectTypeDAO = new EffectTypeDAO();
        this.perkTypeDao = new PerkTypeDAO();
        this.expertiseDAO = new ExpertiseTypeDAO();
        this.armorDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialsDAO();
        this.elementDAO = new ElementDAO();
        this.itemDAO = new ItemTypeDAO();
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        this.effectTypeDAO.replaceAll(getView().getEffectModel().getData());
        this.perkTypeDao.replaceAll(getView().getPerkModel().getData());
        this.expertiseDAO.replaceAll(getView().getExpertiseModel().getData());
        this.armorDAO.replaceAll(getView().getArmorModel().getData());
        this.materialsDAO.replaceAll(getView().getMaterialModel().getData());
        this.elementDAO.replaceAll(getView().getElementModel().getData());
        this.itemDAO.replaceAll(getView().getItemModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getEffectModel().setData(effectTypeDAO.getList());
        getView().getPerkModel().setData(perkTypeDao.getList());
        getView().getExpertiseModel().setData(expertiseDAO.getList());
        getView().getArmorModel().setData(armorDAO.getList());
        getView().getMaterialModel().setData(materialsDAO.getList());
        getView().getElementModel().setData(elementDAO.getList());
        getView().getItemModel().setData(itemDAO.getList());
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
