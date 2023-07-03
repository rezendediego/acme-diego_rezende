package br.com.acme_diego_rezende;

import br.com.acme_diego_rezende.model.Assinatura;
import br.com.acme_diego_rezende.model.Cliente;
import br.com.acme_diego_rezende.model.Pagamento;
import br.com.acme_diego_rezende.model.Produto;



import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static br.com.acme_diego_rezende.utilitarios.Cabecalho.exibeCabecalhoNoConsole;
import static br.com.acme_diego_rezende.utilitarios.Separador.exibeSeparador;


public class RunnerLojaVirtualAcme {
    public static void main(String[] args) {
        exibeCabecalhoNoConsole();

        exibeSeparador("Exercicio 01");
        Supplier<List<Produto>> fornecedorInventarioProdutosFicticiosAcme = () -> {
            Produto paranoid = new Produto("paranoid",
                    Paths.get("acme\\produtos\\musicas\\black-sabbath\\paranoid\\paranoid"),
                    new BigDecimal("5.37"));
            Produto aceOfSpades = new Produto("aceOfSpades",
                    Paths.get("acme\\produtos\\musicas\\motorhead\\aceOfSpades\\aceOfSpades"),
                    new BigDecimal("5.37"));
            Produto epidemic = new Produto("epidemic",
                    Paths.get("acme\\produtos\\musicas\\motorhead\\rainingBlood\\epidemic"),
                    new BigDecimal("5.37"));
            Produto terraEmTranse = new Produto("terraEmTranse",
                    Paths.get("acme\\produtos\\videos\\cinema-novo\\terraEmTranse"),
                    new BigDecimal("5.37"));
            Produto cabraMarcadoParaMorrer = new Produto("cabraMarcadoParaMorrer",
                    Paths.get("acme\\produtos\\videos\\anos80\\cabraMarcadoParaMorrer"),
                    new BigDecimal("5.37"));
            Produto centralDoBrasil = new Produto("centralDoBrasil",
                    Paths.get("acme\\produtos\\videos\\retomada\\centralDoBrasil"),
                    new BigDecimal("5.37"));
            Produto vendedorDeSonhos = new Produto("vendedorDeSonhos",
                    Paths.get("acme\\produtos\\imagens\\walter-firmo\\vendedorDeSonhos"),
                    new BigDecimal("10000.00"));
            Produto cabalgata = new Produto("cabalgata",
                    Paths.get("acme\\produtos\\imagens\\walter-firmo\\cabalgata"),
                    new BigDecimal("10000.00"));
            Produto kuikuroWarriors = new Produto("kuikuroWarriors",
                    Paths.get("acme\\produtos\\imagens\\sebastiao-salgado\\kuikuroWarriors"),
                    new BigDecimal("10000.00"));
            Produto serraPelada = new Produto("serraPelada",
                    Paths.get("acme\\produtos\\imagens\\sebastiao-salgado\\serraPelada"),
                    new BigDecimal("10000.00"));

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
        };
        System.out.println("Lista Produtos Fictícios Acme = " + fornecedorInventarioProdutosFicticiosAcme.get().toString());


        Supplier<List<Cliente>> fornecedorListaClientesFicticios = () -> {
            List<String> nomes = Arrays.asList("Andre","Bruno","Carlos","Diego","Elton","Flavia","Gabriela","Heloisa","Irene","Janaina");
            return nomes.stream()
                    .map(Cliente::new)
                    .collect(Collectors.toList());
        };
        System.out.println("Lista Clientes Fictícios Acme = " + fornecedorListaClientesFicticios.get().toString());


        BiFunction<List<Produto>,List<Cliente>,List<Pagamento>> criadorPagamentosFicticiosAcme = (produtosFicticiosAcme, clientesFicticios) -> {
            Pagamento pagamento01 = new Pagamento(Arrays.asList(produtosFicticiosAcme.get(3), produtosFicticiosAcme.get(4), produtosFicticiosAcme.get(8)),
                    LocalDate.now().minusDays(1),
                    clientesFicticios.get(2));

            Pagamento pagamento02 = new Pagamento(Arrays.asList(produtosFicticiosAcme.get(9), produtosFicticiosAcme.get(8)),
                    LocalDate.now().minusMonths(1),
                    clientesFicticios.get(8));

            Pagamento pagamento03 = new Pagamento(Arrays.asList(produtosFicticiosAcme.get(1), produtosFicticiosAcme.get(8)),
                    LocalDate.now(),
                    clientesFicticios.get(4));


            List <Pagamento> pagamentosAcme = new ArrayList<>();
            pagamentosAcme.add(pagamento01);
            pagamentosAcme.add(pagamento02);
            pagamentosAcme.add(pagamento03);
            return pagamentosAcme;
        };
        System.out.println("Lista Pagamentos Ficticios Acme = " + criadorPagamentosFicticiosAcme.apply(fornecedorInventarioProdutosFicticiosAcme.get(),fornecedorListaClientesFicticios.get()).toString() + "\r\n");

        List<Pagamento> listaPagamentosFicticiosAcme = criadorPagamentosFicticiosAcme.apply(fornecedorInventarioProdutosFicticiosAcme.get(),fornecedorListaClientesFicticios.get());















        exibeSeparador("Exercicio 02");
        Function<List<Pagamento>,List<Pagamento>> ordenarPagamentosDecrescente = pagamentos -> {
            List<Pagamento> pagDecrescente = new ArrayList<>(pagamentos);
            pagDecrescente.sort(Comparator.comparing(Pagamento::getDataCompra).reversed());
            return pagDecrescente;
        };

        Consumer<List<Pagamento>> exibidorPagamentosOrdenadosDecrescente = pagamentosOrdenadosDecrescente ->{
            StringBuilder exibePagamentosOrdenadoDecrescente = new StringBuilder();
            exibePagamentosOrdenadoDecrescente.append(">:ORDEM DECRESCENTE"+ "\r\n");
            pagamentosOrdenadosDecrescente.forEach(
                    pagamento -> exibePagamentosOrdenadoDecrescente.append(pagamento.getDataCompra())
                            .append(" ||||| ")
                            .append(pagamento.getCliente())
                            .append(" ||||| ")
                            .append(pagamento.getCarrinho())
                            .append("\r\n")
            );
            System.out.println(exibePagamentosOrdenadoDecrescente.toString());
        };

        exibidorPagamentosOrdenadosDecrescente.accept(ordenarPagamentosDecrescente.apply(listaPagamentosFicticiosAcme));



        Function<List<Pagamento>,List<Pagamento>> ordenarPagamentosCrescente = pagamentos->{
            List<Pagamento> pagCrescente = new ArrayList<>(pagamentos);
            pagCrescente.sort(Comparator.comparing(Pagamento::getDataCompra));
            return pagCrescente;
        };

        Consumer<List<Pagamento>> exibidorPagamentosOrdenadosCrescente = pagamentosOrdenadosCrescente ->{
            StringBuilder exibePagamentosOrdenadoCrescente = new StringBuilder();
            exibePagamentosOrdenadoCrescente.append(">:ORDEM CRESCENTE"+ "\r\n");
            pagamentosOrdenadosCrescente.forEach(
                    pagamento -> exibePagamentosOrdenadoCrescente.append(pagamento.getDataCompra())
                            .append(" ||||| ")
                            .append(pagamento.getCliente())
                            .append(" ||||| ")
                            .append(pagamento.getCarrinho())
                            .append("\r\n")
            );
            System.out.println(exibePagamentosOrdenadoCrescente.toString());
        };

        exibidorPagamentosOrdenadosCrescente.accept(ordenarPagamentosCrescente.apply(listaPagamentosFicticiosAcme));














        exibeSeparador("Exercicio 03");
        Function<Pagamento, Optional<Double>> calcularValorTotalDeUmPagamento = pagamento -> {
            return Optional.of( pagamento.getCarrinho().stream()
                    .mapToDouble( produto -> produto.getPreco().doubleValue())
                    .sum()
            );
        };

        Consumer<Optional<Double>> exibidorvalorTotalDeUmPagamento = valorTotalDeUmPagamento -> {
            StringBuilder formatadorValorTotalDeUmPagamento = new StringBuilder();
            formatadorValorTotalDeUmPagamento.append("O valor total do pagamento é: " + valorTotalDeUmPagamento);
            System.out.println(formatadorValorTotalDeUmPagamento.toString() + "\r\n");
        };

        exibidorvalorTotalDeUmPagamento.accept(calcularValorTotalDeUmPagamento.apply(listaPagamentosFicticiosAcme.get(2)));














        exibeSeparador("Exercicio 04");
        Function<List<Pagamento>,List<Optional<Double>>> calcularValorTotalDeTodosPagamentosUmPorUm = listaPagamentos -> {
            return listaPagamentos.stream()
                    .map( pagamento -> {
                        return Optional.of(pagamento.getCarrinho().stream()
                                .mapToDouble(produto -> produto.getPreco().doubleValue())
                                .sum()); })
                    .collect(Collectors.toList());
        };
        System.out.println("calcular Valor Total De Todos Pagamentos Um Por Um " + calcularValorTotalDeTodosPagamentosUmPorUm.apply(listaPagamentosFicticiosAcme) + "\r\n");














        exibeSeparador("Exercicio 05");
        BiFunction<List<Pagamento>, Map<Produto,Integer>, Map<Produto,Integer>> calcularQuantidadeProdutosVendidos = (listaPagamentos, mapaProdutoNumVendido) -> {
            listaPagamentos.stream()
                    .map(Pagamento::getCarrinho)
                    .flatMap(Collection::stream)
                    .forEach(produto -> {
                        mapaProdutoNumVendido.putIfAbsent(produto, 0);
                        mapaProdutoNumVendido.compute(produto, (chave, numVendido) -> numVendido + 1);
                    });
            return mapaProdutoNumVendido;
        };



        Function<Map<Produto,Integer>, String> exibirProdutosPorQuantidadeVendida = mapaProdutoNumVendido -> {
            StringBuilder mapaParaExibicaoNoConsole = new StringBuilder();
            mapaParaExibicaoNoConsole.append("<<< MAPA: PRODUTO x QUANTIDADE VENDIDA >>>" + "\r\n");
            mapaProdutoNumVendido.forEach(
                    (produto, numVendido) -> mapaParaExibicaoNoConsole.append(produto)
                            .append(" : ")
                            .append(numVendido)
                            .append("\r\n")
            );
            return mapaParaExibicaoNoConsole.toString();
        };



        Map<Produto,Integer> mapaProdutosPorQuantidadeVendida = new HashMap<>();

        System.out.println(
                exibirProdutosPorQuantidadeVendida.apply(
                        calcularQuantidadeProdutosVendidos.apply(
                                listaPagamentosFicticiosAcme, mapaProdutosPorQuantidadeVendida))
        );














        exibeSeparador("Exercicio 06");
        Function<List<Pagamento>,Map<String,List<Produto>>> criarMapaClienteListaProduto = listaPagamento -> {
            Map<String,List<Produto>> mapaClienteListaProduto = new HashMap<>();
            listaPagamento.forEach( pagamento -> {
                mapaClienteListaProduto.put(pagamento.getCliente().getNome(),pagamento.getCarrinho());
            });
            return mapaClienteListaProduto;
        };



        Function<Map<String,List<Produto>>, String> exibeMapaClienteComCompra = mapaClienteListaProduto -> {
            StringBuilder exibicaoMapaClienteListaProduto = new StringBuilder();
            exibicaoMapaClienteListaProduto.append("<<< MAPA: CLIENTE x LISTA PRODUTOS >>>" + "\r\n");
            mapaClienteListaProduto.forEach( (cliente, listaProdutos) -> exibicaoMapaClienteListaProduto.append(cliente)
                    .append(" ||||| ")
                    .append(listaProdutos)
                    .append("\r\n")

            );
            return exibicaoMapaClienteListaProduto.toString();
        };



        System.out.println(exibeMapaClienteComCompra.apply(
                criarMapaClienteListaProduto.apply(
                        listaPagamentosFicticiosAcme)));














        exibeSeparador("Exercicio 07");
        Function<Map<String,List<Produto>>, Map<String,Double>> calcularGastoPorCliente = mapaClientePorProdutos -> {
            Map<String,Double> clienteGastouMais = new HashMap<>();
            mapaClientePorProdutos.forEach(
                    (chaveCliente, listaProduto) -> {
                        clienteGastouMais.put(chaveCliente,
                                listaProduto.stream()
                                        .map(produto -> produto.getPreco().doubleValue())
                                        .reduce(0.0,Double::sum));
                    });
            return clienteGastouMais;
        };



        Function<Map<String,Double>,Map<String,Double>> calcularClienteQueGastouMais = mapaGastoPorCliente -> {
            Optional<Map.Entry<String, Double>> parClienteMaiorGasto = mapaGastoPorCliente.entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue());
            Map<String,Double> clienteQueGastouMais = new HashMap<>();
            parClienteMaiorGasto.ifPresent( parClienteGasto -> clienteQueGastouMais.put( parClienteMaiorGasto.get().getKey(),
                    parClienteMaiorGasto.get().getValue())
            );

            return clienteQueGastouMais;

        };



