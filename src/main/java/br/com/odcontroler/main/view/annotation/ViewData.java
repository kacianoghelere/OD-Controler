package br.com.odcontroler.main.view.annotation;

import br.com.odcontroler.main.view.enums.ViewType;
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
    String name();

    /**
     * Tipo da View
     *
     * @return {@code ViewType} Tipo da View
     */
    ViewType type();
}
