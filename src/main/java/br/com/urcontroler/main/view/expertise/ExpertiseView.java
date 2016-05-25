package br.com.urcontroler.main.view.expertise;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.ExpertiseDAO;
import br.com.urcontroler.data.enums.Attribute;
import br.com.urcontroler.data.entity.Expertise;
import br.com.urcontroler.data.entity.ExpertiseType;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.util.TableUtil;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.expertise.model.ExpertiseModel;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.List;
import java.util.logging.Level;

/**
 * Tela para cadastro e controle de perícias
 *
 * @author Kaciano Ghelere
 */
@ViewData(name = "Perícias", type = ViewType.CRUD, path = {""})
public class ExpertiseView extends View implements TableView, TableSource<Expertise> {

    private ExpertiseBean bean;
    private ExpertiseModel model;
    private TableUtil tableUtil;
    private GComboBoxModel<Attribute> attrModel;
    private GComboBoxModel<ExpertiseType> typeModel;

    /**
     * Cria nova instancia de ExpertiseView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public ExpertiseView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Metodo de inicializaçao
     */
    private void initialize() {
        this.initComponents();
        this.setControls(new ViewParameter(true, false, true, false));
        this.setSize(590, 430);
        this.model = new ExpertiseModel();
        this.attrModel = new GComboBoxModel<>();
        this.typeModel = new GComboBoxModel<>();
        this.bean = new ExpertiseBean(this);
        this.gCBAttribute.setGModel(attrModel);
        this.gCBType.setGModel(typeModel);
        this.gTable.buildTable(this, 0, model);
        this.tableUtil = new TableUtil(this);
    }

    @Override
    public ExpertiseBean getBean() {
        return bean;
    }

    @Override
    public void add() {
        if (gTTitle.validateComponent() && gCBAttribute.validateComponent()) {
            try {
                ObjectWrapper vw = new ObjectWrapper(this)
                        .addValue("title", gTTitle.getText())
                        .addValue("attr", attrModel.getSelectedItem())
                        .addValue("type", typeModel.getSelectedItem())
                        .addValue("value", (Integer) jSpinValue.getValue());
                bean.add(new BeanEvent(vw));
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void remove() {
        tableUtil.remove(null);
    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public ExpertiseModel getModel() {
        return model;
    }

    @Override
    public List<Expertise> getTableData() {
        return new ExpertiseDAO().getList();
    }

    /**
     * Retorna o modelo dos atributos
     *
     * @return {@code GComboBoxModel(Attribute)} Modelo dos atributos
     */
    public GComboBoxModel<Attribute> getAttrModel() {
        return attrModel;
    }

    /**
     * Retorna o modelo dos tipos
     *
     * @return {@code GComboBoxModel(ExpertiseType)} Modelo dos tipos
     */
    public GComboBoxModel<ExpertiseType> getTypeModel() {
        return typeModel;
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
        jLAttribute = new javax.swing.JLabel();
        gCBAttribute = new br.com.gmp.comps.combobox.GComboBox();
        jLValue = new javax.swing.JLabel();
        jSpinValue = new javax.swing.JSpinner();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jLType = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Perícias");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1352_@.png"))); // NOI18N

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(gTable);

        jLTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLTitle.setText("Titulo:");

        jLAttribute.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLAttribute.setText("Atributo:");

        jLValue.setText("Valor:");

        jSpinValue.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

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

        jLType.setText("Tipo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLAttribute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gCBAttribute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLValue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinValue, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLType)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBRemove)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLAttribute)
                        .addComponent(gCBAttribute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLValue)
                        .addComponent(jSpinValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAdd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBAttribute, gCBType, jBAdd, jSpinValue});

    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBAttribute;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLAttribute;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLType;
    private javax.swing.JLabel jLValue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinValue;
    // End of variables declaration//GEN-END:variables

}
