package br.com.odcontroler.main.view.weapontype;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.WeaponTypeDAO;
import br.com.odcontroler.data.enums.AttackType;
import br.com.odcontroler.data.enums.DamageType;
import br.com.odcontroler.data.entity.WeaponType;
import br.com.odcontroler.data.enums.UseType;
import br.com.odcontroler.data.enums.Size;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.annotation.ViewData;
import br.com.odcontroler.main.view.enums.ViewType;
import br.com.odcontroler.main.view.exception.ViewException;
import br.com.odcontroler.main.view.interfaces.BeanListener;
import br.com.odcontroler.main.view.interfaces.TableView;
import br.com.odcontroler.main.view.object.ViewParameter;
import br.com.odcontroler.main.view.weapontype.model.WeaponTypeModel;
import java.util.List;

/**
 * View de cadastro para tipos de armas
 *
 * @author kaciano
 * @version 1.0
 */
@ViewData(name = "Tipos de armas", type = ViewType.CRUD)
public class WeaponTypeView extends View<WeaponTypeBean> implements TableView, TableSource<WeaponType> {

    private WeaponTypeBean bean;
    private WeaponTypeModel model;
    private GComboBoxModel<UseType> useModel;
    private GComboBoxModel<Size> sizeModel;
    private GComboBoxModel<DamageType> dmgModel;
    private GComboBoxModel<AttackType> atkModel;
    private TableDecorator decorator;
    private int count = 0;
    private final int NAME = count++;
    private final int RANGE = count++;
    private final int DMG_TYPE = count++;
    private final int SIZE = count++;
    private final int USE_TYPE = count++;
    private final int ATK_TYPE = count++;

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
        this.setSize(647, 401);
        this.setControls(new ViewParameter(true, false, true, false));
        this.initComponents();
        this.decorator = new TableDecorator(gTable);
        //----------------------------------------------------------------------
        // Inicialização do modelo
        this.model = new WeaponTypeModel();
        this.useModel = new GComboBoxModel<>(UseType.values());
        this.sizeModel = new GComboBoxModel<>(Size.values());
        this.dmgModel = new GComboBoxModel<>(DamageType.values());
        this.atkModel = new GComboBoxModel<>(AttackType.values());
        //----------------------------------------------------------------------
        // Inicialização do bean
        this.bean = new WeaponTypeBean(this);
        //----------------------------------------------------------------------
        // Atribuição dos modelos
        this.gTable.buildTable(this, 0, model);
        this.gCBUse.setGModel(useModel);
        this.gCBSize.setGModel(sizeModel);
        this.gCBDmgType.setGModel(dmgModel);
        this.gCBAtkType.setGModel(atkModel);
        //----------------------------------------------------------------------
        // Atribuição dos editores
        this.decorator.withNumber(RANGE);
        this.decorator.comboAt(USE_TYPE, useModel.getData());
        this.decorator.comboAt(SIZE, sizeModel.getData());
        this.decorator.comboAt(DMG_TYPE, dmgModel.getData());
        this.decorator.comboAt(ATK_TYPE, atkModel.getData());
    }

    @Override
    public void add() {
        try {
            if (gTName.validateComponent()
                    && gCBUse.validateComponent()
                    && gCBSize.validateComponent()
                    && validadeRange()) {
                ObjectWrapper vw = new ObjectWrapper(this)
                        .addValue("name", gTName.getText())
                        .addValue("use", useModel.getSelectedItem())
                        .addValue("size", sizeModel.getSelectedItem())
                        .addValue("damage", dmgModel.getSelectedItem())
                        .addValue("range", nTRange.getInteger())
                        .addValue("attack", atkModel.getSelectedItem());
                this.bean.add(new BeanEvent(vw));
            }
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }

    /**
     * Valida se o range foi informado corretamente
     *
     * @return {@code boolean} Range valido?
     */
    private boolean validadeRange() {
        if (atkModel.getSelectedItem().equals(AttackType.RANGED)) {
            return nTRange.validateComponent();
        }
        return true;
    }

    @Override
    public void remove() throws Exception {
        bean.remove(null);
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
    public GComboBoxModel<Size> getSizeModel() {
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
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLWear = new javax.swing.JLabel();
        gCBUse = new br.com.gmp.comps.combobox.GComboBox();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jLSize = new javax.swing.JLabel();
        gCBSize = new br.com.gmp.comps.combobox.GComboBox();
        jLRange = new javax.swing.JLabel();
        nTRange = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jLDmgType = new javax.swing.JLabel();
        gCBDmgType = new br.com.gmp.comps.combobox.GComboBox();
        jLAtkType = new javax.swing.JLabel();
        gCBAtkType = new br.com.gmp.comps.combobox.GComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tipos de armas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/DK/DK_4.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(647, 401));
        setPreferredSize(new java.awt.Dimension(647, 401));

        gTable.setKeyDelete(true);
        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jScrollPane1.setViewportView(gTable);

        jLTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLTitle.setText("Nome:");

        jLWear.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLWear.setText("Porte:");

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        jLSize.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLSize.setText("Tamanho:");

        jLRange.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLRange.setText("Alcance:");

        jLDmgType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDmgType.setText("Tipo de dano:");

        jLAtkType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLAtkType.setText("Ataque:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLAtkType, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(jLWear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBUse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gCBAtkType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDmgType, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLSize, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLRange, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nTRange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove))
                            .addComponent(gCBDmgType, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(gCBSize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLDmgType, jLRange, jLSize});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDmgType)
                    .addComponent(gCBDmgType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLWear)
                    .addComponent(gCBUse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCBSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBAdd)
                        .addComponent(jBRemove))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nTRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLAtkType)
                        .addComponent(gCBAtkType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLRange)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBAtkType, gCBDmgType, gCBSize, gCBUse, gTName, nTRange});

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
    private br.com.gmp.comps.combobox.GComboBox gCBAtkType;
    private br.com.gmp.comps.combobox.GComboBox gCBDmgType;
    private br.com.gmp.comps.combobox.GComboBox gCBSize;
    private br.com.gmp.comps.combobox.GComboBox gCBUse;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLAtkType;
    private javax.swing.JLabel jLDmgType;
    private javax.swing.JLabel jLRange;
    private javax.swing.JLabel jLSize;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLWear;
    private javax.swing.JScrollPane jScrollPane1;
    private br.com.gmp.comps.textfield.numeric.GNumericField nTRange;
    // End of variables declaration//GEN-END:variables
}
