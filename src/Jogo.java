import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {

    public static void main(String[] args) {
        Random numeroAleatorio = new Random();
        Scanner scanner = new Scanner(System.in);
        List<Integer> numerosInformados = new ArrayList<>();
        List<Integer> numerosSorteados = new ArrayList<>();
        List<Integer> numerosDeAcerto = new ArrayList<>();
        List<Integer> numerosDeErros = new ArrayList<>();
        Integer numeroInformado, numeroSorteado, numeroInformadoMaisUm, numeroInformadoMenosUm, querSair, grauDeDificuldade;
        int pontuacao = 0;
        int quantidadeDeAcertos = 0;
        int quantidadeDeErros = 0;
        int dificuldadeDoJogo = getDificuldadeDoJogo(scanner);

        if(dificuldadeDoJogo == 1) {
            grauDeDificuldade = 10;
        } else if (dificuldadeDoJogo == 2) {
            grauDeDificuldade = 30;
        } else {
            grauDeDificuldade = 50;
        }
        do{
            numeroInformado = validar(scanner, grauDeDificuldade);
            numeroSorteado = numeroAleatorio.nextInt(grauDeDificuldade);
            numeroInformadoMaisUm = numeroInformado + 1;
            numeroInformadoMenosUm = numeroInformado - 1;
            adicionar(numerosInformados, numerosSorteados, numeroInformado, numeroSorteado);

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
        getResultado(numerosInformados, numerosSorteados, pontuacao, quantidadeDeAcertos, numerosDeAcerto,numerosDeErros, quantidadeDeErros);
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

    private static Integer validar(Scanner scanner, Integer grauDeDificuldade) {
        Integer numeroInformado;
        do {
            System.out.println("Informe um número de 0 a "+grauDeDificuldade+" :");
            numeroInformado = scanner.nextInt();
            if(!(numeroInformado>=0 && numeroInformado <=grauDeDificuldade)){
                {
                    System.out.println("O valor digitado não é válido!");
                }
            }
        } while (!(numeroInformado>=0 && numeroInformado <=grauDeDificuldade) );
        return numeroInformado;
    }

    private static void adicionar(List<Integer> numerosInformados, List<Integer> numerosSorteados,
                                  Integer numeroInformado, Integer numeroSorteado){
        numerosInformados.add(numeroInformado);
        numerosSorteados.add(numeroSorteado);
    }
    private static void getResultado(List<Integer> numerosInformados, List<Integer> numerosSorteados, int pontuacao
            , int quantidadeDeAcertos, List<Integer> numerosDeAcerto, List<Integer> numerosDeErros, int quantidadeDeErros) {
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

