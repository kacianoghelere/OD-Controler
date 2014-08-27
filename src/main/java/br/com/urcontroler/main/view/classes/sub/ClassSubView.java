package br.com.urcontroler.main.view.classes.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.entity.ClassBase;
import br.com.urcontroler.data.enums.ClassType;
import br.com.urcontroler.data.enums.Attribute;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.sub.SubView;
import br.com.urcontroler.main.view.classes.ClassView;
import br.com.urcontroler.main.view.classes.ClassBean;
import java.util.logging.Level;

/**
 * Subview para edição de classes.
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public class ClassSubView extends SubView {

    private ClassBase classBase;
    private ClassBean bean;
    private final ClassView view;
    private GComboBoxModel<ClassType> clTypeModel;
    private GComboBoxModel<Alignment> alignmentModel;
    private GComboBoxModel<Attribute> attrModel;

    /**
     * Cria nova instancia de ClassSubView
     *
     * @param view {@code ClassView} Tela das Armaduras
     * @param cl {@code ClassBase} Armadura
     * @since 1.0
     */
    public ClassSubView(ClassView view, ClassBase cl) {
        super(view);
        this.view = view;
        initialize(cl);
    }

    /**
     * Método de inicialização
     *
     * @param cl {@code ClassBase} Armadura
     * @since 1.0
     */
    private void initialize(ClassBase cl) {
        this.setSize(624, 476);
        this.initComponents();
        this.bean = view.getBean();
        this.clTypeModel = new GComboBoxModel<>();
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.attrModel = new GComboBoxModel<>(Attribute.values());
        //----------------------------------------------------------------------
        this.setClass(cl);
        this.setVisible(true);
    }


    /**
     * Retorna a classe que está sendo editada
     *
     * @return {@code ClassBase} Armadura
     * @since 1.0
     */
    public ClassBase getClassBase() {
        return classBase;
    }

    /**
     * Modifica a classe que está sendo editada
     *
     * @param cl {@code ClassBase} Armadura
     * @since 1.0
     */
    public void setClass(ClassBase cl) {
        try {
            if (cl != null) {
                this.classBase = cl;
//                this.gTName.setText(cl.getName());

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Constroi os dados na classe
     *
     * @since 1.0
     */
    private void build() {
        if (this.classBase == null) {
            this.classBase = new ClassBase();
        }
        if (this.classBase.getId() == null) {
            this.classBase.setId(bean.getNextID());
        }
//        this.classBase.setName(gTName.getText());
        this.classBase.setDescription(gTADesc.getText());
        this.classBase.setType(clTypeModel.getSelectedItem());
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return {@code boolean} Os campos estão todos preenchidos corretamente?
     * @since 1.0
     */
    private boolean validateFields() {
//        if (!gTName.validateComponent()) {
//            System.out.println("Nome invalido");
//            return false;
//        }
//        if (!gCBType.validateComponent()) {
//            System.out.println("Tipo invalido");
//            return false;
//        }
//        if (!gCBMaterial.validateComponent()) {
//            System.out.println("Material invalido");
//            return false;
//        }
//        if (!(jSpinCA.getValue() != null && ((Integer) jSpinCA.getValue()) != 0)) {
//            showBallon(jSpinCA, "CA invalido");
//            return false;
//        }
        return true;
    }

    /**
     * Retorna o Modelo dos Tipos de classes
     *
     * @return {@code GComboBoxModel(ClassType)} Tipos de classes
     * @since 1.0
     */
    public GComboBoxModel<ClassType> getClassTypeModel() {
        return clTypeModel;
    }

    /**
     * Retorna o Modelo dos alinhamentos
     *
     * @return {@code GComboBoxModel(Alignment)} Modelo dos alinhamentos
     * @since 1.1
     */
    public GComboBoxModel<Alignment> getAlignmentModel() {
        return alignmentModel;
    }

    /**
     * Retorna o ClassView
     *
     * @return {@code ClassView}
     * @since 1.0
     */
    public ClassView getView() {
        return view;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAdd = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jTPConfigs = new javax.swing.JTabbedPane();
        jPBasics = new javax.swing.JPanel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLName = new javax.swing.JLabel();
        jLDice = new javax.swing.JLabel();
        gCBDice = new br.com.gmp.comps.combobox.GComboBox();
        jLBonusCA = new javax.swing.JLabel();
        gNBonusCA = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLKeyAttr = new javax.swing.JLabel();
        gCBKeyAttr = new br.com.gmp.comps.combobox.GComboBox();
        gCBAligment = new br.com.gmp.comps.combobox.GComboBox();
        jLAligment = new javax.swing.JLabel();
        rPane = new br.com.urcontroler.main.comps.RequirementPane();
        jTBModifiers = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTblLevels = new br.com.gmp.comps.table.GTable();
        gDLArmors = new br.com.gmp.comps.list.dual.GMPDualList();
        gDLWeapons = new br.com.gmp.comps.list.dual.GMPDualList();
        gDLItems = new br.com.gmp.comps.list.dual.GMPDualList();
        gDLMagics = new br.com.gmp.comps.list.dual.GMPDualList();
        jSPDesc = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar classe");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/status/avenge.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(535, 464));
        setMinimumSize(new java.awt.Dimension(535, 464));
        setPreferredSize(new java.awt.Dimension(535, 464));

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Salvar");
        jBAdd.setFocusable(false);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.setFocusable(false);
        jBCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLDice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDice.setText("Dado de vida:");

        jLBonusCA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLBonusCA.setText("Bônus CA:");

        jLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLType.setText("Tipo:");

        jLKeyAttr.setText("Atributo Chave:");

        jLAligment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLAligment.setText("Alinhamento:");

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLDice)
                            .addComponent(jLName, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gCBDice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLBonusCA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLAligment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBAligment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addComponent(gNBonusCA, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLKeyAttr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBKeyAttr, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLBonusCA, jLDice, jLName, jLType});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLBonusCA)
                    .addComponent(gNBonusCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLKeyAttr)
                    .addComponent(gCBKeyAttr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAligment)
                    .addComponent(gCBAligment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBDice, gTName});

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBAligment, gCBKeyAttr, gCBType, gNBonusCA});

        jTPConfigs.addTab("Configurações basicas", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1253_.png")), jPBasics); // NOI18N

        jScrollPane1.setViewportView(gTblLevels);

        jTBModifiers.addTab("Niveis", new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1393_@.png")), jScrollPane1); // NOI18N

        gDLArmors.setDestinationLabelText("Pode utilizar");
        gDLArmors.setSourceLabelText("Não pode utilizar");
        jTBModifiers.addTab("Armaduras", new javax.swing.ImageIcon(getClass().getResource("/Mixed/P_21.png")), gDLArmors); // NOI18N

        gDLWeapons.setDestinationLabelText("Pode utilizar");
        gDLWeapons.setSourceLabelText("Não pode utilizar");
        jTBModifiers.addTab("Armas", new javax.swing.ImageIcon(getClass().getResource("/Mixed/DK_4.png")), gDLWeapons); // NOI18N

        gDLItems.setDestinationLabelText("Pode utilizar");
        gDLItems.setSourceLabelText("Não pode utilizar");
        jTBModifiers.addTab("Itens", new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1255_.png")), gDLItems); // NOI18N

        gDLMagics.setDestinationLabelText("Pode utilizar");
        gDLMagics.setSourceLabelText("Não pode utilizar");
        jTBModifiers.addTab("Magias", new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1385_@.png")), gDLMagics); // NOI18N

        jTPConfigs.addTab("Modificadores", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1247_.png")), jTBModifiers); // NOI18N

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jSPDesc.setViewportView(gTADesc);

        jTPConfigs.addTab("Descrição", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png")), jSPDesc); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTPConfigs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPConfigs, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd)
                    .addComponent(jBCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        if (validateFields()) {
            try {
                if (classBase == null) {
                    System.out.println("Criando nova classe...");
                    build();
                    view.getBean().add(new BeanEvent(view, classBase));
                } else {
                    System.out.println("Atualizando classe...");
                    build();
                    view.getBean().update(classBase);
                }
                this.dispose();
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
                this.dispose();
            }
        } else {
            System.out.println("Campos invalidos.");
        }
    }//GEN-LAST:event_jBAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBAligment;
    private br.com.gmp.comps.combobox.GComboBox gCBDice;
    private br.com.gmp.comps.combobox.GComboBox gCBKeyAttr;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.dual.GMPDualList gDLArmors;
    private br.com.gmp.comps.list.dual.GMPDualList gDLItems;
    private br.com.gmp.comps.list.dual.GMPDualList gDLMagics;
    private br.com.gmp.comps.list.dual.GMPDualList gDLWeapons;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNBonusCA;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTblLevels;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
    private javax.swing.JLabel jLAligment;
    private javax.swing.JLabel jLBonusCA;
    private javax.swing.JLabel jLDice;
    private javax.swing.JLabel jLKeyAttr;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLType;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTBModifiers;
    private javax.swing.JTabbedPane jTPConfigs;
    private br.com.urcontroler.main.comps.RequirementPane rPane;
    // End of variables declaration//GEN-END:variables
}
