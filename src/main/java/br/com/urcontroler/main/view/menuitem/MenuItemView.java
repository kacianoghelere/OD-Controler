package br.com.urcontroler.main.view.menuitem;

import br.com.gmp.comps.combobox.model.GComboBoxModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.gmp.utils.object.ObjectWrapper;
import br.com.urcontroler.data.db.dao.MenuItemDAO;
import br.com.urcontroler.data.entity.Menu;
import br.com.urcontroler.data.entity.MenuItem;
import br.com.urcontroler.main.MainScreen;
import br.com.urcontroler.main.object.BeanEvent;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.BeanListener;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.menuitem.model.MenuItemModel;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.List;
import java.util.logging.Level;
import javax.swing.ImageIcon;

/**
 * Tela de cadastro de itens de menu
 *
 * @author kaciano
 * @version 1.0
 */
public class MenuItemView extends View implements TableView, TableSource<MenuItem> {

    private MenuItemBean bean;
    private MenuItemModel model;
    private GComboBoxModel<Menu> parentModel;
    private GComboBoxModel<ImageIcon> iconModel;
    private TableDecorator decorator;
    private int count = 0;
    private final int ID_COLUMN = count++;
    private final int MENU_COLUMN = count++;
    private final int TITLE_COLUMN = count++;
    private final int CLASS_COLUMN = count++;
    private final int ICON_COLUMN = count++;

    /**
     * Cria nova instancia de MenuItemView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public MenuItemView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.initComponents();
        this.setControls(new ViewParameter(true, false, true, true));
        this.setSize(600, 420);
        this.parentModel = new GComboBoxModel();
        this.iconModel = new GComboBoxModel();
        this.model = new MenuItemModel();
        this.gTable.buildTable(this, 0, model);
        this.bean = new MenuItemBean(this);
        this.gCBIcon.setGModel(iconModel);
        this.gCBMenu.setGModel(parentModel);
        this.decorator = new TableDecorator(gTable).withIcon(ICON_COLUMN);
    }

    @Override
    public void add() throws Exception {
        if (gTTitle.validateComponent() && gCBIcon.validateComponent()
                && gTClass.validateComponent() && gCBMenu.validateComponent()) {
            ObjectWrapper ow = new ObjectWrapper(this)
                    .addValue("title", gTTitle.getText())
                    .addValue("icon", gCBIcon.getSelectedIndex())
                    .addValue("class", gTClass.getText())
                    .addValue("menu", (Menu) gCBMenu.getSelectedItem());
            bean.add(new BeanEvent(this, ow));
            //super.clear();
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
                throwException(new ViewException(this, e));
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
    public MenuItemModel getModel() {
        return this.model;
    }

    @Override
    public List<MenuItem> getTableData() {
        return new MenuItemDAO().getList();
    }

    @Override
    public BeanListener getBean() {
        return this.bean;
    }

    /**
     * Retorna o modelo dos ícones
     *
     * @return {@code GComboBoxModel(ImageIcon)} Modelo dos ícones
     */
    public GComboBoxModel<ImageIcon> getIconModel() {
        return this.iconModel;
    }

    /**
     * Retorna o modelo dos menus
     *
     * @return {@code GComboBoxModel(Menu)} Modelo dos menus
     */
    public GComboBoxModel<Menu> getParentModel() {
        return this.parentModel;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLTitle = new javax.swing.JLabel();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        gTClass = new br.com.gmp.comps.textfield.GTextField();
        jLClass = new javax.swing.JLabel();
        jLIcon = new javax.swing.JLabel();
        gCBIcon = new br.com.gmp.comps.combobox.GComboBox();
        jLMenu = new javax.swing.JLabel();
        gCBMenu = new br.com.gmp.comps.combobox.GComboBox();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMPreview = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de telas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/window/dialog.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 420));
        setPreferredSize(new java.awt.Dimension(600, 420));

        jLTitle.setText("Titulo:");

        gTTitle.setPlaceholder("Titulo da tela");

        gTClass.setPlaceholder("Classe da tela");

        jLClass.setText("Classe:");

        jLIcon.setText("Ícone:");

        jLMenu.setText("Menu:");

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

        jScrollPane1.setViewportView(gTable);

        jMPreview.setText("Pré-Visualização");
        jMenuBar.add(jMPreview);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLMenu)
                            .addComponent(jLClass)
                            .addComponent(jLTitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gTClass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(gCBMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIcon)
                    .addComponent(gCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLMenu)
                        .addComponent(gCBMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBAdd)
                        .addComponent(jBRemove)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBIcon, gTTitle});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBMenu, jBAdd});

    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.combobox.GComboBox gCBIcon;
    private br.com.gmp.comps.combobox.GComboBox gCBMenu;
    private br.com.gmp.comps.textfield.GTextField gTClass;
    private br.com.gmp.comps.textfield.GTextField gTTitle;
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBRemove;
    private javax.swing.JLabel jLClass;
    private javax.swing.JLabel jLIcon;
    private javax.swing.JLabel jLMenu;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JMenu jMPreview;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
