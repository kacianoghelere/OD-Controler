package br.com.urcontroler.main.view.armor.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.entity.Armor;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.Origin;
import br.com.urcontroler.data.entity.MaterialType;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.sub.SubView;
import br.com.urcontroler.main.view.armor.ArmorView;
import br.com.urcontroler.main.view.armor.ArmorBean;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 * Subview para edição de armaduras.
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public class ArmorSubView extends SubView {

    private Armor armor;
    private ArmorBean bean;
    private final ArmorView view;
    private GComboBoxModel<ArmorType> armorTypeModel;
    private GComboBoxModel<MaterialType> materialModel;
    private GComboBoxModel<Origin> originModel;
    private GComboBoxModel<Alignment> alignmentModel;

    /**
     * Cria nova instancia de ArmorSubView
     *
     * @param view {@code ArmorView} Tela das Armaduras
     * @param armor {@code Armor} Armadura
     * @since 1.0
     */
    public ArmorSubView(ArmorView view, Armor armor) {
        super(view);
        this.view = view;
        initialize(armor);
    }

    /**
     * Método de inicialização
     *
     * @param armor {@code Armor} Armadura
     * @since 1.0
     */
    private void initialize(Armor armor) {
        this.setSize(430, 300);
        this.initComponents();
        this.bean = view.getBean();
        this.armorTypeModel = new GComboBoxModel<>(bean.getArmorTypeDAO().getList());
        this.gCBType.setGModel(armorTypeModel);
        this.materialModel = new GComboBoxModel<>(bean.getMaterialsDAO().getList());
        this.gCBMaterial.setGModel(materialModel);
        this.originModel = new GComboBoxModel<>(bean.getOriginDAO().getList());
        this.gCBOrigin.setGModel(originModel);
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.gCBAlignment.setGModel(alignmentModel);
        //----------------------------------------------------------------------
        JMenuItem gen;
        gen = new JMenuItem("Gerar nome", new ImageIcon(getClass()
                .getResource("/ComponentIcons/controlers/settings.png")));
        gen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                autoName();
            }
        });
        this.gTName.getComponentPopupMenu().add(gen);
        //----------------------------------------------------------------------
        this.setArmor(armor);
        this.setVisible(true);
    }

    /**
     * Cria o nome da armadura automaticamente
     *
     * @since 1.0
     */
    private void autoName() {
        if (gCBType.validateComponent() && gCBMaterial.validateComponent() && gCBOrigin.validateComponent()) {
            ArmorType prefix = this.armorTypeModel.getSelectedItem();
            MaterialType mat1 = this.materialModel.getSelectedItem();
            Origin origin = this.originModel.getSelectedItem();
            this.gTName.setText(prefix.getName() + " " + origin.getName()
                    + " de " + mat1.getName());
        }
    }

    /**
     * Retorna a armadura que está sendo editada
     *
     * @return {@code Armor} Armadura
     * @since 1.0
     */
    public Armor getArmor() {
        return armor;
    }

    /**
     * Modifica a armadura que está sendo editada
     *
     * @param armor {@code Armor} Armadura
     * @since 1.0
     */
    public void setArmor(Armor armor) {
        try {
            if (armor != null) {
                this.armor = armor;
                this.gTName.setText(armor.getName());
                this.gTADesc.setText(armor.getDescription());
                this.gCBType.setSelectedItem(armor.getType());
                this.gCBMaterial.setSelectedItem(armor.getMaterial());
                this.gCBAlignment.setSelectedItem(armor.getAlignment());
                this.gCBOrigin.setSelectedItem(armor.getOrigin());
                this.jSpinPrice.setValue(armor.getPrice());
                this.jSpinCA.setValue(armor.getArmorClass());
                this.jSpinMov.setValue(armor.getMovReduction());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Constroi os dados na armadura
     *
     * @since 1.0
     */
    private void build() {
        if (this.armor == null) {
            this.armor = new Armor();
        }
        if (this.armor.getId() == null) {
            this.armor.setId(bean.getNextID());
        }
        this.armor.setName(gTName.getText());
        this.armor.setDescription(gTADesc.getText());
        this.armor.setPrice((Double) jSpinPrice.getValue());
        this.armor.setType(armorTypeModel.getSelectedItem());
        this.armor.setMaterial(materialModel.getSelectedItem());
        this.armor.setArmorClass((Integer) jSpinCA.getValue());
        this.armor.setAlignment(alignmentModel.getSelectedItem());
        this.armor.setOrigin(originModel.getSelectedItem());
        this.armor.setMovReduction((Integer) jSpinMov.getValue());
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return {@code boolean} Os campos estão todos preenchidos corretamente?
     * @since 1.0
     */
    private boolean validateFields() {
        if (!gTName.validateComponent()) {
            System.out.println("Nome invalido");
            return false;
        }
        if (!gCBType.validateComponent()) {
            System.out.println("Tipo invalido");
            return false;
        }
        if (!gCBMaterial.validateComponent()) {
            System.out.println("Material invalido");
            return false;
        }
        if (!(jSpinCA.getValue() != null && ((Integer) jSpinCA.getValue()) != 0)) {
            showBallon(jSpinCA, "CA invalido");
            return false;
        }
        return true;
    }

    /**
     * Retorna o Modelo dos Tipos de armaduras
     *
     * @return {@code GComboBoxModel(ArmorType)} Tipos de armaduras
     * @since 1.0
     */
    public GComboBoxModel<ArmorType> getArmorTypeModel() {
        return armorTypeModel;
    }

    /**
     * Retorna o Modelo dos Materiais
     *
     * @return {@code GComboBoxModel(PrimeMaterial)} Materiais
     */
    public GComboBoxModel<MaterialType> getMaterialModel() {
        return materialModel;
    }

    /**
     * Retorna o Modelo das origens
     *
     * @return {@code GComboBoxModel(Origin)} Origens
     * @since 1.1
     */
    public GComboBoxModel<Origin> getOriginModel() {
        return originModel;
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
     * Retorna o ArmorView
     *
     * @return {@code ArmorView}
     * @since 1.0
     */
    public ArmorView getView() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPBasics = new javax.swing.JPanel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLMat1 = new javax.swing.JLabel();
        gCBMaterial = new br.com.gmp.comps.combobox.GComboBox();
        gCBOrigin = new br.com.gmp.comps.combobox.GComboBox();
        jLMat2 = new javax.swing.JLabel();
        JLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLName = new javax.swing.JLabel();
        jLAlign = new javax.swing.JLabel();
        gCBAlignment = new br.com.gmp.comps.combobox.GComboBox();
        jSPModifiers = new javax.swing.JScrollPane();
        jPModifiers = new javax.swing.JPanel();
        jSpinMov = new javax.swing.JSpinner();
        jSpinCA = new javax.swing.JSpinner();
        jLMov = new javax.swing.JLabel();
        jLCA = new javax.swing.JLabel();
        jLPrice = new javax.swing.JLabel();
        jSpinPrice = new javax.swing.JSpinner();
        jSPDesc = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar armadura");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/P/P_21.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(430, 300));
        setMinimumSize(new java.awt.Dimension(430, 300));
        setPreferredSize(new java.awt.Dimension(430, 300));

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

        jLMat1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat1.setText("Material:");

        jLMat2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat2.setText("Origem");

        JLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLType.setText("Tipo:");

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLAlign.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLAlign.setText("Alinhamento");

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLType)
                            .addComponent(jLName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMat1)
                            .addComponent(jLMat2)
                            .addComponent(jLAlign))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBAlignment, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gCBOrigin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gCBMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JLType, jLMat1, jLMat2, jLName});

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gCBAlignment, gCBMaterial, gCBOrigin, gCBType, gTName});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLName)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMat1)
                    .addComponent(gCBMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMat2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBAlignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAlign))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBAlignment, gCBMaterial, gCBOrigin, gCBType, gTName});

        jTabbedPane1.addTab("Configurações basicas", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/DK/DK_0.png")), jPBasics); // NOI18N

        jSpinMov.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        jSpinMov.setMaximumSize(new java.awt.Dimension(40, 26));
        jSpinMov.setMinimumSize(new java.awt.Dimension(40, 26));
        jSpinMov.setPreferredSize(new java.awt.Dimension(40, 26));

        jSpinCA.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        jSpinCA.setMaximumSize(new java.awt.Dimension(40, 26));
        jSpinCA.setMinimumSize(new java.awt.Dimension(40, 26));
        jSpinCA.setPreferredSize(new java.awt.Dimension(40, 26));

        jLMov.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMov.setText("Redução de movimento:");

        jLCA.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCA.setText("Classe de armadura:");

        jLPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPrice.setText("Preço:");

        jSpinPrice.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));
        jSpinPrice.setMaximumSize(new java.awt.Dimension(40, 26));

        javax.swing.GroupLayout jPModifiersLayout = new javax.swing.GroupLayout(jPModifiers);
        jPModifiers.setLayout(jPModifiersLayout);
        jPModifiersLayout.setHorizontalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModifiersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPModifiersLayout.createSequentialGroup()
                        .addComponent(jLPrice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPModifiersLayout.createSequentialGroup()
                            .addComponent(jLMov)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSpinMov, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPModifiersLayout.createSequentialGroup()
                            .addComponent(jLCA)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSpinCA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSpinCA, jSpinMov, jSpinPrice});

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLCA, jLMov});

        jPModifiersLayout.setVerticalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModifiersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCA)
                    .addComponent(jSpinCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMov)
                    .addComponent(jSpinMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrice))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLCA, jLMov, jLPrice});

        jSPModifiers.setViewportView(jPModifiers);

        jTabbedPane1.addTab("Modificadores", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1247_.png")), jSPModifiers); // NOI18N

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jSPDesc.setViewportView(gTADesc);

        jTabbedPane1.addTab("Descrição", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png")), jSPDesc); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                if (armor == null) {
                    System.out.println("Criando nova armadura...");
                    build();
                    view.getBean().add(new BeanEvent(view, armor));
                } else {
                    System.out.println("Atualizando armadura...");
                    build();
                    view.getBean().update(armor);
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
    private javax.swing.JLabel JLType;
    private br.com.gmp.comps.combobox.GComboBox gCBAlignment;
    private br.com.gmp.comps.combobox.GComboBox gCBMaterial;
    private br.com.gmp.comps.combobox.GComboBox gCBOrigin;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
    private javax.swing.JLabel jLAlign;
    private javax.swing.JLabel jLCA;
    private javax.swing.JLabel jLMat1;
    private javax.swing.JLabel jLMat2;
    private javax.swing.JLabel jLMov;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLPrice;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPModifiers;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JScrollPane jSPModifiers;
    private javax.swing.JSpinner jSpinCA;
    private javax.swing.JSpinner jSpinMov;
    private javax.swing.JSpinner jSpinPrice;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
