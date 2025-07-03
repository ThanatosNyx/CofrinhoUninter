package cofrinho.moedas;

/**
 * Representa uma moeda do tipo Euro.
 * A conversão é feita utilizando uma taxa fixa, por exemplo:
 * 1 Euro = 6.23 Reais (cotação atual)
 */
public class Euro extends Moeda {

    private final double taxa = 6.23; // Taxa de conversão para Real

    public Euro(double valor) {
        super(valor); // Chama o construtor da classe base Moeda
    }

    @Override
    public double converter() {
        return valor * taxa; // Converte para Real
    }

    @Override
    public String toString() {
        return "Euro: € " + valor;
    }
}