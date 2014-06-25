package br.com.odcontroler.datatables.str;

import java.util.ArrayList;
import java.util.List;

/**
 * Coleção com os valores por faixa do atributo Força
 *
 * @author kaciano
 * @version 1.0
 */
public class StrValues {

    private List<StrData> strValues;

    /**
     * Cria nova instancia de StrValues
     */
    public StrValues() {
        strValues = new ArrayList<>();
        int modifier = -5;
        int init = 0, end = 1;
        for (int i = 0; i < 25; i++) {
            strValues.add(new StrData(init, end, modifier++));
            init = ++end;
            end++;
        }
    }

    /**
     * Retorna as faixas do atributo
     *
     * @return <code>List(StrData)</code> Lista de faixas
     */
    public List<StrData> getValues() {
        return this.strValues;
    }

//    public static void main(String[] args) {
//        List<StrData> values1 = new StrValues().getValues();
//        for (StrData data : values1) {
//            System.out.println(data);
//        }
//    }
}
