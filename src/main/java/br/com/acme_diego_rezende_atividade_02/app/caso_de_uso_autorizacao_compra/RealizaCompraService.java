package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_autorizacao_compra;

import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao.Infracao;
import br.com.acme_diego_rezende_atividade_02.exception.PagamentoEmAtrasoException;
import br.com.acme_diego_rezende_atividade_02.model.Compra;
import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoCompra;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class RealizaCompraService {
    static List<Infracao> listaInfracoesVerificaveis;
    static CriadorFaturaParaPagamentoService criadorFaturaParaPagamentoService = new CriadorFaturaParaPagamentoService();

    public RealizaCompraService(List<Infracao> listaInfracoesVerificaveis) {
        RealizaCompraService.listaInfracoesVerificaveis = listaInfracoesVerificaveis;
    }

    private static Predicate<Compra> isCompraAutorizada = compra -> {
        AutorizaCompraService autorizaCompraService = new AutorizaCompraService(listaInfracoesVerificaveis);
        return autorizaCompraService.autorizarCompra(compra);
    };
    private static Function<Compra, FaturaParaPagamentoCompra> gerarPagamentoDeCompra = compra -> Optional.of(compra)
              .filter(isCompraAutorizada)
              .map(compraAutorizada -> criadorFaturaParaPagamentoService.criarFaturaAutorizadaCompra(compraAutorizada))
              .orElseGet(()->Optional.of(compra)
                      .map(compraRejeitada -> criadorFaturaParaPagamentoService.criarFaturaRejeitadaCompra(compraRejeitada)).get());

    public void realizaCompra(Compra carrinhoCompra) throws PagamentoEmAtrasoException {
        Optional.of(gerarPagamentoDeCompra.apply(carrinhoCompra))
                .filter(FaturaParaPagamentoCompra::isAutorizada)
                .orElseThrow(() -> new PagamentoEmAtrasoException(">>>: ERRO: O Cliente possui assinatura em atraso e nao pode realizar a compra."));
    }

}
