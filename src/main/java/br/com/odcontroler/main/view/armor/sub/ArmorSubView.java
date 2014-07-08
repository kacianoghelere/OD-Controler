package br.com.odcontroler.main.view.armor.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.odcontroler.data.entity.Armor;
import br.com.odcontroler.data.entity.ArmorType;
import br.com.odcontroler.data.entity.Attributes;
import br.com.odcontroler.data.entity.PrimeMaterial;
import br.com.odcontroler.data.entity.Restriction;
import br.com.odcontroler.data.entity.RestrictionType;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.sub.SubView;
import br.com.odcontroler.main.view.armor.ArmorView;
import br.com.odcontroler.main.view.armor.bean.ArmorBean;
import br.com.odcontroler.main.view.armor.dialog.EffectDialog;
import br.com.odcontroler.main.view.armor.dialog.RestrictionDialog;
import br.com.odcontroler.main.view.armor.model.ArmorEffectModel;
import br.com.odcontroler.main.view.armor.model.RestrictionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 *
 * @author kaciano
 */
public class ArmorSubView extends SubView {

    private Armor armor;
    private ArmorBean bean;
    private ArmorView view;
    private RestrictionModel restModel;
    private ArmorEffectModel effectModel;
    private GComboBoxModel<ArmorType> armorTypeModel;
    private GComboBoxModel<PrimeMaterial> materialModel1;
    private GComboBoxModel<PrimeMaterial> materialModel2;
    private GComboBoxModel<RestrictionType> restrictModel;

    /**
     * Cria nova instancia de ArmorSubView
     *
     * @param view <code>ArmorView</code> Tela das Armaduras
     * @param armor <code>Armor</code> Armadura
     */
    public ArmorSubView(ArmorView view, Armor armor) {
        super(view);
        this.view = view;
        initialize(armor);
    }

