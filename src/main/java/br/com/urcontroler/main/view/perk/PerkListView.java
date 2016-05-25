package br.com.urcontroler.main.view.perk;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.urcontroler.data.entity.Perk;
import br.com.urcontroler.data.entity.PerkType;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.object.ViewParameter;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.interfaces.ListView;
import java.util.logging.Level;

/**
 * Janela para cadastro e edicao de perks
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class PerkListView extends View<PerkListBean> implements ListView<Perk> {

    private Perk editingPerk;
    private GComboBoxModel<PerkType> typeModel;
    private GListModel<Perk> model;
    private PerkListBean bean;

    /**
     * Cria nova instancia de PerkSubView
     *
     * @param mainScreen {@code MainScreen}
     */
    public PerkListView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, true, true));
        this.setSize(595, 335);
        this.initComponents();
        this.bean = new PerkListBean(this);
        this.typeModel = new GComboBoxModel<>(bean.getPerkTypeList());
        this.gCBType.setGModel(typeModel);
        this.model = new GListModel<>(bean.getPerkList());
        this.gListWeapons.setModel(model);
        this.setVisible(true);
    }

    @Override
    public void apply() throws Exception {
        if (validateFields()) {
            Perk build = build();
            ObjectCopy.copyAll(build, editingPerk);
            updateComponent(gListWeapons);
        } else {
            LOGGER.log(Level.WARNING, "Campos invalidos.");
        }
    }

    @Override
    public void add() throws Exception {
        Perk tmp = buildTemp();
        model.add(tmp);
        editingPerk = tmp;
    }

    @Override
    public void remove() throws Exception {
        this.gListWeapons.removeSelected();
    }

    @Override
    public Perk buildTemp() throws Exception {
        Perk perk = new Perk();
        perk.setId(bean.getNextID());
        perk.setTitle("");
        return perk;
    }

    @Override
    public GList getList() {
        return gListWeapons;
    }

    @Override
    public GListModel<Perk> getModel() {
        return model;
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return {@code boolean} Os campos estão todos preenchidos corretamente?
     * @since 1.0
     */
    private boolean validateFields() {
        if (!gTTitle.validateComponent()) {
            System.out.println("Titulo invalido");
            return false;
        }
        if (!gCBType.validateComponent()) {
            System.out.println("Tipo invalido");
            return false;
        }
        return true;
    }

    /**
     * Reconstroi o perk
     */
    private Perk build() {
        Perk perk = editingPerk;
        if (perk == null) {
            perk = new Perk();
        }
        if (perk.getId() == null) {
            perk.setId(bean.getNextID());
        }
        perk.setTitle(gTTitle.getText());
        perk.setDescription(gTADesc.getText());
        perk.setType(typeModel.getSelectedItem());
        return perk;
    }

    /**
     * Constroi os dados do Perk na tela caso ele exista
     *
     * @param editingPerk {@code Perk} Perk a ser editado
     */
    public void setEditingPerk(Perk editingPerk) {
        try {
            if (editingPerk != null) {
                this.editingPerk = editingPerk;
                this.gTID.setLong(editingPerk.getId());
                this.gTTitle.setText(editingPerk.getTitle());
                this.gTADesc.setText(editingPerk.getDescription());
                if (typeModel.contains(editingPerk.getType())) {
                    this.gCBType.setSelectedItem(editingPerk.getType());
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Retorna o Perk que está em edição
     *
     * @return {@code Perk} Perk em edição
     */
    public Perk getEditingPerk() {
        try {
            if (gTTitle.validateComponent()) {
                if (gCBType.validateComponent()) {
                    if (gTADesc.validateComponent()) {
                        editingPerk.setId(gTID.getLong());
                        editingPerk.setTitle(gTTitle.getText());
                        editingPerk.setDescription(gTADesc.getText());
                        editingPerk.setType(typeModel.getSelectedItem());
                        return editingPerk;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public PerkListBean getBean() {
        return bean;
    }

    /**
     * Método de mudança de seleção
     */
    public void changeSelection() {

    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLTitle = new javax.swing.JLabel();
        jLID = new javax.swing.JLabel();
        gTID = new br.com.gmp.comps.textfield.GTextField();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLType = new javax.swing.JLabel();
        jBApply = new javax.swing.JButton();
        jPList = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        gListWeapons = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Vantagens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1215_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(595, 335));
        setMinimumSize(new java.awt.Dimension(595, 335));
        setPreferredSize(new java.awt.Dimension(595, 335));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar Vantagem"));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        gTADesc.setMaximum(255);
        jScrollPane2.setViewportView(gTADesc);

        jLTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLTitle.setText("Titulo:");

        jLID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLID.setText("Código:");

        gTID.setEnabled(false);

        jLType.setText("Tipo:");

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBApply)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(gTID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                            .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gTID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLID)
                            .addComponent(jLType)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBApply)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBType, gTID, gTTitle});

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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPListLayout.setVerticalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPListLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

        pack();
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

    private void gListWeaponsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListWeaponsValueChanged
        changeSelection();
    }//GEN-LAST:event_gListWeaponsValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.GList gListWeapons;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTID;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JPanel jPList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
