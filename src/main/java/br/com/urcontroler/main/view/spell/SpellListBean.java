package br.com.urcontroler.main.view.spell;

import br.com.gmp.comps.data.GenericDAO;
import br.com.urcontroler.data.db.dao.DaoBuilder;
import br.com.urcontroler.data.entity.ElementType;
import br.com.urcontroler.data.entity.Spell;
import br.com.urcontroler.data.entity.SpellType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.List;

/**
 * Bean de controle para a lista de magias
 *
 * @author kaciano
 */
public class SpellListBean extends ViewBean<SpellListView> {

    private GenericDAO<Spell> spellDAO;
    private GenericDAO<SpellType> spellTypeDAO;
    private GenericDAO<ElementType> elementTypeDAO;

    /**
     * Cria nova instancia de SpellListBean
     *
     * @param view {@code SpellListView} View da lista de magias
     */
    public SpellListBean(SpellListView view) {
        super(view);
        spellDAO = DaoBuilder.get(Spell.class);
        spellTypeDAO = DaoBuilder.get(SpellType.class);
        elementTypeDAO = DaoBuilder.get(ElementType.class);
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        spellDAO.replaceAll(getView().getModel().getData());
    }

    /**
     * Retorna a lista de registros de magia
     *
     * @return {@code List(Spell)} Lista de registros de magia
     */
    public List<Spell> getSpellList() {
        return spellDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de magia
     *
     * @return {@code List(SpellType)} Lista de registros de tipos de magia
     */
    public List<SpellType> getSpellTypeList() {
        return spellTypeDAO.getList();
    }

    /**
     * Retorna a lista de registros de tipos de elementos
     *
     * @return {@code List(SpellType)} Lista de registros de tipos de elementos
     */
    public List<ElementType> getElementTypeList() {
        return elementTypeDAO.getList();
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
        for (Spell spell : getView().getModel().getData()) {
            if (spell.getId() == null) {
                id = 1L;
            } else if (spell.getId() > id) {
                id = spell.getId();
            }
        }
        return (id + 1);
    }
}
