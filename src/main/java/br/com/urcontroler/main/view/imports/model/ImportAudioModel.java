package br.com.urcontroler.main.view.imports.model;

import br.com.gmp.utils.audio.file.AudioFile;
import br.com.urcontroler.main.util.object.AudioList;
import java.util.List;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

/**
 * Modelo para treetables para listagem de arquivos de audio
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class ImportAudioModel extends AbstractTreeTableModel {

    private ImportAudioNode root;

    /**
     * Cria nova instância de AudioModel
     *
     * @param audioList {@code File} Arquivo/Diretório
     */
    public ImportAudioModel(AudioList audioList) {
        initialize(audioList);
    }

    /**
     * Método de inicialização
     */
    private void initialize(AudioList audioList) {
        this.root = new ImportAudioNode("Efeitos sonoros");
        buildNodes(audioList);
    }

    /**
     * Constroi os nós dentro do root recursivamente
     *
     * @param list {@code AudioList} Lista de arquivos
     */
    private void buildNodes(AudioList list) {
        addData(root, "Ambientes", list.getAmbiences());
        addData(root, "Sons de fundo", list.getBackgrounds());
        addData(root, "Efeitos", list.getEffects());
        addData(root, "Músicas", list.getMusics());
    }

    /**
     * Adiciona os elementos
     *
     * @param parent {@code ImportAudioNode} Nó pai
     * @param name {@code String} Nome do nó
     * @param files {@code List(AudioFile)} Arquivos de audio
     */
    private void addData(ImportAudioNode parent, String name, List<AudioFile> files) {
        ImportAudioNode node = new ImportAudioNode(name);
        for (AudioFile audio : files) {
            node.add(new ImportAudioNode(audio));
        }
        parent.add(node);
    }

    /**
     * Retorna a quantidade de colunas
     *
     * @return {@code int} Quantidade de colunas
     */
    @Override
    public int getColumnCount() {
        return 4;
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
                return "Arquivo";
            case 1:
                return "Album";
            case 2:
                return "Duração";
            case 3:
                return "Caminho";
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
        ImportAudioNode anode = (ImportAudioNode) node;
        if (anode.getElement() instanceof AudioFile) {
            AudioFile file = (AudioFile) anode.getElement();
            switch (column) {
                case 0:
                    return file.getTitle();
                case 1:
                    return file.getAlbum();
                case 2:
                    return file.getLength();
                case 3:
                    return file.getPath();
                default:
                    return "Unknown";
            }
        } else {
            switch (column) {
                case 0:
                    return anode.getElement();
                case 1:
                    return "";
                case 2:
                    return "";
                case 3:
                    return "";
                default:
                    return "Unknown";
            }
        }
    }

    @Override
    public Object getChild(Object node, int index) {
        return ((ImportAudioNode) node).getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((ImportAudioNode) parent).getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        ImportAudioNode treenode = (ImportAudioNode) parent;
        for (int i = 0; i > treenode.getChildren().size(); i++) {
            if (treenode.getChildren().get(i) == child) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object object) {
        return ((ImportAudioNode) object).getElement() instanceof AudioFile;
    }

    @Override
    public Object getRoot() {
        return root;
    }

}
