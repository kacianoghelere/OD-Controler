package br.com.odcontroler.datatables.dex;

import br.com.odcontroler.data.entity.AttrRange;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de destreza
 *
 * @author kaciano
 * @version 1.0
 */
public class DexData {

    private AttrRange range;
    private int ajust;
    private int traps;
    private int silenceLockpick;
    private int hidePickpocket;

    /**
     * Cria nova instancia de DexData
     */
    public DexData() {
    }

    /**
     * Cria nova instancia de DexData
     *
     * @param range <code>AttrRange</code> Faixa de valores
     * @param ajust <code>int</code> Ajuste de ataque, CA e proteção
     * @param traps <code>int</code> Localizar e desarmar armadilhas
     * @param silenceLockpick <code>int</code> Mover-se em silencio e abrir
     * fechaduras
     * @param hidePickpocket <code>int</code> Esconder-se nas sombras e pungar
     */
    public DexData(AttrRange range, int ajust, int traps, int silenceLockpick, int hidePickpocket) {
        this.range = range;
        this.ajust = ajust;
        this.traps = traps;
        this.silenceLockpick = silenceLockpick;
        this.hidePickpocket = hidePickpocket;
    }

    /**
     * Cria nova instancia de DexData
     *
     * @param init <code>int</code> Inicio da faixa de valores
     * @param end <code>int</code> Fim da faixa de valores
     * @param ajust <code>int</code> Ajuste de ataque, CA e proteção
     * @param traps <code>int</code> Localizar e desarmar armadilhas
     * @param silenceLockpick <code>int</code> Mover-se em silencio e abrir
     * fechaduras
     * @param hidePickpocket <code>int</code> Esconder-se nas sombras e pungar
     */
    public DexData(int init, int end, int ajust, int traps, int silenceLockpick, int hidePickpocket) {
        this.range = new AttrRange(init, end);
        this.ajust = ajust;
        this.traps = traps;
        this.silenceLockpick = silenceLockpick;
        this.hidePickpocket = hidePickpocket;
    }

    /**
     * Cria nova instancia de DexData
     *
     * @param range <code>String</code> Faixa de valores
     * @param ajust <code>int</code> Ajuste de ataque, CA e proteção
     * @param traps <code>int</code> Localizar e desarmar armadilhas
     * @param silenceLockpick <code>int</code> Mover-se em silencio e abrir
     * fechaduras
     * @param hidePickpocket <code>int</code> Esconder-se nas sombras e pungar
     */
    public DexData(String range, int ajust, int traps, int silenceLockpick, int hidePickpocket) {
        this.range = new AttrRange(range);
        this.ajust = ajust;
        this.traps = traps;
        this.silenceLockpick = silenceLockpick;
        this.hidePickpocket = hidePickpocket;
    }

    @Override
    public String toString() {
        return "DexData{" + range + ", "
                + "Ajustment=" + ajust + ", "
                + "traps=" + traps + ", "
                + "silenceLockpick=" + silenceLockpick + ", "
                + "hidePickpocket=" + hidePickpocket + '}';
    }

    /**
     * Retorna a Faixa de valores
     *
     * @return <code>AttrRange</code> Faixa de valores
     */
    public AttrRange getRange() {
        return range;
    }

    /**
     * Modifica a Faixa de valores
     *
     * @param range <code>AttrRange</code> Faixa de valores
     */
    public void setRange(AttrRange range) {
        this.range = range;
    }

    /**
     * Retorna o Ajuste de ataque, CA e proteção
     *
     * @return <code>int</code> Ajuste de ataque, CA e proteção
     */
    public int getAjust() {
        return ajust;
    }

    /**
     * Modifica o Ajuste de ataque, CA e proteção
     *
     * @param ajust <code>int</code> Ajuste de ataque, CA e proteção
     */
    public void setAjust(int ajust) {
        this.ajust = ajust;
    }

    /**
     * Retorna Localizar e desarmar armadilhas
     *
     * @return <code>int</code> Localizar e desarmar armadilhas
     */
    public int getTraps() {
        return traps;
    }

    /**
     * Modifica Localizar e desarmar armadilhas
     *
     * @param traps <code>int</code> Localizar e desarmar armadilhas
     */
    public void setTraps(int traps) {
        this.traps = traps;
    }

    /**
     * Retorna Mover-se em silencio e abrir fechaduras
     *
     * @return <code>int</code> Mover-se em silencio e abrir fechaduras
     */
    public int getSilenceLockpick() {
        return silenceLockpick;
    }

    /**
     * Modifica Mover-se em silencio e abrir fechaduras
     *
     * @param silenceLockpick <code>int</code> Mover-se em silencio e abrir
     * fechaduras
     */
    public void setSilenceLockpick(int silenceLockpick) {
        this.silenceLockpick = silenceLockpick;
    }

    /**
     * Retorna Esconder-se nas sombras e pungar
     *
     * @return <code>int</code> Esconder-se nas sombras e pungar
     */
    public int getHidePickpocket() {
        return hidePickpocket;
    }

    /**
     * Modifica Esconder-se nas sombras e pungar
     *
     * @param hidePickpocket <code>int</code> Esconder-se nas sombras e pungar
     */
    public void setHidePickpocket(int hidePickpocket) {
        this.hidePickpocket = hidePickpocket;
    }

}
