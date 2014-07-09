package br.com.odcontroler.main.util;

import br.com.gmp.comps.model.GTableModel;
import br.com.gmp.comps.table.GTable;
import br.com.gmp.utils.interact.WindowUtil;
import br.com.odcontroler.main.object.BeanEvent;
import br.com.odcontroler.main.view.View;
import br.com.odcontroler.main.view.interfaces.TableView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe utilitária para Views que usam tabelas
 *
 * @author kaciano
 */
public class TableUtil {

    private View view;
    private GTable table;
    private GTableModel model;

    /**
     * Cria nova instancia de TableUtil
     *
     * @param view {@code View} View da tabela
     * @param table {@code GTable}
     * @param model {@code GTableModel}
     */
    public TableUtil(View view, GTable table, GTableModel model) {
        this.view = view;
        this.table = table;
        this.model = model;
    }

    /**
     * Cria nova instancia de TableUtil
     *
     * @param hasTable {@code HasTable}
     */
    public TableUtil(TableView hasTable) {
        this.view = (View) hasTable;
        this.table = hasTable.getTable();
        this.model = hasTable.getModel();
    }

    /**
     * Adiciona os itens na tabela
     *
     * @param evt {@code BeanEvent} Evento
     */
    public void add(BeanEvent evt) {
        model.add(evt.getValue());
    }

    /**
     * Remove os itens selecionados da tabela
     *
     * @param evt {@code BeanEvent} Evento
     */
    public void remove(BeanEvent evt) {
        String text = "Deseja remover os itens selecionados?";
        if (WindowUtil.confirmation(view, "Remover", text, "Sim", "Não")) {
            try {
                if (table.getSelectedRowCount() > 0) {
                    model.remove(table.getSelectedRows());
                }
            } catch (NumberFormatException e) {
                Logger.getLogger(TableUtil.class.getName())
                        .log(Level.SEVERE, null, e);
            }
        }
    }

}
