package br.com.urcontroler.main.view.item;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.urcontroler.data.db.dao.ItemDAO;
import br.com.urcontroler.data.db.dao.ItemTypeDAO;
import br.com.urcontroler.data.entity.Item;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.item.model.ItemModel;
import br.com.urcontroler.main.view.item.sub.ItemSubView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View de controle para itens gerais
 *
 * @author kaciano
 * @version 1.0
 */
@ViewData(name = "Itens gerais", type = ViewType.CRUD, path = {""})
public class ItemView extends View<ItemBean> implements TableView, TableSource<Item> {

    private ItemBean bean;
    private ItemModel model;
    private TableDecorator decorator;
    private int count = 0;
    private final int NAME = count++;
    private final int TYPE = count++;
    private final int DESCRIPTION = count++;
    private final int WEIGHT = count++;
    private final int PRICE = count++;

    /**
     * Creates new form ItemView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public ItemView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setSize(662, 484);
        this.setControls(new ViewParameter(true, false, true, true));
        this.initComponents();
        this.decorator = new TableDecorator(gTable);
        //----------------------------------------------------------------------
        // Inicialização do modelo
        this.model = new ItemModel();
        //----------------------------------------------------------------------
        // Inicialização do bean
        this.bean = new ItemBean(this);
        //----------------------------------------------------------------------
        // Atribuição do modelo na tabela
        this.gTable.buildTable(this, 0, model);
        //----------------------------------------------------------------------
        // Atribuição dos editores na tabela
        this.decorator.withNumber(PRICE);
        this.decorator.comboAt(TYPE, new ItemTypeDAO().getList());
    }

    @Override
    public void add() throws Exception {
        ItemSubView subview = new ItemSubView(this, null);
        getMainScreen().getListener().insertView(subview);
        if (subview.getItem() != null) {
            try {
                bean.add(new BeanEvent(this, subview.getItem()));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                throwException(new ViewException(this, ex));
            } catch (Exception ex) {
                throwException(new ViewException(this, ex));
            }
        }
    }

    @Override
    public void remove() throws Exception {
        bean.remove(null);
    }

    @Override
    public void edit() {
        try {
            bean.edit(null);
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public ItemModel getModel() {
        return this.model;
    }

    @Override
    public List<Item> getTableData() {
        return new ItemDAO().getList();
    }

    @Override
    public ItemBean getBean() {
        return this.bean;
    }

    /**
     * Dados gerados automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jBEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Itens Gerais");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1255_.png"))); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setMnemonic('A');
        jBAdd.setText("Adicionar");
        jBAdd.setFocusable(false);
        jBAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar1.add(jBAdd);

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setMnemonic('R');
        jBRemove.setText("Remover");
        jBRemove.setFocusable(false);
        jBRemove.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });
        jToolBar1.add(jBRemove);

        jBEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar/edit.png"))); // NOI18N
        jBEdit.setMnemonic('E');
        jBEdit.setText("Editar");
        jBEdit.setFocusable(false);
        jBEdit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditActionPerformed(evt);
            }
        });
        jToolBar1.add(jBEdit);

        gTable.setKeyDelete(true);
        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception ex) {
            Logger.getLogger(ItemView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        edit();
    }//GEN-LAST:event_jBEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBEdit;
    private javax.swing.JButton jBRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
