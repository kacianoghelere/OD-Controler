package br.com.odcontroler.main.view.log;

import br.com.gmp.comps.GColors;
import br.com.gmp.utils.object.TextBuilder;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.exception.ViewException;
import br.com.odcontroler.main.view.object.ViewParameter;
import br.com.odcontroler.system.SystemManager;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTree;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
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
    private void showLog(javax.swing.event.TreeSelectionEvent evt) {
        FileNode node = (FileNode) evt.getPath().getLastPathComponent();
        if (model.isLeaf(node)) {
            System.out.println(node.getName());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Logs");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar/file.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(655, 500));

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
        showLog(evt);
    }//GEN-LAST:event_jXTreeTableValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXTreeTable jXTreeTable;
    // End of variables declaration//GEN-END:variables
}
