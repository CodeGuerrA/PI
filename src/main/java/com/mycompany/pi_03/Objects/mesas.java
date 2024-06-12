package com.mycompany.pi_03.Objects;

import java.util.Scanner;

public class mesas {

    private String[] status;
    private int totalMesas;

    public mesas(int totalMesas) {
        this.totalMesas = totalMesas;
        criarArrayDeMesas();
    }

    public String getStatus(int numeroMesa) {
        return status[numeroMesa - 1];
    }

    public void setStatus(int numeroMesa, String novoStatus) {
        status[numeroMesa - 1] = novoStatus;
    }

    public void abrirTabelaDeMesas() {
        // Mostrar o status inicial das mesas
        System.out.println("\nStatus inicial das mesas:");
        mostrarMesas();

        Scanner scanner = new Scanner(System.in);
        int mesaEscolhida;
        // Loop para garantir uma entrada válida
        while (true) {
            // Solicitar ao usuário o número da mesa que ele deseja ocupar
            System.out.print("\nDigite o número da mesa que deseja ocupar: ");
            try {
                mesaEscolhida = scanner.nextInt();
                // Verificar se o número da mesa é válido
                if (mesaEscolhida >= 1 && mesaEscolhida <= totalMesas) {
                    break; // Saia do loop se a entrada for válida
                } else {
                    System.out.println("Número de mesa inválido. Por favor, escolha um número de mesa entre 1 e " + totalMesas + ".");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, insira um número de mesa válido.");
                scanner.next(); // Limpar o buffer do Scanner
            }
        }

        // Clicar na mesa escolhida
        clicarMesa(mesaEscolhida);

        // Mostrar o status de todas as mesas após ocupar uma
        System.out.println("\nStatus de todas as mesas após ocupar a mesa " + mesaEscolhida + ":");
        mostrarMesas();

        // Mostrar o cardápio após ocupar a mesa
        Cardapio cardapio = new Cardapio();
        cardapio.mostrarCardapio();
        cardapio.selecionarOpcao(new Comanda(), scanner); // Alteração aqui

        scanner.close();
    }

    public void mostrarMesas() {
        for (int i = 1; i <= totalMesas; i++) {
            System.out.println("Mesa " + i + ": " + status[i - 1]);
        }
    }

    private void criarArrayDeMesas() {
        status = new String[totalMesas];
        for (int i = 0; i < totalMesas; i++) {
            status[i] = "Disponível"; // Todas as mesas inicialmente disponíveis
        }
    }

    public void clicarMesa(int numeroMesa) {
        if (status[numeroMesa - 1].equals("Disponível")) {
            status[numeroMesa - 1] = "Ocupada";
        } else {
            status[numeroMesa - 1] = "Disponível";
        }
    }
}
