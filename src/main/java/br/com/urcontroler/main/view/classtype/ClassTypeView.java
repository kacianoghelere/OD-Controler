package br.com.urcontroler.main.view.classtype;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.ClassTypeDAO;
import br.com.urcontroler.data.entity.ClassType;
import br.com.urcontroler.data.enums.SpellCategory;
import br.com.urcontroler.data.enums.SpellClass;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.classtype.model.ClassTypeModel;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tela de cadastro e controle de tipos de classes
 *
 * @author kaciano
 * @version 1.0
 */
@ViewData(name = "Tipos de classes", type = ViewType.CRUD, path = {""})
public class ClassTypeView extends View implements TableView, TableSource<ClassType> {

    private ClassTypeBean bean;
    private ClassTypeModel model;

    /**
     * Cria nova instancia de ClassTypeView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public ClassTypeView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, false, false));
        this.setSize(532, 412);
        this.model = new ClassTypeModel();
        this.bean = new ClassTypeBean(this);
        this.initComponents();
        int i = 0;
        for (SpellClass spell : SpellClass.values()) {
            this.spellCategory.setValueAt(spell, i, 0);
            this.spellCategory.setValueAt(1, i++, 1);
        }
        this.gTable.buildTable(this, 0, model);
    }

    @Override
    public void add() throws Exception {
        Map<SpellClass, Integer> access = new HashMap<>();
        for (int i = 0; i < spellCategory.getRowCount(); i++) {
            access.put((SpellClass) spellCategory.getValueAt(i, 0),
                    (Integer) spellCategory.getValueAt(i, 1));
        }
        ObjectWrapper ow = new ObjectWrapper(this)
                .addValue("name", gTName.getText())
                .addValue("jp", gNJPBase.getInteger())
                .addValue("magic", gCHMagic.isSelected());
        if (gCHMagic.isSelected()) {
            ow.addValue("access", access);
        }
        this.bean.add(new BeanEvent(ow));
    }

    @Override
    public void remove() throws Exception {
        this.bean.remove(null);
    }

    @Override
    public void edit() {
        if (model.getData().size() > 0) {
            ClassType type = model.getObject(gTable.getSelectedRow());
            if (type != null) {
                gTName.setText(type.getName());
                gNJPBase.setInt(type.getProtection());
                gCHMagic.setSelected(type.isMagic());
                int i = 0;
                Map<SpellClass, Integer> classAccess = type.getClassAccess();
                for (Map.Entry<SpellClass, Integer> e : classAccess.entrySet()) {
                    this.spellCategory.setValueAt(e.getKey(), i, 0);
                    this.spellCategory.setValueAt(e.getValue(), i++, 1);
                }
            }
        }
    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public ClassTypeModel getModel() {
        return model;
    }

    @Override
    public ClassTypeBean getBean() {
        return bean;
    }

    @Override
    public List<ClassType> getTableData() {
        return new ClassTypeDAO().getList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jPanel1 = new javax.swing.JPanel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLName = new javax.swing.JLabel();
        jBRemove = new javax.swing.JButton();
        gCHMagic = new javax.swing.JCheckBox();
        jBAdd = new javax.swing.JButton();
        gNJPBase = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jLJPBase = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        spellCategory = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tipo de classes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Mixed/avenge.png"))); // NOI18N

        jScrollPane1.setViewportView(gTable);

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        gCHMagic.setText("Utiliza magias?");
        gCHMagic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        gCHMagic.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jLJPBase.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLJPBase.setText("JP Base:");

        spellCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Categoria", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(spellCategory);
        if (spellCategory.getColumnModel().getColumnCount() > 0) {
            spellCategory.getColumnModel().getColumn(0).setResizable(false);
            spellCategory.getColumnModel().getColumn(1).setResizable(false);
            spellCategory.getColumnModel().getColumn(1).setPreferredWidth(15);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLJPBase, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(gNJPBase, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCHMagic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove))
                            .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLJPBase, jLName});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLName)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd)
                    .addComponent(jBRemove)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLJPBase)
                        .addComponent(gNJPBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gCHMagic)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCHMagic, gNJPBase, gTName, jBAdd, jBRemove});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox gCHMagic;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNJPBase;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLJPBase;
    private javax.swing.JLabel jLName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable spellCategory;
    // End of variables declaration//GEN-END:variables
}
