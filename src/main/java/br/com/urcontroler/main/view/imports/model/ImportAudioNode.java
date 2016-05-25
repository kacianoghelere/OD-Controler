package br.com.urcontroler.main.view.imports.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Nó de arvore baseado em objetos do tipo File
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class ImportAudioNode {

    private Object element;
    private List<ImportAudioNode> children = new ArrayList<>();

    /**
     * Cria nova diretório de FileNode
     *
     * @param object {@code Object} Elemento do nó
     */
    public ImportAudioNode(Object object) {
        this.element = object;
    }

    /**
     * Retorna o Elemento do nó
     *
     * @return {@code File} Elemento do nó
     */
    public Object getElement() {
        return element;
    }

    /**
     * Modifica o diretório do nó
     *
     * @param element {@code Object} Elemento do nó
     */
    public void setElement(Object element) {
        this.element = element;
    }

    /**
     * Adiciona um novo nó filho
     *
     * @param node {@code ImportAudioNode} Novo nó de arquivos
     */
    public void add(ImportAudioNode node) {
        this.children.add(node);
    }

    /**
     * Retorna os arquivos dentro do nó
     *
     * @return {@code List(ImportAudioNode)} Arquivos dentro do nó
     */
    public List<ImportAudioNode> getChildren() {
        return this.children;
    }

    /**
     * Modifica os arquivos dentro do nó
     *
     * @param children {@code List(ImportAudioNode)} Arquivos dentro do nó
     */
    public void setChildren(List<ImportAudioNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
