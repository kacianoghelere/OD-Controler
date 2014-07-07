package br.com.odcontroler.datatables.constitution;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo constituição
 *
 * @author kaciano
 * @version 1.0
 */
public class ConstValues {

    private final List<ConstData> conValues;

    /**
     * Cria nova instancia de ConValues
     */
    public ConstValues() {
        this.conValues = new ArrayList<>();
        this.conValues.add(new ConstData("0-1", -5, 0));
        this.conValues.add(new ConstData("2-3", -4, 0));
        this.conValues.add(new ConstData("4-5", -3, 0));
        this.conValues.add(new ConstData("6-7", -2, 1));
        this.conValues.add(new ConstData("8-9", -1, 5));
        this.conValues.add(new ConstData("10-11", 0, 10));
        this.conValues.add(new ConstData("12-13", 1, 25));
        this.conValues.add(new ConstData("14-15", 2, 50));
        this.conValues.add(new ConstData("16-17", 3, 75));
        this.conValues.add(new ConstData("18-19", 4, 95));
        this.conValues.add(new ConstData("20-21", 5, 100));
        this.conValues.add(new ConstData("22-23", 6, 100));
        this.conValues.add(new ConstData("24-25", 7, 100));
        this.conValues.add(new ConstData("26-27", 8, 100));
        this.conValues.add(new ConstData("28-29", 9, 100));
        this.conValues.add(new ConstData("30-31", 10, 100));
        this.conValues.add(new ConstData("32-33", 11, 100));
        this.conValues.add(new ConstData("34-35", 12, 100));
        this.conValues.add(new ConstData("36-37", 13, 100));
        this.conValues.add(new ConstData("38-39", 14, 100));
        this.conValues.add(new ConstData("40-41", 15, 100));
        this.conValues.add(new ConstData("42-43", 16, 100));
        this.conValues.add(new ConstData("44-45", 17, 100));
        this.conValues.add(new ConstData("46-47", 18, 100));
        this.conValues.add(new ConstData("48-49", 19, 100));
    }

    /**
     * Retorna a lista de valores para constituição
     *
     * @return {@code List(ConData)} Lista de valores para constituição
     */
    public List<ConstData> getValues() {
        return conValues;
    }
}
