package br.com.urcontroler.main.util.object;

import br.com.gmp.utils.audio.file.AudioFile;
import java.util.List;

/**
 *
 * @author kaciano
 */
public class AudioList {

    private List<AudioFile> ambiences;
    private List<AudioFile> backgrounds;
    private List<AudioFile> effects;
    private List<AudioFile> musics;

    public AudioList() {
    }

    public List<AudioFile> getAmbiences() {
        return ambiences;
    }

    public void setAmbiences(List<AudioFile> ambiences) {
        this.ambiences = ambiences;
    }

    public List<AudioFile> getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(List<AudioFile> backgrounds) {
        this.backgrounds = backgrounds;
    }

    public List<AudioFile> getEffects() {
        return effects;
    }

    public void setEffects(List<AudioFile> effects) {
        this.effects = effects;
    }

    public List<AudioFile> getMusics() {
        return musics;
    }

    public void setMusics(List<AudioFile> musics) {
        this.musics = musics;
    }

}
