package br.com.acme_diego_rezende.model;

import java.time.LocalDate;
import java.util.List;

public class Pagamento {
    private List<Produto> carrinho;
    private final LocalDate dataCompra;
    private final Cliente cliente;

    public Pagamento(List<Produto> carrinho, LocalDate dataCompra, Cliente cliente) {
        this.carrinho = carrinho;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }


    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "carrinho=" + carrinho +
                ", dataCompra=" + dataCompra +
                ", cliente=" + cliente +
                '}';
    }
}
