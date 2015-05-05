package br.com.urcontroler.main.view.player;

import br.com.gmp.comps.player.multi.GPlayerList;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.object.ViewParameter;

/**
 * View de controle e gerenciamento de audio
 *
 * @author kaciano
 */
public class PlayerView extends View {

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
        this.setSize(595, 335);
        this.initComponents();
        this.bean = new PlayerBean(this);
        this.setVisible(true);
    }

    @Override
    public PlayerBean getBean() {
        return bean;
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, Short.MAX_VALUE)
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.player.multi.GPlayerList gPlAmbience;
    private br.com.gmp.comps.player.multi.GPlayerList gPlBackground;
    private br.com.gmp.comps.player.multi.GPlayerList gPlEffects;
    private br.com.gmp.comps.player.multi.GPlayerList gPlMusic;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
