package br.com.acme_diego_rezende_atividade_03.utilitarios.config;

import br.com.acme_diego_rezende_atividade_03.model.Cliente;
import br.com.acme_diego_rezende_atividade_03.repository.ClienteRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClientesAcmeConfig {
    private ClientesAcmeConfig() {
    }

    public static List<Cliente> criarListaClientesFicticios(){
        List<String> nomes = Arrays.asList("andre","bruno","carlos","diego","elton","flavia","gabriela","heloisa","irene","janaina");
        return nomes.stream()
                    .map(Cliente::new)
                    .collect(Collectors.toList());
    }

    public static void adicionarCLientesRepository(List<Cliente> listaClientes){
        listaClientes.stream()
                .forEach(ClienteRepository::criarCliente);
    }

    public static void configurarClientesFicticios(){
        adicionarCLientesRepository(criarListaClientesFicticios());
    }


}
