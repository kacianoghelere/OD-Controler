package br.com.urcontroler.data.db.entity.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Exceção de entidade relacionada
 *
 * @author Kaciano Ghelere
 */
public class IllegalOrphanException extends Exception {

    private List<String> messages;

    /**
     * Cria nova instancia de IllegalOrphanException
     *
     * @param messages {@code List(String)} Lista de mensagens
     */
    public IllegalOrphanException(List<String> messages) {
        super((messages != null && messages.size() > 0 ? messages.get(0) : null));
        if (messages == null) {
            this.messages = new ArrayList<String>();
        } else {
            this.messages = messages;
        }
    }

    /**
     * Retorna Lista de mensagens
     *
     * @return {@code List(String)} Lista de mensagens
     */
    public List<String> getMessages() {
        return messages;
    }
}
