package br.com.odcontroler.datatables.wis;

import br.com.odcontroler.data.entity.AttrRange;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de sabedoria
 *
 * @author kaciano
 * @version 1.0
 */
public class WisData {

    private AttrRange range;
    private int ajust;
    private int[] additSpells = new int[9];

    /**
     * Cria nova instancia de WisData
     */
    public WisData() {
    }

    /**
     * Cria nova instancia de WisData
     *
     * @param init <code>int</code> Inicio da faixa
     * @param end <code>int</code> Fim da faixa
     * @param ajust <code>int</code> Ajuste de proteção
     */
    public WisData(int init, int end, int ajust) {
        this.range = new AttrRange(init, end);
        this.ajust = ajust;
    }

    /**
     * Cria nova instancia de WisData
     *
     * @param range <code>AttrRange</code> Faixa de valores do atributo
     * @param ajust <code>int</code> Ajuste de proteção
     * @param additSpells <code>int[]</code> Magias adicionais
     */
    public WisData(AttrRange range, int ajust, int[] additSpells) {
        this.range = range;
        this.ajust = ajust;
        this.additSpells = additSpells;
    }

    /**
     * Cria nova instancia de WisData
     *
     * @param init <code>int</code> Inicio da faixa
     * @param end <code>int</code> Fim da faixa
     * @param ajust <code>int</code> Ajuste de proteção
     * @param additSpells <code>int[]</code> Magias adicionais
     */
    public WisData(int init, int end, int ajust, int[] additSpells) {
        this.range = new AttrRange(init, end);
        this.ajust = ajust;
        this.additSpells = additSpells;
    }

    /**
     * Retorna a faixa de valores do atributo
     *
     * @return <code>AttrRange</code> Faixa de valores do atributo
     */
    public AttrRange getRange() {
        return range;
    }

    /**
     * Modifica a faixa de valores do atributo
     *
     * @param range <code>AttrRange</code> Faixa de valores do atributo
     */
    public void setRange(AttrRange range) {
        this.range = range;
    }

    /**
     * Retorna o ajuste de proteção
     *
     * @return <code>int</code> Ajuste de proteção
     */
    public int getAjust() {
        return ajust;
    }

    /**
     * Modifica o ajuste de proteção
     *
     * @param ajust <code>int</code> Ajuste de proteção
     */
    public void setAjust(int ajust) {
        this.ajust = ajust;
    }

    /**
     * Retorna as magias adicionais
     *
     * @return <code>int[]</code> Magias adicionais
     */
    public int[] getAdditSpells() {
        return additSpells;
    }

    /**
     * Modifica as magias adicionais
     *
     * @param additSpells <code>int[]</code> Magias adicionais
     */
    public void setAdditSpells(int[] additSpells) {
        this.additSpells = additSpells;
    }
}
