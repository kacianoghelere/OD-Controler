package br.com.urcontroler.main.view.classtype;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.ClassTypeDAO;
import br.com.urcontroler.data.entity.ClassType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.bean.ViewBean;

/**
 * Bean de controle para a tela de controle de tipos de classes
 *
 * @author kaciano
 * @version 1.0
 */
public class ClassTypeBean extends ViewBean<ClassTypeView> {

    private final ClassTypeDAO dao;
    private final TableUtil tableUtil;

    /**
     * Cria nova instancia de ClassTypeBean
     *
     * @param view {@code ClassTypeView} View dos tipos de classe
     */
    public ClassTypeBean(ClassTypeView view) {
        super(view);
        this.dao = new ClassTypeDAO();
        this.tableUtil = new TableUtil(view);
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        ObjectWrapper ow = evt.getWrapper();
        Long nextID = getNextID();
        String name = (String) ow.getValue("name");
        Integer jp = (Integer) ow.getValue("jp");
        boolean magic = (boolean) ow.getValue("magic");
        getView().getModel().add(new ClassType(nextID, name, magic, jp));
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (ClassType base : getView().getModel().getData()) {
            if (base.getId() > id) {
                id = base.getId();
            }
        }
        return (id + 1);
    }
}
