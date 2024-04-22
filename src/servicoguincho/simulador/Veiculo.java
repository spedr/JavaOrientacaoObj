package servicoguincho.simulador;

import servicoguincho.simulador.cargas.EstadoConservacao;
import servicoguincho.simulador.cargas.TipoVeiculo;

public interface Veiculo {
    TipoVeiculo getTipo();
    EstadoConservacao getEstado();
}