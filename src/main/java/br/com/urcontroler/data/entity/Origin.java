package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade da origem dos itens
 *
 * @author Kaciano Ghelere
 * @version 1.0
 */
public class Origin {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @Editable
    @ColumnName(name = "Variação")
    private String variation;
    @Editable
    @ColumnName(name = "Bônus")
    private Integer bonus;

    /**
     * Cria nova instancia de Origin
     *
     * @param id {@code Long} Id da origem
     * @param name {@code String} Nome da origem
     * @param variation {@code String} Variação do nome da origem
     * @param bonus {@code Integer} Bonus da origem
     */
    public Origin(Long id, String name, String variation, Integer bonus) {
        this.id = id;
        this.name = name;
        this.variation = variation;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Origin other = (Origin) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna o Id da origem
     *
     * @return {@code Long} Id da origem
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id da origem
     *
     * @param id {@code Long} Id da origem
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome da origem
     *
     * @return {@code String} Nome da origem
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome da origem
     *
     * @param name {@code String} Nome da origem
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna a variação do nome da origem
     *
     * @return {@code String} Variação do nome da origem
     */
    public String getVariation() {
        return variation;
    }

    /**
     * Modifica a variação do nome da origem
     *
     * @param variation {@code String} Variação do nome da origem
     */
    public void setVariation(String variation) {
        this.variation = variation;
    }

    /**
     * Retorna o bônus da origem
     *
     * @return {@code Integer} Bônus da origem
     */
    public Integer getBonus() {
        return bonus;
    }

    /**
     * Modifica o bônus da origem
     *
     * @param bonus {@code Integer} Bônus da origem
     */
    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

}
