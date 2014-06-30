package br.com.odcontroler.main.actions;

import br.com.odcontroler.main.view.View;
import java.awt.event.ActionEvent;

/**
 * Ação padrão para salvar os dados, tecla F2
 *
 * @author kaciano
 */
public class CommitAction extends FrameAction {

    /**
     * Cria nova instancia de SaveAction
     *
     * @param view {@code View} da ação
     */
    public CommitAction(View view) {
        super("save", view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        getView().getMainScreen().commit(null);
    }

}
