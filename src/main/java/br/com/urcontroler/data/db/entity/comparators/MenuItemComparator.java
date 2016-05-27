/*
 *  Este arquivo foi gerado com a graça do senhor
 *  Altere com cuidado e lembre-se: "Com grandes poderes, vem grandes responsabilidades" - Moisés
 */
package br.com.urcontroler.data.db.entity.comparators;

import br.com.urcontroler.data.db.entity.MenuItem;
import java.util.Comparator;

/**
 * Comparador de MenuItem
 * @author Kaciano Ghelere
 */
public class MenuItemComparator implements Comparator<MenuItem> {

    @Override
    public int compare(MenuItem o1, MenuItem o2) {
        return o1.getId().compareTo(o2.getId());
    }

}
