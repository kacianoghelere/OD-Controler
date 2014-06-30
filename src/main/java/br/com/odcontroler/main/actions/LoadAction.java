package br.com.odcontroler.main.actions;

import br.com.odcontroler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para carregar os dados, tecla F8
 *
 * @author kaciano
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
