package br.com.fiap.localtech.entities;

import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Veiculo {

    private Long id;

    private String marca;

    private String modelo;

    private String placa;

    private int ano;

    private String cor;

    private BigDecimal valorDiaria;
}
