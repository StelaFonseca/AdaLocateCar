package org.adalocatecar.servicos.impl;

import org.adalocatecar.modelos.Cliente;
import org.adalocatecar.modelos.enums.TipoCliente;
import org.adalocatecar.servicos.RepositorioCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RepositorioClienteImpl implements RepositorioCliente {
    private Set<Cliente> clientes = new HashSet<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void cadastrarCliente() {
        System.out.println("========== FORMULÁRIO DE CADASTRO DE CLIENTE ========== \n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("\nDigite o CPF ou CNPJ do cliente: ");
        long documento = scanner.nextLong();

        // Verificar a duplicidade com base no CPF ou CNPJ do cliente
        if (verificarDuplicidade(documento)) {
            System.out.println("Cliente com CPF ou CNPJ já cadastrado!");
            return;
        }

        System.out.print("Digite a data de nascimento (formato: dd/MM/yyyy): ");
        scanner.nextLine();
        String dataNascimento = scanner.nextLine();
        LocalDate nascimento = LocalDate.parse(dataNascimento, formatter);

        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.println("Escolha o tipo de cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");

        int tipoClienteOpcao = scanner.nextInt();

        TipoCliente tipoCliente;
        switch (tipoClienteOpcao) {
            case 1:
                tipoCliente = TipoCliente.PESSOA_FISICA;
                break;
            case 2:
                tipoCliente = TipoCliente.PESSOA_JURIDICA;
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        // Crie o novo cliente com as informações fornecidas e adicione à lista
        Cliente novoCliente = new Cliente(nome, documento, tipoCliente, nascimento, endereco);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public boolean verificarDuplicidade(long documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento() == documento) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Cliente buscarClientePorDocumento() {
        System.out.println("========== BUSCA DE CLIENTE ========== \n");
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o CPF ou CNPJ do cliente: ");
        long documento = scanner.nextLong();

        for (Cliente cliente: clientes) {
            if (cliente.getDocumento() == documento) {
                return cliente;
            }
        }

        System.out.println("Não encontramos nenhum cliente para o documento informado!");
        return null;
    }

    @Override
    public void alterarCliente() {
        Cliente cliente = this.buscarClientePorDocumento();

        if (cliente == null) {
            return;
        }

        System.out.println("\n===== ALTERAÇÃO DE DADOS DO CLIENTE =====\n");
        System.out.println("Você só pode alterar os valores de nome, documento e endereço do cliente.\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("\nDigite o CPF ou CNPJ do cliente: ");
        long documento = scanner.nextLong();

        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        this.clientes.remove(cliente);

        cliente.setNome(nome);
        cliente.setDocumento(documento);
        cliente.setEndereco(endereco);

        this.clientes.add(cliente);

        System.out.print("\nCliente Alterado com sucesso!\n");
    }
}