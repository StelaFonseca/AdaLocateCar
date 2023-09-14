package org.adalocatecar.modelos;

import java.time.LocalDateTime;

public class Devolucao {
    private Veiculo veiculo;
    private Cliente cliente;
    private LocalDateTime dataDevolucao;

    public Devolucao(Veiculo veiculo, Cliente cliente, LocalDateTime dataDevolucao) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataDevolucao = dataDevolucao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public String toString() {
        return "DevolucaoVeiculo{" +
                "veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }
}
