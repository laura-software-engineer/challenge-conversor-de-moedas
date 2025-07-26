import java.util.Scanner;

public class Menu {
    public void exibirMenu () {
        System.out.println("""
                **********************************************
                Seja bem-vindo(a) ao conversor de moeda!
                
                1) Dólar --> Peso Argentino
                2) Peso Argentino --> Dólar
                3) Dólar --> Real Brasileiro
                4) Real Brasileiro --> Dólar
                5) Dólar --> Peso Colombiano
                6) Peso Colombiano --> Dólar
                7) Sair
                
                Digite uma opção válida: 
                **********************************************
                """);
    }

    public int lerOpcao (Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida. Digite um número entre 1 e 7: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double lerValor (Scanner scanner) {
        System.out.println("Digite o valor a ser convertido: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Valor inválido. Tente novamente: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
