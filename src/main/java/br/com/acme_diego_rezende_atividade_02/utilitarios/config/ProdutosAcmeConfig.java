package br.com.acme_diego_rezende_atividade_02.utilitarios.config;

import br.com.acme_diego_rezende_atividade_02.model.Produto;
import br.com.acme_diego_rezende_atividade_02.repository.ProdutoRepository;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProdutosAcmeConfig {
    private ProdutosAcmeConfig() {
    }

    public static List<Produto> criarListaProdutosFicticios() {
        final BigDecimal precoMusica = new BigDecimal("5.37");
        final BigDecimal precoFilme = new BigDecimal("8.90");
        final BigDecimal precoFotografia = new BigDecimal("10000.00");

        Produto paranoid = new Produto("paranoid",
                Paths.get("acme\\produtos\\musicas\\black-sabbath\\paranoid\\paranoid"),
                precoMusica);
        Produto aceOfSpades = new Produto("aceOfSpades",
                Paths.get("acme\\produtos\\musicas\\motorhead\\aceOfSpades\\aceOfSpades"),
                precoMusica);
        Produto epidemic = new Produto("epidemic",
                Paths.get("acme\\produtos\\musicas\\motorhead\\rainingBlood\\epidemic"),
                precoMusica);
        Produto terraEmTranse = new Produto("terraEmTranse",
                Paths.get("acme\\produtos\\videos\\cinema-novo\\terraEmTranse"),
                precoFilme);
        Produto cabraMarcadoParaMorrer = new Produto("cabraMarcadoParaMorrer",
                Paths.get("acme\\produtos\\videos\\anos80\\cabraMarcadoParaMorrer"),
                precoFilme);
        Produto centralDoBrasil = new Produto("centralDoBrasil",
                Paths.get("acme\\produtos\\videos\\retomada\\centralDoBrasil"),
                precoFilme);
        Produto vendedorDeSonhos = new Produto("vendedorDeSonhos",
                Paths.get("acme\\produtos\\imagens\\walter-firmo\\vendedorDeSonhos"),
                precoFotografia);
        Produto cabalgata = new Produto("cabalgata",
                Paths.get("acme\\produtos\\imagens\\walter-firmo\\cabalgata"),
                precoFotografia);
        Produto kuikuroWarriors = new Produto("kuikuroWarriors",
                Paths.get("acme\\produtos\\imagens\\sebastiao-salgado\\kuikuroWarriors"),
                precoFotografia);
        Produto serraPelada = new Produto("serraPelada",
                Paths.get("acme\\produtos\\imagens\\sebastiao-salgado\\serraPelada"),
                precoFotografia);

        List<Produto> produtosAcme = new ArrayList<>();
        produtosAcme.add(paranoid);
        produtosAcme.add(aceOfSpades);
        produtosAcme.add(epidemic);
        produtosAcme.add(terraEmTranse);
        produtosAcme.add(cabraMarcadoParaMorrer);
        produtosAcme.add(centralDoBrasil);
        produtosAcme.add(vendedorDeSonhos);
        produtosAcme.add(cabalgata);
        produtosAcme.add(kuikuroWarriors);
        produtosAcme.add(serraPelada );

        return produtosAcme;
    }
    public static void adicionarProdutosRepository(List<Produto> listaProdutos){
        listaProdutos.stream()
                .forEach(ProdutoRepository::criarProduto);
    }

    public static void configurarProdutosFicticios() {
        adicionarProdutosRepository(criarListaProdutosFicticios());
    }
}
