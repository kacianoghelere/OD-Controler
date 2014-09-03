package br.com.urcontroler.main.view.skill;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.EffectDAO;
import br.com.urcontroler.data.db.dao.SkillDAO;
import br.com.urcontroler.data.entity.Effect;
import br.com.urcontroler.data.entity.Skill;
import br.com.urcontroler.data.enums.SkillType;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.object.ViewParameter;
import br.com.urcontroler.main.view.skill.model.SkillModel;
import java.util.Arrays;
import java.util.List;

/**
 * Tela de cadastro e controle de habilidades singulares
 *
 * @author kaciano
 * @version 1.0
 */
public class SkillView extends View implements TableView, TableSource<Skill> {

    private SkillBean bean;
    private SkillModel model;
    private GComboBoxModel<Effect> effectModel;
    private GComboBoxModel<SkillType> typeModel;
    private TableDecorator decorator;
    private int count = 0;
    private final int NAME = count++;
    private final int EFFECT = count++;
    private final int TYPE = count++;
    private final int DESCRIPTION = count++;

    /**
     * Cria nova instancia de SkillView
     *
     * @param mainScreen {@code MainScreen} Tela pricipal
     */
    public SkillView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, true, false));
        this.setSize(575, 425);
        //----------------------------------------------------------------------
        // Inicialização dos modelos
        this.model = new SkillModel();
        this.effectModel = new GComboBoxModel<>(new EffectDAO().getList());
        this.typeModel = new GComboBoxModel<>(SkillType.values());
        //----------------------------------------------------------------------
        // Inicialização da estrutura        
        this.initComponents();
        this.bean = new SkillBean(this);
        decorator = new TableDecorator(gTable);
        //----------------------------------------------------------------------
        // Atribuição dos modelos
        this.gTable.buildTable(this, 0, model);
        this.gCBEffect.setGModel(effectModel);
        this.gCBType.setGModel(typeModel);
        //----------------------------------------------------------------------
        // Atribuição dos editores
        decorator.comboAt(EFFECT, new EffectDAO().getList());
        decorator.comboAt(TYPE, Arrays.asList(SkillType.values()));
    }

    @Override
    public SkillBean getBean() {
        return this.bean;
    }

    @Override
    public void add() throws Exception {
        ObjectWrapper ow = new ObjectWrapper(this)
                .addValue("name", gTName.getText())
                .addValue("effect", effectModel.getSelectedItem())
                .addValue("type", typeModel.getSelectedItem())
                .addValue("description", gTADesc.getText());
        bean.add(new BeanEvent(ow));
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
        return gTable;
    }

    @Override
    public SkillModel getModel() {
        return this.model;
    }

    @Override
    public List<Skill> getTableData() {
        return new SkillDAO().getList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLName = new javax.swing.JLabel();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        gCBEffect = new br.com.gmp.comps.combobox.GComboBox();
        jLEffect = new javax.swing.JLabel();
        jLType = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();
        jBRemove = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Habilidades Singulares");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Mixed/slice1387_@.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(575, 425));
        setPreferredSize(new java.awt.Dimension(575, 425));

        jScrollPane1.setViewportView(gTable);

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLEffect.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLEffect.setText("Efeito:");

        jLType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLType.setText("Tipo:");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        gTADesc.setColumns(20);
        gTADesc.setLineWrap(true);
        gTADesc.setRows(5);
        jScrollPane2.setViewportView(gTADesc);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLName)
                            .addComponent(jLEffect))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gCBEffect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLType)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gCBEffect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLEffect)
                        .addComponent(jLType))
                    .addComponent(jBRemove)
                    .addComponent(jBAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBEffect, gCBType, gTName});

    }// </editor-fold>//GEN-END:initComponents

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBEffect;
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLEffect;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
