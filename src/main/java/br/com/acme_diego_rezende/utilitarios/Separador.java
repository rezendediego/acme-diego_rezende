package br.com.acme_diego_rezende.utilitarios;

public class Separador {
    private Separador() {
    }

    public static void exibeSeparador(String numExercicio){
        StringBuilder exibe = new StringBuilder();
        exibe.append(">:")
                .append(numExercicio)
                .append(" #######################################################################################################################################")
                .append("\r\n");
        System.out.println(exibe.toString());
    }
}
