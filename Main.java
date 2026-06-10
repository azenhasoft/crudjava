import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Crio uma lista para armazenar os usuários cadastrados
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Scanner para ler dados digitados pelo usuário
        Scanner scanner = new Scanner(System.in);

        int opcao;

        // O menu continuará aparecendo até o usuário escolher sair
        do {

            System.out.println("\n==========================");
            System.out.println(" CRUD DE USUÁRIOS EM JAVA ");
            System.out.println("==========================");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Atualizar usuário");
            System.out.println("4 - Excluir usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            // Limpa o ENTER deixado pelo nextInt()
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    // Cadastro de usuário

                    System.out.print("Informe o ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Informe o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Informe o email: ");
                    String email = scanner.nextLine();

                    // Crio um novo objeto Usuario e adiciono na lista
                    Usuario novoUsuario =
                            new Usuario(id, nome, email);

                    usuarios.add(novoUsuario);

                    System.out.println("Usuário cadastrado com sucesso!");

                    break;

                case 2:

                    // Verifico se existem usuários cadastrados

                    if (usuarios.isEmpty()) {

                        System.out.println("Nenhum usuário cadastrado.");

                    } else {

                        System.out.println("\nLista de usuários:");

                        // Percorro toda a lista exibindo cada usuário
                        for (Usuario usuario : usuarios) {

                            System.out.println(usuario);

                        }

                    }

                    break;

                case 3:

                    // Atualização de usuário

                    System.out.print("Digite o ID do usuário: ");
                    int idAtualizar = scanner.nextInt();

                    scanner.nextLine();

                    boolean encontrouUsuario = false;

                    // Procuro o usuário pelo ID
                    for (Usuario usuario : usuarios) {

                        if (usuario.getId() == idAtualizar) {

                            System.out.print("Novo nome: ");
                            String novoNome =
                                    scanner.nextLine();

                            System.out.print("Novo email: ");
                            String novoEmail =
                                    scanner.nextLine();

                            // Atualizo os dados do usuário
                            usuario.setNome(novoNome);
                            usuario.setEmail(novoEmail);

                            System.out.println("Usuário atualizado com sucesso!");

                            encontrouUsuario = true;

                            break;
                        }
                    }

                    if (!encontrouUsuario) {
                        System.out.println("Usuário não encontrado.");
                    }

                    break;

                case 4:

                    // Exclusão de usuário

                    System.out.print("Digite o ID do usuário: ");
                    int idExcluir = scanner.nextInt();

                    boolean removido = usuarios.removeIf(
                            usuario -> usuario.getId() == idExcluir
                    );

                    if (removido) {
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }

                    break;

                case 0:

                    System.out.println("Programa encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");

            }

        } while (opcao != 0);

        // Fecho o Scanner ao final do programa
        scanner.close();
    }
}
