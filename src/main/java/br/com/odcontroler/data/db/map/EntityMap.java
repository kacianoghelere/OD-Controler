package br.com.odcontroler.data.db.map;

import br.com.odcontroler.data.entity.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Mapa de constantes para o banco de dados
 *
 * @author kaciano
 */
public class EntityMap {

    /**
     * Retorna o mapa de arquivos de dados
     *
     * @return {@code Map(Class(?), String)} Mapa de arquivos de dados
     */
    public Map<Class<?>, String> getMap() {
        Map<Class<?>, String> map = new HashMap<>();
        map.put(Armor.class, "ArmorDB");
        map.put(ArmorType.class, "ArmorTypeDB");
        map.put(Effect.class, "EffectDB");
        map.put(EffectType.class, "EffectTypeDB");
        map.put(ElementType.class, "ElementTypeDB");
        map.put(Expertise.class, "ExpertiseDB");
        map.put(ExpertiseType.class, "ExpertiseTypeDB");
        map.put(ItemType.class, "ItemTypeDB");
        map.put(MaterialType.class, "MaterialTypeDB");
        map.put(Menu.class, "MenuDB");
        map.put(MenuItem.class, "MenuItemDB");
        map.put(Origin.class, "OriginDB");
        map.put(Perk.class, "PerkDB");
        map.put(PerkType.class, "PerkTypeDB");
        map.put(Spell.class, "SpellDB");
        map.put(SpellType.class, "SpellTypeDB");
        map.put(Weapon.class, "WeaponDB");
        map.put(WeaponType.class, "WeaponTypeDB");
        return map;
    }

}
