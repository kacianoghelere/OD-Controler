/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity.comparators;

import br.com.urcontroler.data.db.entity.Menu;
import java.util.Comparator;

/**
 * Comparador de Menu
 *
 * @author Kaciano Ghelere
 */
public class MenuComparator implements Comparator<Menu> {

    @Override
    public int compare(Menu o1, Menu o2) {
        return o1.getId().compareTo(o2.getId());
    }

}
