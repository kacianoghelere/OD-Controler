package br.com.urcontroler.main.view.bind;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Objeto base para modelos de vinculacao de views
 *
 * @author kaciano
 */
public class BindObject {

    private final PropertyChangeSupport props = new PropertyChangeSupport(this);

    /**
     * Retorna o suporte de propriedades
     *
     * @return {@code PropertyChangeSupport} Suporte de propriedades
     */
    protected PropertyChangeSupport getProperties() {
        return props;
    }

    /**
     * Adiciona novo listener
     *
     * @param listener {@code PropertyChangeListener} Controlador de eventos
     */
    protected void addPropertyChangeListener(PropertyChangeListener listener) {
        props.addPropertyChangeListener(listener);
    }

    /**
     * Adiciona novo listener de uma propriedade especifica
     *
     * @param propName {@code String} Nome da propriedade
     * @param listener {@code PropertyChangeListener} Controlador de eventos
     */
    protected void addPropertyChangeListener(String propName, PropertyChangeListener listener) {
        props.addPropertyChangeListener(propName, listener);
    }

    /**
     * Remove o listener de uma propriedade
     *
     * @param listener {@code PropertyChangeListener} Controlador de eventos
     */
    protected void removePropertyChangeListener(PropertyChangeListener listener) {
        props.removePropertyChangeListener(listener);
    }

    /**
     * Remove o listener de uma propriedade especifica
     *
     * @param propName {@code String} Nome da propriedade
     * @param listener {@code PropertyChangeListener} Controlador de eventos
     */
    protected void removePropertyChangeListener(String propName, PropertyChangeListener listener) {
        props.removePropertyChangeListener(propName, listener);
    }
}
