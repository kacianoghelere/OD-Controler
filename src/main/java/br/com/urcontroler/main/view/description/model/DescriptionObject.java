package br.com.urcontroler.main.view.description.model;

import br.com.gmp.utils.annotations.ColumnName;
import br.com.gmp.utils.annotations.Editable;
import br.com.urcontroler.data.entity.MenuItem;

/**
 * Objeto de carregamento de descrições
 *
 * @author Kaciano Ghelere
 */
public class DescriptionObject {

    @ColumnName(name = "Tela")
    private MenuItem item;
    @Editable
    @ColumnName(name = "Salvar")
    private String commit;
    @Editable
    @ColumnName(name = "Processar")
    private String procces;
    @Editable
    @ColumnName(name = "Limpar")
    private String clear;
    @Editable
    @ColumnName(name = "Carregar")
    private String load;
    @Editable
    @ColumnName(name = "Descrição")
    private String description;

    /**
     * Cria nova instancia de DescriptionObject
     */
    public DescriptionObject() {
    }

    /**
     * Cria nova instancia de DescriptionObject
     *
     * @param item {@code MenuItem} Item de menu
     */
    public DescriptionObject(MenuItem item) {
        this.item = item;
        if (item.getDescription() == null) {
            item.setDescription(new br.com.urcontroler.main.util.DescriptionObject.Builder().apply());
        }
        this.commit = item.getDescription().getCommit();
        this.procces = item.getDescription().getProccess();
        this.clear = item.getDescription().getClear();
        this.load = item.getDescription().getLoad();
        this.description = item.getDescription().getDescription();
    }

    /**
     * Cria nova instancia de DescriptionObject
     *
     * @param item {@code MenuItem} Item de menu
     * @param description {@code Description} Objeto da descrição
     */
    public DescriptionObject(MenuItem item, br.com.urcontroler.main.util.DescriptionObject description) {
        this.item = item;
        this.commit = description.getCommit();
        this.procces = description.getProccess();
        this.clear = description.getClear();
        this.load = description.getLoad();
        this.description = description.getDescription();
    }

    /**
     * Cria nova instancia de DescriptionObject
     *
     * @param item {@code MenuItem} Item de menu
     * @param commit {@code String} Texto da função de salvar
     * @param procces {@code String} Texto da função de processar
     * @param clear {@code String} Texto da função de limpar
     * @param load {@code String} Texto da função de carregar
     * @param description {@code String} Texto da descrição
     */
    public DescriptionObject(MenuItem item, String commit,
            String procces, String clear, String load, String description) {
        this.item = item;
        this.commit = commit;
        this.procces = procces;
        this.clear = clear;
        this.load = load;
        this.description = description;
    }

    /**
     * Retorna o objeto da descrição reconstruido
     *
     * @return {@code Description} Descrição
     */
    public br.com.urcontroler.main.util.DescriptionObject build() {
        return new br.com.urcontroler.main.util.DescriptionObject.Builder(item.getTitle(),
                description, commit, procces, clear, load).apply();
    }

    /**
     * Retorna o Item de menu
     *
     * @return {@code MenuItem} Item de menu
     */
    public MenuItem getItem() {
        return item;
    }

    /**
     * Modifica o Item de menu
     *
     * @param item {@code MenuItem} Item de menu
     */
    public void setItem(MenuItem item) {
        this.item = item;
    }

    /**
     * Retorna o Texto da função de salvar
     *
     * @return {@code String} Texto da função de salvar
     */
    public String getCommit() {
        return commit;
    }

    /**
     * Modifica o Texto da função de salvar
     *
     * @param save {@code String} Texto da função de salvar
     */
    public void setSave(String save) {
        this.commit = save;
    }

    /**
     * Retorna o Texto da função de processar
     *
     * @return {@code String} Texto da função de processar
     */
    public String getProcces() {
        return procces;
    }

    /**
     * Modifica o Texto da função de processar
     *
     * @param procces {@code String} Texto da função de processar
     */
    public void setProcces(String procces) {
        this.procces = procces;
    }

    /**
     * Retorna o Texto da função de limpar
     *
     * @return {@code String} Texto da função de limpar
     */
    public String getClear() {
        return clear;
    }

    /**
     * Modifica o Texto da função de limpar
     *
     * @param clear {@code String} Texto da função de limpar
     *
     */
    public void setClear(String clear) {
        this.clear = clear;
    }

    /**
     * Retorna o Texto da função de carregar
     *
     * @return {@code String} Texto da função de carregar
     */
    public String getLoad() {
        return load;
    }

    /**
     * Modifica o Texto da função de carregar
     *
     * @param load {@code String} Texto da função de carregar
     */
    public void setLoad(String load) {
        this.load = load;
    }

    /**
     * Retorna o Texto da descrição
     *
     * @return {@code String} Texto da descrição
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica o Texto da descrição
     *
     * @param description {@code String} Texto da descrição
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
