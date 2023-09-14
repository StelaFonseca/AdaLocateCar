package org.adalocatecar.servicos.impl;
import org.adalocatecar.modelos.Aluguel;
import org.adalocatecar.modelos.Cliente;
import org.adalocatecar.modelos.Veiculo;
import org.adalocatecar.modelos.enums.TipoCliente;
import org.adalocatecar.servicos.ServicoAluguel;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ServicoAluguelImpl  implements ServicoAluguel {
    private List<Aluguel> alugueis = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public void alugarVeiculo(Cliente cliente, Veiculo veiculo) {
        System.out.println("========== FORMULÁRIO DE ALUGUEL DE VEÍCULO ========== \n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nQual a data de inicio da locação (formato: dd/MM/yyyy HH:mm): ");
        String dataInicio = scanner.nextLine();
        LocalDateTime inicio = LocalDateTime.parse(dataInicio, formatter);

        System.out.print("\nQual a data de devolução da locação (formato: dd/MM/yyyy HH:mm): ");
        String dataFim = scanner.nextLine();
        LocalDateTime fim = LocalDateTime.parse(dataFim, formatter);

        if (veiculoDisponivelParaAluguel(veiculo, inicio, fim)) {
            Aluguel aluguel = new Aluguel(veiculo, cliente, inicio, fim);
            alugueis.add(aluguel);
        }

        System.out.println("\nProcesso de alguel finalizado!\n");
    }



    private boolean veiculoDisponivelParaAluguel(Veiculo veiculo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getVeiculo().equals(veiculo)) {
                LocalDateTime inicioJaAlugado = aluguel.getDataInicio();
                LocalDateTime finalJaAlugado = aluguel.getDataFim();

                boolean dataInicioEstaEntreUmAluguel = dataInicio.isAfter(inicioJaAlugado) && dataInicio.isBefore(finalJaAlugado);
                boolean dataFinalEstaEntreUmAluguel = dataFim.isAfter(inicioJaAlugado) && dataFim.isBefore(finalJaAlugado);

                if (dataInicioEstaEntreUmAluguel || dataFinalEstaEntreUmAluguel) {
                    System.out.println(" Veículo já está alugado durante o período especificado.");
                    return false;
                }
            }
        }

        return true;
    }

    public void devolverVeiculo(Cliente cliente, Veiculo veiculo, LocalDateTime dataDevolucao) {

        Aluguel aluguel = buscarAluguelAtivo(cliente, veiculo);

        if (aluguel == null) {
            System.out.println("Não há nenhum aluguel para o cliente " + cliente.getNome() + " com o veículo " +
                    veiculo);

            return;
        }

        long horaDoAluguel = Duration.between(aluguel.getDataInicio(), aluguel.getDataFim()).toHours();
        long horasDaLocacaoTotal = Duration.between(aluguel.getDataInicio(), dataDevolucao).toHours();

        long diarias = horaDoAluguel / 24;

        if (diarias <= 0) {
            diarias = 1;
        }

        if (horasDaLocacaoTotal > horaDoAluguel) {
            diarias++;
        }

        double valorTotal = calcularValorAluguel(aluguel, diarias);

        System.out.println("Devolução de veículo:");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Data de início do aluguel: " + aluguel.getDataInicio());
        System.out.println("Data de devolução: " + dataDevolucao);
        System.out.println("Dias alugados: " + diarias);

        System.out.println("Valor total do aluguel: R$" + valorTotal);
        alugueis.remove(aluguel);
    }

    private double calcularValorAluguel(Aluguel aluguel, long diarias) {
        double valorDiaria;

        switch (aluguel.getVeiculo().getTipo()) {
            case MEDIO:
                valorDiaria = 150.00;
                break;
            case SUV:
                valorDiaria = 200.00;
                break;
            default:
                valorDiaria = 100.00;
        }

        double valorTotal = valorDiaria * diarias;

        if (aluguel.getCliente().getTipo() == TipoCliente.PESSOA_FISICA && diarias > 5) {
            double desconto = valorTotal * 0.05;
            valorTotal -= desconto;
        } else if (aluguel.getCliente().getTipo() == TipoCliente.PESSOA_JURIDICA && diarias > 3) {
            double desconto = valorTotal * 0.10;
            valorTotal -= desconto;
        }

        return valorTotal;
    }

    private Aluguel buscarAluguelAtivo(Cliente cliente, Veiculo veiculo) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getCliente().equals(cliente) && aluguel.getVeiculo().equals(veiculo)) {
                return aluguel;
            }
        }

        return null;
    }
}


