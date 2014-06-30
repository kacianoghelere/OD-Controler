package br.com.odcontroler.main.view.attr;

import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.attr.bean.AttrBean;

/**
 * Tela para cadastro e controle de faixas de atributos
 *
 * @author kaciano
 */
public class AttrView extends View {

    private AttrBean bean;

    /**
     * Cria nova instancia de AttrView
     *
     * @param mainScreen {@code MainScreen} Tela Principal
     */
    public AttrView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
        this.bean = new AttrBean(this);
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
    }

    @Override
    public AttrBean getBean() {
        return this.bean;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
