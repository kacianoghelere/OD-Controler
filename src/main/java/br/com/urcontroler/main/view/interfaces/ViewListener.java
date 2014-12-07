package br.com.urcontroler.main.view.interfaces;

import br.com.gmp.comps.interfaces.ValidableComponent;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 * Interface para Views
 *
 * @author kaciano
 * @param <T> Tipo do Bean
 */
public interface ViewListener<T> {

    /**
     * Acesso aos logs
     */
    public static final Logger LOGGER = Logger.getLogger(View.class.getName());

    /**
     * Retorna se a View pode salvar
     *
     * @return {@code Boolean} Pode salvar
     */
    Boolean canCommit();

    /**
     * Retorna se a View pode processar
     *
     * @return {@code Boolean} Pode processar
     */
    Boolean canProcces();

    /**
     * Retorna se a View pode limpar
     *
     * @return {@code Boolean} Pode limpar
     */
    Boolean canClear();

    /**
     * Retorna se a View pode carregar
     *
     * @return {@code Boolean} Pode carregar
     */
    Boolean canLoad();

    /**
     * Modifica a permissão para salvar
     *
     * @param save {@code Boolean} Pode salvar
     */
    void setCommit(boolean save);

    /**
     * Modifica a permissão para processar
     *
     * @param process {@code Boolean} Pode processar
     */
    void setProcces(boolean process);

    /**
     * Modifica a permissão para limpar
     *
     * @param clear {@code Boolean} Pode limpar
     */
    void setClear(boolean clear);

    /**
     * Modifica a permissão para carregar
     *
     * @param load {@code Boolean} Pode carregar
     */
    void setLoad(boolean load);

    /**
     * Metodo padrão para salvar
     *
     * @see
     * br.com.urcontroler.main.view.bean.ViewBean#onCommit(br.com.urcontroler.main.object.BeanEvent)
     */
    void onCommit();

    /**
     * Metodo padrão para processar os dados
     *
     * @see
     * br.com.urcontroler.main.view.bean.ViewBean#onProcess(br.com.urcontroler.main.object.BeanEvent)
     */
    void onProcess();

    /**
     * Metodo padrão para limpar a tela
     *
     * @see
     * br.com.urcontroler.main.view.bean.ViewBean#onClear(br.com.urcontroler.main.object.BeanEvent)
     */
    void onClear();

    /**
     * Metodo padrão para carregar a tela
     *
     * @see
     * br.com.urcontroler.main.view.bean.ViewBean#onLoad(br.com.urcontroler.main.object.BeanEvent)
     */
    void onLoad();

    /**
     * Retorna o Bean da View
     *
     * @param <T> Tipo de Retorno
     * @return {@code BeanListener}
     */
    <T> BeanListener getBean();

    /**
     * Retorna a tela principal
     *
     * @return {@code MainScreen}
     */
    MainScreen getMainScreen();

    /**
     * Mostra nova mensagem na barra de aplicações
     *
     * @param msg {@code String} Mensagem
     * @param type {@code int} Tipo da mensagem
     */
    void showMessage(String msg, int type);

    /**
     * Mostra balão de mensagem com 5 segundos de duração
     *
     * @param component {@code JComponent} Componente que terá a mensagem
     * @param text {@code String} Mensagem
     */
    void showBallon(JComponent component, String text);

    /**
     * Mostra balão na barra de mensagem com 5 segundos de duração
     *
     * @param text {@code String} Mensagem
     */
    void showMessageBalloon(String text);

    /**
     * Valida o componente e imprime a mensagem de erro em caso de falha
     *
     * @param component {@code ValidableComponent} Componente a ser validado
     * @param errorMsg {@code String} Mensagem de erro
     * @return {@code boolean} Resultado logico da validacao
     */
    boolean validate(ValidableComponent component, String errorMsg);

    /**
     * Valida a condicao e imprime a mensagem de erro em caso de falha
     *
     * @param condition {@code boolean} Condicao logica
     * @param errorMsg {@code String} Mensagem de erro
     * @return {@code boolean} Resultado logico da validacao
     */
    boolean validate(boolean condition, String errorMsg);
}
