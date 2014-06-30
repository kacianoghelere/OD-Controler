package br.com.odcontroler.main.view.interfaces;

import br.com.odcontroler.main.MainScreen;
import javax.swing.JComponent;

/**
 * Interface para Views
 *
 * @author kaciano
 * @param <T> Tipo do Bean
 */
public interface ViewListener<T> {

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
     * br.com.odcontroler.main.view.bean.ViewBean#commit(br.com.odcontroler.main.object.BeanEvent)
     */
    void commit();

    /**
     * Metodo padrão para processar os dados
     *
     * @see
     * br.com.odcontroler.main.view.bean.ViewBean#process(br.com.odcontroler.main.object.BeanEvent)
     */
    void process();

    /**
     * Metodo padrão para limpar a tela
     *
     * @see
     * br.com.odcontroler.main.view.bean.ViewBean#clear(br.com.odcontroler.main.object.BeanEvent)
     */
    void clear();

    /**
     * Metodo padrão para carregar a tela
     *
     * @see
     * br.com.odcontroler.main.view.bean.ViewBean#load(br.com.odcontroler.main.object.BeanEvent)
     */
    void load();

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
    void showBalloon(JComponent component, String text);

}
