package com.fiap.test;

public class Calculadora {

    public int somar(int valorA, int valorB) {
        return valorA + valorB;
    }

    public int subtrair(int valorA, int valorB) {
        return valorA - valorB;
    }

    public int multiplicar(int valorA, int valorB) {
        return valorA * valorB;
    }

    public int dividir(int valorA, int valorB) {
        if (valorB == 0) {
            throw new ArithmeticException("Não é permitido divisão por 0");
        }
        return valorA / valorB;
    }
}