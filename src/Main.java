import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        ConsultaApi consulta = new ConsultaApi();

        int opcao = 0;

        while (opcao != 7) {
            menu.exibirMenu();
            opcao = menu.lerOpcao(scanner);

            switch (opcao) {
                case 1 -> consulta.conversao(menu.lerValor(scanner),"USD","ARS");
                case 2 -> consulta.conversao(menu.lerValor(scanner),"ARS","USD");
                case 3 -> consulta.conversao(menu.lerValor(scanner),"USD","BRL");
                case 4 -> consulta.conversao(menu.lerValor(scanner),"BRL","USD");
                case 5 -> consulta.conversao(menu.lerValor(scanner),"USD","COP");
                case 6 -> consulta.conversao(menu.lerValor(scanner),"COP","USD");
                case 7 -> System.out.println("Programa encerrado. Até Logo!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}