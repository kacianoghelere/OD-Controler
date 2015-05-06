package br.com.urcontroler.main.view.player;

import br.com.gmp.utils.audio.file.AudioConverter;
import br.com.gmp.utils.audio.file.AudioFile;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.system.SystemManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.logging.Level;

/**
 * Bean de controle para Player
 *
 * @author kaciano
 */
public class PlayerBean extends ViewBean<PlayerView> {

    /**
     * Cria nova instancia de PlayerBean
     *
     * @param view {@code PlayerView} View de audio
     */
    public PlayerBean(PlayerView view) {
        super(view);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        try {
            onLoad(null);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void onLoad(BeanEvent evt) throws Exception {
        MainScreen main = getView().getMainScreen();

        List<AudioFile> am = AudioConverter.convert(main.getSounds("system.audio.ambience"));
        List<AudioFile> bg = AudioConverter.convert(main.getSounds("system.audio.background"));
        List<AudioFile> ef = AudioConverter.convert(main.getSounds("system.audio.effect"));
        List<AudioFile> ms = AudioConverter.convert(main.getSounds("system.audio.music"));

        getView().getAmbience().build(am);
        getView().getBackgrounds().build(bg);
        getView().getEffects().build(ef);
        getView().getMusic().build(ms);
    }

}
