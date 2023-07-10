package br.com.acme_diego_rezende_atividade_02.model;

import java.time.LocalDate;
import java.util.List;


public class FaturaParaPagamentoCompra {
    private List<Produto> carrinho;
    private final LocalDate dataCompra;
    private final Cliente cliente;

    private Boolean autorizacaoCompraPorRegraInadimplencia;

    public FaturaParaPagamentoCompra(List<Produto> carrinho, LocalDate dataCompra, Cliente cliente) {
        this.carrinho = carrinho;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
        autorizacaoCompraPorRegraInadimplencia = false;
    }

    private Boolean getAutorizacaoCompraPorRegraInadimplencia() {
        return autorizacaoCompraPorRegraInadimplencia;

    }

    public void setAutorizacaoCompraPorRegraInadimplencia(Boolean autorizacaoCompraPorRegraInadimplencia) {
        this.autorizacaoCompraPorRegraInadimplencia = autorizacaoCompraPorRegraInadimplencia;
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

    public boolean isAutorizada() {
        return getAutorizacaoCompraPorRegraInadimplencia();
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
