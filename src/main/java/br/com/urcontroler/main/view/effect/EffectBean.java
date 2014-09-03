package br.com.urcontroler.main.view.effect;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.EffectDAO;
import br.com.urcontroler.data.db.dao.EffectTypeDAO;
import br.com.urcontroler.data.entity.Effect;
import br.com.urcontroler.data.entity.EffectType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;

/**
 * Bean de controle para EffectView
 *
 * @author kaciano
 * @version 1.0
 */
public class EffectBean extends ViewBean<EffectView> {

    private EffectDAO dao;

    /**
     * Cria nova instancia de ViewBean
     *
     * @param view {@code EffectView} Tela de efeitos
     */
    public EffectBean(EffectView view) {
        super(view);
        this.dao = new EffectDAO();
        getView().getTypeModel().setData(new EffectTypeDAO().getList());
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        ObjectWrapper vw = evt.getWrapper();
        String title = (String) vw.getValue("title");
        String description = (String) vw.getValue("description");
        EffectType type = (EffectType) vw.getValue("type");
        Long nextID = getNextID();
        Effect effect = new Effect(nextID, title, description, type);
        getView().getModel().add(effect);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (Effect effect : getView().getModel().getData()) {
            if (effect.getId() > id) {
                id = effect.getId();
            }
        }
        return (id + 1);
    }
}
