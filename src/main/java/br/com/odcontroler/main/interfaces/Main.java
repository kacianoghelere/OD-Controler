package br.com.odcontroler.main.interfaces;

import java.awt.event.ActionEvent;

/**
 * Interface da tela principal
 *
 * @author kaciano
 */
public interface Main {

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
     * @param evt <code>ActionEvent</code>
     */
    void commit(ActionEvent evt);

    /**
     * Metodo padrão para processar os dados
     *
     * @param evt <code>ActionEvent</code>
     */
    void process(ActionEvent evt);

    /**
     * Metodo padrão para limpar a tela
     *
     * @param evt <code>ActionEvent</code>
     */
    void clear(ActionEvent evt);

    /**
     * Metodo padrão para carregar a tela
     *
     * @param evt <code>ActionEvent</code>
     */
    void load(ActionEvent evt);
}
