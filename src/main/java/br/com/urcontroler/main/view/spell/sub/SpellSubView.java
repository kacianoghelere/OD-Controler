package br.com.urcontroler.main.view.spell.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.urcontroler.data.db.dao.ElementTypeDAO;
import br.com.urcontroler.data.db.dao.SpellTypeDAO;
import br.com.urcontroler.data.entity.ElementType;
import br.com.urcontroler.data.entity.Spell;
import br.com.urcontroler.data.entity.SpellType;
import br.com.urcontroler.data.enums.SpellCategory;
import br.com.urcontroler.data.enums.SpellClass;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.spell.SpellView;
import br.com.urcontroler.main.view.spell.SpellBean;
import br.com.urcontroler.main.view.sub.SubView;

/**
 * SubView para controle de magias
 *
 * @author kaciano
 * @version 1.0
 */
public class SpellSubView extends SubView {

    private SpellView view;
    private SpellBean bean;
    private Spell spell;
    private GComboBoxModel<SpellType> typeModel;
    private GComboBoxModel<SpellClass> classModel;
    private GComboBoxModel<SpellCategory> categoryModel;
    private GComboBoxModel<ElementType> elementModel;

    /**
     * Cria nova instancia de SpellSubView
     *
     * @param parent {@code SpellView} Tela das Magias
     * @param spell {@code Spell} Magia
     */
    public SpellSubView(SpellView parent, Spell spell) {
        super(parent);
        this.view = parent;
        this.initialize(spell);
    }

    /**
     * Método de inicialização
     *
     * @param spell {@code Spell} Magia
     */
    private void initialize(Spell spell) {
        this.setSize(458, 380);
        this.bean = view.getBean();
        this.initComponents();
        this.onLoad();
        this.gCBType.setGModel(typeModel);
        this.gCBCategory.setGModel(categoryModel);
        this.gCBClass.setGModel(classModel);
        this.gCBElement.setGModel(elementModel);
        //----------------------------------------------------------------------
        this.setSpell(spell);
    }

    @Override
    public void onLoad() {
        this.typeModel = new GComboBoxModel<>(new SpellTypeDAO().getList());
        this.classModel = new GComboBoxModel<>(SpellClass.values());
        this.categoryModel = new GComboBoxModel<>(SpellCategory.values());
        this.elementModel = new GComboBoxModel<>(new ElementTypeDAO().getList());
        this.elementModel.getData().add(0, new ElementType());
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
     */
    private void build() {
        if (spell == null) {
            this.spell = new Spell();
        }
        if (spell.getId() == null) {
            this.spell.setId(bean.getNextID());
        }
        this.spell.setName(gTName.getText());
        this.spell.setType(typeModel.getSelectedItem());
        this.spell.setClassification(classModel.getSelectedItem());
        this.spell.setCategory(categoryModel.getSelectedItem());
        ElementType element = elementModel.getSelectedItem();
        this.spell.setElementType(element.getId() != null ? element : null);
        this.spell.setMagicCost(gNCost.getInteger());
        this.spell.setRange(gTRange.getText());
        this.spell.setDuration(gTDuration.getText());
        this.spell.setDescription(gTADesc.getText());
    }

    /**
     * Retorna a magia da view
     *
     * @return {@code Spell} Magia da view
     */
    public Spell getSpell() {
        return this.spell;
    }

    /**
     * Modifica a Magia da view
     *
     * @param spell {@code Spell} Magia da view
     */
    public void setSpell(Spell spell) {
        try {
            if (spell != null) {
                this.spell = spell;
                this.gTName.setText(spell.getName());
                this.gCBType.setSelectedItem(spell.getType());
                this.gCBCategory.setSelectedItem(spell.getCategory());
                this.gCBClass.setSelectedItem(spell.getClassification());
                this.gCBElement.setSelectedItem(spell.getElementType());
                this.gNCost.setInt(spell.getMagicCost());
                this.gTRange.setText(spell.getRange());
                this.gTDuration.setText(spell.getDuration());
                this.gTADesc.setText(spell.getDescription());
            }
        } catch (Exception e) {
            throwException(new ViewException(view, e));
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
        jBCancel = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar magias");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1399_@.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(458, 380));
        setMinimumSize(new java.awt.Dimension(458, 380));
        setPreferredSize(new java.awt.Dimension(458, 380));

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
                            .addComponent(gTDuration, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
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
                                .addComponent(gCBElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                if (spell == null) {
                    System.out.println("Criando nova magia...");
                    build();
                    view.getBean().add(new BeanEvent(view, spell));
                } else {
                    System.out.println("Atualizando magia...");
                    build();
                    view.getBean().update(spell);
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
    private br.com.gmp.comps.combobox.GComboBox gCBCategory;
    private br.com.gmp.comps.combobox.GComboBox gCBClass;
    private br.com.gmp.comps.combobox.GComboBox gCBElement;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNCost;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTDuration;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.textfield.GTextField gTRange;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
    private javax.swing.JLabel jLCategory;
    private javax.swing.JLabel jLClass;
    private javax.swing.JLabel jLCost;
    private javax.swing.JLabel jLElement;
    private javax.swing.JLabel jLLength;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLRange;
    private javax.swing.JLabel jLType;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabs;
    // End of variables declaration//GEN-END:variables
}
