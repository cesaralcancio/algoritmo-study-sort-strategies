package com.cesar.v1;

import java.util.*;

/**
 * Insert and Selection sort comparation: https://stackoverflow.com/questions/15799034/insertion-sort-vs-selection-sort
 *
 */
public class InsertAndSelectSoftMain {

    /**
     * Differences between insert and selection sort:
     * Basically insertion sort works by comparing two elements at a time and
     * selection sort selects the minimum element from the whole array and sorts it.
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> valores = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            valores.add((int) (Math.random() * 100));
        }
        System.out.println(valores);

        insertSort(valores.toArray(Integer[]::new));
        selectSort(valores.toArray(Integer[]::new));
    }

    /**
     * Insert sort para ordenar do maior para o menor.
     * Varre da esquerda para a direita e verifica com os anteriores (varre da direita para a esquerda),
     * caso seja menor, insere nessa posicao.
     * @param valores
     */
    public static void insertSort(Integer[] valores) {
        for (int i = 1; i < valores.length; i++) {
            int analise = i;
            int anteriorDaAnalise = analise - 1;

            while(analise > 0
                    && valores[analise] < valores[anteriorDaAnalise]) {
                troca(valores, analise, anteriorDaAnalise);

                //novos valores
                analise = analise - 1;
                anteriorDaAnalise = analise - 1;
            }
        }

        imprime(valores);
    }

    /**
     * Select Sort para ordenar do menor para o maior.
     * Varre da esquerda para a direita e seleciona o menor para a posicao atual do array.
     * @param valores
     */
    public static void selectSort(Integer[] valores) {
        for(int atual = 0; atual < valores.length; atual++) {
            int posicaoMenor = selecionaMenor(valores, atual);
            troca(valores, atual, posicaoMenor);
        }

        imprime(valores);
    }

    private static Integer selecionaMenor(Integer[] valores, Integer posicaoAtual) {
        //Pra cada posicao de "valores", verificar a direita se tem um menor
        //Se tiver um menor, troca de posicao com o posicaoAtual de "valores".
        Integer posicaoMenor = posicaoAtual;
        Integer menor = valores[posicaoAtual];

        for(int j = posicaoAtual; j < valores.length; j++) {
            int possivelMenor = valores[j];

            if (possivelMenor < menor) {
                menor = possivelMenor;
                posicaoMenor = j;
            }
        }

        return posicaoMenor;
    }

    private static void troca(Integer[] array, int de, int para) {
        int valorDe = array[de];
        int valorPara = array[para];

        array[de] = valorPara;
        array[para] = valorDe;
    }

    private static void imprime(Integer[] array) {
        System.out.println(Arrays.asList(array));
    }
}
