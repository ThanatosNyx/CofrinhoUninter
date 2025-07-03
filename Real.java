package cofrinho.moedas;

/**
 * Representa uma moeda do tipo Real.
 * Como já está na moeda nacional, o valor convertido é o mesmo
 */
public class Real extends Moeda {

    public Real(double valor) {
        super(valor); // Chama o construtor da classe base Moeda
    }

    @Override
    public double converter() {
        return valor; // Retorna o valor diretamente, pois já está em Real
    }

    @Override
    public String toString() {
        return "Real: R$ " + valor; // Personaliza o formato da exibição
    }
}
