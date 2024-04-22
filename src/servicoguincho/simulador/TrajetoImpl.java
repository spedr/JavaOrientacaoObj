package servicoguincho.simulador;

public class TrajetoImpl implements Trajeto {
    private Integer distanciaEmKM;

    public TrajetoImpl(Bairro origem, Bairro destino) {
        this.distanciaEmKM = calcularDistancia(origem, destino);
    }

    private Integer calcularDistancia(Bairro origem, Bairro destino) {
        if (origem == destino) {
            return 5; // Distância dentro do mesmo bairro (assumindo o centro)
        }
        switch (origem) {
            case CENTRO:
                return (destino == Bairro.BAIRRO_A) ? 10 : 15;
            case BAIRRO_A:
                return (destino == Bairro.CENTRO) ? 10 : 8;
            case BAIRRO_B:
                return (destino == Bairro.CENTRO) ? 15 : 8;
            default:
                return 0;
        }
    }

    @Override
    public Integer getDistanciaEmKM() {
        return distanciaEmKM;
    }
}