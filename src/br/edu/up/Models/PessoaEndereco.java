package br.edu.up.Models;

public class PessoaEndereco {
    int Codigo;
    String Nome;
    String Rua;
    String Cidade;

    PessoaEndereco(int codigo, String nome, String rua, String cidade) {
        Codigo = codigo;
        Nome = nome;
        Rua = rua;
        Cidade = cidade;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String rua) {
        Rua = rua;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

}
