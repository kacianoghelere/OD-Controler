package br.com.odcontroler.main.view.armortype.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.ArmorTypeDAO;
import br.com.odcontroler.data.entity.ArmorType;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.armortype.ArmorTypeView;
import br.com.odcontroler.main.view.bean.ViewBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kaciano
 */
public class ArmorTypeBean extends ViewBean<ArmorTypeView> {

    private ArmorTypeDAO dao;

    /**
     * Cria nova instancia de ArmorTypeBean
     *
     * @param view {@code ArmorTypeView} View do Bean
     */
    public ArmorTypeBean(ArmorTypeView view) {
        super(view);
        dao = new ArmorTypeDAO();
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        List<ArmorType> data = getView().getModel().getData();
        dao.deleteAll();
        dao.insertAll(data);
    }

    /**
     * Adiciona novo ArmorType na tabela
     *
     * @param evt {@code BeanEvent} Evento do bean
     */
    @Override
    public void add(BeanEvent evt) {
        try {
            ObjectWrapper vw = evt.getWrapper();
            ArmorType type = new ArmorType();
            Long nextID = getNextID();
            type.setId(nextID);
            type.setTitle((String) vw.getValue("title"));
            type.setMaterialAmount1((Double) vw.getValue("qtd1"));
            type.setMaterialAmount2((Double) vw.getValue("qtd2"));
            type.setBase((Integer) vw.getValue("resbase"));
            getView().getModel().add(type);
        } catch (Exception ex) {
            Logger.getLogger(ArmorTypeBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Remove um ArmorType na tabela
     *
     * @param evt {@code BeanEvent} Evento do bean
     */
    public void remove(BeanEvent evt) {
        getView().getModel().remove((ArmorType[]) evt.getValue());
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (ArmorType type : getView().getModel().getData()) {
            if (type.getId() > id) {
                id = type.getId();
            }
        }
        return (id + 1);
    }

}
