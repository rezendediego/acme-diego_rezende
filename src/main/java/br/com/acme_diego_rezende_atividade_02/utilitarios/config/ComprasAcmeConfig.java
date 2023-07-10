package br.com.acme_diego_rezende_atividade_02.utilitarios.config;

import br.com.acme_diego_rezende_atividade_02.model.Compra;
import br.com.acme_diego_rezende_atividade_02.repository.ClienteRepository;
import br.com.acme_diego_rezende_atividade_02.repository.ProdutoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComprasAcmeConfig {
    private ComprasAcmeConfig() {
    }

    public static List<Compra> criarComprasFicticias(){

       final String pagaComCartao = "cartao";
       final String pagaComBoleto = "boleto";
       final String pagaComPix = "pix";

       Compra compraAndre = new Compra(
            ClienteRepository.getClientePorNome("andre"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(3), ProdutoRepository.getProdutoPorID(4), ProdutoRepository.getProdutoPorID(8)),
            pagaComPix,
            LocalDate.of(2023,6,15));

       Compra compraBruno = new Compra(
            ClienteRepository.getClientePorNome("bruno"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(1), ProdutoRepository.getProdutoPorID(9), ProdutoRepository.getProdutoPorID(5)),
            pagaComBoleto,
            LocalDate.of(2023,5,30));

       Compra compraCarlos = new Compra(
            ClienteRepository.getClientePorNome("carlos"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(3), ProdutoRepository.getProdutoPorID(4), ProdutoRepository.getProdutoPorID(1)),
            pagaComCartao,
            LocalDate.of(2023,2,28));

       Compra compraDiego = new Compra(
            ClienteRepository.getClientePorNome("diego"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(0), ProdutoRepository.getProdutoPorID(1), ProdutoRepository.getProdutoPorID(2)),
            pagaComCartao);

       Compra compraElton = new Compra(
            ClienteRepository.getClientePorNome("elton"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(6), ProdutoRepository.getProdutoPorID(7), ProdutoRepository.getProdutoPorID(8)),
            pagaComBoleto,
            LocalDate.of(2023,3,23));

       Compra compraFlavia = new Compra(
            ClienteRepository.getClientePorNome("flavia"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(9)),
            pagaComPix,
            LocalDate.of(2020,7,3));

       Compra compraGabriela = new Compra(
            ClienteRepository.getClientePorNome("gabriela"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(7), ProdutoRepository.getProdutoPorID(6)),
            pagaComPix,
            LocalDate.of(2022,11,2));

       Compra compraHeloisa = new Compra(
            ClienteRepository.getClientePorNome("heloisa"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(5), ProdutoRepository.getProdutoPorID(4), ProdutoRepository.getProdutoPorID(6)),
            pagaComCartao,
            LocalDate.of(2022,8,15));

       Compra compraIrene = new Compra(
            ClienteRepository.getClientePorNome("irene"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(1), ProdutoRepository.getProdutoPorID(8), ProdutoRepository.getProdutoPorID(6)),
            pagaComBoleto);

       Compra compraJanaina = new Compra(
            ClienteRepository.getClientePorNome("janaina"),
            Arrays.asList(ProdutoRepository.getProdutoPorID(2), ProdutoRepository.getProdutoPorID(4)),
            pagaComPix,
            LocalDate.of(2023,7,1));



       List<Compra> listaComprasFicticias = new ArrayList<>();
       listaComprasFicticias.add(compraAndre);
       listaComprasFicticias.add(compraBruno);
       listaComprasFicticias.add(compraCarlos);
       listaComprasFicticias.add(compraDiego);
       listaComprasFicticias.add(compraElton);
       listaComprasFicticias.add(compraFlavia);
       listaComprasFicticias.add(compraGabriela);
       listaComprasFicticias.add(compraHeloisa);
       listaComprasFicticias.add(compraIrene);
       listaComprasFicticias.add(compraJanaina);


       return listaComprasFicticias;

   }
}
