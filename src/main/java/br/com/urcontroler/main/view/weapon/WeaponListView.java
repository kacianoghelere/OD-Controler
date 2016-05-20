package br.com.urcontroler.main.view.weapon;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.urcontroler.data.entity.MaterialType;
import br.com.urcontroler.data.entity.Origin;
import br.com.urcontroler.data.entity.Weapon;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.enums.Dice;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.ListView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 * SubView para controle de armas
 *
 * @author kaciano
 * @version 1.0
 */
public class WeaponListView extends View<WeaponListBean> implements ListView<Weapon> {

    private WeaponView view;
    private WeaponListBean bean;
    private Weapon editingWeapon;
    private GComboBoxModel<WeaponType> typeModel;
    private GComboBoxModel<Origin> originModel;
    private GComboBoxModel<MaterialType> materialModel;
    private GComboBoxModel<Alignment> alignmentModel;
    private GComboBoxModel<Dice> diceModel;
    private GListModel<Weapon> model;

    /**
     * Cria nova instancia de WeaponSubView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public WeaponListView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setSize(545, 465);
        this.setControls(new ViewParameter(true, false, true, true));
        this.initComponents();
        this.bean = new WeaponListBean(this);
        this.onLoad();
        this.gListWeapons.setModel(model);
        this.gCBType.setGModel(typeModel);
        this.gCBOrigin.setGModel(originModel);
        this.gCBMaterial.setGModel(materialModel);
        this.gCBAlignment.setGModel(alignmentModel);
        this.gCBDmgDice.setGModel(diceModel);
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
    }

    @Override
    public void onLoad() {
        this.model = new GListModel<>(bean.getWeaponList());
        this.typeModel = new GComboBoxModel<>(bean.getWeaponTypeList());
        this.originModel = new GComboBoxModel<>(bean.getOriginList());
        this.materialModel = new GComboBoxModel<>(bean.getMaterialTypeList());
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.diceModel = new GComboBoxModel<>(Dice.values());
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return {@code boolean} Os campos estão todos preenchidos corretamente?
     * @since 1.0
     */
    private boolean validateFields() {
        //<editor-fold desc="Validação" defaultstate="collapsed">
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
        if (!gCBOrigin.validateComponent()) {
            System.out.println("Origem invalido");
            return false;
        }
        if (!gCBAlignment.validateComponent()) {
            System.out.println("Alinhamento invalido");
            return false;
        }
        if (!(jSpnInitiative.getValue() != null && ((Integer) jSpnInitiative.getValue()) != 0)) {
            showBallon(jSpnInitiative, "Iniciativa invalida");
            return false;
        }
        if (!(gNDmgAmt.validateComponent() && gNDmgAmt.isZero() && gNDmgAmt.isNegative())) {
            System.out.println("Qtd dados invalida");
            return false;
        }
        if (!gCBDmgDice.validateComponent()) {
            System.out.println("Dado invalido");
            return false;
        }
        if (!(gNWeight.validateComponent() && gNWeight.isZero() && gNWeight.isNegative())) {
            System.out.println("Peso invalido");
            return false;
        }
        if (!(gNPrice.validateComponent() && gNPrice.isZero() && gNPrice.isNegative())) {
            System.out.println("Preço invalido");
            return false;
        }
        return true;
    }

    /**
     * Cria o nome da arma automaticamente
     *
     * @since 1.0
     */
    private void autoName() {
        if (gCBType.validateComponent() && gCBMaterial.validateComponent() && gCBOrigin.validateComponent()) {
            WeaponType prefix = this.typeModel.getSelectedItem();
            MaterialType material = this.materialModel.getSelectedItem();
            Origin origin = this.originModel.getSelectedItem();
            this.gTName.setText(prefix.getName() + " "
                    + (prefix.getName().endsWith("a")
                            ? origin.getVariation() : origin.getName())
                    + " de " + material.getName());
        }
    }

    /**
     * Seleciona os campos aleatóriamente criando uma arma única por vez
     *
     * @throws Exception Exceção propagada
     */
    private void randomize() throws Exception {
        Random rd = new Random();
        this.gCBAlignment.setSelectedIndex(rd.nextInt(alignmentModel.getSize()));
        this.gCBMaterial.setSelectedIndex(rd.nextInt(materialModel.getSize()));
        this.gCBOrigin.setSelectedIndex(rd.nextInt(originModel.getSize()));
        this.gCBType.setSelectedIndex(rd.nextInt(typeModel.getSize()));
        this.gCBDmgDice.setSelectedIndex(rd.nextInt(diceModel.getSize()));
        this.gNPrice.setInt(rd.nextInt(80));
        this.gNWeight.setInt(rd.nextInt(10));
        this.jSpnInitiative.setValue(rd.nextInt(10));
        this.jSpnRange.setValue(rd.nextInt(80));
        this.gNDmgAmt.setInt(rd.nextInt(10));
        autoName();
        updateComponents();
    }

