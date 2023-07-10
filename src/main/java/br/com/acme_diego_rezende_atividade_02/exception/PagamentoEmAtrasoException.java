package br.com.acme_diego_rezende_atividade_02.exception;

public class PagamentoEmAtrasoException extends RuntimeException{
    public PagamentoEmAtrasoException(String message) {
        super(message);
    }
}
