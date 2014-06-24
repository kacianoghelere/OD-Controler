package br.com.rpgruler.main.util;

import java.util.Random;

/**
 * Utilitário para gerar resultados de dados
 *
 * @author kaciano
 */
public class DiceTool {

    /**
     * Simula o resultado do dado do tamanho indicado
     *
     * @param size <code>int</code> Tamanho do dados
     * @return <code>Integer</code> Resultado dados
     */
    public static Integer throwDice(int size) {
        return (new Random().nextInt(size) + 1);
    }

}
