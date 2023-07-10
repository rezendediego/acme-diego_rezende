package br.com.acme_diego_rezende_atividade_02.repository;

import br.com.acme_diego_rezende_atividade_02.model.Cliente;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;

import java.util.HashMap;
import java.util.Map;


public class AssinaturaRepository {
    private static Map<String,Assinatura> mapaClientePorAssinatura = new HashMap<>();


    public static void criarAssinatura(Assinatura assinatura) {
        mapaClientePorAssinatura.put(
                assinatura.getCliente().getNome(),
                assinatura);
    }


    public void apagarAssinatura(Cliente cliente) {
        mapaClientePorAssinatura.remove(cliente.getNome());
    }


    public static Assinatura getAssinaturaPorCliente(Cliente cliente) {
        return mapaClientePorAssinatura.get(cliente.getNome());
    }


    public Map<String, Assinatura> getTodasAssinaturas() {
        return mapaClientePorAssinatura;
    }
}
