# Pos-Graduação Engenharia com Java | Instituto Infnet #

**Aluno:** Diego Henrique Cornelio de Rezende

**Projeto Disciplina CLEAN CODE**

Implemente um projeto JAVA de uma Loja virtual ACME que vende downloads de músicas, videos e imagens.


**Classes de modelo**

Produto [String nome, Path file, BigDecimal Preco]
Cliente [String Nome]
Assinatura [BigDecimal mensalidade, begin, end (Optional) Cliente] Obs: Crie 2 construtores, um com o "end" e outro sem.

Quando um usuário realiza uma nova compra um "Pagamento" é utilizado para representá-la.

Pagamento [List<Produtos>, dataCompra, Cliente]

**Lista de Exercicios 01**

1 Crie uma Classe com um método main para criar alguns produtos, clientes e pagamentos.
Crie Pagamentos com:  a data de hoje, ontem e um do mês passado.

2 - Ordene e imprima os pagamentos pela data de compra.

3 - Calcule e Imprima a soma dos valores de um pagamento com optional e recebendo um Double diretamente.

4 -  Calcule o Valor de todos os pagamentos da Lista de pagamentos.

5 - Imprima a quantidade de cada Produto vendido.

6 - Crie um Mapa de <Cliente, List<Produto> , onde Cliente pode ser o nome do cliente.

7 - Qual cliente gastou mais?

8 - Quanto foi faturado em um determinado mês?

9 - Crie 3 assinaturas com assinaturas de 99.98 reais, sendo 2 deles com assinaturas encerradas.

10 - Imprima o tempo em meses de alguma assinatura ainda ativa.

11 - Imprima o tempo de meses entre o start e end de todas assinaturas. Não utilize IFs para assinaturas sem end Time.

12 - Calcule o valor pago em cada assinatura até o momento.



