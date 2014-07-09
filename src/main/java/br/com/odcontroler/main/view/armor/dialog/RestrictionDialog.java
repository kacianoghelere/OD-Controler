package br.com.odcontroler.main.view.armor.dialog;

import br.com.odcontroler.main.view.armor.sub.ArmorSubView;
import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.dialog.GDialog;
import br.com.odcontroler.data.db.dao.RestrictionTypeDAO;
import br.com.odcontroler.data.entity.Restriction;
import br.com.odcontroler.data.entity.RestrictionType;

/**
 * Tela auxiliar para resgistro de restrições
 *
 * @author kaciano
 */
public class RestrictionDialog extends GDialog {

    private ArmorSubView dialog;
    private Restriction restriction;
    private GComboBoxModel<RestrictionType> restModel;

    /**
     * Cria nova instancia de RestrictionDialog
     *
     * @param dialog {@code ArmorSubView}
     * @param restriction {@code Restriction} Restrição
     * @param modal {@code boolean} Modal?
     */
    public RestrictionDialog(ArmorSubView dialog, Restriction restriction, boolean modal) {
        super(dialog, modal);
        this.dialog = dialog;
        this.restriction = restriction;
        this.initialize(restriction);
    }

    /**
     * Método de inicialização
     *
     * @param restriction {@code Restriction} Restrição
     */
    private void initialize(Restriction restriction) {
        setSize(275, 150);
        initComponents();
        this.restModel = new GComboBoxModel<>();
        this.restModel.setData(new RestrictionTypeDAO().getList());
        this.gCBType.setModel(restModel);
        this.setRestriction(restriction);
        setVisible(true);
    }

    /**
     * Retorna a Restriction que está sendo manipulada
     *
     * @return {@code Restriction} Restrição
     */
    public Restriction getRestriction() {
        if (restriction == null) {
            restriction = new Restriction();
        }
        restriction.setType(restModel.getSelectedItem());
        restriction.setValue(nTValue.getInteger());
        return restriction;
    }

    /**
     * Modifica a Restriction que está sendo manipulada
     *
     * @param restriction {@code Restriction} Restrição
     */
    public void setRestriction(Restriction restriction) {
        try {
            if (restriction != null) {
                this.restriction = restriction;
                this.gCBType.setSelectedItem(this.restriction.getType());
                this.nTValue.setInt(this.restriction.getValue());
            }
        } catch (Exception e) {
        }
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLValue = new javax.swing.JLabel();
        jBSave = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        nTValue = new br.com.gmp.comps.textfield.NumericTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(275, 120));
        setMinimumSize(new java.awt.Dimension(275, 120));
        setResizable(false);

        jLType.setText("Tipo:");

        jLValue.setText("Valor:");

        jBSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBSave.setText("Salvar");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        nTValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nTValueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nTValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nTValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSave)
                    .addComponent(jBCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        if (gCBType.validateComponent() && nTValue.validateComponent()) {
            dispose();
        }
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void nTValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nTValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nTValueActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBSave;
    private javax.swing.JLabel jLType;
    private javax.swing.JLabel jLValue;
    private br.com.gmp.comps.textfield.NumericTextField nTValue;
    // End of variables declaration//GEN-END:variables
}
