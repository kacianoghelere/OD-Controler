/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.urcontroler.main.view;

import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.list.object.ListElement;
import br.com.gmp.comps.model.GListModel;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.interfaces.BeanListener;
import br.com.urcontroler.main.view.interfaces.ListView;
import java.util.logging.Level;

/**
 *
 * @author Kaciano Ghelere
 */
public class GListView extends View implements ListView<ListElement> {

    /**
     * Cria nova instancia de GListView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public GListView(MainScreen mainScreen) {
        super(mainScreen);
        initComponents();
    }

    @Override
    public void apply() throws Exception {

    }

    @Override
    public void add() throws Exception {

    }

    @Override
    public void remove() throws Exception {

    }

    @Override
    public ListElement buildTemp() throws Exception {
        return null;
    }

    @Override
    public GList getList() {
        return null;
    }

    @Override
    public GListModel<ListElement> getModel() {
        return null;
    }

    @Override
    public BeanListener getBean() {
        return null;
    }

    /**
     * Método de mudança de seleção
     */
    public void changeSelection() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPList = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        gListWeapons = new br.com.gmp.comps.list.GList();
        jPEdit = new javax.swing.JPanel();
        jTBTitle = new javax.swing.JToolBar();
        jLTitle = new javax.swing.JLabel();
        jTbCommands = new javax.swing.JToolBar();
        jBApply = new javax.swing.JButton();
        jPContent = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximumSize(new java.awt.Dimension(690, 457));
        setMinimumSize(new java.awt.Dimension(690, 457));
        setPreferredSize(new java.awt.Dimension(690, 457));

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
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPListLayout.setVerticalGroup(
            jPListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPListLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPEdit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTBTitle.setFloatable(false);
        jTBTitle.setRollover(true);

        jLTitle.setText("Title");
        jTBTitle.add(jLTitle);

        jTbCommands.setFloatable(false);
        jTbCommands.setRollover(true);

        jBApply.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/button/switch/on.png"))); // NOI18N
        jBApply.setText("Aplicar");
        jBApply.setFocusable(false);
        jBApply.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApplyActionPerformed(evt);
            }
        });
        jTbCommands.add(jBApply);

        javax.swing.GroupLayout jPEditLayout = new javax.swing.GroupLayout(jPEdit);
        jPEdit.setLayout(jPEditLayout);
        jPEditLayout.setHorizontalGroup(
            jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTBTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTbCommands, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
            .addComponent(jPContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPEditLayout.setVerticalGroup(
            jPEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEditLayout.createSequentialGroup()
                .addComponent(jTBTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTbCommands, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void gListWeaponsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListWeaponsValueChanged
        changeSelection();
    }//GEN-LAST:event_gListWeaponsValueChanged

    private void jBApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApplyActionPerformed
        try {
            apply();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Apply Error", ex);
        }
    }//GEN-LAST:event_jBApplyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gListWeapons;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBApply;
    private javax.swing.JButton jBDelete;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JPanel jPContent;
    private javax.swing.JPanel jPEdit;
    private javax.swing.JPanel jPList;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar jTBTitle;
    private javax.swing.JToolBar jTbCommands;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
