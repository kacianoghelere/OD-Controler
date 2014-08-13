package br.com.odcontroler.main.view.type;

import br.com.odcontroler.data.db.dao.ArmorTypeDAO;
import br.com.odcontroler.data.db.dao.EffectTypeDAO;
import br.com.odcontroler.data.db.dao.ElementDAO;
import br.com.odcontroler.data.db.dao.ExpertiseTypeDAO;
import br.com.odcontroler.data.db.dao.ItemTypeDAO;
import br.com.odcontroler.data.db.dao.MaterialTypeDAO;
import br.com.odcontroler.data.db.dao.PerkTypeDAO;
import br.com.odcontroler.data.db.dao.SpellTypeDAO;
import br.com.odcontroler.data.entity.Type;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.exception.ViewException;
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
    private final MaterialTypeDAO materialsDAO;
    private final ElementDAO elementDAO;
    private final ItemTypeDAO itemDAO;
    private final SpellTypeDAO spellDAO;

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
        this.elementDAO = new ElementDAO();
        this.itemDAO = new ItemTypeDAO();
        this.spellDAO = new SpellTypeDAO();
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
