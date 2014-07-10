package br.com.odcontroler.main.view.terms.bean;

import br.com.odcontroler.data.db.dao.ArmorTypeDAO;
import br.com.odcontroler.data.db.dao.EffectTypeDAO;
import br.com.odcontroler.data.db.dao.ExpertiseTypeDAO;
import br.com.odcontroler.data.db.dao.PerkTypeDAO;
import br.com.odcontroler.data.db.dao.RestrictionTypeDAO;
import br.com.odcontroler.data.db.dao.UseTypeDAO;
import br.com.odcontroler.data.db.dao.WeaponSizeDAO;
import br.com.odcontroler.data.entity.ArmorType;
import br.com.odcontroler.data.entity.Attribute;
import br.com.odcontroler.data.entity.EffectType;
import br.com.odcontroler.data.entity.ExpertiseType;
import br.com.odcontroler.data.entity.PerkType;
import br.com.odcontroler.data.entity.RestrictionType;
import br.com.odcontroler.data.enums.UseType;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.terms.TermsView;

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
    private final RestrictionTypeDAO restDao;
    private final ExpertiseTypeDAO expDAO;
    private final ArmorTypeDAO armorDAO;

    /**
     * Cria nova instancia de TermsBean
     *
     * @param view {@code TermsView} View
     */
    public TermsBean(TermsView view) {
        super(view);
        this.effectTypeDAO = new EffectTypeDAO();
        this.perkTypeDao = new PerkTypeDAO();
        this.restDao = new RestrictionTypeDAO();
        this.expDAO = new ExpertiseTypeDAO();
        this.armorDAO = new ArmorTypeDAO();
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        effectTypeDAO.replaceAll(getView().getEfModel().getData());
        perkTypeDao.replaceAll(getView().getPerkModel().getData());
        restDao.replaceAll(getView().getRestModel().getData());
        expDAO.replaceAll(getView().getExpModel().getData());
        armorDAO.replaceAll(getView().getArmorModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getEfModel().setData(effectTypeDAO.getList());
        getView().getPerkModel().setData(perkTypeDao.getList());
        getView().getRestModel().setData(restDao.getList());
        getView().getExpModel().setData(expDAO.getList());
        getView().getArmorModel().setData(armorDAO.getList());
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt {@code BeanEvent} Evento do Bean
     */
    public void addEffectTp(BeanEvent evt) {
        Long nextId = getNextEffectID();
        EffectType type = new EffectType(nextId, (String) evt.getValue());
        getView().getEfModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     */
    public void addPerkTp(BeanEvent evt) {
        Long nextId = getNextPerkID();
        PerkType type = new PerkType(nextId, (String) evt.getValue());
        getView().getPerkModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de RestrictionType
     *
     * @param evt {@code BeanEvent} Evento do Bean
     */
    public void addRestTp(BeanEvent evt) {
        Long nextId = getNextRestID();
        Attribute attr = (Attribute) evt.getValue();
        RestrictionType type = new RestrictionType(nextId, attr.getName(), attr);
        boolean contain = false;
        for (RestrictionType tp : getView().getRestModel().getData()) {
            if (tp.getAttribute().equals(attr)) {
                contain = true;
                break;
            }
        }
        if (!contain) {
            getView().getRestModel().add(type);
        }
    }

    /**
     * Adiciona novo elemento na lista de ExpertiseTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     */
    public void addExpTp(BeanEvent evt) {
        Long nextId = getNextRestID();
        ExpertiseType type = new ExpertiseType(nextId, (String) evt.getValue());
        getView().getExpModel().add(type);
    }

    /**
     * Adiciona novo elemento na lista de ArmorTypes
     *
     * @param evt {@code BeanEvent} Evento do Bean
     * @since 1.1
     */
    public void addArmorType(BeanEvent evt) {
        Long nextId = getNextArmorTpID();
        ArmorType type = new ArmorType(nextId, (String) evt.getValue());
        getView().getArmorModel().add(type);
    }

    /**
     * Retorna o próximo ID dos EffectType
     *
     * @return {@code Long} Próximo ID para EffectType
     */
    public Long getNextEffectID() {
        Long id = (long) 0;
        for (EffectType type : getView().getEfModel().getData()) {
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
        for (PerkType type : getView().getPerkModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

    /**
     * Retorna o próximo ID dos RestrictionTypes
     *
     * @return {@code Long} Próximo ID para RestrictionType
     */
    public Long getNextRestID() {
        Long id = (long) 0;
        for (RestrictionType type : getView().getRestModel().getData()) {
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
        for (ExpertiseType type : getView().getExpModel().getData()) {
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
        for (ArmorType type : getView().getArmorModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
