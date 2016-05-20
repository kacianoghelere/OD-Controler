package br.com.urcontroler.data.enums;

/**
 * Modo de uso das armas
 *
 * @author kaciano
 * @version 1.0
 * @author kaciano
 * @version 1.1
 */
public enum UseType {

    /**
     * Tipo de uso para uma mão
     */
    ONE_HANDED("Uma mão"),
    /**
     * Tipo de uso para duas mãos
     */
    TWO_HANDED("Duas mãos"),
    /**
     * Tipo de uso para ambos os modos
     */
    ANY("Qualquer");

    private String name;

    /**
     * Cria nova instancia de WearType
     *
     * @param typeName {@code String} Titulo do tipo
     */
    private UseType(String typeName) {
        this.name = typeName;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna o Titulo do tipo
     *
     * @return {@code String} Titulo do tipo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o Titulo do tipo
     *
     * @param name {@code String} Titulo do tipo
     */
    public void setName(String name) {
        this.name = name;
    }

}
