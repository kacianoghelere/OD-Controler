package br.com.urcontroler.main.actions;

import br.com.urcontroler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para processar os dados, tecla F6
 *
 * @author Kaciano Ghelere
 */
public class ProccessAction extends FrameAction {

    /**
     * Cria nova instancia de ProccessAction
     *
     * @param view {@code View} da ação
     */
    public ProccessAction(View view) {
        super("process", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().getMainScreen().process(e);
    }
}
