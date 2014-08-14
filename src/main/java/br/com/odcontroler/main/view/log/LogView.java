package br.com.odcontroler.main.view.log;

import br.com.gmp.utils.object.TextBuilder;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.exception.ViewException;
import br.com.odcontroler.main.view.object.ViewParameter;
import br.com.odcontroler.system.SystemManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Tela para gerenciamento de logs
 *
 * @author kaciano
 */
public class LogView extends View {

    private LogBean bean;
    File dir = new File(SystemManager.getProperty("system.log.path"));

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
        this.bean = new LogBean(this);
    }

    /**
     * Mostra o log selecionado
     *
     * @param evt {@code javax.swing.event.TreeSelectionEvent} Evento de seleção
     */
    private void showLog(javax.swing.event.TreeSelectionEvent evt) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) evt
                .getPath().getLastPathComponent();
        File file = (File) node.getUserObject();
        if (node.isLeaf() && file.isFile()) {
            try {
                System.out.println("Lendo...");
                TextBuilder builder = new TextBuilder();
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()) {
                    builder.append(br.readLine() + "\n");
                }
                br.close();
                fr.close();
                gTALog.setText(builder.getText());
            } catch (IOException e) {
                throwException(new ViewException(this, e));
            }
        }
    }

    /**
     * Método para adição recursiva de nós na arvore
     */
    DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {
        String curPath = dir.getAbsolutePath();
        DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(dir);
        if (curTop != null) {
            curTop.add(curDir);
        }
        List<File> mainList = new LinkedList();
        File[] tmp = dir.listFiles();
        mainList.addAll(Arrays.asList(tmp));
        Collections.sort(mainList);
        File f;
        List<File> files = new LinkedList();
        for (File obj : mainList) {
            String newPath;
            if (curPath.equals(".")) {
                newPath = obj.getAbsolutePath();
            } else {
                newPath = curPath + File.separator + obj;
            }
            if ((f = new File(newPath)).isDirectory()) {
                addNodes(curDir, f);
            } else {
                files.add(obj);
            }
        }
        for (Object file : files) {
            curDir.add(new DefaultMutableTreeNode(file));
        }
        return curDir;
    }

    DefaultMutableTreeNode nodes(DefaultMutableTreeNode top, File dir) {
        if (top == null) {
            top = new DefaultMutableTreeNode(dir);
        }
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                nodes(top, file);
            }
        } else {
            top.add(new DefaultMutableTreeNode(dir));
        }
        return top;
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        gTALog = new br.com.gmp.comps.textarea.GTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree(nodes(null, dir));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Logs");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar/file.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(655, 500));

        gTALog.setEditable(false);
        gTALog.setColumns(20);
        gTALog.setLineWrap(true);
        gTALog.setRows(5);
        jScrollPane2.setViewportView(gTALog);

        jSplitPane1.setRightComponent(jScrollPane2);

        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(jTree);

        jSplitPane1.setLeftComponent(jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        showLog(evt);
    }//GEN-LAST:event_jTreeValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.textarea.GTextArea gTALog;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