        Function<Map<String,Double>,String> exibeClienteQueGastouMais = mapaClienteMaiorGasto -> {
            StringBuilder clienteQueGastouMais = new StringBuilder();
            mapaClienteMaiorGasto.forEach((chaveCliente,valorGasto) -> {
                clienteQueGastouMais.append("O cliente que gastou mais foi: ")
                        .append(chaveCliente)
                        .append(" no valor de: ")
                        .append(valorGasto)
                        .append("\r\n");
            });

            return clienteQueGastouMais.toString();
        };



        System.out.println(exibeClienteQueGastouMais.apply(
                calcularClienteQueGastouMais.apply(
                        calcularGastoPorCliente.apply(
                                criarMapaClienteListaProduto.apply(
                                        listaPagamentosFicticiosAcme))))
        );














        exibeSeparador("Exercicio 08");
        CalculadoraFaturamentoMensal calculadoraFaturamentoMensal = mes -> {
            return listaPagamentosFicticiosAcme.stream()
                    .filter(pagamento -> pagamento.getDataCompra().getMonth().equals(mes))
                    .flatMap(pagamento -> pagamento.getCarrinho().stream())
                    .map(produto-> produto.getPreco().doubleValue())
                    .reduce(0.0,Double::sum);
        };



        Function<Month,String> exibeFaturamentoMensal = mes -> {
            Locale localBR = new Locale("pt", "BR");
            StringBuilder faturamentoMensal = new StringBuilder();
            faturamentoMensal.append("O Faturamento mensal para o mes: ")
                    .append(mes.getDisplayName(TextStyle.FULL_STANDALONE, localBR))
                    .append(" ")
                    .append(calculadoraFaturamentoMensal.calcule(mes))
                    .append("\r\n");

            return faturamentoMensal.toString();
        };

