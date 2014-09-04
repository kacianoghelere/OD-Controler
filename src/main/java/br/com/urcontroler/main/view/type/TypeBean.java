package br.com.urcontroler.main.view.type;

import br.com.urcontroler.data.db.dao.*;
import br.com.urcontroler.data.entity.Type;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.exception.ViewException;
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
    private final MaterialTypeDAO materialsDAO;
    private final ElementTypeDAO elementDAO;
    private final ItemTypeDAO itemDAO;
    private final SpellTypeDAO spellDAO;
    private final LanguageTypeDAO languageDAO;
    private final SkillTypeDAO skillDAO;

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
        this.materialsDAO = new MaterialTypeDAO();
        this.elementDAO = new ElementTypeDAO();
        this.itemDAO = new ItemTypeDAO();
        this.spellDAO = new SpellTypeDAO();
        this.languageDAO = new LanguageTypeDAO();
        this.skillDAO = new SkillTypeDAO();
        try {
            load(null);
        } catch (Exception ex) {
            getView().throwException(new ViewException(view, ex));
        }
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
        this.spellDAO.replaceAll(getView().getSpellModel().getData());
        this.languageDAO.replaceAll(getView().getLangModel().getData());
        this.skillDAO.replaceAll(getView().getSkillModel().getData());
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
        getView().getSpellModel().setData(spellDAO.getList());
        getView().getLangModel().setData(languageDAO.getList());
        getView().getSkillModel().setData(skillDAO.getList());
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
