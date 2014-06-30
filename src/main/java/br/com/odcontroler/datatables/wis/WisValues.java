package br.com.odcontroler.datatables.wis;

import br.com.odcontroler.data.entity.AttrRange;
import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo Sabedoria
 *
 * @author kaciano
 * @version 1.0
 */
public class WisValues {

    private final List<WisData> wisValues;

    /**
     * Cria nova instancia de WisValues
     */
    public WisValues() {
        this.wisValues = new ArrayList<>();
        wisValues.add(new WisData(new AttrRange("0-1"), -5, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("2-3"), -4, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("4-5"), -3, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("6-7"), -2, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("8-9"), -1, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("10-11"), 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("12-13"), 1, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("14-15"), 2, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("16-17"), 3, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("18-19"), 4, new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("20-21"), 5, new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("22-23"), 6, new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("24-25"), 7, new int[]{2, 2, 1, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("26-27"), 8, new int[]{3, 2, 1, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("28-29"), 9, new int[]{3, 3, 1, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("30-31"), 10, new int[]{3, 3, 2, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("32-33"), 11, new int[]{3, 3, 3, 0, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("34-35"), 12, new int[]{3, 3, 3, 1, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("36-37"), 13, new int[]{4, 3, 3, 1, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("38-39"), 14, new int[]{4, 4, 3, 1, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("40-41"), 15, new int[]{4, 4, 4, 1, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("42-43"), 16, new int[]{4, 4, 4, 1, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("44-45"), 17, new int[]{4, 4, 4, 2, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("46-47"), 18, new int[]{4, 4, 4, 3, 0, 0, 0, 0, 0}));
        wisValues.add(new WisData(new AttrRange("48-49"), 19, new int[]{4, 4, 4, 4, 1, 0, 0, 0, 0}));
    }

    /**
     * Retorna as faixas do atributo
     *
     * @return {@code List(WisData)} Lista de faixas
     */
    public List<WisData> getWisValues() {
        return wisValues;
    }

}
