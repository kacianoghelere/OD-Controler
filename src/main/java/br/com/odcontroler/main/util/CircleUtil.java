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
    public static List<int[]> list(int levels, int size) {
        List<int[]> circles = new ArrayList<>();
        int[] circle = new int[size];
        for (int count = 0; count < levels; count++) {
            for (int i = 0; i < circle.length; i++) {
                if (i == 0 || circle[i] != 0) {
                    circle[i]++;
                }
            }
            circles.add(Arrays.copyOf(circle, size));
        }
        return circles;
    }

    public static void main(String[] args) {
        List<int[]> list = new CircleUtil().list(20, 9);
        for (int[] is : list) {
            System.out.println(Arrays.toString(is));
        }
    }
}
