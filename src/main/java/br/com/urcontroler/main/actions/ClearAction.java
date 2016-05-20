package br.com.urcontroler.main.actions;

import br.com.urcontroler.main.view.View;
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
     * @param view {@code View} da ação
     */
    public ClearAction(View view) {
        super("clear", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().getMainScreen().clear(e);
    }

}
