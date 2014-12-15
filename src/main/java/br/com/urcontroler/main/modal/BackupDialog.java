package br.com.urcontroler.main.modal;

import br.com.gmp.comps.data.GenericDAO;
import br.com.gmp.comps.dialog.GDialog;
import br.com.urcontroler.data.db.dao.DaoBuilder;
import br.com.urcontroler.main.MainScreen;
import java.io.File;
import java.util.Arrays;
import org.jfree.ui.ExtensionFileFilter;
import org.jfree.ui.FilesystemFilter;

/**
 * Modal de controle de cópias de segurança
 *
 * @author kaciano
 */
public class BackupDialog extends GDialog {

    private MainScreen mainScreen;
    private String path;

    /**
     * Creates new form BackupDialog
     *
     * @param mainScreen {@code MainScreen} Janela principal
     */
    public BackupDialog(MainScreen mainScreen) {
        super(mainScreen, true);
        this.mainScreen = mainScreen;
        initialize();
    }

    /**
     * Método de inicializacao
     */
    private void initialize() {
        setSize(430, 245);
        initComponents();
        this.path = mainScreen.getProperty("system.db.path");
        jLDataLocation.setText(path);
        gFFBackup.getFileChooser().setFileFilter(new ExtensionFileFilter("Backup Yap", "byap"));
        gFFRestore.getFileChooser().setFileFilter(new ExtensionFileFilter("Backup Yap", "byap"));
    }

    /**
     * Gera o backup dos dados na pasta dos BDs
     */
    private void generate() {
        File dir = new File(path);
        File[] files = dir.listFiles(new FilesystemFilter("yap", "YAP"));
        String backupPath = gFFBackup.getSelectedFile().getPath();
        GenericDAO<File> dao = DaoBuilder.get(File.class, backupPath);
        dao.replaceAll(Arrays.asList(files));
    }

    /**
     * Restaura o backup dos dados na pasta dos BDs
     */
    private void restore() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jPBackup = new javax.swing.JPanel();
        gFFBackup = new br.com.gmp.comps.textfield.file.GFileField();
        jBGenerate = new javax.swing.JButton();
        jPRestore = new javax.swing.JPanel();
        gFFRestore = new br.com.gmp.comps.textfield.file.GFileField();
        jBRestore = new javax.swing.JButton();
        jLDataLocation = new javax.swing.JLabel();
        gTDataPath = new br.com.gmp.comps.textfield.GTextField();

        setMaximumSize(new java.awt.Dimension(430, 245));
        setMinimumSize(new java.awt.Dimension(430, 245));
        setResizable(false);

        jPBackup.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar copia de segurança"));

        jBGenerate.setText("Gerar");
        jBGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGenerateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBackupLayout = new javax.swing.GroupLayout(jPBackup);
        jPBackup.setLayout(jPBackupLayout);
        jPBackupLayout.setHorizontalGroup(
            jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gFFBackup, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBGenerate)
                .addContainerGap())
        );
        jPBackupLayout.setVerticalGroup(
            jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gFFBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBGenerate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPRestore.setBorder(javax.swing.BorderFactory.createTitledBorder("Restaurar copia de segurança"));

        jBRestore.setText("Restaurar");
        jBRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRestoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPRestoreLayout = new javax.swing.GroupLayout(jPRestore);
        jPRestore.setLayout(jPRestoreLayout);
        jPRestoreLayout.setHorizontalGroup(
            jPRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gFFRestore, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPRestoreLayout.setVerticalGroup(
            jPRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gFFRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLDataLocation.setLabelFor(gTDataPath);
        jLDataLocation.setText("Local dos dados:");

        gTDataPath.setEditable(false);
        gTDataPath.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBackup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLDataLocation)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(gTDataPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLDataLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gTDataPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPRestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGenerateActionPerformed
        generate();
    }//GEN-LAST:event_jBGenerateActionPerformed

    private void jBRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRestoreActionPerformed
        restore();
    }//GEN-LAST:event_jBRestoreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.file.GFileField gFFBackup;
    private br.com.gmp.comps.textfield.file.GFileField gFFRestore;
    private br.com.gmp.comps.textfield.GTextField gTDataPath;
    private javax.swing.JButton jBGenerate;
    private javax.swing.JButton jBRestore;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLDataLocation;
    private javax.swing.JPanel jPBackup;
    private javax.swing.JPanel jPRestore;
    // End of variables declaration//GEN-END:variables
}
