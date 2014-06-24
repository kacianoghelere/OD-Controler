package br.com.rpgruler.main.view.effect.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.rpgruler.data.db.dao.EffectDAO;
import br.com.rpgruler.data.db.dao.EffectTypeDAO;
import br.com.rpgruler.data.entity.Effect;
import br.com.rpgruler.data.entity.EffectType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.bean.ViewBean;
import br.com.rpgruler.main.view.effect.EffectView;

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
     * @param view <code>EffectView</code> Tela de efeitos
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
        Double strength = (Double) vw.getValue("strength");
        EffectType type = (EffectType) vw.getValue("type");
        Long nextID = getNextID();
        Effect effect = new Effect(nextID, title, strength, type);
        getView().getModel().add(effect);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return <code>Integer</code> Próximo ID
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
