package br.com.odcontroler.main.view.log;

import br.com.odcontroler.system.SystemManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class FileModel extends AbstractTreeTableModel {

    private FileNode root;

    public FileModel() {
        root = new FileNode(new File(SystemManager.getProperty("system.log.path")));
        buildNodes(root, root.getFile());
    }

    private void buildNodes(FileNode node, File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                FileNode newNode = new FileNode(file);
                buildNodes(newNode, newNode.getFile());
                node.getChildren().add(newNode);
            } else {
                node.getChildren().add(new FileNode(file));
            }
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Description";
            case 2:
                return "Number Of Children";
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getValueAt(Object node, int column) {
        System.out.println("getValueAt: " + node + ", " + column);
        FileNode treenode = (FileNode) node;
        switch (column) {
            case 0:
                return treenode.getName();
            case 1:
                return treenode.getDescription();
            case 2:
                return treenode.getChildren().size();
            default:
                return "Unknown";
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        FileNode treenode = (FileNode) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        FileNode treenode = (FileNode) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        FileNode treenode = (FileNode) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        FileNode treenode = (FileNode) node;
        return treenode.getFile().isFile();
    }

    @Override
    public Object getRoot() {
        return root;
    }
}

class FileNode {

    private File file;
    private String name;
    private String description;
    private List<FileNode> children = new ArrayList<>();

    public FileNode(File file) {
        this.name = file.getName();
        this.description = file.getPath();
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<FileNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}