        Month maio = Month.MAY;
        Month junho = Month.JUNE;
        Month julho = Month.JULY;
        System.out.println(exibeFaturamentoMensal.apply(maio));
        System.out.println(exibeFaturamentoMensal.apply(junho));
        System.out.println(exibeFaturamentoMensal.apply(julho));














        exibeSeparador("Exercicio 09");
        Supplier<List<Assinatura>> fornecedorAssinaturasFicticiasAcme = () -> {
            List<Assinatura> assinaturasFicticias = new ArrayList<>();
            assinaturasFicticias.add(new Assinatura( new BigDecimal("99.98"),
                    LocalDate.of(2021,6,6),
                    Optional.of(LocalDate.of(2023,6,5)),
                    fornecedorListaClientesFicticios.get().get(6)));

            assinaturasFicticias.add(new Assinatura(new BigDecimal("99.98"),
                    LocalDate.of(2023,1,1),
                    fornecedorListaClientesFicticios.get().get(2)));

            assinaturasFicticias.add(new Assinatura(new BigDecimal("99.98"),
                    LocalDate.of(2022,12,27),
                    Optional.of(LocalDate.of(2023,3,15)),
                    fornecedorListaClientesFicticios.get().get(0)));

            return assinaturasFicticias;
        };

        System.out.println(fornecedorAssinaturasFicticiasAcme.get().toString() + "\r\n");














