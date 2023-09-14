package org.adalocatecar.modelos;

import org.adalocatecar.modelos.enums.TipoCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private String nome;
    private long documento;
    private TipoCliente tipo;
    private LocalDate dataNascimento;
    private String endereco;
    private static List<Cliente> clientesCadastrados = new ArrayList<>();

    public Cliente(String nome, long documento, TipoCliente tipo, LocalDate dataNascimento, String endereco) {
        this.nome = nome;
        this.documento = documento;
        this.tipo = tipo;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    // Verificar duplicação de CPF ou CNPJ
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public static void setClientesCadastrados(List<Cliente> clientesCadastrados) {
        Cliente.clientesCadastrados = clientesCadastrados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(documento, cliente.documento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documento);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                ", tipo=" + tipo +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}


