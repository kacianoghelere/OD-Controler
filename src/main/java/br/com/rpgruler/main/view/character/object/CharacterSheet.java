package br.com.rpgruler.main.view.character.object;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Objeto de exportação de ficha de personagem
 *
 * @author kaciano
 */
public class CharacterSheet implements Serializable {

    //--------------------------------------------------------------------------
    // Basics
    private String charname;
    private String charClass;
    private String charRace;
    private String charAlign;
    private int charWeight;
    private int charHeigth;
    private int charAge;
    private String charSex;
    private int charLevel;
    //--------------------------------------------------------------------------
    // Attributes
    private int str;
    private int dex;
    private int con;
    private int intel;
    private int wis;
    private int charm;
    //--------------------------------------------------------------------------
    // STR bonuses
    private int attackAdjustment;
    private int damageAdjustment;
    //--------------------------------------------------------------------------
    // DEX bonuses
    private int dexAdjustment;
    private int ladinTalents;
    //--------------------------------------------------------------------------
    // CON bonuses
    private int hpAdjustment;
    private int consJP;
    private int percRessurrection;
    //--------------------------------------------------------------------------
    // INTEL bonuses
    private int languages;
    private int intLearnMagics;
    private int intAdMagics;
    //--------------------------------------------------------------------------
    // SAB bonuses
    private int wisJP;
    private int wisAdMagics;
    //--------------------------------------------------------------------------
    // CAR bonuses
    private int followers;
    private int reaction;
    private int livingDead;
    //--------------------------------------------------------------------------
    // Armor bonuses
    private int armorDex;
    private int armor;
    private int armorRace;
    private int finalCA;
    //--------------------------------------------------------------------------
    // HP bonuses
    private int lifePoints;
    //--------------------------------------------------------------------------
    // JP bonuses
    private int baseJP;
    private int dexJP;
    private int conJP;
    //--------------------------------------------------------------------------
    // Moviment bonuses
    private int raceMov;
    private int cargoMov;
    private int armorMov;
    private int finalMov;
    //--------------------------------------------------------------------------
    // Weapon bonuses
    private String weaponName1;
    private String weaponSize1;
    private int weaponDamage1;
    private int weaponRange1;
    private int weaponInit1;
    private int baFinal1;
    private int weaponAttrMod1;
    private int classDamage1;
    private int raceDamage1;
    private String weaponName2;
    private String weaponSize2;
    private int weaponDamage2;
    private int weaponRange2;
    private int weaponInit2;
    private int baFinal2;
    private int weaponAttrMod2;
    private int classDamage2;
    private int raceDamage2;
    //--------------------------------------------------------------------------
    // Equipment bonuses
    private String equipName1;
    private int equipWeight1;
    private String equipName2;
    private int equipWeight2;
    private String equipName3;
    private int equipWeight3;
    private String equipName4;
    private int equipWeight4;
    private String equipName5;
    private int equipWeight5;
    private String equipName6;
    private int equipWeight6;
    private String equipName7;
    private int equipWeight7;
    private String equipName8;
    private int equipWeight8;
    private int copper;
    private int silver;
    private int gold;
    //--------------------------------------------------------------------------
    // Expel bonuses
    private int expel1;
    private int expel2;
    private int expel3;
    private int expel4;
    private int expel5;
    private int expel6;
    private int expel7;
    private int expel8;
    //--------------------------------------------------------------------------
    // Talent bonuses    
    private int talent1;
    private int talent2;
    private int talent3;
    private int talent4;
    private int talent5;
    private int talent6;
    private int talent7;
    private int talent8;
    //--------------------------------------------------------------------------
    // Cargo bonuses    
    private int low;
    private int medium;
    private int max;
    //--------------------------------------------------------------------------
    // Cargo bonuses    
    private int exp;

