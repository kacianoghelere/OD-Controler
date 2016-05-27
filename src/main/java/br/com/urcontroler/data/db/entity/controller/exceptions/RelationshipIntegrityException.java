package br.com.urcontroler.data.db.entity.controller.exceptions;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

/**
 * Exceção de violação de integridade de dados
 *
 * @author Kaciano Ghelere
 */
public class RelationshipIntegrityException extends MySQLIntegrityConstraintViolationException {

    /**
     * Retorna texto da mensagem
     *
     * @param message {@code String} Texto da mensagem
     */
    public RelationshipIntegrityException(String message) {
        super(message);
    }
}
