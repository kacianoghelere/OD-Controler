package br.com.urcontroler.datatables.wisdom;

import br.com.urcontroler.data.entity.AttrRange;
import br.com.urcontroler.datatables.AttrData;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de sabedoria
 *
 * @author kaciano
 * @version 1.0
 */
public class WisdomData implements AttrData {

    private AttrRange range;
    private int ajust;

    /**
     * Cria nova instancia de WisData
     */
    public WisdomData() {
    }

    /**
     * Cria nova instancia de WisData
     *
     * @param init {@code int} Inicio da faixa
     * @param end {@code int} Fim da faixa
     * @param ajust {@code int} Ajuste de proteção
     */
    public WisdomData(int init, int end, int ajust) {
        this.range = new AttrRange(init, end);
        this.ajust = ajust;
    }

    /**
     * Cria nova instancia de WisData
     *
     * @param range {@code AttrRange} Faixa de valores do atributo
     * @param ajust {@code int} Ajuste de proteção
     */
    public WisdomData(AttrRange range, int ajust) {
        this.range = range;
        this.ajust = ajust;
    }

    /**
     * Cria nova instancia de WisData
     *
     * @param range {@code String} Faixa de valores do atributo
     * @param ajust {@code int} Ajuste de proteção
     */
    public WisdomData(String range, int ajust) {
        this.range = new AttrRange(range);
        this.ajust = ajust;
    }

    /**
     * Retorna a faixa de valores do atributo
     *
     * @return {@code AttrRange} Faixa de valores do atributo
     */
    @Override
    public AttrRange getRange() {
        return range;
    }

    /**
     * Modifica a faixa de valores do atributo
     *
     * @param range {@code AttrRange} Faixa de valores do atributo
     */
    public void setRange(AttrRange range) {
        this.range = range;
    }

    /**
     * Retorna o ajuste de proteção
     *
     * @return {@code int} Ajuste de proteção
     */
    public int getAjust() {
        return ajust;
    }

    /**
     * Modifica o ajuste de proteção
     *
     * @param ajust {@code int} Ajuste de proteção
     */
    public void setAjust(int ajust) {
        this.ajust = ajust;
    }

}
