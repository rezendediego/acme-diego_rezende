package br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_validacao_cliente;

import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao.Infracao;
import br.com.acme_diego_rezende_atividade_02.app.caso_de_uso_infracao.InfracaoController;
import br.com.acme_diego_rezende_atividade_02.model.Cliente;

import java.util.List;

public class ValidacaoClienteService {
    List<Infracao> listaInfracoesVerificaveis;

    public ValidacaoClienteService(List<Infracao> listaInfracoesVerificaveis) {
        this.listaInfracoesVerificaveis = listaInfracoesVerificaveis;
    }

    public Boolean validarCliente(Cliente cliente) {
        InfracaoController infracaoController = new InfracaoController(listaInfracoesVerificaveis);
        return infracaoController.verificaSeClientePossuiSuspensao(cliente);

    }
}
