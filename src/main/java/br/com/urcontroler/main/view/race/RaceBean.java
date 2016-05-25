package br.com.urcontroler.main.view.race;

import br.com.urcontroler.data.db.dao.RaceDAO;
import br.com.urcontroler.data.entity.Race;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.race.sub.RaceSubView;

/**
 * Bean de controle para a tela das raças
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class RaceBean extends ViewBean<RaceView> {

    private RaceDAO dao;
    private final TableUtil tableUtil;

    /**
     * Cria nova instancia de RaceBean
     *
     * @param view {@code RaceView} Tela das raças
     */
    public RaceBean(RaceView view) {
        super(view);
        this.dao = new RaceDAO();
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
        getView().getModel().setData(dao.getList());
    }

    @Override
    public void add(BeanEvent evt) throws Exception {
        getView().getModel().add((Race) evt.getValue());
    }

    @Override
    public void remove(BeanEvent evt) throws Exception {
        tableUtil.remove(evt);
    }

    @Override
    public void edit(BeanEvent evt) throws Exception {
        if (getView().getTable().getSelectedRowCount() > 0) {
            Integer row = (Integer) getView().getTable().getSelectedRows()[0];
            RaceSubView subview;
            Race race = getView().getModel().getObject(row);
            subview = new RaceSubView(getView(), race);
            getView().getMainScreen().getListener().insertView(subview);
            if (subview.getRace() != null) {
                getView().getModel().update(row, subview.getRace());
            }
        }
    }

    @Override
    public void update(Object object) throws Exception {
        Integer row = getView().getModel().getObjectRow(object);
        if (object != null) {
            getView().getModel().update(row, (Race) object);
        }
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Long} Próximo ID
     */
    public Long getNextID() {
        Long id = (long) 0;
        for (Race race : getView().getModel().getData()) {
            if (race.getId() > id) {
                id = race.getId();
            }
        }
        return (id + 1);
    }
}
