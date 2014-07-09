package br.com.odcontroler.main.view.materials.bean;

import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.MaterialsDAO;
import br.com.odcontroler.data.entity.PrimeMaterial;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.materials.MaterialsView;
import br.com.odcontroler.main.view.bean.ViewBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bean para controle da tela de materiais
 *
 * @author kaciano
 * @version 1.0
 */
public class MaterialsBean extends ViewBean<MaterialsView> {

    private MaterialsDAO dao;

    /**
     * Cria nova instancia de MaterialsBean
     *
     * @param view {@code MaterialsView} View do Bean
     */
    public MaterialsBean(MaterialsView view) {
        super(view);
        dao = new MaterialsDAO();
    }

    @Override
    public void commit(BeanEvent evt) {
        List<PrimeMaterial> data = getView().getModel().getData();
        dao.deleteAll();
        dao.insertAll(data);
    }

    /**
     * Adiciona novo material na lista da tabela
     *
     * @param evt {@code BeanEvent} Evento do bean
     */
    @Override
    public void add(BeanEvent evt) {
        try {
            ObjectWrapper vw = evt.getWrapper();
            PrimeMaterial pm = new PrimeMaterial();
            pm.setId(getNextID());
            pm.setName((String) vw.getValue("name"));
            pm.setMaterialClass((Integer) vw.getValue("category"));
            pm.setWeight((Double) vw.getValue("weight"));
            pm.setResistence(pm.getWeight() * pm.getMaterialClass());
            getView().getModel().add(pm);
        } catch (Exception ex) {
            Logger.getLogger(MaterialsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Procura pelo próximo ID
     *
     * @return {@code Integer} Próximo ID
     */
    private Long getNextID() {
        Long id = (long) 0;
        for (PrimeMaterial mat : getView().getModel().getData()) {
            if (mat.getId() > id) {
                id = mat.getId();
            }
        }
        return (id + 1);
    }
}
