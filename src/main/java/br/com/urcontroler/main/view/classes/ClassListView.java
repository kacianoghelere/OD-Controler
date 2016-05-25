package br.com.urcontroler.main.view.classes;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.list.dual.model.GDualListModel;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.entity.ClassBase;
import br.com.urcontroler.data.entity.ClassLevel;
import br.com.urcontroler.data.entity.ClassType;
import br.com.urcontroler.data.entity.Expertise;
import br.com.urcontroler.data.entity.ItemType;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.data.entity.Requirement;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.data.enums.Attribute;
import br.com.urcontroler.data.enums.Dice;
import br.com.urcontroler.data.enums.SpellCategory;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.classes.sub.model.ClassLevelModel;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * View para edição de classes.
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
@ViewData(name = "Lista de classes",
        path = "br.com.urcontroler.main.view.classes.ClassListView",
        type = ViewType.LIST)
public class ClassListView extends View<ClassListBean> implements ListView<ClassBase>, TableSource<ClassLevel> {

    private ClassBase editingClassBase;
    private ClassListBean bean;
    private ClassLevelModel levelModel;
    private GComboBoxModel<ClassType> typeModel;
    private GComboBoxModel<Alignment> alignmentModel;
    private GComboBoxModel<Attribute> attrModel;
    private GComboBoxModel<Dice> diceModel;
    private GDualListModel<ArmorType> armorModel;
    private GDualListModel<ItemType> itemModel;
    private GDualListModel<SpellCategory> spellModel;
    private GDualListModel<WeaponType> weaponModel;
    private GDualListModel<Perk> perkModel;
    private GDualListModel<Expertise> expertiseModel;
    private GListModel<ClassBase> model;

    /**
     * Cria nova instancia de ClassSubView
     *
     * @param parent {@code MainScreen} Tela principal
     * @since 1.0
     */
    public ClassListView(MainScreen parent) {
        super(parent);
        initialize();
    }

    /**
     * Método de inicialização
     *
     * @param classBase {@code ClassBase} Classe
     * @since 1.0
     */
    private void initialize() {
        this.setSize(624, 476);
        this.initComponents();
        this.bean = new ClassListBean(this);
        this.onLoad();
        //----------------------------------------------------------------------
        // Atribuição dos modelos
        this.gTblLevels.buildTable(this, 0, levelModel);
        this.gCBDice.setGModel(diceModel);
        this.gCBType.setGModel(typeModel);
        this.gCBAligment.setGModel(alignmentModel);
        this.gCBKeyAttr.setGModel(attrModel);
        this.gDLArmors.setSourceElements(armorModel);
        this.gDLItems.setSourceElements(itemModel);
        this.gDLMagics.setSourceElements(spellModel);
        this.gDLWeapons.setSourceElements(weaponModel);
        this.gDLPerk.setSourceElements(perkModel);
        this.gDLExpertise.setSourceElements(expertiseModel);
        this.setVisible(true);
    }

    @Override
    public void onLoad() {
        this.model = new GListModel<>(bean.getClassBaseList());
        this.levelModel = new ClassLevelModel();
        this.typeModel = new GComboBoxModel<>(bean.getClassTypeList());
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.attrModel = new GComboBoxModel<>(Attribute.values());
        this.diceModel = new GComboBoxModel<>(Dice.values());
        //----------------------------------------------------------------------
        this.armorModel = new GDualListModel<>();
        this.itemModel = new GDualListModel<>();
        this.spellModel = new GDualListModel<>();
        this.weaponModel = new GDualListModel<>();
        this.perkModel = new GDualListModel<>();
        this.expertiseModel = new GDualListModel<>();
    }

    @Override
    public void apply() throws Exception {
        if (validateFields()) {
            ClassBase build = build();
            ObjectCopy.copyAll(build, editingClassBase);
            updateComponent(gListClasses);
        } else {
            LOGGER.log(Level.WARNING, "Campos invalidos.");
        }
    }

    @Override
    public void add() throws Exception {
        ClassBase tmp = buildTemp();
        model.add(tmp);
        editingClassBase = tmp;
    }

    @Override
    public void remove() throws Exception {
//        gListClasses.removeSelected();
    }

