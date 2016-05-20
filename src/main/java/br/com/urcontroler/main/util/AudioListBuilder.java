package br.com.urcontroler.main.util;

import br.com.gmp.utils.audio.file.AudioConverter;
import br.com.gmp.utils.audio.file.AudioFile;
import br.com.gmp.utils.file.FileUtil;
import br.com.gmp.utils.system.SystemProperties;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.interfaces.Main;
import br.com.urcontroler.main.util.object.AudioList;
import br.com.urcontroler.system.SystemManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.List;

/**
 * Construtor de lista de audio
 *
 * @author kaciano
 */
public class AudioListBuilder implements Runnable {

    private final MainScreen main;
    private static AudioListBuilder instance;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Cria nova instancia de AudioListBuilder
     *
     * @param main {@code MainScreen} Tela principal
     */
    private AudioListBuilder(MainScreen main) {
        this.main = main;
    }

    /**
     * Retorna nova instancia de AudioListBuilder
     *
     * @param main {@code MainScreen} Tela principal
     * @return {@code AudioListBuilder} Instancia do construtor
     */
    public static AudioListBuilder build(MainScreen main) {
        if (instance == null) {
            instance = new AudioListBuilder(main);
        }
        return instance;
    }

    @Override
    public void run() {
        try {
            this.main.toggleProcess();
            AudioList list = new AudioList();
            list.setAmbiences(getList("system.audio.ambience"));
            list.setBackgrounds(getList("system.audio.background"));
            list.setEffects(getList("system.audio.effect"));
            list.setMusics(getList("system.audio.music"));

            String json = gson.toJson(list);
            File jsonFile = new File(SystemProperties.USER_HOME
                    + SystemManager.getProperty("system.audio.list"));
            FileUtil.write(jsonFile, json);
            this.main.toggleProcess();
        } catch (Exception ex) {
            this.main.printTypedMsg(ex.getMessage(), Main.ERROR_MSG);
        }
    }

    /**
     * Retorna a lista de AudioFile's contidos no caminho designado para a
     * propriedade
     *
     * @param key {@code String} Chave da propriedade
     * @return {@code List(AudioFile)} Lista de Arquivos de audio
     * @throws Exception Exceção
     */
    private List<AudioFile> getList(String key) throws Exception {
        return AudioConverter.convert(this.main.getSounds(key));
    }

}
