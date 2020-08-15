package com.cesar.v3;

public class Nota {

    private String nome;
    private double valor;


    public Nota(String name, double nota) {
        this.nome = name;
        this.valor = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                "}\n";
    }
}
