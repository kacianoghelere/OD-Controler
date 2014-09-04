package br.com.urcontroler.main.view.skill;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.EffectDAO;
import br.com.urcontroler.data.db.dao.SkillDAO;
import br.com.urcontroler.data.db.dao.SkillTypeDAO;
import br.com.urcontroler.data.entity.Effect;
import br.com.urcontroler.data.entity.Skill;
import br.com.urcontroler.data.entity.SkillType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.exception.ViewException;

/**
 * Bean de controle para a tela de habilidades
 *
 * @author kaciano
 * @version 1.0
 */
public class SkillBean extends ViewBean<SkillView> {

    private SkillDAO dao;
    private TableUtil tableUtil;
    private EffectDAO effectDAO;
    private SkillTypeDAO skillTypeDAO;

    /**
     * Cria nova instancia de SkillBean
     *
     * @param view {@code SkillView} Tela de habilidades
     */
    public SkillBean(SkillView view) {
        super(view);
        this.dao = new SkillDAO();
        this.tableUtil = new TableUtil(view);
        this.effectDAO = new EffectDAO();
        this.skillTypeDAO = new SkillTypeDAO();
        try {
            load(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getModel().setData(dao.getList());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        ObjectWrapper ow = evt.getWrapper();
        String name = (String) ow.getValue("name");
        Effect effect = (Effect) ow.getValue("effect");
        SkillType type = (SkillType) ow.getValue("type");
        String description = (String) ow.getValue("description");
        getView().getModel()
                .add(new Skill(getNextID(), name, effect, type, description));
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    /**
     * Retorna o DAO dos efeitos
     *
     * @return {@code EffectDAO} DAO dos efeitos
     */
    public EffectDAO getEffectDAO() {
        return effectDAO;
    }

    /**
     * Retorna o DAO dos tipos de habilidades
     *
     * @return {@code EffectDAO} DAO dos tipos de habilidades
     */
    public SkillTypeDAO getSkillTypeDAO() {
        return skillTypeDAO;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Long} Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (Skill skill : getView().getModel().getData()) {
            if (skill.getId() > id) {
                id = skill.getId();
            }
        }
        return (id + 1);
    }
}
