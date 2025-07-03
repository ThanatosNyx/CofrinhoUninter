package cofrinho.moedas;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa o cofrinho de moedas. 
 * Possui métodos para adicionar, remover, listar e calcular o total convertido.
 */
public class Cofrinho {
    private List<Moeda> moedas = new ArrayList<>(); // Coleção de moedas

    // Adiciona uma moeda ao cofrinho
    public void adicionar(Moeda m) {
        moedas.add(m);
    }

    // Remove a primeira ocorrência de uma moeda (com base no equals)
    public boolean remover(Moeda m) {
        return moedas.remove(m);
    }

    // Lista todas as moedas presentes no cofrinho
    public void listarMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
        } else {
            for (Moeda m : moedas) {
                System.out.println(m);
            }
        }
    }

    // Calcula o total convertido para Real utilizando o método converter() definido em cada moeda
    public double totalConvertido() {
        double total = 0;
        for (Moeda m : moedas) {
            total += m.converter();
        }
        return total;
    }
}