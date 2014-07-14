package br.com.odcontroler.main.interfaces;

import br.com.odcontroler.data.entity.MenuItem;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.bean.MainScreenBean;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Interface do bean para a tela principal
 *
 * @author kaciano
 */
public interface MainListener {

    /**
     * Acesso rápido ao logger
     *
     * @since 1.1
     */
    public static final Logger LOGGER = Logger.getLogger(MainScreenBean.class.getName());

    /**
     * Metodo padrão para salvar
     *
     * @param evt {@code BeanEvent} Evento
     */
    void commit(BeanEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt {@code BeanEvent} Evento
     */
    void process(BeanEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt {@code BeanEvent} Evento
     */
    void clear(BeanEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt {@code BeanEvent} Evento
     */
    void load(BeanEvent evt);

    /**
     * Volta os dados do frame para o estado inicial
     */
    void clear();

    /**
     * Retorna a View selecionada
     *
     * @return {@code View} View Selecionada
     */
    View getActualView();

    /**
     * Modifica a view selecionada
     *
     * @param view {@code View} View Selecionada
     */
    void setActualView(View view);

    /**
     * Insere uma nova view no desktop
     *
     * @param view {@code View} View
     */
    void insertView(View view);

    /**
     * Retorna a tela principal
     *
     * @return {@code MainScreen} Tela principal
     */
    MainScreen getScreen();

    /**
     * Modifica a tela principal
     *
     * @param screen {@code MainScreen} Tela principal
     */
    void setScreen(MainScreen screen);

    /**
     * Retorna o mapa das views carregadas
     *
     * @return {@code Map(String, MenuItem)} Mapa das views carregadas
     */
    Map<String, MenuItem> getViewMap();

    /**
     * Faz a busca das views pelo prefixo indicado, caso exista, carrega na tela
     *
     * @param prefix {@code String} Prefixo da View
     * @return {@code Boolean} A view foi encontrada?
     */
    Boolean searchView(String prefix);

    /**
     * Adiciona o texto recebido no Log atual
     *
     * @param logData {@code String} Texto à ser adicionado
     * @throws java.io.IOException Exceção de I/O
     */
    void appendLog(String logData) throws IOException;
}
