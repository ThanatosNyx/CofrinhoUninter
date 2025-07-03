package cofrinho.moedas;

/**
 * Classe abstrata que representa uma moeda.
 * Serve como base para classes concretas (Real, Dolar, Euro).
 */
public abstract class Moeda {
    protected double valor; // Valor da moeda

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    /**
     * Método abstrato para conversão da moeda para Real.
     * Deve ser implementado pelas subclasses.
     */
    public abstract double converter();

    /**
     * Sobrescrevendo o método equals para comparar moedas
     * com base no tipo e no valor.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Moeda outra = (Moeda) obj;
        return Double.compare(this.valor, outra.valor) == 0;
    }

    @Override
    public String toString() {
        return "Moeda: " + valor;
    }
}