        exibeSeparador("Exercicio 10");
        Function<List<Assinatura>,List<Assinatura>> selecionarUmaAssinaturaAtiva = listaAssinaturas -> {
            return listaAssinaturas.stream()
                    .filter(assinatura -> !assinatura.getFim().isPresent()
                            || assinatura.getFim().get().isAfter(LocalDate.now()))
                    .limit(1)
                    .collect(Collectors.toList());
        };

        Function<List<Assinatura>,Integer> calcularTempoEmMesesAssinaturaAtiva = listaAssinaturaAtiva -> {
            return Math.toIntExact(ChronoUnit.MONTHS.between(listaAssinaturaAtiva.get(0).getInicio(), LocalDate.now()));
        };

        Function<List<Assinatura>,String> exibeTempoEmMesesAssinaturaAtiva = assinaturaAtivaSelecionada -> {
            StringBuilder exibeAssinaturaAtivaSelecionada = new StringBuilder();
            assinaturaAtivaSelecionada.forEach(
                    assinaturaAtiva -> exibeAssinaturaAtivaSelecionada.append("A assinatura do cliente: ")
                            .append(assinaturaAtivaSelecionada.get(0).getCliente().getNome())
                            .append(" está ativa e possui ")
                            .append(calcularTempoEmMesesAssinaturaAtiva.apply(assinaturaAtivaSelecionada))
                            .append(" meses.")
                            .append("\r\n")
            );
            return exibeAssinaturaAtivaSelecionada.toString();
        };

