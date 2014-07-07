package br.com.odcontroler.data.entity;

/**
 * Faixa de pontuação para atributos
 *
 * @author kaciano
 * @version 1.0
 */
public class AttrRange {

    private int initRange;
    private int endRange;

    /**
     * Cria nova instancia de AttrRange
     *
     * @param initRange {@code int} Inicio da faixa
     * @param endRange {@code int} Fim da faixa
     */
    public AttrRange(int initRange, int endRange) {
        this.initRange = initRange;
        this.endRange = endRange;
    }

    /**
     * Cria nova instancia de AttrRange
     *
     * @param range {@code String} Valor em String da faixa
     */
    public AttrRange(String range) {
        String[] split = range.split("-");
        this.initRange = Integer.parseInt(split[0]);
        this.endRange = Integer.parseInt(split[1]);
    }

    /**
     * Verifica se o valor recebido está na faixa
     *
     * @param value {@code int} Valor verificado
     * @return {@code Boolean} Está na faixa?
     */
    public Boolean isBetween(int value) {
        return value >= initRange && value <= endRange;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.initRange;
        hash = 97 * hash + this.endRange;
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
        final AttrRange other = (AttrRange) obj;
        if (this.initRange != other.initRange) {
            return false;
        }
        return this.endRange == other.endRange;
    }

    @Override
    public String toString() {
        return "Faixa = {" + initRange + " ... " + endRange + '}';
    }

    /**
     * Retorna o inicio da faixa de pontos do atributo
     *
     * @return {@code int} Inicio da faixa
     */
    public int getInitRange() {
        return initRange;
    }

    /**
     * Modifica o inicio da faixa de pontos do atributo
     *
     * @param initRange {@code int} Inicio da faixa
     */
    public void setInitRange(int initRange) {
        this.initRange = initRange;
    }

    /**
     * Retorna o fim da faixa de pontos do atributo
     *
     * @return {@code int} Fim da faixa
     */
    public int getEndRange() {
        return endRange;
    }

    /**
     * Modifica o fim da faixa de pontos do atributo
     *
     * @param endRange {@code int} Fim da faixa
     */
    public void setEndRange(int endRange) {
        this.endRange = endRange;
    }

}
