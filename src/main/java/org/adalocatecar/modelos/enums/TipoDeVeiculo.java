package org.adalocatecar.modelos.enums;

public enum TipoDeVeiculo {
    PEQUENO(100.00),
    MEDIO(150.00),
    SUV(200.00);

    private final double valorDiaria;

    TipoDeVeiculo(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}

