package br.com.odcontroler.main.actions;

import br.com.odcontroler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para processar os dados, tecla F6
 *
 * @author kaciano
 */
public class ProccessAction extends FrameAction {

    /**
     * Cria nova instancia de ProccessAction
     *
     * @param view <code>View</code> da ação
     */
    public ProccessAction(View view) {
        super("proccess", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getView().getMainScreen().process(e);
    }
}
