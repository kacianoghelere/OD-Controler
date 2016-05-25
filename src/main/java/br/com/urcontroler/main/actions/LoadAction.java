package br.com.urcontroler.main.actions;

import br.com.urcontroler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para carregar os dados, tecla F8
 *
 * @author Kaciano Ghelere
 */
public class LoadAction extends FrameAction {

    /**
     * Cria nova instancia de LoadAction
     *
     * @param view {@code View} da ação
     */
    public LoadAction(View view) {
        super("load", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Load!");
        getView().getMainScreen().load(e);
    }

}
