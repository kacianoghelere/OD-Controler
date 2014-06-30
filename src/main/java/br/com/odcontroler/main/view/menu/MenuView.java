package br.com.odcontroler.main.view.menu;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.collections.Triad;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.odcontroler.data.db.dao.MenuDAO;
import br.com.odcontroler.data.entity.Menu;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.interfaces.BeanListener;
import br.com.odcontroler.main.view.interfaces.TableView;
import br.com.odcontroler.main.view.menu.bean.MenuBean;
import br.com.odcontroler.main.view.menu.model.MenuModel;
import br.com.odcontroler.main.view.object.ViewParameter;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;

/**
 * View para controle de menus
 *
 * @author kaciano
 * @version 1.0
 */
public class MenuView extends View implements TableSource<Menu>, TableView {

    private MenuBean bean;
    private MenuModel model;
    private GComboBoxModel<Menu> parentModel;
    private GComboBoxModel<ImageIcon> iconModel;
    private int count = 0;
    private final int ID_COLUMN = count++;
    private final int PARENT_COLUMN = count++;
    private final int TITLE_COLUMN = count++;
    private final int ICON_COLUMN = count++;
    private TableDecorator decorator;

    /**
     * Cria nova instancia de MenuView
     *
     * @param mainScreen {@code MainScreen}
     */
    public MenuView(MainScreen mainScreen) {
        super(mainScreen);
        initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setControls(new ViewParameter(true, true, true, false));
        this.setSize(540, 415);
        this.iconModel = new GComboBoxModel<>();
        this.parentModel = new GComboBoxModel<>();
        this.model = new MenuModel();
        this.gTable.buildTable(this, 0, model);
        this.gCBIcon.setGModel(iconModel);
        this.gCBParent.setGModel(parentModel);
        this.bean = new MenuBean(this);
        this.decorator = new TableDecorator(gTable).withIcon(ICON_COLUMN);
    }

    @Override
    public List<Menu> getTableData() {
        return new MenuDAO().getList();
    }

    @Override
    public void add() {
        if (gTTitle.validateComponent()) {
            if (gCBIcon.validateComponent()) {
                if (gCBParent.validateComponent()) {
                    Triad<String, Integer, Long> triad;
                    Long parent = ((Menu) gCBParent.getSelectedItem()).getId();
                    int index = gCBIcon.getSelectedIndex();
                    triad = new Triad(gTTitle.getText(), index, parent);
                    ObjectWrapper ow = new ObjectWrapper(parent);
                    bean.add(new BeanEvent(this, triad));
                }
            }
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
                LOG.log(Level.SEVERE, null, e);
            }
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public MenuModel getModel() {
        return this.model;
    }

    @Override
    public MenuBean getBean() {
        return this.bean;
    }

    /**
     * Atualiza os dados nas comboboxes
     */
    public void refresh() {
        this.gCBIcon.setGModel(iconModel);
        this.gCBIcon.repaint();
        this.gCBIcon.revalidate();
        this.gCBParent.setGModel(parentModel);
        this.gCBParent.repaint();
        this.gCBParent.revalidate();
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Modelo da combobox de menus superiores
     *
     * @return {@code GComboBoxModel(Menu)}
     */
    public GComboBoxModel<Menu> getParentModel() {
        return parentModel;
    }

    /**
     * Modelo da combobox de icones
     *
     * @return {@code GComboBoxModel(ImageIcon)}
     */
    public GComboBoxModel<ImageIcon> getIconModel() {
        return iconModel;
    }

    /**
     * Retorna o menu de pré-visualização
     *
     * @return {@code JMenu} Menu de pré-visualização
     */
    public JMenu getRoot() {
        return this.jMVisualization;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMenus = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jLTitle = new javax.swing.JLabel();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLParent = new javax.swing.JLabel();
        gCBParent = new br.com.gmp.comps.combobox.GComboBox();
        jLIcon = new javax.swing.JLabel();
        gCBIcon = new br.com.gmp.comps.combobox.GComboBox();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMVisualization = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de menus");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(540, 415));
        setPreferredSize(new java.awt.Dimension(540, 415));

        jPMenus.setBorder(javax.swing.BorderFactory.createTitledBorder("Menus"));

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        gTable.setRowHeight(26);
        jScrollPane1.setViewportView(gTable);

        jLTitle.setText("Titulo:");

        jLParent.setText("Pai:");

        jLIcon.setText("Icone:");

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPMenusLayout = new javax.swing.GroupLayout(jPMenus);
        jPMenus.setLayout(jPMenusLayout);
        jPMenusLayout.setHorizontalGroup(
            jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPMenusLayout.createSequentialGroup()
                        .addGroup(jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLTitle)
                            .addComponent(jLParent))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPMenusLayout.createSequentialGroup()
                                .addComponent(gCBParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPMenusLayout.createSequentialGroup()
                                .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPMenusLayout.setVerticalGroup(
            jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd)
                    .addGroup(jPMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gCBParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLParent))
                    .addComponent(jBRemove))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPMenusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBParent, jBAdd, jBRemove});

        jPMenusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBIcon, gTTitle});

        jMVisualization.setText("Pré-visualização");
        jMenuBar.add(jMVisualization);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPMenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPMenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBIcon;
    private br.com.gmp.comps.combobox.GComboBox gCBParent;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLIcon;
    private javax.swing.JLabel jLParent;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JMenu jMVisualization;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPMenus;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
