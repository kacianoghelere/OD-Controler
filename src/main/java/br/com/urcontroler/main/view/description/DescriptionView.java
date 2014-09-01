package br.com.urcontroler.main.view.description;

import br.com.gmp.comps.model.GListModel;
import br.com.urcontroler.data.entity.MenuItem;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.object.ViewParameter;

/**
 * Tela para edição de descrições de Views
 *
 * @author kaciano
 * @version 1.0
 */
public class DescriptionView extends View {

    private DescriptionBean bean;
    private GListModel<MenuItem> listModel;
    private MenuItem editing;

    /**
     * Cria nova instancia DescriptionView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public DescriptionView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, true, false));
        this.setSize(650, 428);
        this.listModel = new GListModel<>();
        this.bean = new DescriptionBean(this);
        this.initComponents();
        this.gListItems.setModel(listModel);
    }

    /**
     * Efetua a leitura do objeto selecionado
     *
     * @throws Exception Exceção propagada
     */
    private void read() throws Exception {
        if (gListItems.getSelectedIndices().length > 0) {
            editing = (MenuItem) gListItems.getSelectedValue();
            gTName.setText(editing.getDescription().getTitle());
            gTCommit.setText(editing.getDescription().getCommit());
            gTProcces.setText(editing.getDescription().getProcces());
            gTClear.setText(editing.getDescription().getClear());
            gTLoad.setText(editing.getDescription().getLoad());
            gTADescription.setText(editing.getDescription().getDescription());
        }
    }

    /**
     * Efetua a gravação do objeto selecionado
     *
     * @throws Exception Exceção propagada
     */
    private void write() throws Exception {
        if (editing != null) {
            for (MenuItem item : listModel.getData()) {
                if (editing.equals(item)) {
                    item.setDescription(rebuild());
                    break;
                }
            }
        }
    }

    /**
     * Reconstroi a descrição conforme os campos preenchidos
     *
     * @return {@code Description} Descrição da View
     */
    private Description rebuild() {
        Description desc = new Description.Builder()
                .setTitle(!gTName.isEmpty() ? gTName.getText() : "--")
                .setSave(!gTCommit.isEmpty() ? gTCommit.getText() : "--")
                .setProcces(!gTProcces.isEmpty() ? gTProcces.getText() : "--")
                .setClear(!gTClear.isEmpty() ? gTClear.getText() : "--")
                .setLoad(!gTLoad.isEmpty() ? gTLoad.getText() : "--")
                .setDescription(!gTADescription.isEmpty()
                        ? gTADescription.getText() : "--")
                .apply();
        return desc;
    }

    @Override
    public Description getDescription() {
        return new Description.Builder()
                .setTitle(getTitle())
                .setDescription("Tela de controle e cadastro de descrições")
                .setSave("Remove os itens antigos e salva os novos.")
                .apply();
    }

    /**
     * Retorna o modelo de listas das views
     *
     * @return {@code GListModel(MenuItem)} Modelo de listas das views
     */
    public GListModel<MenuItem> getListModel() {
        return listModel;
    }

    @Override
    public DescriptionBean getBean() {
        return this.bean;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        gListItems = new br.com.gmp.comps.list.GList();
        jScrollPane3 = new javax.swing.JScrollPane();
        gTADescription = new br.com.gmp.comps.textarea.GTextArea();
        jPBasics = new javax.swing.JPanel();
        jLName = new javax.swing.JLabel();
        gTName = new br.com.gmp.comps.textfield.GTextField();
        jLCommit = new javax.swing.JLabel();
        gTCommit = new br.com.gmp.comps.textfield.GTextField();
        gTProcces = new br.com.gmp.comps.textfield.GTextField();
        jLProcces = new javax.swing.JLabel();
        jLClean = new javax.swing.JLabel();
        gTClear = new br.com.gmp.comps.textfield.GTextField();
        jLLoad = new javax.swing.JLabel();
        gTLoad = new br.com.gmp.comps.textfield.GTextField();
        jBWrite = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Descrições de telas");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar/edit.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(650, 428));
        setMinimumSize(new java.awt.Dimension(650, 428));
        setPreferredSize(new java.awt.Dimension(650, 428));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Telas"));

        gListItems.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                gListItemsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(gListItems);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Descrição"));

        gTADescription.setColumns(20);
        gTADescription.setRows(5);
        jScrollPane3.setViewportView(gTADescription);

        jPBasics.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações Basicas"));

        jLName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLName.setText("Nome:");

        jLCommit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCommit.setText("Salvar:");

        jLProcces.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLProcces.setText("Processar:");

        jLClean.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLClean.setText("Limpar:");

        jLLoad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLLoad.setText("Carregar:");

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLCommit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTCommit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLProcces)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTProcces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(jLLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gTLoad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLClean, jLCommit, jLLoad, jLName, jLProcces});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCommit)
                    .addComponent(gTCommit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProcces)
                    .addComponent(gTProcces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLClean)
                    .addComponent(gTClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLLoad)
                    .addComponent(gTLoad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBWrite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/toolbar/5.png"))); // NOI18N
        jBWrite.setText("Gravar");
        jBWrite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBWriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addComponent(jPBasics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBWrite)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPBasics, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBWrite)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBWriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBWriteActionPerformed
        try {
            write();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBWriteActionPerformed

    private void gListItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_gListItemsValueChanged
        try {
            write();
            read();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_gListItemsValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gListItems;
    private br.com.gmp.comps.textarea.GTextArea gTADescription;
    private br.com.gmp.comps.textfield.GTextField gTClear;
    private br.com.gmp.comps.textfield.GTextField gTCommit;
    private br.com.gmp.comps.textfield.GTextField gTLoad;
    private br.com.gmp.comps.textfield.GTextField gTName;
    private br.com.gmp.comps.textfield.GTextField gTProcces;
    private javax.swing.JButton jBWrite;
    private javax.swing.JLabel jLClean;
    private javax.swing.JLabel jLCommit;
    private javax.swing.JLabel jLLoad;
    private javax.swing.JLabel jLName;
    private javax.swing.JLabel jLProcces;
    private javax.swing.JPanel jPBasics;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}
