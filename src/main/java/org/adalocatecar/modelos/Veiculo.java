package org.adalocatecar.modelos;

import org.adalocatecar.modelos.enums.TipoDeVeiculo;

import java.util.Objects;

public class Veiculo {
    String nome;
    private String placa;
    private String marca;
    private String modelo;
    private String ano;
    private String cor;
    private TipoDeVeiculo tipo;

    public Veiculo(String nome, String placa, String marca, String modelo, String ano, String cor, TipoDeVeiculo tipo) {
        this.nome = nome;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoDeVeiculo getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "nome='" + nome + '\'' +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                ", cor='" + cor + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(placa, veiculo.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }
}



