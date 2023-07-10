package br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.IPrecoMensalAssinatura;

import java.math.BigDecimal;

public class PrecoMensalidadeJulho2023 implements IPrecoMensalAssinatura {
    private final BigDecimal preco;

    public PrecoMensalidadeJulho2023(BigDecimal precoMensalidadeJulho2023) {
        this.preco = precoMensalidadeJulho2023;
    }

    @Override
    public BigDecimal getPrecoAssinatura() {
        return preco;
    }

    @Override
    public String toString() {
        return "PrecoMensalidadeJulho2023{ "
                + preco
                + " }";
    }
}
