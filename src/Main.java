import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Variavel que gera um numero aleatorio
        Random numeroAleatorio = new Random();

        Scanner scanner = new Scanner(System.in);

        // Variavel que coleta os numeros informados pelo usuario
        List<Integer> numerosInformados = new ArrayList<>();

        //Variavel que coleta os numeros sorteados pelo sitema
        List<Integer> numerosSorteados = new ArrayList<>();

        //Variavel que coleta a quantidade de vezes que o usuario acertou
        List<Integer> numerosDeAcerto = new ArrayList<>();

        // Variavel que coleta a quantidade de vezes que o usuario errou
        List<Integer> numerosDeErros = new ArrayList<>();

        // Variaveis para exibir dados coletados do sistema
        Integer numeroInformado, numeroSorteado, numeroInformadoMaisUm, numeroInformadoMenosUm, querSair, grauDeDificuldade;

        //Variaveis declaradas para sumarizar
        Integer pontuacao = 0;
        Integer quantidadeDeAcertos = 0;
        Integer quantidadeDeErros = 0;
        Integer dificuldadeDoJogo = getDificuldadeDoJogo(scanner);

        if(dificuldadeDoJogo == 1) {
            grauDeDificuldade = 10;
        } else if (dificuldadeDoJogo == 2) {
            grauDeDificuldade = 30;
        } else {
            grauDeDificuldade = 50;
        }

        do{
            numeroInformado = getValidarNumero(scanner, grauDeDificuldade);
            numeroSorteado = numeroAleatorio.nextInt(grauDeDificuldade);
            numeroInformadoMaisUm = numeroInformado + 1;
            numeroInformadoMenosUm = numeroInformado - 1;
            numerosInformados.add(numeroInformado);
            numerosSorteados.add(numeroSorteado);

            if(numeroInformado.equals(numeroSorteado)) {
                quantidadeDeAcertos = getQuantidadeDeAcertos(numerosDeAcerto, numeroInformado, quantidadeDeAcertos);
                System.out.println("Parabéns você acertou e obteve 10 pontos de pontuação!");
                querSair = getQuerSair(scanner);
                pontuacao += 10;

            } else if (numeroInformadoMaisUm.equals(numeroSorteado) || numeroInformadoMenosUm.equals(numeroSorteado)) {
                quantidadeDeAcertos = getQuantidadeDeAcertos(numerosDeAcerto, numeroInformado, quantidadeDeAcertos);
                System.out.println("Parabéns você chegou perto e obteve 5 pontos de pontuação.");
                querSair = getQuerSair(scanner);
                pontuacao+=5;

            } else {
                quantidadeDeErros = getQuantidadeDeErros(numerosDeErros, numeroInformado, quantidadeDeErros);
                System.out.println("Que pena! Você errou, tente novamente!");
                querSair = getQuerSair(scanner);
            }

        } while(querSair != 2);

        System.out.println("***************************************************");
        System.out.println("NÚMEROS ESCOLHIDOS: "+ numerosInformados);
        System.out.println("NÚMEROS SORTEADOS: "+ numerosSorteados);
        System.out.println("NÚMEROS ACERTADOS: "+numerosDeAcerto);
        System.out.println("NÚMEROS ERRADOS: "+numerosDeErros);
        System.out.println("QUANTIDADE DE ACERTOS: "+quantidadeDeAcertos);
        System.out.println("QUANTIDADE DE ERROS: "+quantidadeDeErros);
        System.out.println("SUA PONTUAÇÂO: "+pontuacao);
        System.out.println("VALEU POR TER JOGADO! ATÉ A PRÓXIMA!!");
        System.out.println("***************************************************");
    }

    private static int getQuantidadeDeErros(List<Integer> numerosDeErros, Integer numeroInformado, int quantidadeDeErros) {
        quantidadeDeErros++;
        numerosDeErros.add(numeroInformado);
        return quantidadeDeErros;
    }

    private static int getQuantidadeDeAcertos(List<Integer> numerosDeAcerto, Integer numeroInformado, int quantidadeDeAcertos) {
        quantidadeDeAcertos++;
        numerosDeAcerto.add(numeroInformado);
        return quantidadeDeAcertos;
    }

    private static Integer getValidarNumero(Scanner scanner, Integer grauDeDificuldade) {
        Integer numeroInformado;
        do {
            System.out.println("Informe um número de 0 a "+grauDeDificuldade+" :");
            numeroInformado = scanner.nextInt();
            if(!(numeroInformado >= 0 && numeroInformado <= grauDeDificuldade)){
                {
                    System.out.println("O valor digitado não é válido!");
                }
            }
        } while (!(numeroInformado >= 0 && numeroInformado <= grauDeDificuldade));
        return numeroInformado;
    }

    private static int getQuerSair(Scanner scanner) {
        int querSair;
        System.out.println("Digite 1 para jogar novamente e 2 para sair.");
        querSair = scanner.nextInt();
        return querSair;
    }

    private static int getDificuldadeDoJogo(Scanner scanner) {
        System.out.println("SEJA BEM-VINDO!");
        System.out.println("Informe o nível de dificuldade do jogo (1- Fácil, 2- Médio e 3- Difícil):");
        int dificuldadeDoJogo = scanner.nextInt();
        switch (dificuldadeDoJogo) {
            case 1:
                System.out.println("Você escolheu o nível fácil! Bora jogar!");
                break;
            case 2:
                System.out.println("Você escolheu o nível médio! Bora jogar!");
                break;
            case 3:
                System.out.println("Você escolheu o nível difícil! Bora jogar!");
        }
        return dificuldadeDoJogo;
    }

}