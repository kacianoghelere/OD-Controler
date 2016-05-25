package br.com.urcontroler.main.view.exception;

import br.com.urcontroler.main.view.View;

/**
 * Exceção padrão lançada por Views
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class ViewException extends Exception {

    private View view;

    /**
     * Cria nova instancia de ViewException
     */
    public ViewException() {
    }

    /**
     * Cria nova instancia de ViewException
     *
     * @param view {@code View} View que disparou o erro
     */
    public ViewException(View view) {
        this.view = view;
    }

    /**
     * Cria nova instancia de ViewException
     *
     * @param view {@code View} View que disparou o erro
     * @param message {@code String} Mensagem da exceção
     */
    public ViewException(View view, String message) {
        super(message);
        this.view = view;
    }

    /**
     * Cria nova instancia de ViewException
     *
     * @param view {@code View} View que disparou o erro
     * @param cause {@code Throwable} Causa da exceção
     */
    public ViewException(View view, Throwable cause) {
        super(cause);
        this.view = view;
    }

    /**
     * Cria nova instancia de ViewException
     *
     * @param view {@code View} View que disparou o erro
     * @param message {@code String} Mensagem da exceção
     * @param cause {@code Throwable} Causa da exceção
     */
    public ViewException(View view, String message, Throwable cause) {
        super(message, cause);
        this.view = view;
    }

    /**
     * Retorna a View que disparou o erro
     *
     * @return {@code View} View que disparou o erro
     */
    public View getView() {
        return view;
    }

    /**
     * Modifica a View que disparou o erro
     *
     * @param view {@code View} View que disparou o erro
     */
    public void setView(View view) {
        this.view = view;
    }

}
