package br.com.acme_diego_rezende_atividade_02.model;

import java.util.Optional;

public class TaxaTrimestralSobreAssinatura implements TaxaSobreAssinatura{
    private final Optional<Double> taxaTrimestral = Optional.of(5.0);
    public TaxaTrimestralSobreAssinatura() {
        this.getTaxaSobreAssinatura();
    }
    @Override
    public Optional<Double> getTaxaSobreAssinatura() {
        return taxaTrimestral;
    }
}
