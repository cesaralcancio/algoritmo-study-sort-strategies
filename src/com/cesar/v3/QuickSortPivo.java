package com.cesar.v3;

import java.util.*;

public class QuickSortPivo {

    public static void main(String[] args) {
        Nota[] notas = {
                new Nota("andre", 4),
                new Nota("carlos", 8.5),
                new Nota("ana", 10),
                new Nota("jonas", 3),
                new Nota("juliana", 6.7),
                new Nota("paulo", 9),
                new Nota("mariana", 5),
                new Nota("lucia", 9.3),
                new Nota("guilherme", 7),
        };

        ordena(notas, 0, notas.length);
        System.out.println(Arrays.asList(notas));
    }

    private static void ordena(Nota[] notas, int de, int ate) {
        int elementos = ate - de;
        if (elementos > 1) {
            int pivo = particiona(notas, de, ate);
            ordena(notas, de, pivo);
            ordena(notas, pivo + 1, ate);
        }
    }

    private static int particiona(Nota[] notas, int inicio, int termino) {
        int quantosMenores = 0;
        int indexPivo = termino - 1;
        Nota pivo = notas[indexPivo];

        for(int analisando = inicio; analisando < indexPivo; analisando++) {
            Nota atual = notas[analisando];
            if (atual.getValor() <= pivo.getValor()) {
                troca(notas, analisando, quantosMenores);
                quantosMenores++;
            }
        }

        troca(notas, indexPivo, quantosMenores);
        return indexPivo;
    }

    private static void troca(Nota[] notas, int de, int para) {
        Nota nota1 = notas[de];
        Nota nota2 = notas[para];
        notas[de] = nota2;
        notas[para] = nota1;
    }

}