    @Override
    public ClassBase buildTemp() throws Exception {
        ClassBase tmp = new ClassBase();
        tmp.setAlignment(Alignment.NEUTRAL);
        tmp.setAllowedArmors(new ArrayList<ArmorType>());
        tmp.setAllowedExpertises(new ArrayList<Expertise>());
        tmp.setAllowedItems(new ArrayList<ItemType>());
        tmp.setAllowedMagic(new ArrayList<SpellCategory>());
        tmp.setAllowedWeapons(new ArrayList<WeaponType>());
        tmp.setArmorBonus(0);
        tmp.setClassLevels(new ArrayList<ClassLevel>());
        tmp.setDescription("");
        tmp.setKeyAttribute(Attribute.STR);
        tmp.setLifeDice(Dice.D4);
        tmp.setName("");
        tmp.setPerks(new ArrayList<Perk>());
        tmp.setRequirement(new Requirement());
        tmp.setType(null);
        return tmp;
    }

    @Override
    public GList getList() {
        return gListClasses;
    }

    @Override
    public GListModel<ClassBase> getModel() {
        return model;
    }

    @Override
    public ClassListBean getBean() {
        return bean;
    }

    /**
     * Método de mudança de seleção
     */
    private void changeSelection() {
        setEditingClass((ClassBase) gListClasses.getSelectedValue());
    }

    @Override
    public List<ClassLevel> getTableData() {
        List<ClassLevel> list = new ArrayList<>();
        if (editingClassBase != null) {
            return editingClassBase.getClassLevels();
        } else {
            Long previous = 0l;
            Long exp = 0l;
            int counter = 0;
            int plus = 1;
            boolean plusLife = false;
            for (int i = 0; i < 20; i++) {
                int next = (i + 1);
                exp = Math.round(previous * 1.5);
                previous = exp;
                plusLife = (next > 9);
                list.add(new ClassLevel(next, exp, plusLife ? plus : next, plusLife, next, (15 - i)));
                if (plusLife) {
                    if (counter == 2) {
                        counter = 0;
                        plus++;
                    } else {
                        counter++;
                    }
                }
            }
        }
        return list;
    }

    /**
     * Retorna a classe que está sendo editada
     *
     * @return {@code ClassBase} Classe
     * @since 1.0
     */
    public ClassBase getEditingClass() {
        return editingClassBase;
    }

    /**
     * Modifica a classe que está sendo editada
     *
     * @param cl {@code ClassBase} Classe
     * @since 1.0
     */
    public void setEditingClass(ClassBase cl) {
        try {
            List<ArmorType> armors = bean.getArmorTypeList();
            List<ItemType> items = bean.getItemTypeList();
            List<SpellCategory> magics = Arrays.asList(SpellCategory.values());
            List<WeaponType> weapons = bean.getWeaponTypeList();
            List<Perk> perks = bean.getPerkList();
            List<Expertise> expertises = bean.getExpertiseList();
            //------------------------------------------------------------------            
            if (cl != null) {
                this.editingClassBase = cl;
                this.gTName.setText(cl.getName());
                if (editingClassBase.getLifeDice() != null) {
                    gCBDice.setSelectedItem(editingClassBase.getLifeDice());
                }
                if (editingClassBase.getType() != null) {
                    gCBType.setSelectedItem(editingClassBase.getType());
                }
                this.gNBonusCA.setInt(editingClassBase.getArmorBonus());
                if (editingClassBase.getKeyAttribute() != null) {
                    gCBKeyAttr.setSelectedItem(editingClassBase.getKeyAttribute());
                }
                if (editingClassBase.getAlignment() != null) {
                    gCBAligment.setSelectedItem(editingClassBase.getAlignment());
                }
                if (editingClassBase.getRequirement() != null) {
                    rPane.setRequirement(editingClassBase.getRequirement());
                }
                if (editingClassBase.getClassLevels() != null) {
                    levelModel.setData(editingClassBase.getClassLevels());
                }
                gTADesc.setText(editingClassBase.getDescription());
            }
            //------------------------------------------------------------------        
            // Organiza a lista de tipos de armaduras
            List<ArmorType> clArmor = (List<ArmorType>) (cl == null
                    ? new ArrayList<>() : cl.getAllowedArmors());
            gDLArmors.moveExistent(armors, clArmor);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de armas
            List<WeaponType> clWeapons = (List<WeaponType>) (cl == null
                    ? new ArrayList<>() : cl.getAllowedWeapons());
            gDLWeapons.moveExistent(weapons, clWeapons);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de itens
            List<ItemType> clItems = (List<ItemType>) (cl == null
                    ? new ArrayList<>() : cl.getAllowedItems());
            gDLItems.moveExistent(items, clItems);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de magias
            List<SpellCategory> clMagic = (List<SpellCategory>) (cl == null
                    ? new ArrayList<>() : cl.getAllowedMagic());
            gDLMagics.moveExistent(magics, clMagic);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de vantagens
            List<Perk> clPerks = (List<Perk>) (cl == null
                    ? new ArrayList<>() : cl.getPerks());
            gDLPerk.moveExistent(perks, clPerks);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de vantagens
            List<Expertise> clExpertise = (List<Expertise>) (cl == null
                    ? new ArrayList<>() : cl.getAllowedExpertises());
            gDLExpertise.moveExistent(expertises, clExpertise);
            //------------------------------------------------------------------            
        } catch (Exception e) {
            throwException(new ViewException(this, e));
        }
    }

