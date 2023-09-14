package org.adalocatecar.modelos;

import java.time.LocalDateTime;


public class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Aluguel(Veiculo veiculo, Cliente cliente, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }
}

