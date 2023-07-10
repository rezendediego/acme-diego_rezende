package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_taxacao_assinatura;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CriaMapaTaxacaoAssinaturaService implements  Function<Map<String, Assinatura>, Map<String,Map<String,Double>>> {
    AplicaRegraTaxaManutencaoAssinaturaService aplicaRegraTaxaManutencaoAssinaturaService = new AplicaRegraTaxaManutencaoAssinaturaService();


    Function<Map<String, Assinatura>, Map<String,Map<String,Double>>>  criaMapaClientePorTaxaSobreAssinatura = mapaAssinaturas -> {
        Map<String, Map<String,Double>> mapaClientePorTaxaSobreAssinatura = new HashMap<>();
        mapaAssinaturas.forEach(
                (nomeCliente,assinatura) -> {
                    Map<String, Double> mapaTipoAssinaturaPorValorTaxa = new HashMap<>();
                    Double valorAPagar = aplicaRegraTaxaManutencaoAssinaturaService.calculeTaxa(assinatura);
                    mapaTipoAssinaturaPorValorTaxa.put(assinatura.getTipoAssinatura(), valorAPagar );
                    mapaClientePorTaxaSobreAssinatura.put(nomeCliente,mapaTipoAssinaturaPorValorTaxa);
                });
        return mapaClientePorTaxaSobreAssinatura;
    };


    @Override
    public  Map<String,Map<String,Double>> apply(Map<String, Assinatura> stringAssinaturaMap) {
        return criaMapaClientePorTaxaSobreAssinatura.apply(stringAssinaturaMap);
    }
}
