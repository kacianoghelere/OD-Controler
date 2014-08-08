package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import br.com.odcontroler.data.enums.Dice;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Entidade das classes de personagem
 *
 * @author kaciano
 */
public class CharClass implements Serializable {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String name;
    @ColumnName(name = "Dado de Vida")
    private Dice hpDice;
    @ColumnName(name = "CA Bônus")
    private Integer armorBonus;
    @Ignore
    @ColumnName(name = "Requerimentos")
    private Requires requires;
    @Ignore
    @ColumnName(name = "Armaduras Permitidas")
    private List<ArmorType> allowedArmors;
    @Ignore
    @ColumnName(name = "Armas Permitidas")
    private List<WeaponType> allowedWeapons;
    @Ignore
    @ColumnName(name = "Itens Permitidas")
    private List<ItemType> allowedItems;
    @Ignore
    @ColumnName(name = "Vantagens")
    private List<Perk> perks;

    /**
     * Cria nova instancia de CharClass
     */
    public CharClass() {
    }

    /**
     * Cria nova instancia de CharClass
     *
     * @param id {@code Long} Id da classe
     */
    public CharClass(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CharClass other = (CharClass) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return name;
    }

}
