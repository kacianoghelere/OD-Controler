package br.com.urcontroler.main.view.classes;

import br.com.urcontroler.data.db.dao.ClassBaseDao;
import br.com.urcontroler.data.entity.ClassBase;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.classes.sub.ClassSubView;
import br.com.urcontroler.main.view.exception.ViewException;

/**
 * Bean de controle para view de classes
 *
 * @author kaciano
 * @version 1.0
 */
public class ClassBean extends ViewBean<ClassView> {

    private ClassBaseDao dao = new ClassBaseDao();
    private TableUtil tableUtil;

    /**
     * Cria nova instancia de ClassBean
     *
     * @param view {@code ClassView} View de Classes
     */
    public ClassBean(ClassView view) {
        super(view);
        this.tableUtil = new TableUtil(view);
        try {
            onLoad(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void onCommit(BeanEvent evt) throws Exception {
        dao.replaceAll(getView().getModel().getData());
    }

    @Override
    public void onLoad(BeanEvent evt) throws Exception {

    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((ClassBase) evt.getValue());
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            ClassBase base = getView().getModel().getObject(row);
            ClassSubView subview = new ClassSubView(getView(), base);
            getView().getMainScreen().getListener().insertView(subview);
            if (subview.getClassBase() != null) {
                getView().getModel().update(row, subview.getClassBase());
            }
        }
    }

    @Override
    public void update(Object object) throws Exception {
        Integer row = getView().getModel().getObjectRow(object);
        if (object != null) {
            getView().getModel().update(row, (ClassBase) object);
        }
    }

    /**
     * Retorna o dao dos ClassBases
     *
     * @return {@code ClassBaseDAO} DAO de controle
     */
    public ClassBaseDao getDao() {
        return dao;
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (ClassBase base : getView().getModel().getData()) {
            if (base.getId() > id) {
                id = base.getId();
            }
        }
        return (id + 1);
    }
}
