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
import br.com.urcontroler.main.util.Description;
import br.com.urcontroler.main.view.View;
import br.com.urcontroler.main.view.exception.ViewException;
import br.com.urcontroler.main.view.interfaces.BeanListener;
import br.com.urcontroler.main.view.interfaces.TableView;
import br.com.urcontroler.main.view.menuitem.model.MenuItemModel;
import br.com.urcontroler.main.view.object.ViewParameter;
import java.util.List;
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

    @Override
    public Description getDescription() {
        return new Description.Builder()
                .setTitle(getTitle())
                .setDescription("Tela de controle e cadastro de telas")
                .setSave("Remove os itens antigos e salva os novos.")
                .apply();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPBasics = new javax.swing.JPanel();
        jLTitle = new javax.swing.JLabel();
        gTTitle = new br.com.gmp.comps.textfield.GTextField();
        jLIcon = new javax.swing.JLabel();
        gCBIcon = new br.com.gmp.comps.combobox.GComboBox();
        gTClass = new br.com.gmp.comps.textfield.GTextField();
        jLClass = new javax.swing.JLabel();
        jBRemove = new javax.swing.JButton();
        jBAdd = new javax.swing.JButton();
        gCBMenu = new br.com.gmp.comps.combobox.GComboBox();
        jLMenu = new javax.swing.JLabel();
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

        jScrollPane1.setViewportView(gTable);

        jLTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLTitle.setText("Titulo:");

        gTTitle.setPlaceholder("Titulo da tela");

        jLIcon.setText("Ícone:");

        gTClass.setPlaceholder("Classe da tela");

        jLClass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLClass.setText("Classe:");

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });

        jLMenu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLMenu.setText("Menu:");

        javax.swing.GroupLayout jPBasicsLayout = new javax.swing.GroupLayout(jPBasics);
        jPBasics.setLayout(jPBasicsLayout);
        jPBasicsLayout.setHorizontalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLTitle)
                    .addComponent(jLClass)
                    .addComponent(jLMenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(gCBMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPBasicsLayout.createSequentialGroup()
                        .addComponent(gTTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gTClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLClass, jLMenu, jLTitle});

        jPBasicsLayout.setVerticalGroup(
            jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBasicsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTitle)
                    .addComponent(gTTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLIcon)
                    .addComponent(gCBIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gTClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLClass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdd)
                    .addComponent(jBRemove)
                    .addGroup(jPBasicsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gCBMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLMenu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBIcon, gTTitle});

        jPBasicsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gCBMenu, jBAdd});

        jTabbedPane1.addTab("Configurações Basicas", jPBasics);

        jMPreview.setText("Pré-Visualização");
        jMenuBar.add(jMPreview);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
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
    private javax.swing.JPanel jPBasics;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
