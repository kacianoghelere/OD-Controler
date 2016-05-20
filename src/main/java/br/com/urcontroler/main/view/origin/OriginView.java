package br.com.urcontroler.main.view.origin;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.OriginDAO;
import br.com.urcontroler.data.entity.Origin;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.object.ViewParameter;
import br.com.urcontroler.main.view.origin.model.OriginModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Tela de controle para origem de itens
 *
 * @author kaciano
 * @version 1.0
 */
@ViewData(name = "Origem de itens", type = ViewType.CRUD, path = {""})
public class OriginView extends View implements TableView, TableSource<Origin> {

    private OriginBean bean;
    private OriginModel model;
    private TableDecorator decorator;
    private int count = 0;
    private int NAME = count++;
    private int VARIATION = count++;
    private int BONUS = count++;

    /**
     * Cria nova instancia de OriginView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public OriginView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setSize(620, 300);
        this.setControls(new ViewParameter(true, false, true, false));
        this.initComponents();
        this.decorator = new TableDecorator(gTable);
        //----------------------------------------------------------------------
        // Inicialização do modelo
        this.model = new OriginModel();
        //----------------------------------------------------------------------
        // Inicialização do bean
        this.bean = new OriginBean(this);
        //----------------------------------------------------------------------
        // Atribuição do modelo na tabela
        this.gTable.buildTable(this, 0, model);
        //----------------------------------------------------------------------
        // Atribuição dos editores
        this.decorator.withNumber(BONUS);
    }

    @Override
    public OriginBean getBean() {
        return bean;
    }

    @Override
    public void add() throws Exception {
        ObjectWrapper ow = new ObjectWrapper(this)
                .addValue("name", gTName.getText())
                .addValue("variation", gTVariation.getText())
                .addValue("bonus", jSpnBonus.getValue());
        this.bean.add(new BeanEvent(ow));
    }

    @Override
    public void remove() throws Exception {
        bean.remove(null);
    }

    @Override
    public void edit() {
        if (gTable.getSelectedObjects() != null) {
            Origin origin = model.getObject(gTable.getSelectedRow());
            gTName.setText(origin.getName());
            jSpnBonus.setValue(origin.getBonus());
        }
    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public OriginModel getModel() {
        return model;
    }

    @Override
    public List<Origin> getTableData() {
        return new OriginDAO().getList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBRemove = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        jSP = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLBonus = new javax.swing.JLabel();
        jSpnBonus = new javax.swing.JSpinner();
        jLVariation = new javax.swing.JLabel();
        gTVariation = new br.com.gmp.comps.textfield.GTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Origens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1245_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(620, 300));
        setMinimumSize(new java.awt.Dimension(620, 300));
        setPreferredSize(new java.awt.Dimension(620, 300));

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        gTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gTableMouseClicked(evt);
            }
        });
        jSP.setViewportView(gTable);

        jLName.setText("Nome:");

        jLBonus.setText("Bônus:");

        jSpnBonus.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLVariation.setText("Variação");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSP)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLVariation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTVariation, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLBonus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLName)
                        .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLBonus)
                        .addComponent(jSpnBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLVariation)
                        .addComponent(gTVariation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBAdd)
                    .addComponent(jBRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSP, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gTName, jSpnBonus});

    }// </editor-fold>//GEN-END:initComponents

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            Logger.getLogger(OriginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception ex) {
            Logger.getLogger(OriginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void gTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gTableMouseClicked
        if (evt.getClickCount() == 2) {
            edit();
        }
    }//GEN-LAST:event_gTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.textfield.GTextField gTVariation;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLBonus;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLVariation;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JSpinner jSpnBonus;
    // End of variables declaration//GEN-END:variables
}
