package servicoguincho.simulador;

public class TrajetoCidade implements Trajeto {
    private int distancia;

    public TrajetoCidade(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public Integer getDistanciaEmKM() {
        return this.distancia;
    }
}
