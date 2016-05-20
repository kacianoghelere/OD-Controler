package br.com.urcontroler.main.view.armor;

import br.com.urcontroler.main.view.armor.model.ArmorModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.urcontroler.data.db.dao.ArmorDAO;
import br.com.urcontroler.data.db.dao.ArmorTypeDAO;
import br.com.urcontroler.data.db.dao.MaterialTypeDAO;
import br.com.urcontroler.data.db.dao.OriginDAO;
import br.com.urcontroler.data.entity.Armor;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.armor.sub.ArmorSubView;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.Arrays;
import java.util.List;

/**
 * View para cadastro e controle de armaduras
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
@ViewData(name = "Armaduras", type = ViewType.CRUD, path = {""})
public class ArmorView extends View<ArmorBean> implements TableView, TableSource<Armor> {

    private ArmorBean bean;
    private ArmorModel model;
    private TableDecorator decorator;
    private int count = 0;
    private final int NAME = count++;
    private final int ORIGIN = count++;
    private final int DESCRIPTION = count++;
    private final int TYPE = count++;
    private final int CA = count++;
    private final int MOVIMENT_RED = count++;
    private final int PRICE = count++;
    private final int MATERIAL = count++;
    private final int ALIGNMENT = count++;

    /**
     * Cria nova instancia de ArmorView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public ArmorView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, false, true));
        this.setSize(662, 484);
        this.initComponents();
        this.decorator = new TableDecorator(gTable);
        //----------------------------------------------------------------------
        // Inicialização do modelo
        this.model = new ArmorModel();
        //----------------------------------------------------------------------
        // Inicialização do bean
        this.bean = new ArmorBean(this);
        //----------------------------------------------------------------------
        // Atribuição do modelo na tabela
        this.gTable.buildTable(this, 0, model);
        //----------------------------------------------------------------------
        // Atribuição dos editores na tabela
        this.decorator.withNumber(CA);
        this.decorator.withNumber(MOVIMENT_RED);
        this.decorator.withNumber(PRICE);
        this.decorator.comboAt(ORIGIN, new OriginDAO().getList());
        this.decorator.comboAt(TYPE, new ArmorTypeDAO().getList());
        this.decorator.comboAt(MATERIAL, new MaterialTypeDAO().getList());
        this.decorator.comboAt(ALIGNMENT, Arrays.asList(Alignment.values()));
    }

    @Override
    public ArmorBean getBean() {
        return bean;
    }

    @Override
    public List<Armor> getTableData() {
        return new ArmorDAO().getList();
    }

    @Override
    public void add() {
        ArmorSubView dialog = new ArmorSubView(this, null);
        getMainScreen().getListener().insertView(dialog);
        if (dialog.getArmor() != null) {
            try {
                bean.add(new BeanEvent(this, dialog.getArmor()));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                throwException(new ViewException(this, ex));
            } catch (Exception ex) {
                throwException(new ViewException(this, ex));
            }
        }
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
    public void remove() throws Exception {
        bean.remove(null);
    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public ArmorModel getModel() {
        return model;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jBEdit = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Armaduras");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/P/P_21.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(735, 491));

        gTable.setAutoResizeMode(4);
        gTable.setAutoscrolls(false);
        gTable.setKeyDelete(true);
        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jScrollPane6.setViewportView(gTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
