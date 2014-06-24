package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Entidade de vantagens
 *
 * @author kaciano
 * @version 1.0
 */
public class Perk {

    @NotCopiable
    @Ignore    
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String title;
    @ColumnName(name = "Descrição")
    private String description;
    @Editable
    @ColumnName(name = "Herdado")
    private Boolean inherited;
    @ColumnName(name = "Tipo")
    private PerkType type;

    /**
     * Cria nova instancia de Perk
     */
    public Perk() {
    }

    /**
     * Cria nova instancia de Perk
     *
     * @param id <code>Long</code> Código
     * @param title <code>String</code> Titulo
     * @param description <code>String</code> Descrição
     * @param inherited <code>Boolean</code> Herdavel?
     * @param type <code>PerkType</code> Tipo do perk
     */
    public Perk(Long id, String title, String description, Boolean inherited, PerkType type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.inherited = inherited;
        this.type = type;
    }

    /**
     * Retorna o ID do Perk
     *
     * @return <code>Long</code>
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do Perk
     *
     * @param id <code>Long</code>
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo do Perk
     *
     * @return <code>String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo do Perk
     *
     * @param title <code>String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna a descrição do Perk
     *
     * @return <code>String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica a descrição do Perk
     *
     * @param description <code>String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * O Perk é herdavel?
     *
     * @return <code>Boolean</code> Herdavel?
     */
    public Boolean isInherited() {
        return inherited;
    }

    /**
     * Modifica o status de herdavel do Perk
     *
     * @param inherited <code>Boolean</code> Herdavel?
     */
    public void setInherited(Boolean inherited) {
        this.inherited = inherited;
    }

    /**
     * Retorna o tipo do Perk
     *
     * @return <code>PerkType</code>
     */
    public PerkType getType() {
        return type;
    }

    /**
     * Modifica o tipo do Perk
     *
     * @param type <code>PerkType</code>
     */
    public void setType(PerkType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.inherited);
        hash = 71 * hash + Objects.hashCode(this.type);
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
        final Perk other = (Perk) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.inherited, other.inherited)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

    @Override
    public String toString() {
        return this.title;
    }

}
