package br.com.odcontroler.main.view.classes.sub;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.odcontroler.data.enums.Alignment;
import br.com.odcontroler.data.entity.ClassBase;
import br.com.odcontroler.data.enums.ClassType;
import br.com.odcontroler.data.entity.Origin;
import br.com.odcontroler.data.entity.MaterialType;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.sub.SubView;
import br.com.odcontroler.main.view.classes.ClassView;
import br.com.odcontroler.main.view.classes.ClassBean;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

/**
 * Subview para edição de classes.
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public class ClassSubView extends SubView {

    private ClassBase classBase;
    private ClassBean bean;
    private final ClassView view;
    private GComboBoxModel<ClassType> clTypeModel;
    private GComboBoxModel<Alignment> alignmentModel;

    /**
     * Cria nova instancia de ClassSubView
     *
     * @param view {@code ClassView} Tela das Armaduras
     * @param cl {@code ClassBase} Armadura
     * @since 1.0
     */
    public ClassSubView(ClassView view, ClassBase cl) {
        super(view);
        this.view = view;
        initialize(cl);
    }

    /**
     * Método de inicialização
     *
     * @param cl {@code ClassBase} Armadura
     * @since 1.0
     */
    private void initialize(ClassBase cl) {
        this.setSize(700, 476);
        this.initComponents();
        this.bean = view.getBean();
        this.clTypeModel = new GComboBoxModel<>();
        this.alignmentModel = new GComboBoxModel<>(Alignment.values());
        //----------------------------------------------------------------------
        JMenuItem gen;
        gen = new JMenuItem("Gerar nome", new ImageIcon(getClass()
                .getResource("/ComponentIcons/controlers/settings.png")));
        gen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                autoName();
            }
        });
//        this.gTName.getComponentPopupMenu().add(gen);
        //----------------------------------------------------------------------
        this.setClass(cl);
        this.setVisible(true);
    }

    /**
     * Cria o nome da classe automaticamente
     *
     * @since 1.0
     */
    private void autoName() {
//        if (gCBType.validateComponent() && gCBMaterial.validateComponent() && gCBOrigin.validateComponent()) {
//            ClassType prefix = this.clTypeModel.getSelectedItem();
//            MaterialType mat1 = this.materialModel.getSelectedItem();
//            Origin origin = this.originModel.getSelectedItem();
//            this.gTName.setText(prefix.getName() + " " + origin.getName()
//                    + " de " + mat1.getName());
//        }
    }

    /**
     * Retorna a classe que está sendo editada
     *
     * @return {@code ClassBase} Armadura
     * @since 1.0
     */
    public ClassBase getClassBase() {
        return classBase;
    }

    /**
     * Modifica a classe que está sendo editada
     *
     * @param cl {@code ClassBase} Armadura
     * @since 1.0
     */
    public void setClass(ClassBase cl) {
        try {
            if (cl != null) {
                this.classBase = cl;
//                this.gTName.setText(cl.getName());

            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
    }

    /**
     * Constroi os dados na classe
     *
     * @since 1.0
     */
    private void build() {
        if (this.classBase == null) {
            this.classBase = new ClassBase();
        }
        if (this.classBase.getId() == null) {
            this.classBase.setId(bean.getNextID());
        }
//        this.classBase.setName(gTName.getText());
        this.classBase.setDescription(gTADesc.getText());
        this.classBase.setType(clTypeModel.getSelectedItem());
    }

    /**
     * Valida se os campos estão todos preenchidos corretamente
     *
     * @return {@code boolean} Os campos estão todos preenchidos corretamente?
     * @since 1.0
     */
    private boolean validateFields() {
//        if (!gTName.validateComponent()) {
//            System.out.println("Nome invalido");
//            return false;
//        }
//        if (!gCBType.validateComponent()) {
//            System.out.println("Tipo invalido");
//            return false;
//        }
//        if (!gCBMaterial.validateComponent()) {
//            System.out.println("Material invalido");
//            return false;
//        }
//        if (!(jSpinCA.getValue() != null && ((Integer) jSpinCA.getValue()) != 0)) {
//            showBallon(jSpinCA, "CA invalido");
//            return false;
//        }
        return true;
    }

    /**
     * Retorna o Modelo dos Tipos de classes
     *
     * @return {@code GComboBoxModel(ClassType)} Tipos de classes
     * @since 1.0
     */
    public GComboBoxModel<ClassType> getClassTypeModel() {
        return clTypeModel;
    }

    /**
     * Retorna o Modelo dos alinhamentos
     *
     * @return {@code GComboBoxModel(Alignment)} Modelo dos alinhamentos
     * @since 1.1
     */
    public GComboBoxModel<Alignment> getAlignmentModel() {
        return alignmentModel;
    }

    /**
     * Retorna o ClassView
     *
     * @return {@code ClassView}
     * @since 1.0
     */
    public ClassView getView() {
        return view;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBAdd = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPBasics = new javax.swing.JPanel();
        jSPModifiers = new javax.swing.JScrollPane();
        jPModifiers = new javax.swing.JPanel();
        jSPDesc = new javax.swing.JScrollPane();
        gTADesc = new br.com.gmp.comps.textarea.GTextArea();

        setClosable(true);
        setIconifiable(true);
        setTitle("Editar classe");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/status/avenge.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 476));
        setMinimumSize(new java.awt.Dimension(700, 476));
        setPreferredSize(new java.awt.Dimension(700, 476));

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setText("Salvar");
        jBAdd.setFocusable(false);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBCancel.setText("Cancelar");
        jBCancel.setFocusable(false);
        jBCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Configurações basicas", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1253_.png")), jPBasics); // NOI18N

        javax.swing.GroupLayout jPModifiersLayout = new javax.swing.GroupLayout(jPModifiers);
        jPModifiers.setLayout(jPModifiersLayout);
        jPModifiersLayout.setHorizontalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );
        jPModifiersLayout.setVerticalGroup(
            jPModifiersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jSPModifiers.setViewportView(jPModifiers);

        jTabbedPane1.addTab("Modificadores", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1247_.png")), jSPModifiers); // NOI18N

        gTADesc.setColumns(20);
        gTADesc.setRows(5);
        jSPDesc.setViewportView(gTADesc);

        jTabbedPane1.addTab("Descrição", new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png")), jSPDesc); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd)
                    .addComponent(jBCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        if (validateFields()) {
            try {
                if (classBase == null) {
                    System.out.println("Criando nova classe...");
                    build();
                    view.getBean().add(new BeanEvent(view, classBase));
                } else {
                    System.out.println("Atualizando classe...");
                    build();
                    view.getBean().update(classBase);
                }
                this.dispose();
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
                this.dispose();
            }
        } else {
            System.out.println("Campos invalidos.");
        }
    }//GEN-LAST:event_jBAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textarea.GTextArea gTADesc;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBCancel;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JPanel jPModifiers;
    private javax.swing.JScrollPane jSPDesc;
    private javax.swing.JScrollPane jSPModifiers;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
