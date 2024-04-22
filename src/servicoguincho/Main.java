package servicoguincho;

import servicoguincho.simulador.SimuladorDeOrcamentoImpl;
import servicoguincho.simulador.TrajetoImpl;
import servicoguincho.simulador.VeiculoImpl;
import servicoguincho.simulador.Bairro;
import servicoguincho.simulador.cargas.EstadoConservacao;
import servicoguincho.simulador.cargas.TipoVeiculo;

public class Main {

    public static void main(String[] args) {
        SimuladorDeOrcamentoImpl simulador = new SimuladorDeOrcamentoImpl();
        
        // Cenário 1: Carro novo do Centro até Bairro A
        VeiculoImpl carroNovo = new VeiculoImpl(TipoVeiculo.CARRO, EstadoConservacao.NOVO);
        TrajetoImpl centroParaBairroA = new TrajetoImpl(Bairro.CENTRO, Bairro.BAIRRO_A);
        double custoCenario1 = simulador.calcularCustoTotal(carroNovo, centroParaBairroA);
        System.out.println("Cenário 1 - Custo Total do Serviço: R$" + custoCenario1);

        // Cenário 2: Ônibus quebrado do Bairro B até o Centro
        VeiculoImpl onibusQuebrado = new VeiculoImpl(TipoVeiculo.ONIBUS, EstadoConservacao.QUEBRADO);
        TrajetoImpl bairroBParaCentro = new TrajetoImpl(Bairro.BAIRRO_B, Bairro.CENTRO);
        double custoCenario2 = simulador.calcularCustoTotal(onibusQuebrado, bairroBParaCentro);
        System.out.println("Cenário 2 - Custo Total do Serviço: R$" + custoCenario2);

        // Cenário 3: Minivan nova do Centro até o Bairro B
        VeiculoImpl minivanNova = new VeiculoImpl(TipoVeiculo.MINIVAN, EstadoConservacao.NOVO);
        TrajetoImpl centroParaBairroB = new TrajetoImpl(Bairro.CENTRO, Bairro.BAIRRO_B);
        double custoCenario3 = simulador.calcularCustoTotal(minivanNova, centroParaBairroB);
        System.out.println("Cenário 3 - Custo Total do Serviço: R$" + custoCenario3);

        // Cenário 4: Caminhão quebrado do Bairro A até Bairro B
        VeiculoImpl caminhaoQuebrado = new VeiculoImpl(TipoVeiculo.CAMINHAO, EstadoConservacao.QUEBRADO);
        TrajetoImpl bairroAParaBairroB = new TrajetoImpl(Bairro.BAIRRO_A, Bairro.BAIRRO_B);
        double custoCenario4 = simulador.calcularCustoTotal(caminhaoQuebrado, bairroAParaBairroB);
        System.out.println("Cenário 4 - Custo Total do Serviço: R$" + custoCenario4);

        // Cenário 5: Carro novo trafegando pelo Centro
        TrajetoImpl centroParaCentro = new TrajetoImpl(Bairro.CENTRO, Bairro.CENTRO);
        double custoCenario5 = simulador.calcularCustoTotal(carroNovo, centroParaCentro);
        System.out.println("Cenário 5 - Custo Total do Serviço: R$" + custoCenario5);
    }
}
