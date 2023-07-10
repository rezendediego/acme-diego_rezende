package br.com.acme_diego_rezende_atividade_03.utilitarios;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Impressora {
    String objetoImpresso;
    Logger logger;

    public Impressora() {

        this.objetoImpresso = "";
        this.logger = Logger.getLogger(Impressora.class.getCanonicalName());
    }
    public void imprime(String objetoImpresso){
        this.objetoImpresso = objetoImpresso;
        logger.info(objetoImpresso);
    }

    public void imprimeEnunciado(String enunciado){
        this.objetoImpresso = enunciado;
        logger.log(Level.SEVERE,objetoImpresso);
    }
    public void imprimeAlertaException(String alertaException){
        this.objetoImpresso = alertaException;
        logger.log(Level.WARNING,objetoImpresso);
    }
}
