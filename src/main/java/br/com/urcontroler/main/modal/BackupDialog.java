package br.com.urcontroler.main.modal;

import br.com.gmp.comps.dialog.GDialog;
import br.com.urcontroler.main.MainScreen;
import org.jfree.ui.ExtensionFileFilter;

/**
 * Modal de controle de cópias de segurança
 *
 * @author kaciano
 */
public class BackupDialog extends GDialog {

    /**
     * Creates new form BackupDialog
     *
     * @param mainScreen {@code MainScreen} Janela principal
     */
    public BackupDialog(MainScreen mainScreen) {
        super(mainScreen, true);
        initialize();
    }

    /**
     * Método de inicializacao
     */
    private void initialize() {
        setSize(430, 245);
        initComponents();
        gFFBackup.getFileChooser().setFileFilter(new ExtensionFileFilter("Backup Yap", "byap"));
        gFFRestore.getFileChooser().setFileFilter(new ExtensionFileFilter("Backup Yap", "byap"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jPBackup = new javax.swing.JPanel();
        gFFBackup = new br.com.gmp.comps.textfield.file.GFileField();
        jButton1 = new javax.swing.JButton();
        jPRestore = new javax.swing.JPanel();
        gFFRestore = new br.com.gmp.comps.textfield.file.GFileField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        gTDataPath = new br.com.gmp.comps.textfield.GTextField();

        setMaximumSize(new java.awt.Dimension(430, 245));
        setMinimumSize(new java.awt.Dimension(430, 245));
        setResizable(false);
        setSize(new java.awt.Dimension(430, 245));

        jPBackup.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar copia de segurança"));

        jButton1.setText("Gerar");

        javax.swing.GroupLayout jPBackupLayout = new javax.swing.GroupLayout(jPBackup);
        jPBackup.setLayout(jPBackupLayout);
        jPBackupLayout.setHorizontalGroup(
            jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gFFBackup, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPBackupLayout.setVerticalGroup(
            jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gFFBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPRestore.setBorder(javax.swing.BorderFactory.createTitledBorder("Restaurar copia de segurança"));

        jButton2.setText("Restaurar");

        javax.swing.GroupLayout jPRestoreLayout = new javax.swing.GroupLayout(jPRestore);
        jPRestore.setLayout(jPRestoreLayout);
        jPRestoreLayout.setHorizontalGroup(
            jPRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gFFRestore, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPRestoreLayout.setVerticalGroup(
            jPRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPRestoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(gFFRestore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setLabelFor(gTDataPath);
        jLabel1.setText("Local dos dados:");

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
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(gTDataPath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gTDataPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPRestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textfield.file.GFileField gFFBackup;
    private br.com.gmp.comps.textfield.file.GFileField gFFRestore;
    private br.com.gmp.comps.textfield.GTextField gTDataPath;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBackup;
    private javax.swing.JPanel jPRestore;
    // End of variables declaration//GEN-END:variables
}
