package br.com.acme_diego_rezende_atividade_02.model;

import java.math.BigDecimal;
import java.nio.file.Path;

public class Produto {
    private String nome;
    private Path path;
    private BigDecimal preco;


    public Produto(String nome, Path path, BigDecimal preco) {
        this.nome = nome;
        this.path = path;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }


    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", path=" + path +
                ", preco=" + preco +
                '}';
    }

}
