package br.com.odcontroler.main.view.terms.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.*;
import br.com.odcontroler.data.entity.*;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.terms.TermsView;
import java.util.ArrayList;
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

    private final EffectTypeDAO effectDAO;
    private final PerkTypeDAO perkDao;
    private final ExpertiseTypeDAO expDAO;
    private final ArmorTypeDAO armorDAO;
    private final MaterialsDAO materialsDAO;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view {@code TermsView} View
     */
    public TermsBean(TermsView view) {
        super(view);
        this.effectDAO = new EffectTypeDAO();
        this.perkDao = new PerkTypeDAO();
        this.expDAO = new ExpertiseTypeDAO();
        this.armorDAO = new ArmorTypeDAO();
        this.materialsDAO = new MaterialsDAO();
        System.out.println("Merda");
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        this.effectDAO.replaceAll(view.getEffectModel().getData());
        this.perkDao.replaceAll(view.getPerkModel().getData());
        this.expDAO.replaceAll(view.getExpModel().getData());
        this.armorDAO.replaceAll(view.getArmorModel().getData());
        this.materialsDAO.replaceAll(view.getMaterialModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        view.getEffectModel().setData(effectDAO.getList());
        view.getPerkModel().setData(perkDao.getList());
        view.getExpModel().setData(expDAO.getList());
        view.getArmorModel().setData(armorDAO.getList());
        view.getMaterialModel().setData(materialsDAO.getList());
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Exceção lançada
     * @since 1.1
     */
    public void addEffectTp(BeanEvent evt) throws Exception {
        Long id = getNextEffectID();
        ObjectWrapper ow = evt.getWrapper();
        EffectType type = new EffectType(id, (String) ow.getValue("name"));
        view.getEffectModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Exceção lançada
     * @since 1.1
     */
    public void addPerkTp(BeanEvent evt) throws Exception {
        Long id = getNext(objectToEntity(perkDao.getList()));
        ObjectWrapper ow = evt.getWrapper();
        PerkType type = new PerkType(id, (String) ow.getValue("name"));
        view.getPerkModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de ExpertiseTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Exceção lançada
     * @since 1.1
     */
    public void addExpTp(BeanEvent evt) throws Exception {
        Long id = getNextExpertiseID();
        ObjectWrapper ow = evt.getWrapper();
        ExpertiseType type = new ExpertiseType(id, (String) ow.getValue("name"));
        view.getExpModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de ArmorTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Exceção lançada
     * @since 1.1
     */
    public void addArmorType(BeanEvent evt) throws Exception {
        Long id = getNextArmorTpID();
        ObjectWrapper ow = evt.getWrapper();
        ArmorType type = new ArmorType(id, (String) ow.getValue("name"));
        view.getArmorModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de ArmorTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @throws java.lang.Exception Exceção lançada
     * @since 1.1
     */
    public void addMaterial(BeanEvent evt) throws Exception {
        Long id = getNextMaterialID();
        ObjectWrapper ow = evt.getWrapper();
        PrimeMaterial mat = new PrimeMaterial(id, (String) ow.getValue("name"));
        view.getMaterialModel().add(mat);
    }

    /**
     * Retorna o próximo ID dos EffectType
     *
     * @return {@code Long} Próximo ID para EffectType
     */
    public Long getNextEffectID() {
        Long id = (long) 0;
        for (EffectType type : view.getEffectModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos PerkTypes
     *
     * @return {@code Long} Próximo ID para PerkType
     */
    public Long getNextPerkID() {
        Long id = (long) 0;
        for (PerkType type : view.getPerkModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos ExpertiseTypes
     *
     * @return {@code Long} Próximo ID para ExpertiseType
     */
    public Long getNextExpertiseID() {
        Long id = (long) 0;
        for (ExpertiseType type : view.getExpModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos ArmorTypes
     *
     * @return {@code Long} Próximo ID para ArmorType
     * @since 1.1
     */
    public Long getNextArmorTpID() {
        Long id = (long) 0;
        for (ArmorType type : view.getArmorModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos PrimeMaterials
     *
     * @return {@code Long} Próximo ID para PrimeMaterial
     * @since 1.1
     */
    public Long getNextMaterialID() {
        Long id = (long) 0;
        for (PrimeMaterial material : view.getMaterialModel().getData()) {
            if (material.getId() > id) {
                id = material.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos PrimeMaterials
     *
     * @param list {@code List(Entity)} Lista de entidades
     * @return {@code Long} Próximo ID da entidade
     * @since 1.1
     */
    public Long getNext(List<Entity> list) {
        Long id = (long) 0;
        for (Entity material : list) {
            if (material.getId() > id) {
                id = material.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Converte a lista de objetos em uma lista de entidades
     *
     * @param objects {@code List} Lista de entidades
     * @return {@code List(Entity)} Lista de entidades
     */
    public List<Entity> objectToEntity(List objects) {
        List<Entity> entities = new ArrayList<>();
        for (Object object : objects) {
            entities.add((Entity) object);
        }
        return entities;
    }

}
