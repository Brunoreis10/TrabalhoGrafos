/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Bruno Henrique Wiedemann Reis
 * Lucas Miguel Vieira
 *
 * Dirigido = não espelhado Não Dirigido = espelhado
 *
 * Simples = grafo que não contem laço ( valor na diagonal principal ) e nem
 * aresta paralela ( x > 1 em alguma casa) multigrafo = tem laço ou uma aresta
 * paralela
 *
 * regular = todos os vertices possuem o mesmo grau(soma da linha) completo =
 * precisa ser simples, e todos se ligam ( tudo 1 exceto a diagonal principal)
 * nulo = grafo sem arestas
 *
 */
public class Grafo {

    public Grafo() {

    }

    public String tipoDoGrafo(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(tipoGrafoDirigido(matrix));
        stringBuilder.append(tipoGrafoSimples(matrix));
        stringBuilder.append(tipoGrafoRegular(matrix));
        stringBuilder.append(tipoGrafoCompleto(matrix));
        stringBuilder.append(tipoGrafoNulo(matrix));
        return stringBuilder.toString();
    }

    private String tipoGrafoDirigido(int[][] matrix) {

        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                int value = matrix[x][y];
                int inverso = matrix[y][x];
                if (value != inverso) {
                    return "Dirigido,";
                }
            }
        }
        return "Não Dirigido,";
    }

    private String tipoGrafoCompleto(int[][] matrix) {
        if ("Simples,".equalsIgnoreCase(tipoGrafoSimples(matrix))) {

            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix.length; y++) {
                    if (y != x) {
                        int value = matrix[x][y];
                        if (value == 0) {
                            return "";
                        }
                    }
                }
            }

            return "Completo,";
        } else {
            return "";
        }
    }

    private String tipoGrafoRegular(int[][] matrix) {

        int grauA = 0;

        for (int i = 0; i < matrix.length; i++) {
            int grauB = 0;
            for (int j = 0; j < matrix.length; j++) {
                grauB += matrix[i][j];
            }
            if (i == 0) {
                grauA = grauB;
            } else if (grauA != grauB) {
                return "";
            }

        }
        return "Regular,";
    }

    private String tipoGrafoSimples(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                int value = matrix[x][y];
                //diagonal princpal (Loop) 
                if (x == y) {
                    if (value != 0) {
                        return "Multigrafo,";
                    }
                }

                //verificar aresta paralela
                if (value > 1) {
                    return "Multigrafo,";
                }

            }
        }
        return "Simples,";
    }

    private String tipoGrafoNulo(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                int value = matrix[x][y];
                if (value != 0) {
                    return "";
                }
            }
        }
        return "Nulo,";
    }

    public String arestasDoGrafo(int[][] matrix) {
        int aresta = 0;

        int[][] matrixCopia = Arrays.stream(matrix).map(r -> r.clone()).toArray(int[][]::new);

        StringBuilder builder = new StringBuilder();
        builder.append("E={");

        for (int x = 0; x < matrixCopia.length; x++) {
            for (int y = 0; y < matrixCopia.length; y++) {
                int value = matrixCopia[x][y];

                if (value != 0) {
                    aresta += matrixCopia[x][y];
                    while (value != 0) {
                        builder.append("(V").append(x + 1).append(",").append("V").append(y + 1).append("),");
                        if (matrixCopia[y][x] != 0) {
                            matrixCopia[y][x] -= 1;
                        }
                        value--;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Número de Arestas: ").append(aresta).append(System.lineSeparator());
        stringBuilder.append(builder.toString().substring(0, builder.length() - 1)).append("}");
        return stringBuilder.toString();
    }

    public String grausDoVertice(int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> graus = new ArrayList<>();

        for (int x = 0; x < matrix.length; x++) {
            int grau = 0;
            for (int y = 0; y < matrix.length; y++) {
                grau += matrix[x][y];
            }
            graus.add(grau);
            builder.append("V").append(x + 1).append(" tem Grau: ").append(grau).append(";").append(System.lineSeparator());
        }

        Collections.sort(graus);
        builder.append("Sequência de Graus: ");

        builder.append(graus);

        return builder.toString().replace("[", "(").replace("]", ")");
    }
}
