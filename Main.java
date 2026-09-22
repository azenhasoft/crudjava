import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                mostrarMenu();
                opcao = lerInteiro(scanner, "Escolha uma opção: ");

                switch (opcao) {
                    case 1:
                        cadastrar(scanner, usuarios);
                        break;
                    case 2:
                        listar(usuarios);
                        break;
                    case 3:
                        atualizar(scanner, usuarios);
                        break;
                    case 4:
                        excluir(scanner, usuarios);
                        break;
                    case 0:
                        System.out.println("Programa encerrado.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 0);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n==========================");
        System.out.println(" CRUD DE USUÁRIOS EM JAVA ");
        System.out.println("==========================");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Listar usuários");
        System.out.println("3 - Atualizar usuário");
        System.out.println("4 - Excluir usuário");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static String lerTexto(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Este campo não pode ficar vazio.");
        }
    }

    private static Usuario buscarPorId(List<Usuario> usuarios, int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    private static void cadastrar(Scanner scanner, List<Usuario> usuarios) {
        int id = lerInteiro(scanner, "Informe o ID: ");
        if (buscarPorId(usuarios, id) != null) {
            System.out.println("Já existe um usuário com esse ID.");
            return;
        }

        String nome = lerTexto(scanner, "Informe o nome: ");
        String email = lerTexto(scanner, "Informe o email: ");
        usuarios.add(new Usuario(id, nome, email));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listar(List<Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\nLista de usuários:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void atualizar(Scanner scanner, List<Usuario> usuarios) {
        int id = lerInteiro(scanner, "Digite o ID do usuário: ");
        Usuario usuario = buscarPorId(usuarios, id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        usuario.setNome(lerTexto(scanner, "Novo nome: "));
        usuario.setEmail(lerTexto(scanner, "Novo email: "));
        System.out.println("Usuário atualizado com sucesso!");
    }

    private static void excluir(Scanner scanner, List<Usuario> usuarios) {
        int id = lerInteiro(scanner, "Digite o ID do usuário: ");
        Usuario usuario = buscarPorId(usuarios, id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        usuarios.remove(usuario);
        System.out.println("Usuário removido com sucesso!");
    }
}
