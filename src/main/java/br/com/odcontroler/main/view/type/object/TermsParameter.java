package br.com.odcontroler.main.view.type.object;

/**
 * Parametros para registro de termos
 *
 * @author kaciano
 */
public class TermsParameter {

    private Class<?> objClass;
    private String name;

    /**
     * Cria nova instancia de TermsParameter
     *
     * @param objClass {@code Class(?)} Classe do termo
     * @param name {@code String} Nome do termo
     */
    public TermsParameter(Class<?> objClass, String name) {
        this.objClass = objClass;
        this.name = name;
    }

    /**
     * Retorna a classe do objeto
     *
     * @return {@code Class(?)} Classe do termo
     */
    public Class<?> getObjClass() {
        return objClass;
    }

    /**
     * Modifica a classe do objeto
     *
     * @param objClass {@code Class(?)} Classe do termo
     */
    public void setObjClass(Class<?> objClass) {
        this.objClass = objClass;
    }

    /**
     * Retorna o nome do termo
     *
     * @return {@code String} Nome do termo
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica o nome do termo
     *
     * @param name {@code String} Nome do termo
     */
    public void setName(String name) {
        this.name = name;
    }

}
