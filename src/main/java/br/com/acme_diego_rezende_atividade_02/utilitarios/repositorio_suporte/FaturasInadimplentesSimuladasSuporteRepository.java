package br.com.acme_diego_rezende_atividade_02.utilitarios.repositorio_suporte;

import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoAssinatura;

import java.util.HashMap;
import java.util.Map;

public class FaturasInadimplentesSimuladasSuporteRepository {
    static Map<String, FaturaParaPagamentoAssinatura> armazenadorDeFaturasInadimplentesSimuladas = new HashMap<>();

    private FaturasInadimplentesSimuladasSuporteRepository() {
    }

    public static Map<String, FaturaParaPagamentoAssinatura> getArmazenadorDeFaturasInadimplentesSimuladas() {
        return armazenadorDeFaturasInadimplentesSimuladas;
    }

    public static void setArmazenadorDeFaturasInadimplentesSimuladas(Map<String, FaturaParaPagamentoAssinatura> armazenadorDeFaturasInadimplentesSimuladas) {
        FaturasInadimplentesSimuladasSuporteRepository.armazenadorDeFaturasInadimplentesSimuladas = armazenadorDeFaturasInadimplentesSimuladas;
    }
}
