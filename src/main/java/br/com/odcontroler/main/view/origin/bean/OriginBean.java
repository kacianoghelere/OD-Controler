package br.com.odcontroler.main.view.origin.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.OriginDAO;
import br.com.odcontroler.data.entity.Origin;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.origin.OriginView;

/**
 * Bean de controle para tela de origem de itens
 *
 * @author kaciano
 */
public class OriginBean extends ViewBean<OriginView> {

    private final OriginDAO dao;

    /**
     * Cria nova instancia de OriginBean
     *
     * @param view {@code OriginView} View das origens
     */
    public OriginBean(OriginView view) {
        super(view);
        this.dao = new OriginDAO();
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        Long nextID = getNextID();
        ObjectWrapper ow = evt.getWrapper();
        String name = (String) ow.getValue("name");
        Integer bonus = (Integer) ow.getValue("bonus");
        getView().getModel().add(new Origin(nextID, name, bonus));
    }

    /**
     * Retorna o DAO de controle das origens
     *
     * @return {@code OriginDAO} DAO de controle das origens
     */
    public OriginDAO getDao() {
        return dao;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (Origin origin : getView().getModel().getData()) {
            if (origin.getId() > id) {
                id = origin.getId();
            }
        }
        return (id + 1);
    }
}
