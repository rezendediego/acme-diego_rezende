package br.com.acme_diego_rezende_atividade_02.repository;

import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoAssinatura;


import java.util.HashMap;
import java.util.Map;

public class FaturasPagamentoAssinaturaRepository {
    static Map<String, FaturaParaPagamentoAssinatura> mapaPagamentosFicticiosAcme = new HashMap<>();


    public static void criarFaturaParaPagamentoAssinatura(FaturaParaPagamentoAssinatura pagamento) {
        mapaPagamentosFicticiosAcme.put(
                pagamento.getCliente().getNome(),
                pagamento);

    }


    public void apagarPagamento(FaturaParaPagamentoAssinatura pagamento) {
        mapaPagamentosFicticiosAcme.remove(pagamento.getCliente().getNome());

    }


    public FaturaParaPagamentoAssinatura getFaturasPagamentoAssinaturaPorNomeCliente(String nomeCliente) {
        return mapaPagamentosFicticiosAcme.get(nomeCliente);
    }


    public static Map<String, FaturaParaPagamentoAssinatura> getTodasFaturasPagamentoAssinatura() {
        return mapaPagamentosFicticiosAcme;
    }
}
