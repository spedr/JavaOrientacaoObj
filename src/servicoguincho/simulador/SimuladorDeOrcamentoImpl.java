package servicoguincho.simulador;

public class SimuladorDeOrcamentoImpl implements SimuladorDeOrcamento {
    @Override
    public double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto) {
        Guincho guincho = escolherGuincho(veiculo);
        return guincho.calcularCustoDeslocamento(trajeto);
    }

    private Guincho escolherGuincho(Veiculo veiculo) {
        switch (veiculo.getTipo()) {
            case CARRO:
            case MINIVAN:
                return new GuinchoPlataforma();
            case ONIBUS:
            case CAMINHAO:
                return new GuinchoReboque();
            default:
                throw new IllegalArgumentException("Tipo de veículo não suportado.");
        }
    }
}