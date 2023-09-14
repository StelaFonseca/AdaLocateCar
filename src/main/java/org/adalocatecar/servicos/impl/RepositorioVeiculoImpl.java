package org.adalocatecar.servicos.impl;

import org.adalocatecar.modelos.enums.TipoDeVeiculo;
import org.adalocatecar.servicos.RepositorioVeiculo;

import java.util.*;

import org.adalocatecar.modelos.Veiculo;

public class RepositorioVeiculoImpl implements RepositorioVeiculo {
    private Set<Veiculo> veiculos;

    public RepositorioVeiculoImpl() {
        this.veiculos = new HashSet<>();
        Veiculo veiculo = new Veiculo("POLO", "ST1212", "FIAT", "SEDAN", "2010", "AZUL", TipoDeVeiculo.MEDIO);
        this.veiculos.add(veiculo);
    }

    public Veiculo cadastrarVeiculo() {
        System.out.println("========== FORMULÁRIO DE CADASTRO DE VEÍCULO ========== \n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite a placa do veículo: ");
        String placa = scanner.nextLine().toUpperCase();

        for (Veiculo veiculo : this.veiculos) {
            if (veiculo.getPlaca().contains(placa)) {
                System.out.print("Já existe um veículo cadastrado com essa placa!");
                return null;
            }
        }

        System.out.print("Digite o nome do veículo: ");
        String nome = scanner.next().toUpperCase();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.next();

        System.out.print("Digite o ano do veículo: ");
        String anoVeiculo = scanner.next();

        System.out.print("Digite a cor do veículo: ");
        scanner.nextLine();
        String corVeiculo = scanner.nextLine();

        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.println("===== Escolha o tipo de veículo =====");
        System.out.println("1. PEQUENO");
        System.out.println("2. MÉDIO");
        System.out.println("3. SUV");

        System.out.print("\nDigite o tipo do veículo: ");
        int tipoVeiculoOpcao = scanner.nextInt();

        TipoDeVeiculo tipoVeiculo;

        switch (tipoVeiculoOpcao) {
            case 1:
                tipoVeiculo = TipoDeVeiculo.PEQUENO;
                break;
            case 2:
                tipoVeiculo = TipoDeVeiculo.MEDIO;
                break;
            case 3:
                tipoVeiculo = TipoDeVeiculo.SUV;
                break;
            default:
                System.out.println("Opção inválida! Veículo cadastrado como PEQUENO por padrão.");
                tipoVeiculo = TipoDeVeiculo.PEQUENO;
        }

        Veiculo veiculo = new Veiculo(nome, placa, marca, modelo, anoVeiculo, corVeiculo, tipoVeiculo);
        this.veiculos.add(veiculo);

        System.out.println("\nVeículo cadastrado com sucesso!\n");
        return veiculo;
    }

    @Override
    public Veiculo buscarVeiculoPorParteDoNome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nQual o nome do Veículo que você deseja buscar? ");
        String nome = scanner.nextLine().toUpperCase();

        for (Veiculo veiculo : this.veiculos) {
            if (veiculo.getNome().contains(nome)) {
                return veiculo;
            }
        }

        System.out.println("Nenhum Veículo encontrado para o nome digitado!");
        return null;
    }

    @Override
    public void alterarVeiculo() {
        Veiculo veiculo = this.buscarVeiculoPorParteDoNome();

        if (veiculo == null) {
            return;
        }

        System.out.println("\n===== ALTERAÇÃO DE DADOS DO VEÍCULO =====\n");
        System.out.println("Você só pode alterar os valores de nome, ano e cor do veículo.\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o ano do veículo: ");
        String anoVeiculo = scanner.next();

        System.out.print("\nDigite a cor do veículo: ");
        String corVeiculo = scanner.nextLine();

        System.out.print("\nDigite o nome do veículo: ");
        String nome = scanner.next().toUpperCase();

        this.veiculos.remove(veiculo);

        veiculo.setNome(nome);
        veiculo.setAno(anoVeiculo);
        veiculo.setCor(corVeiculo);

        this.veiculos.add(veiculo);

        System.out.print("\nVeículo Alterado com sucesso!\n");
    }
}

