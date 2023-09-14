package org.adalocatecar.servicos;
import org.adalocatecar.modelos.Veiculo;


import java.util.List;

public interface RepositorioVeiculo {
   Veiculo cadastrarVeiculo();

   Veiculo buscarVeiculoPorParteDoNome();

   void alterarVeiculo();
}