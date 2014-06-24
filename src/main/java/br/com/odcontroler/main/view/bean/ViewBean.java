package br.com.odcontroler.main.view.bean;

import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.interfaces.BeanListener;

/**
 * Bean padrão para implementação de ViewBeans
 *
 * @author kaciano
 * @version 1.0
 * @param <T> Tipo da View
 */
public class ViewBean<T> implements BeanListener<T> {

    private final T view;

    /**
     * Cria nova instancia de DefaultViewBean
     *
     * @param view <code>DefaultView</code> View do bean
     * @see br.com.rpgruler.main.view.View
     */
    public ViewBean(T view) {
        this.view = view;
    }

    @Override
    public void commit(BeanEvent evt) throws Exception {
        System.out.println("Save not implemented yet.");
    }

    @Override
    public void process(BeanEvent evt) throws Exception {
        System.out.println("Process not implemented yet.");
    }

    @Override
    public void clear(BeanEvent evt) throws Exception {
        System.out.println("Clear not implemented yet.");
    }

    @Override
    public void load(BeanEvent evt) throws Exception {
        System.out.println("Load not implemented yet.");
    }

    /**
     * Método para adição de conteúdos
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    public void add(BeanEvent evt) throws Exception {
        System.out.println("Add not implemented yet.");
    }

    /**
     * Método para edição de conteúdos
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    public void edit(BeanEvent evt) throws Exception {
        System.out.println("Edit not implemented yet.");
    }

    /**
     * Método para construção de conteúdos
     *
     * @param evt <code>BeanEvent</code> Evento do Bean
     * @throws java.lang.Exception Propagação de exceção
     */
    public void build(BeanEvent evt) throws Exception {
        System.out.println("Build not implemented yet.");
    }

    @Override
    public T getView() {
        return view;
    }

}