    /**
     * Constroi os dados na classe
     *
     * @return {@code ClassBase} Classe de personagem
     * @since 1.0
     */
    private ClassBase build() {
        ClassBase cl = this.editingClassBase;
        if (cl == null) {
            cl = new ClassBase();
        }
        if (cl.getId() == null) {
            cl.setId(bean.getNextID());
        }
        cl.setName(gTName.getText());
        cl.setLifeDice(diceModel.getSelectedItem());
        cl.setType(typeModel.getSelectedItem());
        cl.setArmorBonus(gNBonusCA.getInteger());
        cl.setKeyAttribute(attrModel.getSelectedItem());
        cl.setAlignment(alignmentModel.getSelectedItem());
        cl.setRequirement(rPane.getRequirement());
        cl.setClassLevels(levelModel.getData());
        cl.setAllowedArmors(gDLArmors.getDestinationData().getList());
        cl.setAllowedWeapons(gDLWeapons.getDestinationData().getList());
        cl.setAllowedItems(gDLItems.getDestinationData().getList());
        cl.setAllowedMagic(gDLMagics.getDestinationData().getList());
        cl.setPerks(gDLPerk.getDestinationData().getList());
        cl.setAllowedExpertises(gDLExpertise.getDestinationData().getList());
        cl.setDescription(gTADesc.getText());
        return cl;
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
        if (!gCBDice.validateComponent()) {
            System.out.println("Dado de vida invalido");
            return false;
        }
        if (!gCBType.validateComponent()) {
            System.out.println("Tipo invalido");
            return false;
        }
        if (!gCBKeyAttr.validateComponent()) {
            System.out.println("Atributo chave invalido");
            return false;
        }
        if (!gCBAligment.validateComponent()) {
            System.out.println("Alinhamento invalido");
            return false;
        }
        return true;
    }

