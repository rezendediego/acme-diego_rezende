package br.com.acme_diego_rezende_atividade_03.builder;

import br.com.acme_diego_rezende_atividade_03.model.Cliente;
import br.com.acme_diego_rezende_atividade_03.model.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoBuilder {
    private final List<Produto> produtosDoCarrinho;
    private final Cliente cliente;
    private final String meioDePagamento;
    private final LocalDate dataCompra;
    private Double valorTotal;
    private Boolean isAutorizada;

    @Override
    public String toString() {
        return "CarrinhoBuilder{" +
                ", cliente=" + cliente + "\r\n" +
                "produtosDoCarrinho=" + produtosDoCarrinho + "\r\n" +
                ", valorTotal=" + valorTotal + "\r\n" +
                ", meioDePagamento='" + meioDePagamento + '\'' + "\r\n" +
                ", dataCompra=" + dataCompra +  "\r\n" +
                ", isAutorizada=" + isAutorizada + "\r\n" +
                '}';
    }

    private CarrinhoBuilder(Builder builder) {
        this.produtosDoCarrinho = builder.produtos;
        this.cliente = builder.cliente;
        this.dataCompra = LocalDate.now();
        this.meioDePagamento = builder.meioDePagamento;
        this.isAutorizada = builder.isAutorizada;
        this.valorTotal = this.produtosDoCarrinho.stream()
                .mapToDouble(produto -> produto.getPreco().doubleValue())
                .reduce(0.0,Double::sum);
    }

    public List<Produto> getProdutosDoCarrinho() {
        return produtosDoCarrinho;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getMeioDePagamento() {
        return meioDePagamento;
    }

    public static class Builder {
        private List<Produto> produtos = new ArrayList<>();
        private Cliente cliente;
        private String meioDePagamento;
        private Boolean isAutorizada;

        public Builder setIsAutorizada(Boolean autorizacao){
            this.isAutorizada = autorizacao;
            return this;
        }

        public Builder setCliente(Cliente cliente){
            this.cliente =cliente;
            return this;
        }

        public Builder setMeioDePagamento(String meioDePagamento) {
            this.meioDePagamento = meioDePagamento;
            return this;
        }

        public Builder addProduto(Produto produto) {
            produtos.add(produto);
            return this;
        }

        public CarrinhoBuilder build() {
            return new CarrinhoBuilder(this);
        }
    }

}

