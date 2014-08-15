package br.com.odcontroler.main.view.log;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXTreeTable;

public class SwingXExample extends JFrame {

    private JTabbedPane tabs = new JTabbedPane();

    private MyTreeTableModel treeTableModel = new MyTreeTableModel();
    private FileModel fileModel = new FileModel();
    private JXTreeTable treeTable = new JXTreeTable(fileModel);

    public SwingXExample() {
        super("SwingX Examples");

        // Build the tree table panel
        JPanel treeTablePanel = new JPanel(new BorderLayout());
        treeTablePanel.add(new JScrollPane(treeTable));
        tabs.addTab("JXTreeTable", treeTablePanel);

        // Add the tabs to the JFrame
        add(tabs);

        setSize(1024, 768);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width / 2 - 512, d.height / 2 - 384);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        AppStarter starter = new AppStarter(args);
        SwingUtilities.invokeLater(starter);
    }
}

class AppStarter extends Thread {

    private String[] args;

    public AppStarter(String[] args) {
        this.args = args;
    }

    public void run() {
        SwingXExample example = new SwingXExample();
    }

}
