package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao;

import br.com.acme_diego_rezende_atividade_02.model.Cliente;

import java.util.List;
import java.util.function.BiPredicate;


public class InfracaoController {
    List<Infracao> listaInfracoes;

    public InfracaoController(List<Infracao> listaInfracoes) {
        this.listaInfracoes = listaInfracoes;
    }

   private BiPredicate<Cliente, List<Infracao>> verificaInfracao =
           (cliente,listaDeInfracoesParaProcessar) ->
                   listaDeInfracoesParaProcessar.stream()
                           .anyMatch(infracao -> infracao.verificaInfracao(cliente));




    public Boolean verificaSeClientePossuiSuspensao(Cliente cliente) {
        return verificaInfracao.test(cliente,listaInfracoes);
    }
}
