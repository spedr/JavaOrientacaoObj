package servicoguincho.simulador;

public abstract class GuinchoImpl implements Guincho {
    protected double taxaPorKm;

    @Override
    public double calcularCustoDeslocamento(Trajeto trajeto) {
        return trajeto.getDistanciaEmKM() * taxaPorKm;
    }
}
