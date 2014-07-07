package br.com.odcontroler.datatables.cargo;

import br.com.odcontroler.data.entity.AttrRange;
import br.com.odcontroler.datatables.AttrData;
import java.util.Objects;

/**
 * Objeto de carregamento para tabela de carga
 *
 * @author kaciano
 * @version 1.0
 */
public class CargoData implements AttrData {

    private AttrRange range;
    private int noCargo;
    private int lowCargo;
    private int heavyCargo;

    /**
     * Cria nova instancia de CargoData
     */
    public CargoData() {
    }

    /**
     * Cria nova instancia de CargoData
     *
     * @param range {@code AttrRange} Faixa do atributo força
     * @param noCargo {@code int} Sem carga até...
     * @param lowCargo {@code int} Carga leve até...(-1 metro)
     * @param heavyCargo {@code int} Carga pesada até...(-2 metros)
     */
    public CargoData(AttrRange range, int noCargo, int lowCargo, int heavyCargo) {
        this.range = range;
        this.noCargo = noCargo;
        this.lowCargo = lowCargo;
        this.heavyCargo = heavyCargo;
    }

    /**
     * Cria nova instancia de CargoData
     *
     * @param range {@code String} Faixa do atributo força
     * @param noCargo {@code int} Sem carga até...
     * @param lowCargo {@code int} Carga leve até...(-1 metro)
     * @param heavyCargo {@code int} Carga pesada até...(-2 metros)
     */
    public CargoData(String range, int noCargo, int lowCargo, int heavyCargo) {
        this.range = new AttrRange(range);
        this.noCargo = noCargo;
        this.lowCargo = lowCargo;
        this.heavyCargo = heavyCargo;
    }

    /**
     * Cria nova instancia de CargoData
     *
     * @param init {@code int} Inicio da Faixa do atributo força
     * @param end {@code int} Fim da Faixa do atributo força
     * @param noCargo {@code int} Sem carga até...
     * @param lowCargo {@code int} Carga leve até...(-1 metro)
     * @param heavyCargo {@code int} Carga pesada até...(-2 metros)
     */
    public CargoData(int init, int end, int noCargo, int lowCargo, int heavyCargo) {
        this.range = new AttrRange(init, end);
        this.noCargo = noCargo;
        this.lowCargo = lowCargo;
        this.heavyCargo = heavyCargo;
    }

    @Override
    public String toString() {
        return "CargoData{" + range.toString() + ", "
                + "noCargo=" + noCargo + ", "
                + "lowCargo=" + lowCargo + ", "
                + "heavyCargo=" + heavyCargo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.range);
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
        final CargoData other = (CargoData) obj;
        return Objects.equals(this.range, other.range);
    }

    /**
     * Retorna a Faixa do atributo força
     *
     * @return {@code AttrRange} Faixa do atributo força
     */
    @Override
    public AttrRange getRange() {
        return range;
    }

    /**
     * Modifica a Faixa do atributo força
     *
     * @param range {@code AttrRange} Faixa do atributo força
     */
    public void setRange(AttrRange range) {
        this.range = range;
    }

    /**
     * Retorna Sem carga
     *
     * @return {@code int} Sem carga
     */
    public int getNoCargo() {
        return noCargo;
    }

    /**
     * Modifica Sem carga
     *
     * @param noCargo {@code int} Sem carga
     */
    public void setNoCargo(int noCargo) {
        this.noCargo = noCargo;
    }

    /**
     * Retorna Carga leve
     *
     * @return {@code int} Carga leve
     */
    public int getLowCargo() {
        return lowCargo;
    }

    /**
     * Modifica Carga leve
     *
     * @param lowCargo {@code int} Carga leve
     */
    public void setLowCargo(int lowCargo) {
        this.lowCargo = lowCargo;
    }

    /**
     * Retorna Carga pesada
     *
     * @return {@code int} Carga pesada
     */
    public int getHeavyCargo() {
        return heavyCargo;
    }

    /**
     * Modifica Carga pesada
     *
     * @param heavyCargo {@code int} Carga pesada
     */
    public void setHeavyCargo(int heavyCargo) {
        this.heavyCargo = heavyCargo;
    }
}
