package br.com.urcontroler.main.view.description;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.urcontroler.data.db.dao.MenuItemDAO;
import br.com.urcontroler.data.entity.MenuItem;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.description.model.DescriptionModel;
import br.com.urcontroler.main.view.description.model.DescriptionObject;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Tela para edição de descrições de Views
 *
 * @author kaciano
 * @version 1.0
 */
public class DescriptionView extends View implements TableView, TableSource<DescriptionObject> {

    private DescriptionBean bean;
    private DescriptionModel model;

    /**
     * Cria nova instancia DescriptionView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public DescriptionView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        setControls(new ViewParameter(true, false, false, false));
        setSize(648, 357);
        this.bean = new DescriptionBean(this);
        this.model = new DescriptionModel();
        initComponents();
        this.gTable.buildTable(this, 0, model);
    }

    @Override
    public void add() throws Exception {

    }

    @Override
    public void remove() throws Exception {

    }

    @Override
    public void edit() {

    }

    @Override
    public List<DescriptionObject> getTableData() {
        List<DescriptionObject> desc = new ArrayList<>();
        List<MenuItem> list = new MenuItemDAO().getList();
        for (MenuItem item : list) {
            desc.add(new DescriptionObject(item));
        }
        return desc;
    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public DescriptionModel getModel() {
        return model;
    }

    @Override
    public DescriptionBean getBean() {
        return this.bean;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Descrições de telas");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(648, 357));
        setMinimumSize(new java.awt.Dimension(648, 357));

        jScrollPane2.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
