package mercado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CaixaDoAtacado {
    private static Map<Integer, Produto> catalogo = new HashMap<>();
    static {
        catalogo.put(1, new Produto(1, "Café 1kg", 53.00));
        catalogo.put(2, new Produto(2, "Sabão em pó", 36.00));
        catalogo.put(3, new Produto(3, "Caixa de Leite", 82.00));
        catalogo.put(4, new Produto(4, "Refrigerante", 8.50));
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java CaixaDoAtacado <caminho_arquivo_compra>");
            return;
        }

        String arquivoCompra = args[0];
        Compra compra = new Compra();
        TipoPagamento tipoPagamento;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCompra))) {
            tipoPagamento = TipoPagamento.valueOf(br.readLine().toUpperCase());

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int idProduto = Integer.parseInt(dados[0]);
                int quantidade = Integer.parseInt(dados[1]);
                Produto produto = catalogo.get(idProduto);
                compra.adicionarProduto(produto, quantidade);
            }

            System.out.println("Itens comprados:");
            for (Map.Entry<Produto, Integer> entry : compra.getItens().entrySet()) {
                Produto produto = entry.getKey();
                int quantidade = entry.getValue();
                double precoDescontado = produto.getPreco() * calcularDesconto(quantidade);
                double desconto = (1.0 - calcularDesconto(quantidade)) * 100;
                System.out.printf("%d x %s a R$%.2f cada: R$%.2f (desconto aplicado: %.0f%%)\n",
                        quantidade, produto.getNome(), precoDescontado, precoDescontado * quantidade, desconto);
            }

            double total = computarCompra(compra, tipoPagamento);
            System.out.printf("Método de pagamento: %s\n", tipoPagamento);
            System.out.printf("Total a pagar: R$ %.2f%n", total);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Método de pagamento inválido ou erro nos dados do produto.");
        }
    }

    private static double calcularDesconto(int quantidade) {
        if (quantidade <= 5) return 1.0;
        else if (quantidade <= 15) return 0.90;
        else if (quantidade <= 25) return 0.80;
        else return 0.75;
    }

    public static double computarCompra(Compra compra, TipoPagamento tipoPagamento) {
        double total = 0;

        for (Map.Entry<Produto, Integer> item : compra.getItens().entrySet()) {
            double precoBase = item.getKey().getPreco();
            int quantidade = item.getValue();
            double desconto = calcularDesconto(quantidade);

            total += precoBase * quantidade * desconto;
        }

        return total * tipoPagamento.getFatorAjuste();
    }
}
