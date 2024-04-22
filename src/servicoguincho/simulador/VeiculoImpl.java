package servicoguincho.simulador;

import servicoguincho.simulador.cargas.EstadoConservacao;
import servicoguincho.simulador.cargas.TipoVeiculo;

public class VeiculoImpl implements Veiculo {
    private TipoVeiculo tipo;
    private EstadoConservacao estado;

    public VeiculoImpl(TipoVeiculo tipo, EstadoConservacao estado) {
        this.tipo = tipo;
        this.estado = estado;
    }

    @Override
    public TipoVeiculo getTipo() {
        return tipo;
    }

    @Override
    public EstadoConservacao getEstado() {
        return estado;
    }
}