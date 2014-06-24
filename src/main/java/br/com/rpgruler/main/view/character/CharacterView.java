package br.com.rpgruler.main.view.character;

import br.com.rpgruler.main.MainScreen;
import br.com.rpgruler.main.view.View;
import br.com.rpgruler.main.view.character.bean.CharacterBean;
import br.com.rpgruler.main.view.interfaces.BeanListener;
import br.com.rpgruler.main.view.object.ViewParameter;

/**
 * View para controle e cadastro de personagens
 *
 * @author kaciano
 * @version 1.0
 */
public class CharacterView extends View {

    private CharacterBean bean;

    /**
     * Cria nova instancia de CharacterView
     *
     * @param mainScreen <code>MainScreen</code> Tela Principal
     */
    public CharacterView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        this.setControls(new ViewParameter(true, true, true, false));
        this.setSize(627, 474);
        this.bean = new CharacterBean(this);
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPMainInfo = new javax.swing.JPanel();
        jPCharData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gMPTextField1 = new br.com.gmp.comps.textfield.GTextField();
        jLabel2 = new javax.swing.JLabel();
        gMPComboBox1 = new br.com.gmp.comps.combobox.GComboBox();
        jLabel3 = new javax.swing.JLabel();
        gMPTextField2 = new br.com.gmp.comps.textfield.GTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        numericTextField1 = new br.com.gmp.comps.textfield.NumericTextField();
        numericTextField2 = new br.com.gmp.comps.textfield.NumericTextField();
        jLabel6 = new javax.swing.JLabel();
        numericTextField3 = new br.com.gmp.comps.textfield.NumericTextField();
        jLabel7 = new javax.swing.JLabel();
        gMPComboBox2 = new br.com.gmp.comps.combobox.GComboBox();
        jLabel8 = new javax.swing.JLabel();
        gMPComboBox3 = new br.com.gmp.comps.combobox.GComboBox();
        jLabel9 = new javax.swing.JLabel();
        numericTextField4 = new br.com.gmp.comps.textfield.NumericTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Personagens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1405_@.png"))); // NOI18N

        jPCharData.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do personagem"));

        jLabel1.setText("Nome do personagem:");

        jLabel2.setText("Raça:");

        jLabel3.setText("Nome do Jogador:");

        jLabel4.setText("Idade:");

        jLabel5.setText("Peso:");

        jLabel6.setText("Altura:");

        jLabel7.setText("Sexo:");

        gMPComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        jLabel8.setText("Tendencia:");

        gMPComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Luz", "Neutro", "Sombras" }));

        jLabel9.setText("Nível:");

        javax.swing.GroupLayout jPCharDataLayout = new javax.swing.GroupLayout(jPCharData);
        jPCharData.setLayout(jPCharDataLayout);
        jPCharDataLayout.setHorizontalGroup(
            jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCharDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCharDataLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gMPComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gMPComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPCharDataLayout.createSequentialGroup()
                        .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPCharDataLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(numericTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numericTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numericTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numericTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 9, Short.MAX_VALUE))
                            .addGroup(jPCharDataLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gMPTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gMPComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPCharDataLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gMPTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jPCharDataLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gMPComboBox2, numericTextField1, numericTextField2, numericTextField3});

        jPCharDataLayout.setVerticalGroup(
            jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCharDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gMPTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gMPTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(gMPComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(numericTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numericTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(numericTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(numericTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(gMPComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPCharDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gMPComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));

        javax.swing.GroupLayout jPMainInfoLayout = new javax.swing.GroupLayout(jPMainInfo);
        jPMainInfo.setLayout(jPMainInfoLayout);
        jPMainInfoLayout.setHorizontalGroup(
            jPMainInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMainInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMainInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCharData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPMainInfoLayout.setVerticalGroup(
            jPMainInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMainInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPCharData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Principal", jPMainInfo);
        jTabbedPane1.addTab("Equipamentos", jPanel3);
        jTabbedPane1.addTab("Habilidades", jPanel5);
        jTabbedPane1.addTab("Perícias", jPanel2);
        jTabbedPane1.addTab("Inventario", jPanel4);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gMPComboBox1;
    private br.com.gmp.comps.combobox.GComboBox gMPComboBox2;
    private br.com.gmp.comps.combobox.GComboBox gMPComboBox3;
    private br.com.gmp.comps.textfield.GTextField gMPTextField1;
    private br.com.gmp.comps.textfield.GTextField gMPTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPCharData;
    private javax.swing.JPanel jPMainInfo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private br.com.gmp.comps.textfield.NumericTextField numericTextField1;
    private br.com.gmp.comps.textfield.NumericTextField numericTextField2;
    private br.com.gmp.comps.textfield.NumericTextField numericTextField3;
    private br.com.gmp.comps.textfield.NumericTextField numericTextField4;
    // End of variables declaration//GEN-END:variables
}
