package br.com.odcontroler.main.view.effect;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.EffectDAO;
import br.com.odcontroler.data.entity.Effect;
import br.com.odcontroler.data.entity.EffectType;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.effect.bean.EffectBean;
import br.com.odcontroler.main.view.effect.model.EffectModel;
import br.com.odcontroler.main.view.interfaces.BeanListener;
import br.com.odcontroler.main.view.interfaces.TableView;
import br.com.odcontroler.main.view.object.ViewParameter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View para cadastro de efeitos
 *
 * @author kaciano
 */
public class EffectView extends br.com.odcontroler.main.view.View implements TableView, TableSource<Effect> {

    private EffectBean bean;
    private EffectModel model;
    private TableUtil tableUtil;
    private GComboBoxModel<EffectType> typeModel;

    /**
     * Cria nova instancia de EffectView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public EffectView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setSize(550, 400);
        this.setControls(new ViewParameter(true, false, true, false));
        this.tableUtil = new TableUtil(this);
        this.model = new EffectModel();
        this.typeModel = new GComboBoxModel<>();
        this.gTable.buildTable(this, 0, model);
        this.gCBType.setGModel(typeModel);
        this.bean = new EffectBean(this);
    }

    @Override
    public void clear() {
        gTTitle.clear();
        nTStrength.clear();
        gCBType.setSelectedIndex(0);
    }

    @Override
    public void add() {
        if (gTTitle.validateComponent() && nTStrength.validateComponent()
                && gCBType.validateComponent()) {
            try {
                ObjectWrapper vw = new ObjectWrapper(this)
                        .addValue("title", gTTitle.getText())
                        .addValue("strength", nTStrength.getDouble())
                        .addValue("type", (EffectType) gCBType.getSelectedItem());
                bean.add(new BeanEvent(vw));
            } catch (Exception ex) {
                Logger.getLogger(EffectView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remove() {
        this.tableUtil.remove(null);
    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public EffectModel getModel() {
        return this.model;
    }

    @Override
    public List<Effect> getTableData() {
        return new EffectDAO().getList();
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     * Retorna o modelo dos tipos de efeitos
     *
     * @return {@code GComboBoxModel(EffectType)} Modelo dos tipos
     */
    public GComboBoxModel<EffectType> getTypeModel() {
        return this.typeModel;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jLTitle = new javax.swing.JLabel();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLStrength = new javax.swing.JLabel();
        nTStrength = new br.com.gmp.comps.textfield.NumericTextField();
        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Efeitos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/status/slice1390_@.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(550, 400));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Efeitos"));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jScrollPane1.setViewportView(gTable);

        jLTitle.setText("Titulo:");

        jLStrength.setText("Proporção:");

        nTStrength.setText("");

        jLType.setText("Tipo:");

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLStrength)
                            .addComponent(jLTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nTStrength, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLStrength)
                        .addComponent(nTStrength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLType)
                        .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBRemove)
                    .addComponent(jBAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception e) {
            Logger.getLogger(EffectView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception e) {
            Logger.getLogger(EffectView.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLStrength;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JScrollPane jScrollPane1;
    private br.com.gmp.comps.textfield.NumericTextField nTStrength;
    // End of variables declaration//GEN-END:variables

}
