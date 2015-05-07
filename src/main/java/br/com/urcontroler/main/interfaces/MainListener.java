package br.com.urcontroler.main.interfaces;

import br.com.gmp.utils.reflection.ObjectInstance;
import br.com.urcontroler.data.entity.MenuItem;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
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
     * Acesso estático aos logs
     */
    public static final Logger LOGGER = Logger.getLogger(MainListener.class.getName());

    /**
     * Metodo padrão para salvar
     *
     * @param evt {@code BeanEvent} Evento
     */
    void onCommit(BeanEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt {@code BeanEvent} Evento
     */
    void onProcess(BeanEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt {@code BeanEvent} Evento
     */
    void onClear(BeanEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt {@code BeanEvent} Evento
     */
    void onLoad(BeanEvent evt);

    /**
     * Volta os dados do frame para o estado inicial
     */
    void clear();

    /**
     * Retorna a View selecionada
     *
     * @return {@code View} View Selecionada
     */
    View getCurrentView();

    /**
     * Modifica a view selecionada
     *
     * @param view {@code View} View Selecionada
     */
    void setCurrentView(View view);

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

    /**
     * Insere a instancia do objeto na área de trabalho
     *
     * @param instance {@code ObjectInstance} Instancia
     */
    void insertInstance(ObjectInstance instance);

    /**
     * Insere a instancia do objeto na área de trabalho
     *
     * @param instance {@code ObjectInstance} Instancia
     * @param description {@code Description} Descrição da View
     */
    void insertInstance(ObjectInstance instance, Description description);

    /**
     * Constroi a lista de arquivos de audio (Com thread embutida)
     */
    void buildAudioList();

    /**
     * Reconstroi a lista de arquivos de audio (Sem thread embutida)
     */
    void rebuildAudioList();
}
