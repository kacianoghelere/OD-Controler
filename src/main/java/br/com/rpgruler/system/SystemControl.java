package br.com.rpgruler.system;

import br.com.gmp.utils.annotations.Intercept;
import br.com.gmp.utils.interceptors.InterceptorModule;
import br.com.gmp.utils.system.SystemProperties;
import br.com.rpgruler.main.MainScreen;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe de inicialização da aplicação
 *
 * @author kaciano
 */
public class SystemControl {

    /**
     * Cria nova instancia de SystemControl
     */
    public SystemControl() {
        System.out.println("-------------------------------------------------"
                + "\nSistema operacional: " + SystemProperties.OS_NAME.toUpperCase()
                + " - " + SystemProperties.OS_ARCH
                + "\nVersão do Java: " + SystemProperties.JAVA_VERSION
                + "\nUsuário: " + SystemProperties.USER_NAME.toUpperCase()
                + "\nPasta principal: " + SystemProperties.USER_HOME
                + "\n-------------------------------------------------\n");
    }

    /**
     * Carrega a tela principal
     *
     * @return <code>SystemControl</code>
     */
    @Intercept
    public SystemControl loadScreen() {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
        return this;
    }

    /**
     * Método de inicialização principal
     *
     * @param args Argumentos
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SystemControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Injector injector = Guice.createInjector(new InterceptorModule());
        SystemControl controls = injector.getInstance(SystemControl.class);
        controls.loadScreen();
    }
}
