package br.com.urcontroler.main.view.imports;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.list.dual.model.GDualListModel;
import br.com.gmp.utils.audio.file.AudioConverter;
import br.com.gmp.utils.audio.file.AudioFile;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.imports.model.ImportAudioModel;
import br.com.urcontroler.main.view.imports.model.ImportAudioNode;
import br.com.urcontroler.main.view.imports.object.AudioDir;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;

/**
 * Tela de importacao de midias
 *
 * @author Kaciano Ghelere
 */
public class ImportAudioView extends View<ImportAudioBean> {

    private ImportAudioBean bean;
    private GComboBoxModel<AudioDir> audioTypeModel;
    private ImportAudioModel model;
    private AudioFile selected;

    /**
     * Cria nova instancia de ImportView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public ImportAudioView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    private void initialize() {
        this.setControls(new ViewParameter(false, false, false, false));
        this.setSize(640, 450);
        this.initComponents();
        this.bean = new ImportAudioBean(this);
        this.loadModel();
        this.audioTypeModel = new GComboBoxModel<>();
        this.audioTypeModel.addElement(new AudioDir("Sons do Ambiente", getMainScreen().getSounds("system.audio.ambience")));
        this.audioTypeModel.addElement(new AudioDir("Sons de Fundo", getMainScreen().getSounds("system.audio.background")));
        this.audioTypeModel.addElement(new AudioDir("Efeitos sonoros", getMainScreen().getSounds("system.audio.effect")));
        this.audioTypeModel.addElement(new AudioDir("Músicas", getMainScreen().getSounds("system.audio.music")));
        this.gCBType.setGModel(audioTypeModel);

        this.setVisible(true);
    }

    /**
     * Recarrega o modelo de dados
     */
    private void loadModel() {
        try {
            getMainScreen().getListener().buildAudioList();
            Thread.sleep(1500l);
            model = new ImportAudioModel(getMainScreen().readAudioList());
            treeTable.setTreeTableModel(model);
            updateComponent(treeTable);
        } catch (InterruptedException ex) {
            Logger.getLogger(ImportAudioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Importa os arquivos de audio para a pasta destino
     */
    private void importAudio() {
        try {
            if (this.gFFDir.getFileChooser().getSelectedFile() != null) {
                GDualListModel<AudioFile> data = gDLImport.getDestinationData(AudioFile.class);
                List<AudioFile> files = data.getList();

                String msg = "Serão importados " + files.size() + " arquivos.\nDeseja continuar?";
                if (WindowUtil.confirmation(this, "Importar arquivos", msg)) {
                    File destination = new File(audioTypeModel.getSelectedItem().getPath());
                    for (AudioFile file : files) {
                        FileUtils.copyFileToDirectory(new File(file.getPath()), destination);
                    }
                }

                getMainScreen().getListener().buildAudioList();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum diretório selecionado!");
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Abrir os arquivos
     */
    private void openFiles() {
        try {
            if (gFFDir.getFileChooser().getSelectedFile() != null) {
                List<AudioFile> convert = AudioConverter.convert(gFFDir.getFileChooser().getSelectedFile());
                gDLImport.setSourceElements(convert.toArray(new AudioFile[]{}));
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum diretório selecionado!");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ImportAudioBean getBean() {
        return this.bean;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabImports = new javax.swing.JTabbedPane();
        jPBackup = new javax.swing.JPanel();
        gFFDir = new br.com.gmp.comps.textfield.file.GFileField();
        jBOpen = new javax.swing.JButton();
        gDLImport = new br.com.gmp.comps.list.dual.GDualList();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLImport = new javax.swing.JLabel();
        jBImport = new javax.swing.JButton();
        jBRebuild = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeTable = new org.jdesktop.swingx.JXTreeTable();
        jBDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Importação de arquivos");
        setToolTipText("Importação de arquivos de audio, imagens e etc.");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/painter/painter.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(640, 450));
        setMinimumSize(new java.awt.Dimension(640, 450));
        setPreferredSize(new java.awt.Dimension(640, 450));

        gFFDir.setToolTipText("Diretório dos arquivos");
        gFFDir.setMaximumSize(new java.awt.Dimension(178, 30));
        gFFDir.setMinimumSize(new java.awt.Dimension(178, 30));

        jBOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/transition/switch.png"))); // NOI18N
        jBOpen.setText("Abrir");
        jBOpen.setMaximumSize(new java.awt.Dimension(66, 25));
        jBOpen.setMinimumSize(new java.awt.Dimension(66, 25));
        jBOpen.setPreferredSize(new java.awt.Dimension(66, 25));
        jBOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOpenActionPerformed(evt);
            }
        });

        gDLImport.setDestinationLabelText("Importar");
        gDLImport.setSourceLabelText("Disponíveis");

        jLImport.setText("Tipo:");

        jBImport.setText("Importar");
        jBImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImportActionPerformed(evt);
            }
        });

        jBRebuild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/settings.png"))); // NOI18N
        jBRebuild.setText("Reconstruir lista");
        jBRebuild.setToolTipText("Reconstruir a lista de arquivos de audio");
        jBRebuild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRebuildActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBackupLayout = new javax.swing.GroupLayout(jPBackup);
        jPBackup.setLayout(jPBackupLayout);
        jPBackupLayout.setHorizontalGroup(
            jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gDLImport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(jPBackupLayout.createSequentialGroup()
                        .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPBackupLayout.createSequentialGroup()
                                .addComponent(jLImport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(gFFDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBOpen, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jBImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPBackupLayout.createSequentialGroup()
                        .addComponent(jBRebuild)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPBackupLayout.setVerticalGroup(
            jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackupLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gCBType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLImport)
                    .addComponent(jBImport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gFFDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gDLImport, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRebuild)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabImports.addTab("Importação de Audio", jPBackup);

        treeTable.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeTableValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(treeTable);

        jBDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBDelete.setText("Remover");
        jBDelete.setToolTipText("Remover arquivo de audio");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBDelete)
                .addContainerGap(529, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jBDelete)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addGap(46, 46, 46)))
        );

        jTabImports.addTab("Arquivos de audio", jPanel1);

        getContentPane().add(jTabImports, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jBOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOpenActionPerformed
        openFiles();
    }//GEN-LAST:event_jBOpenActionPerformed

    private void jBImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImportActionPerformed
        importAudio();
    }//GEN-LAST:event_jBImportActionPerformed

    private void jBRebuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRebuildActionPerformed
        getMainScreen().getListener().buildAudioList();
    }//GEN-LAST:event_jBRebuildActionPerformed

    private void treeTableValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeTableValueChanged
        ImportAudioNode node = (ImportAudioNode) evt.getPath().getLastPathComponent();
        if (node.getElement() instanceof AudioFile) {
            this.selected = (AudioFile) node.getElement();
        } else {
            this.selected = null;
        }
    }//GEN-LAST:event_treeTableValueChanged

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        if (this.selected != null) {
            if (WindowUtil.confirmation(this, "Remover arquivo de audio",
                    "Deseja realmente remover o arquivo de audio?")) {
                boolean deleted = FileUtils.deleteQuietly(new File(selected.getPath()));
                if (deleted) {
                    JOptionPane.showMessageDialog(this, "Arquivo removido!");
                    this.loadModel();
                }
            }
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.dual.GDualList gDLImport;
    private br.com.gmp.comps.textfield.file.GFileField gFFDir;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBImport;
    private javax.swing.JButton jBOpen;
    private javax.swing.JButton jBRebuild;
    private javax.swing.JLabel jLImport;
    private javax.swing.JPanel jPBackup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabImports;
    private org.jdesktop.swingx.JXTreeTable treeTable;
    // End of variables declaration//GEN-END:variables
}
