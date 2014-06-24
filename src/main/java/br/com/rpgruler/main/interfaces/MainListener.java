package br.com.rpgruler.main.interfaces;

import br.com.rpgruler.data.entity.MenuItem;
import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.object.BeanEvent;
import br.com.rpgruler.main.view.View;
import java.util.Map;

/**
 * Interface do bean para a tela principal
 *
 * @author kaciano
 */
public interface MainListener {

    /**
     * Metodo padrão para salvar
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void commit(BeanEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void process(BeanEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void clear(BeanEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt <code>BeanEvent</code> Evento
     */
    void load(BeanEvent evt);

    /**
     * Volta os dados do frame para o estado inicial
     */
    void clear();

    /**
     * Retorna a View selecionada
     *
     * @return <code>View</code> View Selecionada
     */
    View getActualView();

    /**
     * Modifica a view selecionada
     *
     * @param view <code>View</code> View Selecionada
     */
    void setActualView(View view);

    /**
     * Insere uma nova view no desktop
     *
     * @param view <code>View</code> View
     */
    void insertView(View view);

    /**
     * Retorna a tela principal
     *
     * @return <code>MainScreen</code> Tela principal
     */
    MainScreen getScreen();

    /**
     * Modifica a tela principal
     *
     * @param screen <code>MainScreen</code> Tela principal
     */
    void setScreen(MainScreen screen);

    /**
     * Retorna o mapa das views carregadas
     *
     * @return <code>Map(String, MenuItem)</code> Mapa das views carregadas
     */
    Map<String, MenuItem> getViewMap();

    /**
     * Faz a busca das views pelo prefixo indicado, caso exista, carrega na tela
     *
     * @param prefix <code>String</code> Prefixo da View
     * @return <code>Boolean</code> A view foi encontrada?
     */
    Boolean searchView(String prefix);
}
