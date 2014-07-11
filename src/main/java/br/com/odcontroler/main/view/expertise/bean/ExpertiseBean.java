package br.com.odcontroler.main.view.expertise.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.ExpertiseDAO;
import br.com.odcontroler.data.db.dao.ExpertiseTypeDAO;
import br.com.odcontroler.data.entity.Expertise;
import br.com.odcontroler.data.entity.ExpertiseType;
import br.com.odcontroler.data.entity.attr.Attribute;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.expertise.ExpertiseView;
import javax.swing.SwingUtilities;

/**
 * Bean de controle para tela de perícias
 *
 * @author kaciano
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
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        getView().getAttrModel().setData(Attribute.values());
        getView().getTypeModel().setData(typeDAO.getList());
        SwingUtilities.updateComponentTreeUI(getView());
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
