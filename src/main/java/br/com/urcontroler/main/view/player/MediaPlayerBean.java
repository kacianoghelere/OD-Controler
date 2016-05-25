package br.com.urcontroler.main.view.player;

import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.object.AudioList;
import br.com.urcontroler.main.view.bean.ViewBean;
import java.util.logging.Level;

/**
 * Bean de controle para MediaPlayer
 *
 * @author Kaciano Ghelere
 */
public class MediaPlayerBean extends ViewBean<MediaPlayerView> {

    /**
     * Cria nova instancia de PlayerBean
     *
     * @param view {@code MediaPlayerView} View de audio
     */
    public MediaPlayerBean(MediaPlayerView view) {
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
        AudioList list = getView().getMainScreen().readAudioList();

        getView().getAmbience().build(list.getAmbiences());
        getView().getBackgrounds().build(list.getBackgrounds());
        getView().getEffects().build(list.getEffects());
        getView().getMusic().build(list.getMusics());
    }

    @Override
    public void onProcess(BeanEvent evt) throws Exception {
        getView().getMainScreen().getListener().buildAudioList();
    }

}
