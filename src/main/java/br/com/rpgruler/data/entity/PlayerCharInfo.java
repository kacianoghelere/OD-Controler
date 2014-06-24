package br.com.rpgruler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author kaciano
 */
public class PlayerCharInfo implements Serializable {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nivel")
    private Long charLevel;
    @Ignore
    @ColumnName(name = "Atributos")
    private Attributes attributes;
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
     * @param id <code>Long</code> ID do Info
     * @param charLevel <code>Long</code> Nivel do personagem
     * @param attributes <code>Attributes</code> Atributos principais
     * @param playerChar <code>PlayerChar</code> Personagem
     */
    public PlayerCharInfo(Long id, Long charLevel, Attributes attributes, PlayerChar playerChar) {
        this.id = id;
        this.charLevel = charLevel;
        this.attributes = attributes;
        this.playerChar = playerChar;
        this.active = true;
    }

    /**
     *
     * @return <code>Long</code> ID do Info
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id <code>Long</code> ID do Info
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return <code>Long</code> Nivel do personagem
     */
    public Long getCharLevel() {
        return charLevel;
    }

    /**
     *
     * @param charLevel <code>Long</code> Nivel do personagem
     */
    public void setCharLevel(Long charLevel) {
        this.charLevel = charLevel;
    }

    /**
     *
     * @return <code>Attributes</code> Atributos principais
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     *
     * @param attributes <code>Attributes</code> Atributos principais
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    /**
     *
     * @return <code>PlayerChar</code> Personagem
     */
    public PlayerChar getPlayerChar() {
        return playerChar;
    }

    /**
     *
     * @param playerChar <code>PlayerChar</code> Personagem
     */
    public void setPlayerChar(PlayerChar playerChar) {
        this.playerChar = playerChar;
    }

    /**
     *
     * @return <code>Boolean</code> Info ativo?
     */
    public Boolean isActive() {
        return active;
    }

    /**
     *
     * @param active <code>Boolean</code> Info ativo?
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.charLevel);
        hash = 29 * hash + Objects.hashCode(this.attributes);
        hash = 29 * hash + Objects.hashCode(this.playerChar);
        hash = 29 * hash + Objects.hashCode(this.active);
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
        if (!Objects.equals(this.charLevel, other.charLevel)) {
            return false;
        }
        if (!Objects.equals(this.attributes, other.attributes)) {
            return false;
        }
        if (!Objects.equals(this.playerChar, other.playerChar)) {
            return false;
        }
        return Objects.equals(this.active, other.active);
    }



    @Override
    public String toString() {
        return id + " - " + playerChar.getName() + " - " + charLevel;
    }

}
