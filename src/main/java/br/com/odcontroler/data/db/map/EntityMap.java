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
        map.put(Element.class, "ElementDB");
        map.put(Material.class, "MaterialsDB");
        map.put(ArmorType.class, "ArmorTypeDB");
        map.put(Effect.class, "EffectDB");
        map.put(EffectType.class, "EffectTypeDB");
        map.put(Menu.class, "MenuDB");
        map.put(MenuItem.class, "MenuItemDB");
        map.put(Perk.class, "PerkDB");
        map.put(PerkType.class, "PerkTypeDB");
        map.put(WeaponType.class, "WeaponTypeDB");
        map.put(Weapon.class, "WeaponDB");
        map.put(Armor.class, "ArmorDB");
        map.put(Expertise.class, "ExpertiseDB");
        map.put(ExpertiseType.class, "ExpertiseTypeDB");
        map.put(Origin.class, "OriginDB");
        map.put(ItemType.class, "ItemTypeDB");
        return map;
    }

}
