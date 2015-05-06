package br.com.urcontroler.main.view.player;

import br.com.gmp.comps.player.multi.GPlayerList;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.io.IOException;
import javazoom.jl.decoder.BitstreamException;

/**
 * View de controle e gerenciamento de audio
 *
 * @author kaciano
 */
public class PlayerView extends View<PlayerBean> {

    private PlayerBean bean;

    /**
     * Cria nova instancia de PlayerView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public PlayerView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(false, false, false, true));
        this.setSize(640, 315);
        this.initComponents();
        this.bean = new PlayerBean(this);
        this.setVisible(true);
    }

    @Override
    public PlayerBean getBean() {
        return bean;
    }

    /**
     * Termina todas as reproduções ao fechar o frame
     */
    public void closePlayers() {
        try {
            this.gPlAmbience.execute("close");
            this.gPlBackground.execute("close");
            this.gPlEffects.execute("close");
            this.gPlMusic.execute("close");
        } catch (Exception ex) {
            this.throwException(new ViewException(this, ex));
        }
    }

    /**
     * Retorn a lista de sons do ambiente
     *
     * @return {@code GPlayerList} Lista de sons do ambiente
     */
    public GPlayerList getAmbience() {
        return this.gPlAmbience;
    }

    /**
     * Retorn a lista de sons de fundo
     *
     * @return {@code GPlayerList} Lista de sons de fundo
     */
    public GPlayerList getBackgrounds() {
        return this.gPlBackground;
    }

    /**
     * Retorn a lista de efeitos sonoros
     *
     * @return {@code GPlayerList} Lista de efeitos sonoros
     */
    public GPlayerList getEffects() {
        return this.gPlEffects;
    }

    /**
     * Retorn a lista de musicas
     *
     * @return {@code GPlayerList} Lista de musicas
     */
    public GPlayerList getMusic() {
        return this.gPlMusic;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        gPlAmbience = new br.com.gmp.comps.player.multi.GPlayerList();
        gPlBackground = new br.com.gmp.comps.player.multi.GPlayerList();
        gPlMusic = new br.com.gmp.comps.player.multi.GPlayerList();
        gPlEffects = new br.com.gmp.comps.player.multi.GPlayerList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Efeitos sonoros");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/multimedia/unpause.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(640, 315));
        setMinimumSize(new java.awt.Dimension(640, 315));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        gPlAmbience.setBorder(javax.swing.BorderFactory.createTitledBorder("Ambiente"));
        jTabbedPane1.addTab("Ambiente", gPlAmbience);

        gPlBackground.setBorder(javax.swing.BorderFactory.createTitledBorder("Sons de fundo"));
        jTabbedPane1.addTab("Sons de Fundo", gPlBackground);

        gPlMusic.setBorder(javax.swing.BorderFactory.createTitledBorder("Músicas"));
        jTabbedPane1.addTab("Músicas", gPlMusic);

        gPlEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Efeitos"));
        jTabbedPane1.addTab("Efeitos", gPlEffects);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        closePlayers();
    }//GEN-LAST:event_formInternalFrameClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.player.multi.GPlayerList gPlAmbience;
    private br.com.gmp.comps.player.multi.GPlayerList gPlBackground;
    private br.com.gmp.comps.player.multi.GPlayerList gPlEffects;
    private br.com.gmp.comps.player.multi.GPlayerList gPlMusic;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
