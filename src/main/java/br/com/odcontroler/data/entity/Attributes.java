package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidade dos atributos para personagens, classes, raças, inimigos e
 * equipamentos.
 *
 * @author kaciano
 */
public class Attributes {

    @ColumnName(name = "FOR")
    private Attribute strength;
    @ColumnName(name = "DES")
    private Attribute dexterity;
    @ColumnName(name = "CON")
    private Attribute constitution;
    @ColumnName(name = "INT")
    private Attribute intelligence;
    @ColumnName(name = "WIS")
    private Attribute wisdom;
    @ColumnName(name = "CHA")
    private Attribute charisma;

    /**
     * Constroi nova instancia de Attributes
     */
    public Attributes() {
        this.strength = new Attribute((long) 1, "Força", "FOR", 0);
        this.dexterity = new Attribute((long) 2, "Destreza", "DEX", 0);
        this.constitution = new Attribute((long) 3, "Constituição", "CON", 0);
        this.intelligence = new Attribute((long) 4, "Inteligencia", "INT", 0);
        this.wisdom = new Attribute((long) 5, "Sabedoria", "SAB", 0);
        this.charisma = new Attribute((long) 6, "Carisma", "CAR", 0);
    }

    /**
     * Constroi nova instancia de Attributes
     *
     * @param str {@code Integer} Força
     * @param dex {@code Integer} Destreza
     * @param con {@code Integer} Constituição
     * @param intel {@code Integer} Inteligencia
     * @param wis {@code Integer} Sabedoria
     * @param charm {@code Integer} Carisma
     */
    public Attributes(Integer str, Integer dex, Integer con, Integer intel, Integer wis, Integer charm) {
        this.strength = new Attribute((long) 1, "Força", "FOR", str);
        this.dexterity = new Attribute((long) 2, "Destreza", "DEX", dex);
        this.constitution = new Attribute((long) 3, "Constituição", "CON", con);
        this.intelligence = new Attribute((long) 4, "Inteligencia", "INT", intel);
        this.wisdom = new Attribute((long) 5, "Sabedoria", "SAB", wis);
        this.charisma = new Attribute((long) 6, "Carisma", "CAR", charm);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Attribute attr : getValues()) {
            sb.append((attr.getAlias() + ": " + attr.getValue() + "\n"));
        }
        return sb.toString();
    }

    /**
     * Retorna os atributos usados
     *
     * @return {@code List(Attribute)} Atributos
     */
    public List<Attribute> getValues() {
        List<Attribute> list = new ArrayList<>();
        list.add(strength);
        list.add(dexterity);
        list.add(constitution);
        list.add(intelligence);
        list.add(wisdom);
        list.add(charisma);
        return list;
    }

    /**
     * Retorna a Força
     *
     * @return {@code Integer} Força
     */
    public Integer getStrength() {
        return strength.getValue();
    }

    /**
     * Modifica a Força
     *
     * @param strength {@code Integer} Força
     */
    public void setStrength(Integer strength) {
        this.strength.setValue(strength);
    }

    /**
     * Retorna a Destreza
     *
     * @return {@code Integer} Destreza
     */
    public Integer getDexterity() {
        return dexterity.getValue();
    }

    /**
     * Modifica a Destreza
     *
     * @param dexterity {@code Integer} Destreza
     */
    public void setDexterity(Integer dexterity) {
        this.dexterity.setValue(dexterity);
    }

    /**
     * Retorna a Constituição
     *
     * @return {@code Integer} Constituição
     */
    public Integer getConstitution() {
        return constitution.getValue();
    }

    /**
     * Modifica a Constituição
     *
     * @param constitution {@code Integer} Constituição
     */
    public void setConstitution(Integer constitution) {
        this.constitution.setValue(constitution);
    }

    /**
     * Retorna a Inteligencia
     *
     * @return {@code Integer} Inteligencia
     */
    public Integer getIntelligence() {
        return intelligence.getValue();
    }

    /**
     * Modifica a Inteligencia
     *
     * @param intelligence {@code Integer} Inteligencia
     */
    public void setIntelligence(Integer intelligence) {
        this.intelligence.setValue(intelligence);
    }

    /**
     * Retorna a Sabedoria
     *
     * @return {@code Integer} Sabedoria
     */
    public Integer getWisdom() {
        return wisdom.getValue();
    }

    /**
     * Modifica a Sabedoria
     *
     * @param wisdom {@code Integer} Sabedoria
     */
    public void setWisdom(Integer wisdom) {
        this.wisdom.setValue(wisdom);
    }

    /**
     * Retorna o Carisma
     *
     * @return {@code Integer} Carisma
     */
    public Integer getCharisma() {
        return charisma.getValue();
    }

    /**
     * Modifica o Carisma
     *
     * @param charisma {@code Integer} Carisma
     */
    public void setCharisma(Integer charisma) {
        this.charisma.setValue(charisma);
    }

  
}
