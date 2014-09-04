package br.com.urcontroler.main.view.effect;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.EffectDAO;
import br.com.urcontroler.data.entity.Effect;
import br.com.urcontroler.data.entity.EffectType;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.effect.model.EffectModel;
import br.com.urcontroler.main.view.interfaces.BeanListener;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.object.ViewParameter;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.exception.ViewException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View para cadastro de efeitos
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
@ViewData(name = "Efeitos", type = ViewType.CRUD, path = {})
public class EffectView extends View implements TableView, TableSource<Effect> {

    private EffectBean bean;
    private EffectModel model;
    private TableDecorator decorator;
    private GComboBoxModel<EffectType> typeModel;
    private int count = 0;
    private final int NAME = count++;
    private final int DESCRIPTION = count++;
    private final int TYPE = count++;

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
        this.setSize(550, 400);
        this.setControls(new ViewParameter(true, false, true, false));
        this.initComponents();
        this.decorator = new TableDecorator(gTable);
        //----------------------------------------------------------------------
        // Inicializações
        this.model = new EffectModel();
        this.typeModel = new GComboBoxModel<>();
        this.bean = new EffectBean(this);
        //----------------------------------------------------------------------
        // 
        this.gTable.buildTable(this, 0, model);
        this.gCBType.setGModel(typeModel);
        //----------------------------------------------------------------------
        //
        this.decorator.comboAt(TYPE, bean.getTypeDAO().getList());
    }

    @Override
    public void clear() {
        gTTitle.clear();
        gTDesc.clear();
        gCBType.setSelectedIndex(0);
    }

    @Override
    public void add() {
        if (gTTitle.validateComponent() && gTDesc.validateComponent()
                && gCBType.validateComponent()) {
            try {
                ObjectWrapper vw = new ObjectWrapper(this)
                        .addValue("title", gTTitle.getText())
                        .addValue("description", gTDesc.getText())
                        .addValue("type", (EffectType) gCBType.getSelectedItem());
                bean.add(new BeanEvent(vw));
            } catch (Exception ex) {
                throwException(new ViewException(this, ex));
            }
        }
    }

    @Override
    public void remove() throws Exception {
        bean.remove(null);
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
        jLDesc = new javax.swing.JLabel();
        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        gTDesc = new br.com.gmp.comps.textfield.GTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Efeitos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1400_@.png"))); // NOI18N
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

        jLTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLTitle.setText("Titulo:");

        jLDesc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDesc.setText("Descrição:");

        jLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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
                            .addComponent(jLDesc)
                            .addComponent(jLTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gTDesc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLType, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLDesc, jLTitle, jLType});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDesc)
                    .addComponent(gTDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLType)
                        .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBRemove)
                    .addComponent(jBAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBType, gTDesc});

    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception e) {
            throwException(new ViewException(this, e));
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception e) {
            throwException(new ViewException(this, e));
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textfield.GTextField gTDesc;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLDesc;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
