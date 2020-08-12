package com.cesar.v2;

import java.util.*;

public class MergeSortMain {

    public static void main(String[] args) {
        //Testando ordenar so uma parte do array
        Aluno[] alunosOutro = {
                new Aluno("andre", 4),
                new Aluno("carlos", 8.5),
                new Aluno("ana", 10),
                new Aluno("jonas", 3),
                new Aluno("juliana", 6.7),
                new Aluno("guilherme", 7),
                new Aluno("paulo", 9),
                new Aluno("mariana", 5),
                new Aluno("lucia", 9.3)
        };

        //Aluno[] rank3 = intercala(alunosOutro, 2, 4, alunos.length - 3);
        ordena(alunosOutro, 0, alunosOutro.length);
        System.out.println(Arrays.asList(alunosOutro));
    }

    /**
     * Intercala até ordenar
     * @param alunos
     * @param inicial
     * @param termino
     */
    public static void ordena(Aluno[] alunos, int inicial, int termino) {
        int quantidade = termino - inicial;
        if (quantidade > 1) {
            int meio = (inicial + termino) / 2;
            System.out.println("ordena: de " + inicial + " a " + termino + ", meio " + meio);
            ordena(alunos, inicial, meio);
            ordena(alunos, meio, termino);
            intercala(alunos, inicial, meio, termino);
            System.out.println("ordenado: " + inicial + " " + termino);
        } else {
            System.out.println("nao ordena de " + inicial + " a " + termino);
        }
    }

    /**
     * inicial e inclusivo
     * miolo e final sao exclusivo
     * @param alunos
     * @param inicial
     * @param miolo
     * @param _final
     * @return
     */
    public static Aluno[] intercala(Aluno[] alunos, int inicial, int miolo, int _final) {
        Aluno[] resultado = new Aluno[_final - inicial];
        int atual = 0;
        int atual1 = inicial;
        int atual2 = miolo;

        while(atual < resultado.length) {
            Aluno aluno1 = pegarAlunoPosicao(alunos, atual1, inicial, miolo);
            Aluno aluno2 = pegarAlunoPosicao(alunos, atual2, miolo, _final);

            if (alunoMenorOuNotNull(aluno1, aluno2)) {
                resultado[atual++] = aluno1;
                atual1++;
            } else if (alunoMenorOuNotNull(aluno2, aluno1)) {
                resultado[atual++] = aluno2;
                atual2++;
            }
        }

        for(int c = 0; c < resultado.length; c++) {
            alunos[inicial + c] = resultado[c];
        }
        return alunos;
    }

    private static boolean alunoMenorOuNotNull(Aluno a, Aluno b){
        return (a != null && b != null && a.getNota() <= b.getNota())
                || (a != null && b == null)
                || false;
    }

    private static Aluno pegarAlunoPosicao(Aluno[] alunos, int posicao, int inicio, int fim) {
        Aluno aluno = null;
        try {
            //So retorna se tiver entre a posicao
            if (posicao >= inicio && posicao < fim) {
                aluno = alunos[posicao];
            }
        } catch (IndexOutOfBoundsException e) {
            //Aluno nao existe no array
        }

        return aluno;
    }
}
