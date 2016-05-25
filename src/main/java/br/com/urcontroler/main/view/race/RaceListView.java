package br.com.urcontroler.main.view.race;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.list.dual.GDualList;
import br.com.gmp.comps.list.dual.model.GDualListModel;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.LanguageType;
import br.com.urcontroler.data.entity.Modifier;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.data.entity.Race;
import br.com.urcontroler.data.entity.Skill;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.enums.Dice;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * SubView para controle de raças
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class RaceListView extends View<RaceListBean> implements ListView<Race> {

    private RaceListBean bean;
    private Race editingRace;
    private GComboBoxModel<Alignment> alignmentModel;
    private GComboBoxModel<Dice> diceModel;
    private GDualListModel<ArmorType> armorModel;
    private GDualListModel<WeaponType> weaponModel;
    private GDualListModel<Skill> skillModel;
    private GDualListModel<Perk> perkModel;
    private GDualListModel<LanguageType> langModel;
    private GListModel<Race> model;

    /**
     * Cria nova instancia de RaceSubView
     *
     * @param parent {@code RaceView} Tela das Raças
     */
    public RaceListView(MainScreen parent) {
        super(parent);
        this.initialize();
    }

    /**
     * Método de inicialização
     *
     * @param race {@code Race} Raça
     */
    private void initialize() {
        this.bean = new RaceListBean(this);
        this.setSize(695, 425);
        this.initComponents();
        this.onLoad();
        //----------------------------------------------------------------------
        //Atribuição dos modelos
        this.gCBTendency.setGModel(alignmentModel);
        this.gCBLifeDice.setGModel(diceModel);
        this.gDLArmors.setSourceElements(armorModel);
        this.gDLWeapons.setSourceElements(weaponModel);
        this.gDLSkill.setSourceElements(skillModel);
        this.gDLPerks.setSourceElements(perkModel);
        this.gDLLangs.setSourceElements(langModel);
        this.gListRaces.setModel(model);
        this.setEditingRace(editingRace);
    }

    @Override
    public void onLoad() {
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.diceModel = new GComboBoxModel<>(Dice.values());
        //----------------------------------------------------------------------
        this.armorModel = new GDualListModel<>(bean.getArmorTpList());
        this.weaponModel = new GDualListModel<>(bean.getWeaponTpList());
        this.skillModel = new GDualListModel<>(bean.getSkillList());
        this.perkModel = new GDualListModel<>(bean.getPerkList());
        this.langModel = new GDualListModel<>(bean.getLangTpList());
        //----------------------------------------------------------------------
        this.model = new GListModel<>(bean.getRaceList());
    }

    @Override
    public RaceListBean getBean() {
        return bean;
    }

    @Override
    public void apply() throws Exception {
        if (validateFields()) {
            Race build = build();
            ObjectCopy.copyAll(build, editingRace);
            updateComponent(gListRaces);
        } else {
            LOGGER.log(Level.WARNING, "Campos invalidos.");
        }
    }

    @Override
    public void add() throws Exception {
        Race tmp = buildTemp();
        model.add(tmp);
        editingRace = tmp;
    }

    @Override
    public void remove() throws Exception {
        this.gListRaces.removeSelected();
    }

    @Override
    public Race buildTemp() throws Exception {
        Race tmp = new Race();
        tmp.setAllowedArmors(new ArrayList<ArmorType>());
        tmp.setAllowedWeapons(new ArrayList<WeaponType>());
        tmp.setLifeDice(Dice.D4);
        tmp.setMaturity(0);
        tmp.setMaxAge(0);
        tmp.setMaxHeight(0D);
        tmp.setMinHeight(0D);
        tmp.setMaxWeight(0D);
        tmp.setMinWeight(0D);
        tmp.setModifier(new Modifier(0, 0, 0, 0, 0, 0));
        tmp.setName("");
        tmp.setPerks(new ArrayList<Perk>());
        tmp.setSkills(new ArrayList<Skill>());
        tmp.setTendecy(Alignment.NEUTRAL);
        return tmp;
    }

    @Override
    public GList getList() {
        return gListRaces;
    }

    @Override
    public GListModel<Race> getModel() {
        return model;
    }

    /**
     * Modifica a seleção da lista
     */
    private void changeSelection() {
        setEditingRace((Race) gListRaces.getSelectedValue());
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return {@code boolean} Os campos estão todos preenchidos corretamente?
     * @since 1.0
     */
    private boolean validateFields() {
        if (!gTName.validateComponent()) {
            LOGGER.severe("Nome invalido");
            return false;
        }
        if (!gCBTendency.validateComponent()) {
            LOGGER.severe("Tendencia invalido");
            return false;
        }
        if (!gCBLifeDice.validateComponent()) {
            LOGGER.severe("Dado de vida invalido");
            return false;
        }
        if (!gNMaturity.validateComponent()) {
            LOGGER.severe("Maturidade invalida");
            return false;
        }
        if (!gNLifeExpec.validateComponent()) {
            LOGGER.severe("Expectativa de vida invalida");
            return false;
        }
        return true;
    }

    /**
     * Reconstroi a raça
     *
     * @return {@code Race} Raça reconstruida
     */
    private Race build() {
        Race race = this.editingRace;
        if (race == null) {
            race = new Race();
        }
        if (race.getId() == null) {
            race.setId(bean.getNextID());
        }
        race.setName(gTName.getText());
        race.setTendecy(alignmentModel.getSelectedItem());
        race.setLifeDice(diceModel.getSelectedItem());
        race.setMaturity(gNMaturity.getInteger());
        race.setMaxAge(gNMaturity.getInteger());
        race.setMinHeight((double) jSpnMinHeight.getValue());
        race.setMaxHeight((double) jSpnMaxHeight.getValue());
        race.setMinWeight((double) jSpnMinWeight.getValue());
        race.setMaxWeight((double) jSpnMaxWeight.getValue());
        race.setModifier(modifierPane.getModifier());
        race.setAllowedArmors(gDLArmors.getDestinationData().getList());
        race.setAllowedWeapons(gDLWeapons.getDestinationData().getList());
        race.setSkills(gDLSkill.getDestinationData().getList());
        race.setPerks(gDLPerks.getDestinationData().getList());
        race.setLanguages(gDLLangs.getDestinationData().getList());
        return race;
    }

    /**
     * Retorna a raça da view
     *
     * @return {@code Race} Raça da view
     */
    public Race getEditingRace() {
        return this.editingRace;
    }

    /**
     * Modifica a Raça da view
     *
     * @param race {@code Race} Raça da view
     */
    public void setEditingRace(Race race) {
        try {
            List<ArmorType> armors = bean.getArmorTpList();
            List<WeaponType> weapons = bean.getWeaponTpList();
            List<Skill> skills = bean.getSkillList();
            List<Perk> perks = bean.getPerkList();
            List<LanguageType> langs = bean.getLangTpList();
            if (race != null) {
                this.editingRace = race;
                this.gTName.setText(race.getName());
                if (race.getTendecy() != null) {
                    this.gCBTendency.setSelectedItem(race.getTendecy());
                }
                if (race.getLifeDice() != null) {
                    this.gCBLifeDice.setSelectedItem(race.getLifeDice());
                }
                this.gNMaturity.setInt(race.getMaturity());
                this.gNMaturity.setInt(race.getMaxAge());
                this.jSpnMinHeight.setValue(race.getMinHeight());
                this.jSpnMaxHeight.setValue(race.getMaxHeight());
                this.jSpnMinWeight.setValue(race.getMinWeight());
                this.jSpnMaxWeight.setValue(race.getMaxWeight());
                if (race.getModifier() != null) {
                    this.modifierPane.setModifier(race.getModifier());
                }
            }
            //------------------------------------------------------------------
            List<ArmorType> raceArmors;
            raceArmors = (List<ArmorType>) (race == null ? new ArrayList<>() : race.getAllowedArmors());
            gDLArmors.moveExistent(armors, raceArmors);
            //------------------------------------------------------------------
            List<WeaponType> raceWeapons;
            raceWeapons = (List<WeaponType>) (race == null ? new ArrayList<>() : race.getAllowedWeapons());
            gDLWeapons.moveExistent(weapons, raceWeapons);
            //------------------------------------------------------------------
            List<Skill> raceSkills;
            raceSkills = (List<Skill>) (race == null ? new ArrayList<>() : race.getSkills());
            gDLSkill.moveExistent(skills, raceSkills);
            //------------------------------------------------------------------
            List<Perk> racePerks;
            racePerks = (List<Perk>) (race == null ? new ArrayList<>() : race.getPerks());
            gDLPerks.moveExistent(perks, racePerks);
            //------------------------------------------------------------------
            List<LanguageType> raceLangs;
            raceLangs = (List<LanguageType>) (race == null ? new ArrayList<>() : race.getLanguages());
            gDLLangs.moveExistent(langs, raceLangs);
        } catch (Exception e) {
            throwException(new ViewException(this, e));
        }
    }

    /**
     * Move todos os itens já adicionados para a lista de destino, separando o
     * conteído
     *
     * @param data {@code List} Dados do objeto
     * @param model {@code List} Dados da entidade
     * @param dual {@code GDualList} Lista dupla
     */
    private void moveExistent(List data, List model, GDualList dual) {
        //----------------------------------------------------------------------
        // Cria duas listas auxiliares para contagem
        List contains = new ArrayList();
        List notContains = new ArrayList();
        //----------------------------------------------------------------------
        // Percorre os dados das listas para verificar quais objetos existem em
        // ambas
        for (Object object : data) {
            if (model.contains(object)) {
                contains.add(object);
            } else {
                notContains.add(object);
            }
        }
        //----------------------------------------------------------------------
        // Limpa as listas da lista dupla
        dual.clearDestinationListModel();
        dual.clearSourceListModel();
        //----------------------------------------------------------------------
        // Adiciona os itens das listas auxiliares nas respectivas listas
        dual.setSourceElements(notContains.toArray());
        dual.setDestinationElements(contains.toArray());
    }

    /**
     * Dados gerados automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPBasic = new javax.swing.JPanel();
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLTendency = new javax.swing.JLabel();
        gCBTendency = new br.com.gmp.comps.combobox.GComboBox();
        jLLifeDice = new javax.swing.JLabel();
        gCBLifeDice = new br.com.gmp.comps.combobox.GComboBox();
        jLMaturity = new javax.swing.JLabel();
        gNMaturity = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jLLifeExpec = new javax.swing.JLabel();
        gNLifeExpec = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPInfo = new javax.swing.JPanel();
        jSpnMaxWeight = new javax.swing.JSpinner();
        jLMaxWeight = new javax.swing.JLabel();
        jSpnMinHeight = new javax.swing.JSpinner();
        jLMinHeight = new javax.swing.JLabel();
        jSpnMaxHeight = new javax.swing.JSpinner();
        jLMaxHeight = new javax.swing.JLabel();
        jSpnMinWeight = new javax.swing.JSpinner();
        jLMinWeight = new javax.swing.JLabel();
        modifierPane = new br.com.urcontroler.main.comps.modifier.ModifierPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        gDLSkill = new br.com.gmp.comps.list.dual.GDualList();
        gDLPerks = new br.com.gmp.comps.list.dual.GDualList();
        gDLLangs = new br.com.gmp.comps.list.dual.GDualList();
        gDLArmors = new br.com.gmp.comps.list.dual.GDualList();
        gDLWeapons = new br.com.gmp.comps.list.dual.GDualList();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTADescription = new br.com.gmp.comps.textarea.GTextArea();
        jBApply = new javax.swing.JButton();
        jPList = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd1 = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        gListRaces = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Raças");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1405_@.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(695, 425));
        setMinimumSize(new java.awt.Dimension(695, 425));
        setPreferredSize(new java.awt.Dimension(695, 425));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Raças"));

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLTendency.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLTendency.setText("Tendencia:");

        jLLifeDice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLLifeDice.setText("Dado de Vida:");

        jLMaturity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMaturity.setText("Maturidade:");

        jLLifeExpec.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLLifeExpec.setText("Expec. Vida:");
        jLLifeExpec.setToolTipText("Expectativa de Vida");

        jSpnMaxWeight.setModel(new javax.swing.SpinnerNumberModel(20.0d, 20.0d, 200.0d, 1.0d));
        jSpnMaxWeight.setToolTipText("Variação de peso");

        jLMaxWeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMaxWeight.setText("Peso. Max:");
        jLMaxWeight.setToolTipText("Variação de peso");

        jSpnMinHeight.setModel(new javax.swing.SpinnerNumberModel(100.0d, 100.0d, 250.0d, 1.0d));
        jSpnMinHeight.setToolTipText("Altura em centimetros");

        jLMinHeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMinHeight.setText("Alt. Min:");
        jLMinHeight.setToolTipText("Altura em centimetros");

        jSpnMaxHeight.setModel(new javax.swing.SpinnerNumberModel(100.0d, 100.0d, 250.0d, 1.0d));
        jSpnMaxHeight.setToolTipText("Altura em centimetros");

        jLMaxHeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMaxHeight.setText("Alt. Max:");
        jLMaxHeight.setToolTipText("Altura em centimetros");

        jSpnMinWeight.setModel(new javax.swing.SpinnerNumberModel(20.0d, 20.0d, 200.0d, 1.0d));
        jSpnMinWeight.setToolTipText("Variação de peso");

        jLMinWeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMinWeight.setText("Peso. Min:");
        jLMinWeight.setToolTipText("Variação de peso");

        javax.swing.GroupLayout jPInfoLayout = new javax.swing.GroupLayout(jPInfo);
        jPInfo.setLayout(jPInfoLayout);
        jPInfoLayout.setHorizontalGroup(
            jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMinHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMinHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addGroup(jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMinWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMinWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMaxHeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMaxHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                    .addGroup(jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMaxWeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMaxWeight)))
                .addGap(14, 14, 14))
        );

        jPInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLMaxHeight, jLMaxWeight, jLMinHeight, jLMinWeight});

        jPInfoLayout.setVerticalGroup(
            jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpnMinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMinHeight)
                    .addComponent(jLMaxHeight)
                    .addComponent(jSpnMaxHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpnMinWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMaxWeight)
                    .addComponent(jLMinWeight)
                    .addComponent(jSpnMaxWeight))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Dimensões", jPInfo);
        jTabbedPane3.addTab("Modificadores", modifierPane);

        javax.swing.GroupLayout jPBasicLayout = new javax.swing.GroupLayout(jPBasic);
        jPBasic.setLayout(jPBasicLayout);
        jPBasicLayout.setHorizontalGroup(
            jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicLayout.createSequentialGroup()
                        .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMaturity)
                            .addComponent(jLTendency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPBasicLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(gCBTendency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(13, 13, 13)
                                .addComponent(jLLifeDice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBLifeDice, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(jPBasicLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gNMaturity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLLifeExpec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gNLifeExpec, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPBasicLayout.createSequentialGroup()
                        .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane3)
                            .addGroup(jPBasicLayout.createSequentialGroup()
                                .addComponent(jLName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPBasicLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLMaturity, jLName, jLTendency});

        jPBasicLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLLifeDice, jLLifeExpec});

        jPBasicLayout.setVerticalGroup(
            jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLName)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTendency)
                    .addComponent(gCBTendency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLifeDice)
                    .addComponent(gCBLifeDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMaturity)
                    .addComponent(gNMaturity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLifeExpec)
                    .addComponent(gNLifeExpec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Básico", jPBasic);

        gDLSkill.setDestinationLabelText("Acessivel");
        gDLSkill.setSourceLabelText("Não acessivel");
        jTabbedPane2.addTab("Habilidades", gDLSkill);

        gDLPerks.setDestinationLabelText("Acessivel");
        gDLPerks.setSourceLabelText("Não acessivel");
        jTabbedPane2.addTab("Vantagens", gDLPerks);

        gDLLangs.setDestinationLabelText("Acessivel");
        gDLLangs.setSourceLabelText("Não acessivel");
        jTabbedPane2.addTab("Idiomas", gDLLangs);

        gDLArmors.setDestinationLabelText("Pode utilizar");
        gDLArmors.setSourceLabelText("Não pode utilizar");
        jTabbedPane2.addTab("Armaduras", gDLArmors);

        gDLWeapons.setDestinationLabelText("Pode utilizar");
        gDLWeapons.setSourceLabelText("Não pode utilizar");
        jTabbedPane2.addTab("Armas", gDLWeapons);

        jTabbedPane1.addTab("Modificadores", jTabbedPane2);

        gTADescription.setColumns(20);
        gTADescription.setRows(5);
        jScrollPane1.setViewportView(gTADescription);

        jTabbedPane1.addTab("Descrição", jScrollPane1);

        jBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/button/switch/on.png"))); // NOI18N
        jBApply.setText("Aplicar");
        jBApply.setFocusable(false);
        jBApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBApply)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBApply)
                .addContainerGap())
        );

        jPList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd1.setFocusable(false);
        jBAdd1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAdd1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdd1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jBAdd1);

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

        gListRaces.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gListRacesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(gListRaces);

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdd1ActionPerformed
        try {
            add();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Add Error", ex);
        }
    }//GEN-LAST:event_jBAdd1ActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Delete Error", ex);
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void gListRacesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListRacesValueChanged
        changeSelection();
    }//GEN-LAST:event_gListRacesValueChanged

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        try {
            apply();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Apply Error", ex);
        }
    }//GEN-LAST:event_jBApplyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBLifeDice;
    private br.com.gmp.comps.combobox.GComboBox gCBTendency;
    private br.com.gmp.comps.list.dual.GDualList gDLArmors;
    private br.com.gmp.comps.list.dual.GDualList gDLLangs;
    private br.com.gmp.comps.list.dual.GDualList gDLPerks;
    private br.com.gmp.comps.list.dual.GDualList gDLSkill;
    private br.com.gmp.comps.list.dual.GDualList gDLWeapons;
    private br.com.gmp.comps.list.GList gListRaces;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNLifeExpec;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNMaturity;
    private br.com.gmp.comps.textarea.GTextArea gTADescription;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd1;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JLabel jLLifeDice;
    private javax.swing.JLabel jLLifeExpec;
    private javax.swing.JLabel jLMaturity;
    private javax.swing.JLabel jLMaxHeight;
    private javax.swing.JLabel jLMaxWeight;
    private javax.swing.JLabel jLMinHeight;
    private javax.swing.JLabel jLMinWeight;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLTendency;
    private javax.swing.JPanel jPBasic;
    private javax.swing.JPanel jPInfo;
    private javax.swing.JPanel jPList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpnMaxHeight;
    private javax.swing.JSpinner jSpnMaxWeight;
    private javax.swing.JSpinner jSpnMinHeight;
    private javax.swing.JSpinner jSpnMinWeight;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JToolBar jToolBar1;
    private br.com.urcontroler.main.comps.modifier.ModifierPane modifierPane;
    // End of variables declaration//GEN-END:variables

}
