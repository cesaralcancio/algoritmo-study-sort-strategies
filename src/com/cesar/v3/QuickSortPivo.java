package com.cesar.v3;

import java.util.*;
import java.util.jar.*;

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
        int encontrado = buscaBinaria(notas, 0, notas.length, 6.7);
        int encontradoLinear = buscaLinear(notas, 0, notas.length, 6.7);
        System.out.println(encontrado);
        System.out.println(encontradoLinear);
        System.out.println(Arrays.asList(notas));
    }

    private static int buscaBinaria(Nota[] notas, int de, int ate, double busca) {
        int meio = (de + ate) / 2;
        System.out.println("Buscando " + busca + " de " + de  + " ate " + ate + " e o meio é " + meio);
        Nota notaDoMeio = notas[meio];

        if (notaDoMeio.getValor() == busca) {
            return meio;
        } else if (de != 0 || ate != 0) {
            if (busca < notaDoMeio.getValor()) {
                return buscaBinaria(notas, de, meio - 1, busca);
            } else {
                return buscaBinaria(notas, meio + 1, ate, busca);
            }
        }

        return -1;
    }

    private static int buscaLinear(Nota[] notas, int de, int ate, double busca) {
        for(int atual = de; atual < ate; atual++) {
            System.out.println("Buscando " + busca + "em posicao " + atual);
            if(notas[atual].getValor() == busca) {
                return atual;
            }
        }

        return -1;
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
