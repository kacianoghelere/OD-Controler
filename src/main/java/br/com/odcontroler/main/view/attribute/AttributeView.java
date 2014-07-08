package br.com.odcontroler.main.view.attribute;

import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.attribute.bean.AttributeBean;

/**
 * Tela para cadastro e controle de faixas de atributos
 *
 * @author kaciano
 * @version 1.0
 */
public class AttributeView extends View {

    private final AttributeBean bean;

    /**
     * Cria nova instancia de AttributeView
     *
     * @param mainScreen {@code MainScreen} Tela Principal
     */
    public AttributeView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
        this.bean = new AttributeBean(this);
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
    }

    @Override
    public AttributeBean getBean() {
        return this.bean;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPAttributes = new javax.swing.JTabbedPane();
        jPT1_1 = new javax.swing.JPanel();
        jPT1_4 = new javax.swing.JPanel();
        jPT1_2 = new javax.swing.JPanel();
        jPT1_3 = new javax.swing.JPanel();
        jPT1_5 = new javax.swing.JPanel();
        jPT1_6 = new javax.swing.JPanel();

        jTPAttributes.addTab("T1-1 Força", jPT1_1);
        jTPAttributes.addTab("T1-4 Destreza", jPT1_4);
        jTPAttributes.addTab("T1-2 Inteligencia", jPT1_2);
        jTPAttributes.addTab("T1-3 Sabedoria", jPT1_3);
        jTPAttributes.addTab("T1-5 Constituição", jPT1_5);
        jTPAttributes.addTab("T1-6 Carisma", jPT1_6);

        getContentPane().add(jTPAttributes, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPT1_1;
    private javax.swing.JPanel jPT1_2;
    private javax.swing.JPanel jPT1_3;
    private javax.swing.JPanel jPT1_4;
    private javax.swing.JPanel jPT1_5;
    private javax.swing.JPanel jPT1_6;
    private javax.swing.JTabbedPane jTPAttributes;
    // End of variables declaration//GEN-END:variables
}
