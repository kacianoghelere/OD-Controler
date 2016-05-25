package br.com.urcontroler.main.view.expertise;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.ExpertiseDAO;
import br.com.urcontroler.data.db.dao.ExpertiseTypeDAO;
import br.com.urcontroler.data.entity.Expertise;
import br.com.urcontroler.data.entity.ExpertiseType;
import br.com.urcontroler.data.enums.Attribute;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.expertise.ExpertiseView;
import java.util.logging.Level;

/**
 * Bean de controle para tela de perícias
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class ExpertiseBean extends ViewBean<ExpertiseView> {

    private final ExpertiseDAO dao;
    private final ExpertiseTypeDAO typeDAO;

    /**
     * Cria nova instancia de ExpertiseBean
     *
     * @param view {@code ExpertiseView} View do Bean
     */
    public ExpertiseBean(ExpertiseView view) {
        super(view);
        this.dao = new ExpertiseDAO();
        this.typeDAO = new ExpertiseTypeDAO();
        try {
            onLoad(null);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void onLoad(BeanEvent evt) throws Exception {
        getView().getAttrModel().setData(Attribute.values());
        getView().getTypeModel().setData(typeDAO.getList());
        getView().updateComponents();
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        ObjectWrapper vw = evt.getWrapper();
        Long id = getNextID();
        String title = (String) vw.getValue("title");
        Attribute attr = (Attribute) vw.getValue("attr");
        ExpertiseType type = (ExpertiseType) vw.getValue("type");
        Integer value = (Integer) vw.getValue("value");
        getView().getModel().add(new Expertise(id, title, type, attr, value));
    }

    /**
     * Retorna o próximo ID da lista
     *
     * @return {@code Long} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Expertise exp : getView().getModel().getData()) {
            if (id < exp.getId()) {
                id = exp.getId();
            }
        }
        return (id + 1);
    }
}
