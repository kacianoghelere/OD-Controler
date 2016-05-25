package br.com.urcontroler.data.db.entity.controller.exceptions;

/**
 * Exceção de entidade inexistente
 *
 * @author Kaciano Ghelere
 */
public class NonexistentEntityException extends Exception {

    /**
     * Cria nova instancia de NonexistentEntityException
     *
     * @param message {@code String} Texto da mensagem
     * @param cause {@code Throwable} Causa da exceção
     */
    public NonexistentEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Retorna texto da mensagem
     *
     * @param message {@code String} Texto da mensagem
     */
    public NonexistentEntityException(String message) {
        super(message);
    }
}
