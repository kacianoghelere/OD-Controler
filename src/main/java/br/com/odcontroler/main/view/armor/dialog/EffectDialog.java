package br.com.odcontroler.main.view.armor.dialog;

import br.com.odcontroler.main.view.armor.sub.ArmorSubView;
import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.dialog.GDialog;
import br.com.odcontroler.data.db.dao.EffectDAO;
import br.com.odcontroler.data.entity.Effect;

/**
 * Caixa de dialogo para efeitos de armaduras
 *
 * @author kaciano
 */
public class EffectDialog extends GDialog {

    private Effect effect;
    private ArmorSubView dialog;
    private GComboBoxModel<Effect> effectModel;

    /**
     * Cria nova instancia de EffectDialog
     *
     * @param dialog <code>ArmorSubView</code> Tela de edição de armaduras
     * @param effect <code>Effect</code> Efeito da caixa de dialogo
     * @param modal <code>boolean</code> Modal?
     */
    public EffectDialog(ArmorSubView dialog, Effect effect, boolean modal) {
        super(dialog, modal);
        this.dialog = dialog;
        initialize(effect);
    }

    /**
     * Método de inicialização
     */
    private void initialize(Effect effect) {
        initComponents();
        this.effectModel = new GComboBoxModel<>(new EffectDAO().getList());
        this.gCBEffect.setGModel(effectModel);
        setEffect(effect);
        setSize(270, 100);
        setVisible(true);
    }

    /**
     * Retorna o efeito da caixa de dialogo
     *
     * @return <code>Effect</code> Efeito da caixa de dialogo
     */
    public Effect getEffect() {
        try {
            effect = effectModel.getSelectedItem();
            return effect;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Modifica o efeito da caixa de dialogo
     *
     * @param effect <code>Effect</code> Efeito da caixa de dialogo
     */
    public void setEffect(Effect effect) {
        if (effect != null) {
            this.effect = effect;
            gCBEffect.setSelectedItem(effect);
        }
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gCBEffect = new br.com.gmp.comps.combobox.GComboBox();
        jBCancel = new javax.swing.JButton();
        jBSave = new javax.swing.JButton();

        setUndecorated(true);
        setResizable(false);

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        jBSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBSave.setText("Salvar");
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gCBEffect, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jBCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gCBEffect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBSave)
                        .addComponent(jBCancel))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        if (gCBEffect.validateComponent()) {
            dispose();
        }
    }//GEN-LAST:event_jBSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBEffect;
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBSave;
    // End of variables declaration//GEN-END:variables
}
