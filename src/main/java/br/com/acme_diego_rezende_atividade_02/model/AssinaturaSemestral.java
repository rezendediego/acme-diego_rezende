package br.com.acme_diego_rezende_atividade_02.model;

import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.TipoSemestral;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.IPrecoMensalAssinatura;

import java.time.LocalDate;
import java.util.Optional;

public class AssinaturaSemestral  extends Assinatura {
    public AssinaturaSemestral(
            LocalDate inicio,
            Cliente cliente,
            IPrecoMensalAssinatura precoMensalAssinatura ) {
        super();
        this.setTipoAssinatura(new TipoSemestral());
        this.inicio = inicio;
        this.setFim(Optional.of(this.inicio.plusMonths(6)));
        this.cliente = cliente;
        this.mensalidade = precoMensalAssinatura;
        this.setInadimplente(false);
    }

    public AssinaturaSemestral(
            Cliente cliente,
            IPrecoMensalAssinatura precoMensalAssinatura ) {
        super();
        this.setTipoAssinatura(new TipoSemestral());
        this.inicio = LocalDate.now();
        this.setFim(Optional.of(this.inicio.plusMonths(6)));
        this.cliente = cliente;
        this.mensalidade = precoMensalAssinatura;
        this.setInadimplente(false);
    }
}
