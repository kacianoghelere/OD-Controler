package br.com.rpgruler.main.view.sub;

import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.interfaces.BeanListener;

/**
 * View genérica para views secundárias
 *
 * @author kaciano
 * @version 1.0
 */
public class SubView extends View {

    private View parentView;

    /**
     * Cria nova instancia de SubView
     *
     * @param parent <code>View</code> Tela pai
     */
    public SubView(View parent) {
        super(parent.getMainScreen());
        this.parentView = parent;
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
    }

    @Override
    public BeanListener getBean() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Retorna a view pai
     *
     * @return <code>View</code> Tela pai
     */
    public View getParentView() {
        return parentView;
    }

    /**
     * Modifica a view pai
     *
     * @param parentView <code>View</code> Tela pai
     */
    public void setParentView(View parentView) {
        this.parentView = parentView;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
