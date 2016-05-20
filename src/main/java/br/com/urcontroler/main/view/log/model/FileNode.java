package br.com.urcontroler.main.view.log.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Nó de arvore baseado em objetos do tipo File
 *
 * @author kaciano
 * @version 1.0
 */
public class FileNode {

    private File file;
    private String name;
    private String description;
    private List<FileNode> children = new ArrayList<>();

    /**
     * Cria nova instância de FileNode
     *
     * @param file {@code File} Arquivo do nó
     */
    public FileNode(File file) {
        this.name = file.getName();
        this.description = file.getPath();
        this.file = file;
    }

    /**
     * Cria nova instância de FileNode
     *
     * @param file {@code File} Arquivo do nó
     * @param name {@code String} Nome do nó
     * @param description {@code String} Descrição do nó
     */
    public FileNode(File file, String name, String description) {
        this.file = file;
        this.name = name;
        this.description = description;
    }

    /**
     * Retorna o nome do nó
     *
     * @return {@code String} Nome do nó
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do nó
     *
     * @param name {@code String} Nome do nó
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a descrição do nó
     *
     * @return {@code String} Descrição do nó
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a descrição do nó
     *
     * @param description {@code String} Descrição do nó
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retorna o arquivo do nó
     *
     * @return {@code File} Arquivo do nó
     */
    public File getFile() {
        return file;
    }

    /**
     * Modifica o arquivo do nó
     *
     * @param file {@code File} Arquivo do nó
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Adiciona um novo nó filho
     *
     * @param node {@code FileNode} Novo nó de arquivos
     */
    public void add(FileNode node) {
        children.add(node);
    }

    /**
     * Retorna os arquivos dentro do nó
     *
     * @return {@code List(FileNode)} Arquivos dentro do nó
     */
    public List<FileNode> getChildren() {
        return children;
    }

    /**
     * Modifica os arquivos dentro do nó
     *
     * @param children {@code List(FileNode)} Arquivos dentro do nó
     */
    public void setChildren(List<FileNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return name;
    }
}
