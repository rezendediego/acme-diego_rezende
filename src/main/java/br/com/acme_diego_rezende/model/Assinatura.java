package br.com.acme_diego_rezende.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class Assinatura {
    private BigDecimal mensalidade;
    private final LocalDate inicio;
    private Optional<LocalDate> fim;
    private Cliente cliente;

    public Assinatura(BigDecimal mensalidade, LocalDate begin, Optional<LocalDate> end, br.com.acme_diego_rezende.model.Cliente cliente) {
        this.mensalidade = mensalidade;
        this.inicio = begin;
        this.fim = end;
        this.cliente = cliente;
    }

    public Assinatura(BigDecimal mensalidade, LocalDate begin, br.com.acme_diego_rezende.model.Cliente cliente) {
        this.mensalidade = mensalidade;
        this.inicio = begin;
        this.fim = Optional.empty();
        this.cliente = cliente;
    }


    public BigDecimal getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(BigDecimal mensalidade) {
        this.mensalidade = mensalidade;
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

    public br.com.acme_diego_rezende.model.Cliente getCliente() {
        return cliente;
    }


    @Override
    public String toString() {
        return "Assinatura{" +
                "mensalidade=" + mensalidade +
                ", begin=" + inicio +
                ", end=" + fim +
                ", Cliente=" + cliente +
                '}';
    }
}
