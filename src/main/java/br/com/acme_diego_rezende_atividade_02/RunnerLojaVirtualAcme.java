package br.com.acme_diego_rezende_atividade_02;


import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao.Infracao;
import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao.InfracaoInadimplenciaAssinatura;
import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_taxacao_assinatura.CriaMapaTaxacaoAssinaturaService;
import br.com.acme_diego_rezende_atividade_02.model.FaturaParaPagamentoAssinatura;
import br.com.acme_diego_rezende_atividade_02.repository.FaturasPagamentoAssinaturaRepository;
import br.com.acme_diego_rezende_atividade_02.utilitarios.config.AssinaturasAcmeConfig;
import br.com.acme_diego_rezende_atividade_02.utilitarios.config.ClientesAcmeConfig;
import br.com.acme_diego_rezende_atividade_02.utilitarios.config.FaturasPagamentoAssinaturaAcmeConfig;
import br.com.acme_diego_rezende_atividade_02.utilitarios.config.ProdutosAcmeConfig;
import br.com.acme_diego_rezende_atividade_02.model.Cliente;

import br.com.acme_diego_rezende_atividade_02.model.Produto;
import br.com.acme_diego_rezende_atividade_02.model.assinatura_strategy.Assinatura;
import br.com.acme_diego_rezende_atividade_02.repository.AssinaturaRepository;
import br.com.acme_diego_rezende_atividade_02.repository.ClienteRepository;
import br.com.acme_diego_rezende_atividade_02.repository.ProdutoRepository;
import br.com.acme_diego_rezende_atividade_02.utilitarios.Impressora;
import br.com.acme_diego_rezende_atividade_02.utilitarios.simuladores.SimuladorClientesInadimplentes;
import br.com.acme_diego_rezende_atividade_02.utilitarios.simuladores.SimuladorDeCompras;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RunnerLojaVirtualAcme {
    public static void main(String[] args) {
        Impressora impressora = new Impressora();

        impressora.imprimeEnunciado(" ### Criacao de Produtos, Clientes e Assinaturas Ficticias ###");
        ProdutoRepository produtoRepository = new ProdutoRepository();
        ProdutosAcmeConfig.configurarProdutosFicticios();
        List<Produto> produtosFicticiosAcme = produtoRepository.getTodosProdutos();
        impressora.imprime(produtosFicticiosAcme.toString());


        ClientesAcmeConfig.configurarClientesFicticios();
        List<Cliente> clientesFicticiosAcme = ClienteRepository.getTodosClientes();
        impressora.imprime(clientesFicticiosAcme.toString());

        impressora.imprimeEnunciado("### Crie 3 tipos de Assinatura ###");
        AssinaturaRepository assinaturaRepository = new AssinaturaRepository();
        AssinaturasAcmeConfig.configurarAssinaturasFicticias();
        Map<String, Assinatura> mapaAssinaturasFicticiasAcme = assinaturaRepository.getTodasAssinaturas();
        impressora.imprime(mapaAssinaturasFicticiasAcme.toString());

        impressora.imprimeEnunciado("### Crie um metodo para calcular uma taxa para cada Assinatura ###");
        CriaMapaTaxacaoAssinaturaService criaMapaTaxacaoAssinaturaService = new CriaMapaTaxacaoAssinaturaService();
        Map<String, Map<String, Double>> mapaClientePorTaxaSobreAssinatura = criaMapaTaxacaoAssinaturaService.apply(mapaAssinaturasFicticiasAcme);
        impressora.imprime(mapaClientePorTaxaSobreAssinatura.toString());

        FaturasPagamentoAssinaturaAcmeConfig.configurarPagamentoAssinaturaFicticios();
        Map<String, FaturaParaPagamentoAssinatura> mapaClientePorFaturaParaPagamentoAssinatura = FaturasPagamentoAssinaturaRepository.getTodasFaturasPagamentoAssinatura();
        impressora.imprime(mapaClientePorFaturaParaPagamentoAssinatura.toString());

        impressora.imprimeEnunciado("### Crie um atributo para controlar assinaturas com atraso de pagamento ###");
        Map<String, FaturaParaPagamentoAssinatura> faturasInadimplentesSimuladas = new HashMap<>();
        try{
            SimuladorClientesInadimplentes simuladorClientesInadimplentes = new SimuladorClientesInadimplentes();
            faturasInadimplentesSimuladas = simuladorClientesInadimplentes.simulaAssinaturaInadimplente(FaturasPagamentoAssinaturaRepository.getTodasFaturasPagamentoAssinatura());
        }catch (NoSuchAlgorithmException e){
            impressora.imprimeAlertaException(e.getMessage());
        }
        impressora.imprime(faturasInadimplentesSimuladas.toString());

        impressora.imprimeEnunciado("### Crie um mecanismo para validar clientes ###");
        InfracaoInadimplenciaAssinatura infracaoInadimplenciaAssinatura = new InfracaoInadimplenciaAssinatura();
        List<Infracao> listInfracoesVerificaveis = new ArrayList<>();
        listInfracoesVerificaveis.add(infracaoInadimplenciaAssinatura);

        SimuladorDeCompras simuladorDeCompras = new SimuladorDeCompras(faturasInadimplentesSimuladas, listInfracoesVerificaveis);
        simuladorDeCompras.realizeComprasFicticias();

    }
}