package br.com.odcontroler.data.constants;

/**
 * Enum para resgistro dos tamanhos de armas
 *
 * @author kaciano
 * @version 1.0
 */
public enum WeaponSize {

    /**
     * Arma de pequeno porte
     */
    SMALL("Pequena"),
    /**
     * Arma de médio porte
     */
    MEDIUM("Média"),
    /**
     * Arma de grande porte
     */
    BIG("Grande"),
    /**
     * Arma gigante
     */
    GIANT("Gigante");

    private final String size;

    /**
     * Cria nova instancia de WeaponSize
     *
     * @param size <code>String</code> Tamanho
     */
    private WeaponSize(String size) {
        this.size = size;
    }

}
