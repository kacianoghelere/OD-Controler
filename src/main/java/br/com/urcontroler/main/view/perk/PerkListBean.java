package br.com.urcontroler.main.view.perk;

import br.com.gmp.comps.data.DAO;
import br.com.urcontroler.data.db.dao.DaoBuilder;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.data.entity.PerkType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.List;

/**
 * Bean de controle para a lista de perks
 *
 * @author Kaciano Ghelere
 */
public class PerkListBean extends ViewBean<PerkListView> {

    private DAO<Perk> perkDAO;
    private DAO<PerkType> perkTypeDAO;

    /**
     * Cria nova instancia de PerkListBean
     *
     * @param view {@code PerkListView} Tela de perks
     */
    public PerkListBean(PerkListView view) {
        super(view);
        initialize();
    }

    /**
     * Método de inicializacao
     */
    private void initialize() {
        this.perkDAO = DaoBuilder.get(Perk.class);
        this.perkTypeDAO = DaoBuilder.get(PerkType.class);
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        perkDAO.replaceAll(getView().getModel().getData());
    }

    /**
     * Retorna a lista de perks registrados
     *
     * @return {@code List(Perk)} Lista de perks registrados
     */
    public List<Perk> getPerkList() {
        return perkDAO.getList();
    }

    /**
     * Retorna a lista de tipos de perks registrados
     *
     * @return {@code List(PerkType)} Lista de tipos de perks registrados
     */
    public List<PerkType> getPerkTypeList() {
        return perkTypeDAO.getList();
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
        for (Perk perk : getView().getModel().getData()) {
            if (perk.getId() == null) {
                id = 1L;
            } else if (perk.getId() > id) {
                id = perk.getId();
            }
        }
        return (id + 1);
    }
}
