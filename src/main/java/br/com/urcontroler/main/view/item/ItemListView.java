package br.com.urcontroler.main.view.item;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.utils.object.ObjectCopy;
import br.com.urcontroler.data.entity.Item;
import br.com.urcontroler.data.entity.ItemType;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.interfaces.ListView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.logging.Level;

/**
 * View de cadastro para itens
 *
 * @author kaciano
 * @version 1.0
 */
public class ItemListView extends View<ItemListBean> implements ListView<Item> {

    private Item editingItem;
    private ItemListBean bean;
    private GComboBoxModel<ItemType> typeModel;
    private GListModel<Item> model;

    /**
     * Cria nova instância de ItemSubView
     *
     * @param mainScreen {@code ItemView} Tela principal
     */
    public ItemListView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        setSize(463, 286);
        setControls(new ViewParameter(true, false, true, true));
        initComponents();
        this.bean = new ItemListBean(this);
        this.typeModel = new GComboBoxModel<>(bean.getItemTypeList());
        this.gCBType.setGModel(typeModel);
    }

    @Override
    public ItemListBean getBean() {
        return bean;
    }

    @Override
    public void apply() throws Exception {
        if (validateFields()) {
            Item build = build();
            ObjectCopy.copyAll(build, editingItem);
            updateComponent(gListItems);
        } else {
            LOGGER.log(Level.WARNING, "Campos invalidos.");
        }
    }

    @Override
    public void add() throws Exception {
        Item tmp = buildTemp();
        model.add(tmp);
        editingItem = tmp;
    }

    @Override
    public void remove() throws Exception {
        gListItems.removeSelected();
    }

    /**
     * Método de modificação do formulario
     */
    private void changeSelection() {
        setEditingItem((Item) gListItems.getSelectedValue());
    }

    @Override
    public Item buildTemp() throws Exception {
        Item item = new Item();
        item.setId(bean.getNextID());
        item.setPrice(0);
        item.setWeight(0D);
        return item;
    }

    @Override
    public GList getList() {
        return gListItems;
    }

    @Override
    public GListModel<Item> getModel() {
        return model;
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return {@code boolean} Os campos estão todos preenchidos corretamente?
     * @since 1.0
     */
    private boolean validateFields() {
        if (!gTName.validateComponent()) {
            return false;
        }
        if (!gCBType.validateComponent()) {
            return false;
        }
        if (gTADesc.getText().isEmpty()) {
            showBallon(gTADesc, "Descrição invalida");
            return false;
        }
        if (!(jSpnWeight.getValue() != null && ((Double) jSpnWeight.getValue()) != 0d)) {
            showBallon(jSpnWeight, "Peso invalido");
            return false;
        }
        if (!(gNPrice.validateComponent() && gNPrice.isZero() && gNPrice.isNegative())) {
            System.out.println("Preço invalido");
            return false;
        }
        return true;
    }

    /**
     * Retorna o Item à ser adicionado/editado
     *
     * @return {@code Item} Item à ser adicionado/editado
     */
    public Item getEditingItem() {
        return editingItem;
    }

    /**
     * Modifica o Item à ser adicionado/editado
     *
     * @param Item {@code Item} Item à ser adicionado/editado
     */
    public void setEditingItem(Item Item) {
        if (Item != null) {
            this.editingItem = Item;
            gTName.setText(Item.getName());
            gCBType.setSelectedItem(Item.getType());
            gTADesc.setText(Item.getDescription());
            jSpnWeight.setValue(Item.getWeight());
            gNPrice.setInt(Item.getPrice());
        }
    }

    /**
     * Constroi o editingItem
     *
     * @return {@code Item} EditingItem
     */
    private Item build() {
        Item item = editingItem;
        if (item == null) {
            item = new Item();
        }
        if (item.getId() == null) {
            item.setId(bean.getNextID());
        }
        item.setName(gTName.getText());
        item.setType(typeModel.getSelectedItem());
        item.setDescription(gTADesc.getText());
        item.setWeight((Double) jSpnWeight.getValue());
        item.setPrice(gNPrice.getInteger());
        return item;
    }

    /**
     * Dados gerados automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSPDesc = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        gNPrice = new br.com.gmp.comps.textfield.numeric.GNumericField();
        jSpnWeight = new javax.swing.JSpinner();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLName = new javax.swing.JLabel();
        jLPrice = new javax.swing.JLabel();
        jLWeight = new javax.swing.JLabel();
        jPList = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gListItems = new br.com.gmp.comps.list.GList();
        jBApply = new javax.swing.JButton();

        setTitle("Itens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1255_.png"))); // NOI18N

        jSPDesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        gTADesc.setColumns(20);
        gTADesc.setLineWrap(true);
        gTADesc.setRows(5);
        jSPDesc.setViewportView(gTADesc);

        jLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLType.setText("Tipo:");

        jSpnWeight.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(5.0d)));

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLPrice.setText("Preço:");

        jLWeight.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLWeight.setText("Peso:");

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

        gListItems.setBorder(null);
        gListItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gListItemsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(gListItems);

        javax.swing.GroupLayout jPListLayout = new javax.swing.GroupLayout(jPList);
        jPList.setLayout(jPListLayout);
        jPListLayout.setHorizontalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPListLayout.setVerticalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPListLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/button/switch/on.png"))); // NOI18N
        jBApply.setText("Aplicar");
        jBApply.setFocusable(false);
        jBApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSpnWeight)
                                    .addComponent(gNPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jBApply))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLName, jLPrice, jLType, jLWeight});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpnWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLWeight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPrice)
                            .addComponent(gNPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSPDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBApply)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBType, gNPrice, gTName, jSpnWeight});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLName, jLPrice, jLType, jLWeight});

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

    private void gListItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListItemsValueChanged
        changeSelection();
    }//GEN-LAST:event_gListItemsValueChanged

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        try {
            apply();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Apply Error", ex);
        }
    }//GEN-LAST:event_jBApplyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.GList gListItems;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNPrice;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLPrice;
    private javax.swing.JLabel jLType;
    private javax.swing.JLabel jLWeight;
    private javax.swing.JPanel jPList;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpnWeight;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
