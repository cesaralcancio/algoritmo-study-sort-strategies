package com.cesar.v2;

import java.util.*;

public class Intercala {

    public static void main(String[] args) {
        Aluno[] alunos1 = new Aluno[] {
                new Aluno("Bento", 1),
                new Aluno("Cesar", 3.5),
                new Aluno("Paula", 5),
                new Aluno("Chico", 7.5)
        };

        Aluno[] alunos2 = new Aluno[] {
                new Aluno("Joao", 0.5),
                new Aluno("Maria", 3),
                new Aluno("Alfredo", 6),
                new Aluno("Bruno", 7),
                new Aluno("Thais", 8),
                new Aluno("Jose", 10)
        };

        Aluno[] rank = intercala(alunos2, alunos1);
        System.out.println(Arrays.asList(rank));

        //Refactory
        Aluno[] alunos = new Aluno[] {
                new Aluno("Bento", 1),
                new Aluno("Cesar", 3.5),
                new Aluno("Paula", 5),
                new Aluno("Chico", 7.5),
                new Aluno("Joao", 0.5),
                new Aluno("Maria", 3),
                new Aluno("Alfredo", 6),
                new Aluno("Bruno", 7),
                new Aluno("Thais", 8),
                new Aluno("Jose", 10),
        };
        Aluno[] rank2 = intercala(alunos, 0, 4, alunos.length);
        System.out.println(Arrays.asList(rank2));

        //Testando ordenar so uma parte do array
        Aluno[] alunosOutro = new Aluno[] {
                new Aluno("Bento", 1), //mantem
                new Aluno("Cesar", 3.5), //mantem
                new Aluno("Paula", 5), //ordena
                new Aluno("Chico", 7.5), //ordena
                new Aluno("Joao", 0.5), //ordena
                new Aluno("Maria", 3), //ordena
                new Aluno("Alfredo", 6), //ordena
                new Aluno("Bruno", 7), //mantem
                new Aluno("Thais", 8), //mantem
                new Aluno("Jose", 10), //mantem
        };
        //Aluno[] rank3 = intercala(alunosOutro, 2, 4, alunos.length - 3);
        Aluno[] rank3 = intercala(alunosOutro, 0, 4, 10);
        System.out.println(Arrays.asList(rank3));
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

    public static Aluno[] intercala(Aluno[] alunos1, Aluno[] alunos2) {
        Aluno[] resultado = new Aluno[alunos1.length + alunos2.length];
        int posicaoAtual = 0;
        int posicaoAtualAlunos1 = 0;
        int posicaoAtualAlunos2 = 0;

        while(posicaoAtual < resultado.length) {
            Aluno aluno1 = pegarAlunoPosicao(alunos1, posicaoAtualAlunos1);
            Aluno aluno2 = pegarAlunoPosicao(alunos2, posicaoAtualAlunos2);
            //System.out.println(posicaoAtual + " comparando " + aluno1 + " com " + aluno2);

            if (alunoMenorOuNotNull(aluno1, aluno2)) {
                resultado[posicaoAtual++] = aluno1;
                posicaoAtualAlunos1++;
            } else if (alunoMenorOuNotNull(aluno2, aluno1)) {
                resultado[posicaoAtual++] = aluno2;
                posicaoAtualAlunos2++;
            }
        }

        return resultado;
    }

    private static boolean alunoMenorOuNotNull(Aluno a, Aluno b){
        return (a != null && b != null && a.getNota() <= b.getNota())
                || (a != null && b == null)
                || false;
    }

    private static Aluno pegarAlunoPosicao(Aluno[] alunos, int posicao) {
        return pegarAlunoPosicao(alunos, posicao, 0, alunos.length);
    }

    private static Aluno pegarAlunoPosicao(Aluno[] alunos, int posicao, int inicio, int fim) {
        Aluno aluno = null;
        try{
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