    /**
     * Retorna o Modelo dos Tipos de classes
     *
     * @return {@code GComboBoxModel(ClassType)} Tipos de classes
     * @since 1.0
     */
    public GComboBoxModel<ClassType> getClassTypeModel() {
        return typeModel;
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

        bGEvolution = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
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
        rPane = new br.com.urcontroler.main.comps.requirement.RequirementPane();
        jTBModifiers = new javax.swing.JTabbedPane();
        gDLArmors = new br.com.gmp.comps.list.dual.GDualList();
        gDLWeapons = new br.com.gmp.comps.list.dual.GDualList();
        gDLItems = new br.com.gmp.comps.list.dual.GDualList();
        gDLMagics = new br.com.gmp.comps.list.dual.GDualList();
        gDLExpertise = new br.com.gmp.comps.list.dual.GDualList();
        gDLPerk = new br.com.gmp.comps.list.dual.GDualList();
        jPLevels = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTblLevels = new br.com.gmp.comps.table.GTable();
        jBRecharge = new javax.swing.JButton();
        jSPDesc = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jLTitle = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        jBApply = new javax.swing.JButton();
        jPList = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        gListClasses = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Classes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/status/avenge.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(830, 495));
        setMinimumSize(new java.awt.Dimension(830, 495));
        setPreferredSize(new java.awt.Dimension(830, 495));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                                .addComponent(gCBKeyAttr, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))))
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

        gDLExpertise.setDestinationLabelText("Pode utilizar");
        gDLExpertise.setSourceLabelText("Não pode utilizar");
        jTBModifiers.addTab("Perícias", new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1215_.png")), gDLExpertise); // NOI18N

        gDLPerk.setDestinationLabelText("Pode utilizar");
        gDLPerk.setSourceLabelText("Não pode utilizar");
        jTBModifiers.addTab("Vantagens", new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1390_@.png")), gDLPerk); // NOI18N

        jTPConfigs.addTab("Modificadores", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1247_.png")), jTBModifiers); // NOI18N

        gTblLevels.setAutoscrolls(false);
        jScrollPane1.setViewportView(gTblLevels);

        jBRecharge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jBRecharge.setText("Recarregar");

        javax.swing.GroupLayout jPLevelsLayout = new javax.swing.GroupLayout(jPLevels);
        jPLevels.setLayout(jPLevelsLayout);
        jPLevelsLayout.setHorizontalGroup(
            jPLevelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPLevelsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBRecharge)
                .addContainerGap())
        );
        jPLevelsLayout.setVerticalGroup(
            jPLevelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPLevelsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBRecharge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
        );

        jTPConfigs.addTab("Niveis", new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1393_@.png")), jPLevels); // NOI18N

        gTADesc.setColumns(20);
        gTADesc.setLineWrap(true);
        gTADesc.setRows(5);
        jSPDesc.setViewportView(gTADesc);

        jTPConfigs.addTab("Descrição", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png")), jSPDesc); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLTitle.setText("Editar Classes");
        jToolBar1.add(jLTitle);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/button/switch/on.png"))); // NOI18N
        jBApply.setText("Aplicar");
        jBApply.setFocusable(false);
        jBApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });
        jToolBar2.add(jBApply);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTPConfigs)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTPConfigs, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setFocusable(false);
        jBAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar3.add(jBAdd);

        jBDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/minus.png"))); // NOI18N
        jBDelete.setFocusable(false);
        jBDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });
        jToolBar3.add(jBDelete);

        gListClasses.setBorder(null);
        gListClasses.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gListClassesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(gListClasses);

        javax.swing.GroupLayout jPListLayout = new javax.swing.GroupLayout(jPList);
        jPList.setLayout(jPListLayout);
        jPListLayout.setHorizontalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPListLayout.setVerticalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPListLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addGap(0, 0, 0)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        try {
            apply();
        } catch (Exception ex) {
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

    private void gListClassesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListClassesValueChanged
        changeSelection();
    }//GEN-LAST:event_gListClassesValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGEvolution;
    private br.com.gmp.comps.combobox.GComboBox gCBAligment;
    private br.com.gmp.comps.combobox.GComboBox gCBDice;
    private br.com.gmp.comps.combobox.GComboBox gCBKeyAttr;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.dual.GDualList gDLArmors;
    private br.com.gmp.comps.list.dual.GDualList gDLExpertise;
    private br.com.gmp.comps.list.dual.GDualList gDLItems;
    private br.com.gmp.comps.list.dual.GDualList gDLMagics;
    private br.com.gmp.comps.list.dual.GDualList gDLPerk;
    private br.com.gmp.comps.list.dual.GDualList gDLWeapons;
    private br.com.gmp.comps.list.GList gListClasses;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNBonusCA;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTblLevels;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBRecharge;
    private javax.swing.JLabel jLAligment;
    private javax.swing.JLabel jLBonusCA;
    private javax.swing.JLabel jLDice;
    private javax.swing.JLabel jLKeyAttr;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPLevels;
    private javax.swing.JPanel jPList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTBModifiers;
    private javax.swing.JTabbedPane jTPConfigs;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private br.com.urcontroler.main.comps.requirement.RequirementPane rPane;
    // End of variables declaration//GEN-END:variables

}