        System.out.println(exibeTempoEmMesesAssinaturaAtiva.apply(selecionarUmaAssinaturaAtiva.apply(fornecedorAssinaturasFicticiasAcme.get())));














        exibeSeparador("Exercicio 11");
        Function<List<Assinatura>, Map<String,Integer>> calcularEmMesesTempoEntreInicioFimTodasAssinaturas = listaAssinaturas -> {
            Map<String,Integer> mapaAssinaturaPorTempoEmMeses = new HashMap<>();
            listaAssinaturas.forEach(
                    assinatura -> {
                        mapaAssinaturaPorTempoEmMeses.putIfAbsent(
                                assinatura.getCliente().getNome(),
                                assinatura.getFim()
                                        .map(diaFinal -> (int) ChronoUnit.MONTHS.between(assinatura.getInicio(), assinatura.getFim().get()))
                                        .orElseGet(() -> (int) ChronoUnit.MONTHS.between(assinatura.getInicio(), LocalDate.now())));
                    }
            );
            return mapaAssinaturaPorTempoEmMeses;
        };

        System.out.println("Tempo em Meses de Todas as Assinaturas: " + calcularEmMesesTempoEntreInicioFimTodasAssinaturas.apply(fornecedorAssinaturasFicticiasAcme.get()) + "\r\n" );














        exibeSeparador("Exercicio 12");
        CalculadoraValorPagoAssinatura calculadoraValorPagoAssinatura = (tempoDeAssinaturaEmMeses, mensalidade) -> {
            Map<String,Double> mapaValorPagoAteMomentoPorAssinatura = new HashMap<>();
            tempoDeAssinaturaEmMeses.forEach(
                    (chaveCliente,tempoEmMeses) -> mapaValorPagoAteMomentoPorAssinatura.putIfAbsent(
                            chaveCliente,
                            tempoEmMeses.doubleValue() * mensalidade)
            );
            return mapaValorPagoAteMomentoPorAssinatura;
        };

        System.out.println("O valor pago em cada assinatura até o momento é: "+ calculadoraValorPagoAssinatura.calcule(
                calcularEmMesesTempoEntreInicioFimTodasAssinaturas.apply(fornecedorAssinaturasFicticiasAcme.get()),
                new BigDecimal("99.98").doubleValue()) + "\r\n");


    }

    @FunctionalInterface
    public interface CalculadoraFaturamentoMensal{
        public abstract Double calcule(Month mes);
    }

    @FunctionalInterface
    public interface CalculadoraValorPagoAssinatura{
        public abstract Map<String,Double> calcule(Map<String,Integer> tempoDeAssinaturaEmMeses, Double mensalidade);
    }

}





