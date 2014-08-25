package br.com.odcontroler.main.view.weapon;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.decorate.TableDecorator;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.odcontroler.data.db.dao.MaterialTypeDAO;
import br.com.odcontroler.data.db.dao.OriginDAO;
import br.com.odcontroler.data.db.dao.WeaponDAO;
import br.com.odcontroler.data.db.dao.WeaponTypeDAO;
import br.com.odcontroler.data.entity.Weapon;
import br.com.odcontroler.data.enums.Alignment;
import br.com.odcontroler.data.enums.Dice;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.Description;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.annotation.ViewData;
import br.com.odcontroler.main.view.enums.ViewType;
import br.com.odcontroler.main.view.exception.ViewException;
import br.com.odcontroler.main.view.interfaces.TableView;
import br.com.odcontroler.main.view.object.ViewParameter;
import br.com.odcontroler.main.view.weapon.model.WeaponModel;
import br.com.odcontroler.main.view.weapon.sub.WeaponSubView;
import java.util.Arrays;
import java.util.List;

/**
 * View para cadastro e controle de armas
 *
 * @author kaciano
 * @version 1.0
 */
@ViewData(name = "Armas", type = ViewType.CRUD, path = {""})
public class WeaponView extends View<WeaponBean> implements TableView, TableSource<Weapon> {

    private WeaponBean bean;
    private WeaponModel model;
    private TableDecorator decorator;
    private int count = 0;
    private final int NAME = count++;
    private final int ORIGIN = count++;
    private final int INITIATIVE = count++;
    private final int RANGE = count++;
    private final int DMG_AMOUNT = count++;
    private final int DICE= count++;
    private final int TYPE = count++;
    private final int MATERIAL = count++;
    private final int ALIGNMENT = count++;

    /**
     * Cria nova instancia de WeaponView
     *
     * @param mainScreen {@code MainScreen} Tela principal
     */
    public WeaponView(MainScreen mainScreen) {
        super(mainScreen);
        this.initialize();
    }

    /**
     * Método de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, true, true));
        this.setSize(662, 481);
        this.initComponents();
        this.decorator = new TableDecorator(gTable);
        //----------------------------------------------------------------------
        // Inicialização do modelo
        this.model = new WeaponModel();
        //----------------------------------------------------------------------
        // Inicialização do bean        
        this.bean = new WeaponBean(this);
        //----------------------------------------------------------------------
        // Atribuição do modelo à tabela
        this.gTable.buildTable(this, 0, model);
        //----------------------------------------------------------------------
        // Atribuição dos editores à tabela
        this.decorator.withNumber(INITIATIVE);
        this.decorator.withNumber(RANGE);
        this.decorator.comboAt(ORIGIN, new OriginDAO().getList());
        this.decorator.comboAt(TYPE, new WeaponTypeDAO().getList());
        this.decorator.comboAt(MATERIAL, new MaterialTypeDAO().getList());
        this.decorator.comboAt(ALIGNMENT, Arrays.asList(Alignment.values()));
        this.decorator.comboAt(DICE, Arrays.asList(Dice.values()));
    }

    @Override
    public void add() throws Exception {
        WeaponSubView subview = new WeaponSubView(this, null);
        getMainScreen().getListener().insertView(subview);
        if (subview.getWeapon() != null) {
            try {
                bean.add(new BeanEvent(this, subview.getWeapon()));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                throwException(new ViewException(this, ex));
            } catch (Exception ex) {
                throwException(new ViewException(this, ex));
            }
        }
    }

    @Override
    public void remove() throws Exception {
        bean.remove(null);
    }

    @Override
    public void edit() {
        try {
            bean.edit(null);
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }

    @Override
    public GTable getTable() {
        return gTable;
    }

    @Override
    public WeaponModel getModel() {
        return model;
    }

    @Override
    public List<Weapon> getTableData() {
        return new WeaponDAO().getList();
    }

    @Override
    public WeaponBean getBean() {
        return bean;
    }

    @Override
    public Description getDescription() {
        return new Description.Builder()
                .setTitle(getTitle())
                .setDescription("Tela de controle e cadastro de armas")
                .setSave("Remove os itens antigos e salva os novos.")
                .apply();
    }

    /**
     * Dados gerados automaticamente
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jBEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Armas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/weapons/K/K_64.png"))); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jBAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/new.png"))); // NOI18N
        jBAdd.setMnemonic('A');
        jBAdd.setText("Adicionar");
        jBAdd.setFocusable(false);
        jBAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jToolBar1.add(jBAdd);

        jBRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/controlers/off.png"))); // NOI18N
        jBRemove.setMnemonic('R');
        jBRemove.setText("Remover");
        jBRemove.setFocusable(false);
        jBRemove.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBRemove.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRemoveActionPerformed(evt);
            }
        });
        jToolBar1.add(jBRemove);

        jBEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ComponentIcons/menubar/menubar/edit.png"))); // NOI18N
        jBEdit.setMnemonic('E');
        jBEdit.setText("Editar");
        jBEdit.setFocusable(false);
        jBEdit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditActionPerformed(evt);
            }
        });
        jToolBar1.add(jBEdit);

        gTable.setKeyDelete(true);
        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        jScrollPane1.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        edit();
    }//GEN-LAST:event_jBEditActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        try {
            remove();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        try {
            add();
        } catch (Exception ex) {
            throwException(new ViewException(this, ex));
        }
    }//GEN-LAST:event_jBAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBEdit;
    private javax.swing.JButton jBRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
