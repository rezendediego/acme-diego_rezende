package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_autorizacao_compra;

import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao.Infracao;
import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_validacao_cliente.ValidacaoClienteService;
import br.com.acme_diego_rezende_atividade_02.model.Compra;

import java.util.List;
import java.util.function.Predicate;

public class AutorizaCompraService {
    List<Infracao> listaInfracoesVerificaveis;

    public AutorizaCompraService(List<Infracao> listaInfracoesVerificaveis) {
        this.listaInfracoesVerificaveis = listaInfracoesVerificaveis;
    }

    Predicate<Compra> autorizarCompra = compra -> {
        ValidacaoClienteService validacaoClienteService = new ValidacaoClienteService(listaInfracoesVerificaveis);
        return validacaoClienteService.validarCliente(compra.getCliente());
    };

    public Boolean autorizarCompra(Compra compra) {
        return autorizarCompra.test(compra);
    }
}
