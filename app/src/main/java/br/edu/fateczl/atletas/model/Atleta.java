package br.edu.fateczl.atletas.model;

public class Atleta {

    private String nome;
    private String nascimento;
    private String bairro;

    public Atleta(String dados) {
        this.nome = dados.split(";")[0];
        this.nascimento = dados.split(";")[1];
        this.bairro = dados.split(";")[2];
    }

    @Override
    public String toString() {
        return getNome() + ", " +
                getNascimento() + ", " +
                getBairro();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
