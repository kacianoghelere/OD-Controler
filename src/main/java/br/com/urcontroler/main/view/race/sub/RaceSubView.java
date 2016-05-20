package br.com.urcontroler.main.view.race.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.dual.GDualList;
import br.com.gmp.comps.list.dual.model.GDualListModel;
import br.com.urcontroler.data.db.dao.ArmorTypeDAO;
import br.com.urcontroler.data.db.dao.LanguageTypeDAO;
import br.com.urcontroler.data.db.dao.PerkDAO;
import br.com.urcontroler.data.db.dao.SkillDAO;
import br.com.urcontroler.data.db.dao.WeaponTypeDAO;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.LanguageType;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.data.entity.Race;
import br.com.urcontroler.data.entity.Skill;
import br.com.urcontroler.data.entity.WeaponType;
import br.com.urcontroler.data.enums.Alignment;
import br.com.urcontroler.data.enums.Dice;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.race.*;
import br.com.urcontroler.main.view.sub.SubView;
import java.util.ArrayList;
import java.util.List;

/**
 * SubView para controle de raças
 *
 * @author kaciano
 * @version 1.0
 */
public class RaceSubView extends SubView {

    private final RaceView view;
    private RaceBean bean;
    private Race race;
    private GComboBoxModel<Alignment> alignmentModel;
    private GComboBoxModel<Dice> diceModel;
    private GDualListModel<ArmorType> armorModel;
    private GDualListModel<WeaponType> weaponModel;
    private GDualListModel<Skill> skillModel;
    private GDualListModel<Perk> perkModel;
    private GDualListModel<LanguageType> langModel;

    /**
     * Cria nova instancia de RaceSubView
     *
     * @param parent {@code RaceView} Tela das Raças
     * @param race {@code Race} Raça
     */
    public RaceSubView(RaceView parent, Race race) {
        super(parent);
        this.view = parent;
        this.initialize(race);
    }

    /**
     * Método de inicialização
     *
     * @param race {@code Race} Raça
     */
    private void initialize(Race race) {
        this.bean = view.getBean();
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
        this.setRace(race);
    }

