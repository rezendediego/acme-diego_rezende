package br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.ITipoAssinatura;

public class TipoSemestral  implements ITipoAssinatura {
    public TipoSemestral() {
        this.getTipoAssinatura();
    }

    @Override
    public String getTipoAssinatura() {
        return "SEMESTRAL";
    }
}
