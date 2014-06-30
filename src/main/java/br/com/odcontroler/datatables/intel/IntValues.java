package br.com.odcontroler.datatables.intel;

import br.com.odcontroler.data.entity.AttrRange;
import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo Inteligencia
 *
 * @author kaciano
 * @version 1.0
 */
public class IntValues {

    private final List<IntData> intValues;

    /**
     * Cria nova instancia de IntValues
     */
    public IntValues() {
        this.intValues = new ArrayList<>();
        intValues.add(new IntData(new AttrRange("0-1"), 0, 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("2-3"), 0, 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("4-5"), 0, 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("6-7"), 0, 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("8-9"), 0, 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("10-11"), 0, 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("12-13"), 0, 0, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("14-15"), 1, 25, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("16-17"), 2, 35, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("18-19"), 3, 45, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("20-21"), 4, 55, new int[]{2, 1, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("22-23"), 5, 65, new int[]{2, 2, 0, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("24-25"), 6, 75, new int[]{2, 2, 1, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("26-27"), 7, 85, new int[]{3, 2, 1, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("28-29"), 8, 95, new int[]{3, 3, 1, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("30-31"), 8, 95, new int[]{3, 3, 2, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("32-33"), 8, 95, new int[]{3, 3, 3, 0, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("34-35"), 8, 95, new int[]{3, 3, 3, 1, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("36-37"), 8, 95, new int[]{4, 3, 3, 1, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("38-39"), 8, 95, new int[]{4, 4, 3, 1, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("40-41"), 8, 95, new int[]{4, 4, 4, 1, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("42-43"), 8, 95, new int[]{4, 4, 4, 1, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("44-45"), 8, 95, new int[]{4, 4, 4, 2, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("46-47"), 8, 95, new int[]{4, 4, 4, 3, 0, 0, 0, 0, 0}));
        intValues.add(new IntData(new AttrRange("48-49"), 8, 95, new int[]{4, 4, 4, 4, 1, 0, 0, 0, 0}));
    }

    /**
     * Retorna a lista de valores para inteligencia
     *
     * @return {@code List(IntData)} Lista de valores para inteligencia
     */
    public List<IntData> getIntValues() {
        return intValues;
    }

    public static void main(String[] args) {
        List<IntData> intValues = new IntValues().getIntValues();
        for (IntData data : intValues) {
            System.out.println(data);
        }
    }
}
