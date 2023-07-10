package br.com.acme_diego_rezende_atividade_02.model;

import java.time.LocalDate;
import java.util.List;


public class Compra {
    private final Cliente cliente;
    private List<Produto> carrinho;
    private Double valorTotal;
    private String meioDePagamento;
    private final LocalDate dataCompra;
    private Boolean isClienteAutorizadoComprar;


    public Compra(Cliente cliente, List<Produto> carrinho, String meioDePagamento, LocalDate dataCompra) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.valorTotal = calcularValorTotalPagamento(this.carrinho);
        this.meioDePagamento = meioDePagamento;
        this.dataCompra = dataCompra;
        this.isClienteAutorizadoComprar = false;

    }

    public Compra(Cliente cliente, List<Produto> carrinho, String meioDePagamento) {
        this.cliente = cliente;
        this.carrinho = carrinho;
        this.valorTotal = calcularValorTotalPagamento(this.carrinho);
        this.meioDePagamento = meioDePagamento;
        this.dataCompra = LocalDate.now();
        this.isClienteAutorizadoComprar = false;

    }

    private Double calcularValorTotalPagamento(List<Produto> carrinho){
        return carrinho.stream()
                .mapToDouble(produto -> produto.getPreco().doubleValue())
                .reduce(0.0, Double::sum);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMeioDePagamento() {
        return meioDePagamento;
    }

    public void setMeioDePagamento(String meioDePagamento) {
        this.meioDePagamento = meioDePagamento;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public Boolean getClienteAutorizadoComprar() {
        return isClienteAutorizadoComprar;
    }

    public void setClienteAutorizadoComprar(Boolean clienteAutorizadoComprar) {
        isClienteAutorizadoComprar = clienteAutorizadoComprar;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "cliente=" + cliente +
                ", carrinho=" + carrinho +
                ", valorTotal=" + valorTotal +
                ", meioDePagamento='" + meioDePagamento + '\'' +
                ", dataCompra=" + dataCompra +
                ", isClienteAutorizadoComprar=" + isClienteAutorizadoComprar +
                '}';
    }
}
