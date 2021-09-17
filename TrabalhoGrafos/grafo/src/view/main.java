/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Grafo;

/**
 *
 * @author Bruno Henrique Wiedemann Reis 
 * Lucas Miguel Vieira
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] values = {
            {0, 1, 0, 0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 1, 0, 0}

        };

        Grafo grafo = new Grafo();
        String retornoGrafos = grafo.tipoDoGrafo(values);
        System.out.println("Tipo Grafo:" + retornoGrafos.substring(0, retornoGrafos.length() - 1));
        System.out.println("==============================");
        System.out.println("Arestas do Grafo:" + System.lineSeparator() + grafo.arestasDoGrafo(values));
        System.out.println("==============================");
        System.out.println("Grau de cada Vértice do Grafo:" + System.lineSeparator() + grafo.grausDoVertice(values));

    }
}
