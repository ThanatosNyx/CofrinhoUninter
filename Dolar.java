package cofrinho.moedas;

/**
 * Representa uma moeda do tipo Dólar.
 * A conversão é feita utilizando uma taxa fixa, por exemplo:
 * 1 Dólar = 5.76 Reais (cotação atual).
 */
public class Dolar extends Moeda {

    private final double taxa = 5.76; // Taxa de conversão para Real

    public Dolar(double valor) {
        super(valor); // Chama o construtor da classe base Moeda
    }

    @Override
    public double converter() {
        return valor * taxa; // Converte para Real
    }

    @Override
    public String toString() {
        return "Dólar: USD " + valor;
    }
}