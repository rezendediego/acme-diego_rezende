package br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.ITipoAssinatura;

public class TipoAnual  implements ITipoAssinatura {
    public TipoAnual() {
        this.getTipoAssinatura();
    }

    @Override
    public String getTipoAssinatura() {
        return "ANUAL";
    }
}
