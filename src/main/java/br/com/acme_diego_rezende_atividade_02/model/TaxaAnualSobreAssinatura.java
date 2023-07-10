package br.com.acme_diego_rezende_atividade_02.model;

import java.util.Optional;

public class TaxaAnualSobreAssinatura implements TaxaSobreAssinatura{
    private final Optional<Double> taxaAnual = Optional.empty();

    public TaxaAnualSobreAssinatura() {
        this.getTaxaSobreAssinatura();
    }

    @Override
    public Optional<Double> getTaxaSobreAssinatura() {
        return taxaAnual;
    }
}
