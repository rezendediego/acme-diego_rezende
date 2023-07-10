package br.com.acme_diego_rezende_atividade_02.domain;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;


@FunctionalInterface
public interface RegraTaxaManutencaoAssinatura {
    Double calculeTaxa(Assinatura assinatura);


}

