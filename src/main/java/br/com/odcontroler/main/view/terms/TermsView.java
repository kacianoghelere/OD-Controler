package br.com.odcontroler.main.view.terms;

import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.comps.textfield.GTextField;
import br.com.odcontroler.data.entity.ArmorType;
import br.com.odcontroler.data.entity.EffectType;
import br.com.odcontroler.data.entity.Element;
import br.com.odcontroler.data.entity.ExpertiseType;
import br.com.odcontroler.data.entity.ItemType;
import br.com.odcontroler.data.entity.Material;
import br.com.odcontroler.data.entity.PerkType;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.terms.bean.TermsBean;
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
    private GListModel<EffectType> effectModel;
    private GListModel<PerkType> perkModel;
    private GListModel<ArmorType> armorModel;
    private GListModel<ExpertiseType> expertiseModel;
    private GListModel<Material> materialModel;
    private GListModel<Element> elementModel;
    private GListModel<ItemType> itemModel;

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
        this.setControls(new ViewParameter(true, false, true, true));
        this.effectModel = new GListModel<>();
        this.perkModel = new GListModel<>();
        this.armorModel = new GListModel<>();
        this.expertiseModel = new GListModel<>();
        this.materialModel = new GListModel<>();
        this.elementModel = new GListModel<>();
        this.itemModel = new GListModel<>();
        this.bean = new TermsBean(this);
        this.gLtEffectTp.setModel(effectModel);
        this.gLtPerkTp.setModel(perkModel);
        this.gLtExpTp.setModel(expertiseModel);
        this.gLtArmorTp.setModel(armorModel);
        this.gLtMaterials.setModel(materialModel);
        this.gLtElement.setModel(elementModel);
        this.gLtItemTp.setModel(itemModel);
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
     * Adiciona novo elemento na lista de Materials
     *
     * @param evt {@code KeyEvent} Evento do teclado
     * @since 1.1
     */
    private void addMaterial(KeyEvent evt) {
        if (gTMaterial.validateComponent()) {
            bean.addMaterial(new BeanEvent(this, gTMaterial.getText()));
            gTMaterial.clear();
        }
    }

    /**
     * Adiciona novo elemento na lista de Elements
     *
     * @param evt {@code KeyEvent} Evento do teclado
     * @since 1.1
     */
    private void addElement(KeyEvent evt) {
        if (gTElement.validateComponent()) {
            bean.addElement(new BeanEvent(this, gTElement.getText()));
            gTElement.clear();
        }
    }

    /**
     * Adiciona novo elemento na lista de Elements
     *
     * @param evt {@code KeyEvent} Evento do teclado
     * @since 1.1
     */
    private void addItem(KeyEvent evt) {
        if (gTItemTp.validateComponent()) {
            bean.addItem(new BeanEvent(this, gTItemTp.getText()));
            gTItemTp.clear();
        }
    }

    /**
     * Adiciona novo elemento na lista de Elements
     *
     * @param textfield {@code GTextField} Campo de texto
     * @param object {@code Object} Objeto à ser adicionado
     * @param model {@code GListModel} Modelo da lista
     */
    private void add(GTextField textfield, Object object, GListModel model) {
        if (textfield.validateComponent()) {
            model.add(object);
            textfield.clear();
        }
    }

    /**
     * Remove o item da lista indicada
     *
     * @param glist {@code GList} GLista
     * @param model {@code GListModel} Modelo da lista
     */
    private void remove(GList glist, GListModel model) {
        if (glist.getModel().getSize() > 0 && glist.getSelectedIndex() >= 0) {
            Object type = model.getElementAt(glist.getSelectedIndex());
            model.remove(type);
        }
    }

    /**
     * Retorna o modelo de lista dos EffectTypes
     *
     * @return {@code GListModel(EffectType)}
     */
    public GListModel<EffectType> getEffectModel() {
        return effectModel;
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
    public GListModel<ExpertiseType> getExpertiseModel() {
        return expertiseModel;
    }

    /**
     * Retorna o modelo de lista dos Materials
     *
     * @return {@code GListModel(Material)}
     */
    public GListModel<Material> getMaterialModel() {
        return materialModel;
    }

    /**
     * Retorna o modelo de lista dos Elements
     *
     * @return {@code GListModel(Element)}
     */
    public GListModel<Element> getElementModel() {
        return elementModel;
    }

    /**
     * Retorna o modelo de lista dos ItemTypes
     *
     * @return {@code GListModel(ItemType)}
     */
    public GListModel<ItemType> getItemModel() {
        return itemModel;
    }

    @Override
    public TermsBean getBean() {
        return bean;
    }

    /**
     * Códigos gerados automaticamente
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
        jPMaterials = new javax.swing.JPanel();
        gTMaterial = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk1 = new javax.swing.JScrollPane();
        gLtMaterials = new br.com.gmp.comps.list.GList();
        jPElement = new javax.swing.JPanel();
        gTElement = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk2 = new javax.swing.JScrollPane();
        gLtElement = new br.com.gmp.comps.list.GList();
        jPItemType = new javax.swing.JPanel();
        gTItemTp = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk3 = new javax.swing.JScrollPane();
        gLtItemTp = new br.com.gmp.comps.list.GList();

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

        gTArmorTp.setPlaceholder("Tipos de Armaduras");
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

        jTabbedPane.addTab("Armaduras", jPArmorTypes);

        jPMaterials.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Materiais"));

        gTMaterial.setPlaceholder("Tipos de Materiais");
        gTMaterial.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTMaterial.setMinimumSize(new java.awt.Dimension(150, 28));
        gTMaterial.setPreferredSize(new java.awt.Dimension(150, 28));
        gTMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTMaterialKeyReleased(evt);
            }
        });

        gLtMaterials.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtMaterialsKeyReleased(evt);
            }
        });
        jSPPerk1.setViewportView(gLtMaterials);

        javax.swing.GroupLayout jPMaterialsLayout = new javax.swing.GroupLayout(jPMaterials);
        jPMaterials.setLayout(jPMaterialsLayout);
        jPMaterialsLayout.setHorizontalGroup(
            jPMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMaterialsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPMaterialsLayout.setVerticalGroup(
            jPMaterialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMaterialsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Materiais", jPMaterials);

        jPElement.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Elementos"));

        gTElement.setPlaceholder("Tipos de Elementos");
        gTElement.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTElement.setMinimumSize(new java.awt.Dimension(150, 28));
        gTElement.setPreferredSize(new java.awt.Dimension(150, 28));
        gTElement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTElementKeyReleased(evt);
            }
        });

        gLtElement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtElementKeyReleased(evt);
            }
        });
        jSPPerk2.setViewportView(gLtElement);

        javax.swing.GroupLayout jPElementLayout = new javax.swing.GroupLayout(jPElement);
        jPElement.setLayout(jPElementLayout);
        jPElementLayout.setHorizontalGroup(
            jPElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPElementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPElementLayout.setVerticalGroup(
            jPElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPElementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Elementos", jPElement);

        jPItemType.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Itens"));

        gTItemTp.setPlaceholder("Tipos de Itens");
        gTItemTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTItemTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTItemTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTItemTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTItemTpKeyReleased(evt);
            }
        });

        gLtItemTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtItemTpKeyReleased(evt);
            }
        });
        jSPPerk3.setViewportView(gLtItemTp);

        javax.swing.GroupLayout jPItemTypeLayout = new javax.swing.GroupLayout(jPItemType);
        jPItemType.setLayout(jPItemTypeLayout);
        jPItemTypeLayout.setHorizontalGroup(
            jPItemTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPItemTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPItemTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTItemTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPItemTypeLayout.setVerticalGroup(
            jPItemTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPItemTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk3, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTItemTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Itens", jPItemType);

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
            remove(gLtEffectTp, effectModel);
        }
    }//GEN-LAST:event_gLtEffectTpKeyReleased

    private void gLtPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtPerkTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtPerkTp, perkModel);
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
            remove(gLtExpTp, expertiseModel);
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
            remove(gLtArmorTp, armorModel);
        }
    }//GEN-LAST:event_gLtArmorTpKeyReleased

    private void gTMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTMaterialKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addMaterial(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTMaterialKeyReleased

    private void gLtMaterialsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtMaterialsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtMaterials, materialModel);
        }
    }//GEN-LAST:event_gLtMaterialsKeyReleased

    private void gTElementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTElementKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addElement(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTElementKeyReleased

    private void gLtElementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtElementKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtElement, elementModel);
        }
    }//GEN-LAST:event_gLtElementKeyReleased

    private void gTItemTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTItemTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                addItem(evt);
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_gTItemTpKeyReleased

    private void gLtItemTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtItemTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtItemTp, itemModel);
        }
    }//GEN-LAST:event_gLtItemTpKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gLtArmorTp;
    private br.com.gmp.comps.list.GList gLtEffectTp;
    private br.com.gmp.comps.list.GList gLtElement;
    private br.com.gmp.comps.list.GList gLtExpTp;
    private br.com.gmp.comps.list.GList gLtItemTp;
    private br.com.gmp.comps.list.GList gLtMaterials;
    private br.com.gmp.comps.list.GList gLtPerkTp;
    private br.com.gmp.comps.textfield.GTextField gTArmorTp;
    private br.com.gmp.comps.textfield.GTextField gTEffectTp;
    private br.com.gmp.comps.textfield.GTextField gTElement;
    private br.com.gmp.comps.textfield.GTextField gTExpertiseTp;
    private br.com.gmp.comps.textfield.GTextField gTItemTp;
    private br.com.gmp.comps.textfield.GTextField gTMaterial;
    private br.com.gmp.comps.textfield.GTextField gTPerkTp;
    private javax.swing.JPanel jPArmorTypes;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPElement;
    private javax.swing.JPanel jPExpertiseTypes;
    private javax.swing.JPanel jPItemType;
    private javax.swing.JPanel jPMaterials;
    private javax.swing.JPanel jPPerkTypes;
    private javax.swing.JScrollPane jSPArmorTp;
    private javax.swing.JScrollPane jSPEffect;
    private javax.swing.JScrollPane jSPExpertise;
    private javax.swing.JScrollPane jSPPerk;
    private javax.swing.JScrollPane jSPPerk1;
    private javax.swing.JScrollPane jSPPerk2;
    private javax.swing.JScrollPane jSPPerk3;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
