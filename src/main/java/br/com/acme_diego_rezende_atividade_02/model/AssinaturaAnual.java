package br.com.acme_diego_rezende_atividade_02.model;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.TipoAnual;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.IPrecoMensalAssinatura;

import java.time.LocalDate;
import java.util.Optional;

public class AssinaturaAnual  extends Assinatura {
    public AssinaturaAnual(
            LocalDate inicio,
            Cliente cliente,
            IPrecoMensalAssinatura precoMensalAssinatura ) {
        super();
        this.setTipoAssinatura(new TipoAnual());
        this.inicio = inicio;
        this.setFim(Optional.of(this.inicio.plusMonths(12)));
        this.cliente = cliente;
        this.mensalidade = precoMensalAssinatura;
        this.setInadimplente(false);
    }

    public AssinaturaAnual(
            Cliente cliente,
            IPrecoMensalAssinatura precoMensalAssinatura ) {
        super();
        this.setTipoAssinatura(new TipoAnual());
        this.inicio = LocalDate.now();
        this.setFim(Optional.of(this.inicio.plusMonths(12)));
        this.cliente = cliente;
        this.mensalidade = precoMensalAssinatura;
        this.setInadimplente(false);
    }
}
