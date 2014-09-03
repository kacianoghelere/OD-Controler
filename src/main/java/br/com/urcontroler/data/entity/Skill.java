package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Id;
import br.com.gmp.utils.annotations.Ignore;
import br.com.urcontroler.data.enums.SkillType;
import java.util.Objects;

/**
 * Entidade das habilidades singulares
 *
 * @author kaciano
 * @version 1.0
 */
public class Skill {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Efeito")
    private Effect effect;
    @Editable
    @ColumnName(name = "Tipo")
    private SkillType skillType;
    @Editable
    @ColumnName(name = "Descrição")
    private String description;

    /**
     * Cria nova instancia de Skill
     */
    public Skill() {
    }

    /**
     * Cria nova instancia de Skill
     *
     * @param id {@code Long} Código da habilidade
     * @param name {@code String} Nome da habilidade
     * @param effect {@code Effect} Efeito da habilidade
     * @param skillType {@code SkillType} Tipo da habilidade
     * @param description {@code String} Descrição da habilidade
     */
    public Skill(Long id, String name, Effect effect, SkillType skillType,
            String description) {
        this.id = id;
        this.name = name;
        this.effect = effect;
        this.skillType = skillType;
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Skill other = (Skill) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna o Código da habilidade
     *
     * @return {@code Long} Código da habilidade
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código da habilidade
     *
     * @param id {@code Long} Código da habilidade
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da habilidade
     *
     * @return {@code String} Nome da habilidade
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da habilidade
     *
     * @param name {@code String} Nome da habilidade
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Efeito da habilidade
     *
     * @return {@code Effect} Efeito da habilidade
     */
    public Effect getEffect() {
        return effect;
    }

    /**
     * Modifica o Efeito da habilidade
     *
     * @param effect {@code Effect} Efeito da habilidade
     */
    public void setEffect(Effect effect) {
        this.effect = effect;
    }

    /**
     * Retorna o Tipo da habilidade
     *
     * @return {@code SkillType} Tipo da habilidade
     */
    public SkillType getSkillType() {
        return skillType;
    }

    /**
     * Modifica o Tipo da habilidade
     *
     * @param skillType {@code SkillType} Tipo da habilidade
     */
    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    /**
     * Retorna o Descrição da habilidade
     *
     * @return {@code String} Descrição da habilidade
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica o Descrição da habilidade
     *
     * @param description {@code String} Descrição da habilidade
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
