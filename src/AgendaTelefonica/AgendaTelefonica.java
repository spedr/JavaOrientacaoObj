package AgendaTelefonica;

import java.util.ArrayList;
import java.util.List;

public class AgendaTelefonica {
    private List<Contato> contatos;

    public AgendaTelefonica() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        if (buscarContato(contato.getNome()) == null) {
            contatos.add(contato);
        }
    }

    public void removerContato(String nome) {
        Contato contato = buscarContato(nome);
        if (contato != null) {
            contatos.remove(contato);
        }
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void atualizarContato(String nome, Contato novoContato) {
        Contato contato = buscarContato(nome);
        if (contato != null) {
            contato.setNome(novoContato.getNome());
            contato.setNumeroTelefone(novoContato.getNumeroTelefone());
        }
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getNumeroTelefone());
        }
    }
}
