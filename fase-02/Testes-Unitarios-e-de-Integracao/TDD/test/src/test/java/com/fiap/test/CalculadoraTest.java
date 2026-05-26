package com.fiap.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;
    private int valorA;
    private int valorB;

    @BeforeEach
    void setup() {
        calculadora = new Calculadora();
        valorA = 5;
        valorB = 2;
    }

    @Test
    void devePermitirSomar() {
        // Arrange - Preparar
        valorA = 5;
        valorB = 6;

        // Action - Agir/Atuar
        int resultado = calculadora.somar(valorA, valorB);

        // Assert - Validar
        assertEquals(11, resultado);
    }

    @Test
    void devePermitirSubtrair() {
        int resultado = calculadora.subtrair(valorA, valorB);
        assertEquals(3, resultado);
    }

    @Test
    void devePermitirMultiplicar() {
        int resultado = calculadora.multiplicar(valorA, valorB);
        assertEquals(10, resultado);
    }

    @Test
    void devePermitirDividir() {
        valorA = 6;
        valorB = 2;

        int resultado = calculadora.dividir(valorA, valorB);

        assertEquals(3, resultado);
    }

    @Test
    void deveGerarErroAoDividirPorZero() {
        valorB = 0;

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(valorA, valorB);
        });

        assertEquals("Não é permitido divisão por 0", exception.getMessage());
    }
}