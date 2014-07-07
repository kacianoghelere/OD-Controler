package br.com.odcontroler.datatables.charisma;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo carisma
 *
 * @author kaciano
 * @version 1.0
 */
public class CharValues {

    private final List<CharData> charValues;

    /**
     * Cria nova instancia de CarValues
     */
    public CharValues() {
        this.charValues = new ArrayList<>();
        this.charValues.add(new CharData("0-1", 0, -25, "0"));
        this.charValues.add(new CharData("2-3", 0, -20, "0"));
        this.charValues.add(new CharData("4-5", 0, -15, "0"));
        this.charValues.add(new CharData("6-7", 0, -10, "0"));
        this.charValues.add(new CharData("8-9", 0, -5, "1"));
        this.charValues.add(new CharData("10-11", 1, 0, "1d2"));
        this.charValues.add(new CharData("12-13", 2, 5, "1d3"));
        this.charValues.add(new CharData("14-15", 3, 10, "1d4"));
        this.charValues.add(new CharData("16-17", 4, 15, "1d6"));
        this.charValues.add(new CharData("18-19", 5, 20, "1d8"));
        this.charValues.add(new CharData("20-21", 6, 25, "2d4"));
        this.charValues.add(new CharData("22-23", 7, 30, "1d10"));
        this.charValues.add(new CharData("24-25", 8, 35, "1d12"));
        this.charValues.add(new CharData("26-27", 9, 40, "2d6"));
        this.charValues.add(new CharData("28-29", 10, 45, "1d20"));
        this.charValues.add(new CharData("30-31", 10, 50, "1d20"));
        this.charValues.add(new CharData("32-33", 10, 55, "1d20"));
        this.charValues.add(new CharData("34-35", 11, 60, "2d12"));
        this.charValues.add(new CharData("36-37", 11, 65, "2d12"));
        this.charValues.add(new CharData("38-39", 11, 70, "2d12"));
        this.charValues.add(new CharData("40-41", 12, 75, "2d20"));
        this.charValues.add(new CharData("42-43", 12, 80, "2d20"));
        this.charValues.add(new CharData("44-45", 12, 85, "2d20"));
        this.charValues.add(new CharData("46-47", 13, 90, "3d12"));
        this.charValues.add(new CharData("48-49", 13, 95, "3d12"));
    }

    /**
     * Retorna a lista de valores para carisma
     *
     * @return {@code List(CarData)} Lista de valores para carisma
     */
    public List<CharData> getValues() {
        return charValues;
    }
}
