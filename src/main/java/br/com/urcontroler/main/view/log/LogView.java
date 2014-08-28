package br.com.urcontroler.main.view.log;

import br.com.urcontroler.main.view.log.model.FileNode;
import br.com.urcontroler.main.view.log.model.FileModel;
import br.com.gmp.comps.GColors;
import br.com.gmp.utils.file.FileUtil;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.object.ViewParameter;
import br.com.urcontroler.system.SystemManager;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import org.jdesktop.swingx.JXTreeTable;

/**
 * Tela para gerenciamento de logs
 *
 * @author kaciano
 */
public class LogView extends View {

    private LogBean bean;
    File dir = new File(SystemManager.getProperty("system.log.path"));
    FileModel model = new FileModel();

    /**
     * Cria nova instancia de LogView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public LogView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();

    }

    private void initialize() {
        setSize(655, 500);
        setControls(new ViewParameter(false, true, false, false));
        initComponents();
        this.jXTreeTable.setTreeTableModel(model);
        this.jXTreeTable = new JXTreeTable() {

        };
        this.bean = new LogBean(this);
    }

    /**
     * Mostra o log selecionado
     *
     * @param evt {@code javax.swing.event.TreeSelectionEvent} Objeto do evento
     */
    private void showLog(javax.swing.event.TreeSelectionEvent evt) throws IOException {
        FileNode node = (FileNode) evt.getPath().getLastPathComponent();
        if (model.isLeaf(node)) {
            gDialog.setTitle(node.getDescription());
            gTextArea1.setText(FileUtil.readString(node.getFile()));
            gDialog.show();
        }
    }

    @Override
    public void process() {
        super.process();
    }

    @Override
    public LogBean getBean() {
        return this.bean;
    }

    @Override
    public Description getDescription() {
        return new Description.Builder()
                .setTitle(getTitle())
                .setDescription("View para controle de logs.")
                .setSave("--")
                .setProcces("--")
                .setClear("--")
                .setLoad("--")
                .apply();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gDialog = new br.com.gmp.comps.dialog.GDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTextArea1 = new br.com.gmp.comps.textarea.GTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTreeTable = new org.jdesktop.swingx.JXTreeTable() {

            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JCheckBox) {
                    JCheckBox check = (JCheckBox) c;
                    check.setOpaque(showVerticalLines);
                }
                if (row % 2 == 0 && !isCellSelected(row, column)) {
                    c.setBackground(GColors.FOCUS);
                } else if (isCellSelected(row, column)) {
                    c.setBackground(getSelectionBackground());
                } else {
                    c.setBackground(getBackground());
                }
                return c;
            }

            @Override
            public Component prepareRenderer(int row, int column) {
                Component c = super.prepareRenderer(row, column);
                if (c instanceof JCheckBox) {
                    JCheckBox check = (JCheckBox) c;
                    check.setOpaque(showVerticalLines);
                }
                if (row % 2 == 0 && !isCellSelected(row, column)) {
                    c.setBackground(GColors.FOCUS);
                } else if (isCellSelected(row, column)) {
                    c.setBackground(getSelectionBackground());
                } else {
                    c.setBackground(getBackground());
                }
                return c;
            }

            @Override
            public TreeCellRenderer getTreeCellRenderer() {
                DefaultTreeCellRenderer rend = new DefaultTreeCellRenderer() {

                    @Override
                    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                        Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
                        if (c instanceof JCheckBox) {
                            JCheckBox check = (JCheckBox) c;
                            check.setOpaque(showVerticalLines);
                        }
                        if (row % 2 == 0 && !sel) {
                            c.setBackground(GColors.FOCUS);
                        } else if (sel) {
                            c.setBackground(getSelectionBackground());
                        } else {
                            c.setBackground(getBackground());
                        }
                        return c;
                    }

                };
                return rend;
            }

        };

        gDialog.setMinimumSize(new java.awt.Dimension(651, 444));

        gTextArea1.setColumns(20);
        gTextArea1.setLineWrap(true);
        gTextArea1.setRows(5);
        jScrollPane2.setViewportView(gTextArea1);

        javax.swing.GroupLayout gDialogLayout = new javax.swing.GroupLayout(gDialog.getContentPane());
        gDialog.getContentPane().setLayout(gDialogLayout);
        gDialogLayout.setHorizontalGroup(
            gDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        gDialogLayout.setVerticalGroup(
            gDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addContainerGap())
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Logs");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar/file.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(655, 500));

        jXTreeTable.setShowGrid(true);
        jXTreeTable.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jXTreeTableValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jXTreeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jXTreeTableValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jXTreeTableValueChanged
        try {
            showLog(evt);
        } catch (IOException ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jXTreeTableValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.dialog.GDialog gDialog;
    private br.com.gmp.comps.textarea.GTextArea gTextArea1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTreeTable jXTreeTable;
    // End of variables declaration//GEN-END:variables
}
