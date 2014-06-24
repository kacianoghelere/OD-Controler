package br.com.rpgruler.main.view.perk.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.rpgruler.data.db.dao.PerkTypeDAO;
import br.com.rpgruler.data.entity.Perk;
import br.com.rpgruler.data.entity.PerkType;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.sub.SubView;
import br.com.rpgruler.main.view.perk.PerkView;
import br.com.rpgruler.main.view.perk.bean.PerkBean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Janela auxiliar para cadastro de perks
 *
 * @author kaciano
 * @version 1.0
 */
public class PerkSubView extends SubView {

    private Perk perk;
    private PerkView view;
    private GComboBoxModel<PerkType> typeModel;

    /**
     * Cria nova instancia de PerkSubView
     *
     * @param perks <code>PerkView</code> Tela de Perks
     * @param perk <code>Perk</code> Perk a ser editado     
     */
    public PerkSubView(PerkView perks, Perk perk) {
        super(perks);
        this.view = perks;
        this.initialize(perk);
    }

    /**
     * Método de inicialização
     */
    private void initialize(Perk perk) {
        this.setSize(400, 236);
        this.initComponents();
        this.typeModel = new GComboBoxModel<>(new PerkTypeDAO().getList());
        this.gCBType.setGModel(typeModel);
        this.setPerk(perk);
        this.setVisible(true);
    }

    /**
     * Constroi os dados do Perk na tela caso ele exista
     *
     * @param perk <code>Perk</code> Perk a ser editado
     */
    public void setPerk(Perk perk) {
        try {
            if (perk != null) {
                this.perk = perk;
                this.gTID.setLong(this.perk.getId());
                this.gTTitle.setText(this.perk.getTitle());
                this.gTADesc.setText(this.perk.getDescription());
                this.jChInherited.setSelected(this.perk.isInherited());
                if (typeModel.contains(this.perk.getType())) {
                    this.gCBType.setSelectedItem(this.perk.getType());
                }
            } else {
                PerkBean bean = (PerkBean) this.view.getBean();
                this.perk = new Perk();
                this.perk.setId(bean.getNextID());
                this.gTID.setLong(this.perk.getId());
            }
        } catch (Exception e) {
            Logger.getLogger(PerkSubView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Retorna o Perk que está em edição
     *
     * @return <code>Perk</code> Perk em edição
     */
    public Perk getPerk() {
        try {            
            if (gTTitle.validateComponent()) {
                if (gCBType.validateComponent()) {
                    if (gTADesc.validateComponent()) {                        
                        perk.setId(gTID.getLong());
                        perk.setTitle(gTTitle.getText());
                        perk.setInherited(jChInherited.isSelected());
                        perk.setDescription(gTADesc.getText());
                        perk.setType(typeModel.getSelectedItem());
                        return perk;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            Logger.getLogger(PerkSubView.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        jBAdd = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jChInherited = new javax.swing.JCheckBox();
        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        gTID = new br.com.gmp.comps.textfield.GTextField();
        jLID = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar vantagem");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1215_.png"))); // NOI18N

        jLTitle.setText("Titulo:");

        gTADesc.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));
        gTADesc.setColumns(20);
        gTADesc.setMaximum(255);
        gTADesc.setRows(5);
        jScrollPane2.setViewportView(gTADesc);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Salvar");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jChInherited.setText("Herdavel");

        jLType.setText("Tipo:");

        gTID.setEnabled(false);

        jLID.setText("Código:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLID)
                                    .addComponent(jLTitle))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(gTID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jChInherited))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChInherited))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAdd)
                    .addComponent(jBCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        if (getPerk() != null) {
            view.getBean().add(new BeanEvent(view, getPerk()));
            dispose();
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTID;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
    private javax.swing.JCheckBox jChInherited;
    private javax.swing.JLabel jLID;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
