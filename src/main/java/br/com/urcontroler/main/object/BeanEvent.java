package br.com.urcontroler.main.object;

import br.com.gmp.utils.object.ObjectWrapper;

/**
 * Evento de transporte de dados
 *
 * @author Kaciano Ghelere
 */
public class BeanEvent {

    private Object frame;
    private Object value;
    private ObjectWrapper viewWrapper;

    /**
     * Cria nova instancia de BeanEvent
     *
     * @param wrapper {@code ViewWrapper} Objeto de transporte
     */
    public BeanEvent(ObjectWrapper wrapper) {
        this.viewWrapper = wrapper;
    }

    /**
     * Cria nova instancia de BeanEvent
     *
     * @param frame {@code Object} Tela que carregou o evento
     * @param value {@code Object} Objeto transportado
     */
    public BeanEvent(Object frame, Object value) {
        this.frame = frame;
        this.value = value;
    }

    /**
     * Retorna o frame
     *
     * @return {@code Object} Frame
     */
    public Object getFrame() {
        return frame;
    }

    /**
     * Modifica o frame
     *
     * @param frame {@code Object} Frame
     */
    public void setFrame(Object frame) {
        this.frame = frame;
    }

    /**
     * Retorna o valor transportado
     *
     * @return {@code Object} Valor transportado
     */
    public Object getValue() {
        return value;
    }

    /**
     * Modifica o valor transportado
     *
     * @param value {@code Object} Valor transportado
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Retorna o objeto de transporte
     *
     * @return {@code ObjectWrapper} Objeto de transporte
     */
    public ObjectWrapper getWrapper() {
        return viewWrapper;
    }

    /**
     * Modifica o objeto de transporte
     *
     * @param viewWrapper {@code ObjectWrapper} Objeto de transporte
     */
    public void setViewWrapper(ObjectWrapper viewWrapper) {
        this.viewWrapper = viewWrapper;
    }

}
