package br.com.rpgruler.data.db.map;

import br.com.rpgruler.data.entity.Element;
import br.com.rpgruler.data.entity.RestrictionType;
import br.com.rpgruler.data.entity.Weapon;
import br.com.rpgruler.data.entity.UseType;
import br.com.rpgruler.data.entity.PerkType;
import br.com.rpgruler.data.entity.Expertise;
import br.com.rpgruler.data.entity.EffectType;
import br.com.rpgruler.data.entity.ArmorType;
import br.com.rpgruler.data.entity.WeaponType;
import br.com.rpgruler.data.entity.MenuItem;
import br.com.rpgruler.data.entity.ExpertiseType;
import br.com.rpgruler.data.entity.Perk;
import br.com.rpgruler.data.entity.Menu;
import br.com.rpgruler.data.entity.PrimeMaterial;
import br.com.rpgruler.data.entity.Armor;
import br.com.rpgruler.data.entity.Effect;
import br.com.rpgruler.data.entity.WeaponSize;
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
     * @return <code>Map(Class(?), String)</code> Mapa de arquivos de dados
     */
    public Map<Class<?>, String> getMap() {
        Map<Class<?>, String> map = new HashMap<>();
        map.put(Element.class, "ElementDB");
        map.put(PrimeMaterial.class, "MaterialsDB");
        map.put(ArmorType.class, "ArmorTypeDB");
        map.put(UseType.class, "UseTypeDB");
        map.put(Effect.class, "EffectDB");
        map.put(EffectType.class, "EffectTypeDB");
        map.put(Menu.class, "MenuDB");
        map.put(MenuItem.class, "MenuItemDB");
        map.put(Perk.class, "PerkDB");
        map.put(PerkType.class, "PerkTypeDB");
        map.put(WeaponType.class, "WeaponTypeDB");
        map.put(WeaponSize.class, "WeaponSizeDB");
        map.put(Weapon.class, "WeaponDB");
        map.put(RestrictionType.class, "RestrictionTypeDB");
        map.put(Armor.class, "ArmorDB");
        map.put(Expertise.class, "ExpertiseDB");
        map.put(ExpertiseType.class, "ExpertiseTypeDB");
        return map;
    }

}
