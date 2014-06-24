package br.com.rpgruler.main.actions;

import br.com.rpgruler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para limpar os dados, tecla F4
 *
 * @author kaciano
 */
public class ClearAction extends FrameAction {

    /**
     * Cria nova instancia de ClearAction
     *
     * @param view <code>View</code> da ação
     */
    public ClearAction(View view) {
        super("clear", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().getMainScreen().clear(e);
    }

}
