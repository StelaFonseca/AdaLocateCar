package org.adalocatecar;

import org.adalocatecar.modelos.Cliente;
import org.adalocatecar.modelos.Veiculo;
import org.adalocatecar.servicos.RepositorioCliente;
import org.adalocatecar.servicos.RepositorioVeiculo;
import org.adalocatecar.servicos.ServicoAluguel;
import org.adalocatecar.servicos.impl.RepositorioClienteImpl;
import org.adalocatecar.servicos.impl.RepositorioVeiculoImpl;
import org.adalocatecar.servicos.impl.ServicoAluguelImpl;
import org.adalocatecar.ui.UIMenu;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RepositorioVeiculo repositorioVeiculo = new RepositorioVeiculoImpl();
        RepositorioCliente repositorioCliente = new RepositorioClienteImpl();
        ServicoAluguel servicoAluguel = new ServicoAluguelImpl();

        while (true) {
            UIMenu.printMenu();

            System.out.print("Digite sua opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    repositorioVeiculo.cadastrarVeiculo();
                    break;

                case 2:
                    repositorioVeiculo.alterarVeiculo();
                    break;

                case 3:
                    Veiculo veiculoAchado = repositorioVeiculo.buscarVeiculoPorParteDoNome();
                    if (veiculoAchado == null) {
                        break;
                    }

                    System.out.println("\n" + veiculoAchado + "\n");
                    break;
                case 4:
                    repositorioCliente.cadastrarCliente();
                    break;

                case 5:
                    repositorioCliente.alterarCliente();
                    break;

                case 6:
                    Cliente cliente = repositorioCliente.buscarClientePorDocumento();

                    if (cliente == null) {
                        break;
                    }

                    Veiculo veiculo = repositorioVeiculo.buscarVeiculoPorParteDoNome();

                    if (veiculo == null) {
                        break;
                    }

                    servicoAluguel.alugarVeiculo(cliente, veiculo);
                    break;

                case 7:

                   Cliente cliente1 = repositorioCliente.buscarClientePorDocumento();

                    if (cliente1 == null) {
                        break;
                    }

                    Veiculo veiculo1 = repositorioVeiculo.buscarVeiculoPorParteDoNome();

                    if (veiculo1 == null) {
                        break;
                    }

                    servicoAluguel.devolverVeiculo(cliente1, veiculo1, LocalDateTime.now().plusDays(5));
                    break;


                case 8:
                    System.out.println("Saindo do programa. Até logo!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
