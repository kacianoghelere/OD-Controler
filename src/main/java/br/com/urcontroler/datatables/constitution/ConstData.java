package br.com.urcontroler.datatables.constitution;

import br.com.urcontroler.data.entity.AttrRange;
import br.com.urcontroler.datatables.AttrData;
import java.util.Objects;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de constituição
 *
 * @author kaciano
 * @version 1.0
 */
public class ConstData implements AttrData {

    private AttrRange range;
    private int ajust;
    private int ressurrect;

    /**
     * Cria nova instancia de ConData
     */
    public ConstData() {
    }

    /**
     * Cria nova instancia de ConData
     *
     * @param range {@code AttrRange} Faixa do atributo
     * @param ajust {@code int} Ajuste de pontos de vida e proteção
     * @param ressurrect {@code int} Chance de ressurreição
     */
    public ConstData(AttrRange range, int ajust, int ressurrect) {
        this.range = range;
        this.ajust = ajust;
        this.ressurrect = ressurrect;
    }

    /**
     * Cria nova instancia de ConData
     *
     * @param range {@code String} Faixa do atributo
     * @param ajust {@code int} Ajuste de pontos de vida e proteção
     * @param ressurrect {@code int} Chance de ressurreição
     */
    public ConstData(String range, int ajust, int ressurrect) {
        this.range = new AttrRange(range);
        this.ajust = ajust;
        this.ressurrect = ressurrect;
    }

    /**
     * Cria nova instancia de ConData
     *
     * @param init {@code int} Inicio da faixa do atributo
     * @param end {@code int} Fim da faixa do atributo
     * @param ajust {@code int} Ajuste de pontos de vida e proteção
     * @param ressurrect {@code int} Chance de ressurreição
     */
    public ConstData(int init, int end, int ajust, int ressurrect) {
        this.range = new AttrRange(init, end);
        this.ajust = ajust;
        this.ressurrect = ressurrect;
    }

    @Override
    public String toString() {
        return "ConData{" + range.toString() + ", "
                + "ajust=" + ajust + ", "
                + "ressurrect=" + ressurrect + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.range);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ConstData other = (ConstData) obj;
        return Objects.equals(this.range, other.range);
    }

    /**
     * Retorna a Faixa do atributo
     *
     * @return {@code AttrRange} Faixa do atributo
     */
    @Override
    public AttrRange getRange() {
        return range;
    }

    /**
     * Modifica a Faixa do atributo
     *
     * @param range {@code AttrRange} Faixa do atributo
     */
    public void setRange(AttrRange range) {
        this.range = range;
    }

    /**
     * Retorna o ajuste de pontos de vida e proteção
     *
     * @return {@code int} Ajuste de pontos de vida e proteção
     */
    public int getAjust() {
        return ajust;
    }

    /**
     * Modifica o ajuste de pontos de vida e proteção
     *
     * @param ajust {@code int} Ajuste de pontos de vida e proteção
     */
    public void setAjust(int ajust) {
        this.ajust = ajust;
    }

    /**
     * Retorna a chance de ressurreição
     *
     * @return {@code int} Chance de ressurreição
     */
    public int getRessurrect() {
        return ressurrect;
    }

    /**
     * Modifica a chance de ressurreição
     *
     * @param ressurrect {@code int} Chance de ressurreição
     */
    public void setRessurrect(int ressurrect) {
        this.ressurrect = ressurrect;
    }

}
