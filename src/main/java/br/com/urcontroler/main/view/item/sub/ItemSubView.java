package br.com.urcontroler.main.view.item.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.urcontroler.data.db.dao.ItemTypeDAO;
import br.com.urcontroler.data.entity.Item;
import br.com.urcontroler.data.entity.ItemType;
import br.com.urcontroler.main.interfaces.Main;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.item.ItemView;
import br.com.urcontroler.main.view.item.ItemBean;
import br.com.urcontroler.main.view.object.ViewParameter;
import br.com.urcontroler.main.view.sub.SubView;

/**
 * Subview de cadastro para itens
 *
 * @author kaciano
 * @version 1.0
 */
public class ItemSubView extends SubView {

    private Item item;
    private ItemView view;
    private ItemBean bean;
    private GComboBoxModel<ItemType> typeModel;

    /**
     * Cria nova instância de ItemSubView
     *
     * @param parent {@code ItemView} Tela de itens
     * @param item {@code Item} Item à ser adicionado/editado
     */
    public ItemSubView(ItemView parent, Item item) {
        super(parent);
        this.view = parent;
        this.bean = parent.getBean();
        this.item = item;
        initialize(item);
    }

    /**
     * Método de inicialização
     *
     * @param item {@code Item} Item à ser adicionado/editado
     */
    private void initialize(Item item) {
        setSize(463, 286);
        setControls(new ViewParameter(true, false, true, true));
        initComponents();
        load();
        this.gCBType.setGModel(typeModel);
        setItem(item);
    }

    @Override
    public void load() {
        this.typeModel = new GComboBoxModel<>(new ItemTypeDAO().getList());
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
     * Retorna o item à ser adicionado/editado
     *
     * @return {@code Item} Item à ser adicionado/editado
     */
    public Item getItem() {
        return item;
    }

    /**
     * Modifica o item à ser adicionado/editado
     *
     * @param item {@code Item} Item à ser adicionado/editado
     */
    public void setItem(Item item) {
        if (item != null) {
            this.item = item;
            gTName.setText(item.getName());
            gCBType.setSelectedItem(item.getType());
            gTADesc.setText(item.getDescription());
            jSpnWeight.setValue(item.getWeight());
            gNPrice.setInt(item.getPrice());
        }
    }

    /**
     * Constroi o item
     */
    private void build() {
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
    }

    /**
     * Dados gerados automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBRemove = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
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

        setTitle("Editar item");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/MenuIcons/slice1255_.png"))); // NOI18N

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setText("Cancelar");
        jBRemove.setFocusable(false);
        jBRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
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

        gTADesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSPDesc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLType, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSpnWeight)
                            .addComponent(gNPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLName, jLPrice, jLType, jLWeight});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLName)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpnWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLWeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPrice)
                    .addComponent(gNPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSPDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBRemove, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBType, gNPrice, gTName, jSpnWeight});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLName, jLPrice, jLType, jLWeight});

    }// </editor-fold>//GEN-END:initComponents

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        if (validateFields()) {
            try {
                if (item == null) {
                    showMessage("Criando novo item...", Main.INFORMATIVE_MSG);
                    build();
                    view.getBean().add(new BeanEvent(view, item));
                } else {
                    showMessage("Atualizando item...", Main.INFORMATIVE_MSG);
                    build();
                    view.getBean().update(item);
                }
                this.dispose();
            } catch (Exception ex) {
                throwException(new ViewException(view, ex));
                this.dispose();
            }
        } else {
            System.out.println("Campos invalidos.");
        }
    }//GEN-LAST:event_jBAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textfield.numeric.GNumericField gNPrice;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLPrice;
    private javax.swing.JLabel jLType;
    private javax.swing.JLabel jLWeight;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JSpinner jSpnWeight;
    // End of variables declaration//GEN-END:variables
}
