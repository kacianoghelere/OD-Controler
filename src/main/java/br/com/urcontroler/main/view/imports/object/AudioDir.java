package br.com.urcontroler.main.view.imports.object;

import java.util.Objects;

/**
 * Objeto de diretorio de audio
 *
 * @author kaciano
 */
public class AudioDir {

    private String title;
    private String path;

    /**
     * Cria nova instancia de AudioDir
     *
     * @param title {@code String} Titulo do diretorio
     * @param path {@code String} Caminho do diretorio
     */
    public AudioDir(String title, String path) {
        this.title = title;
        this.path = path;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.path);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AudioDir other = (AudioDir) obj;
        return this.path.equals(other.path);
    }

    /**
     * Retorna o titulo do diretorio
     *
     * @return {@code String} Titulo do diretorio
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do diretorio
     *
     * @param title {@code String} Titulo do diretorio
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o caminho do diretorio
     *
     * @return {@code String} Caminho do diretorio
     */
    public String getPath() {
        return path;
    }

    /**
     * Modifica o caminho do diretorio
     *
     * @param path {@code String} Caminho do diretorio
     */
    public void setPath(String path) {
        this.path = path;
    }

}
