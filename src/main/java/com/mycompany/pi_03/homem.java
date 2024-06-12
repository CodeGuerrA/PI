package com.mycompany.pi_03;

import com.mycompany.pi_03.Objects.Cardapio;
import com.mycompany.pi_03.Objects.Comanda;
import com.mycompany.pi_03.Objects.mesas;

import java.util.*;

public class homem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mesas mesas = new mesas(16); // Corrigido o nome da classe para Mesas
        Set<Integer> mesasEscolhidas = new HashSet<>();
        Map<Integer, Comanda> comandas = new HashMap<>();
        Cardapio cardapio = new Cardapio();

        boolean executando = true;

        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Abrir serviços");
            System.out.println("2. Ocupar mesa");
            System.out.println("3. Sair");

            System.out.print("Opção: ");
            try {
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        exibirStatusMesas(mesas);
                        break;
                    case 2:
                        ocuparMesa(scanner, mesas, mesasEscolhidas, comandas, cardapio);
                        break;
                    case 3:
                        executando = false;
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira uma opção válida.");
                scanner.next();
            }
        }

        scanner.close();
    }

    private static void exibirStatusMesas(mesas mesas) {
        System.out.println("\nStatus das mesas:");
        mesas.mostrarMesas();
    }

    private static void ocuparMesa(Scanner scanner, mesas mesas, Set<Integer> mesasEscolhidas,
            Map<Integer, Comanda> comandas, Cardapio cardapio) {
        int mesaEscolhida;
        do {
            System.out.print("\nDigite o número da mesa que deseja ocupar: ");
            mesaEscolhida = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (mesaEscolhida >= 1 && mesaEscolhida <= 16) {
                if (mesasEscolhidas.contains(mesaEscolhida)) {
                    System.out.println("Esta mesa já foi escolhida. Por favor, escolha outra mesa.");
                } else {
                    mesasEscolhidas.add(mesaEscolhida);
                    break;
                }
            } else {
                System.out.println("Número de mesa inválido. Por favor, escolha um número de mesa entre 1 e 16.");
            }
        } while (true);

        mesas.clicarMesa(mesaEscolhida);
        System.out.println("\nStatus da mesa " + mesaEscolhida + " após ocupar:");
        System.out.println("Mesa " + mesaEscolhida + ": " + mesas.getStatus(mesaEscolhida));

        Comanda comanda = new Comanda();
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar item à comanda");
            System.out.println("2. Mostrar comanda");
            System.out.println("3. Finalizar comanda");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após nextInt()

            switch (opcao) {
                case 1:
                    cardapio.selecionarOpcao(comanda, scanner); // Chamada do método corrigida
                    break;
                case 2:
                    comanda.mostrarComanda();
                    break;
                case 3:
                    System.out.println("Comanda finalizada.");
                    comandas.put(mesaEscolhida, comanda);
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }
}
