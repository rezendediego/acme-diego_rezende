package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_taxacao_assinatura;


import br.com.acme_diego_rezende_atividade_02.domain.RegraTaxaManutencaoAssinatura;
import br.com.acme_diego_rezende_atividade_02.model.*;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.*;


public class AplicaRegraTaxaManutencaoAssinaturaService implements RegraTaxaManutencaoAssinatura {

    private ToIntFunction<Assinatura> calcularTempoAssinaturaEmMeses = assinatura ->
            Math.toIntExact(ChronoUnit.MONTHS.between(assinatura.getInicio(), LocalDate.now()));

    private ToDoubleFunction<Assinatura> calcularValorTotalPagoPorAssinatura = assinatura -> {
        Integer tempoEmMeses =  calcularTempoAssinaturaEmMeses.applyAsInt(assinatura);
        return tempoEmMeses * assinatura.getMensalidade().doubleValue();
    };

    private ToDoubleBiFunction<Double, TaxaSobreAssinatura> aplicarTaxaSobreAssinatura = (
            valorTotalPagoPorAssinatura,
            porcentagemTaxaSobreAssinatura) -> {

        Optional<Double> taxaAplicavel = Optional.of(
                    porcentagemTaxaSobreAssinatura.getTaxaSobreAssinatura().orElse(0.0));

        return valorTotalPagoPorAssinatura * (taxaAplicavel.get()/Integer.valueOf(100));

    };

    private RegraTaxaManutencaoAssinatura fornecerTaxaParaCadaAssinatura = assinatura -> {

        Predicate<Assinatura> isAnual = assinaturaAnual -> assinaturaAnual.getTipoAssinatura().equals("ANUAL");
        Predicate<Assinatura> isSemestral = assinaturaSemestral -> assinaturaSemestral.getTipoAssinatura().equals("SEMESTRAL");
        Predicate<Assinatura> isTrimestral = assinaturaTrimestral -> assinaturaTrimestral.getTipoAssinatura().equals("TRIMESTRAL");

        TaxaSobreAssinatura taxaAnualSobreAssinatura = new TaxaAnualSobreAssinatura();
        TaxaSobreAssinatura taxaSemestralSobreAssinatura = new TaxaSemestralSobreAssinatura();
        TaxaSobreAssinatura taxaTrimestralSobreAssinatura = new TaxaTrimestralSobreAssinatura();

        return Optional.of(assinatura)
                .filter(isAnual)
                .map(assinaturaAnualDetectada -> aplicarTaxaSobreAssinatura.applyAsDouble(
                        calcularValorTotalPagoPorAssinatura.applyAsDouble(assinaturaAnualDetectada),
                        taxaAnualSobreAssinatura))
                .orElseGet(() -> Optional.of(assinatura)
                        .filter(isSemestral)
                        .map(assinaturaSemestralDetectada -> aplicarTaxaSobreAssinatura.applyAsDouble(
                                calcularValorTotalPagoPorAssinatura.applyAsDouble(assinaturaSemestralDetectada),
                                taxaSemestralSobreAssinatura))
                                .orElseGet(() -> Optional.of(assinatura)
                                                .filter(isTrimestral)
                                                .map(assinaturaTrimestralDetectada -> aplicarTaxaSobreAssinatura.applyAsDouble(
                                                        calcularValorTotalPagoPorAssinatura.applyAsDouble(assinaturaTrimestralDetectada),
                                                        taxaTrimestralSobreAssinatura))
                                        .orElse(0.0)));

    };


    @Override
    public Double calculeTaxa(Assinatura assinatura) {

        return fornecerTaxaParaCadaAssinatura.calculeTaxa(assinatura);
    }


}