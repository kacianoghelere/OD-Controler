package br.com.odcontroler.datatables.con;

import br.com.odcontroler.data.entity.AttrRange;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de inteligencia
 *
 * @author kaciano
 * @version 1.0
 */
public class ConData {

    private AttrRange range;
    private int ajust;
    private int ressurrect;

    public ConData() {
    }

    public ConData(AttrRange range, int ajust, int ressurrect) {
        this.range = range;
        this.ajust = ajust;
        this.ressurrect = ressurrect;
    }

    public ConData(String range, int ajust, int ressurrect) {
        this.range = new AttrRange(range);
        this.ajust = ajust;
        this.ressurrect = ressurrect;
    }

    public ConData(int init, int end, int ajust, int ressurrect) {
        this.range = new AttrRange(init, end);
        this.ajust = ajust;
        this.ressurrect = ressurrect;
    }

}
