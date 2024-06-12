package com.mycompany.pi_03.Objects;

import java.util.HashMap;
import java.util.Map;

public class Comanda {
    private Map<String, Integer> itens; // Mapeia o nome do item para a quantidade

    public Comanda() {
        this.itens = new HashMap<>();
    }

    public void adicionarItem(String categoria, int numeroItem, int quantidade) {
        String item = null;
        double preco = 0;

        switch (categoria) {
            case "Pastel":
                item = getPastel(numeroItem);
                preco = getPrecoPastel(numeroItem);
                break;
            case "Bebida":
                item = getBebida(numeroItem);
                preco = getPrecoBebida(numeroItem);
                break;
            case "Sobremesa":
                item = getSobremesa(numeroItem);
                preco = getPrecoSobremesa(numeroItem);
                break;
            default:
                System.out.println("Categoria inválida.");
                return;
        }

        if (item != null) {
            double total = preco * quantidade;
            System.out.println(quantidade + " " + item + " adicionado à comanda. Total: R$" + total);
            if (itens.containsKey(item)) {
                int quantidadeAtual = itens.get(item);
                itens.put(item, quantidadeAtual + quantidade);
            } else {
                itens.put(item, quantidade);
            }
        } else {
            System.out.println("Item inválido.");
        }
    }

    private String getPastel(int numeroItem) {
        switch (numeroItem) {
            case 1:
                return "Pastel de carne";
            case 2:
                return "Pastel de queijo";
            case 3:
                return "Pastel de frango";
            default:
                return null;
        }
    }

    private double getPrecoPastel(int numeroItem) {
        switch (numeroItem) {
            case 1:
                return 5.00;
            case 2:
                return 4.50;
            case 3:
                return 5.50;
            default:
                return 0;
        }
    }

    private String getBebida(int numeroItem) {
        switch (numeroItem) {
            case 1:
                return "Refrigerante";
            case 2:
                return "Suco natural";
            case 3:
                return "Água mineral";
            default:
                return null;
        }
    }

    private double getPrecoBebida(int numeroItem) {
        switch (numeroItem) {
            case 1:
                return 4.00;
            case 2:
                return 5.00;
            case 3:
                return 3.00;
            default:
                return 0;
        }
    }

    private String getSobremesa(int numeroItem) {
        switch (numeroItem) {
            case 1:
                return "Pudim";
            case 2:
                return "Sorvete";
            case 3:
                return "Mousse de chocolate";
            default:
                return null;
        }
    }

    private double getPrecoSobremesa(int numeroItem) {
        switch (numeroItem) {
            case 1:
                return 6.00;
            case 2:
                return 4.50;
            case 3:
                return 7.00;
            default:
                return 0;
        }
    }

    public void mostrarComanda() {
        if (itens.isEmpty()) {
            System.out.println("A comanda está vazia.");
        } else {
            System.out.println("\nComanda:");
            for (Map.Entry<String, Integer> entry : itens.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
