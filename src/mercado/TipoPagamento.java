package mercado;

public enum TipoPagamento {
    DEBITO(1.0),
    DINHEIRO(0.95),
    CREDITO(1.03);

    private final double fatorAjuste;

    TipoPagamento(double fatorAjuste) {
        this.fatorAjuste = fatorAjuste;
    }

    public double getFatorAjuste() {
        return fatorAjuste;
    }
}
