package org.adalocatecar.servicos;

import org.adalocatecar.modelos.*;

import java.time.LocalDateTime;

public interface ServicoAluguel {
    void alugarVeiculo(Cliente cliente, Veiculo veiculo);
    void devolverVeiculo(Cliente cliente, Veiculo veiculo, LocalDateTime dataDevolucao);
}