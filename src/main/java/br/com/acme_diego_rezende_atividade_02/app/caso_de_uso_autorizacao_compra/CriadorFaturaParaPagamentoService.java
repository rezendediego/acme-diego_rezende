package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_autorizacao_compra;

import br.com.acme_diego_rezende_atividade_02.model.Compra;
import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoCompra;


public class CriadorFaturaParaPagamentoService {

    public FaturaParaPagamentoCompra criarFaturaAutorizadaCompra(Compra compraAutorizada) {
        FaturaParaPagamentoCompra faturaAutorizada = new FaturaParaPagamentoCompra(
                compraAutorizada.getCarrinho(),
                compraAutorizada.getDataCompra(),
                compraAutorizada.getCliente());
        faturaAutorizada.setAutorizacaoCompraPorRegraInadimplencia(true);
        return faturaAutorizada;
    }


    public FaturaParaPagamentoCompra criarFaturaRejeitadaCompra(Compra compraRejeitada) {
        FaturaParaPagamentoCompra faturaRejeitada = new FaturaParaPagamentoCompra(
                compraRejeitada.getCarrinho(),
                compraRejeitada.getDataCompra(),
                compraRejeitada.getCliente());
        faturaRejeitada.setAutorizacaoCompraPorRegraInadimplencia(false);
        return faturaRejeitada;    }
}