    @Override
    public WeaponListBean getBean() {
        return bean;
    }

    @Override
    public void apply() throws Exception {
        if (validateFields()) {
            Weapon build = build();
            ObjectCopy.copyAll(build, editingWeapon);
            updateComponent(gListWeapons);
        } else {
            LOGGER.log(Level.WARNING, "Campos invalidos.");
        }
    }

    @Override
    public void add() throws Exception {
        Weapon tmp = buildTemp();
        model.add(tmp);
        editingWeapon = tmp;
    }

    @Override
    public void remove() throws Exception {
        this.gListWeapons.removeSelected();
    }

    @Override
    public Weapon buildTemp() throws Exception {
        Weapon weapon = new Weapon();
        weapon.setName("");
        weapon.setId(bean.getNextID());
        weapon.setDmgAmount(0);
        weapon.setPrice(0);
        weapon.setRange(0);
        weapon.setInitiative(0);
        weapon.setWeight(0D);
        return weapon;
    }

    @Override
    public GList getList() {
        return this.gListWeapons;
    }

    @Override
    public GListModel<Weapon> getModel() {
        return model;
    }

    /**
     * Método de modificação do formulario
     */
    public void changeSelection() {
        setEditingWeapon((Weapon) gListWeapons.getSelectedValue());
    }

    /**
     * Reconstroi a arma
     */
    private Weapon build() {
        Weapon weapon = editingWeapon;
        if (weapon == null) {
            weapon = new Weapon();
        }
        if (weapon.getId() == null) {
            weapon.setId(bean.getNextID());
        }
        weapon.setName(gTName.getText());
        weapon.setAlignment((Alignment) gCBAlignment.getSelectedItem());
        weapon.setMaterial((MaterialType) gCBMaterial.getSelectedItem());
        weapon.setOrigin((Origin) gCBOrigin.getSelectedItem());
        weapon.setType((WeaponType) gCBType.getSelectedItem());
        weapon.setDescription(gTADesc.getText());
        weapon.setPrice(gNPrice.getInteger());
        weapon.setWeight(gNWeight.getDouble());
        weapon.setInitiative((Integer) jSpnInitiative.getValue());
        weapon.setRange((Integer) jSpnRange.getValue());
        weapon.setDmgAmount(gNDmgAmt.getInteger());
        weapon.setDice(diceModel.getSelectedItem());
        return weapon;
    }

    /**
     * Retorna a arma da view
     *
     * @return {@code Weapon} Arma da view
     */
    public Weapon getEditingWeapon() {
        return this.editingWeapon;
    }

    /**
     * Modifica a arma da view
     *
     * @param weapon {@code Weapon} Arma da view
     */
    public void setEditingWeapon(Weapon weapon) {
        try {
            if (weapon != null) {
                this.editingWeapon = weapon;
                this.gTName.setText(weapon.getName());
                if (weapon.getAlignment() != null) {
                    this.gCBAlignment.setSelectedItem(weapon.getAlignment());
                }
                if (weapon.getMaterial() != null) {
                    this.gCBMaterial.setSelectedItem(weapon.getMaterial());
                }
                if (weapon.getOrigin() != null) {
                    this.gCBOrigin.setSelectedItem(weapon.getOrigin());
                }
                if (weapon.getType() != null) {
                    this.gCBType.setSelectedItem(weapon.getType());
                }
                this.gTADesc.setText(weapon.getDescription());
                this.gNPrice.setInt(weapon.getPrice());
                this.gNWeight.setInt(new Double(weapon.getWeight()).intValue());
                this.jSpnInitiative.setValue(weapon.getInitiative());
                this.jSpnRange.setValue(weapon.getRange());
                this.gNDmgAmt.setInt(weapon.getDmgAmount());
                if (weapon.getDice() != null) {
                    this.gCBDmgDice.setSelectedItem(weapon.getDice());
                }
            }
        } catch (Exception e) {
            throwException(new ViewException(view, e));
        }
    }

