package br.com.acme_diego_rezende_atividade_02.model;

import java.util.Optional;

public class TaxaSemestralSobreAssinatura implements TaxaSobreAssinatura{
    private final Optional<Double> taxaSemestral = Optional.of(3.0);

    public TaxaSemestralSobreAssinatura() {
        this.getTaxaSobreAssinatura();
    }

    @Override
    public Optional<Double> getTaxaSobreAssinatura() {
        return taxaSemestral;
    }
}
