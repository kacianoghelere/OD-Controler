package br.com.odcontroler.main.view.log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

public class MyTreeTableModel extends AbstractTreeTableModel {

    private MyTreeNode myroot;

    public MyTreeTableModel() {
        myroot = new MyTreeNode("root", "Root of the tree");
        myroot.getChildren().add(new MyTreeNode("Empty Child 1", "This is an empty child"));
        MyTreeNode subtree = new MyTreeNode("Sub Tree", "This is a subtree (it has children)");
        subtree.getChildren().add(new MyTreeNode("EmptyChild 1, 1", "This is an empty child of a subtree"));
        subtree.getChildren().add(new MyTreeNode("EmptyChild 1, 2", "This is an empty child of a subtree"));
        myroot.getChildren().add(subtree);
        myroot.getChildren().add(new MyTreeNode("Empty Child 2", "This is an empty child"));

        myroot = new MyTreeNode("root", "Root of the tree");
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
        MyTreeNode treenode = (MyTreeNode) node;
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
        MyTreeNode treenode = (MyTreeNode) node;
        return treenode.getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        MyTreeNode treenode = (MyTreeNode) parent;
        return treenode.getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        MyTreeNode treenode = (MyTreeNode) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }

        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        MyTreeNode treenode = (MyTreeNode) node;
        return treenode.getChildren().size() <= 0;
    }

    @Override
    public Object getRoot() {
        return myroot;
    }
}

class MyTreeNode {

    private String name;
    private String description;
    private List<MyTreeNode> children = new ArrayList<>();

    public MyTreeNode() {
    }

    public MyTreeNode(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<MyTreeNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}
