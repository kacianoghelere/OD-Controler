package br.com.rpgruler.main.view.armortype;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.rpgruler.data.db.dao.ArmorTypeDAO;
import br.com.rpgruler.data.entity.ArmorType;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.armortype.bean.ArmorTypeBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.interfaces.TableView;
import br.com.rpgruler.main.view.armortype.model.ArmorTypeModel;
import br.com.rpgruler.main.view.object.ViewParameter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cadastro de tipos de armaduras
 *
 * @author kaciano
 * @version 1.0
 */
public class ArmorTypeView extends View implements TableSource<ArmorType>, TableView {

    private ArmorTypeBean bean;
    private ArmorTypeModel model;

    /**
     * Cria nova instancia de ArmorTypeView
     *
     * @param mainScreen <code>MainScreen</code> Tela principal
     */
    public ArmorTypeView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setSize(700, 480);
        this.setControls(new ViewParameter(true, false, false, false));
        this.bean = new ArmorTypeBean(this);
        this.model = new ArmorTypeModel();
        this.gTable.buildTable(this, 0, model);
    }

    @Override
    public List<ArmorType> getTableData() {
        return new ArmorTypeDAO().getList();
    }

    /**
     * Modifica o modelo de tabela
     *
     * @param model <code>ArmorTypeModel</code>
     */
    public void setModel(ArmorTypeModel model) {
        this.model = model;
    }

    /**
     * Adiciona um item na tabela
     */
    @Override
    public void add() {
        try {
            if (gTTitle.validateComponent()) {
                ObjectWrapper vw = new ObjectWrapper(this)
                        .addValue("title", gTTitle.getText())
                        .addValue("qtd1", (Double) jSpQtd1.getValue())
                        .addValue("qtd2", (Double) jSpQtd2.getValue())
                        .addValue("resbase", nTResBase.getDouble());
                bean.add(new BeanEvent(vw));
            }
        } catch (NumberFormatException e) {
            Logger.getLogger(ArmorTypeView.class.getName())
                    .log(Level.SEVERE, null, e);
        }
    }

    /**
     * Remove um item da tabela
     */
    @Override
    public void remove() {
        String text = "Deseja remover os itens selecionados?";
        if (WindowUtil.confirmation(this, "Remover", text, "Sim", "Não")) {
            try {
                if (gTable.getSelectedRowCount() > 0) {
                    model.remove(gTable.getSelectedRows());
                }
            } catch (NumberFormatException e) {
                Logger.getLogger(ArmorTypeView.class.getName())
                        .log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public ArmorTypeModel getModel() {
        return model;
    }

    @Override
    public BeanListener getBean() {
        return bean;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLName = new javax.swing.JLabel();
        nTResBase = new br.com.gmp.comps.textfield.NumericTextField();
        jLabel1 = new javax.swing.JLabel();
        jSpQtd1 = new javax.swing.JSpinner();
        jLQtd1 = new javax.swing.JLabel();
        jLQtd2 = new javax.swing.JLabel();
        jSpQtd2 = new javax.swing.JSpinner();
        jBRemove = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Tipos de armaduras");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/armor/DVK/DVK_3.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(700, 480));
        setPreferredSize(new java.awt.Dimension(700, 480));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setToolTipText("Matérias primas");
        jScrollPane1.setViewportView(gTable);

        jLName.setText("Nome:");

        jLabel1.setText("Res. Base:");

        jSpQtd1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.5d));

        jLQtd1.setText("Qtd. Material 1:");

        jLQtd2.setText("Qtd. Material 2:");

        jSpQtd2.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.5d));

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setText("Remover");
        jBRemove.setFocusable(false);
        jBRemove.setMaximumSize(new java.awt.Dimension(30, 30));
        jBRemove.setMinimumSize(new java.awt.Dimension(30, 30));
        jBRemove.setPreferredSize(new java.awt.Dimension(30, 30));
        jBRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Adicionar");
        jBAdd.setFocusable(false);
        jBAdd.setMaximumSize(new java.awt.Dimension(30, 30));
        jBAdd.setMinimumSize(new java.awt.Dimension(30, 30));
        jBAdd.setPreferredSize(new java.awt.Dimension(30, 30));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTResBase, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLQtd1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpQtd1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLQtd2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpQtd2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jSpQtd1, jSpQtd2, nTResBase});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nTResBase, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpQtd1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLQtd2)
                        .addComponent(jSpQtd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLQtd1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jSpQtd1, jSpQtd2});

    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLQtd1;
    private javax.swing.JLabel jLQtd2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpQtd1;
    private javax.swing.JSpinner jSpQtd2;
    private br.com.gmp.comps.textfield.NumericTextField nTResBase;
    // End of variables declaration//GEN-END:variables

}
