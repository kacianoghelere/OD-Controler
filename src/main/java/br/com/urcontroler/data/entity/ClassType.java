package br.com.urcontroler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.gmp.utils.annotations.Id;
import br.com.gmp.utils.annotations.Ignore;
import java.util.Objects;

/**
 * Enumerador de tipos de classes
 *
 * @author kaciano
 * @version 1.0
 */
public class ClassType {

    @Id
    @Ignore
    @ColumnName(name = "Código")
    private Long id;
    @Editable
    @ColumnName(name = "Nome")
    private String name;
    @ColumnName(name = "Utiliza magias?")
    @Editable
    private boolean magic;
    @Editable
    @ColumnName(name = "Proteção")
    private Integer protection;

    /**
     * Cria nova instancia de ClassType
     */
    public ClassType() {
    }

    /**
     * Cria nova instancia de ClassType
     *
     * @param id {@code Long} ID do tipo
     * @param name {@code String} Nome do tipo
     * @param magic {@code boolean} Classe magica?
     * @param protection {@code Integer} Proteção base
     */
    public ClassType(Long id, String name, boolean magic, Integer protection) {
        this.id = id;
        this.name = name;
        this.magic = magic;
        this.protection = protection;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final ClassType other = (ClassType) obj;
        return Objects.equals(this.id, other.id);
    }

    /**
     * Retorna o ID do tipo
     *
     * @return {@code Long} ID do tipo
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o ID do tipo
     *
     * @param id {@code Long} ID do tipo
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o nome do tipo
     *
     * @return {@code String} Nome do tipo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do tipo
     *
     * @param name {@code String} Nome do tipo
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna se é um tipo de Classe magica
     *
     * @return {@code boolean} Classe magica?
     */
    public boolean isMagic() {
        return magic;
    }

    /**
     * Modifica se é um tipo de Classe magica
     *
     * @param magic {@code boolean} Classe magica?
     */
    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    /**
     * Retorna a Proteção base
     *
     * @return {@code Integer} Proteção base
     */
    public Integer getProtection() {
        return protection;
    }

    /**
     * Modifica a Proteção base
     *
     * @param protection {@code Integer} Proteção base
     */
    public void setProtection(Integer protection) {
        this.protection = protection;
    }

}
