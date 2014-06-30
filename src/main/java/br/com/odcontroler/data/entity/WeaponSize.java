package br.com.odcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import java.util.Objects;

/**
 * Objeto de tamanho de armas
 *
 * @author kaciano
 * @version 1.0
 */
public class WeaponSize {

    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Titulo")
    private String title;

    /**
     * Cria nova instancia de WeaponSize
     */
    public WeaponSize() {
    }

    /**
     * Cria nova instancia de WeaponSize
     *
     * @param id {@code Long} Código do tipo
     * @param title {@code String} Titulo do tipo
     */
    public WeaponSize(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Retorna o código
     *
     * @return {@code Long} Código do tipo
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o código
     *
     * @param id {@code Long} Código do tipo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o titulo
     *
     * @return {@code String} Titulo do tipo
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica o titulo
     *
     * @param title {@code String} Titulo do tipo
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.title);
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
        final WeaponSize other = (WeaponSize) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.title, other.title);
    }
}
