package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.Id;
import java.util.Objects;

/**
 * Entidade dos Status de personagens e inimigos
 *
 * @author kaciano
 * @version 1.0
 */
public class Status {

    @Ignore
    @Id
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Titulo")
    private String title;
    @ColumnName(name = "Duração")
    private Integer duration;
    @ColumnName(name = "Efeito")
    private Effect idEffect;

    /**
     * Cria nova instancia de Status
     */
    public Status() {
    }

    /**
     * Cria nova instancia de Status
     *
     * @param id {@code Long} Id do Status
     * @param title {@code String} Titulo do Status
     * @param duration {@code Integer} Duração do Status
     * @param idEffect {@code Effect} Efeito do Status
     */
    public Status(Long id, String title, Integer duration, Effect idEffect) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.idEffect = idEffect;
    }

    /**
     * Retorna o Id
     *
     * @return {@code Long} Id do Status
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Id
     *
     * @param id {@code Long} Id do Status
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Titulo
     *
     * @return {@code String} Titulo do Status
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o Titulo
     *
     * @param title {@code String} Titulo do Status
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna a Duração do Status
     *
     * @return {@code Integer} Duração do Status
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * Modifica a Duração do Status
     *
     * @param duration {@code Integer} Duração do Status
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * Retorna o Efeito do Status
     *
     * @return {@code Effect} Efeito do Status
     */
    public Effect getIdEffect() {
        return idEffect;
    }

    /**
     * Modifica o Efeito do Status
     *
     * @param idEffect {@code Effect} Efeito do Status
     */
    public void setIdEffect(Effect idEffect) {
        this.idEffect = idEffect;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final Status other = (Status) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return title;
    }

}
