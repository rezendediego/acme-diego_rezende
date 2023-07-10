package br.com.acme_diego_rezende_atividade_02.exception;

public class FalhaNoGeradorRandomException extends RuntimeException{
    public FalhaNoGeradorRandomException(String message) {
        super(message);
    }
}
