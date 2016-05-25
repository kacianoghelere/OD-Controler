package br.com.urcontroler.main.util.object;

import br.com.gmp.utils.audio.file.AudioFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de listagem de arquivos de audio
 *
 * @author Kaciano Ghelere
 */
public class AudioList {

    private List<AudioFile> ambiences;
    private List<AudioFile> backgrounds;
    private List<AudioFile> effects;
    private List<AudioFile> musics;

    /**
     * Cria nova instancia de AudioList
     */
    public AudioList() {
        this.ambiences = new ArrayList<>();
        this.backgrounds = new ArrayList<>();
        this.effects = new ArrayList<>();
        this.musics = new ArrayList<>();
    }

    /**
     * Retorna a lista de sons de ambiente
     *
     * @return {@code List(AudioFile)} Lista de sons de ambiente
     */
    public List<AudioFile> getAmbiences() {
        return ambiences;
    }

    /**
     * Modifica a lista de sons de ambiente
     *
     * @param ambiences {@code List(AudioFile)} Lista de sons de ambiente
     */
    public void setAmbiences(List<AudioFile> ambiences) {
        this.ambiences = ambiences;
    }

    /**
     * Retorna a lista de sons de fundo
     *
     * @return {@code List(AudioFile)} Lista de sons de fundo
     */
    public List<AudioFile> getBackgrounds() {
        return backgrounds;
    }

    /**
     * Modifica a lista de sons de fundo
     *
     * @param backgrounds {@code List(AudioFile)} Lista de sons de fundo
     */
    public void setBackgrounds(List<AudioFile> backgrounds) {
        this.backgrounds = backgrounds;
    }

    /**
     * Retorna a lista de efeitos sonoros
     *
     * @return {@code List(AudioFile)} Lista de efeitos sonoros
     */
    public List<AudioFile> getEffects() {
        return effects;
    }

    /**
     * Modifica a lista de efeitos sonoros
     *
     * @param effects {@code List(AudioFile)} Lista de efeitos sonoros
     */
    public void setEffects(List<AudioFile> effects) {
        this.effects = effects;
    }

    /**
     * Retorna a lista de musicas
     *
     * @return {@code List(AudioFile)} Lista de musicas
     */
    public List<AudioFile> getMusics() {
        return musics;
    }

    /**
     * Modifica a lista de musicas
     *
     * @param musics {@code List(AudioFile)} Lista de musicas
     */
    public void setMusics(List<AudioFile> musics) {
        this.musics = musics;
    }

}
