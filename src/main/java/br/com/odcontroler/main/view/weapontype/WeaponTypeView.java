package br.com.odcontroler.main.view.weapontype;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.WeaponTypeDAO;
import br.com.odcontroler.data.entity.WeaponType;
import br.com.odcontroler.data.entity.UseType;
import br.com.odcontroler.data.entity.WeaponSize;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.interfaces.BeanListener;
import br.com.odcontroler.main.view.interfaces.TableView;
import br.com.odcontroler.main.view.object.ViewParameter;
import br.com.odcontroler.main.view.weapontype.bean.WeaponTypeBean;
import br.com.odcontroler.main.view.weapontype.model.WeaponTypeModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View de cadastro para tipos de armas
 *
 * @author kaciano
 */
public class WeaponTypeView extends View implements TableView, TableSource<WeaponType> {

    private WeaponTypeBean bean;
    private WeaponTypeModel model;
    private GComboBoxModel<UseType> useModel;
    private GComboBoxModel<WeaponSize> sizeModel;
    private TableUtil tableUtil;

    /**
     * Cria nova instancia de WeaponTypeView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public WeaponTypeView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setSize(647, 401);
        this.setControls(new ViewParameter(true, false, false, false));
        this.initComponents();
        this.model = new WeaponTypeModel();
        this.useModel = new GComboBoxModel<>();
        this.sizeModel = new GComboBoxModel<>();
        this.gTable.buildTable(this, 0, model);
        this.tableUtil = new TableUtil(this);
        this.bean = new WeaponTypeBean(this);
        this.gCBUse.setGModel(useModel);
        this.gCBSize.setGModel(sizeModel);
        try {
            this.bean.load(null);
        } catch (Exception ex) {
            Logger.getLogger(WeaponTypeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add() {
        try {
            if (gTTitle.validateComponent()
                    && gCBUse.validateComponent()
                    && gCBSize.validateComponent()) {
                ObjectWrapper vw = new ObjectWrapper(this)
                        .addValue("title", gTTitle.getText())
                        .addValue("use", useModel.getSelectedItem())
                        .addValue("size", sizeModel.getSelectedItem())
                        .addValue("range", (Integer) jSpRange.getValue());
                this.bean.add(new BeanEvent(vw));
            }
        } catch (Exception ex) {
            Logger.getLogger(WeaponTypeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove() {
        tableUtil.remove(null);
    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public WeaponTypeModel getModel() {
        return this.model;
    }

    @Override
    public List<WeaponType> getTableData() {
        return new WeaponTypeDAO().getList();
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     * Retorna o modelo dos UseTypes
     *
     * @return {@code UseType} Modelo dos UseTypes
     */
    public GComboBoxModel<UseType> getUseModel() {
        return useModel;
    }

    /**
     * Retorna o modelo dos WeaponSizes
     *
     * @return {@code WeaponSize} Modelo dos WeaponSizes
     */
    public GComboBoxModel<WeaponSize> getSizeModel() {
        return sizeModel;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jLTitle = new javax.swing.JLabel();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLWear = new javax.swing.JLabel();
        gCBUse = new br.com.gmp.comps.combobox.GComboBox();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jLSize = new javax.swing.JLabel();
        gCBSize = new br.com.gmp.comps.combobox.GComboBox();
        jLRange = new javax.swing.JLabel();
        jSpRange = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Tipos de armas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/DK/DK_4.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(647, 401));
        setPreferredSize(new java.awt.Dimension(647, 401));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jScrollPane1.setViewportView(gTable);

        jLTitle.setText("Titulo:");

        jLWear.setText("Porte:");

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Adicionar");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setText("Remover");
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        jLSize.setText("Tamanho:");

        jLRange.setText("Alcance:");

        jSpRange.setModel(new javax.swing.SpinnerNumberModel(1, 1, 150, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLTitle)
                            .addComponent(jLWear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gCBUse, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLSize)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBSize, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLRange)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpRange, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLRange, jLTitle, jLWear});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLWear)
                    .addComponent(gCBUse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCBSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSize)
                    .addComponent(jSpRange, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLRange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdd)
                    .addComponent(jBRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception e) {
            Logger.getLogger(WeaponTypeView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception e) {
            Logger.getLogger(WeaponTypeView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBSize;
    private br.com.gmp.comps.combobox.GComboBox gCBUse;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLRange;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLWear;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpRange;
    // End of variables declaration//GEN-END:variables
}
