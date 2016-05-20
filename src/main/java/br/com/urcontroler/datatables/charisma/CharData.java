package br.com.urcontroler.datatables.charisma;

import br.com.urcontroler.data.entity.AttrRange;
import br.com.urcontroler.datatables.AttrData;
import java.util.Objects;

/**
 * Objeto de dados para preenchimento da tabela de modificadores de carisma
 *
 * @author kaciano
 * @version 1.0
 */
public class CharData implements AttrData {

    private AttrRange range;
    private int followers;
    private int reaction;
    private String repellUndead;

    /**
     * Cria nova instancia de CarData
     */
    public CharData() {
    }

    /**
     * Cria nova instancia de CarData
     *
     * @param range {@code AttrRange} Faixa do atributo
     * @param followers {@code int} Número máximo de seguidores
     * @param reaction {@code int} Ajuste de reação
     * @param repellUndead {@code String} Mortos-vivos afastados
     */
    public CharData(AttrRange range, int followers, int reaction, String repellUndead) {
        this.range = range;
        this.followers = followers;
        this.reaction = reaction;
        this.repellUndead = repellUndead;
    }

    /**
     * Cria nova instancia de CarData
     *
     * @param range {@code String} Faixa do atributo
     * @param followers {@code int} Número máximo de seguidores
     * @param reaction {@code int} Ajuste de reação
     * @param repellUndead {@code String} Mortos-vivos afastados
     */
    public CharData(String range, int followers, int reaction, String repellUndead) {
        this.range = new AttrRange(range);
        this.followers = followers;
        this.reaction = reaction;
        this.repellUndead = repellUndead;
    }

    /**
     * Cria nova instancia de CarData
     *
     * @param init {@code int} Inicio da faixa do atributo
     * @param end {@code int} Fim da faixa do atributo
     * @param followers {@code int} Número máximo de seguidores
     * @param reaction {@code int} Ajuste de reação
     * @param repellUndead {@code String} Mortos-vivos afastados
     */
    public CharData(int init, int end, int followers, int reaction, String repellUndead) {
        this.range = new AttrRange(init, end);
        this.followers = followers;
        this.reaction = reaction;
        this.repellUndead = repellUndead;
    }

    @Override
    public String toString() {
        return "CarData{" + range.toString() + ", "
                + "followers=" + followers + ", "
                + "reaction=" + reaction + ", "
                + "repellUndead=" + repellUndead + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.range);
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
        final CharData other = (CharData) obj;
        return Objects.equals(this.range, other.range);
    }

    /**
     * Retorna a faixa do atributo
     *
     * @return {@code AttrRange} Faixa do atributo
     */
    @Override
    public AttrRange getRange() {
        return range;
    }

    /**
     * Modifica a faixa do atributo
     *
     * @param range {@code AttrRange} Faixa do atributo
     */
    public void setRange(AttrRange range) {
        this.range = range;
    }

    /**
     * Retorna o número máximo de seguidores
     *
     * @return {@code int} Número máximo de seguidores
     */
    public int getFollowers() {
        return followers;
    }

    /**
     * Modifica o número máximo de seguidores
     *
     * @param followers {@code int} Número máximo de seguidores
     */
    public void setFollowers(int followers) {
        this.followers = followers;
    }

    /**
     * Retorna o ajuste de reação
     *
     * @return {@code int} Ajuste de reação
     */
    public int getReaction() {
        return reaction;
    }

    /**
     * Modifica o ajuste de reação
     *
     * @param reaction {@code int} Ajuste de reação
     */
    public void setReaction(int reaction) {
        this.reaction = reaction;
    }

    /**
     * Retorna Mortos-vivos afastados
     *
     * @return {@code String} Mortos-vivos afastados
     */
    public String getRepellUndead() {
        return repellUndead;
    }

    /**
     * Modifica Mortos-vivos afastados
     *
     * @param repellUndead {@code String} Mortos-vivos afastados
     */
    public void setRepellUndead(String repellUndead) {
        this.repellUndead = repellUndead;
    }

}
