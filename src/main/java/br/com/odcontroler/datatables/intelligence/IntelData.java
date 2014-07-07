package br.com.odcontroler.datatables.intelligence;

import br.com.odcontroler.data.entity.AttrRange;
import br.com.odcontroler.datatables.AttrData;
import java.util.Arrays;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de inteligencia
 *
 * @author kaciano
 * @version 1.0
 */
public class IntelData implements AttrData {

    private AttrRange range;
    private int languages;
    private int learnMagic;
    private int[] additSpells = new int[9];

    /**
     * Cria nova instancia de IntData
     */
    public IntelData() {

    }

    /**
     * Cria nova instancia de IntData
     *
     * @param range {@code AttrRange} Faixa de valores
     * @param languages {@code int} Idiomas adicionais
     * @param learnMagic {@code int} Porcentagem de aprender magica
     */
    public IntelData(AttrRange range, int languages, int learnMagic) {
        this.range = range;
        this.languages = languages;
        this.learnMagic = learnMagic;
    }

    /**
     * Cria nova instancia de IntData
     *
     * @param range {@code AttrRange} Faixa de valores
     * @param languages {@code int} Idiomas adicionais
     * @param learnMagic {@code int} Porcentagem de aprender magica
     * @param aditMagics {@code int[]} Magias adicionais
     */
    public IntelData(AttrRange range, int languages, int learnMagic, int[] aditMagics) {
        this.range = range;
        this.languages = languages;
        this.learnMagic = learnMagic;
        this.additSpells = aditMagics;
    }

    /**
     * Cria nova instancia de IntData
     *
     * @param init {@code int} Inicio da faixa
     * @param end {@code int} Fim da faixa
     * @param languages {@code int} Idiomas adicionais
     * @param learnMagic {@code int} Porcentagem de aprender magica
     */
    public IntelData(int init, int end, int languages, int learnMagic) {
        this.range = new AttrRange(init, end);
        this.languages = languages;
        this.learnMagic = learnMagic;
    }

    @Override
    public String toString() {
        return "IntData{"
                + range + ", "
                + "languages: " + languages + ", "
                + "learnMagic: " + learnMagic + ", "
                + "additSpells: " + Arrays.toString(additSpells) + '}';
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
     * Retorna os idiomas adicionais
     *
     * @return {@code int} Idiomas adicionais
     */
    public int getLanguages() {
        return languages;
    }

    /**
     * Modifica os idiomas adicionais
     *
     * @param languages {@code int} Idiomas adicionais
     */
    public void setLanguages(int languages) {
        this.languages = languages;
    }

    /**
     * Retorna a porcentagem de aprender magica
     *
     * @return {@code int} Porcentagem de aprender magica
     */
    public int getLearnMagic() {
        return learnMagic;
    }

    /**
     * Modifica a porcentagem de aprender magica
     *
     * @param learnMagic {@code int} Porcentagem de aprender magica
     */
    public void setLearnMagic(int learnMagic) {
        this.learnMagic = learnMagic;
    }

    /**
     * Retorna as magias adicionais
     *
     * @return {@code int[]} Magias adicionais
     */
    public int[] getAdditSpells() {
        return additSpells;
    }

    /**
     * Modifica as magias adicionais
     *
     * @param additSpells {@code int[]} Magias adicionais
     */
    public void setAdditSpells(int[] additSpells) {
        this.additSpells = additSpells;
    }

}
