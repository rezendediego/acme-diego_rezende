package br.com.acme_diego_rezende_atividade_02.model;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.TipoTrimestral;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.IPrecoMensalAssinatura;

import java.time.LocalDate;
import java.util.Optional;

public class AssinaturaTrimestral extends Assinatura {
    public AssinaturaTrimestral(
            LocalDate inicio,
            Cliente cliente,
            IPrecoMensalAssinatura precoMensalAssinatura ) {
        super();
        this.setTipoAssinatura(new TipoTrimestral());
        this.inicio = inicio;
        this.setFim(Optional.of(this.inicio.plusMonths(3)));
        this.cliente = cliente;
        this.mensalidade = precoMensalAssinatura;
        this.setInadimplente(false);
    }

    public AssinaturaTrimestral(
            Cliente cliente,
            IPrecoMensalAssinatura precoMensalAssinatura ) {
        super();
        this.setTipoAssinatura(new TipoTrimestral());
        this.inicio = LocalDate.now();
        this.setFim(Optional.of(this.inicio.plusMonths(3)));
        this.cliente = cliente;
        this.mensalidade = precoMensalAssinatura;
        this.setInadimplente(false);
    }

}
