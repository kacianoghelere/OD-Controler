package br.com.urcontroler.main.util;

import br.com.gmp.utils.audio.file.AudioConverter;
import br.com.gmp.utils.audio.file.AudioFile;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.interfaces.Main;
import br.com.urcontroler.main.util.object.AudioList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 * Construtor de lista de audio
 *
 * @author kaciano
 */
public class AudioListBuilder implements Runnable {

    private final MainScreen screen;
    private static AudioListBuilder instance;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Cria nova instancia de AudioListBuilder
     *
     * @param screen {@code MainScreen} Tela principal
     */
    private AudioListBuilder(MainScreen screen) {
        this.screen = screen;
    }

    /**
     * Retorna nova instancia de AudioListBuilder
     *
     * @param screen {@code MainScreen} Tela principal
     * @return {@code AudioListBuilder} Instancia do construtor
     */
    public static AudioListBuilder build(MainScreen screen) {
        if (instance == null) {
            instance = new AudioListBuilder(screen);
        }
        return instance;
    }

    @Override
    public void run() {
        try {
            this.screen.toggleProcess();
            List<AudioFile> ambiences = getList("system.audio.ambience");
            List<AudioFile> backgrounds = getList("system.audio.background");
            List<AudioFile> effects = getList("system.audio.effect");
            List<AudioFile> musics = getList("system.audio.music");

            AudioList list = new AudioList();
            list.setAmbiences(ambiences);
            list.setBackgrounds(backgrounds);
            list.setEffects(effects);
            list.setMusics(musics);

            String json = gson.toJson(list);
            System.out.println(json);

            this.screen.toggleProcess();
        } catch (Exception ex) {
            this.screen.printTypedMsg(ex.getMessage(), Main.ERROR_MSG);
        }
    }

    private List<AudioFile> getList(String path) throws Exception {
        return AudioConverter.convert(this.screen.getSounds(path));
    }

}
