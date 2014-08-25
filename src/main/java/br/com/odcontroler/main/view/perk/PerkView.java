package br.com.odcontroler.main.view.perk;

import br.com.gmp.comps.table.GTable;
import br.com.gmp.comps.table.interfaces.TableSource;
import br.com.odcontroler.data.db.dao.PerkDAO;
import br.com.odcontroler.data.entity.Perk;
import br.com.odcontroler.main.MainScreen;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.util.Description;
import br.com.odcontroler.main.util.TableUtil;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.perk.sub.PerkSubView;
import br.com.odcontroler.main.view.interfaces.TableView;
import br.com.odcontroler.main.view.object.ViewParameter;
import br.com.odcontroler.main.view.perk.model.PerkModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * View de cadastro e manutenção de perks
 *
 * @author kaciano
 */
public class PerkView extends View implements TableSource<Perk>, TableView {

    private PerkBean bean;
    private PerkModel model;
    private TableUtil tableUtil;

    /**
     * Cria nova instancia de PerkView
     *
     * @param screen {@code MainScreen} Tela principal
     */
    public PerkView(MainScreen screen) {
        super(screen);
        initialize();
    }

    /**
     * Metodo de inicialização
     */
    private void initialize() {
        this.setControls(new ViewParameter(true, false, false, false));
        this.setSize(320, 300);
        this.initComponents();
        this.model = new PerkModel();
        this.gTable.buildTable(this, 0, model);
        this.tableUtil = new TableUtil(this);
        this.bean = new PerkBean(this);
    }

    @Override
    public List<Perk> getTableData() {
        return new PerkDAO().getList();
    }

    @Override
    public void add() {
        PerkSubView dialog = new PerkSubView(this, null);
        getMainScreen().getListener().insertView(dialog);
        if (dialog.getPerk() != null) {
            bean.add(new BeanEvent(this, dialog.getPerk()));
        }
    }

    /**
     * Edita o Perk
     */
    @Override
    public void edit() {
        try {
            bean.edit(null);
        } catch (Exception ex) {
            Logger.getLogger(PerkView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove() {
        tableUtil.remove(null);
    }

    @Override
    public GTable getTable() {
        return this.gTable;
    }

    @Override
    public PerkModel getModel() {
        return this.model;
    }

    @Override
    public PerkBean getBean() {
        return this.bean;
    }

    @Override
    public Description getDescription() {
        return new Description.Builder()
                .setTitle(getTitle())
                .setDescription("View para cadastro de controle de vantagens.")
                .setSave("Remove todos os itens e salva os novos")
                .setProcces("Nada faz.")
                .setClear("Nada faz.")
                .setLoad("Nada faz.")
                .apply();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar = new javax.swing.JToolBar();
        jBAdd = new javax.swing.JButton();
        jBRemove = new javax.swing.JButton();
        jBEdit = new javax.swing.JButton();
        jSP = new javax.swing.JScrollPane();
        gTable = new br.com.gmp.comps.table.GTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vantagens");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/RpgIcons/misc/slice1215_.png"))); // NOI18N

        jToolBar.setFloatable(false);
        jToolBar.setRollover(true);

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
        jToolBar.add(jBAdd);

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
        jToolBar.add(jBRemove);

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
        jToolBar.add(jBEdit);

        gTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        gTable.setOpaque(false);
        gTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gTableMouseClicked(evt);
            }
        });
        jSP.setViewportView(gTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSP, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        add();
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRemoveActionPerformed
        remove();
    }//GEN-LAST:event_jBRemoveActionPerformed

    private void jBEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditActionPerformed
        edit();
    }//GEN-LAST:event_jBEditActionPerformed

    private void gTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gTableMouseClicked
        if (evt.getClickCount() == 2) {
            edit();
        }
    }//GEN-LAST:event_gTableMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.com.gmp.comps.table.GTable gTable;
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBEdit;
    private javax.swing.JButton jBRemove;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
}
