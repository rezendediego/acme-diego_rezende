package br.com.acme_diego_rezende_atividade_02.model;

import br.com.acme_diego_rezende_atividade_02.repository.AssinaturaRepository;

import java.time.LocalDate;
import java.time.Month;

public class FaturaParaPagamentoAssinatura {
    private final Cliente cliente;
    private final LocalDate inicioAssinatura;
    private final Month mesFaturado;
    private final LocalDate vencimentoContaAssinatura;
    private Boolean isPago;


    public FaturaParaPagamentoAssinatura(Cliente cliente, Month mesFaturado) {
        this.cliente = cliente;
        inicioAssinatura = AssinaturaRepository.getAssinaturaPorCliente(this.cliente).getInicio();
        this.mesFaturado = mesFaturado;
        vencimentoContaAssinatura = LocalDate.of(
                LocalDate.now().getYear(),
                mesFaturado,
                inicioAssinatura.getDayOfMonth());
        isPago = true;
    }

    public void setPago(Boolean pago) {
        isPago = pago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getInicioAssinatura() {
        return inicioAssinatura;
    }

    public Month getMesFaturado() {
        return mesFaturado;
    }

    public LocalDate getVencimentoContaAssinatura() {
        return vencimentoContaAssinatura;
    }

    public Boolean getPago() {
        return isPago;
    }


    @Override
    public String toString() {
        return "FaturaParaPagamentoAssinatura{" +
                "cliente=" + cliente +
                ", inicioAssinatura=" + inicioAssinatura +
                ", mesFaturado=" + mesFaturado +
                ", vencimentoContaAssinatura=" + vencimentoContaAssinatura +
                ", isPago=" + isPago +
                '}';
    }
}
