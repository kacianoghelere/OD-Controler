package br.com.urcontroler.main.view.spell;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.urcontroler.data.entity.ElementType;
import br.com.urcontroler.data.entity.Spell;
import br.com.urcontroler.data.entity.SpellType;
import br.com.urcontroler.data.enums.SpellCategory;
import br.com.urcontroler.data.enums.SpellClass;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.ListView;
import java.util.logging.Level;

/**
 * View para controle de magias
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
@ViewData(name = "Lista de magias",
        path = "br.com.urcontroler.main.view.spell.SpellListView",
        type = ViewType.LIST)
public class SpellListView extends View<SpellListBean> implements ListView<Spell> {

    private SpellListBean bean;
    private Spell editingSpell;
    private GComboBoxModel<SpellType> typeModel;
    private GComboBoxModel<SpellClass> classModel;
    private GComboBoxModel<SpellCategory> categoryModel;
    private GComboBoxModel<ElementType> elementModel;
    private GListModel<Spell> model;

    /**
     * Cria nova instancia de SpellListView
     *
     * @param parent {@code MainScreen} Tela principal
     */
    public SpellListView(MainScreen parent) {
        super(parent);
        this.initialize();
    }

    /**
     * Método de inicialização
     *
     * @param spell {@code Spell} Magia
     */
    private void initialize() {
        this.setSize(605, 410);
        this.bean = new SpellListBean(this);
        this.initComponents();
        this.onLoad();
        this.gListSpells.setModel(model);
        this.gCBType.setGModel(typeModel);
        this.gCBCategory.setGModel(categoryModel);
        this.gCBClass.setGModel(classModel);
        this.gCBElement.setGModel(elementModel);
    }

    @Override
    public void onLoad() {
        this.model = new GListModel<>(bean.getSpellList());
        this.typeModel = new GComboBoxModel<>(bean.getSpellTypeList());
        this.classModel = new GComboBoxModel<>(SpellClass.values());
        this.categoryModel = new GComboBoxModel<>(SpellCategory.values());
        this.elementModel = new GComboBoxModel<>(bean.getElementTypeList());
        this.elementModel.getData().add(0, new ElementType());
    }

    @Override
    public SpellListBean getBean() {
        return this.bean;
    }

    @Override
    public void apply() throws Exception {
        if (validateFields()) {
            Spell build = build();
            ObjectCopy.copyAll(build, editingSpell);
            updateComponent(gListSpells);
        } else {
            LOGGER.log(Level.WARNING, "Campos invalidos.");
        }
    }

    @Override
    public void add() throws Exception {
        Spell tmp = buildTemp();
        model.add(tmp);
        editingSpell = tmp;
    }

    @Override
    public void remove() throws Exception {
        gListSpells.removeSelected();
    }

    @Override
    public Spell buildTemp() throws Exception {
        Spell tmp = new Spell();
        tmp.setName("");
        tmp.setCategory(SpellCategory.ILLUSION);
        tmp.setClassification(SpellClass.NOVICE);
        tmp.setDescription("");
        tmp.setDuration("");
        tmp.setMagicCost(0);
        tmp.setRange(title);
        return tmp;
    }

    @Override
    public GList getList() {
        return gListSpells;
    }

    @Override
    public GListModel<Spell> getModel() {
        return model;
    }

    /**
     * Método de mudança de seleção
     */
    private void changeSelection() {
        setEditingSpell((Spell) gListSpells.getSelectedValue());
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
        if (!gCBType.validateComponent()) {
            LOGGER.severe("Tipo invalido");
            return false;
        }
        if (!gCBClass.validateComponent()) {
            LOGGER.severe("Classificação invalida");
            return false;
        }
        if (!gCBCategory.validateComponent()) {
            LOGGER.severe("Categoria invalida");
            return false;
        }
        if (!gTRange.validateComponent()) {
            LOGGER.severe("Alcance invalido");
            return false;
        }
        if (!gTDuration.validateComponent()) {
            LOGGER.severe("Duração invalida");
            return false;
        }
        if (!gTADesc.validateText()) {
            LOGGER.severe("Descrição invalida");
            return false;
        }
        return true;
    }

    /**
     * Reconstroi a magia
     *
     * @return {@code Spell} Magia reconstruida
     */
    private Spell build() {
        Spell spell = editingSpell;
        if (spell == null) {
            spell = new Spell();
        }
        if (spell.getId() == null) {
            spell.setId(bean.getNextID());
        }
        spell.setName(gTName.getText());
        spell.setType(typeModel.getSelectedItem());
        spell.setClassification(classModel.getSelectedItem());
        spell.setCategory(categoryModel.getSelectedItem());
        ElementType element = elementModel.getSelectedItem();
        spell.setElementType(element.getId() != null ? element : null);
        spell.setMagicCost(gNCost.getInteger());
        spell.setRange(gTRange.getText());
        spell.setDuration(gTDuration.getText());
        spell.setDescription(gTADesc.getText());
        return spell;
    }

    /**
     * Retorna a magia da view
     *
     * @return {@code Spell} Magia da view
     */
    public Spell getEditingSpell() {
        return this.editingSpell;
    }

    /**
     * Modifica a Magia da view
     *
     * @param spell {@code Spell} Magia da view
     */
    public void setEditingSpell(Spell spell) {
        try {
            if (spell != null) {
                this.editingSpell = spell;
                this.gTName.setText(spell.getName());
                if (spell.getType() != null) {
                    this.gCBType.setSelectedItem(spell.getType());
                }
                if (spell.getCategory() != null) {
                    this.gCBCategory.setSelectedItem(spell.getCategory());
                }
                if (spell.getClassification() != null) {
                    this.gCBClass.setSelectedItem(spell.getClassification());
                }
                if (spell.getElementType() != null) {
                    this.gCBElement.setSelectedItem(spell.getElementType());
                }
                this.gNCost.setInt(spell.getMagicCost());
                this.gTRange.setText(spell.getRange());
                this.gTDuration.setText(spell.getDuration());
                this.gTADesc.setText(spell.getDescription());
            }
        } catch (Exception e) {
            throwException(new ViewException(this, e));
        }
    }

    /**
     * Retorna o modelo dos Tipos de magias
     *
     * @return {@code GComboBoxModel(SpellType)} Tipos de magias
     * @since 1.0
     */
    public GComboBoxModel<SpellType> getSpellTypeModel() {
        return typeModel;
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
        gListSpells = new br.com.gmp.comps.list.GList();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jLTitle = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        jBApply = new javax.swing.JButton();
        jTabs = new javax.swing.JTabbedPane();
        jPBasics = new javax.swing.JPanel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLName = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLType = new javax.swing.JLabel();
        gTRange = new br.com.gmp.comps.textfield.GTextField();
        jLRange = new javax.swing.JLabel();
        gTDuration = new br.com.gmp.comps.textfield.GTextField();
        jLLength = new javax.swing.JLabel();
        jLCategory = new javax.swing.JLabel();
        gCBCategory = new br.com.gmp.comps.combobox.GComboBox();
        gCBClass = new br.com.gmp.comps.combobox.GComboBox();
        jLClass = new javax.swing.JLabel();
        gNCost = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jLCost = new javax.swing.JLabel();
        gCBElement = new br.com.gmp.comps.combobox.GComboBox();
        jLElement = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Magias");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1399_@.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(605, 410));
        setMinimumSize(new java.awt.Dimension(605, 410));
        setPreferredSize(new java.awt.Dimension(605, 410));

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

        gListSpells.setBorder(null);
        gListSpells.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gListSpellsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(gListSpells);

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
                .addComponent(jScrollPane3)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jLTitle.setText("Editar Magias");
        jToolBar2.add(jLTitle);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/button/switch/on.png"))); // NOI18N
        jBApply.setText("Aplicar");
        jBApply.setFocusable(false);
        jBApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });
        jToolBar3.add(jBApply);

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLType.setText("Tipo:");

        jLRange.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLRange.setText("Alcance:");

        jLLength.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLLength.setText("Duração:");

        jLCategory.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCategory.setText("Categoria:");

        jLClass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLClass.setText("Classificação:");

        jLCost.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCost.setText("Custo de Magia:");

        jLElement.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLElement.setText("Elemento:");

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLRange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLLength, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gTDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(gCBCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gTRange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLCost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPBasicsLayout.createSequentialGroup()
                                .addComponent(gNCost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLElement)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBElement, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLCategory, jLClass, jLCost, jLLength, jLName, jLRange, jLType});

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gCBCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gNCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCost)
                    .addComponent(gCBElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLElement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTRange, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLRange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLength))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBClass, gCBElement, gCBType, gTName, jLCategory, jLClass, jLCost, jLLength, jLName, jLRange, jLType});

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBCategory, gTDuration});

        jTabs.addTab("Configurações Básicas", jPBasics);

        gTADesc.setColumns(20);
        gTADesc.setLineWrap(true);
        gTADesc.setRows(5);
        jScrollPane2.setViewportView(gTADesc);

        jTabs.addTab("Descrição", jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabs)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void gListSpellsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListSpellsValueChanged
        changeSelection();
    }//GEN-LAST:event_gListSpellsValueChanged

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        try {
            apply();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Apply Error", ex);
        }
    }//GEN-LAST:event_jBApplyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBCategory;
    private br.com.gmp.comps.combobox.GComboBox gCBClass;
    private br.com.gmp.comps.combobox.GComboBox gCBElement;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.GList gListSpells;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNCost;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTDuration;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.textfield.GTextField gTRange;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JLabel jLCategory;
    private javax.swing.JLabel jLClass;
    private javax.swing.JLabel jLCost;
    private javax.swing.JLabel jLElement;
    private javax.swing.JLabel jLLength;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLRange;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabs;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    // End of variables declaration//GEN-END:variables

}
