package br.com.urcontroler.main.comps.modifier;

import br.com.urcontroler.data.entity.Modifier;

/**
 * Painel auxiliar para controle de modificadores
 *
 * @author kaciano
 */
public class ModifierPane extends javax.swing.JPanel {

    /**
     * Cria nova instancia de ModifierPane
     */
    public ModifierPane() {
        this(new Modifier());
    }

    /**
     * Cria nova instancia de ModifierPane
     *
     * @param requirement {@code Modifier} Modificadores
     */
    public ModifierPane(Modifier requirement) {
        this.modifier = requirement;
        this.initialize(requirement);
    }

    /**
     * Método de inicialização
     *
     * @param r {@code Modifier} Modificadores
     */
    private void initialize(Modifier r) {
        initComponents();
        if (r != null) {
            setModifier(modifier);
        }
    }

    /**
     * Retorna os modificadores editados
     *
     * @return {@code Modifier} Modificadores
     */
    public Modifier getModifier() {
        return modifier;
    }

    /**
     * Modifica os modificadores editados
     *
     * @param modifier {@code Modifier} Modificadores
     */
    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    /**
     * Retorna uma String com os valores preenchidos separados por virgula
     *
     * @return {@code String} String com os valores preenchidos
     */
    public String getValues() {
        String value = jSpnStr.getValue() + ","
                + jSpnDex.getValue() + ","
                + jSpnCon.getValue() + ","
                + jSpnInt.getValue() + ","
                + jSpnWis.getValue() + ","
                + jSpnCha.getValue();
        return value;
    }

    /**
     * Modifica os valores digitados
     *
     * @param values {@code String} String com os valores preenchidos
     */
    public void setValues(String values) {
        String[] split = values.split(",");
        if (split.length != 6) {
            return;
        }
        this.modifier.setSTR(Integer.parseInt(split[0]));
        this.modifier.setDES(Integer.parseInt(split[1]));
        this.modifier.setCON(Integer.parseInt(split[2]));
        this.modifier.setINT(Integer.parseInt(split[3]));
        this.modifier.setWIS(Integer.parseInt(split[4]));
        this.modifier.setCHA(Integer.parseInt(split[5]));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        modifier = new br.com.urcontroler.data.entity.Modifier();
        jPanel1 = new javax.swing.JPanel();
        jLStr = new javax.swing.JLabel();
        jSpnStr = new javax.swing.JSpinner();
        jSpnDex = new javax.swing.JSpinner();
        jLDex = new javax.swing.JLabel();
        jSpnCon = new javax.swing.JSpinner();
        jLCons = new javax.swing.JLabel();
        jSpnCha = new javax.swing.JSpinner();
        jLChar = new javax.swing.JLabel();
        jLWis = new javax.swing.JLabel();
        jLInt = new javax.swing.JLabel();
        jSpnInt = new javax.swing.JSpinner();
        jSpnWis = new javax.swing.JSpinner();

        setPreferredSize(new java.awt.Dimension(340, 115));

        jLStr.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLStr.setText("Força:");

        jSpnStr.setModel(new javax.swing.SpinnerNumberModel(0, -3, 3, 1));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, modifier, org.jdesktop.beansbinding.ELProperty.create("${STR}"), jSpnStr, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jSpnDex.setModel(new javax.swing.SpinnerNumberModel(0, -3, 3, 1));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, modifier, org.jdesktop.beansbinding.ELProperty.create("${DES}"), jSpnDex, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLDex.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLDex.setText("Destreza:");

        jSpnCon.setModel(new javax.swing.SpinnerNumberModel(0, -3, 3, 1));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, modifier, org.jdesktop.beansbinding.ELProperty.create("${CON}"), jSpnCon, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLCons.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLCons.setText("Constituição:");

        jSpnCha.setModel(new javax.swing.SpinnerNumberModel(0, -3, 3, 1));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, modifier, org.jdesktop.beansbinding.ELProperty.create("${CHA}"), jSpnCha, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jLChar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLChar.setText("Carisma:");

        jLWis.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLWis.setText("Sabedoria:");

        jLInt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLInt.setText("Inteligência:");

        jSpnInt.setModel(new javax.swing.SpinnerNumberModel(0, -3, 3, 1));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, modifier, org.jdesktop.beansbinding.ELProperty.create("${INT}"), jSpnInt, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        jSpnWis.setModel(new javax.swing.SpinnerNumberModel(0, -3, 3, 1));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, modifier, org.jdesktop.beansbinding.ELProperty.create("${WIS}"), jSpnWis, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLStr)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnStr, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLCons)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnCon))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLDex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnDex)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLInt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnInt, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLChar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnCha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLWis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpnWis)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLChar, jLInt, jLWis});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLCons, jLDex, jLStr});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLInt)
                            .addComponent(jSpnInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpnStr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLStr))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLWis)
                            .addComponent(jSpnWis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpnDex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLDex))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLChar)
                            .addComponent(jSpnCha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLCons)
                        .addComponent(jSpnCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLChar;
    private javax.swing.JLabel jLCons;
    private javax.swing.JLabel jLDex;
    private javax.swing.JLabel jLInt;
    private javax.swing.JLabel jLStr;
    private javax.swing.JLabel jLWis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner jSpnCha;
    private javax.swing.JSpinner jSpnCon;
    private javax.swing.JSpinner jSpnDex;
    private javax.swing.JSpinner jSpnInt;
    private javax.swing.JSpinner jSpnStr;
    private javax.swing.JSpinner jSpnWis;
    private br.com.urcontroler.data.entity.Modifier modifier;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
