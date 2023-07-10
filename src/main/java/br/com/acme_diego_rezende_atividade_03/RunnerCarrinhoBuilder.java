package br.com.acme_diego_rezende_atividade_03;

import br.com.acme_diego_rezende_atividade_03.builder.CarrinhoBuilder;
import br.com.acme_diego_rezende_atividade_03.model.Cliente;
import br.com.acme_diego_rezende_atividade_03.model.Produto;
import br.com.acme_diego_rezende_atividade_03.repository.ClienteRepository;
import br.com.acme_diego_rezende_atividade_03.repository.ProdutoRepository;
import br.com.acme_diego_rezende_atividade_03.utilitarios.Impressora;
import br.com.acme_diego_rezende_atividade_03.utilitarios.config.ClientesAcmeConfig;
import br.com.acme_diego_rezende_atividade_03.utilitarios.config.ProdutosAcmeConfig;

import java.util.List;

public class RunnerCarrinhoBuilder {
    public static void main(String[] args) {

        Impressora impressora = new Impressora();

        impressora.imprimeEnunciado(" ### Criacao de Produtos e Clientes Ficticios ###");
        ProdutoRepository produtoRepository;
        produtoRepository = new ProdutoRepository();
        ProdutosAcmeConfig.configurarProdutosFicticios();
        List<Produto> produtosFicticiosAcme = produtoRepository.getTodosProdutos();
        impressora.imprime(produtosFicticiosAcme.toString());


        ClientesAcmeConfig.configurarClientesFicticios();
        List<Cliente> clientesFicticiosAcme = ClienteRepository.getTodosClientes();
        impressora.imprime(clientesFicticiosAcme.toString());


        CarrinhoBuilder compra01 = new CarrinhoBuilder.Builder()
                .setCliente(clientesFicticiosAcme.get(0))
                .addProduto(produtosFicticiosAcme.get(1))
                .addProduto(produtosFicticiosAcme.get(6))
                .setMeioDePagamento("cartao")
                .setIsAutorizada(true)
                .build();
        impressora.imprime(compra01.toString());



        CarrinhoBuilder compra02 = new CarrinhoBuilder.Builder()
                .setCliente(clientesFicticiosAcme.get(3))
                .addProduto(produtosFicticiosAcme.get(9))
                .setMeioDePagamento("pix")
                .setIsAutorizada(false)
                .build();
        impressora.imprime(compra02.toString());

        CarrinhoBuilder compra03 = new CarrinhoBuilder.Builder()
                .setCliente(clientesFicticiosAcme.get(7))
                .addProduto(produtosFicticiosAcme.get(0))
                .addProduto(produtosFicticiosAcme.get(1))
                .addProduto(produtosFicticiosAcme.get(2))
                .addProduto(produtosFicticiosAcme.get(3))
                .addProduto(produtosFicticiosAcme.get(4))
                .addProduto(produtosFicticiosAcme.get(5))
                .addProduto(produtosFicticiosAcme.get(6))
                .addProduto(produtosFicticiosAcme.get(7))
                .addProduto(produtosFicticiosAcme.get(8))
                .addProduto(produtosFicticiosAcme.get(9))
                .setMeioDePagamento("boleto")
                .setIsAutorizada(true)
                .build();

        impressora.imprime(compra03.toString());


    }
}