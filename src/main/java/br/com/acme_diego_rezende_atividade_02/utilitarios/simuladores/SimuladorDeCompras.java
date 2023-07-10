package br.com.acme_diego_rezende_atividade_02.utilitarios.simuladores;

import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_autorizacao_compra.RealizaCompraService;
import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao.Infracao;
import br.com.acme_diego_rezende_atividade_02.model.Cliente;
import br.com.acme_diego_rezende_atividade_02.model.Compra;
import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoAssinatura;
import br.com.acme_diego_rezende_atividade_02.repository.ClienteRepository;
import br.com.acme_diego_rezende_atividade_02.utilitarios.Impressora;
import br.com.acme_diego_rezende_atividade_02.utilitarios.config.ComprasAcmeConfig;

import java.util.*;
import java.util.function.Function;

public class SimuladorDeCompras {
    Map<String, FaturaParaPagamentoAssinatura> mapaFaturasInadimplentesSimuladas;
    Impressora impressora;
    List<Compra> listaComprasFicticias;

    List<Infracao> listaInfracoesVerificaveis;

    public SimuladorDeCompras(Map<String, FaturaParaPagamentoAssinatura> mapaFaturasInadimplentesSimuladas, List<Infracao> listaInfracoesVerificaveis) {
        this.mapaFaturasInadimplentesSimuladas = mapaFaturasInadimplentesSimuladas;
        this.listaInfracoesVerificaveis = listaInfracoesVerificaveis;
        this.listaComprasFicticias = ComprasAcmeConfig.criarComprasFicticias();
        this.impressora = new Impressora();
    }

    Function<Map<String, FaturaParaPagamentoAssinatura>, Map<Cliente,Compra>> criaComprasSimuladas = mapaFaturas ->{
        Map<Cliente,Compra> mapaComprasSimuladas = new HashMap<>();
        mapaFaturas.forEach((chaveNomeCliente,faturaAssinatura)->
                        mapaComprasSimuladas.put(
                                ClienteRepository.getClientePorNome(chaveNomeCliente),
                                listaComprasFicticias.stream()
                                        .filter(compra -> compra.getCliente().getNome().equals(chaveNomeCliente))
                                        .findFirst()
                                        .orElse(null)
                                )
        );
        return mapaComprasSimuladas;
    };

    public void realizeComprasFicticias() {
        RealizaCompraService realizaCompraService = new RealizaCompraService(listaInfracoesVerificaveis);
        Map<Cliente,Compra> mapaComprasSimuladas = criaComprasSimuladas.apply(mapaFaturasInadimplentesSimuladas);
        mapaComprasSimuladas.forEach((cliente,carrinho) -> {
            impressora.imprime(carrinho.toString());
            try{
            realizaCompraService.realizaCompra(carrinho);
            }catch (RuntimeException pagamentoEmAtrasoException){
                impressora.imprimeAlertaException(pagamentoEmAtrasoException.getMessage());
            }
        });
    }
}
