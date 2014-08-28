package br.com.urcontroler.main.view.annotation;

import br.com.urcontroler.main.view.enums.ViewType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Interface do tipo anotação para dados de telas
 *
 * @author kaciano
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ViewData {

    /**
     * Nome da View
     *
     * @return {@code String} Nome da View
     */
    public String name();

    /**
     * Caminho da View
     *
     * @return {@code String} Caminho da View
     */
    public String[] path();

    /**
     * Tipo da View
     *
     * @return {@code ViewType} Tipo da View
     */
    public ViewType type();
}
