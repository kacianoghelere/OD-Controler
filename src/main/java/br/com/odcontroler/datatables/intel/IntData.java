package br.com.odcontroler.datatables.intel;

import br.com.odcontroler.data.entity.AttrRange;
import java.util.Arrays;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de inteligencia
 *
 * @author kaciano
 * @version 1.0
 */
public class IntData {

    private AttrRange range;
    private int languages;
    private int learnMagic;
    private int[] additSpells = new int[9];

    /**
     * Cria nova instancia de IntData
     */
    public IntData() {

    }

    /**
     * Cria nova instancia de IntData
     *
     * @param range <code>AttrRange</code> Faixa de valores
     * @param languages <code>int</code> Idiomas adicionais
     * @param learnMagic <code>int</code> Porcentagem de aprender magica
     */
    public IntData(AttrRange range, int languages, int learnMagic) {
        this.range = range;
        this.languages = languages;
        this.learnMagic = learnMagic;
    }
    /**
     * Cria nova instancia de IntData
     *
     * @param range <code>AttrRange</code> Faixa de valores
     * @param languages <code>int</code> Idiomas adicionais
     * @param learnMagic <code>int</code> Porcentagem de aprender magica
     * @param aditMagics <code>int[]</code> Magias adicionais
     */
    public IntData(AttrRange range, int languages, int learnMagic, int[] aditMagics) {
        this.range = range;
        this.languages = languages;
        this.learnMagic = learnMagic;
        this.additSpells = aditMagics;
    }

    /**
     * Cria nova instancia de IntData
     *
     * @param init <code>int</code> Inicio da faixa
     * @param end <code>int</code> Fim da faixa
     * @param languages <code>int</code> Idiomas adicionais
     * @param learnMagic <code>int</code> Porcentagem de aprender magica
     */
    public IntData(int init, int end, int languages, int learnMagic) {
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
     * Retorna os idiomas adicionais
     *
     * @return <code>int</code> Idiomas adicionais
     */
    public int getLanguages() {
        return languages;
    }

    /**
     * Modifica os idiomas adicionais
     *
     * @param languages <code>int</code> Idiomas adicionais
     */
    public void setLanguages(int languages) {
        this.languages = languages;
    }

    /**
     * Retorna a porcentagem de aprender magica
     *
     * @return <code>int</code> Porcentagem de aprender magica
     */
    public int getLearnMagic() {
        return learnMagic;
    }

    /**
     * Modifica a porcentagem de aprender magica
     *
     * @param learnMagic <code>int</code> Porcentagem de aprender magica
     */
    public void setLearnMagic(int learnMagic) {
        this.learnMagic = learnMagic;
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
