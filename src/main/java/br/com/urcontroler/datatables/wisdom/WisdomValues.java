package br.com.urcontroler.datatables.wisdom;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo Sabedoria
 *
 * @author kaciano
 * @version 1.0
 */
public class WisdomValues {

    private final List<WisdomData> wisValues;

    /**
     * Cria nova instancia de WisValues
     */
    public WisdomValues() {
        this.wisValues = new ArrayList<>();
        wisValues.add(new WisdomData("0-1", -5));
        wisValues.add(new WisdomData("2-3", -4));
        wisValues.add(new WisdomData("4-5", -3));
        wisValues.add(new WisdomData("6-7", -2));
        wisValues.add(new WisdomData("8-9", -1));
        wisValues.add(new WisdomData("10-11", 0));
        wisValues.add(new WisdomData("12-13", 1));
        wisValues.add(new WisdomData("14-15", 2));
        wisValues.add(new WisdomData("16-17", 3));
        wisValues.add(new WisdomData("18-19", 4));
        wisValues.add(new WisdomData("20-21", 5));
        wisValues.add(new WisdomData("22-23", 6));
        wisValues.add(new WisdomData("24-25", 7));
        wisValues.add(new WisdomData("26-27", 8));
        wisValues.add(new WisdomData("28-29", 9));
        wisValues.add(new WisdomData("30-31", 10));
        wisValues.add(new WisdomData("32-33", 11));
        wisValues.add(new WisdomData("34-35", 12));
        wisValues.add(new WisdomData("36-37", 13));
        wisValues.add(new WisdomData("38-39", 14));
        wisValues.add(new WisdomData("40-41", 15));
        wisValues.add(new WisdomData("42-43", 16));
        wisValues.add(new WisdomData("44-45", 17));
        wisValues.add(new WisdomData("46-47", 18));
        wisValues.add(new WisdomData("48-49", 19));
    }

    /**
     * Retorna as faixas do atributo
     *
     * @return {@code List(WisData)} Lista de faixas
     */
    public List<WisdomData> getValues() {
        return wisValues;
    }

}
