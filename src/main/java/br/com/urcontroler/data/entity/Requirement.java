package br.com.urcontroler.data.entity;

/**
 * Classe para os requerimentos mínimos
 *
 * @author ka
 */
public class Requirement {

    private int STR;
    private int DES;
    private int CON;
    private int INT;
    private int WIS;
    private int CHA;

    /**
     * Cria nova instancia de Requires
     */
    public Requirement() {
    }

    /**
     * Cria nova instancia de Requires
     *
     * @param STR {@code int} Requerimento minimo para força
     * @param DES {@code int} Requerimento minimo para destreza
     * @param CON {@code int} Requerimento minimo para constituição
     * @param INT {@code int} Requerimento minimo para inteligencia
     * @param WIS {@code int} Requerimento minimo para sabedoria
     * @param CHA {@code int} Requerimento minimo para carisma
     */
    public Requirement(int STR, int DES, int CON, int INT, int WIS, int CHA) {
        this.STR = STR;
        this.DES = DES;
        this.CON = CON;
        this.INT = INT;
        this.WIS = WIS;
        this.CHA = CHA;
    }

    /**
     * Retorna requerimento minimo para força
     *
     * @return {@code int} Requerimento minimo para força
     */
    public int getSTR() {
        return STR;
    }

    /**
     * Modifica requerimento minimo para força
     *
     * @param STR {@code int} Requerimento minimo para força
     */
    public void setSTR(int STR) {
        this.STR = STR;
    }

    /**
     * Retorna requerimento minimo para destreza
     *
     * @return {@code int} Requerimento minimo para destreza
     */
    public int getDES() {
        return DES;
    }

    /**
     * Modifica requerimento minimo para destreza
     *
     * @param DES {@code int} Requerimento minimo para destreza
     */
    public void setDES(int DES) {
        this.DES = DES;
    }

    /**
     * Retorna requerimento minimo para constituição
     *
     * @return {@code int} Requerimento minimo para constituição
     */
    public int getCON() {
        return CON;
    }

    /**
     * Modifica
     *
     * @param CON {@code int} Requerimento minimo para constituição
     */
    public void setCON(int CON) {
        this.CON = CON;
    }

    /**
     * Retorna requerimento minimo para inteligencia
     *
     * @return {@code int} Requerimento minimo para inteligencia
     */
    public int getINT() {
        return INT;
    }

    /**
     * Modifica requerimento minimo para inteligencia
     *
     * @param INT {@code int} Requerimento minimo para inteligencia
     */
    public void setINT(int INT) {
        this.INT = INT;
    }

    /**
     * Retorna requerimento minimo para sabedoria
     *
     * @return {@code int} Requerimento minimo para sabedoria
     */
    public int getWIS() {
        return WIS;
    }

    /**
     * Modifica requerimento minimo para sabedoria
     *
     * @param WIS {@code int} Requerimento minimo para sabedoria
     */
    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    /**
     * Retorna requerimento minimo para carisma
     *
     * @return {@code int} Requerimento minimo para carisma
     */
    public int getCHA() {
        return CHA;
    }

    /**
     * Modifica requerimento minimo para carisma
     *
     * @param CHA {@code int} Requerimento minimo para carisma
     */
    public void setCHA(int CHA) {
        this.CHA = CHA;
    }

}
