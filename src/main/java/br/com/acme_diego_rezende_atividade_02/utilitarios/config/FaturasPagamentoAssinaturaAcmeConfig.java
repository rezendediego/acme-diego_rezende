package br.com.acme_diego_rezende_atividade_02.utilitarios.config;

import br.com.acme_diego_rezende_atividade_02.model.Cliente;
import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoAssinatura;
import br.com.acme_diego_rezende_atividade_02.repository.ClienteRepository;
import br.com.acme_diego_rezende_atividade_02.repository.FaturasPagamentoAssinaturaRepository;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class FaturasPagamentoAssinaturaAcmeConfig {
    static List<Cliente> clientesAcme = ClienteRepository.getTodosClientes();

    private FaturasPagamentoAssinaturaAcmeConfig() {
    }

    public static List<FaturaParaPagamentoAssinatura> criarListaFaturasPagamentosAssinaturaFicticios(){

        FaturaParaPagamentoAssinatura compra01 = new FaturaParaPagamentoAssinatura(clientesAcme.get(0), Month.JULY);
        FaturaParaPagamentoAssinatura compra02 = new FaturaParaPagamentoAssinatura(clientesAcme.get(1), Month.JULY);
        FaturaParaPagamentoAssinatura compra03 = new FaturaParaPagamentoAssinatura(clientesAcme.get(2), Month.JULY);
        FaturaParaPagamentoAssinatura compra04 = new FaturaParaPagamentoAssinatura(clientesAcme.get(3), Month.JULY);
        FaturaParaPagamentoAssinatura compra05 = new FaturaParaPagamentoAssinatura(clientesAcme.get(4), Month.JULY);
        FaturaParaPagamentoAssinatura compra06 = new FaturaParaPagamentoAssinatura(clientesAcme.get(5), Month.JULY);
        FaturaParaPagamentoAssinatura compra07 = new FaturaParaPagamentoAssinatura(clientesAcme.get(6), Month.JULY);
        FaturaParaPagamentoAssinatura compra08 = new FaturaParaPagamentoAssinatura(clientesAcme.get(7), Month.JULY);
        FaturaParaPagamentoAssinatura compra09 = new FaturaParaPagamentoAssinatura(clientesAcme.get(8), Month.JULY);
        FaturaParaPagamentoAssinatura compra10 = new FaturaParaPagamentoAssinatura(clientesAcme.get(9), Month.JULY);


        List<FaturaParaPagamentoAssinatura> listaFaturaParaPagamentoCompra = new ArrayList<>();
        listaFaturaParaPagamentoCompra.add(compra01);
        listaFaturaParaPagamentoCompra.add(compra02);
        listaFaturaParaPagamentoCompra.add(compra03);
        listaFaturaParaPagamentoCompra.add(compra04);
        listaFaturaParaPagamentoCompra.add(compra05);
        listaFaturaParaPagamentoCompra.add(compra06);
        listaFaturaParaPagamentoCompra.add(compra07);
        listaFaturaParaPagamentoCompra.add(compra08);
        listaFaturaParaPagamentoCompra.add(compra09);
        listaFaturaParaPagamentoCompra.add(compra10);

        return listaFaturaParaPagamentoCompra;

    }

    public static void adicionarPagamentoAssinaturaRepository(List<FaturaParaPagamentoAssinatura> listaFaturas){
        listaFaturas.stream()
                .forEach(FaturasPagamentoAssinaturaRepository::criarFaturaParaPagamentoAssinatura);
    }

    public static void configurarPagamentoAssinaturaFicticios() {
        adicionarPagamentoAssinaturaRepository(criarListaFaturasPagamentosAssinaturaFicticios());
    }


}
