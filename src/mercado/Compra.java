package mercado;

import java.util.HashMap;
import java.util.Map;

public class Compra {
    private Map<Produto, Integer> itens = new HashMap<>();

    public void adicionarProduto(Produto produto, int quantidade) {
        itens.put(produto, quantidade);
    }

    public Map<Produto, Integer> getItens() {
        return itens;
    }
}
