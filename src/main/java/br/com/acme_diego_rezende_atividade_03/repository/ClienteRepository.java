package br.com.acme_diego_rezende_atividade_03.repository;

import br.com.acme_diego_rezende_atividade_03.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {
    static List<Cliente> listaClientesFicticiosAcme = new ArrayList<>();

    public static void criarCliente(Cliente cliente) {
        listaClientesFicticiosAcme.add(cliente);
    }

    public void apagarCliente(Cliente cliente) {
        listaClientesFicticiosAcme.remove(cliente);
    }


    public static Cliente getClientePorID(int id) {
        return listaClientesFicticiosAcme.get(id);
    }

    public static Cliente getClientePorNome(String nome) {
         Optional<Cliente> buscaCliente = listaClientesFicticiosAcme.stream()
                .filter(cliente -> cliente.getNome().equals(nome))
                .findFirst();
         return buscaCliente.orElseThrow(() -> new IllegalArgumentException("Cliente nao encontrado"));
    }

    public static List<Cliente> getTodosClientes() {
        return listaClientesFicticiosAcme;
    }
}
