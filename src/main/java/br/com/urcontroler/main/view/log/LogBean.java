package br.com.urcontroler.main.view.log;

import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.bean.ViewBean;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.system.SystemManager;
import java.io.File;
import java.util.Arrays;
import org.jfree.ui.FilesystemFilter;

/**
 * Bean de controle para tela de logs
 *
 * @author kaciano
 * @version 1.0
 */
public class LogBean extends ViewBean<LogView> {

    /**
     * Cria nova instancia de LogBean
     *
     * @param view {@code LogView} Tela dos logs
     */
    public LogBean(LogView view) {
        super(view);
        try {
            onLoad(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void onLoad(BeanEvent evt) throws Exception {

    }

}
