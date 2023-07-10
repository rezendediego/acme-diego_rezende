package br.com.acme_diego_rezende_atividade_02.model;

public class Cliente {
    private final String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + nome + '\'' +
                '}';
    }
}
