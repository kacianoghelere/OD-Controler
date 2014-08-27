package br.com.urcontroler.data.enums;

/**
 * Enumerador de Alinhamentos/Tendencias
 *
 * @author kaciano
 */
public enum Alignment {

    /**
     * Alinhamento de ordem
     */
    LAWFULL(1L, "Ordeiro"),
    /**
     * Alinhamento de neutralidade
     */
    NEUTRAL(2L, "Neutro"),
    /**
     * Alinhamento do caos
     */
    CHAOTIC(3L, "Caótico");

    private Long id;
    private String name;

    /**
     * Cria nova instancia de Align
     *
     * @param id {@code Long} ID do alinhamento
     * @param name {@code String} Nome do alinhamento
     */
    private Alignment(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Retorna ID do alinhamento
     *
     * @return {@code Long} ID do alinhamento
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica ID do alinhamento
     *
     * @param id {@code Long} ID do alinhamento
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna Nome do alinhamento
     *
     * @return {@code String} Nome do alinhamento
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica Nome do alinhamento
     *
     * @param name {@code String} Nome do alinhamento
     */
    public void setName(String name) {
        this.name = name;
    }

}
