package br.com.rpgruler.main.actions;

import br.com.rpgruler.main.view.View;
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
     * @param view <code>View</code> da ação
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
