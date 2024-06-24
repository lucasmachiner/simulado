package br.edu.up.Models;

public class Pessoa {
    int Codigo;
    String Nome;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String toCsv() {
        return Codigo + "," + Nome;
    }

}
