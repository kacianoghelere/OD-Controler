package br.com.odcontroler.datatables;

import br.com.odcontroler.data.entity.AttrRange;

/**
 * Interface de padronização de atributos
 *
 * @author kaciano
 * @version 1.0
 */
public interface AttrData {

    /**
     * Retorna o Range do valor do atributo
     *
     * @return {@code AttrRange} Range do valor do atributo
     */
    AttrRange getRange();
}
