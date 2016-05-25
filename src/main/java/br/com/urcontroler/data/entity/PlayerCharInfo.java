package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Kaciano Ghelere
 */
public class PlayerCharInfo implements Serializable {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nivel")
    private Long charLevel;
    @Ignore
//    @ColumnName(name = "Atributos")
//    private Attributes attributes;
    @ColumnName(name = "Personagem")
    private PlayerChar playerChar;
    @ColumnName(name = "Ativo")
    private Boolean active;

    /**
     * Cria nova instancia de PlayerCharInfo
     */
    public PlayerCharInfo() {
    }

    /**
     * Cria nova instancia de PlayerCharInfo
     *
     * @param id {@code Long} ID do Info
     * @param charLevel {@code Long} Nivel do personagem
     * @param attributes {@code Attributes} Atributos principais
     * @param playerChar {@code PlayerChar} Personagem
     */
//    public PlayerCharInfo(Long id, Long charLevel, Attributes attributes, PlayerChar playerChar) {
//        this.id = id;
//        this.charLevel = charLevel;
//        this.attributes = attributes;
//        this.playerChar = playerChar;
//        this.active = true;
//    }
    /**
     *
     * @return {@code Long} Id do Info
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id {@code Long} Id do Info
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return {@code Long} Nivel do personagem
     */
    public Long getCharLevel() {
        return charLevel;
    }

    /**
     *
     * @param charLevel {@code Long} Nivel do personagem
     */
    public void setCharLevel(Long charLevel) {
        this.charLevel = charLevel;
    }

    /**
     *
     * @return {@code Attributes} Atributos principais
     */
//    public Attributes getAttributes() {
//        return attributes;
//    }
    /**
     *
     * @param attributes {@code Attributes} Atributos principais
     */
//    public void setAttributes(Attributes attributes) {
//        this.attributes = attributes;
//    }
    /**
     *
     * @return {@code PlayerChar} Personagem
     */
    public PlayerChar getPlayerChar() {
        return playerChar;
    }

    /**
     *
     * @param playerChar {@code PlayerChar} Personagem
     */
    public void setPlayerChar(PlayerChar playerChar) {
        this.playerChar = playerChar;
    }

    /**
     *
     * @return {@code Boolean} Info ativo?
     */
    public Boolean isActive() {
        return active;
    }

    /**
     *
     * @param active {@code Boolean} Info ativo?
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final PlayerCharInfo other = (PlayerCharInfo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " - " + playerChar.getName() + " - " + charLevel;
    }

}
