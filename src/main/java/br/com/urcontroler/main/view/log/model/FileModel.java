package br.com.urcontroler.main.view.log.model;

import br.com.urcontroler.system.SystemManager;
import java.io.File;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

/**
 * Modelo para treetables que reconstroi dinamicamente a estrutura de um
 * diretório
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class FileModel extends AbstractTreeTableModel {

    private FileNode root;
    private File fileDir;

    /**
     * Cria nova instância de FileModel
     */
    public FileModel() {
        this(new File(SystemManager.getProperty("system.log.path")));
    }

    /**
     * Cria nova instância de FileModel
     *
     * @param fileDir {@code File} Arquivo/Diretório
     */
    public FileModel(File fileDir) {
        this(new FileNode(fileDir), fileDir);
    }

    /**
     * Cria nova instância de FileModel
     *
     * @param root {@code FileNode} Nó raiz
     * @param fileDir {@code File} Arquivo/Diretório
     */
    public FileModel(FileNode root, File fileDir) {
        this.root = root;
        this.fileDir = fileDir;
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        buildNodes(root, root.getFile());
    }

    /**
     * Constroi os nós dentro do root recursivamente
     *
     * @param node {@code FileNode} Nó pai
     * @param dir {@code File} Arquivo/Diretório
     */
    public void buildNodes(FileNode node, File dir) {
        for (File file : dir.listFiles()) {
            FileNode newNode = new FileNode(file);
            if (file.isDirectory()) {
                buildNodes(newNode, newNode.getFile());
            }
            node.getChildren().add(newNode);
        }
    }

    /**
     * Retorna a quantidade de colunas
     *
     * @return {@code int} Quantidade de colunas
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    /**
     * Retorna o nome da coluna a partir o indice
     *
     * @param column {@code int} Indice da coluna
     * @return {@code String} Nome da coluna
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nome";
            case 1:
                return "Caminho";
            case 2:
                return "Registros";
            default:
                return "Unknown";
        }
    }

    /**
     * Retorna os dados do nó na coluna
     *
     * @param node {@code Object} Nó
     * @param column {@code int} Indice da coluna
     * @return {@code Object} Valor da posição
     */
    @Override
    public Object getValueAt(Object node, int column) {
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
