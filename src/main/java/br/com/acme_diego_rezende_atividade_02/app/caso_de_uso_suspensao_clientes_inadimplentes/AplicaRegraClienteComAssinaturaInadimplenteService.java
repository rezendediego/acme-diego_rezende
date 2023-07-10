package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_suspensao_clientes_inadimplentes;

import br.com.acme_diego_rezende_atividade_02.domain.RegraAssinaturaInadimplente;
import br.com.acme_diego_rezende_atividade_02.model.Cliente;
import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoAssinatura;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;
import br.com.acme_diego_rezende_atividade_02.repository.AssinaturaRepository;
import br.com.acme_diego_rezende_atividade_02.utilitarios.repositorio_suporte.FaturasInadimplentesSimuladasSuporteRepository;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class AplicaRegraClienteComAssinaturaInadimplenteService implements RegraAssinaturaInadimplente {
    BiFunction<Cliente, Map<String, FaturaParaPagamentoAssinatura>, FaturaParaPagamentoAssinatura> buscaFaturaMensalDeCliente =
            (cliente, mapaComAssinaturasInadimplentesSimuladas) ->
                    mapaComAssinaturasInadimplentesSimuladas.entrySet()
                            .stream()
                            .filter(itemMapa -> itemMapa.getKey().equals(cliente.getNome()))
                            .map(Map.Entry::getValue)
                            .findFirst()
                            .orElse(null);


    Predicate<FaturaParaPagamentoAssinatura> isFaturaSemPagar = FaturaParaPagamentoAssinatura::getPago;

    @Override
    public Assinatura aplicaRegra(Cliente cliente) {
        Assinatura assinatura = AssinaturaRepository.getAssinaturaPorCliente(cliente);
        Map<String, FaturaParaPagamentoAssinatura> mapaAssinaturasIncluindoInadimplentes = FaturasInadimplentesSimuladasSuporteRepository.getArmazenadorDeFaturasInadimplentesSimuladas();
        assinatura.setInadimplente(isFaturaSemPagar.test(buscaFaturaMensalDeCliente.apply(cliente, mapaAssinaturasIncluindoInadimplentes)));

        return assinatura;
    }
}