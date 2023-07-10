package br.com.acme_diego_rezende_atividade_02.repository;

import br.com.acme_diego_rezende_atividade_02.model.Produto;

import java.util.ArrayList;
import java.util.List;


public class ProdutoRepository {
    static List<Produto> listaProdutosFicticiosAcme = new ArrayList<>();

    public static void criarProduto(Produto produto) {
        listaProdutosFicticiosAcme.add(produto);
    }


    public void apagarProduto(Produto produto) {
        listaProdutosFicticiosAcme.remove(produto);

    }


    public static Produto getProdutoPorID(int id) {
        return listaProdutosFicticiosAcme.get(id);
    }


    public List<Produto> getTodosProdutos() {
        return listaProdutosFicticiosAcme;
    }
}
