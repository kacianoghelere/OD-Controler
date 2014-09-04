package br.com.urcontroler.main.view.type;

import br.com.gmp.comps.list.GList;
import br.com.gmp.comps.model.GListModel;
import br.com.gmp.comps.textfield.GTextField;
import br.com.urcontroler.data.entity.ArmorType;
import br.com.urcontroler.data.entity.EffectType;
import br.com.urcontroler.data.entity.ElementType;
import br.com.urcontroler.data.entity.ExpertiseType;
import br.com.urcontroler.data.entity.ItemType;
import br.com.urcontroler.data.entity.LanguageType;
import br.com.urcontroler.data.entity.SpellType;
import br.com.urcontroler.data.entity.MaterialType;
import br.com.urcontroler.data.entity.PerkType;
import br.com.urcontroler.data.entity.SkillType;
import br.com.urcontroler.data.entity.Type;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.annotation.ViewData;
import br.com.urcontroler.main.view.enums.ViewType;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.awt.event.KeyEvent;

/**
 * Tela para cadastro de termos comuns
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
@ViewData(name = "Controle de tipos", type = ViewType.CRUD, path = {""})
public class TypeView extends View<TypeBean> {

    private TypeBean bean;
    private GListModel<EffectType> effectModel;
    private GListModel<PerkType> perkModel;
    private GListModel<ArmorType> armorModel;
    private GListModel<ExpertiseType> expertiseModel;
    private GListModel<MaterialType> materialModel;
    private GListModel<ElementType> elementModel;
    private GListModel<ItemType> itemModel;
    private GListModel<SpellType> spellModel;
    private GListModel<LanguageType> languageModel;
    private GListModel<SkillType> skillModel;

    /**
     * Cria nova instancia de TypeView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public TypeView(MainScreen mainScreen) {
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
        //----------------------------------------------------------------------
        // Inicialização dos modelos
        this.effectModel = new GListModel<>();
        this.perkModel = new GListModel<>();
        this.armorModel = new GListModel<>();
        this.expertiseModel = new GListModel<>();
        this.materialModel = new GListModel<>();
        this.elementModel = new GListModel<>();
        this.itemModel = new GListModel<>();
        this.spellModel = new GListModel<>();
        this.languageModel = new GListModel<>();
        this.skillModel = new GListModel<>();
        //----------------------------------------------------------------------
        // Inicialização do bean
        this.bean = new TypeBean(this);
        //----------------------------------------------------------------------
        // Atribuição dos modelos nas listas
        this.gLtEffectTp.setModel(effectModel);
        this.gLtPerkTp.setModel(perkModel);
        this.gLtExpTp.setModel(expertiseModel);
        this.gLtArmorTp.setModel(armorModel);
        this.gLtMaterials.setModel(materialModel);
        this.gLtElement.setModel(elementModel);
        this.gLtItemTp.setModel(itemModel);
        this.gLtSpellTp.setModel(spellModel);
        this.gLtLangTp.setModel(languageModel);
        this.gLtSkillTp.setModel(skillModel);
    }

    /**
     * Adiciona novo elemento na lista de Elements
     *
     * @param evt {@code KeyEvent} Evento do clique
     * @param textfield {@code GTextField} Campo de texto
     * @param object {@code Object} Objeto à ser adicionado
     * @param model {@code GListModel} Modelo da lista
     */
    private void add(java.awt.event.KeyEvent evt, GTextField textfield, Object object, GListModel model) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                add(textfield, object, model);
            } catch (Exception ex) {
                throwException(new ViewException(this, ex));
            }
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
            Type type = (Type) object;
            type.setId(bean.getNextID(model.getData()));
            type.setName(textfield.getText());
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
     * @return {@code GListModel(MaterialType)}
     */
    public GListModel<MaterialType> getMaterialModel() {
        return materialModel;
    }

    /**
     * Retorna o modelo de lista dos Elements
     *
     * @return {@code GListModel(ElementType)}
     */
    public GListModel<ElementType> getElementModel() {
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

    /**
     * Retorna o modelo de lista dos SpellTypes
     *
     * @return {@code GListModel(SpellType)}
     */
    public GListModel<SpellType> getSpellModel() {
        return spellModel;
    }

    /**
     * Retorna o modelo de lista dos LanguageTypes
     *
     * @return {@code GListModel(LanguageType)}
     */
    public GListModel<LanguageType> getLangModel() {
        return languageModel;
    }

    /**
     * Retorna o modelo de lista dos SkillTypes
     *
     * @return {@code GListModel(SkillType)}
     */
    public GListModel<SkillType> getSkillModel() {
        return skillModel;
    }

    @Override
    public TypeBean getBean() {
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
        jPMagicType = new javax.swing.JPanel();
        gTSpellTp = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk4 = new javax.swing.JScrollPane();
        gLtSpellTp = new br.com.gmp.comps.list.GList();
        jPLanguageType = new javax.swing.JPanel();
        gTLangTp = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk5 = new javax.swing.JScrollPane();
        gLtLangTp = new br.com.gmp.comps.list.GList();
        jPSkillTp = new javax.swing.JPanel();
        gTSkillTp = new br.com.gmp.comps.textfield.GTextField();
        jSPPerk6 = new javax.swing.JScrollPane();
        gLtSkillTp = new br.com.gmp.comps.list.GList();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tipos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1213_.png"))); // NOI18N
        setMaximumSize(new java.awt.Dimension(375, 327));
        setMinimumSize(new java.awt.Dimension(375, 327));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(375, 327));

        jTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane.setName("jTabbedPane"); // NOI18N

        jPPerkTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Vantagens"));
        jPPerkTypes.setName("jPPerkTypes"); // NOI18N

        gTPerkTp.setPlaceholder("Tipos de vantagens");
        gTPerkTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTPerkTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTPerkTp.setName("gTPerkTp"); // NOI18N
        gTPerkTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTPerkTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTPerkTpKeyReleased(evt);
            }
        });

        jSPPerk.setName("jSPPerk"); // NOI18N

        gLtPerkTp.setKeyDelete(true);
        gLtPerkTp.setName("gLtPerkTp"); // NOI18N
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
        jPEffects.setName("jPEffects"); // NOI18N

        gTEffectTp.setPlaceholder("Tipos de efeitos");
        gTEffectTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTEffectTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTEffectTp.setName("gTEffectTp"); // NOI18N
        gTEffectTp.setNextFocusableComponent(gTPerkTp);
        gTEffectTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTEffectTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTEffectTpKeyReleased(evt);
            }
        });

        jSPEffect.setName("jSPEffect"); // NOI18N

        gLtEffectTp.setKeyDelete(true);
        gLtEffectTp.setName("gLtEffectTp"); // NOI18N
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
        jPExpertiseTypes.setName("jPExpertiseTypes"); // NOI18N

        gTExpertiseTp.setPlaceholder("Tipos de perícias");
        gTExpertiseTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTExpertiseTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTExpertiseTp.setName("gTExpertiseTp"); // NOI18N
        gTExpertiseTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTExpertiseTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTExpertiseTpKeyReleased(evt);
            }
        });

        jSPExpertise.setName("jSPExpertise"); // NOI18N

        gLtExpTp.setKeyDelete(true);
        gLtExpTp.setName("gLtExpTp"); // NOI18N
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

        jPArmorTypes.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Armaduras"));
        jPArmorTypes.setName("jPArmorTypes"); // NOI18N

        gTArmorTp.setPlaceholder("Tipos de Armaduras");
        gTArmorTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTArmorTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTArmorTp.setName("gTArmorTp"); // NOI18N
        gTArmorTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTArmorTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTArmorTpKeyReleased(evt);
            }
        });

        jSPArmorTp.setName("jSPArmorTp"); // NOI18N

        gLtArmorTp.setKeyDelete(true);
        gLtArmorTp.setName("gLtArmorTp"); // NOI18N
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
        jPMaterials.setName("jPMaterials"); // NOI18N

        gTMaterial.setPlaceholder("Tipos de Materiais");
        gTMaterial.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTMaterial.setMinimumSize(new java.awt.Dimension(150, 28));
        gTMaterial.setName("gTMaterial"); // NOI18N
        gTMaterial.setPreferredSize(new java.awt.Dimension(150, 28));
        gTMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTMaterialKeyReleased(evt);
            }
        });

        jSPPerk1.setName("jSPPerk1"); // NOI18N

        gLtMaterials.setKeyDelete(true);
        gLtMaterials.setName("gLtMaterials"); // NOI18N
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
        jPElement.setName("jPElement"); // NOI18N

        gTElement.setPlaceholder("Tipos de Elementos");
        gTElement.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTElement.setMinimumSize(new java.awt.Dimension(150, 28));
        gTElement.setName("gTElement"); // NOI18N
        gTElement.setPreferredSize(new java.awt.Dimension(150, 28));
        gTElement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTElementKeyReleased(evt);
            }
        });

        jSPPerk2.setName("jSPPerk2"); // NOI18N

        gLtElement.setKeyDelete(true);
        gLtElement.setName("gLtElement"); // NOI18N
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
        jPItemType.setName("jPItemType"); // NOI18N

        gTItemTp.setPlaceholder("Tipos de Itens");
        gTItemTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTItemTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTItemTp.setName("gTItemTp"); // NOI18N
        gTItemTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTItemTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTItemTpKeyReleased(evt);
            }
        });

        jSPPerk3.setName("jSPPerk3"); // NOI18N

        gLtItemTp.setKeyDelete(true);
        gLtItemTp.setName("gLtItemTp"); // NOI18N
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

        jPMagicType.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Magias"));
        jPMagicType.setName("jPMagicType"); // NOI18N

        gTSpellTp.setPlaceholder("Tipos de Itens");
        gTSpellTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTSpellTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTSpellTp.setName("gTSpellTp"); // NOI18N
        gTSpellTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTSpellTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTSpellTpKeyReleased(evt);
            }
        });

        jSPPerk4.setName("jSPPerk4"); // NOI18N

        gLtSpellTp.setKeyDelete(true);
        gLtSpellTp.setName("gLtSpellTp"); // NOI18N
        gLtSpellTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtSpellTpKeyReleased(evt);
            }
        });
        jSPPerk4.setViewportView(gLtSpellTp);

        javax.swing.GroupLayout jPMagicTypeLayout = new javax.swing.GroupLayout(jPMagicType);
        jPMagicType.setLayout(jPMagicTypeLayout);
        jPMagicTypeLayout.setHorizontalGroup(
            jPMagicTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMagicTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMagicTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTSpellTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPMagicTypeLayout.setVerticalGroup(
            jPMagicTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMagicTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk4, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTSpellTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Magias", jPMagicType);

        jPLanguageType.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Idiomas"));
        jPLanguageType.setName("jPLanguageType"); // NOI18N

        gTLangTp.setPlaceholder("Tipos de Idiomas");
        gTLangTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTLangTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTLangTp.setName("gTLangTp"); // NOI18N
        gTLangTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTLangTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTLangTpKeyReleased(evt);
            }
        });

        jSPPerk5.setName("jSPPerk5"); // NOI18N

        gLtLangTp.setKeyDelete(true);
        gLtLangTp.setName("gLtLangTp"); // NOI18N
        gLtLangTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtLangTpKeyReleased(evt);
            }
        });
        jSPPerk5.setViewportView(gLtLangTp);

        javax.swing.GroupLayout jPLanguageTypeLayout = new javax.swing.GroupLayout(jPLanguageType);
        jPLanguageType.setLayout(jPLanguageTypeLayout);
        jPLanguageTypeLayout.setHorizontalGroup(
            jPLanguageTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLanguageTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPLanguageTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTLangTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPLanguageTypeLayout.setVerticalGroup(
            jPLanguageTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPLanguageTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk5, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTLangTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Idiomas", jPLanguageType);

        jPSkillTp.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos de Habilidades"));
        jPSkillTp.setName("jPSkillTp"); // NOI18N

        gTSkillTp.setPlaceholder("Tipos de Habilidades");
        gTSkillTp.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        gTSkillTp.setMinimumSize(new java.awt.Dimension(150, 28));
        gTSkillTp.setName("gTSkillTp"); // NOI18N
        gTSkillTp.setPreferredSize(new java.awt.Dimension(150, 28));
        gTSkillTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTSkillTpKeyReleased(evt);
            }
        });

        jSPPerk6.setName("jSPPerk6"); // NOI18N

        gLtSkillTp.setKeyDelete(true);
        gLtSkillTp.setName("gLtSkillTp"); // NOI18N
        gLtSkillTp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gLtSkillTpKeyReleased(evt);
            }
        });
        jSPPerk6.setViewportView(gLtSkillTp);

        javax.swing.GroupLayout jPSkillTpLayout = new javax.swing.GroupLayout(jPSkillTp);
        jPSkillTp.setLayout(jPSkillTpLayout);
        jPSkillTpLayout.setHorizontalGroup(
            jPSkillTpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSkillTpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSkillTpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gTSkillTp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSPPerk6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPSkillTpLayout.setVerticalGroup(
            jPSkillTpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSkillTpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSPPerk6, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gTSkillTp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jTabbedPane.addTab("Habilidades", jPSkillTp);

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
        add(evt, gTEffectTp, new EffectType(), effectModel);
    }//GEN-LAST:event_gTEffectTpKeyReleased

    private void gTPerkTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTPerkTpKeyReleased
        add(evt, gTPerkTp, new PerkType(), perkModel);
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
        add(evt, gTExpertiseTp, new ExpertiseType(), expertiseModel);
    }//GEN-LAST:event_gTExpertiseTpKeyReleased

    private void gLtExpTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtExpTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtExpTp, expertiseModel);
        }
    }//GEN-LAST:event_gLtExpTpKeyReleased

    private void gTArmorTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTArmorTpKeyReleased
        add(evt, gTArmorTp, new ArmorType(), armorModel);
    }//GEN-LAST:event_gTArmorTpKeyReleased

    private void gLtArmorTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtArmorTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtArmorTp, armorModel);
        }
    }//GEN-LAST:event_gLtArmorTpKeyReleased

    private void gTMaterialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTMaterialKeyReleased
        add(evt, gTMaterial, new MaterialType(), materialModel);
    }//GEN-LAST:event_gTMaterialKeyReleased

    private void gLtMaterialsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtMaterialsKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtMaterials, materialModel);
        }
    }//GEN-LAST:event_gLtMaterialsKeyReleased

    private void gTElementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTElementKeyReleased
        add(evt, gTElement, new ElementType(), elementModel);
    }//GEN-LAST:event_gTElementKeyReleased

    private void gLtElementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtElementKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtElement, elementModel);
        }
    }//GEN-LAST:event_gLtElementKeyReleased

    private void gTItemTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTItemTpKeyReleased
        add(evt, gTItemTp, new ItemType(), itemModel);
    }//GEN-LAST:event_gTItemTpKeyReleased

    private void gLtItemTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtItemTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtItemTp, itemModel);
        }
    }//GEN-LAST:event_gLtItemTpKeyReleased

    private void gTSpellTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTSpellTpKeyReleased
        add(evt, gTSpellTp, new SpellType(), spellModel);
    }//GEN-LAST:event_gTSpellTpKeyReleased

    private void gLtSpellTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtSpellTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtSpellTp, spellModel);
        }
    }//GEN-LAST:event_gLtSpellTpKeyReleased

    private void gTLangTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTLangTpKeyReleased
        add(evt, gTLangTp, new LanguageType(), languageModel);
    }//GEN-LAST:event_gTLangTpKeyReleased

    private void gLtLangTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtLangTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtLangTp, languageModel);
        }
    }//GEN-LAST:event_gLtLangTpKeyReleased

    private void gTSkillTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTSkillTpKeyReleased
        add(evt, gTSkillTp, new SkillType(), skillModel);
    }//GEN-LAST:event_gTSkillTpKeyReleased

    private void gLtSkillTpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gLtSkillTpKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove(gLtSkillTp, skillModel);
        }
    }//GEN-LAST:event_gLtSkillTpKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.list.GList gLtArmorTp;
    private br.com.gmp.comps.list.GList gLtEffectTp;
    private br.com.gmp.comps.list.GList gLtElement;
    private br.com.gmp.comps.list.GList gLtExpTp;
    private br.com.gmp.comps.list.GList gLtItemTp;
    private br.com.gmp.comps.list.GList gLtLangTp;
    private br.com.gmp.comps.list.GList gLtMaterials;
    private br.com.gmp.comps.list.GList gLtPerkTp;
    private br.com.gmp.comps.list.GList gLtSkillTp;
    private br.com.gmp.comps.list.GList gLtSpellTp;
    private br.com.gmp.comps.textfield.GTextField gTArmorTp;
    private br.com.gmp.comps.textfield.GTextField gTEffectTp;
    private br.com.gmp.comps.textfield.GTextField gTElement;
    private br.com.gmp.comps.textfield.GTextField gTExpertiseTp;
    private br.com.gmp.comps.textfield.GTextField gTItemTp;
    private br.com.gmp.comps.textfield.GTextField gTLangTp;
    private br.com.gmp.comps.textfield.GTextField gTMaterial;
    private br.com.gmp.comps.textfield.GTextField gTPerkTp;
    private br.com.gmp.comps.textfield.GTextField gTSkillTp;
    private br.com.gmp.comps.textfield.GTextField gTSpellTp;
    private javax.swing.JPanel jPArmorTypes;
    private javax.swing.JPanel jPEffects;
    private javax.swing.JPanel jPElement;
    private javax.swing.JPanel jPExpertiseTypes;
    private javax.swing.JPanel jPItemType;
    private javax.swing.JPanel jPLanguageType;
    private javax.swing.JPanel jPMagicType;
    private javax.swing.JPanel jPMaterials;
    private javax.swing.JPanel jPPerkTypes;
    private javax.swing.JPanel jPSkillTp;
    private javax.swing.JScrollPane jSPArmorTp;
    private javax.swing.JScrollPane jSPEffect;
    private javax.swing.JScrollPane jSPExpertise;
    private javax.swing.JScrollPane jSPPerk;
    private javax.swing.JScrollPane jSPPerk1;
    private javax.swing.JScrollPane jSPPerk2;
    private javax.swing.JScrollPane jSPPerk3;
    private javax.swing.JScrollPane jSPPerk4;
    private javax.swing.JScrollPane jSPPerk5;
    private javax.swing.JScrollPane jSPPerk6;
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
