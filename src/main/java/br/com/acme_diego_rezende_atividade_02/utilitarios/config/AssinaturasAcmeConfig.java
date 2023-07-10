package br.com.acme_diego_rezende_atividade_02.utilitarios.config;

import br.com.acme_diego_rezende_atividade_02.model.AssinaturaAnual;
import br.com.acme_diego_rezende_atividade_02.model.AssinaturaSemestral;
import br.com.acme_diego_rezende_atividade_02.model.AssinaturaTrimestral;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.PrecoMensalidadeJulho2023;
import br.com.acme_diego_rezende_atividade_02.repository.AssinaturaRepository;
import br.com.acme_diego_rezende_atividade_02.repository.ClienteRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AssinaturasAcmeConfig {
    static PrecoMensalidadeJulho2023 precoMensalidadeJulho2023 = new PrecoMensalidadeJulho2023(new BigDecimal("99.98"));

    private AssinaturasAcmeConfig() {
    }

    public static List<Assinatura> criarListaAssinaturasFicticias() {

        Assinatura assinaturaAndre = new AssinaturaAnual(
                LocalDate.of(2021,6,6),
                ClienteRepository.getClientePorID(0),
                precoMensalidadeJulho2023);

        Assinatura assinaturaBruno = new AssinaturaSemestral(
                LocalDate.of(2022,3,16),
                ClienteRepository.getClientePorID(1),
                precoMensalidadeJulho2023);

        Assinatura assinaturaCarlos = new AssinaturaTrimestral(
                LocalDate.of(2023,1,1),
                ClienteRepository.getClientePorID(2),
                precoMensalidadeJulho2023);

        Assinatura assinaturaDiego = new AssinaturaTrimestral(
                LocalDate.of(2018,11,23),
                ClienteRepository.getClientePorID(3),
                precoMensalidadeJulho2023);

        Assinatura assinaturaElton = new AssinaturaAnual(
                ClienteRepository.getClientePorID(4),
                precoMensalidadeJulho2023);

        Assinatura assinaturaFlavia = new AssinaturaAnual(
                LocalDate.of(2023,4,27),
                ClienteRepository.getClientePorID(5),
                precoMensalidadeJulho2023);

        Assinatura assinaturaGabriela = new AssinaturaAnual(
                LocalDate.of(2021,2,28),
                ClienteRepository.getClientePorID(6),
                precoMensalidadeJulho2023);

        Assinatura assinaturaHeloisa = new AssinaturaSemestral(
                LocalDate.of(2003,5,18),
                ClienteRepository.getClientePorID(7),
                precoMensalidadeJulho2023);

        Assinatura assinaturaIrene = new AssinaturaSemestral(
                LocalDate.of(2022,9,18),
                ClienteRepository.getClientePorID(8),
                precoMensalidadeJulho2023);

        Assinatura assinaturaJanaina = new AssinaturaSemestral(
                LocalDate.of(2021,7,7),
                ClienteRepository.getClientePorID(9),
                precoMensalidadeJulho2023);

        List<Assinatura> listaAssinatura = new ArrayList<>();
        listaAssinatura.add(assinaturaAndre);
        listaAssinatura.add(assinaturaBruno);
        listaAssinatura.add(assinaturaCarlos);
        listaAssinatura.add(assinaturaDiego);
        listaAssinatura.add(assinaturaElton);
        listaAssinatura.add(assinaturaFlavia);
        listaAssinatura.add(assinaturaGabriela);
        listaAssinatura.add(assinaturaHeloisa);
        listaAssinatura.add(assinaturaIrene);
        listaAssinatura.add(assinaturaJanaina);

        return listaAssinatura;
    }

    public static void adicionarAssinaturaRepository(List<Assinatura> listaAssinaturas){
        listaAssinaturas.stream()
                .forEach(AssinaturaRepository::criarAssinatura);
    }
    public static void configurarAssinaturasFicticias() {
        adicionarAssinaturaRepository(criarListaAssinaturasFicticias());
    }
}