    @Override
    public void onLoad() {
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        this.diceModel = new GComboBoxModel<>(Dice.values());
        //----------------------------------------------------------------------
        this.armorModel = new GDualListModel<>();
        this.weaponModel = new GDualListModel<>();
        this.skillModel = new GDualListModel<>();
        this.perkModel = new GDualListModel<>();
        this.langModel = new GDualListModel<>();
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
     * Move todos os itens já adicionados para a lista de destino, separando o
     * conteído
     *
     * @param data {@code List} Dados do objeto
     * @param model {@code List} Dados da entidade
     * @param dual {@code GDualList} Lista dupla
     */
    private void moveExistent(List data, List model, GDualList dual) {
        List contains = new ArrayList();
        List notContains = new ArrayList();
        for (Object object : data) {
            if (model.contains(object)) {
                contains.add(object);
            } else {
                notContains.add(object);
            }
        }
        dual.clearDestinationListModel();
        dual.clearSourceListModel();
        dual.setSourceElements(notContains.toArray());
        dual.setDestinationElements(contains.toArray());
    }

    /**
     * Reconstroi a raça
     */
    private void build() {
        if (race == null) {
            this.race = new Race();
        }
        if (race.getId() == null) {
            this.race.setId(bean.getNextID());
        }
        this.race.setName(gTName.getText());
        this.race.setTendecy(alignmentModel.getSelectedItem());
        this.race.setLifeDice(diceModel.getSelectedItem());
        this.race.setMaturity(gNMaturity.getInteger());
        this.race.setMaxAge(gNMaturity.getInteger());
        this.race.setMinHeight((double) jSpnMinHeight.getValue());
        this.race.setMaxHeight((double) jSpnMaxHeight.getValue());
        this.race.setMinWeight((double) jSpnMinWeight.getValue());
        this.race.setMaxWeight((double) jSpnMaxWeight.getValue());
        this.race.setModifier(modifierPane.getModifier());
        this.race.setAllowedArmors(gDLArmors.getDestinationData().getList());
        this.race.setAllowedWeapons(gDLWeapons.getDestinationData().getList());
        this.race.setSkills(gDLSkill.getDestinationData().getList());
        this.race.setPerks(gDLPerks.getDestinationData().getList());
        this.race.setLanguages(gDLLangs.getDestinationData().getList());
    }

    /**
     * Retorna a raça da view
     *
     * @return {@code Race} Raça da view
     */
    public Race getRace() {
        return this.race;
    }

    /**
     * Modifica a Raça da view
     *
     * @param race {@code Race} Raça da view
     */
    public void setRace(Race race) {
        try {
            List<ArmorType> armors = new ArmorTypeDAO().getList();
            List<WeaponType> weapons = new WeaponTypeDAO().getList();
            List<Skill> skills = new SkillDAO().getList();
            List<Perk> perks = new PerkDAO().getList();
            List<LanguageType> langs = new LanguageTypeDAO().getList();
            if (race != null) {
                this.race = race;
                this.gTName.setText(race.getName());
                this.gCBTendency.setSelectedItem(race.getTendecy());
                this.gCBLifeDice.setSelectedItem(race.getLifeDice());
                this.gNMaturity.setInt(race.getMaturity());
                this.gNMaturity.setInt(race.getMaxAge());
                this.jSpnMinHeight.setValue(race.getMinHeight());
                this.jSpnMaxHeight.setValue(race.getMaxHeight());
                this.jSpnMinWeight.setValue(race.getMinWeight());
                this.jSpnMaxWeight.setValue(race.getMaxWeight());
                this.modifierPane.setModifier(race.getModifier());
            }
            //------------------------------------------------------------------        
            // Organiza a lista de tipos de armaduras
            List<ArmorType> raceArmors = (List<ArmorType>) (race == null
                    ? new ArrayList<>() : race.getAllowedArmors());
            moveExistent(armors, raceArmors, gDLArmors);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de armas
            List<WeaponType> raceWeapons = (List<WeaponType>) (race == null
                    ? new ArrayList<>() : race.getAllowedWeapons());
            moveExistent(weapons, raceWeapons, gDLWeapons);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de habilidades
            List<Skill> raceSkills = (List<Skill>) (race == null
                    ? new ArrayList<>() : race.getSkills());
            moveExistent(skills, raceSkills, gDLSkill);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de vantagens
            List<Perk> racePerks = (List<Perk>) (race == null
                    ? new ArrayList<>() : race.getPerks());
            moveExistent(perks, racePerks, gDLPerks);
            //------------------------------------------------------------------            
            // Organiza a lista de tipos de idiomas
            List<LanguageType> raceLangs = (List<LanguageType>) (race == null
                    ? new ArrayList<>() : race.getLanguages());
            moveExistent(langs, raceLangs, gDLLangs);
        } catch (Exception e) {
            throwException(new ViewException(view, e));
        }
    }

    /**
     * Dados gerados automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBCancel = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPBasic = new javax.swing.JPanel();
        modifierPane = new br.com.urcontroler.main.comps.modifier.ModifierPane();
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
        jPInfo = new javax.swing.JPanel();
        jSpnMinHeight = new javax.swing.JSpinner();
        jLMinHeight = new javax.swing.JLabel();
        jSpnMaxHeight = new javax.swing.JSpinner();
        jLMaxHeight = new javax.swing.JLabel();
        jSpnMinWeight = new javax.swing.JSpinner();
        jLMinWeight = new javax.swing.JLabel();
        jSpnMaxWeight = new javax.swing.JSpinner();
        jLMaxWeight = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        gDLSkill = new br.com.gmp.comps.list.dual.GDualList();
        gDLPerks = new br.com.gmp.comps.list.dual.GDualList();
        gDLLangs = new br.com.gmp.comps.list.dual.GDualList();
        gDLArmors = new br.com.gmp.comps.list.dual.GDualList();
        gDLWeapons = new br.com.gmp.comps.list.dual.GDualList();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTADescription = new br.com.gmp.comps.textarea.GTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar raças");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1405_@.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(685, 383));
        setMinimumSize(new java.awt.Dimension(685, 383));
        setPreferredSize(new java.awt.Dimension(685, 383));

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

        jPInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações"));

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

        jSpnMaxWeight.setModel(new javax.swing.SpinnerNumberModel(20.0d, 20.0d, 200.0d, 1.0d));
        jSpnMaxWeight.setToolTipText("Variação de peso");

        jLMaxWeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMaxWeight.setText("Peso. Max:");
        jLMaxWeight.setToolTipText("Variação de peso");

        javax.swing.GroupLayout jPInfoLayout = new javax.swing.GroupLayout(jPInfo);
        jPInfo.setLayout(jPInfoLayout);
        jPInfoLayout.setHorizontalGroup(
            jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMinHeight, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMinHeight))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMaxHeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMaxHeight))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMinWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMinWeight))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInfoLayout.createSequentialGroup()
                        .addComponent(jLMaxWeight)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnMaxWeight)))
                .addContainerGap())
        );

        jPInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLMaxHeight, jLMaxWeight, jLMinHeight, jLMinWeight});

        jPInfoLayout.setVerticalGroup(
            jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpnMinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMinHeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpnMaxHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMaxHeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpnMinWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMinWeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpnMaxWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMaxWeight))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPBasicLayout = new javax.swing.GroupLayout(jPBasic);
        jPBasic.setLayout(jPBasicLayout);
        jPBasicLayout.setHorizontalGroup(
            jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBasicLayout.createSequentialGroup()
                        .addComponent(jLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(modifierPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPBasicLayout.createSequentialGroup()
                        .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMaturity)
                            .addComponent(jLTendency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gNMaturity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gCBTendency, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLLifeDice)
                            .addComponent(jLLifeExpec, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gNLifeExpec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gCBLifeDice, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPBasicLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLMaturity, jLName, jLTendency});

        jPBasicLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLLifeDice, jLLifeExpec});

        jPBasicLayout.setVerticalGroup(
            jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBasicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPBasicLayout.createSequentialGroup()
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
                        .addComponent(modifierPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                if (race == null) {
                    System.out.println("Criando nova raça...");
                    build();
                    view.getBean().add(new BeanEvent(view, race));
                } else {
                    System.out.println("Atualizando raça...");
                    build();
                    view.getBean().update(race);
                }
                this.dispose();
            } catch (Exception ex) {
                throwException(new ViewException(view, ex));
                this.dispose();
            }
        } else {
            LOGGER.warning("Erro na validação dos campos.");
        }
    }//GEN-LAST:event_jBAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBLifeDice;
    private br.com.gmp.comps.combobox.GComboBox gCBTendency;
    private br.com.gmp.comps.list.dual.GDualList gDLArmors;
    private br.com.gmp.comps.list.dual.GDualList gDLLangs;
    private br.com.gmp.comps.list.dual.GDualList gDLPerks;
    private br.com.gmp.comps.list.dual.GDualList gDLSkill;
    private br.com.gmp.comps.list.dual.GDualList gDLWeapons;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNLifeExpec;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNMaturity;
    private br.com.gmp.comps.textarea.GTextArea gTADescription;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpnMaxHeight;
    private javax.swing.JSpinner jSpnMaxWeight;
    private javax.swing.JSpinner jSpnMinHeight;
    private javax.swing.JSpinner jSpnMinWeight;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private br.com.urcontroler.main.comps.modifier.ModifierPane modifierPane;
    // End of variables declaration//GEN-END:variables
}
