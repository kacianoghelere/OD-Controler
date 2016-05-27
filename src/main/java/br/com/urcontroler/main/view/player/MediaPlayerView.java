package br.com.urcontroler.main.view.player;

import br.com.gmp.comps.player.multi.GPlayerList;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.util.DescriptionObject;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.object.ViewParameter;

/**
 * View de controle e gerenciamento de audio
 *
 * @author Kaciano Ghelere
 */
public class MediaPlayerView extends View<MediaPlayerBean> {

    private MediaPlayerBean bean;

    /**
     * Cria nova instancia de PlayerView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public MediaPlayerView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(false, true, false, true));
        this.setSize(640, 315);
        this.initComponents();
        this.bean = new MediaPlayerBean(this);
        this.setVisible(true);
    }

    @Override
    public MediaPlayerBean getBean() {
        return this.bean;
    }

    /**
     * Executa o arquivo de audio após o click da tabela
     *
     * @param evt {@code java.awt.event.MouseEvent} Evento do mouse
     * @param player {@code GPlayerList} Reprodutor de audio
     * @throws java.lang.Exception Exceção
     */
    public void executeClick(java.awt.event.MouseEvent evt, GPlayerList player) throws Exception {
        if (evt.getClickCount() == 2) {
            player.execute("play");
        }
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

    @Override
    public DescriptionObject getDescription() {
        return new DescriptionObject.Builder()
                .setTitle("MediaPlayer")
                .setLoad("Recarrega os arquivos de audio")
                .setProcess("Reprocessa a lista de arquivos de audio")
                .setDescription("Tela de reprodução de arquivos de audio")
                .apply();
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
        jTabPlayers = new javax.swing.JTabbedPane();
        gPlAmbience = new br.com.gmp.comps.player.multi.GPlayerList();
        gPlBackground = new br.com.gmp.comps.player.multi.GPlayerList();
        gPlMusic = new br.com.gmp.comps.player.multi.GPlayerList();
        gPlEffects = new br.com.gmp.comps.player.multi.GPlayerList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Efeitos sonoros");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/multimedia/music2.png"))); // NOI18N
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

        jTabPlayers.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        gPlAmbience.setBorder(javax.swing.BorderFactory.createTitledBorder("Ambiente"));
        gPlAmbience.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gPlAmbienceMouseClicked(evt);
            }
        });
        jTabPlayers.addTab("Ambiente", gPlAmbience);

        gPlBackground.setBorder(javax.swing.BorderFactory.createTitledBorder("Sons de fundo"));
        gPlBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gPlBackgroundMouseClicked(evt);
            }
        });
        jTabPlayers.addTab("Sons de Fundo", gPlBackground);

        gPlMusic.setBorder(javax.swing.BorderFactory.createTitledBorder("Músicas"));
        gPlMusic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gPlMusicMouseClicked(evt);
            }
        });
        jTabPlayers.addTab("Músicas", gPlMusic);

        gPlEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Efeitos"));
        gPlEffects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gPlEffectsMouseClicked(evt);
            }
        });
        jTabPlayers.addTab("Efeitos", gPlEffects);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabPlayers, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        closePlayers();
    }//GEN-LAST:event_formInternalFrameClosing

    private void gPlAmbienceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gPlAmbienceMouseClicked
        try {
            executeClick(evt, gPlAmbience);
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_gPlAmbienceMouseClicked

    private void gPlBackgroundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gPlBackgroundMouseClicked
        try {
            executeClick(evt, gPlBackground);
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_gPlBackgroundMouseClicked

    private void gPlMusicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gPlMusicMouseClicked
        try {
            executeClick(evt, gPlMusic);
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_gPlMusicMouseClicked

    private void gPlEffectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gPlEffectsMouseClicked
        try {
            executeClick(evt, gPlEffects);
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_gPlEffectsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.player.multi.GPlayerList gPlAmbience;
    private br.com.gmp.comps.player.multi.GPlayerList gPlBackground;
    private br.com.gmp.comps.player.multi.GPlayerList gPlEffects;
    private br.com.gmp.comps.player.multi.GPlayerList gPlMusic;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTabbedPane jTabPlayers;
    // End of variables declaration//GEN-END:variables
}
