package br.com.rpgruler.data.entity;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Ignore;
import br.com.gmp.utils.annotations.NotCopiable;
import java.util.Objects;

/**
 * Matérias primas
 *
 * @author kaciano
 */
public class PrimeMaterial {

    @Ignore
    @NotCopiable
    @ColumnName(name = "Código")
    private Long id;
    @ColumnName(name = "Nome")
    private String name;
    @ColumnName(name = "Peso/Unidade")
    private Double weight;
    @ColumnName(name = "Classe")
    private Integer materialClass;
    @ColumnName(name = "Resistencia/Unidade")
    private Double resistence;

    /**
     * Cria nova instancia de PrimeMaterial
     */
    public PrimeMaterial() {
    }

    /**
     * Cria nova instancia de PrimeMaterial
     *
     * @param id <code>Long</code> Código do material
     * @param name <code>String</code> Nome do material
     * @param weight <code>Double</code> Peso do material
     * @param materialClass <code>Integer</code> Classificação do material
     */
    public PrimeMaterial(Long id, String name, Double weight, Integer materialClass) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.materialClass = materialClass;
        this.resistence = (weight * materialClass);
    }

    /**
     * Método para calculo da resistencia
     */
    public void calcResistence() {
        this.resistence = (weight * materialClass);
    }

    /**
     * Retorna o Código do material
     *
     * @return <code>Long</code> Código do material
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica o Código do material
     *
     * @param id <code>Long</code> Código do material
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna o Nome do material
     *
     * @return <code>String</code> Nome do material
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Nome do material
     *
     * @param name <code>String</code> Nome do material
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o Peso do material
     *
     * @return <code>Double</code> Peso do material
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Modifica o Peso do material
     *
     * @param weight <code>Double</code> Peso do material
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Retorna a Classificação do material
     *
     * @return <code>Integer</code> Classificação do material
     */
    public Integer getMaterialClass() {
        return materialClass;
    }

    /**
     * Modifica a Classificação do material
     *
     * @param materialClass <code>Integer</code> Classificação do material
     */
    public void setMaterialClass(Integer materialClass) {
        this.materialClass = materialClass;
    }

    /**
     * Retorna a Resistencia do material
     *
     * @return <code>Double</code> Resistencia do material
     */
    public Double getResistence() {
        resistence = (weight * materialClass);
        return resistence;
    }

    /**
     * Modifica a Resistencia do material
     *
     * @param resistence <code>Double</code> Resistencia do material
     */
    public void setResistence(Double resistence) {
        this.resistence = resistence;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.weight);
        hash = 23 * hash + Objects.hashCode(this.materialClass);
        hash = 23 * hash + Objects.hashCode(this.resistence);
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
        final PrimeMaterial other = (PrimeMaterial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        if (!Objects.equals(this.materialClass, other.materialClass)) {
            return false;
        }
        return Objects.equals(this.resistence, other.resistence);
    }

    @Override
    public String toString() {
        return name;
    }

}
