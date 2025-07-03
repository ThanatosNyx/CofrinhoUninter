package cofrinho.moedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho(); // Criação da instância do Cofrinho
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu Meu Cofrinho ===");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Remover moeda");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular total convertido para Real");
            System.out.println("5. Sair do cofrinho");
            
            // Validação para entrada da opção
            while (true) {
                System.out.print("Escolha uma opção: ");
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt(); // Lê a opção
                    break; // Sai do loop
                } else {
                    System.out.println("Entrada inválida! Por favor, digite um número inteiro entre 1 e 5.");
                    scanner.next(); // Limpa entrada inválida
                }
            }

            switch (opcao) {
                case 1: { // Adicionar moeda
                    int tipo;
                    while (true) {
                        System.out.print("Digite o tipo de moeda (1-Real, 2-Dólar, 3-Euro): ");
                        if (scanner.hasNextInt()) {
                            tipo = scanner.nextInt();
                            if (tipo >= 1 && tipo <= 3) break;
                            else System.out.println("Tipo inválido! Escolha 1, 2 ou 3.");
                        } else {
                            System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                            scanner.next(); // Limpa entrada inválida
                        }
                    }

                    System.out.print("Digite o valor da moeda: ");
                    String input = scanner.next(); // Lê entrada como string
                    input = input.replace(',', '.'); // Substitui vírgula por ponto
                    double valor;

                    try {
                        valor = Double.parseDouble(input); // Converte entrada para double
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido! Operação cancelada.");
                        break;
                    }

                    Moeda moeda = null;
                    if (tipo == 1) moeda = new Real(valor);
                    else if (tipo == 2) moeda = new Dolar(valor);
                    else if (tipo == 3) moeda = new Euro(valor);

                    if (moeda != null) {
                        cofrinho.adicionar(moeda);
                        System.out.println("Moeda adicionada!");
                    } else {
                        System.out.println("Erro ao adicionar moeda. Tente novamente.");
                    }
                    break;
                }
                case 2: { // Remover moeda
                    System.out.print("Digite o valor da moeda a ser removida: ");
                    String input = scanner.next();
                    input = input.replace(',', '.'); // Substitui vírgula por ponto
                    double valor;

                    try {
                        valor = Double.parseDouble(input); //converte String em número decimal 
                    } catch (NumberFormatException e) { // impede que o programa seja interrompido por erro do usuário 
                        System.out.println("Valor inválido! Operação cancelada.");
                        break;
                    }

                    int tipo;
                    while (true) {
                        System.out.print("Digite o tipo de moeda (1-Real, 2-Dólar, 3-Euro): ");
                        if (scanner.hasNextInt()) {
                            tipo = scanner.nextInt();
                            if (tipo >= 1 && tipo <= 3) break;
                            else System.out.println("Tipo inválido! Escolha 1, 2 ou 3.");
                        } else {
                            System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                            scanner.next(); // Limpa entrada inválida
                        }
                    }

                    Moeda moeda = null;
                    if (tipo == 1) moeda = new Real(valor); // Cria um objeto da classe Real
                    else if (tipo == 2) moeda = new Dolar(valor); // Cria um objeto da classe Dolar
                    else if (tipo == 3) moeda = new Euro(valor); // Cria um objeto da classe Euro 

                    if (moeda != null && cofrinho.remover(moeda)) {
                        System.out.println("Moeda removida!");
                    } else {
                        System.out.println("Moeda não encontrada ou tipo inválido.");
                    }
                    break;
                }
                case 3: { // Listar moedas
                    System.out.println("\nMoedas no cofrinho:");
                    cofrinho.listarMoedas();
                    break;
                }
                case 4: { // Calcular total convertido
                    System.out.printf("\nTotal convertido para Reais: R$ %.2f\n", cofrinho.totalConvertido());
                    break;
                }
                case 5: { // Sair
                    System.out.println("Cofrinho encerrado.");
                    break;
                }
                default: {
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
                }
            }
        } while (opcao != 5);

        scanner.close();
    }
}