    /**
     * Método de inicialização
     *
     * @param armor <code>Armor</code> Armadura
     */
    private void initialize(Armor armor) {
        setSize(680, 545);
        initComponents();
        this.bean = (ArmorBean) view.getBean();
        this.restModel = new RestrictionModel();
        this.effectModel = new ArmorEffectModel();
        this.armorTypeModel = new GComboBoxModel<>(bean.getArmorTypeDAO().getList());
        this.materialModel1 = new GComboBoxModel<>(bean.getMaterialsDAO().getList());
        this.materialModel2 = new GComboBoxModel<>(bean.getMaterialsDAO().getList());
        this.restrictModel = new GComboBoxModel<>(bean.getRestDAO().getList());
        this.gTblRestrictions.setModel(restModel);
        this.gTblEffects.setModel(effectModel);
        this.gCBType.setGModel(armorTypeModel);
        this.gCBMat1.setGModel(materialModel1);
        this.gCBMat2.setGModel(materialModel2);
        this.gCBRest.setGModel(restrictModel);
        //----------------------------------------------------------------------
        JMenuItem jMIGen = new JMenuItem("Gerar nome", new ImageIcon(getClass()
                .getResource("/ComponentIcons/controlers/settings.png")));
        jMIGen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                autoName();
            }
        });
        this.gTName.getComponentPopupMenu().add(jMIGen);
        //----------------------------------------------------------------------
        this.setArmor(armor);
        this.setVisible(true);
    }

    /**
     * Cria o nome da armadura automaticamentes
     */
    private void autoName() {
        if (gCBType.validateComponent() && gCBMat1.validateComponent() && gCBMat2.validateComponent()) {
            ArmorType prefix = this.armorTypeModel.getSelectedItem();
            PrimeMaterial mat1 = this.materialModel1.getSelectedItem();
            PrimeMaterial mat2 = this.materialModel2.getSelectedItem();
            String name = prefix.getTitle()
                    + " de " + mat1.getName()
                    + " e " + mat2.getName();
            this.gTName.setText(name);
        }
    }

    /**
     * Retorna a armadura que está sendo editada
     *
     * @return <code>Armor</code> Armadura
     */
    public Armor getArmor() {
        return armor;
    }

    /**
     * Modifica a armadura que está sendo editada
     *
     * @param armor <code>Armor</code> Armadura
     */
    public void setArmor(Armor armor) {
        try {
            if (armor != null) {
                this.armor = armor;
                this.gTName.setText(this.armor.getName());
                this.gTADesc.setText(this.armor.getDescription());
                this.gCBType.setSelectedItem(this.armor.getType());
                this.gCBMat1.setSelectedItem(this.armor.getMaterial1());
                this.gCBMat2.setSelectedItem(this.armor.getMaterial2());
                this.jSpinPrice.setValue(this.armor.getPrice());
                if (this.armor.getRestriction() != null) {
                    this.restModel.setData(this.armor.getRestriction());
                }
                if (this.armor.getEffects() != null) {
                    this.effectModel.setData(this.armor.getEffects());
                }
                if (this.armor.getAttributes() != null) {
                    Attributes attr = this.armor.getAttributes();
                    jSpinStr.setValue(attr.getStrength());
                    jSpinDex.setValue(attr.getDexterity());
                    jSpinCon.setValue(attr.getConstitution());
                    jSpinInt.setValue(attr.getIntelligence());
                    jSpinWis.setValue(attr.getWisdom());
                    jSpinChar.setValue(attr.getCharisma());
                    jSpinDef.setValue(attr.getDefense());
                    jSpinEva.setValue(attr.getEvasion());
                    jSpinHP.setValue(attr.getHealth());
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ArmorSubView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Constroi os dados na armadura
     */
    private void buildArmor() {
        if (this.armor == null) {
            this.armor = new Armor();
        }
        if (this.armor.getId() == null) {
            this.armor.setId(bean.getNextID());
        }
        Attributes attr = new Attributes();
        attr.setStrength((Integer) jSpinStr.getValue());
        attr.setDexterity((Integer) jSpinDex.getValue());
        attr.setConstitution((Integer) jSpinCon.getValue());
        attr.setIntelligence((Integer) jSpinInt.getValue());
        attr.setWisdom((Integer) jSpinWis.getValue());
        attr.setCharisma((Integer) jSpinChar.getValue());
        attr.setDefense((Integer) jSpinDef.getValue());
        attr.setEvasion((Integer) jSpinEva.getValue());
        attr.setHealth((Integer) jSpinHP.getValue());
        this.armor.setAttributes(attr);
        this.armor.setName(gTName.getText());
        this.armor.setDescription(gTADesc.getText());
        this.armor.setPrice((Double) jSpinPrice.getValue());
        this.armor.setType(armorTypeModel.getSelectedItem());
        this.armor.setMaterial1(materialModel1.getSelectedItem());
        this.armor.setMaterial2(materialModel2.getSelectedItem());
        this.armor.setEffects(effectModel.getData());
        this.armor.setRestriction(restModel.getData());
        this.armor.calcResistence();
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return <code>boolean</code> Os campos estão todos preenchidos
     * corretamente?
     */
    private boolean validateFields() {
        if (gTName.validateComponent()) {
            if (gCBType.validateComponent()) {
                if (gCBMat1.validateComponent()) {
                    if (gCBMat2.validateComponent()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Adiciona nova restrição
     */
    private void addRestriction() {
        RestrictionType rest = restrictModel.getSelectedItem();
        Restriction restriction = new Restriction(rest.getId(), rest, 0);
        if (!restModel.contains(restriction)) {
            restModel.add(restriction);
        }
    }

    /**
     * Edita a restrição selecionada
     */
    private void editRestriction() {
        if (gTblRestrictions.getSelectedRowCount() > 0) {
            Integer row = (Integer) gTblRestrictions.getSelectedRows()[0];
            RestrictionDialog dialog = new RestrictionDialog(this, restModel.getObject(row), true);
            if (dialog.getRestriction() != null) {
                restModel.update(row, dialog.getRestriction());
            }
        }
    }

    /**
     * Retorna o Modelo das restrições
     *
     * @return <code>RestrictionModel</code> Modelo das restrições
     */
    public RestrictionModel getRestModel() {
        return restModel;
    }

    /**
     * Retorna o Modelo dos efeitos de armaduras
     *
     * @return <code>ArmorEffectModel</code> Modelo dos efeitos de armaduras
     */
    public ArmorEffectModel getEffectModel() {
        return effectModel;
    }

    /**
     * Retorna o Modelo dos Tipos de armaduras
     *
     * @return <code>GComboBoxModel(ArmorType)</code> Tipos de armaduras
     */
    public GComboBoxModel<ArmorType> getArmorTypeModel() {
        return armorTypeModel;
    }

    /**
     * Retorna o Modelo dos Materiais 1
     *
     * @return <code>GComboBoxModel(PrimeMaterial)</code> Materiais 1
     */
    public GComboBoxModel<PrimeMaterial> getMaterialModel1() {
        return materialModel1;
    }

    /**
     * Retorna o Modelo dos Materiais 2
     *
     * @return <code>GComboBoxModel(PrimeMaterial)</code> Materiais 2
     */
    public GComboBoxModel<PrimeMaterial> getMaterialModel2() {
        return materialModel2;
    }

    /**
     * Retorna o ArmorView
     *
     * @return <code>ArmorView</code>
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

        jPCaracteristics = new javax.swing.JPanel();
        jSPEffects = new javax.swing.JScrollPane();
        gTblEffects = new br.com.gmp.comps.table.GTable();
        jBAddEffect = new javax.swing.JButton();
        jBRemoveEffect = new javax.swing.JButton();
        jPBasics = new javax.swing.JPanel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLMat1 = new javax.swing.JLabel();
        gCBMat1 = new br.com.gmp.comps.combobox.GComboBox();
        gCBMat2 = new br.com.gmp.comps.combobox.GComboBox();
        jLMat2 = new javax.swing.JLabel();
        JLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLName = new javax.swing.JLabel();
        jLPrice = new javax.swing.JLabel();
        jSpinPrice = new javax.swing.JSpinner();
        jPRestrictions = new javax.swing.JPanel();
        jSPRestrictions = new javax.swing.JScrollPane();
        gTblRestrictions = new br.com.gmp.comps.table.GTable();
        gCBRest = new br.com.gmp.comps.combobox.GComboBox();
        jSPModifiers = new javax.swing.JScrollPane();
        jPModifiers = new javax.swing.JPanel();
        JLStr = new javax.swing.JLabel();
        jSpinStr = new javax.swing.JSpinner();
        jLDex = new javax.swing.JLabel();
        jSpinDex = new javax.swing.JSpinner();
        jSpinInt = new javax.swing.JSpinner();
        jLInt = new javax.swing.JLabel();
        jSpinChar = new javax.swing.JSpinner();
        jSpinCon = new javax.swing.JSpinner();
        jLChar = new javax.swing.JLabel();
        jLCon = new javax.swing.JLabel();
        jSpinWis = new javax.swing.JSpinner();
        jLWis = new javax.swing.JLabel();
        jSpinEva = new javax.swing.JSpinner();
        jSpinDef = new javax.swing.JSpinner();
        jLEva = new javax.swing.JLabel();
        jLDef = new javax.swing.JLabel();
        jSpinHP = new javax.swing.JSpinner();
        jLHP = new javax.swing.JLabel();
        jBAdd = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jSPDesc = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar armadura");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/P/P_21.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(680, 511));

        jSPEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Efeitos"));

        gTblEffects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gTblEffects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTblEffects.setOpaque(false);
        gTblEffects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gTblEffectsMouseClicked(evt);
            }
        });
        jSPEffects.setViewportView(gTblEffects);

        jBAddEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAddEffect.setFocusable(false);
        jBAddEffect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAddEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddEffectActionPerformed(evt);
            }
        });

        jBRemoveEffect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemoveEffect.setFocusable(false);
        jBRemoveEffect.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemoveEffect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveEffectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCaracteristicsLayout = new javax.swing.GroupLayout(jPCaracteristics);
        jPCaracteristics.setLayout(jPCaracteristicsLayout);
        jPCaracteristicsLayout.setHorizontalGroup(
            jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSPEffects, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
            .addGroup(jPCaracteristicsLayout.createSequentialGroup()
                .addComponent(jBAddEffect)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRemoveEffect)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPCaracteristicsLayout.setVerticalGroup(
            jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCaracteristicsLayout.createSequentialGroup()
                .addComponent(jSPEffects, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCaracteristicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAddEffect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBRemoveEffect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPBasics.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações basicas"));

        jLMat1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat1.setText("Material 1:");

        jLMat2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMat2.setText("Material 2:");

        JLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLType.setText("Tipo:");

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPrice.setText("Preço:");

        jSpinPrice.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), null, Double.valueOf(0.5d)));

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLType)
                            .addComponent(jLName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gTName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMat1)
                            .addComponent(jLMat2)
                            .addComponent(jLPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(gCBMat2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gCBMat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JLType, jLMat1, jLMat2, jLName, jLPrice});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(gCBMat1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBMat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMat2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrice))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBMat1, gCBMat2, gCBType, gTName, jSpinPrice});

        jSPRestrictions.setBorder(javax.swing.BorderFactory.createTitledBorder("Restrições"));

        gTblRestrictions.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gTblRestrictions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTblRestrictions.setOpaque(false);
        gTblRestrictions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gTblRestrictionsMouseClicked(evt);
            }
        });
        jSPRestrictions.setViewportView(gTblRestrictions);

        gCBRest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gCBRestKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPRestrictionsLayout = new javax.swing.GroupLayout(jPRestrictions);
        jPRestrictions.setLayout(jPRestrictionsLayout);
        jPRestrictionsLayout.setHorizontalGroup(
            jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPRestrictionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSPRestrictions, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(gCBRest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPRestrictionsLayout.setVerticalGroup(
            jPRestrictionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestrictionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPRestrictions, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gCBRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSPModifiers.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificadores"));

        JLStr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLStr.setText("FOR:");

        jSpinStr.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLDex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDex.setText("DES:");

        jSpinDex.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jSpinInt.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLInt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLInt.setText("INT:");

        jSpinChar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jSpinCon.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLChar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLChar.setText("CAR:");

        jLCon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCon.setText("CON:");

        jSpinWis.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLWis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLWis.setText("SAB:");

        jSpinEva.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jSpinDef.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLEva.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLEva.setText("EVA:");

        jLDef.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDef.setText("DEF:");

        jSpinHP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jLHP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLHP.setText("HP:");

        javax.swing.GroupLayout jPModifiersLayout = new javax.swing.GroupLayout(jPModifiers);
        jPModifiers.setLayout(jPModifiersLayout);
        jPModifiersLayout.setHorizontalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModifiersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPModifiersLayout.createSequentialGroup()
                        .addComponent(JLStr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinStr, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinDex, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLInt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinInt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPModifiersLayout.createSequentialGroup()
                        .addComponent(jLWis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinWis, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLCon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinCon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLChar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinChar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPModifiersLayout.createSequentialGroup()
                        .addComponent(jLHP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinHP, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDef)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinDef, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLEva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinEva, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSpinChar, jSpinCon, jSpinDef, jSpinDex, jSpinEva, jSpinHP, jSpinInt, jSpinStr, jSpinWis});

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JLStr, jLChar, jLCon, jLDef, jLDex, jLEva, jLHP, jLInt, jLWis});

        jPModifiersLayout.setVerticalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModifiersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLStr)
                    .addComponent(jSpinStr, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDex)
                    .addComponent(jSpinDex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLInt)
                    .addComponent(jSpinInt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLWis)
                    .addComponent(jSpinWis, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCon)
                    .addComponent(jSpinCon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLChar)
                    .addComponent(jSpinChar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLHP)
                    .addComponent(jSpinHP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLDef)
                    .addComponent(jSpinDef, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEva)
                    .addComponent(jSpinEva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPModifiersLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jSpinChar, jSpinCon, jSpinDef, jSpinDex, jSpinEva, jSpinHP, jSpinInt, jSpinStr, jSpinWis});

        jSPModifiers.setViewportView(jPModifiers);

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

        jSPDesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jSPDesc.setViewportView(gTADesc);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSPModifiers)
                            .addComponent(jPBasics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSPDesc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPRestrictions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPCaracteristics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPBasics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSPModifiers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSPDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPCaracteristics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPRestrictions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            buildArmor();
            try {
                view.getBean().add(new BeanEvent(view, armor));
            } catch (Exception ex) {
                Logger.getLogger(ArmorSubView.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBAddEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddEffectActionPerformed
        EffectDialog dialog = new EffectDialog(this, null, true);
        if (dialog.getEffect() != null) {
            effectModel.add(dialog.getEffect());
        }
    }//GEN-LAST:event_jBAddEffectActionPerformed

    private void jBRemoveEffectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveEffectActionPerformed
        new TableUtil(view, gTblEffects, effectModel).remove(null);
    }//GEN-LAST:event_jBRemoveEffectActionPerformed

    private void gTblRestrictionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gTblRestrictionsMouseClicked
        if (evt.getClickCount() == 2) {
            editRestriction();
        }
    }//GEN-LAST:event_gTblRestrictionsMouseClicked

    private void gTblEffectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gTblEffectsMouseClicked
        if (evt.getClickCount() == 2) {
            if (gTblEffects.getSelectedRowCount() > 0) {
                Integer row = (Integer) gTblEffects.getSelectedRows()[0];
                EffectDialog dialog = new EffectDialog(this, effectModel.getObject(row), true);
                if (dialog.getEffect() != null) {
                    effectModel.update(row, dialog.getEffect());
                }
            }
        }
    }//GEN-LAST:event_gTblEffectsMouseClicked

    private void gCBRestKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gCBRestKeyReleased
        addRestriction();
    }//GEN-LAST:event_gCBRestKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLStr;
    private javax.swing.JLabel JLType;
    private br.com.gmp.comps.combobox.GComboBox gCBMat1;
    private br.com.gmp.comps.combobox.GComboBox gCBMat2;
    private br.com.gmp.comps.combobox.GComboBox gCBRest;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTblEffects;
    private br.com.gmp.comps.table.GTable gTblRestrictions;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBAddEffect;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBRemoveEffect;
    private javax.swing.JLabel jLChar;
    private javax.swing.JLabel jLCon;
    private javax.swing.JLabel jLDef;
    private javax.swing.JLabel jLDex;
    private javax.swing.JLabel jLEva;
    private javax.swing.JLabel jLHP;
    private javax.swing.JLabel jLInt;
    private javax.swing.JLabel jLMat1;
    private javax.swing.JLabel jLMat2;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLPrice;
    private javax.swing.JLabel jLWis;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPCaracteristics;
    private javax.swing.JPanel jPModifiers;
    private javax.swing.JPanel jPRestrictions;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JScrollPane jSPEffects;
    private javax.swing.JScrollPane jSPModifiers;
    private javax.swing.JScrollPane jSPRestrictions;
    private javax.swing.JSpinner jSpinChar;
    private javax.swing.JSpinner jSpinCon;
    private javax.swing.JSpinner jSpinDef;
    private javax.swing.JSpinner jSpinDex;
    private javax.swing.JSpinner jSpinEva;
    private javax.swing.JSpinner jSpinHP;
    private javax.swing.JSpinner jSpinInt;
    private javax.swing.JSpinner jSpinPrice;
    private javax.swing.JSpinner jSpinStr;
    private javax.swing.JSpinner jSpinWis;
    // End of variables declaration//GEN-END:variables
}
