package br.com.odcontroler.main.view.terms;

import br.com.gmp.comps.model.GListModel;
import br.com.odcontroler.data.entity.ArmorType;
import br.com.odcontroler.data.entity.EffectType;
import br.com.odcontroler.data.entity.ExpertiseType;
import br.com.odcontroler.data.entity.PerkType;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.terms.bean.TermsBean;
import br.com.odcontroler.main.view.interfaces.BeanListener;
import br.com.odcontroler.main.view.object.ViewParameter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

/**
 * Tela para cadastro de termos comuns
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public class TermsView extends View {

    private TermsBean bean;
    private GListModel<EffectType> efModel;
    private GListModel<PerkType> perkModel;
    private GListModel<ArmorType> armorModel;
    private GListModel<ExpertiseType> expModel;

    /**
     * Cria nova instancia de TermsView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public TermsView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.setSize(375, 327);
        this.setControls(new ViewParameter(true, false, false, true));
        this.efModel = new GListModel<>();
        this.perkModel = new GListModel<>();
        this.armorModel = new GListModel<>();
        this.expModel = new GListModel<>();
        this.bean = new TermsBean(this);
        this.gLtEffectTp.setModel(efModel);
        this.gLtPerkTp.setModel(perkModel);
        this.gLtExpTp.setModel(expModel);
        this.gLtArmorTp.setModel(armorModel);
        try {
            this.bean.load(null);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adiciona novo elemento na lista de efeitos
     *
     * @param evt {@code KeyEvent} Evento do teclado
     */
    private void addEffectType(KeyEvent evt) {
        if (gTEffectTp.validateComponent()) {
            bean.addEffectTp(new BeanEvent(this, gTEffectTp.getText()));
            gTEffectTp.clear();
        }
    }

    /**
     * Remove o EffectType selecionado
     *
     * @param evt {@code KeyEvent} Evento do teclado
     */
    private void removeEffectType(KeyEvent evt) {
        if (gLtEffectTp.getModel().getSize() > 0 && gLtEffectTp.getSelectedIndex() >= 0) {
            EffectType ef = efModel.getElementAt(gLtEffectTp.getSelectedIndex());
            efModel.remove(ef);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt {@code KeyEvent} Evento do teclado
     */
    private void addPerkType(KeyEvent evt) {
        if (gTPerkTp.validateComponent()) {
            bean.addPerkTp(new BeanEvent(this, gTPerkTp.getText()));
            gTPerkTp.clear();
        }
    }

    /**
     * Remove o PerkType selecionado
     *
     * @param evt {@code KeyEvent} Evento do teclado
     */
    private void removePerkType(KeyEvent evt) {
        if (gLtPerkTp.getModel().getSize() > 0 && gLtPerkTp.getSelectedIndex() >= 0) {
            PerkType type = perkModel.getElementAt(gLtPerkTp.getSelectedIndex());
            perkModel.remove(type);
        }
    }

    /**
     * Adiciona novo elemento na lista de PerkTypes
     *
     * @param evt {@code KeyEvent} Evento do teclado
     */
    private void addExpType(KeyEvent evt) {
        if (gTExpertiseTp.validateComponent()) {
            bean.addExpTp(new BeanEvent(this, gTExpertiseTp.getText()));
            gTExpertiseTp.clear();
        }
    }

    /**
     * Remove o ExpertiseType selecionado
     *
     * @param evt {@code KeyEvent} Evento do teclado
     */
    private void removeExpType(KeyEvent evt) {
        if (gLtExpTp.getModel().getSize() > 0 && gLtExpTp.getSelectedIndex() >= 0) {
            ExpertiseType type = expModel.getElementAt(gLtExpTp.getSelectedIndex());
            expModel.remove(type);
        }
    }

    /**
     * Adiciona novo elemento na lista de ArmorTypes
     *
     * @param evt {@code KeyEvent} Evento do teclado
     * @since 1.1
     */
    private void addArmorTp(KeyEvent evt) {
        if (gTArmorTp.validateComponent()) {
            bean.addArmorType(new BeanEvent(this, gTArmorTp.getText()));
            gTArmorTp.clear();
        }
    }

    /**
     * Remove o ArmorType selecionado
     *
     * @param evt {@code KeyEvent} Evento do teclado
     * @since 1.1
     */
    private void removeArmorTp(KeyEvent evt) {
        if (gLtArmorTp.getModel().getSize() > 0 && gLtArmorTp.getSelectedIndex() >= 0) {
            ArmorType type = armorModel.getElementAt(gLtArmorTp.getSelectedIndex());
            armorModel.remove(type);
        }
    }

    /**
     * Retorna o modelo de lista dos EffectTypes
     *
     * @return {@code GListModel(EffectType)}
     */
    public GListModel<EffectType> getEfModel() {
        return efModel;
    }

    /**
     * Retorna o modelo de lista dos PerkTypes
     *
     * @return {@code GListModel(PerkType)}
     */
    public GListModel<PerkType> getPerkModel() {
        return perkModel;
    }

    /**
     * Retorna o modelo de lista dos ArmorTypes
     *
     * @return {@code GListModel(ArmorType)}
     */
    public GListModel<ArmorType> getArmorModel() {
        return armorModel;
    }

    /**
     * Retorna o modelo de lista dos ExpertiseTypes
     *
     * @return {@code GListModel(ExpertiseType)}
     */
    public GListModel<ExpertiseType> getExpModel() {
        return expModel;
    }

    @Override
    public BeanListener getBean() {
        return bean;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPPerkTypes = new javax.swing.JPanel();
        gTPerkTp = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk = new javax.swing.JScrollPane();
        gLtPerkTp = new br.com.gmp.comps.list.GList();
        jPEffects = new javax.swing.JPanel();
        gTEffectTp = new br.com.gmp.comps.textfield.GTextField();
        jSPEffect = new javax.swing.JScrollPane();
        gLtEffectTp = new br.com.gmp.comps.list.GList();
        jPExpertiseTypes = new javax.swing.JPanel();
        gTExpertiseTp = new br.com.gmp.comps.textfield.GTextField();
        jSPExpertise = new javax.swing.JScrollPane();
        gLtExpTp = new br.com.gmp.comps.list.GList();
        jPArmorTypes = new javax.swing.JPanel();
        gTArmorTp = new br.com.gmp.comps.textfield.GTextField();
        jSPArmorTp = new javax.swing.JScrollPane();
        gLtArmorTp = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Termos comuns");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(375, 327));
        setMinimumSize(new java.awt.Dimension(375, 327));
        setPreferredSize(new java.awt.Dimension(375, 327));

        jTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPPerkTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Vantagens"));

        gTPerkTp.setPlaceholder("Tipos de vantagens");
        gTPerkTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTPerkTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTPerkTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTPerkTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTPerkTpKeyReleased(evt);
            }
        });

        gLtPerkTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtPerkTpKeyReleased(evt);
            }
        });
        jSPPerk.setViewportView(gLtPerkTp);

        javax.swing.GroupLayout jPPerkTypesLayout = new javax.swing.GroupLayout(jPPerkTypes);
        jPPerkTypes.setLayout(jPPerkTypesLayout);
        jPPerkTypesLayout.setHorizontalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTPerkTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPPerkTypesLayout.setVerticalGroup(
            jPPerkTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPerkTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTPerkTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Vantagens", jPPerkTypes);

        jPEffects.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Efeitos"));

        gTEffectTp.setPlaceholder("Tipos de efeitos");
        gTEffectTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTEffectTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTEffectTp.setNextFocusableComponent(gTPerkTp);
        gTEffectTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTEffectTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTEffectTpKeyReleased(evt);
            }
        });

        gLtEffectTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtEffectTpKeyReleased(evt);
            }
        });
        jSPEffect.setViewportView(gLtEffectTp);

        javax.swing.GroupLayout jPEffectsLayout = new javax.swing.GroupLayout(jPEffects);
        jPEffects.setLayout(jPEffectsLayout);
        jPEffectsLayout.setHorizontalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTEffectTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPEffect, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEffectsLayout.setVerticalGroup(
            jPEffectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEffectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPEffect, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTEffectTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Efeitos", jPEffects);

        jPExpertiseTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Perícias"));

        gTExpertiseTp.setPlaceholder("Tipos de perícias");
        gTExpertiseTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTExpertiseTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTExpertiseTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTExpertiseTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTExpertiseTpKeyReleased(evt);
            }
        });

        gLtExpTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtExpTpKeyReleased(evt);
            }
        });
        jSPExpertise.setViewportView(gLtExpTp);

        javax.swing.GroupLayout jPExpertiseTypesLayout = new javax.swing.GroupLayout(jPExpertiseTypes);
        jPExpertiseTypes.setLayout(jPExpertiseTypesLayout);
        jPExpertiseTypesLayout.setHorizontalGroup(
            jPExpertiseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExpertiseTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPExpertiseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTExpertiseTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPExpertise, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPExpertiseTypesLayout.setVerticalGroup(
            jPExpertiseTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPExpertiseTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPExpertise, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTExpertiseTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Perícias", jPExpertiseTypes);

        jPArmorTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Perícias"));

        gTArmorTp.setPlaceholder("Tipos de perícias");
        gTArmorTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTArmorTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTArmorTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTArmorTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTArmorTpKeyReleased(evt);
            }
        });

        gLtArmorTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtArmorTpKeyReleased(evt);
            }
        });
        jSPArmorTp.setViewportView(gLtArmorTp);

        javax.swing.GroupLayout jPArmorTypesLayout = new javax.swing.GroupLayout(jPArmorTypes);
        jPArmorTypes.setLayout(jPArmorTypesLayout);
        jPArmorTypesLayout.setHorizontalGroup(
            jPArmorTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPArmorTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPArmorTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTArmorTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPArmorTp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPArmorTypesLayout.setVerticalGroup(
            jPArmorTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPArmorTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPArmorTp, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTArmorTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Tipo de armadura", jPArmorTypes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gTEffectTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTEffectTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addEffectType(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTEffectTpKeyReleased

    private void gTPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTPerkTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addPerkType(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTPerkTpKeyReleased

    private void gLtEffectTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtEffectTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeEffectType(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtEffectTpKeyReleased

    private void gLtPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtPerkTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removePerkType(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtPerkTpKeyReleased

    private void gTExpertiseTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTExpertiseTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addExpType(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTExpertiseTpKeyReleased

    private void gLtExpTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtExpTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeExpType(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtExpTpKeyReleased

    private void gTArmorTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTArmorTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addArmorTp(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTArmorTpKeyReleased

    private void gLtArmorTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtArmorTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            try {
                removeArmorTp(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gLtArmorTpKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gLtArmorTp;
    private br.com.gmp.comps.list.GList gLtEffectTp;
    private br.com.gmp.comps.list.GList gLtExpTp;
    private br.com.gmp.comps.list.GList gLtPerkTp;
    private br.com.gmp.comps.textfield.GTextField gTArmorTp;
    private br.com.gmp.comps.textfield.GTextField gTEffectTp;
    private br.com.gmp.comps.textfield.GTextField gTExpertiseTp;
    private br.com.gmp.comps.textfield.GTextField gTPerkTp;
    private javax.swing.JPanel jPArmorTypes;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPExpertiseTypes;
    private javax.swing.JPanel jPPerkTypes;
    private javax.swing.JScrollPane jSPArmorTp;
    private javax.swing.JScrollPane jSPEffect;
    private javax.swing.JScrollPane jSPExpertise;
    private javax.swing.JScrollPane jSPPerk;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
