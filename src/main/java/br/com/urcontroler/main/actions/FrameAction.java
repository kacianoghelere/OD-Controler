package br.com.urcontroler.main.actions;

import br.com.urcontroler.main.view.View;
import javax.swing.AbstractAction;

/**
 * Ação padrão dos Frames
 *
 * @author kaciano
 */
public abstract class FrameAction extends AbstractAction {

    private String name;
    private View mainScreen;

    /**
     * Cria nova instancia
     *
     * @param name Nome da ação
     * @param mainScreen View da ação
     */
    public FrameAction(String name, View mainScreen) {
        super(name);
        this.mainScreen = mainScreen;
        this.name = name;
    }

    /**
     * Retorna o Nome da ação
     *
     * @return {@code String} Nome da ação
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da ação
     *
     * @param name {@code String} Nome da ação
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o View
     *
     * @return {@code View} View da ação
     */
    public View getView() {
        return mainScreen;
    }

    /**
     * Modifica o View
     *
     * @param mainScreen {@code View} View da ação
     */
    public void setView(View mainScreen) {
        this.mainScreen = mainScreen;
    }
}
