package com.mycompany.pi_03.Objects;

import java.util.Scanner;

public class Cardapio {

    public void mostrarCardapio() {
        System.out.println("\nCardápio:");
        System.out.println("----------");
        System.out.println("1. Pasteis");
        System.out.println("2. Bebidas");
        System.out.println("3. Sobremesas");
        System.out.println("----------");
    }

    public void selecionarOpcao(Comanda comanda, Scanner scanner) {
        int opcao;
        while (true) {
            System.out.print("\nEscolha uma opção do cardápio (1 - Pasteis, 2 - Bebidas, 3 - Sobremesas): ");
            try {
                opcao = scanner.nextInt();
                if (opcao >= 1 && opcao <= 3) {
                    break;
                } else {
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.next(); // Limpar o buffer do Scanner
            }
        }

        switch (opcao) {
            case 1:
                adicionarItem(comanda, scanner, "Pasteis");
                break;
            case 2:
                adicionarItem(comanda, scanner, "Bebidas");
                break;
            case 3:
                adicionarItem(comanda, scanner, "Sobremesas");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void adicionarItem(Comanda comanda, Scanner scanner, String categoria) {
        switch (categoria) {
            case "Pasteis":
                mostrarPasteis();
                break;
            case "Bebidas":
                mostrarBebidas();
                break;
            case "Sobremesas":
                mostrarSobremesas();
                break;
            default:
                System.out.println("Categoria inválida.");
                return;
        }

        scanner.nextLine(); // Consumir a nova linha após nextInt()

        System.out.print("Digite o número do item desejado: ");
        int numeroItem = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após nextInt()

        System.out.print("Digite a quantidade desejada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após nextInt()

        switch (categoria) {
            case "Pasteis":
                comanda.adicionarItem("Pastel", numeroItem, quantidade);
                break;
            case "Bebidas":
                comanda.adicionarItem("Bebida", numeroItem, quantidade);
                break;
            case "Sobremesas":
                comanda.adicionarItem("Sobremesa", numeroItem, quantidade);
                break;
        }
    }

    private void mostrarPasteis() {
        System.out.println("\nPasteis:");
        System.out.println("----------");
        System.out.println("1. Pastel de carne - R$ 5,00");
        System.out.println("2. Pastel de queijo - R$ 4,50");
        System.out.println("3. Pastel de frango - R$ 5,50");
        System.out.println("----------");
    }

    private void mostrarBebidas() {
        System.out.println("\nBebidas:");
        System.out.println("----------");
        System.out.println("1. Refrigerante - R$ 4,00");
        System.out.println("2. Suco natural - R$ 5,00");
        System.out.println("3. Água mineral - R$ 3,00");
        System.out.println("----------");
    }

    private void mostrarSobremesas() {
        System.out.println("\nSobremesas:");
        System.out.println("----------");
        System.out.println("1. Pudim - R$ 6,00");
        System.out.println("2. Sorvete - R$ 4,50");
        System.out.println("3. Mousse de chocolate - R$ 7,00");
        System.out.println("----------");
    }
}
