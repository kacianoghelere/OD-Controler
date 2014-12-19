package br.com.urcontroler.data.entity;

import br.com.urcontroler.main.view.bind.BindObject;

/**
 * Classe para os modificadores de atributos
 *
 * @author kaciano
 */
public class Modifier extends BindObject {

    private int STR;
    private int DES;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

    /**
     * Cria nova instancia de Modifier
     */
    public Modifier() {
    }

    /**
     * Cria nova instancia de Modifier
     *
     * @param STR {@code int} Modificador para força
     * @param DES {@code int} Modificador para destreza
     * @param CON {@code int} Modificador para constituição
     * @param INT {@code int} Modificador para inteligencia
     * @param WIS {@code int} Modificador para sabedoria
     * @param CHA {@code int} Modificador para carisma
     */
    public Modifier(int STR, int DES, int CON, int INT, int WIS, int CHA) {
        this.STR = STR;
        this.DES = DES;
        this.CON = CON;
        this.INT = INT;
        this.WIS = WIS;
        this.CHA = CHA;
    }

    /**
     * Retorna o modificador para força
     *
     * @return {@code int} Modificador para força
     */
    public int getSTR() {
        return STR;
    }

    /**
     * Modifica o modificador para força
     *
     * @param STR {@code int} Modificador para força
     */
    public void setSTR(int STR) {
        this.STR = STR;
    }

    /**
     * Retorna o modificador para destreza
     *
     * @return {@code int} Modificador para destreza
     */
    public int getDES() {
        return DES;
    }

    /**
     * Modifica o modificador para destreza
     *
     * @param DES {@code int} Modificador para destreza
     */
    public void setDES(int DES) {
        this.DES = DES;
    }

    /**
     * Retorna o modificador para constituição
     *
     * @return {@code int} Modificador para constituição
     */
    public int getCON() {
        return CON;
    }

    /**
     * Modifica o modificador para constituição
     *
     * @param CON {@code int} Modificador para constituição
     */
    public void setCON(int CON) {
        this.CON = CON;
    }

    /**
     * Retorna o modificador para inteligencia
     *
     * @return {@code int} Modificador para inteligencia
     */
    public int getINT() {
        return INT;
    }

    /**
     * Modifica o modificador para inteligencia
     *
     * @param INT {@code int} Modificador para inteligencia
     */
    public void setINT(int INT) {
        this.INT = INT;
    }

    /**
     * Retorna o modificador para sabedoria
     *
     * @return {@code int} Modificador para sabedoria
     */
    public int getWIS() {
        return WIS;
    }

    /**
     * Modifica o modificador para sabedoria
     *
     * @param WIS {@code int} Modificador para sabedoria
     */
    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    /**
     * Retorna o modificador para carisma
     *
     * @return {@code int} Modificador para carisma
     */
    public int getCHA() {
        return CHA;
    }

    /**
     * Modifica o modificador para carisma
     *
     * @param CHA {@code int} Modificador para carisma
     */
    public void setCHA(int CHA) {
        this.CHA = CHA;
    }

}
