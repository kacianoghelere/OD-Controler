package br.com.odcontroler.main.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Utilitário para listar habilidades por circulo de magia
 *
 * @author kaciano
 */
public class CircleUtil {

    /**
     * Lista todos os circulos do tamanho desejado na quantidade de niveis
     * recebida
     *
     * @param levels {@code int} Quantidade de niveis
     * @param size {@code int} Tamanho do circulo
     * @return {@code List(int[])} Lista de circulos preenchida
     */
    public static List<int[]> listCircles(int levels, int size) {
        int count = 0;
        int index = 0;
        List<int[]> circles = new ArrayList<>();
        int[] circle = new int[size];
        int oldIndex = 0;
        int newIndex = 0;
        do {
            oldIndex = (index - 1);
            newIndex = (index + 1);
            if (index < size) {
                //--------------------------------------------------------------
                // Se o circulo anterior não for negativo
                if (oldIndex != -1) {
                    circle[index]++;
                    //----------------------------------------------------------
                    // Se o circulo anterior for igual ao atual
                    if (circle[oldIndex] <= circle[index]) {
                        index++;
                    }
                } //--------------------------------------------------------------
                // Se o circulo anterior for negativo
                else {
                    //----------------------------------------------------------
                    // Se o circulo atual for menor do que o próximo
                    if (circle[index] <= circle[newIndex]) {
                        circle[index]++;
                    } else // Se o circulo atual for maior do que o próximo
                    if (circle[index] > circle[newIndex]) {
                        circle[index]++;
                        index++;
                    }
                }
            }
            count++;
            circles.add(Arrays.copyOf(circle, size));
        } while (levels > count);
        return circles;
    }

    /**
     * Lista todos os circulos do tamanho desejado na quantidade de niveis
     * recebida
     *
     * @param levels {@code int} Quantidade de niveis
     * @param size {@code int} Tamanho do circulo
     * @return {@code List(int[])} Lista de circulos preenchida
     */
    public static List<String[]> list(int levels, int size) {
        List<String[]> circles = new ArrayList<>();
        int count = 0;
        do {
            circles.add(generateMatrix(count, size));
            count += 2;
        } while (count < size);
        return circles;
    }

    private static String[] generateMatrix(int index, int size) {
        int begin = 1;
        String temp = "";
        do {
            for (int j = index; j < begin + index; j++) {
                if (temp.replaceAll(",", "").length() < (size - index)) {
                    temp += begin + ",";
                } else {
                    break;
                }
            }
            begin++;
        } while (temp.replaceAll(",", "").length() < (size - index));
        String zeros = "";
        if ((temp.length() - 1) > 0) {
            temp = temp.substring(0, temp.length() - 1);
            zeros = addZeros(size - temp.replaceAll(",", "").length()) + temp;
        }
        return zeros.split(",");
    }

    private static String addZeros(int amount) {
        String zeros = "";
        for (int i = 0; i < amount; i++) {
            zeros += "0,";
        }
        return zeros;
    }

    public static void main(String[] args) {
        List<String[]> list = new CircleUtil().list(9, 30);
        for (String[] is : list) {
            System.out.println(Arrays.toString(is));
        }
    }
}
