package br.com.odcontroler.main.interfaces;

import br.com.odcontroler.main.MainScreen;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

/**
 * Interface da tela principal
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public interface Main {

    /**
     * Acesso rápido ao logger
     *
     * @since 1.1
     */
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    /**
     * Tipo de mensagem para erros
     *
     * @since 1.0
     */
    public static int ERROR_MSG = 4;

    /**
     * Tipo de mensagem para informação
     *
     * @since 1.0
     */
    public static int INFORMATIVE_MSG = 1;

    /**
     * Tipo de mensagem para questionamento
     *
     * @since 1.0
     */
    public static int QUESTION_MSG = 2;

    /**
     * Tipo de mensagem para secesso
     *
     * @since 1.0
     */
    public static int SUCCESS_MSG = 5;

    /**
     * Tipo de mensagem para avisos
     *
     * @since 1.0
     */
    public static int WARNING_MSG = 3;

    /**
     * Icone de mensagem para erros
     *
     * @since 1.0
     */
    public static String ERROR_ICON = "/ComponentIcons/transition/toolbar/4.png";

    /**
     * Icone de mensagem para informação
     *
     * @since 1.0
     */
    public static String INFORMATIVE_ICON = "/ComponentIcons/transition/toolbar/1.png";

    /**
     * Icone de mensagem para questionamento
     *
     * @since 1.0
     */
    public static String QUESTION_ICON = "/ComponentIcons/transition/toolbar/2.png";

    /**
     * Icone de mensagem para sucesso
     *
     * @since 1.0
     */
    public static String SUCCESS_ICON = "/ComponentIcons/transition/toolbar/5.png";

    /**
     * Icone de mensagem para avisos
     *
     * @since 1.0
     */
    public static String WARNING_ICON = "/ComponentIcons/transition/toolbar/3.png";

    /**
     * Metodo padrão para salvar
     *
     * @param evt {@code ActionEvent}
     * @since 1.0
     */
    void commit(ActionEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt {@code ActionEvent}
     * @since 1.0
     */
    void process(ActionEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt {@code ActionEvent}
     * @since 1.0
     */
    void clear(ActionEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt {@code ActionEvent}
     * @since 1.0
     */
    void load(ActionEvent evt);
}
