package AgendaTelefonica;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaTelefonica agenda = new AgendaTelefonica();

    public static void main(String[] args) {
        String opcao = "";
        while (!opcao.equals("6")) {
            printMenu();
            opcao = scanner.nextLine().trim();
            switch (opcao) {
                case "1":
                    addContact();
                    break;
                case "2":
                    removeContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    updateContact();
                    break;
                case "5":
                    listContacts();
                    break;
                case "6":
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Remover Contato");
        System.out.println("3. Buscar Contato");
        System.out.println("4. Atualizar Contato");
        System.out.println("5. Listar Contatos");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void addContact() {
        String nome = getNameFromUser("Digite o nome do contato: ");
        String numero = getPhoneFromUser("Digite o número de telefone: ");
        agenda.adicionarContato(new Contato(nome, numero));
        System.out.println("Contato adicionado com sucesso!");
    }

    private static void removeContact() {
        String nome = getNameFromUser("Digite o nome do contato para remover: ");
        agenda.removerContato(nome);
        System.out.println("Contato removido com sucesso!");
    }

    private static void searchContact() {
        String nome = getNameFromUser("Digite o nome do contato para buscar: ");
        Contato encontrado = agenda.buscarContato(nome);
        if (encontrado != null) {
            System.out.println("Nome: " + encontrado.getNome() + ", Telefone: " + encontrado.getNumeroTelefone());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void updateContact() {
        String nome = getNameFromUser("Digite o nome do contato para atualizar: ");
        String novoNome = getNameFromUser("Digite o novo nome: ");
        String novoNumero = getPhoneFromUser("Digite o novo número de telefone: ");
        agenda.atualizarContato(nome, new Contato(novoNome, novoNumero));
        System.out.println("Contato atualizado com sucesso!");
    }

    private static void listContacts() {
        System.out.println("Listando todos os contatos:");
        agenda.listarContatos();
    }

    private static String getPhoneFromUser(String message) {
        System.out.print(message);
        String phone = scanner.nextLine().trim();
        while (!phone.matches("^(\\+\\d{2})?\\(\\d{2}\\)\\d{4,5}-\\d{4}$")) {
            System.out.print("Número inválido. Formato esperado: (99)9999-9999 ou (99)99999-9999. Tente novamente: ");
            phone = scanner.nextLine().trim();
        }
        return phone;
    }

    private static String getNameFromUser(String message) {
        System.out.print(message);
        String nome = scanner.nextLine().trim();
        nome = nome.toUpperCase();
        while (!nome.matches("^[A-ZÀ-Ü ]{1,50}$")) {
            System.out.print("Nome inválido. O nome deve conter apenas letras e espaços, até 50 caracteres. Tente novamente: ");
            nome = scanner.nextLine().trim().toUpperCase();
        }
        return nome;
    }
}