    public CharacterSheet() {
        for (Field field : getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object get = field.get(this);
                if (get instanceof Integer) {
                    field.set(this, 1);
                } else if (get instanceof String) {
                    field.set(this, "A");
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(CharacterSheet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getCharname() {
        return charname;
    }

    public void setCharname(String charname) {
        this.charname = charname;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String getCharRace() {
        return charRace;
    }

    public void setCharRace(String charRace) {
        this.charRace = charRace;
    }

    public String getCharAlign() {
        return charAlign;
    }

    public void setCharAlign(String charAlign) {
        this.charAlign = charAlign;
    }

    public int getCharWeight() {
        return charWeight;
    }

    public void setCharWeight(int charWeight) {
        this.charWeight = charWeight;
    }

    public int getCharHeigth() {
        return charHeigth;
    }

    public void setCharHeigth(int charHeigth) {
        this.charHeigth = charHeigth;
    }

    public int getCharAge() {
        return charAge;
    }

    public void setCharAge(int charAge) {
        this.charAge = charAge;
    }

    public String getCharSex() {
        return charSex;
    }

    public void setCharSex(String charSex) {
        this.charSex = charSex;
    }

    public int getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(int charLevel) {
        this.charLevel = charLevel;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public int getAttackAdjustment() {
        return attackAdjustment;
    }

    public void setAttackAdjustment(int attackAdjustment) {
        this.attackAdjustment = attackAdjustment;
    }

    public int getDamageAdjustment() {
        return damageAdjustment;
    }

    public void setDamageAdjustment(int damageAdjustment) {
        this.damageAdjustment = damageAdjustment;
    }

    public int getDexAdjustment() {
        return dexAdjustment;
    }

    public void setDexAdjustment(int dexAdjustment) {
        this.dexAdjustment = dexAdjustment;
    }

    public int getLadinTalents() {
        return ladinTalents;
    }

    public void setLadinTalents(int ladinTalents) {
        this.ladinTalents = ladinTalents;
    }

    public int getHpAdjustment() {
        return hpAdjustment;
    }

    public void setHpAdjustment(int hpAdjustment) {
        this.hpAdjustment = hpAdjustment;
    }

    public int getConsJP() {
        return consJP;
    }

    public void setConsJP(int consJP) {
        this.consJP = consJP;
    }

    public int getPercRessurrection() {
        return percRessurrection;
    }

    public void setPercRessurrection(int percRessurrection) {
        this.percRessurrection = percRessurrection;
    }

    public int getLanguages() {
        return languages;
    }

    public void setLanguages(int languages) {
        this.languages = languages;
    }

    public int getIntLearnMagics() {
        return intLearnMagics;
    }

    public void setIntLearnMagics(int intLearnMagics) {
        this.intLearnMagics = intLearnMagics;
    }

    public int getIntAdMagics() {
        return intAdMagics;
    }

    public void setIntAdMagics(int intAdMagics) {
        this.intAdMagics = intAdMagics;
    }

    public int getWisJP() {
        return wisJP;
    }

    public void setWisJP(int wisJP) {
        this.wisJP = wisJP;
    }

    public int getWisAdMagics() {
        return wisAdMagics;
    }

    public void setWisAdMagics(int wisAdMagics) {
        this.wisAdMagics = wisAdMagics;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getReaction() {
        return reaction;
    }

    public void setReaction(int reaction) {
        this.reaction = reaction;
    }

    public int getLivingDead() {
        return livingDead;
    }

    public void setLivingDead(int livingDead) {
        this.livingDead = livingDead;
    }

    public int getArmorDex() {
        return armorDex;
    }

    public void setArmorDex(int armorDex) {
        this.armorDex = armorDex;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getArmorRace() {
        return armorRace;
    }

    public void setArmorRace(int armorRace) {
        this.armorRace = armorRace;
    }

    public int getFinalCA() {
        return finalCA;
    }

    public void setFinalCA(int finalCA) {
        this.finalCA = finalCA;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public int getBaseJP() {
        return baseJP;
    }

    public void setBaseJP(int baseJP) {
        this.baseJP = baseJP;
    }

    public int getDexJP() {
        return dexJP;
    }

    public void setDexJP(int dexJP) {
        this.dexJP = dexJP;
    }

    public int getConJP() {
        return conJP;
    }

    public void setConJP(int conJP) {
        this.conJP = conJP;
    }

    public int getRaceMov() {
        return raceMov;
    }

    public void setRaceMov(int raceMov) {
        this.raceMov = raceMov;
    }

    public int getCargoMov() {
        return cargoMov;
    }

    public void setCargoMov(int cargoMov) {
        this.cargoMov = cargoMov;
    }

    public int getArmorMov() {
        return armorMov;
    }

    public void setArmorMov(int armorMov) {
        this.armorMov = armorMov;
    }

    public int getFinalMov() {
        return finalMov;
    }

    public void setFinalMov(int finalMov) {
        this.finalMov = finalMov;
    }

    public String getWeaponName1() {
        return weaponName1;
    }

    public void setWeaponName1(String weaponName1) {
        this.weaponName1 = weaponName1;
    }

    public String getWeaponSize1() {
        return weaponSize1;
    }

    public void setWeaponSize1(String weaponSize1) {
        this.weaponSize1 = weaponSize1;
    }

    public int getWeaponDamage1() {
        return weaponDamage1;
    }

    public void setWeaponDamage1(int weaponDamage1) {
        this.weaponDamage1 = weaponDamage1;
    }

    public int getWeaponRange1() {
        return weaponRange1;
    }

    public void setWeaponRange1(int weaponRange1) {
        this.weaponRange1 = weaponRange1;
    }

    public int getWeaponInit1() {
        return weaponInit1;
    }

    public void setWeaponInit1(int weaponInit1) {
        this.weaponInit1 = weaponInit1;
    }

    public int getBaFinal1() {
        return baFinal1;
    }

    public void setBaFinal1(int baFinal1) {
        this.baFinal1 = baFinal1;
    }

    public int getWeaponAttrMod1() {
        return weaponAttrMod1;
    }

    public void setWeaponAttrMod1(int weaponAttrMod1) {
        this.weaponAttrMod1 = weaponAttrMod1;
    }

    public int getClassDamage1() {
        return classDamage1;
    }

    public void setClassDamage1(int classDamage1) {
        this.classDamage1 = classDamage1;
    }

    public int getRaceDamage1() {
        return raceDamage1;
    }

    public void setRaceDamage1(int raceDamage1) {
        this.raceDamage1 = raceDamage1;
    }

    public String getWeaponName2() {
        return weaponName2;
    }

    public void setWeaponName2(String weaponName2) {
        this.weaponName2 = weaponName2;
    }

    public String getWeaponSize2() {
        return weaponSize2;
    }

    public void setWeaponSize2(String weaponSize2) {
        this.weaponSize2 = weaponSize2;
    }

    public int getWeaponDamage2() {
        return weaponDamage2;
    }

    public void setWeaponDamage2(int weaponDamage2) {
        this.weaponDamage2 = weaponDamage2;
    }

    public int getWeaponRange2() {
        return weaponRange2;
    }

    public void setWeaponRange2(int weaponRange2) {
        this.weaponRange2 = weaponRange2;
    }

    public int getWeaponInit2() {
        return weaponInit2;
    }

    public void setWeaponInit2(int weaponInit2) {
        this.weaponInit2 = weaponInit2;
    }

    public int getBaFinal2() {
        return baFinal2;
    }

    public void setBaFinal2(int baFinal2) {
        this.baFinal2 = baFinal2;
    }

    public int getWeaponAttrMod2() {
        return weaponAttrMod2;
    }

    public void setWeaponAttrMod2(int weaponAttrMod2) {
        this.weaponAttrMod2 = weaponAttrMod2;
    }

    public int getClassDamage2() {
        return classDamage2;
    }

    public void setClassDamage2(int classDamage2) {
        this.classDamage2 = classDamage2;
    }

    public int getRaceDamage2() {
        return raceDamage2;
    }

    public void setRaceDamage2(int raceDamage2) {
        this.raceDamage2 = raceDamage2;
    }

    public String getEquipName1() {
        return equipName1;
    }

    public void setEquipName1(String equipName1) {
        this.equipName1 = equipName1;
    }

    public int getEquipWeight1() {
        return equipWeight1;
    }

    public void setEquipWeight1(int equipWeight1) {
        this.equipWeight1 = equipWeight1;
    }

    public String getEquipName2() {
        return equipName2;
    }

    public void setEquipName2(String equipName2) {
        this.equipName2 = equipName2;
    }

    public int getEquipWeight2() {
        return equipWeight2;
    }

    public void setEquipWeight2(int equipWeight2) {
        this.equipWeight2 = equipWeight2;
    }

    public String getEquipName3() {
        return equipName3;
    }

    public void setEquipName3(String equipName3) {
        this.equipName3 = equipName3;
    }

    public int getEquipWeight3() {
        return equipWeight3;
    }

    public void setEquipWeight3(int equipWeight3) {
        this.equipWeight3 = equipWeight3;
    }

    public String getEquipName4() {
        return equipName4;
    }

    public void setEquipName4(String equipName4) {
        this.equipName4 = equipName4;
    }

    public int getEquipWeight4() {
        return equipWeight4;
    }

    public void setEquipWeight4(int equipWeight4) {
        this.equipWeight4 = equipWeight4;
    }

    public String getEquipName5() {
        return equipName5;
    }

    public void setEquipName5(String equipName5) {
        this.equipName5 = equipName5;
    }

    public int getEquipWeight5() {
        return equipWeight5;
    }

    public void setEquipWeight5(int equipWeight5) {
        this.equipWeight5 = equipWeight5;
    }

    public String getEquipName6() {
        return equipName6;
    }

    public void setEquipName6(String equipName6) {
        this.equipName6 = equipName6;
    }

    public int getEquipWeight6() {
        return equipWeight6;
    }

    public void setEquipWeight6(int equipWeight6) {
        this.equipWeight6 = equipWeight6;
    }

    public String getEquipName7() {
        return equipName7;
    }

    public void setEquipName7(String equipName7) {
        this.equipName7 = equipName7;
    }

    public int getEquipWeight7() {
        return equipWeight7;
    }

    public void setEquipWeight7(int equipWeight7) {
        this.equipWeight7 = equipWeight7;
    }

    public String getEquipName8() {
        return equipName8;
    }

    public void setEquipName8(String equipName8) {
        this.equipName8 = equipName8;
    }

    public int getEquipWeight8() {
        return equipWeight8;
    }

    public void setEquipWeight8(int equipWeight8) {
        this.equipWeight8 = equipWeight8;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExpel1() {
        return expel1;
    }

    public void setExpel1(int expel1) {
        this.expel1 = expel1;
    }

    public int getExpel2() {
        return expel2;
    }

    public void setExpel2(int expel2) {
        this.expel2 = expel2;
    }

    public int getExpel3() {
        return expel3;
    }

    public void setExpel3(int expel3) {
        this.expel3 = expel3;
    }

    public int getExpel4() {
        return expel4;
    }

    public void setExpel4(int expel4) {
        this.expel4 = expel4;
    }

    public int getExpel5() {
        return expel5;
    }

    public void setExpel5(int expel5) {
        this.expel5 = expel5;
    }

    public int getExpel6() {
        return expel6;
    }

    public void setExpel6(int expel6) {
        this.expel6 = expel6;
    }

    public int getExpel7() {
        return expel7;
    }

    public void setExpel7(int expel7) {
        this.expel7 = expel7;
    }

    public int getExpel8() {
        return expel8;
    }

    public void setExpel8(int expel8) {
        this.expel8 = expel8;
    }

    public int getTalent1() {
        return talent1;
    }

    public void setTalent1(int talent1) {
        this.talent1 = talent1;
    }

    public int getTalent2() {
        return talent2;
    }

    public void setTalent2(int talent2) {
        this.talent2 = talent2;
    }

    public int getTalent3() {
        return talent3;
    }

    public void setTalent3(int talent3) {
        this.talent3 = talent3;
    }

    public int getTalent4() {
        return talent4;
    }

    public void setTalent4(int talent4) {
        this.talent4 = talent4;
    }

    public int getTalent5() {
        return talent5;
    }

    public void setTalent5(int talent5) {
        this.talent5 = talent5;
    }

    public int getTalent6() {
        return talent6;
    }

    public void setTalent6(int talent6) {
        this.talent6 = talent6;
    }

    public int getTalent7() {
        return talent7;
    }

    public void setTalent7(int talent7) {
        this.talent7 = talent7;
    }

    public int getTalent8() {
        return talent8;
    }

    public void setTalent8(int talent8) {
        this.talent8 = talent8;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

}
