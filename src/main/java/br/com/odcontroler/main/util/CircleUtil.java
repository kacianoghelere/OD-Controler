package br.com.odcontroler.main.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Utilitário para listar habilidades por circulo de magia (Utilizando MCRL)
 *
 * @author kaciano
 * @version 1.0
 */
public class CircleUtil {

    /**
     * Retorna o array bidimensonal dos circulos
     *
     * @param levels {@code int} Quantidade de niveis
     * @param amount {@code int} Quantidade de circulos
     * @return {@code Integer[][]} Matriz de circulos
     */
    public Integer[][] getMatrix(int levels, int amount) {
        return build(levels, amount);
    }

    /**
     * Retorna uma lista com os arrays dos circulos
     *
     * @param levels {@code int} Quantidade de niveis
     * @param amount {@code int} Quantidade de circulos
     * @return {@code List(Integer[])} Lista de circulos
     */
    public List<Integer[]> getList(int levels, int amount) {
        return Arrays.asList(build(levels, amount));
    }

    /**
     * Retorna o circulo conforme o nível recebido
     *
     * @param level {@code int} Nivel do circulo
     * @param levels {@code int} Quantidade de niveis
     * @param amount {@code int} Quantidade de circulos
     * @return {@code Integer[]} Circulo do nível
     */
    public Integer[] getCircle(int level, int levels, int amount) {
        Integer[][] matrix = getMatrix(levels, amount);
        return matrix[level];
    }

    /**
     * Retorna o circulo conforme o nível recebido
     *
     * @param level {@code int} Nivel do circulo
     * @param matrix {@code Integer[][]} Matriz de circulos
     * @return {@code Integer[]} Circulo do nível
     */
    public Integer[] getCircle(int level, Integer[][] matrix) {
        return matrix[level];
    }

    /**
     * Retorna o circulo conforme o nível recebido
     *
     * @param level {@code int} Nivel do circulo
     * @param list {@code Integer[][]} Lista de circulos
     * @return {@code List(Integer[])} Lista de circulos
     */
    public Integer[] getCircle(int level, List<Integer[]> list) {
        return list.get(level);
    }

    /**
     * Constroi a matriz de circulos a partir da quantidade de niveis e circulos
     *
     * @param levels {@code int} Quantidade de niveis
     * @param circles {@code int} Quantidade de circulos
     * @return {@code Integer[][]} Matriz de circulos
     */
    private Integer[][] build(int levels, int circles) {
        int begin = 0;
        int value = 1;
        List<Integer[]> list = new ArrayList();
        List<Integer> level = null;
        //----------------------------------------------------------------------
        // Laço dos niveis dentro do circulo, continua enquanto o tamanho da
        // lista for inferior ao numero de circulos
        do {
            level = new ArrayList();
            //------------------------------------------------------------------
            // Laço para preencher os valores dentro dos niveis
            do {
                //--------------------------------------------------------------
                // Adiciona o valor dentro da lista conforme o tamanho dele
                // Ex: 1 add 1 vez, 2 add 2 vezes, 3 add 3 vezes...
                for (int i = 0; i < value; i++) {
                    //----------------------------------------------------------
                    // Verifica se o tamanho do circulo não foi comprometido,
                    // caso esteja ok adiciona o valor, se não, para o loop
                    if (level.size() < (levels - begin)) {
                        level.add(value);
                    } else {
                        break;
                    }
                }
                //--------------------------------------------------------------
                // Incrementa o valor para prosseguir
                value++;
            } while (level.size() < (levels - begin));
            //------------------------------------------------------------------
            // Verifica a diferença entre o tamanho da lista e o tamanho
            // desejado, completa com zeros caso seja necessário
            while (level.size() < levels) {
                level.add(0, 0);
            }
            //------------------------------------------------------------------
            // Reset no valor para evitar o loop infinito
            value = 1;
            //------------------------------------------------------------------
            // Aumenta as casas do inicio, para manter o nivelamento
            begin += 2;
            //------------------------------------------------------------------
            // Converte e atribui a lista à lista de circulos
            list.add(level.toArray(new Integer[]{}));
        } while (list.size() < circles);
        //----------------------------------------------------------------------
        // Retorna a matriz transposta
        return transpose(list.toArray(new Integer[][]{}));
    }

    /**
     * Transpoe a matriz (Transforma linhas em colunas e vice versa)
     *
     * @param matrix {@code Object[][]} Matriz a ser transposta
     * @return {@code Object[][]} Matriz transposta
     */
    public static Object[][] transpose(Object[][] matrix) {
        Object[][] transposed = new Object[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    /**
     * Transpoe a matriz (Transforma linhas em colunas e vice versa)
     *
     * @param matrix {@code Integer[][]} Matriz a ser transposta
     * @return {@code Integer[][]} Matriz transposta
     */
    private Integer[][] transpose(Integer[][] matrix) {
        Integer[][] transposed = new Integer[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

}
