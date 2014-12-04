package br.com.urcontroler.main.view.armor;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.entity.Armor;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.Origin;
import br.com.urcontroler.data.entity.MaterialType;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.interfaces.ListView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;

/**
 * View para inclusão e edição de armaduras.
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public class ArmorListView extends View<ArmorListBean> implements ListView<Armor> {

    private Armor editingArmor;
    private ArmorListBean bean;
    private GComboBoxModel<ArmorType> armorTypeModel;
    private GComboBoxModel<MaterialType> materialModel;
    private GComboBoxModel<Origin> originModel;
    private GComboBoxModel<Alignment> alignmentModel;
    private GListModel<Armor> model;

    /**
     * Cria nova instancia de ArmorListView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     * @since 1.0
     */
    public ArmorListView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     *
     * @param armor {@code Armor} Armadura
     * @since 1.0
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, false, true));
        this.setSize(640, 530);
        this.initComponents();
        this.gListArmors.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setText(value.toString());
                label.setIcon(new ImageIcon(getClass().getResource("/Mixed/P_2.png")));
                return label;
            }
        });
        this.bean = new ArmorListBean(this);
        this.armorTypeModel = new GComboBoxModel<>(bean.getArmorTypeList());
        this.gCBType.setGModel(armorTypeModel);
        this.materialModel = new GComboBoxModel<>(bean.getMaterialTypeList());
        this.gCBMaterial.setGModel(materialModel);
        this.originModel = new GComboBoxModel<>(bean.getOriginList());
        this.gCBOrigin.setGModel(originModel);
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.gCBAlignment.setGModel(alignmentModel);
        this.model = new GListModel<>(bean.getArmorList());
        this.gListArmors.setModel(model);
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
        this.setVisible(true);
    }

    /**
     * Método de modificação do formulario
     */
    private void changeSelection() {
        setEditingArmor((Armor) gListArmors.getSelectedValue());
    }

    @Override
    public void apply() throws IllegalArgumentException, IllegalAccessException {
        if (validateFields()) {
            Armor build = build();
            ObjectCopy.copyAll(build, editingArmor);
            updateComponent(gListArmors);
        } else {
            LOGGER.log(Level.WARNING, "Campos invalidos.");
        }
    }

    @Override
    public void add() throws Exception {
        Armor tmp = buildTemp();
        model.add(tmp);
        editingArmor = tmp;
    }

    @Override
    public void remove() throws Exception {
        gListArmors.removeSelected();
    }

    @Override
    public Armor buildTemp() throws Exception {
        Armor armor = new Armor();
        armor.setId(bean.getNextID());
        armor.setName("");
        armor.setMovReduction(0);
        armor.setArmorClass(0);
        armor.setPrice(0D);
        return armor;
    }

    @Override
    public ArmorListBean getBean() {
        return bean;
    }

    @Override
    public GList getList() {
        return gListArmors;
    }

    @Override
    public GListModel<Armor> getModel() {
        return model;
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
    public Armor getEditingArmor() {
        return editingArmor;
    }

    /**
     * Modifica a armadura que está sendo editada
     *
     * @param editingArmor {@code Armor} Armadura
     * @since 1.0
     */
    public void setEditingArmor(Armor editingArmor) {
        try {
            if (editingArmor != null) {
                this.editingArmor = editingArmor;
                this.gTName.setText(editingArmor.getName());
                this.gTADesc.setText(editingArmor.getDescription());
                if (editingArmor.getType() != null) {
                    this.gCBType.setSelectedItem(editingArmor.getType());
                }
                if (editingArmor.getMaterial() != null) {
                    this.gCBMaterial.setSelectedItem(editingArmor.getMaterial());
                }
                if (editingArmor.getAlignment() != null) {
                    this.gCBAlignment.setSelectedItem(editingArmor.getAlignment());
                }
                if (editingArmor.getOrigin() != null) {
                    this.gCBOrigin.setSelectedItem(editingArmor.getOrigin());
                }
                if (editingArmor.getPrice() != null) {
                    this.jSpinPrice.setValue(editingArmor.getPrice());
                }
                if (editingArmor.getOrigin() != null) {
                    this.jSpinCA.setValue(editingArmor.getArmorClass());
                }
                if (editingArmor.getMovReduction() != null) {
                    this.jSpinMov.setValue(editingArmor.getMovReduction());
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "setEditingArmor Error", e);
        }
    }

    /**
     * Constroi os dados na armadura
     *
     * @return {@code Armor} Armadura reconstruida
     * @since 1.0
     */
    private Armor build() {
        Armor armor = editingArmor;
        if (armor == null) {
            armor = new Armor();
        }
        if (armor.getId() == null) {
            armor.setId(bean.getNextID());
        }
        armor.setName(gTName.getText());
        armor.setDescription(gTADesc.getText());
        armor.setPrice((Double) jSpinPrice.getValue());
        armor.setType(armorTypeModel.getSelectedItem());
        armor.setMaterial(materialModel.getSelectedItem());
        armor.setArmorClass((Integer) jSpinCA.getValue());
        armor.setAlignment(alignmentModel.getSelectedItem());
        armor.setOrigin(originModel.getSelectedItem());
        armor.setMovReduction((Integer) jSpinMov.getValue());
        return armor;
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
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gListArmors = new br.com.gmp.comps.list.GList();
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
        jSpinCA = new javax.swing.JSpinner();
        jLCA1 = new javax.swing.JLabel();
        jSpinMov = new javax.swing.JSpinner();
        jLMov1 = new javax.swing.JLabel();
        jLPrice1 = new javax.swing.JLabel();
        jSpinPrice = new javax.swing.JSpinner();
        jSPDesc = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        jBApply = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Armaduras");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/P/P_21.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(620, 500));
        setMinimumSize(new java.awt.Dimension(620, 500));
        setPreferredSize(new java.awt.Dimension(620, 500));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setFocusable(false);
        jBAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar1.add(jBAdd);

        jBDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/minus.png"))); // NOI18N
        jBDelete.setFocusable(false);
        jBDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(jBDelete);

        gListArmors.setBorder(null);
        gListArmors.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gListArmorsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(gListArmors);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPBasics.setBorder(javax.swing.BorderFactory.createTitledBorder("Armadura"));

        jLMat1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat1.setLabelFor(gCBMaterial);
        jLMat1.setText("Material:");

        jLMat2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat2.setLabelFor(gCBOrigin);
        jLMat2.setText("Origem:");

        JLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLType.setLabelFor(gCBType);
        JLType.setText("Tipo:");

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setLabelFor(gTName);
        jLName.setText("Nome:");

        jLAlign.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLAlign.setLabelFor(gCBAlignment);
        jLAlign.setText("Alinhamento:");

        jSpinCA.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        jSpinCA.setMaximumSize(new java.awt.Dimension(40, 26));
        jSpinCA.setMinimumSize(new java.awt.Dimension(40, 26));
        jSpinCA.setPreferredSize(new java.awt.Dimension(40, 26));

        jLCA1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCA1.setLabelFor(jSpinCA);
        jLCA1.setText("CA:");

        jSpinMov.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));
        jSpinMov.setMaximumSize(new java.awt.Dimension(40, 26));
        jSpinMov.setMinimumSize(new java.awt.Dimension(40, 26));
        jSpinMov.setPreferredSize(new java.awt.Dimension(40, 26));

        jLMov1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMov1.setLabelFor(jSpinMov);
        jLMov1.setText("Red. Movimento:");

        jLPrice1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPrice1.setLabelFor(jSpinPrice);
        jLPrice1.setText("Preço:");

        jSpinPrice.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.5d));
        jSpinPrice.setMaximumSize(new java.awt.Dimension(40, 26));

        jSPDesc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição"));

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jSPDesc.setViewportView(gTADesc);

        jBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/button/switch/on.png"))); // NOI18N
        jBApply.setText("Aplicar");
        jBApply.setFocusable(false);
        jBApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDesc)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMat1)
                            .addComponent(jLMat2)
                            .addComponent(jLAlign)
                            .addComponent(jLCA1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBOrigin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gCBAlignment, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gCBMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSpinMov, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                .addComponent(jSpinCA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLName)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(JLType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLMov1)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLPrice1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBApply))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLAlign, jLCA1, jLMat1, jLMat2, jLMov1, jLName, jLPrice1});

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSpinCA, jSpinMov, jSpinPrice});

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gCBAlignment, gCBMaterial, gCBOrigin, gTName});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCA1)
                    .addComponent(jSpinCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMov1)
                    .addComponent(jSpinMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPrice1)
                    .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSPDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBApply)
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBAlignment, gCBMaterial, gCBOrigin, gCBType, gTName});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPBasics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPBasics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        try {
            apply();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            LOGGER.log(Level.SEVERE, "Apply Error", ex);
        }
    }//GEN-LAST:event_jBApplyActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Add Error", ex);
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Delete Error", ex);
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void gListArmorsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListArmorsValueChanged
        changeSelection();
    }//GEN-LAST:event_gListArmorsValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLType;
    private br.com.gmp.comps.combobox.GComboBox gCBAlignment;
    private br.com.gmp.comps.combobox.GComboBox gCBMaterial;
    private br.com.gmp.comps.combobox.GComboBox gCBOrigin;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.GList gListArmors;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JLabel jLAlign;
    private javax.swing.JLabel jLCA1;
    private javax.swing.JLabel jLMat1;
    private javax.swing.JLabel jLMat2;
    private javax.swing.JLabel jLMov1;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLPrice1;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinCA;
    private javax.swing.JSpinner jSpinMov;
    private javax.swing.JSpinner jSpinPrice;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
