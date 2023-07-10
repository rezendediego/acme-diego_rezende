package br.com.acme_diego_rezende_atividade_02.utilitarios.simuladores;


import br.com.acme_diego_rezende_atividade_02.exception.FalhaNoGeradorRandomException;
import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoAssinatura;
import br.com.acme_diego_rezende_atividade_02.utilitarios.repositorio_suporte.FaturasInadimplentesSimuladasSuporteRepository;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.UnaryOperator;


public class SimuladorClientesInadimplentes {
    private static Random randomIsClienteInadimplente;

    static {
        try {
            randomIsClienteInadimplente = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new FalhaNoGeradorRandomException("Falha na obtencao de uma instancia de SecureRandom.");
        }
    }

    static Map<String, FaturaParaPagamentoAssinatura> mapaSimuladoRetorno = new HashMap<>();
    static UnaryOperator<Map<String, FaturaParaPagamentoAssinatura>> simulaAssinaturaInadimplente =
            mapaFaturas -> {
                mapaFaturas.forEach(
                            (chaveNome,fatura) -> {
                                FaturaParaPagamentoAssinatura faturaSimulada = new FaturaParaPagamentoAssinatura(fatura.getCliente(), fatura.getMesFaturado());
                                faturaSimulada.setPago(randomIsClienteInadimplente.nextBoolean());
                                mapaSimuladoRetorno.put(
                                        faturaSimulada.getCliente().getNome(),
                                        faturaSimulada);
            });
           return mapaSimuladoRetorno;
    };



    public Map<String, FaturaParaPagamentoAssinatura> simulaAssinaturaInadimplente(Map<String, FaturaParaPagamentoAssinatura> todasFaturasPagamentoAssinatura) throws NoSuchAlgorithmException {
        Map<String, FaturaParaPagamentoAssinatura> simuladas = simulaAssinaturaInadimplente.apply(todasFaturasPagamentoAssinatura);
        FaturasInadimplentesSimuladasSuporteRepository.setArmazenadorDeFaturasInadimplentesSimuladas(simuladas);
        return simuladas;

    }

}


