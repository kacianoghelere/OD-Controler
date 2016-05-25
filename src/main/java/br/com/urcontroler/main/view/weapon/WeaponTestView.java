package br.com.urcontroler.main.view.weapon;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.urcontroler.data.db.dao.MaterialTypeDAO;
import br.com.urcontroler.data.db.dao.OriginDAO;
import br.com.urcontroler.data.db.dao.WeaponTypeDAO;
import br.com.urcontroler.data.entity.MaterialType;
import br.com.urcontroler.data.entity.Origin;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.enums.Dice;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.interfaces.BeanListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 * SubView para controle de armas
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class WeaponTestView extends View {

    private WeaponBean bean;
    private GComboBoxModel<WeaponType> typeModel;
    private GComboBoxModel<Origin> originModel;
    private GComboBoxModel<MaterialType> materialModel;
    private GComboBoxModel<Alignment> alignmentModel;
    private GComboBoxModel<Dice> diceModel;

    /**
     * Cria nova instancia de WeaponTestView
     *
     * @param parent {@code MainScreen} Tela principal
     */
    public WeaponTestView(MainScreen parent) {
        super(parent);
        this.initialize();
    }

    @Override
    public BeanListener getBean() {
        return null;
    }

    /**
     * Método de inicialização
     *
     * @param weapon {@code WeaponView} Arma
     */
    private void initialize() {
        this.setSize(385, 427);
        this.initComponents();
        this.onLoad();
        this.gCBType.setGModel(typeModel);
        this.gCBOrigin.setGModel(originModel);
        this.gCBMaterial.setGModel(materialModel);
        this.gCBAlignment.setGModel(alignmentModel);
        this.gCBDmgDice.setGModel(diceModel);
//        this.setWeapon(weapon);
        //----------------------------------------------------------------------
        JMenuItem gen;
        gen = new JMenuItem("Gerar nome", new ImageIcon(getClass()
                .getResource("/ComponentIcons/controlers/settings.png")));
        gen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Teste");
            }
        });
        this.gTName.getComponentPopupMenu().add(gen);
        //----------------------------------------------------------------------
    }

    @Override
    public void onLoad() {
        this.typeModel = new GComboBoxModel<>(new WeaponTypeDAO().getList());
        this.originModel = new GComboBoxModel<>(new OriginDAO().getList());
        this.materialModel = new GComboBoxModel<>(new MaterialTypeDAO().getList());
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.diceModel = new GComboBoxModel<>(Dice.values());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        weaponBind = new br.com.urcontroler.data.entity.Weapon();
        jTabs = new javax.swing.JTabbedPane();
        jPBasics = new javax.swing.JPanel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLName = new javax.swing.JLabel();
        gCBOrigin = new br.com.gmp.comps.combobox.GComboBox();
        jLOrigin = new javax.swing.JLabel();
        jLInitiative = new javax.swing.JLabel();
        jSpnInitiative = new javax.swing.JSpinner();
        jSpnRange = new javax.swing.JSpinner();
        jLRange = new javax.swing.JLabel();
        jLDamage = new javax.swing.JLabel();
        gCBDmgDice = new br.com.gmp.comps.combobox.GComboBox();
        gNDmgAmt = new br.com.gmp.comps.textfield.numeric.GNumericField();
        gNWeight = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jLWeight = new javax.swing.JLabel();
        gNPrice = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jLPrice = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLType = new javax.swing.JLabel();
        gCBMaterial = new br.com.gmp.comps.combobox.GComboBox();
        jLMaterial = new javax.swing.JLabel();
        gCBAlignment = new br.com.gmp.comps.combobox.GComboBox();
        jLAlignment = new javax.swing.JLabel();
        jPDescription = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        jBCancel = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        jBRandom = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar armas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/P/P_5.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(385, 427));
        setMinimumSize(new java.awt.Dimension(385, 427));
        setPreferredSize(new java.awt.Dimension(385, 427));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, weaponBind, org.jdesktop.beansbinding.ELProperty.create("${name}"), gTName, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLOrigin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLOrigin.setText("Origem:");

        jLInitiative.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLInitiative.setText("Iniciativa:");

        jSpnInitiative.setModel(new javax.swing.SpinnerNumberModel());

        jSpnRange.setModel(new javax.swing.SpinnerNumberModel());

        jLRange.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLRange.setText("Alcance:");

        jLDamage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDamage.setText("Dano:");

        gCBDmgDice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "D4", "D6", "D8", "D10", "D12", "D20" }));

        jLWeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLWeight.setText("Peso:");

        jLPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPrice.setText("Preço:");

        jLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLType.setText("Tipo:");

        jLMaterial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMaterial.setText("Material:");

        jLAlignment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLAlignment.setText("Alinhamento");

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLInitiative)
                            .addComponent(jLWeight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpnInitiative)
                            .addComponent(gNWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gNDmgAmt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gCBDmgDice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBasicsLayout.createSequentialGroup()
                                        .addComponent(jLPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gNPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLRange, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpnRange))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLMaterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPBasicsLayout.createSequentialGroup()
                            .addComponent(jLAlignment)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gCBAlignment, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addGroup(jPBasicsLayout.createSequentialGroup()
                            .addComponent(jLDamage)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPBasicsLayout.createSequentialGroup()
                            .addComponent(jLOrigin)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(gCBOrigin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLAlignment, jLDamage, jLInitiative, jLMaterial, jLName, jLOrigin, jLType, jLWeight});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBAlignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLAlignment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLOrigin))
                .addGap(5, 5, 5)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMaterial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLInitiative)
                    .addComponent(jSpnInitiative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLRange)
                    .addComponent(jSpnRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDamage)
                    .addComponent(gCBDmgDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gNDmgAmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gNWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWeight)
                    .addComponent(gNPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrice))
                .addGap(26, 26, 26))
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBAlignment, gCBDmgDice, gCBMaterial, gCBOrigin, gCBType, gNDmgAmt, gNPrice, gNWeight, gTName, jLAlignment, jLDamage, jLInitiative, jLMaterial, jLName, jLOrigin, jLPrice, jLRange, jLType, jLWeight, jSpnInitiative, jSpnRange});

        jTabs.addTab("Configurações Básicas", jPBasics);

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jScrollPane1.setViewportView(gTADesc);

        javax.swing.GroupLayout jPDescriptionLayout = new javax.swing.GroupLayout(jPDescription);
        jPDescription.setLayout(jPDescriptionLayout);
        jPDescriptionLayout.setHorizontalGroup(
            jPDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );
        jPDescriptionLayout.setVerticalGroup(
            jPDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        jTabs.addTab("Descrição", jPDescription);

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.setFocusable(false);
        jBCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Salvar");
        jBAdd.setFocusable(false);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBRandom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jBRandom.setText("Aleatório");
        jBRandom.setFocusable(false);
        jBRandom.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRandomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRandom)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd)
                    .addComponent(jBCancel)
                    .addComponent(jBRandom))
                .addContainerGap())
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        System.out.println("Teste");
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        System.out.println("Teste");
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRandomActionPerformed
        System.out.println("Teste");
    }//GEN-LAST:event_jBRandomActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBAlignment;
    private br.com.gmp.comps.combobox.GComboBox gCBDmgDice;
    private br.com.gmp.comps.combobox.GComboBox gCBMaterial;
    private br.com.gmp.comps.combobox.GComboBox gCBOrigin;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNDmgAmt;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNPrice;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNWeight;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBRandom;
    private javax.swing.JLabel jLAlignment;
    private javax.swing.JLabel jLDamage;
    private javax.swing.JLabel jLInitiative;
    private javax.swing.JLabel jLMaterial;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLOrigin;
    private javax.swing.JLabel jLPrice;
    private javax.swing.JLabel jLRange;
    private javax.swing.JLabel jLType;
    private javax.swing.JLabel jLWeight;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPDescription;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpnInitiative;
    private javax.swing.JSpinner jSpnRange;
    private javax.swing.JTabbedPane jTabs;
    private br.com.urcontroler.data.entity.Weapon weaponBind;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
