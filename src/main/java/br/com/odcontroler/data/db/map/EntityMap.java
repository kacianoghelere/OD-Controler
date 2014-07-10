package br.com.odcontroler.data.db.map;

import br.com.odcontroler.data.entity.Element;
import br.com.odcontroler.data.entity.RestrictionType;
import br.com.odcontroler.data.entity.Weapon;
import br.com.odcontroler.data.enums.UseType;
import br.com.odcontroler.data.entity.PerkType;
import br.com.odcontroler.data.entity.Expertise;
import br.com.odcontroler.data.entity.EffectType;
import br.com.odcontroler.data.entity.ArmorType;
import br.com.odcontroler.data.entity.WeaponType;
import br.com.odcontroler.data.entity.MenuItem;
import br.com.odcontroler.data.entity.ExpertiseType;
import br.com.odcontroler.data.entity.Perk;
import br.com.odcontroler.data.entity.Menu;
import br.com.odcontroler.data.entity.PrimeMaterial;
import br.com.odcontroler.data.entity.Armor;
import br.com.odcontroler.data.entity.Effect;
import br.com.odcontroler.data.entity.Origin;
import br.com.odcontroler.data.enums.Size;
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
        map.put(Size.class, "WeaponSizeDB");
        map.put(Weapon.class, "WeaponDB");
        map.put(RestrictionType.class, "RestrictionTypeDB");
        map.put(Armor.class, "ArmorDB");
        map.put(Expertise.class, "ExpertiseDB");
        map.put(ExpertiseType.class, "ExpertiseTypeDB");
        map.put(Origin.class, "OriginDB");
        return map;
    }

}
