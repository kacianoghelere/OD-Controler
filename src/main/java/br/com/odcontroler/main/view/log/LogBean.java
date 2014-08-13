package br.com.odcontroler.main.view.log;

import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.bean.ViewBean;
import br.com.odcontroler.main.view.exception.ViewException;
import br.com.odcontroler.system.SystemManager;
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
            load(null);
        } catch (Exception ex) {
            view.throwException(new ViewException(view, ex));
        }
    }

    @Override
    public void load(BeanEvent evt) throws Exception {

    }

}
