package br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy;

import br.com.acme_diego_rezende_atividade_02.model.Cliente;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.IPrecoMensalAssinatura;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.interfaces_strategy.ITipoAssinatura;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public abstract class Assinatura {
    protected IPrecoMensalAssinatura mensalidade;
    protected ITipoAssinatura tipoAssinatura;

    protected LocalDate inicio;
    protected Optional<LocalDate> fim;

    protected Cliente cliente;
    protected Boolean isInadimplente;

    protected Assinatura(){

    }

    public BigDecimal getMensalidade() {
        return mensalidade.getPrecoAssinatura();
    }

    public void setMensalidade(IPrecoMensalAssinatura mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getTipoAssinatura() {
        return tipoAssinatura.getTipoAssinatura();
    }

    public void setTipoAssinatura(ITipoAssinatura tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }


    public LocalDate getInicio() {
        return inicio;
    }

    public Optional<LocalDate> getFim() {
        return fim;
    }

    public void setFim(Optional<LocalDate> fim) {
        this.fim = fim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Boolean getInadimplente() {
        return isInadimplente;
    }

    public void setInadimplente(Boolean inadimplente) {
        isInadimplente = inadimplente;
    }

    @Override
    public String toString() {
        return "Assinatura{" +
                ", cliente=" + cliente +
                ", tipoAssinatura=" + tipoAssinatura.getTipoAssinatura() +
                ", precoMensalAssinatura=" + mensalidade +
                ", mensalidade=" + mensalidade +
                ", inicio=" + inicio +
                ", fim=" + fim +

                ", isInadimplente=" + isInadimplente +
                '}';
    }
}
