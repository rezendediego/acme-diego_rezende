package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao;

import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_suspensao_clientes_inadimplentes.AplicaRegraClienteComAssinaturaInadimplenteService;
import br.com.acme_diego_rezende_atividade_02.model.Cliente;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;

public class InfracaoInadimplenciaAssinatura implements Infracao {
    AplicaRegraClienteComAssinaturaInadimplenteService aplicaRegraClienteComAssinaturaInadimplenteService = new AplicaRegraClienteComAssinaturaInadimplenteService();
    @Override
    public Boolean verificaInfracao(Cliente cliente) {
        Assinatura assinatura = aplicaRegraClienteComAssinaturaInadimplenteService.aplicaRegra(cliente);
        return assinatura.getInadimplente();
    }
}
