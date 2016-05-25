package br.com.urcontroler.data.db.entity.controller.exceptions;

/**
 * Exceção de entidade existente
 *
 * @author Kaciano Ghelere
 */
public class PreexistingEntityException extends Exception {

    /**
     * Cria nova instancia de PreexistingEntityException
     *
     * @param message {@code String} Texto da mensagem
     * @param cause {@code Throwable} Causa da exceção
     */
    public PreexistingEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Retorna Texto da mensagem
     *
     * @param message {@code String} Texto da mensagem
     */
    public PreexistingEntityException(String message) {
        super(message);
    }
}
