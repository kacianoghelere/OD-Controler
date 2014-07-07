package br.com.odcontroler.datatables.strength;

import br.com.odcontroler.data.entity.AttrRange;
import br.com.odcontroler.datatables.AttrData;
import java.util.Objects;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de força
 *
 * @author kaciano
 * @version 1.0
 */
public class StrengthData implements AttrData {

    private AttrRange range;
    private int ajust;

    /**
     * Cria nova instancia de StrData
     */
    public StrengthData() {
    }

    /**
     * Cria nova instancia de StrData
     *
     * @param range {@code AttrRange} Faixa de valores do atributo
     * @param ajust {@code int} Ajuste
     */
    public StrengthData(AttrRange range, int ajust) {
        this.range = range;
        this.ajust = ajust;
    }

    /**
     * Cria nova instancia de StrData
     *
     * @param init {@code int} Inicio da faixa de valores
     * @param end {@code int} Fim da faixa de valores
     * @param ajust {@code int} Ajuste
     */
    public StrengthData(int init, int end, int ajust) {
        this.range = new AttrRange(init, end);
        this.ajust = ajust;
    }

    @Override
    public String toString() {
        return "StrData{" + range + ", ajust = " + ajust + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.range);
        hash = 89 * hash + this.ajust;
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
        final StrengthData other = (StrengthData) obj;
        if (!Objects.equals(this.range, other.range)) {
            return false;
        }
        return this.ajust == other.ajust;
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
     * Retorna o ajuste do atributo
     *
     * @return {@code int} Ajuste
     */
    public int getAjust() {
        return ajust;
    }

    /**
     * Modifica o ajuste do atributo
     *
     * @param ajust {@code int} Ajuste
     */
    public void setAjust(int ajust) {
        this.ajust = ajust;
    }

}
