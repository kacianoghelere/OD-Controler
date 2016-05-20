package br.com.urcontroler.main.modal;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.dialog.GDialog;
import br.com.gmp.comps.list.dual.model.GDualListModel;
import br.com.gmp.utils.audio.file.AudioConverter;
import br.com.gmp.utils.audio.file.AudioFile;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.imports.object.AudioDir;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Modal de importacao de arquivos de audio
 *
 * @author kaciano
 */
public class ImportAudioDialog extends GDialog {

    private final MainScreen main;
    private GComboBoxModel<AudioDir> audioTypeModel;
    private Logger LOGGER = Logger.getLogger(ImportAudioDialog.class.getName());

    /**
     * Creates new form BackupDialog
     *
     * @param mainScreen {@code MainScreen} Janela principal
     */
    public ImportAudioDialog(MainScreen mainScreen) {
        super(mainScreen, true);
        this.main = mainScreen;
        initialize();
    }

    /**
     * Método de inicializacao
     */
    private void initialize() {
        setSize(550, 370);
        initComponents();

        this.audioTypeModel = new GComboBoxModel<>();
        this.audioTypeModel.addElement(new AudioDir("Sons do Ambiente", main.getSounds("system.audio.ambience")));
        this.audioTypeModel.addElement(new AudioDir("Sons de Fundo", main.getSounds("system.audio.background")));
        this.audioTypeModel.addElement(new AudioDir("Efeitos sonoros", main.getSounds("system.audio.effect")));
        this.audioTypeModel.addElement(new AudioDir("Músicas", main.getSounds("system.audio.music")));
        this.gCBType.setGModel(audioTypeModel);

        this.gFFDir.getFileChooser().setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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

                this.main.getListener().buildAudioList();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jPBackup = new javax.swing.JPanel();
        gFFDir = new br.com.gmp.comps.textfield.file.GFileField();
        jBOpen = new javax.swing.JButton();
        gDLImport = new br.com.gmp.comps.list.dual.GDualList();
        gCBType = new br.com.gmp.comps.combobox.GComboBox();
        jLImport = new javax.swing.JLabel();
        jBImport = new javax.swing.JButton();

        setTitle("Importar arquivos de audio");
        setMaximumSize(new java.awt.Dimension(550, 370));
        setMinimumSize(new java.awt.Dimension(550, 370));
        setResizable(false);

        jPBackup.setBorder(javax.swing.BorderFactory.createTitledBorder("Importação de arquivos de audio"));

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

        javax.swing.GroupLayout jPBackupLayout = new javax.swing.GroupLayout(jPBackup);
        jPBackup.setLayout(jPBackupLayout);
        jPBackupLayout.setHorizontalGroup(
            jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gDLImport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
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
                            .addComponent(jBImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(gDLImport, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOpenActionPerformed
        openFiles();
    }//GEN-LAST:event_jBOpenActionPerformed

    private void jBImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImportActionPerformed
        importAudio();
    }//GEN-LAST:event_jBImportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBType;
    private br.com.gmp.comps.list.dual.GDualList gDLImport;
    private br.com.gmp.comps.textfield.file.GFileField gFFDir;
    private javax.swing.JButton jBImport;
    private javax.swing.JButton jBOpen;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLImport;
    private javax.swing.JPanel jPBackup;
    // End of variables declaration//GEN-END:variables
}