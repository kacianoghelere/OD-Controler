package br.com.odcontroler.datatables.strength;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo Força
 *
 * @author kaciano
 * @version 1.0
 */
public class StrengthValues {

    private final List<StrengthData> strValues;

    /**
     * Cria nova instancia de StrValues
     */
    public StrengthValues() {
        strValues = new ArrayList<>();
        int modifier = -5;
        int init = 0, end = 1;
        for (int i = 0; i < 25; i++) {
            strValues.add(new StrengthData(init, end, modifier++));
            init = ++end;
            end++;
        }
    }

    /**
     * Retorna as faixas do atributo
     *
     * @return {@code List(StrData)} Lista de faixas
     */
    public List<StrengthData> getValues() {
        return this.strValues;
    }

//    public static void main(String[] args) {
//        List<StrData> values1 = new StrValues().getValues();
//        for (StrData data : values1) {
//            System.out.println(data);
//        }
//    }
}
