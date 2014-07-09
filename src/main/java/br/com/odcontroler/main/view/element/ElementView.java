package br.com.odcontroler.main.view.element;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.image.ImageUtil;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.ElementDAO;
import br.com.odcontroler.data.entity.Element;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.element.bean.ElementBean;
import br.com.odcontroler.main.view.element.model.ElementModel;
import br.com.odcontroler.main.view.interfaces.BeanListener;
import br.com.odcontroler.main.view.interfaces.TableView;
import br.com.odcontroler.main.view.object.ViewParameter;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * View dos Elementos
 *
 * @author kaciano
 */
public class ElementView extends View implements TableSource<Element>, TableView {

    private ElementBean bean;
    private ElementModel model;
    private GComboBoxModel<Element> bonusModel;
    private GComboBoxModel<Element> weakModel;
    private GComboBoxModel<ImageIcon> symbolModel;
    private final int TITLE_COLUMN = 0;
    private final int SYMBOL_COLUMN = 1;

    /**
     * Cria nova instancia de ElementView
     *
     * @param screen {@code MainScreen} Tela principal
     */
    public ElementView(MainScreen screen) {
        super(screen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        initComponents();
        setControls(new ViewParameter(true, false, false, true));
        bean = new ElementBean(this);
        List<Element> defaults = bean.getDefaultElements();
        model = new ElementModel();
        model.setData(defaults);
        //----------------------------------------------------------------------
        bonusModel = new GComboBoxModel<>(defaults);
        gCBBonus.setGModel(bonusModel);
        //----------------------------------------------------------------------
        weakModel = new GComboBoxModel<>(defaults);
        gCBWeak.setGModel(weakModel);
        //----------------------------------------------------------------------
        symbolModel = new GComboBoxModel<>(Arrays.asList(bean.getElementsIcons()));
        gCBSymbol.setGModel(symbolModel);
        //----------------------------------------------------------------------
        gTable.buildTable(this, 0, model);
        buildTable();
        load();
        setSize(700, 390);
    }

    @Override
    public List<Element> getTableData() {
        return new ElementDAO().getList();
    }

    /**
     * Monta os dados da tabela
     */
    private void buildTable() {
        gTable.getColumnModel().getColumn(SYMBOL_COLUMN).setCellRenderer(new TableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                ImageIcon ic = new ImageIcon(getClass().getResource((String) value));
                Image sc = new ImageUtil().getScaledImage(ic.getImage(), 20, 20);
                ic.setImage(sc);
                JLabel label = new JLabel(ic);
                if (isSelected) {
                    label.setOpaque(true);
                    label.setBackground(table.getSelectionBackground());
                } else {
                    label.setOpaque(true);
                    label.setBackground(new JLabel().getBackground());
                }
                return label;
            }
        });
    }

    @Override
    public void add() {
        try {
            if (gTTitle.validateComponent() && (gCBSymbol.getSelectedIndex() >= 0)
                    && (gCBBonus.getSelectedIndex() >= 0)
                    && (gCBWeak.getSelectedIndex() >= 0)) {
                ObjectWrapper vw = new ObjectWrapper(this)
                        .addValue("title", gTTitle.getText())
                        .addValue("symbol", gCBSymbol.getSelectedIndex())
                        .addValue("bonus", bonusModel.getSelectedItem())
                        .addValue("weak", weakModel.getSelectedItem());
                bean.add(new BeanEvent(vw));
            }
        } catch (Exception e) {
            Logger.getLogger(ElementView.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void remove() {
        String text = "Deseja remover os itens selecionados?";
        if (WindowUtil.confirmation(this, "Remover", text, "Sim", "Não")) {
            try {
                if (gTable.getSelectedRowCount() > 0) {
                    model.remove(gTable.getSelectedRows());
                }
            } catch (NumberFormatException e) {
                Logger.getLogger(ElementView.class.getName())
                        .log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public ElementModel getModel() {
        return model;
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

        jToolBar = new javax.swing.JToolBar();
        jLTitle = new javax.swing.JLabel();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jLBonus = new javax.swing.JLabel();
        gCBBonus = new br.com.gmp.comps.combobox.GComboBox();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLWeak = new javax.swing.JLabel();
        gCBWeak = new br.com.gmp.comps.combobox.GComboBox();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jLSymbol = new javax.swing.JLabel();
        gCBSymbol = new br.com.gmp.comps.combobox.GComboBox();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Elementos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1399_@.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(700, 390));
        setPreferredSize(new java.awt.Dimension(700, 390));
        setVisible(true);

        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);

        jLTitle.setText("Titulo");
        jToolBar.add(jLTitle);
        jToolBar.add(gTTitle);
        jToolBar.add(jSeparator1);

        jLBonus.setText("Bonus:");
        jToolBar.add(jLBonus);
        jToolBar.add(gCBBonus);
        jToolBar.add(jSeparator2);

        jLWeak.setText("Fraqueza:");
        jToolBar.add(jLWeak);
        jToolBar.add(gCBWeak);
        jToolBar.add(jSeparator3);

        jLSymbol.setText("Simbolo");
        jToolBar.add(jLSymbol);

        gCBSymbol.setMaximumSize(new java.awt.Dimension(50, 50));
        jToolBar.add(gCBSymbol);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setFocusable(false);
        jBAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar.add(jBAdd);

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setFocusable(false);
        jBRemove.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });
        jToolBar.add(jBRemove);

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setRowHeight(26);
        gTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                gTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void gTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gTableKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            remove();
        }
    }//GEN-LAST:event_gTableKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBBonus;
    private br.com.gmp.comps.combobox.GComboBox gCBSymbol;
    private br.com.gmp.comps.combobox.GComboBox gCBWeak;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLBonus;
    private javax.swing.JLabel jLSymbol;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLWeak;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables

}
