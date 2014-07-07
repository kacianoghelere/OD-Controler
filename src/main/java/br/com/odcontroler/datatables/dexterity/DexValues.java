package br.com.odcontroler.datatables.dexterity;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo Destreza
 *
 * @author kaciano
 * @version 1.0
 */
public class DexValues {

    private final List<DexData> dexValues;

    /**
     * Cria nova instancia de DexValues
     */
    public DexValues() {
        this.dexValues = new ArrayList<>();
        dexValues.add(new DexData("0-1", -5, -25, -25, -25));
        dexValues.add(new DexData("2-3", -4, -20, -20, -20));
        dexValues.add(new DexData("4-5", -3, -15, -15, -15));
        dexValues.add(new DexData("6-7", -2, -10, -10, -10));
        dexValues.add(new DexData("8-9", -1, -5, -5, -5));
        dexValues.add(new DexData("10-11", 0, 0, 0, 0));
        dexValues.add(new DexData("12-13", 1, 0, 5, 0));
        dexValues.add(new DexData("14-15", 2, 0, 10, 5));
        dexValues.add(new DexData("16-17", 3, 5, 15, 10));
        dexValues.add(new DexData("18-19", 4, 10, 20, 15));
        dexValues.add(new DexData("20-21", 5, 15, 25, 20));
        dexValues.add(new DexData("22-23", 6, 20, 30, 25));
        dexValues.add(new DexData("24-25", 7, 25, 35, 30));
        dexValues.add(new DexData("26-27", 8, 30, 40, 35));
        dexValues.add(new DexData("28-29", 9, 35, 45, 40));
        dexValues.add(new DexData("30-31", 10, 40, 50, 45));
        dexValues.add(new DexData("32-33", 11, 45, 55, 50));
        dexValues.add(new DexData("34-35", 12, 50, 60, 55));
        dexValues.add(new DexData("36-37", 13, 55, 65, 60));
        dexValues.add(new DexData("38-39", 14, 60, 70, 65));
        dexValues.add(new DexData("40-41", 15, 65, 75, 70));
        dexValues.add(new DexData("42-43", 16, 70, 80, 75));
        dexValues.add(new DexData("44-45", 17, 75, 85, 80));
        dexValues.add(new DexData("46-47", 18, 80, 90, 85));
        dexValues.add(new DexData("48-49", 19, 85, 95, 90));
    }

    /**
     * Retorna a lista de valores para destreza
     *
     * @return {@code List(DexData)} Lista de valores para destreza
     */
    public List<DexData> getValues() {
        return dexValues;
    }

}
