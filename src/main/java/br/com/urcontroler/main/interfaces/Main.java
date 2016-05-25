package br.com.urcontroler.main.interfaces;

import br.com.gmp.utils.reflection.ObjectInstance;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

/**
 * Interface da tela principal
 *
 * @author Kaciano Ghelere
 */
public interface Main {

    /**
     * Acesso estático aos logs
     */
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    /**
     * Tipo de mensagem para erros
     */
    public static int ERROR_MSG = 4;

    /**
     * Tipo de mensagem para informação
     */
    public static int INFORMATIVE_MSG = 1;

    /**
     * Tipo de mensagem para questionamento
     */
    public static int QUESTION_MSG = 2;

    /**
     * Tipo de mensagem para secesso
     */
    public static int SUCCESS_MSG = 5;

    /**
     * Tipo de mensagem para avisos
     */
    public static int WARNING_MSG = 3;

    /**
     * Icone de mensagem para erros
     */
    public static String ERROR_ICON = "/ComponentIcons/transition/toolbar/4.png";

    /**
     * Icone de mensagem para informação
     */
    public static String INFORMATIVE_ICON = "/ComponentIcons/transition/toolbar/1.png";

    /**
     * Icone de mensagem para questionamento
     */
    public static String QUESTION_ICON = "/ComponentIcons/transition/toolbar/2.png";

    /**
     * Icone de mensagem para secesso
     */
    public static String SUCCESS_ICON = "/ComponentIcons/transition/toolbar/5.png";

    /**
     * Icone de mensagem para avisos
     */
    public static String WARNING_ICON = "/ComponentIcons/transition/toolbar/3.png";

    /**
     * Metodo padrão para salvar
     *
     * @param evt {@code ActionEvent}
     */
    void commit(ActionEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt {@code ActionEvent}
     */
    void process(ActionEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt {@code ActionEvent}
     */
    void clear(ActionEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt {@code ActionEvent}
     */
    void load(ActionEvent evt);

    /**
     * Dispara o evento de processo iniciado
     */
    void toggleProcess();

}