    /**
     * Retorna o modelo dos Tipos de armas
     *
     * @return {@code GComboBoxModel(WeaponType)} Tipos de armas
     * @since 1.0
     */
    public GComboBoxModel<WeaponType> getArmorTypeModel() {
        return typeModel;
    }

    /**
     * Retorna o modelo das origens
     *
     * @return {@code GComboBoxModel(Origin)} Origens de armas
     * @since 1.0
     */
    public GComboBoxModel<Origin> getOriginModel() {
        return originModel;
    }

    /**
     * Retorna o modelo dos Materiais
     *
     * @return {@code GComboBoxModel(PrimeMaterial)} Materiais
     */
    public GComboBoxModel<MaterialType> getMaterialModel() {
        return materialModel;
    }

    /**
     * Retorna o modelo dos alinhamentos
     *
     * @return {@code GComboBoxModel(Alignment)} Modelo dos alinhamentos
     * @since 1.1
     */
    public GComboBoxModel<Alignment> getAlignmentModel() {
        return alignmentModel;
    }

    /**
     * Retorna o modelo dos dados
     *
     * @return {@code GComboBoxModel(Dice)} Modelo dos dados
     * @since 1.1
     */
    public GComboBoxModel<Dice> getDiceModel() {
        return diceModel;
    }

    /**
     * Dados gerados automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPList = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        gListWeapons = new br.com.gmp.comps.list.GList();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        jBApply = new javax.swing.JButton();
        jBRandomize = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Armas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/P/P_5.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(545, 465));
        setMinimumSize(new java.awt.Dimension(545, 465));
        setPreferredSize(new java.awt.Dimension(545, 465));

        jPList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        gListWeapons.setBorder(null);
        gListWeapons.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gListWeaponsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(gListWeapons);

        javax.swing.GroupLayout jPListLayout = new javax.swing.GroupLayout(jPList);
        jPList.setLayout(jPListLayout);
        jPListLayout.setHorizontalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPListLayout.setVerticalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPListLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPBasics.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Armas"));

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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jScrollPane1.setViewportView(gTADesc);

        jBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/button/switch/on.png"))); // NOI18N
        jBApply.setText("Aplicar");
        jBApply.setFocusable(false);
        jBApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });

        jBRandomize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jBRandomize.setText("Gerar");
        jBRandomize.setFocusable(false);
        jBRandomize.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRandomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRandomizeActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLMaterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLOrigin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBOrigin, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLAlignment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBAlignment, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLInitiative)
                                    .addComponent(jLWeight))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSpnInitiative)
                                    .addComponent(gNWeight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gNDmgAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLDamage))
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLRange, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpnRange))
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gCBDmgDice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addGroup(jPBasicsLayout.createSequentialGroup()
                                        .addComponent(jLPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gNPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))))))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jBApply)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRandomize)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLAlignment, jLDamage, jLInitiative, jLMaterial, jLName, jLOrigin, jLType, jLWeight});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLType))
                .addGap(6, 6, 6)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBApply)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBasicsLayout.createSequentialGroup()
                        .addComponent(jBRandomize)
                        .addContainerGap())))
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBAlignment, gCBDmgDice, gCBMaterial, gCBOrigin, gCBType, gNDmgAmt, gNPrice, gNWeight, gTName, jLAlignment, jLDamage, jLInitiative, jLMaterial, jLName, jLOrigin, jLPrice, jLRange, jLType, jLWeight, jSpnInitiative, jSpnRange});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBasics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBasics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void gListWeaponsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListWeaponsValueChanged
        changeSelection();
    }//GEN-LAST:event_gListWeaponsValueChanged

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        try {
            apply();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Apply Error", ex);
        }
    }//GEN-LAST:event_jBApplyActionPerformed

    private void jBRandomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRandomizeActionPerformed
        try {
            randomize();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Randomize Error", ex);
        }
    }//GEN-LAST:event_jBRandomizeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBAlignment;
    private br.com.gmp.comps.combobox.GComboBox gCBDmgDice;
    private br.com.gmp.comps.combobox.GComboBox gCBMaterial;
    private br.com.gmp.comps.combobox.GComboBox gCBOrigin;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.GList gListWeapons;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNDmgAmt;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNPrice;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNWeight;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBRandomize;
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
    private javax.swing.JPanel jPList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpnInitiative;
    private javax.swing.JSpinner jSpnRange;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
